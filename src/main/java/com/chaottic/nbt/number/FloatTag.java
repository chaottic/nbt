package com.chaottic.nbt.number;

import com.chaottic.nbt.TagRegistry;
import com.chaottic.nbt.TagType;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@SuppressWarnings("ClassCanBeRecord")
public final class FloatTag implements NumberTag {

    public static final TagType<FloatTag> TAG_TYPE = new TagType<FloatTag>() {

        @Override
        public FloatTag load(DataInput input) throws IOException {
            return new FloatTag(input.readFloat());
        }
    };

    private final float f;

    public FloatTag(float f) {
        this.f = f;
    }

    @Override
    public Number getAsNumber() {
        return f;
    }

    @Override
    public void save(DataOutput output) throws IOException {
        output.writeFloat(f);
    }

    @Override
    public byte getKey() {
        return TagRegistry.FLOAT;
    }
}
