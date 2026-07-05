package com.github.steveice10.packetlib.tcp.io;

import com.github.steveice10.packetlib.io.NetInput;
import io.netty.b.i;
import java.io.IOException;
import java.util.UUID;

/* loaded from: classes.dex */
public class ByteBufNetInput implements NetInput {
    private i buf;

    public ByteBufNetInput(i iVar) {
        this.buf = iVar;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public boolean readBoolean() {
        return this.buf.o();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public byte readByte() {
        return this.buf.n();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readUnsignedByte() {
        return this.buf.p();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public short readShort() {
        return this.buf.q();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readUnsignedShort() {
        return this.buf.r();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public char readChar() {
        return this.buf.u();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readInt() {
        return this.buf.s();
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
        return this.buf.t();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public long readVarLong() throws IOException {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte b2 = readByte();
            if ((b2 & 128) != 128) {
                return i | ((b2 & 127) << (i2 * 7));
            }
            int i3 = i2 + 1;
            i |= (b2 & 127) << (i2 * 7);
            if (i3 > 10) {
                throw new IOException("VarLong too long (length must be <= 10)");
            }
            i2 = i3;
        }
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public float readFloat() {
        return this.buf.v();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public double readDouble() {
        return this.buf.w();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public byte[] readBytes(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Array cannot have length less than 0.");
        }
        byte[] bArr = new byte[i];
        this.buf.a(bArr);
        return bArr;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readBytes(byte[] bArr) {
        return readBytes(bArr, 0, bArr.length);
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readBytes(byte[] bArr, int i, int i2) {
        int iG = this.buf.g();
        if (iG <= 0) {
            return -1;
        }
        if (iG < i2) {
            i2 = iG;
        }
        this.buf.a(bArr, i, i2);
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
        int iG = this.buf.g();
        if (iG <= 0) {
            return -1;
        }
        if (iG < i2 * 2) {
            i2 = iG / 2;
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
        int iG = this.buf.g();
        if (iG <= 0) {
            return -1;
        }
        if (iG < i2 * 4) {
            i2 = iG / 4;
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
        int iG = this.buf.g();
        if (iG <= 0) {
            return -1;
        }
        if (iG < i2 * 2) {
            i2 = iG / 2;
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
        return this.buf.g();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public byte[] readPrefixedBytes() {
        return readBytes(readShort());
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public void skipReadableBytes() {
        this.buf.b(this.buf.b() + this.buf.g());
    }
}
