package com.chaottic.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@SuppressWarnings("ClassCanBeRecord")
public final class ByteArrayTag implements Tag {

    public static final TagType<ByteArrayTag> TAG_TYPE = new TagType<ByteArrayTag>() {

        @Override
        public ByteArrayTag load(DataInput input) throws IOException {
            int length = input.readInt();

            byte[] bytes = new byte[length];

            input.readFully(bytes);

            return new ByteArrayTag(bytes);
        }
    };

    final byte[] bytes;

    ByteArrayTag(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public void save(DataOutput output) throws IOException {
        output.writeInt(bytes.length);
        output.write(bytes);
    }

    @Override
    public byte getKey() {
        return TagRegistry.BYTE_ARRAY;
    }
}
