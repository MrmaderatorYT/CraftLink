package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketEntityRelativeMove extends Packet {
    public byte dX;
    public byte dY;
    public byte dZ;
    public int entityId;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 31;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
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

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.dX = netInput.readByte();
        this.dY = netInput.readByte();
        this.dZ = netInput.readByte();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeByte(this.dX);
        netOutput.writeByte(this.dY);
        netOutput.writeByte(this.dZ);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
