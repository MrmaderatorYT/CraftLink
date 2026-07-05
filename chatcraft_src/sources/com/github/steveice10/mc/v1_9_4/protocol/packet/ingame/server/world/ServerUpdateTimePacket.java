package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerUpdateTimePacket implements Packet {
    private long age;
    private long time;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerUpdateTimePacket() {
    }

    public ServerUpdateTimePacket(long j, long j2) {
        this.age = j;
        this.time = j2;
    }

    public long getWorldAge() {
        return this.age;
    }

    public long getTime() {
        return this.time;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.age = netInput.readLong();
        this.time = netInput.readLong();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeLong(this.age);
        netOutput.writeLong(this.time);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
