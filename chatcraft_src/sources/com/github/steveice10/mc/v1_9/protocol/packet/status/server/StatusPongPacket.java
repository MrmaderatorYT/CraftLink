package com.github.steveice10.mc.v1_9.protocol.packet.status.server;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class StatusPongPacket implements Packet {
    private long time;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private StatusPongPacket() {
    }

    public StatusPongPacket(long j) {
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
