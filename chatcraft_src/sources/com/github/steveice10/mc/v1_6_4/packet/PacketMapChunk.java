package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public class PacketMapChunk extends Packet {
    public byte[] data;
    public int endY;
    public boolean groundUp;
    public int startY;
    public int x;
    public int z;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 51;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
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
        this.data = bArr;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readInt();
        this.z = netInput.readInt();
        this.groundUp = netInput.readBoolean();
        this.startY = netInput.readShort();
        this.endY = netInput.readShort();
        int i = netInput.readInt();
        byte[] bytes = netInput.readBytes(i);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 16; i4++) {
            i2 += (this.startY >> i4) & 1;
            i3 += (this.endY >> i4) & 1;
        }
        int i5 = (i2 * 12288) + (i3 * 2048);
        if (this.groundUp) {
            i5 += 256;
        }
        this.data = new byte[i5];
        Inflater inflater = new Inflater();
        inflater.setInput(bytes, 0, i);
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

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        Deflater deflater = new Deflater(-1);
        byte[] bArr = new byte[0];
        try {
            deflater.setInput(this.data, 0, this.data.length);
            deflater.finish();
            byte[] bArr2 = new byte[this.data.length];
            int iDeflate = deflater.deflate(this.data);
            deflater.end();
            netOutput.writeInt(this.x);
            netOutput.writeInt(this.z);
            netOutput.writeBoolean(this.groundUp);
            netOutput.writeShort((short) (this.startY & 65535));
            netOutput.writeShort((short) (this.endY & 65535));
            netOutput.writeInt(iDeflate);
            netOutput.writeBytes(bArr2, iDeflate);
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
