package com.clarence;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.commons.io.FileUtils;
import org.apache.flink.api.common.serialization.BulkWriter;
import org.apache.flink.api.common.serialization.SimpleStringEncoder;
import org.apache.flink.connector.file.sink.FileSink;
import org.apache.flink.core.fs.FSDataOutputStream;
import org.apache.flink.core.fs.Path;
import org.apache.flink.formats.avro.AvroBuilder;
import org.apache.flink.formats.avro.AvroWriterFactory;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.filesystem.OutputFileConfig;
import org.apache.flink.streaming.api.functions.sink.filesystem.rollingpolicies.DefaultRollingPolicy;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class FileConnectorTest {
    @Test
    void testUseMyGenericRecord() throws Exception {
        String schemaStr = "{\"namespace\": \"com.clarence.Person\",\n" +
                " \"type\": \"record\",\n" +
                " \"name\": \"Person\",\n" +
                " \"fields\": [\n" +
                "     {\"name\": \"name\", \"type\": \"string\"},\n" +
                "     {\"name\": \"age\",  \"type\": [\"int\", \"null\"]}\n" +
                " ]\n" +
                "}";
        Schema schema = new Schema.Parser().parse(schemaStr);

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<MyGenericRecord> personSourceStream = env.addSource(new SourceFunction<MyGenericRecord>() {
            @Override
            public void run(SourceContext<MyGenericRecord> ctx) throws Exception {
                while (true) {
                    MyGenericRecord user1 = new MyGenericRecord(schemaStr);
                    user1.put("name", "Alyssa");
                    user1.put("age", 256);
                    ctx.collect(user1);
                    TimeUnit.SECONDS.sleep(1);
                }
            }

            @Override
            public void cancel() {

            }
        });
        env.enableCheckpointing(100);
        AvroWriterFactory<MyGenericRecord> factory = new AvroWriterFactory<>((AvroBuilder<MyGenericRecord>) out -> {
            DatumWriter<MyGenericRecord> datumWriter = new ReflectDatumWriter<>(schema);
            DataFileWriter<MyGenericRecord> dataFileWriter = new DataFileWriter<>(datumWriter);
            dataFileWriter.create(schema, out);
            return dataFileWriter;
        });
        FileSink<MyGenericRecord> fileSink = FileSink.forBulkFormat(getLocalPath("G:\\01_Data\\FlinkTest"), factory).build();
        personSourceStream.sinkTo(fileSink).setParallelism(1);
        env.execute();
    }

    @Test
    void testAvro() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Person> personSourceStream = env.addSource(new SourceFunction<Person>() {
            @Override
            public void run(SourceContext<Person> ctx) throws Exception {
                while (true) {
                    Person person = new Person("test", 1);
                    ctx.collect(person);
                    TimeUnit.SECONDS.sleep(1);
                }
            }

            @Override
            public void cancel() {

            }
        });
        env.enableCheckpointing(100);
        AvroWriterFactory<Person> factory = new AvroWriterFactory<>((AvroBuilder<Person>) out -> {
            Schema schema = ReflectData.get().getSchema(Person.class);
            DatumWriter<Person> datumWriter = new ReflectDatumWriter<>(schema);
            DataFileWriter<Person> dataFileWriter = new DataFileWriter<>(datumWriter);
            dataFileWriter.create(schema, out);
            return dataFileWriter;
        });
        FileSink<Person> fileSink = FileSink.forBulkFormat(getLocalPath("G:\\01_Data\\FlinkTest"), factory).build();
        personSourceStream.sinkTo(fileSink);
        env.execute();
    }

    @Test
    void testMyAvroGenericRecord() throws Exception{
        String schemaStr = "{\"namespace\": \"com.clarence.Person\",\n" +
                " \"type\": \"record\",\n" +
                " \"name\": \"Person\",\n" +
                " \"fields\": [\n" +
                "     {\"name\": \"name\", \"type\": \"string\"},\n" +
                "     {\"name\": \"age\",  \"type\": [\"int\", \"null\"]}\n" +
                " ]\n" +
                "}";
        Schema schema = new Schema.Parser().parse(schemaStr);

        // 使用schema创建用户对象.
        MyGenericRecord user1 = new MyGenericRecord(schemaStr);
        user1.put("name", "Alyssa");
        user1.put("age", 256);

        MyGenericRecord user2 = new MyGenericRecord(schemaStr);
        user2.put("name", "Ben");
        user2.put("age", 7);

        String targetFile = "G:\\01_Data\\avroTest.avro";
        // 序列化并写出到磁盘
        File file = new File(targetFile);
        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>(schema);
        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<>(datumWriter);
        dataFileWriter.create(schema, file);
        dataFileWriter.append(user1);
        dataFileWriter.append(user2);
        dataFileWriter.close();

        // 从磁盘反序列化，打印在控制台
        DatumReader<GenericRecord> datumReader = new GenericDatumReader<>(schema);
        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<>(file, datumReader);
        GenericRecord user = null;
        while (dataFileReader.hasNext()) {
            user = dataFileReader.next(user);
            System.out.println(user);
        }
    }

    @Test
    void testDeWithSchema() throws Exception {
        String schemaStr = "{\"namespace\": \"com.clarence.Person\",\n" +
                " \"type\": \"record\",\n" +
                " \"name\": \"Person\",\n" +
                " \"fields\": [\n" +
                "     {\"name\": \"name\", \"type\": \"string\"},\n" +
                "     {\"name\": \"age\",  \"type\": [\"int\", \"null\"]}\n" +
                " ]\n" +
                "}";
        File file = new File("G:\\01_Data\\FlinkTest\\2022-07-13--23\\part-44c5d165-c6d5-42bf-aea7-4102a7e793b8-0");
        Schema schema = new Schema.Parser().parse(schemaStr);
        DatumReader<GenericRecord> datumReader = new GenericDatumReader<>(schema);
        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<>(file, datumReader);
        GenericRecord user = null;
        while (dataFileReader.hasNext()) {
            user = dataFileReader.next(user);
            System.out.println(user);
        }

    }

    @Test
    void testAvroGenericDataRecord() throws Exception {
        String schemaStr = "{\"namespace\": \"com.clarence.Person\",\n" +
                " \"type\": \"record\",\n" +
                " \"name\": \"Person\",\n" +
                " \"fields\": [\n" +
                "     {\"name\": \"name\", \"type\": \"string\"},\n" +
                "     {\"name\": \"age\",  \"type\": [\"int\", \"null\"]}\n" +
                " ]\n" +
                "}";
        Schema schema = new Schema.Parser().parse(schemaStr);

        // 使用schema创建用户对象.
        GenericRecord user1 = new GenericData.Record(schema);
        user1.put("name", "Alyssa");
        user1.put("age", 256);

        GenericRecord user2 = new GenericData.Record(schema);
        user2.put("name", "Ben");
        user2.put("age", 7);

        String targetFile = "G:\\01_Data\\avroTest.avro";
        // 序列化并写出到磁盘
        File file = new File(targetFile);
        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>(schema);
        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<>(datumWriter);
        dataFileWriter.create(schema, file);
        dataFileWriter.append(user1);
        dataFileWriter.append(user2);
        dataFileWriter.close();

        // 从磁盘反序列化，打印在控制台
        DatumReader<GenericRecord> datumReader = new GenericDatumReader<>(schema);
        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<>(file, datumReader);
        GenericRecord user = null;
        while (dataFileReader.hasNext()) {
            user = dataFileReader.next(user);
            System.out.println(user);
        }
    }

    @Test
    void getAvroData() throws Exception {
        String filePath = "G:\\01_Data\\FlinkTest\\2022-07-13--22\\test.avro";

        File file = new File(filePath);
        DatumReader<Person> datumReader = new SpecificDatumReader<>(Person.class);
        DataFileReader<Person> dataFileReader = new DataFileReader<>(file, datumReader);
        for (Person person : dataFileReader) { // 通过迭代的方式一条条读取出来
            System.out.println(person);
        }
    }

    private Path getLocalPath(String filePath) {
        return new Path(filePath);
    }

    @Test
    void testFileSystem() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> sourceStream = env.addSource(new SourceFunction<String>() {
            @Override
            public void run(SourceContext<String> collector) throws Exception {
                while (true) {
                    collector.collect("hello");
                    TimeUnit.SECONDS.sleep(1);
                }
            }

            @Override
            public void cancel() {

            }
        });
        // sourceStream.print();
        final FileSink<String> sink = FileSink
                .forRowFormat(new Path("G:\\01_Data\\FlinkTest"), new SimpleStringEncoder<String>("UTF-8"))
                .withRollingPolicy(
                        DefaultRollingPolicy.builder()
                                .withRolloverInterval(TimeUnit.SECONDS.toMillis(1))
                                .withInactivityInterval(TimeUnit.SECONDS.toMillis(1))
                                .withMaxPartSize(1024 * 1024 * 1024)
                                .build())
                .withOutputFileConfig(new OutputFileConfig("test", ".txt"))
                .build();

        FileSink.DefaultBulkFormatBuilder<String> stringDefaultBulkFormatBuilder = FileSink.forBulkFormat(new Path("G:\\01_Data\\FlinkTest"), new BulkWriter.Factory<String>() {
            @Override
            public BulkWriter<String> create(FSDataOutputStream out) throws IOException {
                BulkWriter<String> o = null;
                return o;
            }
        });


        sourceStream.sinkTo(sink);
        env.execute();

    }
}
