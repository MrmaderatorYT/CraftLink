package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientTabCompletePacket implements Packet {
    private String text;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientTabCompletePacket() {
    }

    public ClientTabCompletePacket(String str) {
        this.text = str;
    }

    public String getText() {
        return this.text;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.text = netInput.readString();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.text);
    }
}
