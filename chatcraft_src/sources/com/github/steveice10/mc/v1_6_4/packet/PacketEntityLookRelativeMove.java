package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketEntityLookRelativeMove extends Packet {
    public byte dX;
    public byte dY;
    public byte dZ;
    public int entityId;
    public byte pitch;
    public byte yaw;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 33;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketEntityLookRelativeMove() {
    }

    public PacketEntityLookRelativeMove(int i, byte b2, byte b3, byte b4, byte b5, byte b6) {
        this.entityId = i;
        this.dX = b2;
        this.dY = b3;
        this.dZ = b4;
        this.yaw = b5;
        this.pitch = b6;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.dX = netInput.readByte();
        this.dY = netInput.readByte();
        this.dZ = netInput.readByte();
        this.yaw = netInput.readByte();
        this.pitch = netInput.readByte();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeByte(this.dX);
        netOutput.writeByte(this.dY);
        netOutput.writeByte(this.dZ);
        netOutput.writeByte(this.yaw);
        netOutput.writeByte(this.pitch);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
