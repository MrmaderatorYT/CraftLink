package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketPlayerDigging extends Packet {
    public byte face;
    public byte status;
    public int x;
    public byte y;
    public int z;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 14;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketPlayerDigging() {
    }

    public PacketPlayerDigging(byte b2, int i, byte b3, int i2, byte b4) {
        this.status = b2;
        this.x = i;
        this.y = b3;
        this.z = i2;
        this.face = b4;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.status = dataInputStream.readByte();
        this.x = dataInputStream.readInt();
        this.y = dataInputStream.readByte();
        this.z = dataInputStream.readInt();
        this.face = dataInputStream.readByte();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.status);
        dataOutputStream.writeInt(this.x);
        dataOutputStream.writeByte(this.y);
        dataOutputStream.writeInt(this.z);
        dataOutputStream.writeByte(this.face);
    }
}
