package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketBlockAction extends Packet {
    public byte b1;
    public byte b2;
    public int block;
    public int x;
    public int y;
    public int z;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 54;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketBlockAction() {
    }

    public PacketBlockAction(int i, int i2, int i3, byte b2, byte b3, short s) {
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.b1 = b2;
        this.b2 = b3;
        this.block = s;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.x = dataInputStream.readInt();
        this.y = dataInputStream.readShort();
        this.z = dataInputStream.readInt();
        this.b1 = dataInputStream.readByte();
        this.b2 = dataInputStream.readByte();
        this.block = dataInputStream.readUnsignedShort();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.x);
        dataOutputStream.writeInt(this.y);
        dataOutputStream.writeInt(this.z);
        dataOutputStream.writeByte(this.b1);
        dataOutputStream.writeByte(this.b2);
        dataOutputStream.writeShort(this.block);
    }
}
