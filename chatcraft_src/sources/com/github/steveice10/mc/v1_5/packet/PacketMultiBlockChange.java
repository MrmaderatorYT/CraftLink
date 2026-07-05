package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketMultiBlockChange extends Packet {
    public byte[] data;
    public int records;
    public int x;
    public int z;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 52;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketMultiBlockChange() {
    }

    public PacketMultiBlockChange(int i, int i2, int i3, byte[] bArr) {
        this.x = i;
        this.z = i2;
        this.records = i3;
        this.data = bArr;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) throws IOException {
        this.x = dataInputStream.readInt();
        this.z = dataInputStream.readInt();
        this.records = dataInputStream.readShort() & 65535;
        int i = dataInputStream.readInt();
        if (i > 0) {
            this.data = new byte[i];
            dataInputStream.readFully(this.data);
        }
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.x);
        dataOutputStream.writeInt(this.z);
        dataOutputStream.writeShort((short) this.records);
        if (this.data != null) {
            dataOutputStream.writeInt(this.data.length);
            dataOutputStream.write(this.data);
        } else {
            dataOutputStream.writeInt(0);
        }
    }
}
