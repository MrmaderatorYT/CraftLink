package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketSpawnObject extends Packet {
    public int data;
    public int entityId;
    public byte pitch;
    public short speedX;
    public short speedY;
    public short speedZ;
    public byte type;
    public int x;
    public int y;
    public byte yaw;
    public int z;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 23;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketSpawnObject() {
    }

    public PacketSpawnObject(int i, byte b2, int i2, int i3, int i4, byte b3, byte b4, int i5, short s, short s2, short s3) {
        this.entityId = i;
        this.type = b2;
        this.x = i2;
        this.y = i3;
        this.z = i4;
        this.yaw = b3;
        this.pitch = b4;
        this.data = i5;
        this.speedX = s;
        this.speedY = s2;
        this.speedZ = s3;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.entityId = dataInputStream.readInt();
        this.type = dataInputStream.readByte();
        this.x = dataInputStream.readInt();
        this.y = dataInputStream.readInt();
        this.z = dataInputStream.readInt();
        this.pitch = dataInputStream.readByte();
        this.yaw = dataInputStream.readByte();
        this.data = dataInputStream.readInt();
        if (this.data > 0) {
            this.speedX = dataInputStream.readShort();
            this.speedY = dataInputStream.readShort();
            this.speedZ = dataInputStream.readShort();
        }
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        dataOutputStream.writeByte(this.type);
        dataOutputStream.writeInt(this.x);
        dataOutputStream.writeInt(this.y);
        dataOutputStream.writeInt(this.z);
        dataOutputStream.writeByte(this.pitch);
        dataOutputStream.writeByte(this.yaw);
        dataOutputStream.writeInt(this.data);
        if (this.data > 0) {
            dataOutputStream.writeShort(this.speedX);
            dataOutputStream.writeShort(this.speedY);
            dataOutputStream.writeShort(this.speedZ);
        }
    }
}
