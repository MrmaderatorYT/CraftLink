package com.github.steveice10.mc.v1_9.protocol.packet.ingame.server;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerSwitchCameraPacket implements Packet {
    private int cameraEntityId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerSwitchCameraPacket() {
    }

    public ServerSwitchCameraPacket(int i) {
        this.cameraEntityId = i;
    }

    public int getCameraEntityId() {
        return this.cameraEntityId;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.cameraEntityId = netInput.readVarInt();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.cameraEntityId);
    }
}
