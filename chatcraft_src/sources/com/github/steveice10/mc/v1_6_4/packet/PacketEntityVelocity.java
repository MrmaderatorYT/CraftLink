package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketEntityVelocity extends Packet {
    public int entityId;
    public short velX;
    public short velY;
    public short velZ;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 28;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
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

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.velX = netInput.readShort();
        this.velY = netInput.readShort();
        this.velZ = netInput.readShort();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeShort(this.velX);
        netOutput.writeShort(this.velY);
        netOutput.writeShort(this.velZ);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
