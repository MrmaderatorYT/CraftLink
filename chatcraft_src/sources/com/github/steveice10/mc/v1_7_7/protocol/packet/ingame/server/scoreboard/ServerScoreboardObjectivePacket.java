package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.scoreboard;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerScoreboardObjectivePacket implements Packet {
    private Action action;
    private String displayName;
    private String name;

    public enum Action {
        ADD,
        REMOVE,
        UPDATE
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerScoreboardObjectivePacket() {
    }

    public ServerScoreboardObjectivePacket(String str, String str2, Action action) {
        this.name = str;
        this.displayName = str2;
        this.action = action;
    }

    public String getName() {
        return this.name;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Action getAction() {
        return this.action;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.name = netInput.readString();
        this.displayName = netInput.readString();
        this.action = Action.values()[netInput.readByte()];
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.name);
        netOutput.writeString(this.displayName);
        netOutput.writeByte(this.action.ordinal());
    }
}
