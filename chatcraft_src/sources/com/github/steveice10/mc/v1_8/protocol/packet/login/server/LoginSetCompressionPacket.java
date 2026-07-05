package com.github.steveice10.mc.v1_8.protocol.packet.login.server;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class LoginSetCompressionPacket implements Packet {
    private int threshold;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return true;
    }

    private LoginSetCompressionPacket() {
    }

    public LoginSetCompressionPacket(int i) {
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
