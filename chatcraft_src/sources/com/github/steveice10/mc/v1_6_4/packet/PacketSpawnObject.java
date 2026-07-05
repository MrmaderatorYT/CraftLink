package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

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

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 23;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
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

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.type = netInput.readByte();
        this.x = netInput.readInt();
        this.y = netInput.readInt();
        this.z = netInput.readInt();
        this.pitch = netInput.readByte();
        this.yaw = netInput.readByte();
        this.data = netInput.readInt();
        if (this.data > 0) {
            this.speedX = netInput.readShort();
            this.speedY = netInput.readShort();
            this.speedZ = netInput.readShort();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeByte(this.type);
        netOutput.writeInt(this.x);
        netOutput.writeInt(this.y);
        netOutput.writeInt(this.z);
        netOutput.writeByte(this.pitch);
        netOutput.writeByte(this.yaw);
        netOutput.writeInt(this.data);
        if (this.data > 0) {
            netOutput.writeShort(this.speedX);
            netOutput.writeShort(this.speedY);
            netOutput.writeShort(this.speedZ);
        }
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
