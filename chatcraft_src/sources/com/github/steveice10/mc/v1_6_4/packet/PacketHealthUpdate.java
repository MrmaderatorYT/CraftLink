package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketHealthUpdate extends Packet {
    public short food;
    public float health;
    public float saturation;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 8;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketHealthUpdate() {
    }

    public PacketHealthUpdate(float f, short s, float f2) {
        this.health = f;
        this.food = s;
        this.saturation = f2;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.health = netInput.readFloat();
        this.food = netInput.readShort();
        this.saturation = netInput.readFloat();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeFloat(this.health);
        netOutput.writeShort(this.food);
        netOutput.writeFloat(this.saturation);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
