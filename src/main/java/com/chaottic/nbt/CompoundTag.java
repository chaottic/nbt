package com.chaottic.nbt;

import com.chaottic.nbt.number.*;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class CompoundTag implements Tag {

    public static final TagType<CompoundTag> TAG_TYPE = new TagType<CompoundTag>() {

        @Override
        public CompoundTag load(DataInput input) throws IOException {
            Map<String, Tag> map = new HashMap<>();

            byte b;
            while ((b = input.readByte()) != TagRegistry.EMPTY) {
                map.put(input.readUTF(), TagRegistry.TAG_TYPES[b].load(input));
            }

            return new CompoundTag(map);
        }
    };

    private final Map<String, Tag> map;

    public CompoundTag() {
        this(new HashMap<>());
    }

    private CompoundTag(Map<String, Tag> map) {
        this.map = map;
    }

    public void putByte(String name, byte b) {
        map.put(name, new ByteTag(b));
    }

    public void putShort(String name, short s) {
        map.put(name, new ShortTag(s));
    }

    public void putInt(String name, int i) {
        map.put(name, new IntTag(i));
    }

    public void putLong(String name, long l) {
        map.put(name, new LongTag(l));
    }

    public void putFloat(String name, float f) {
        map.put(name, new FloatTag(f));
    }

    public void putDouble(String name, double d) {
        map.put(name, new DoubleTag(d));
    }

    public void putByteArray(String name, byte[] bytes) {
        map.put(name, new ByteArrayTag(bytes));
    }

    public void putString(String name, String string) {
        map.put(name, new StringTag(string));
    }

    public void put(String name, Tag tag) {
        map.put(name, tag);
    }

    public byte getByte(String name) {
        return map.get(name) instanceof NumberTag numberTag ? numberTag.getAsNumber().byteValue() : 0;
    }

    public short getShort(String name) {
        return map.get(name) instanceof NumberTag numberTag ? numberTag.getAsNumber().shortValue() : 0;
    }

    public int getInt(String name) {
        return map.get(name) instanceof NumberTag numberTag ? numberTag.getAsNumber().intValue() : 0;
    }

    public long getLong(String name) {
        return map.get(name) instanceof NumberTag numberTag ? numberTag.getAsNumber().longValue() : 0L;
    }

    public float getFloat(String name) {
        return map.get(name) instanceof NumberTag numberTag ? numberTag.getAsNumber().floatValue() : 0.0F;
    }

    public double getDouble(String name) {
        return map.get(name) instanceof NumberTag numberTag ? numberTag.getAsNumber().doubleValue() : 0.0D;
    }

    public byte[] getByteArray(String name) {
        return map.get(name) instanceof ByteArrayTag byteArrayTag ? byteArrayTag.bytes : new byte[0];
    }

    public String getString(String name) {
        return map.get(name) instanceof StringTag stringTag ? stringTag.string : "";
    }

    public ListTag getListTag(String name, byte key) {
        return map.get(name) instanceof ListTag listTag && listTag.get(0).getKey() == key ? listTag : new ListTag();
    }

    public CompoundTag getCompoundTag(String name) {
        return map.get(name) instanceof CompoundTag compoundTag ? compoundTag : new CompoundTag();
    }

    @Override
    public void save(DataOutput output) throws IOException {
        for (Map.Entry<String, Tag> entry : map.entrySet()) {
            Tag tag = entry.getValue();

            byte key = tag.getKey();

            output.writeByte(key);
            if (key != TagRegistry.EMPTY) {
                output.writeUTF(entry.getKey());

                tag.save(output);
            }
        }
        output.writeByte(TagRegistry.EMPTY);
    }

    @Override
    public byte getKey() {
        return TagRegistry.COMPOUND;
    }
}
