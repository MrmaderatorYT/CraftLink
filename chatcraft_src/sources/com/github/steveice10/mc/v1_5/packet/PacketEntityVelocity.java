package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketEntityVelocity extends Packet {
    public int entityId;
    public short velX;
    public short velY;
    public short velZ;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 28;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketEntityVelocity() {
    }

    public PacketEntityVelocity(int i, short s, short s2, short s3) {
        this.entityId = i;
        this.velX = s;
        this.velY = s2;
        this.velZ = s3;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.entityId = dataInputStream.readInt();
        this.velX = dataInputStream.readShort();
        this.velY = dataInputStream.readShort();
        this.velZ = dataInputStream.readShort();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        dataOutputStream.writeShort(this.velX);
        dataOutputStream.writeShort(this.velY);
        dataOutputStream.writeShort(this.velZ);
    }
}
