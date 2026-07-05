package com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.world;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientTeleportConfirmPacket implements Packet {
    private int id;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientTeleportConfirmPacket() {
    }

    public ClientTeleportConfirmPacket(int i) {
        this.id = i;
    }

    public int getTeleportId() {
        return this.id;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.id = netInput.readVarInt();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.id);
    }
}
