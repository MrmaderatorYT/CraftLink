package com.github.steveice10.mc.v1_12_2.protocol.packet.ingame.client;

import com.github.steveice10.mc.common.MinecraftPacket;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class ClientKeepAlivePacket extends MinecraftPacket {
    private long id;

    private ClientKeepAlivePacket() {
    }

    public ClientKeepAlivePacket(long j) {
        this.id = j;
    }

    public long getPingId() {
        return this.id;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.id = netInput.readLong();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeLong(this.id);
    }
}
