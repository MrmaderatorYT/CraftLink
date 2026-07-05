package com.github.steveice10.mc.v1_10.protocol.packet.ingame.server;

import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerTabCompletePacket implements Packet {
    private String[] matches;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerTabCompletePacket() {
    }

    public ServerTabCompletePacket(String[] strArr) {
        this.matches = strArr;
    }

    public String[] getMatches() {
        return this.matches;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.matches = new String[netInput.readVarInt()];
        for (int i = 0; i < this.matches.length; i++) {
            this.matches[i] = netInput.readString();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.matches.length);
        for (String str : this.matches) {
            netOutput.writeString(str);
        }
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
