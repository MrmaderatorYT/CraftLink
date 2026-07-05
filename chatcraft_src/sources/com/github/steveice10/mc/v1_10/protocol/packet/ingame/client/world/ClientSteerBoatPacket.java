package com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.world;

import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientSteerBoatPacket implements Packet {
    private boolean unk1;
    private boolean unk2;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientSteerBoatPacket() {
    }

    public ClientSteerBoatPacket(boolean z, boolean z2) {
        this.unk1 = z;
        this.unk2 = z2;
    }

    public boolean getUnknown1() {
        return this.unk1;
    }

    public boolean getUnknown2() {
        return this.unk2;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.unk1 = netInput.readBoolean();
        this.unk2 = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeBoolean(this.unk1);
        netOutput.writeBoolean(this.unk2);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
