package com.chaottic.nbt;

import com.chaottic.nbt.number.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TagRegistry {
    public final byte EMPTY = 0;
    public final byte BYTE = 1;
    public final byte SHORT = 2;
    public final byte INT = 3;
    public final byte LONG = 4;
    public final byte FLOAT = 5;
    public final byte DOUBLE = 6;
    public final byte BYTE_ARRAY = 7;
    public final byte STRING = 8;
    public final byte LIST = 9;
    public final byte COMPOUND = 10;
    public final byte INT_ARRAY = 11;
    public final byte LONG_ARRAY = 12;

    public final TagType<?>[] TAG_TYPES = {
            null,
            ByteTag.TAG_TYPE,
            ShortTag.TAG_TYPE,
            IntTag.TAG_TYPE,
            LongTag.TAG_TYPE,
            FloatTag.TAG_TYPE,
            DoubleTag.TAG_TYPE,
            ByteArrayTag.TAG_TYPE,
            StringTag.TAG_TYPE,
            ListTag.TAG_TYPE,
            CompoundTag.TAG_TYPE
    };
}
