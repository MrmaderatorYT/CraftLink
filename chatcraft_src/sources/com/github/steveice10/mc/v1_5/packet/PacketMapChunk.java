package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public class PacketMapChunk extends Packet {
    public byte[] data;
    public int endY;
    public boolean groundUp;
    public int length;
    public int startY;
    public int x;
    public int z;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 51;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketMapChunk() {
    }

    public PacketMapChunk(int i, int i2, boolean z, int i3, int i4, byte[] bArr) {
        this.x = i;
        this.z = i2;
        this.groundUp = z;
        this.startY = i3;
        this.endY = i4;
        Deflater deflater = new Deflater(-1);
        try {
            deflater.setInput(bArr, 0, bArr.length);
            deflater.finish();
            this.data = new byte[bArr.length];
            this.length = deflater.deflate(this.data);
        } finally {
            deflater.end();
        }
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) throws IOException {
        this.x = dataInputStream.readInt();
        this.z = dataInputStream.readInt();
        this.groundUp = dataInputStream.readBoolean();
        this.startY = dataInputStream.readShort();
        this.endY = dataInputStream.readShort();
        this.length = dataInputStream.readInt();
        byte[] bArr = new byte[this.length];
        dataInputStream.readFully(bArr, 0, this.length);
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            i += (this.startY >> i2) & 1;
        }
        int i3 = i * 12288;
        if (this.groundUp) {
            i3 += 256;
        }
        this.data = new byte[i3];
        Inflater inflater = new Inflater();
        inflater.setInput(bArr, 0, this.length);
        try {
            try {
                inflater.inflate(this.data);
            } catch (DataFormatException unused) {
                throw new IOException("Bad compressed data format");
            }
        } finally {
            inflater.end();
        }
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.x);
        dataOutputStream.writeInt(this.z);
        dataOutputStream.writeBoolean(this.groundUp);
        dataOutputStream.writeShort((short) (this.startY & 65535));
        dataOutputStream.writeShort((short) (this.endY & 65535));
        dataOutputStream.writeByte(this.length);
        dataOutputStream.write(this.data, 0, this.length);
    }
}
