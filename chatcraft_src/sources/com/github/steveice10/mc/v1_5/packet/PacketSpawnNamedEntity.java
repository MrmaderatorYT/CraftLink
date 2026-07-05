package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.data.WatchableObject;
import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketSpawnNamedEntity extends Packet {
    public int entityId;
    public short item;
    public WatchableObject[] metadata;
    public String name;
    public byte pitch;
    public int x;
    public int y;
    public byte yaw;
    public int z;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 20;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketSpawnNamedEntity() {
    }

    public PacketSpawnNamedEntity(int i, String str, int i2, int i3, int i4, byte b2, byte b3, short s, WatchableObject[] watchableObjectArr) {
        this.entityId = i;
        this.name = str;
        this.x = i2;
        this.y = i3;
        this.z = i4;
        this.yaw = b2;
        this.pitch = b3;
        this.item = s;
        this.metadata = watchableObjectArr;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.entityId = dataInputStream.readInt();
        this.name = IOUtils.readString(dataInputStream);
        this.x = dataInputStream.readInt();
        this.y = dataInputStream.readInt();
        this.z = dataInputStream.readInt();
        this.yaw = dataInputStream.readByte();
        this.pitch = dataInputStream.readByte();
        this.item = dataInputStream.readShort();
        this.metadata = IOUtils.readMetadata(dataInputStream);
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        IOUtils.writeString(dataOutputStream, this.name);
        dataOutputStream.writeInt(this.x);
        dataOutputStream.writeInt(this.y);
        dataOutputStream.writeInt(this.z);
        dataOutputStream.writeByte(this.yaw);
        dataOutputStream.writeByte(this.pitch);
        dataOutputStream.writeShort(this.item);
        IOUtils.writeMetadata(dataOutputStream, this.metadata);
    }
}
