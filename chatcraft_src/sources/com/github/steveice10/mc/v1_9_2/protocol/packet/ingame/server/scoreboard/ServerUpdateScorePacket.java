package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.server.scoreboard;

import com.github.steveice10.mc.v1_9_2.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.scoreboard.ScoreboardAction;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerUpdateScorePacket implements Packet {
    private ScoreboardAction action;
    private String entry;
    private String objective;
    private int value;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerUpdateScorePacket() {
    }

    public ServerUpdateScorePacket(String str, String str2) {
        this.entry = str;
        this.objective = str2;
        this.action = ScoreboardAction.REMOVE;
    }

    public ServerUpdateScorePacket(String str, String str2, int i) {
        this.entry = str;
        this.objective = str2;
        this.value = i;
        this.action = ScoreboardAction.ADD_OR_UPDATE;
    }

    public String getEntry() {
        return this.entry;
    }

    public ScoreboardAction getAction() {
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
        this.action = (ScoreboardAction) MagicValues.key(ScoreboardAction.class, Integer.valueOf(netInput.readVarInt()));
        this.objective = netInput.readString();
        if (this.action == ScoreboardAction.ADD_OR_UPDATE) {
            this.value = netInput.readVarInt();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.entry);
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.action)).intValue());
        netOutput.writeString(this.objective);
        if (this.action == ScoreboardAction.ADD_OR_UPDATE) {
            netOutput.writeVarInt(this.value);
        }
    }
}
