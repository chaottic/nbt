package com.chaottic.nbt;

import java.io.DataInput;
import java.io.IOException;

public interface TagType<T extends Tag> {

    T load(DataInput input) throws IOException;
}
