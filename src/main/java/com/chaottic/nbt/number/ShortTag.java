package com.chaottic.nbt.number;

import com.chaottic.nbt.TagRegistry;
import com.chaottic.nbt.TagType;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@SuppressWarnings("ClassCanBeRecord")
public final class ShortTag implements NumberTag {

    public static final TagType<ShortTag> TAG_TYPE = new TagType<ShortTag>() {

        @Override
        public ShortTag load(DataInput input) throws IOException {
            return new ShortTag(input.readShort());
        }
    };

    private final short s;

    public ShortTag(short s) {
        this.s = s;
    }

    @Override
    public Number getAsNumber() {
        return s;
    }

    @Override
    public void save(DataOutput output) throws IOException {
        output.writeShort(s);
    }

    @Override
    public byte getKey() {
        return TagRegistry.SHORT;
    }
}
