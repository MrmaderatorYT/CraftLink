package com.github.steveice10.mc.v1_9.protocol.packet.ingame.server;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerSetCompressionPacket implements Packet {
    private int threshold;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return true;
    }

    private ServerSetCompressionPacket() {
    }

    public ServerSetCompressionPacket(int i) {
        this.threshold = i;
    }

    public int getThreshold() {
        return this.threshold;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.threshold = netInput.readVarInt();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.threshold);
    }
}
