package com.chaottic.nbt.number;

import com.chaottic.nbt.TagRegistry;
import com.chaottic.nbt.TagType;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@SuppressWarnings("ClassCanBeRecord")
public final class DoubleTag implements NumberTag {

    public static final TagType<DoubleTag> TAG_TYPE = new TagType<DoubleTag>() {

        @Override
        public DoubleTag load(DataInput input) throws IOException {
            return new DoubleTag(input.readDouble());
        }
    };

    private final double d;

    public DoubleTag(double d) {
        this.d = d;
    }

    @Override
    public Number getAsNumber() {
        return d;
    }

    @Override
    public void save(DataOutput output) throws IOException {
        output.writeDouble(d);
    }

    @Override
    public byte getKey() {
        return TagRegistry.DOUBLE;
    }
}
