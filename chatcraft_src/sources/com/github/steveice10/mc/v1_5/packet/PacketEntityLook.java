package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketEntityLook extends Packet {
    public int entityId;
    public byte pitch;
    public byte yaw;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 32;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketEntityLook() {
    }

    public PacketEntityLook(int i, byte b2, byte b3) {
        this.entityId = i;
        this.yaw = b2;
        this.pitch = b3;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.entityId = dataInputStream.readInt();
        this.yaw = dataInputStream.readByte();
        this.pitch = dataInputStream.readByte();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        dataOutputStream.writeByte(this.yaw);
        dataOutputStream.writeByte(this.pitch);
    }
}
