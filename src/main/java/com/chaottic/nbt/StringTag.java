package com.chaottic.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@SuppressWarnings("ClassCanBeRecord")
public final class StringTag implements Tag {

    public static final TagType<StringTag> TAG_TYPE = new TagType<StringTag>() {

        @Override
        public StringTag load(DataInput input) throws IOException {
            return new StringTag(input.readUTF());
        }
    };

    final String string;

    StringTag(String string) {
        this.string = string;
    }

    @Override
    public void save(DataOutput output) throws IOException {
        output.writeUTF(string);
    }

    @Override
    public byte getKey() {
        return TagRegistry.STRING;
    }
}
