package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketBlockChange extends Packet {
    public short block;
    public byte data;
    public int x;
    public int y;
    public int z;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 53;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketBlockChange() {
    }

    public PacketBlockChange(int i, int i2, int i3, short s, byte b2) {
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.block = s;
        this.data = b2;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.x = dataInputStream.readInt();
        this.y = dataInputStream.readByte();
        this.z = dataInputStream.readInt();
        this.block = dataInputStream.readShort();
        this.data = dataInputStream.readByte();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.x);
        dataOutputStream.writeByte(this.y);
        dataOutputStream.writeInt(this.z);
        dataOutputStream.writeShort(this.block);
        dataOutputStream.writeByte(this.data);
    }
}
