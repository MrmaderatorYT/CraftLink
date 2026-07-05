package com.github.steveice10.packetlib.io.buffer;

import com.github.steveice10.packetlib.io.NetOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: classes.dex */
public class ByteBufferNetOutput implements NetOutput {
    private ByteBuffer buffer;

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void flush() {
    }

    public ByteBufferNetOutput(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }

    public ByteBuffer getByteBuffer() {
        return this.buffer;
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeBoolean(boolean z) {
        this.buffer.put(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeByte(int i) {
        this.buffer.put((byte) i);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeShort(int i) {
        this.buffer.putShort((short) i);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeChar(int i) {
        this.buffer.putChar((char) i);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeInt(int i) {
        this.buffer.putInt(i);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeVarInt(int i) {
        while ((i & (-128)) != 0) {
            writeByte((i & 127) | 128);
            i >>>= 7;
        }
        writeByte(i);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeLong(long j) {
        this.buffer.putLong(j);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeVarLong(long j) {
        while (((-128) & j) != 0) {
            writeByte(((int) (127 & j)) | 128);
            j >>>= 7;
        }
        writeByte((int) j);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeFloat(float f) {
        this.buffer.putFloat(f);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeDouble(double d) {
        this.buffer.putDouble(d);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeBytes(byte[] bArr) {
        this.buffer.put(bArr);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeBytes(byte[] bArr, int i) {
        this.buffer.put(bArr, 0, i);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeShorts(short[] sArr) {
        writeShorts(sArr, sArr.length);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeShorts(short[] sArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            writeShort(sArr[i2]);
        }
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeInts(int[] iArr) {
        writeInts(iArr, iArr.length);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeInts(int[] iArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            writeInt(iArr[i2]);
        }
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeLongs(long[] jArr) {
        writeLongs(jArr, jArr.length);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeLongs(long[] jArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            writeLong(jArr[i2]);
        }
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeString(String str) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("String cannot be null!");
        }
        byte[] bytes = str.getBytes("UTF-8");
        if (bytes.length > 32767) {
            throw new IOException("String too big (was " + str.length() + " bytes encoded, max 32767)");
        }
        writeVarInt(bytes.length);
        writeBytes(bytes);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeUUID(UUID uuid) {
        writeLong(uuid.getMostSignificantBits());
        writeLong(uuid.getLeastSignificantBits());
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writePrefixedBytes(byte[] bArr) {
        writeShort(bArr.length);
        writeBytes(bArr);
    }
}
