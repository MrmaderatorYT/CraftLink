package com.github.steveice10.mc.v1_8.protocol.packet.status.client;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class StatusPingPacket implements Packet {
    private long time;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private StatusPingPacket() {
    }

    public StatusPingPacket(long j) {
        this.time = j;
    }

    public long getPingTime() {
        return this.time;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.time = netInput.readLong();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeLong(this.time);
    }
}
