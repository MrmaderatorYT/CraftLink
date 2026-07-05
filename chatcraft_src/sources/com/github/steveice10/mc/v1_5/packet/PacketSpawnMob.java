package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.data.WatchableObject;
import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketSpawnMob extends Packet {
    public int entityId;
    public byte headYaw;
    public WatchableObject[] metadata;
    public byte pitch;
    public byte type;
    public short velX;
    public short velY;
    public short velZ;
    public int x;
    public int y;
    public byte yaw;
    public int z;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 24;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketSpawnMob() {
    }

    public PacketSpawnMob(int i, byte b2, int i2, int i3, int i4, byte b3, byte b4, byte b5, short s, short s2, short s3, WatchableObject[] watchableObjectArr) {
        this.entityId = i;
        this.type = b2;
        this.x = i2;
        this.y = i3;
        this.z = i4;
        this.yaw = b3;
        this.pitch = b4;
        this.headYaw = b5;
        this.velX = s;
        this.velY = s2;
        this.velZ = s3;
        this.metadata = watchableObjectArr;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.entityId = dataInputStream.readInt();
        this.type = dataInputStream.readByte();
        this.x = dataInputStream.readInt();
        this.y = dataInputStream.readInt();
        this.z = dataInputStream.readInt();
        this.yaw = dataInputStream.readByte();
        this.pitch = dataInputStream.readByte();
        this.headYaw = dataInputStream.readByte();
        this.velX = dataInputStream.readShort();
        this.velY = dataInputStream.readShort();
        this.velZ = dataInputStream.readShort();
        this.metadata = IOUtils.readMetadata(dataInputStream);
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        dataOutputStream.writeByte(this.type);
        dataOutputStream.writeInt(this.x);
        dataOutputStream.writeInt(this.y);
        dataOutputStream.writeInt(this.z);
        dataOutputStream.writeByte(this.yaw);
        dataOutputStream.writeByte(this.pitch);
        dataOutputStream.writeByte(this.headYaw);
        dataOutputStream.writeShort(this.velX);
        dataOutputStream.writeShort(this.velY);
        dataOutputStream.writeShort(this.velZ);
        IOUtils.writeMetadata(dataOutputStream, this.metadata);
    }
}
