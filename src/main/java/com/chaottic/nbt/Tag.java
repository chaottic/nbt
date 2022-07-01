package com.chaottic.nbt;

import java.io.DataOutput;
import java.io.IOException;

public interface Tag {

    void save(DataOutput output) throws IOException;

    byte getKey();
}
