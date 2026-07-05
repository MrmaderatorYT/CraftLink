package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketSetExperience extends Packet {
    public short experience;
    public float experienceBar;
    public short level;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 43;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketSetExperience() {
    }

    public PacketSetExperience(float f, short s, short s2) {
        this.experienceBar = f;
        this.level = s;
        this.experience = s2;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.experienceBar = netInput.readFloat();
        this.level = netInput.readShort();
        this.experience = netInput.readShort();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeFloat(this.experienceBar);
        netOutput.writeShort(this.level);
        netOutput.writeShort(this.experience);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
