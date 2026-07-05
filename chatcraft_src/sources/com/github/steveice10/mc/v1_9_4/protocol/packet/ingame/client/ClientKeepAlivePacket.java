package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.client;

import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientKeepAlivePacket implements Packet {
    private int id;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientKeepAlivePacket() {
    }

    public ClientKeepAlivePacket(int i) {
        this.id = i;
    }

    public int getPingId() {
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

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
