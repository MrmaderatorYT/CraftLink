package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketUseBed extends Packet {
    public int entityId;
    public byte unknown;
    public int x;
    public byte y;
    public int z;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 17;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketUseBed() {
    }

    public PacketUseBed(int i, byte b2, int i2, byte b3, int i3) {
        this.entityId = i;
        this.unknown = b2;
        this.x = i2;
        this.y = b3;
        this.z = i3;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.entityId = dataInputStream.readInt();
        this.unknown = dataInputStream.readByte();
        this.x = dataInputStream.readInt();
        this.y = dataInputStream.readByte();
        this.z = dataInputStream.readInt();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        dataOutputStream.writeByte(this.unknown);
        dataOutputStream.writeInt(this.x);
        dataOutputStream.writeByte(this.y);
        dataOutputStream.writeInt(this.z);
    }
}
