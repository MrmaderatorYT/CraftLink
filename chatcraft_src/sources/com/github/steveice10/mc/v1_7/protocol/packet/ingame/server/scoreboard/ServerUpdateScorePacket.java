package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.scoreboard;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerUpdateScorePacket implements Packet {
    private Action action;
    private String entry;
    private String objective;
    private int value;

    public enum Action {
        ADD_OR_UPDATE,
        REMOVE
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerUpdateScorePacket() {
    }

    public ServerUpdateScorePacket(String str) {
        this.entry = str;
        this.action = Action.REMOVE;
    }

    public ServerUpdateScorePacket(String str, String str2, int i) {
        this.entry = str;
        this.objective = str2;
        this.value = i;
        this.action = Action.ADD_OR_UPDATE;
    }

    public String getEntry() {
        return this.entry;
    }

    public Action getAction() {
        return this.action;
    }

    public String getObjective() {
        return this.objective;
    }

    public int getValue() {
        return this.value;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entry = netInput.readString();
        this.action = Action.values()[netInput.readByte()];
        if (this.action == Action.ADD_OR_UPDATE) {
            this.objective = netInput.readString();
            this.value = netInput.readInt();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.entry);
        netOutput.writeByte(this.action.ordinal());
        if (this.action == Action.ADD_OR_UPDATE) {
            netOutput.writeString(this.objective);
            netOutput.writeInt(this.value);
        }
    }
}
