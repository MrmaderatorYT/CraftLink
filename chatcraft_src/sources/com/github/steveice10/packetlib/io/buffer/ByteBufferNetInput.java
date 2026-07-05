package com.github.steveice10.packetlib.io.buffer;

import com.github.steveice10.mc.v1_5.util.Constants;
import com.github.steveice10.packetlib.io.NetInput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: classes.dex */
public class ByteBufferNetInput implements NetInput {
    private ByteBuffer buffer;

    @Override // com.github.steveice10.packetlib.io.NetInput
    public void skipReadableBytes() {
    }

    public ByteBufferNetInput(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }

    public ByteBuffer getByteBuffer() {
        return this.buffer;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public boolean readBoolean() {
        return this.buffer.get() == 1;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public byte readByte() {
        return this.buffer.get();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readUnsignedByte() {
        return this.buffer.get() & Constants.DimensionIds.NETHER;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public short readShort() {
        return this.buffer.getShort();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readUnsignedShort() {
        return this.buffer.getShort() & 65535;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public char readChar() {
        return this.buffer.getChar();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readInt() {
        return this.buffer.getInt();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readVarInt() throws IOException {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte b2 = readByte();
            if ((b2 & 128) != 128) {
                return i | ((b2 & 127) << (i2 * 7));
            }
            int i3 = i2 + 1;
            i |= (b2 & 127) << (i2 * 7);
            if (i3 > 5) {
                throw new IOException("VarInt too long (length must be <= 5)");
            }
            i2 = i3;
        }
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public long readLong() {
        return this.buffer.getLong();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public long readVarLong() throws IOException {
        long j = 0;
        int i = 0;
        while (true) {
            if ((readByte() & 128) != 128) {
                return j | ((r3 & 127) << (i * 7));
            }
            int i2 = i + 1;
            j |= (r3 & 127) << (i * 7);
            if (i2 > 10) {
                throw new IOException("VarLong too long (length must be <= 10)");
            }
            i = i2;
        }
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public float readFloat() {
        return this.buffer.getFloat();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public double readDouble() {
        return this.buffer.getDouble();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public byte[] readBytes(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Array cannot have length less than 0.");
        }
        byte[] bArr = new byte[i];
        this.buffer.get(bArr);
        return bArr;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readBytes(byte[] bArr) {
        return readBytes(bArr, 0, bArr.length);
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readBytes(byte[] bArr, int i, int i2) {
        int iRemaining = this.buffer.remaining();
        if (iRemaining <= 0) {
            return -1;
        }
        if (iRemaining < i2) {
            i2 = iRemaining;
        }
        this.buffer.get(bArr, i, i2);
        return i2;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public short[] readShorts(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Array cannot have length less than 0.");
        }
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = readShort();
        }
        return sArr;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readShorts(short[] sArr) {
        return readShorts(sArr, 0, sArr.length);
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readShorts(short[] sArr, int i, int i2) {
        int iRemaining = this.buffer.remaining();
        if (iRemaining <= 0) {
            return -1;
        }
        if (iRemaining < i2 * 2) {
            i2 = iRemaining / 2;
        }
        for (int i3 = i; i3 < i + i2; i3++) {
            sArr[i3] = readShort();
        }
        return i2;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int[] readInts(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Array cannot have length less than 0.");
        }
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readInt();
        }
        return iArr;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readInts(int[] iArr) {
        return readInts(iArr, 0, iArr.length);
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readInts(int[] iArr, int i, int i2) {
        int iRemaining = this.buffer.remaining();
        if (iRemaining <= 0) {
            return -1;
        }
        if (iRemaining < i2 * 4) {
            i2 = iRemaining / 4;
        }
        for (int i3 = i; i3 < i + i2; i3++) {
            iArr[i3] = readInt();
        }
        return i2;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public long[] readLongs(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Array cannot have length less than 0.");
        }
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = readLong();
        }
        return jArr;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readLongs(long[] jArr) {
        return readLongs(jArr, 0, jArr.length);
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readLongs(long[] jArr, int i, int i2) {
        int iRemaining = this.buffer.remaining();
        if (iRemaining <= 0) {
            return -1;
        }
        if (iRemaining < i2 * 2) {
            i2 = iRemaining / 2;
        }
        for (int i3 = i; i3 < i + i2; i3++) {
            jArr[i3] = readLong();
        }
        return i2;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public String readString() {
        return new String(readBytes(readVarInt()), "UTF-8");
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public UUID readUUID() {
        return new UUID(readLong(), readLong());
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int available() {
        return this.buffer.remaining();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public byte[] readPrefixedBytes() {
        return readBytes(readShort());
    }
}
