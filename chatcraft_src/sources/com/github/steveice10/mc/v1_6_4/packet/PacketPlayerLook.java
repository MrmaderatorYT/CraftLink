package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketPlayerLook extends Packet {
    public boolean grounded;
    public float pitch;
    public float yaw;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 12;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketPlayerLook() {
    }

    public PacketPlayerLook(float f, float f2, boolean z) {
        this.yaw = f;
        this.pitch = f2;
        this.grounded = z;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.yaw = netInput.readFloat();
        this.pitch = netInput.readFloat();
        this.grounded = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeFloat(this.yaw);
        netOutput.writeFloat(this.pitch);
        netOutput.writeBoolean(this.grounded);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
