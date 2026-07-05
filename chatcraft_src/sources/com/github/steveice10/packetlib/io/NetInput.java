package com.github.steveice10.packetlib.io;

import java.util.UUID;

/* loaded from: classes.dex */
public interface NetInput {
    int available();

    boolean readBoolean();

    byte readByte();

    int readBytes(byte[] bArr);

    int readBytes(byte[] bArr, int i, int i2);

    byte[] readBytes(int i);

    char readChar();

    double readDouble();

    float readFloat();

    int readInt();

    int readInts(int[] iArr);

    int readInts(int[] iArr, int i, int i2);

    int[] readInts(int i);

    long readLong();

    int readLongs(long[] jArr);

    int readLongs(long[] jArr, int i, int i2);

    long[] readLongs(int i);

    byte[] readPrefixedBytes();

    short readShort();

    int readShorts(short[] sArr);

    int readShorts(short[] sArr, int i, int i2);

    short[] readShorts(int i);

    String readString();

    UUID readUUID();

    int readUnsignedByte();

    int readUnsignedShort();

    int readVarInt();

    long readVarLong();

    void skipReadableBytes();
}
