package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketPlayerDigging extends Packet {
    public byte face;
    public byte status;
    public int x;
    public int y;
    public int z;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 14;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketPlayerDigging() {
    }

    public PacketPlayerDigging(byte b2, int i, int i2, int i3, byte b3) {
        this.status = b2;
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.face = b3;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.status = netInput.readByte();
        this.x = netInput.readInt();
        this.y = netInput.readUnsignedByte();
        this.z = netInput.readInt();
        this.face = netInput.readByte();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.status);
        netOutput.writeInt(this.x);
        netOutput.writeByte(this.y);
        netOutput.writeInt(this.z);
        netOutput.writeByte(this.face);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
