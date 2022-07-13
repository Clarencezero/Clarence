package com.clarence;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.flink.api.common.ExecutionConfig;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.common.typeutils.TypeSerializer;
import org.apache.flink.formats.avro.typeutils.AvroSerializer;
import org.apache.flink.formats.avro.typeutils.GenericRecordAvroTypeInfo;
import org.apache.flink.util.Preconditions;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

public class MyGenericRecordAvroTypeInfo extends TypeInformation<MyGenericRecord> {
    private static final long serialVersionUID = 4142397758643820650L;
    private transient Schema schema;

    public MyGenericRecordAvroTypeInfo(Schema schema) {
        this.schema = (Schema) Preconditions.checkNotNull(schema);
    }
    @Override
    public boolean isBasicType() {
        return false;
    }

    @Override
    public boolean isTupleType() {
        return false;
    }

    @Override
    public int getArity() {
        return 1;
    }

    @Override
    public int getTotalFields() {
        return 1;
    }

    @Override
    public Class<MyGenericRecord> getTypeClass() {
        return MyGenericRecord.class;
    }

    @Override
    public boolean isKeyType() {
        return false;
    }

    @Override
    public TypeSerializer<MyGenericRecord> createSerializer(ExecutionConfig executionConfig) {
        return new AvroSerializer(MyGenericRecord.class, this.schema);    }

    @Override
    public String toString() {
        return String.format("MyGEnericRecord(\"%s\")", this.schema.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof MyGenericRecordAvroTypeInfo) {
            MyGenericRecordAvroTypeInfo avroTypeInfo = (MyGenericRecordAvroTypeInfo)o;
            return Objects.equals(avroTypeInfo.schema, this.schema);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.schema);
    }

    @Override
    public boolean canEqual(Object obj) {
        return obj instanceof MyGenericRecordAvroTypeInfo;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeUTF(this.schema.toString());
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        this.schema = (new Schema.Parser()).parse(ois.readUTF());
    }
}
