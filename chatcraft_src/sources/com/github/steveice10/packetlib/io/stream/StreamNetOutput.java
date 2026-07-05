package com.github.steveice10.packetlib.io.stream;

import com.github.steveice10.packetlib.io.NetOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

/* loaded from: classes.dex */
public class StreamNetOutput implements NetOutput {
    protected OutputStream out;

    public StreamNetOutput(OutputStream outputStream) {
        this.out = outputStream;
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeBoolean(boolean z) throws IOException {
        writeByte(z ? 1 : 0);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeByte(int i) throws IOException {
        this.out.write(i);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeShort(int i) throws IOException {
        writeByte((byte) ((i >>> 8) & 255));
        writeByte((byte) ((i >>> 0) & 255));
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeChar(int i) throws IOException {
        writeByte((byte) ((i >>> 8) & 255));
        writeByte((byte) ((i >>> 0) & 255));
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeInt(int i) throws IOException {
        writeByte((byte) ((i >>> 24) & 255));
        writeByte((byte) ((i >>> 16) & 255));
        writeByte((byte) ((i >>> 8) & 255));
        writeByte((byte) ((i >>> 0) & 255));
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeVarInt(int i) throws IOException {
        while ((i & (-128)) != 0) {
            writeByte((i & 127) | 128);
            i >>>= 7;
        }
        writeByte(i);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeLong(long j) throws IOException {
        writeByte((byte) (j >>> 56));
        writeByte((byte) (j >>> 48));
        writeByte((byte) (j >>> 40));
        writeByte((byte) (j >>> 32));
        writeByte((byte) (j >>> 24));
        writeByte((byte) (j >>> 16));
        writeByte((byte) (j >>> 8));
        writeByte((byte) (j >>> 0));
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeVarLong(long j) throws IOException {
        while (((-128) & j) != 0) {
            writeByte(((int) (127 & j)) | 128);
            j >>>= 7;
        }
        writeByte((int) j);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeFloat(float f) throws IOException {
        writeInt(Float.floatToIntBits(f));
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeDouble(double d) throws IOException {
        writeLong(Double.doubleToLongBits(d));
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeBytes(byte[] bArr) throws IOException {
        writeBytes(bArr, bArr.length);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeBytes(byte[] bArr, int i) throws IOException {
        this.out.write(bArr, 0, i);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeShorts(short[] sArr) throws IOException {
        writeShorts(sArr, sArr.length);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeShorts(short[] sArr, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            writeShort(sArr[i2]);
        }
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeInts(int[] iArr) throws IOException {
        writeInts(iArr, iArr.length);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeInts(int[] iArr, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            writeInt(iArr[i2]);
        }
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeLongs(long[] jArr) throws IOException {
        writeLongs(jArr, jArr.length);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeLongs(long[] jArr, int i) throws IOException {
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
    public void writeUUID(UUID uuid) throws IOException {
        writeLong(uuid.getMostSignificantBits());
        writeLong(uuid.getLeastSignificantBits());
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writePrefixedBytes(byte[] bArr) throws IOException {
        writeShort(bArr.length);
        writeBytes(bArr);
    }

    public OutputStream getOutputStream() {
        return this.out;
    }

    public void close() throws IOException {
        try {
            this.out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
