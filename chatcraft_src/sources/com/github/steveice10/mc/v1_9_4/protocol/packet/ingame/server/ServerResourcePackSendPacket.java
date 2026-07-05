package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server;

import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerResourcePackSendPacket implements Packet {
    private String hash;
    private String url;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerResourcePackSendPacket() {
    }

    public ServerResourcePackSendPacket(String str, String str2) {
        this.url = str;
        this.hash = str2;
    }

    public String getUrl() {
        return this.url;
    }

    public String getHash() {
        return this.hash;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.url = netInput.readString();
        this.hash = netInput.readString();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.url);
        netOutput.writeString(this.hash);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
