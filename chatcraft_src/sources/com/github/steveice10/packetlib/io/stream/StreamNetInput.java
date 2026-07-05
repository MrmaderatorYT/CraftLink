package com.github.steveice10.packetlib.io.stream;

import com.github.steveice10.mc.v1_5.util.Constants;
import com.github.steveice10.packetlib.io.NetInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/* loaded from: classes.dex */
public class StreamNetInput implements NetInput {
    protected InputStream in;

    public StreamNetInput(InputStream inputStream) {
        this.in = inputStream;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public boolean readBoolean() {
        return readByte() == 1;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public byte readByte() {
        return (byte) readUnsignedByte();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readUnsignedByte() throws IOException {
        int i = this.in.read();
        if (i >= 0) {
            return i;
        }
        throw new EOFException();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public short readShort() {
        return (short) readUnsignedShort();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readUnsignedShort() throws IOException {
        return (readUnsignedByte() << 8) + (readUnsignedByte() << 0);
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public char readChar() throws IOException {
        return (char) ((readUnsignedByte() << 8) + (readUnsignedByte() << 0));
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readInt() throws IOException {
        return (readUnsignedByte() << 24) + (readUnsignedByte() << 16) + (readUnsignedByte() << 8) + (readUnsignedByte() << 0);
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
    public long readLong() throws IOException {
        byte[] bytes = readBytes(8);
        return (bytes[0] << 56) + ((bytes[1] & Constants.DimensionIds.NETHER) << 48) + ((bytes[2] & Constants.DimensionIds.NETHER) << 40) + ((bytes[3] & Constants.DimensionIds.NETHER) << 32) + ((bytes[4] & Constants.DimensionIds.NETHER) << 24) + ((bytes[5] & Constants.DimensionIds.NETHER) << 16) + ((bytes[6] & Constants.DimensionIds.NETHER) << 8) + ((bytes[7] & Constants.DimensionIds.NETHER) << 0);
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
        return Float.intBitsToFloat(readInt());
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public byte[] readBytes(int i) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException("Array cannot have length less than 0.");
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = this.in.read(bArr, i2, i - i2);
            if (i3 < 0) {
                throw new EOFException();
            }
            i2 += i3;
        }
        return bArr;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readBytes(byte[] bArr) {
        return this.in.read(bArr);
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readBytes(byte[] bArr, int i, int i2) {
        return this.in.read(bArr, i, i2);
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public short[] readShorts(int i) throws EOFException {
        if (i < 0) {
            throw new IllegalArgumentException("Array cannot have length less than 0.");
        }
        short[] sArr = new short[i];
        if (readShorts(sArr) >= i) {
            return sArr;
        }
        throw new EOFException();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readShorts(short[] sArr) {
        return readShorts(sArr, 0, sArr.length);
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readShorts(short[] sArr, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            try {
                sArr[i3] = readShort();
            } catch (EOFException unused) {
                return i3 - i;
            }
        }
        return i2;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int[] readInts(int i) throws EOFException {
        if (i < 0) {
            throw new IllegalArgumentException("Array cannot have length less than 0.");
        }
        int[] iArr = new int[i];
        if (readInts(iArr) >= i) {
            return iArr;
        }
        throw new EOFException();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readInts(int[] iArr) {
        return readInts(iArr, 0, iArr.length);
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readInts(int[] iArr, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            try {
                iArr[i3] = readInt();
            } catch (EOFException unused) {
                return i3 - i;
            }
        }
        return i2;
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public long[] readLongs(int i) throws EOFException {
        if (i < 0) {
            throw new IllegalArgumentException("Array cannot have length less than 0.");
        }
        long[] jArr = new long[i];
        if (readLongs(jArr) >= i) {
            return jArr;
        }
        throw new EOFException();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readLongs(long[] jArr) {
        return readLongs(jArr, 0, jArr.length);
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public int readLongs(long[] jArr, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            try {
                jArr[i3] = readLong();
            } catch (EOFException unused) {
                return i3 - i;
            }
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
        return this.in.available();
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public byte[] readPrefixedBytes() {
        return readBytes(readShort());
    }

    @Override // com.github.steveice10.packetlib.io.NetInput
    public void skipReadableBytes() {
        try {
            readBytes(this.in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() throws IOException {
        try {
            this.in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InputStream getInputStream() {
        return this.in;
    }
}
