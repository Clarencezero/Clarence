package com.clarence.demo01;

import com.clarence.Person;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.CheckpointingMode;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.table.data.GenericRowData;
import org.apache.flink.table.data.RowData;
import org.apache.flink.table.data.StringData;
import org.apache.hadoop.conf.Configuration;
import org.apache.iceberg.*;
import org.apache.iceberg.catalog.Catalog;
import org.apache.iceberg.catalog.TableIdentifier;
import org.apache.iceberg.flink.TableLoader;
import org.apache.iceberg.flink.sink.FlinkSink;
import org.apache.iceberg.hadoop.HadoopCatalog;
import org.apache.iceberg.relocated.com.google.common.collect.ImmutableMap;
import org.apache.iceberg.types.Types;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CreateIcebergTable {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000, CheckpointingMode.AT_LEAST_ONCE);
        System.setProperty("HADOOP_USER_NAME", "root");

        DataStreamSource<String> source = env.addSource(new SourceFunction<String>() {
            int count = 0;
            final String[] address = {"北京", "杭州", "广州", "深圳"};
            final String[] name = {"Tom", "Tim", "Clarence", "Gerry"};

            @Override
            public void run(SourceContext<String> sourceContext) throws Exception {
                String data = "%s,%s,%s,%s";
                Random random = new Random();
                while (true) {
                    int index = random.nextInt(4);
                    sourceContext.collect(String.format(data, count++, name[index], index, address[index]));
                    TimeUnit.SECONDS.sleep(1);
                }
            }

            @Override
            public void cancel() {
            }
        });

        SingleOutputStreamOperator<RowData> map = source.map((MapFunction<String, RowData>) s -> {
            String[] split = s.split(",");
            GenericRowData row = new GenericRowData(4);
            row.setField(0, Integer.parseInt(split[0]));
            row.setField(1, StringData.fromString(split[1]));
            row.setField(2, Integer.parseInt(split[2]));
            row.setField(3, StringData.fromString(split[3]));
            return row;
        });

        // 创建 Iceberg 表
        Configuration hadoopConfig = new Configuration();
        Catalog catalog = new HadoopCatalog(hadoopConfig, "hdfs://hadoop101/flink_iceberg");
        TableIdentifier name = TableIdentifier.of("icebergdb", "flink_iceberg_tb1");
        // 创建 Iceberg 表 Schema
        Schema schema = new Schema(
                Types.NestedField.required(1, "id", Types.IntegerType.get()),
                Types.NestedField.required(2, "name", Types.StringType.get()),
                Types.NestedField.required(3, "age", Types.IntegerType.get()),
                Types.NestedField.required(4, "address", Types.StringType.get())
        );

        // 指定对应的分区
        PartitionSpec partitionSpec = PartitionSpec.builderFor(schema).identity("address").build();

        // 指定 Iceberg 表数据格式化为 Parquet 存储
        ImmutableMap<String, String> props = ImmutableMap.of(TableProperties.DEFAULT_FILE_FORMAT, FileFormat.PARQUET.name());

        Table table;
        // 通过 Schema 先判断表是否存在
        if (!catalog.tableExists(name)) {
            table = catalog.createTable(name, schema, partitionSpec, props);
        } else {
            table = catalog.loadTable(name);
        }

        TableLoader tableLoader = TableLoader.fromHadoopTable("hdfs://hadoop101/flink_iceberg/icebergdb/flink_iceberg_tb1");

        // 将流式结果写入 Iceberg 表
        FlinkSink.forRowData(map)
                .table(table)
                .tableLoader(tableLoader)
                .overwrite(true)
                .build();

        env.execute();
    }
}
