package com.github.steveice10.packetlib.tcp.io;

import com.github.steveice10.packetlib.io.NetOutput;
import io.netty.b.i;
import java.io.IOException;
import java.util.UUID;

/* loaded from: classes.dex */
public class ByteBufNetOutput implements NetOutput {
    private i buf;

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void flush() {
    }

    public ByteBufNetOutput(i iVar) {
        this.buf = iVar;
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeBoolean(boolean z) {
        this.buf.a(z);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeByte(int i) {
        this.buf.v(i);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeShort(int i) {
        this.buf.w(i);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeChar(int i) {
        this.buf.y(i);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeInt(int i) {
        this.buf.x(i);
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
        this.buf.a(j);
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
        this.buf.a(f);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeDouble(double d) {
        this.buf.a(d);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeBytes(byte[] bArr) {
        this.buf.b(bArr);
    }

    @Override // com.github.steveice10.packetlib.io.NetOutput
    public void writeBytes(byte[] bArr, int i) {
        this.buf.b(bArr, 0, i);
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
