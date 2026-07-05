package com.github.steveice10.packetlib.io;

import java.util.UUID;

/* loaded from: classes.dex */
public interface NetOutput {
    void flush();

    void writeBoolean(boolean z);

    void writeByte(int i);

    void writeBytes(byte[] bArr);

    void writeBytes(byte[] bArr, int i);

    void writeChar(int i);

    void writeDouble(double d);

    void writeFloat(float f);

    void writeInt(int i);

    void writeInts(int[] iArr);

    void writeInts(int[] iArr, int i);

    void writeLong(long j);

    void writeLongs(long[] jArr);

    void writeLongs(long[] jArr, int i);

    void writePrefixedBytes(byte[] bArr);

    void writeShort(int i);

    void writeShorts(short[] sArr);

    void writeShorts(short[] sArr, int i);

    void writeString(String str);

    void writeUUID(UUID uuid);

    void writeVarInt(int i);

    void writeVarLong(long j);
}
