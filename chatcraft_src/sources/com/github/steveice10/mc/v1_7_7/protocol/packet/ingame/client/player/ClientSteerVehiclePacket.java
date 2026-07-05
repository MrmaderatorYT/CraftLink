package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientSteerVehiclePacket implements Packet {
    private boolean dismount;
    private float forward;
    private boolean jump;
    private float sideways;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientSteerVehiclePacket() {
    }

    public ClientSteerVehiclePacket(float f, float f2, boolean z, boolean z2) {
        this.sideways = f;
        this.forward = f2;
        this.jump = z;
        this.dismount = z2;
    }

    public float getSideways() {
        return this.sideways;
    }

    public float getForward() {
        return this.forward;
    }

    public boolean getJumping() {
        return this.jump;
    }

    public boolean getDismounting() {
        return this.dismount;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.sideways = netInput.readFloat();
        this.forward = netInput.readFloat();
        this.jump = netInput.readBoolean();
        this.dismount = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeFloat(this.sideways);
        netOutput.writeFloat(this.forward);
        netOutput.writeBoolean(this.jump);
        netOutput.writeBoolean(this.dismount);
    }
}
