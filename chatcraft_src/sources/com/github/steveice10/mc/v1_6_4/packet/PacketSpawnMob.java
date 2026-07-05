package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.data.WatchableObject;
import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

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

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 24;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
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

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.type = netInput.readByte();
        this.x = netInput.readInt();
        this.y = netInput.readInt();
        this.z = netInput.readInt();
        this.yaw = netInput.readByte();
        this.pitch = netInput.readByte();
        this.headYaw = netInput.readByte();
        this.velX = netInput.readShort();
        this.velY = netInput.readShort();
        this.velZ = netInput.readShort();
        this.metadata = readMetadata(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeByte(this.type);
        netOutput.writeInt(this.x);
        netOutput.writeInt(this.y);
        netOutput.writeInt(this.z);
        netOutput.writeByte(this.yaw);
        netOutput.writeByte(this.pitch);
        netOutput.writeByte(this.headYaw);
        netOutput.writeShort(this.velX);
        netOutput.writeShort(this.velY);
        netOutput.writeShort(this.velZ);
        writeMetadata(netOutput, this.metadata);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
