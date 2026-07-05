package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketEntityTeleport extends Packet {
    public int entityId;
    public byte pitch;
    public int x;
    public int y;
    public byte yaw;
    public int z;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 34;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketEntityTeleport() {
    }

    public PacketEntityTeleport(int i, int i2, int i3, int i4, byte b2, byte b3) {
        this.entityId = i;
        this.x = i2;
        this.y = i3;
        this.z = i4;
        this.yaw = b2;
        this.pitch = b3;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.x = netInput.readInt();
        this.y = netInput.readInt();
        this.z = netInput.readInt();
        this.yaw = netInput.readByte();
        this.pitch = netInput.readByte();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeInt(this.x);
        netOutput.writeInt(this.y);
        netOutput.writeInt(this.z);
        netOutput.writeByte(this.yaw);
        netOutput.writeByte(this.pitch);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
