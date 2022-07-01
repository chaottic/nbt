package com.chaottic.nbt.number;

import com.chaottic.nbt.TagRegistry;
import com.chaottic.nbt.TagType;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@SuppressWarnings("ClassCanBeRecord")
public final class ByteTag implements NumberTag {

    public static final TagType<ByteTag> TAG_TYPE = new TagType<ByteTag>() {

        @Override
        public ByteTag load(DataInput input) throws IOException {
            return new ByteTag(input.readByte());
        }
    };

    private final byte b;

    public ByteTag(byte b) {
        this.b = b;
    }

    @Override
    public Number getAsNumber() {
        return b;
    }

    @Override
    public void save(DataOutput output) throws IOException {
        output.writeByte(b);
    }

    @Override
    public byte getKey() {
        return TagRegistry.BYTE;
    }
}
