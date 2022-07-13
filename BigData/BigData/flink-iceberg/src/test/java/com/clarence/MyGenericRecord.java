package com.clarence;

import org.apache.avro.AvroRuntimeException;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class MyGenericRecord implements GenericRecord, Comparable<GenericData.Record>, Serializable {
    private transient Schema schema;
    private final String schemaStr;
    private final Object[] values;

    public MyGenericRecord(String schemaStr) {
        this.schemaStr = schemaStr;
        this.schema = new Schema.Parser().parse(schemaStr);
        this.values = new Object[schema.getFields().size()];
    }

    @Override
    public int compareTo(@NotNull GenericData.Record that) {
        return GenericData.get().compare(this, that, schema);
    }

    @Override
    public void put(String key, Object value) {
        this.checkSchema();
        Schema.Field field = schema.getField(key);
        if (field == null) {
            throw new AvroRuntimeException("Not a valid schema field: " + key);
        }

        values[field.pos()] = value;
    }

    @Override
    public Object get(String key) {
        this.checkSchema();
        Schema.Field field = schema.getField(key);
        if (field == null) {
            throw new AvroRuntimeException("Not a valid schema field: " + key);
        }
        return values[field.pos()];
    }

    @Override
    public void put(int i, Object v) {
        values[i] = v;
    }

    @Override
    public Object get(int i) {
        this.checkSchema();
        return values[i];
    }

    private void checkSchema() {
        if (this.schema == null) {
            this.schema = new Schema.Parser().parse(schemaStr);
        }
    }

    @Override
    public Schema getSchema() {
        this.checkSchema();
        return this.schema;
    }
}
