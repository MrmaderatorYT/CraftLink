package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketEntityEffect extends Packet {
    public byte amplifier;
    public short duration;
    public byte effect;
    public int entityId;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 41;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketEntityEffect() {
    }

    public PacketEntityEffect(int i, byte b2, byte b3, short s) {
        this.entityId = i;
        this.effect = b2;
        this.amplifier = b3;
        this.duration = s;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.effect = netInput.readByte();
        this.amplifier = netInput.readByte();
        this.duration = netInput.readShort();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeByte(this.effect);
        netOutput.writeByte(this.amplifier);
        netOutput.writeShort(this.duration);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
