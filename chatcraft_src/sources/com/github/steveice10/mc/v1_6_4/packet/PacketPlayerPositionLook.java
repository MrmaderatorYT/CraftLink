package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketPlayerPositionLook extends Packet {
    public boolean grounded;
    public float pitch;
    public double stance;
    public double x;
    public double y;
    public float yaw;
    public double z;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 13;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketPlayerPositionLook() {
    }

    public PacketPlayerPositionLook(double d, double d2, double d3, double d4, float f, float f2, boolean z) {
        this.x = d;
        this.y = d2;
        this.stance = d3;
        this.z = d4;
        this.yaw = f;
        this.pitch = f2;
        this.grounded = z;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readDouble();
        this.y = netInput.readDouble();
        this.stance = netInput.readDouble();
        this.z = netInput.readDouble();
        this.yaw = netInput.readFloat();
        this.pitch = netInput.readFloat();
        this.grounded = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeDouble(this.x);
        netOutput.writeDouble(this.y);
        netOutput.writeDouble(this.stance);
        netOutput.writeDouble(this.z);
        netOutput.writeFloat(this.yaw);
        netOutput.writeFloat(this.pitch);
        netOutput.writeBoolean(this.grounded);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
