package com.chaottic.nbt.number;

import com.chaottic.nbt.TagRegistry;
import com.chaottic.nbt.TagType;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@SuppressWarnings("ClassCanBeRecord")
public final class IntTag implements NumberTag {

    public static final TagType<IntTag> TAG_TYPE = new TagType<IntTag>() {

        @Override
        public IntTag load(DataInput input) throws IOException {
            return new IntTag(input.readInt());
        }
    };

    private final int i;

    public IntTag(int i) {
        this.i = i;
    }

    @Override
    public Number getAsNumber() {
        return i;
    }

    @Override
    public void save(DataOutput output) throws IOException {
        output.writeInt(i);
    }

    @Override
    public byte getKey() {
        return TagRegistry.INT;
    }
}
