package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerPlayerListEntryPacket implements Packet {
    private String name;
    private boolean online;
    private int ping;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerPlayerListEntryPacket() {
    }

    public ServerPlayerListEntryPacket(String str, boolean z, int i) {
        this.name = str;
        this.online = z;
        this.ping = i;
    }

    public String getName() {
        return this.name;
    }

    public boolean getOnline() {
        return this.online;
    }

    public int getPing() {
        return this.ping;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.name = netInput.readString();
        this.online = netInput.readBoolean();
        this.ping = netInput.readShort();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.name);
        netOutput.writeBoolean(this.online);
        netOutput.writeShort(this.ping);
    }
}
