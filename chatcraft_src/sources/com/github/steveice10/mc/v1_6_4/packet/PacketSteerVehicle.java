package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketSteerVehicle extends Packet {
    public float forward;
    public boolean jump;
    public float sideways;
    public boolean unmount;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 27;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketSteerVehicle() {
    }

    public PacketSteerVehicle(float f, float f2, boolean z, boolean z2) {
        this.sideways = f;
        this.forward = f2;
        this.jump = z;
        this.unmount = z2;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.sideways = netInput.readFloat();
        this.forward = netInput.readFloat();
        this.jump = netInput.readBoolean();
        this.unmount = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeFloat(this.sideways);
        netOutput.writeFloat(this.forward);
        netOutput.writeBoolean(this.jump);
        netOutput.writeBoolean(this.unmount);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
