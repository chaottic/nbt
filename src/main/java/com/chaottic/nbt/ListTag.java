package com.chaottic.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public final class ListTag extends AbstractList<Tag> implements Tag {

    public static final TagType<ListTag> TAG_TYPE = new TagType<ListTag>() {

        @Override
        public ListTag load(DataInput input) throws IOException {
            int size = input.readInt();

            List<Tag> list = new ArrayList<>(size);

            TagType<?> type = TagRegistry.TAG_TYPES[input.readByte()];

            for (int i = 0; i < size; i++) {
                list.add(type.load(input));
            }

            return new ListTag(list);
        }
    };

    private final List<Tag> list;

    public ListTag() {
        this(new ArrayList<>());
    }

    private ListTag(List<Tag> list) {
        this.list = list;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Tag get(int index) {
        return list.get(index);
    }

    @Override
    public void save(DataOutput output) throws IOException {

        output.writeByte(list.isEmpty() ? TagRegistry.EMPTY : list.get(0).getKey());
        output.writeInt(list.size());

        for (Tag tag : list) {
            tag.save(output);
        }
    }

    @Override
    public byte getKey() {
        return TagRegistry.LIST;
    }
}
