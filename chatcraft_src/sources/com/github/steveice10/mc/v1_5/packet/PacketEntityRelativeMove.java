package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketEntityRelativeMove extends Packet {
    public byte dX;
    public byte dY;
    public byte dZ;
    public int entityId;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 31;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketEntityRelativeMove() {
    }

    public PacketEntityRelativeMove(int i, byte b2, byte b3, byte b4) {
        this.entityId = i;
        this.dX = b2;
        this.dY = b3;
        this.dZ = b4;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.entityId = dataInputStream.readInt();
        this.dX = dataInputStream.readByte();
        this.dY = dataInputStream.readByte();
        this.dZ = dataInputStream.readByte();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        dataOutputStream.writeByte(this.dX);
        dataOutputStream.writeByte(this.dY);
        dataOutputStream.writeByte(this.dZ);
    }
}
