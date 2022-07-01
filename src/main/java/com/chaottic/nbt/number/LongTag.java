package com.chaottic.nbt.number;

import com.chaottic.nbt.TagRegistry;
import com.chaottic.nbt.TagType;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@SuppressWarnings("ClassCanBeRecord")
public final class LongTag implements NumberTag {

    public static final TagType<LongTag> TAG_TYPE = new TagType<LongTag>() {

        @Override
        public LongTag load(DataInput input) throws IOException {
            return new LongTag(input.readLong());
        }
    };

    private final long l;

    public LongTag(long l) {
        this.l = l;
    }

    @Override
    public Number getAsNumber() {
        return l;
    }

    @Override
    public void save(DataOutput output) throws IOException {
        output.writeLong(l);
    }

    @Override
    public byte getKey() {
        return TagRegistry.LONG;
    }
}
