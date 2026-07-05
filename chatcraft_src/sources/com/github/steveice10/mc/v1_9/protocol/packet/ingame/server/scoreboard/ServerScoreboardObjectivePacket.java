package com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.scoreboard;

import com.github.steveice10.mc.v1_9.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9.protocol.data.game.scoreboard.ObjectiveAction;
import com.github.steveice10.mc.v1_9.protocol.data.game.scoreboard.ScoreType;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerScoreboardObjectivePacket implements Packet {
    private ObjectiveAction action;
    private String displayName;
    private String name;
    private ScoreType type;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerScoreboardObjectivePacket() {
    }

    public ServerScoreboardObjectivePacket(String str) {
        this.name = str;
        this.action = ObjectiveAction.REMOVE;
    }

    public ServerScoreboardObjectivePacket(String str, ObjectiveAction objectiveAction, String str2, ScoreType scoreType) {
        if (objectiveAction != ObjectiveAction.ADD && objectiveAction != ObjectiveAction.UPDATE) {
            throw new IllegalArgumentException("(name, action, displayName) constructor only valid for adding and updating objectives.");
        }
        this.name = str;
        this.action = objectiveAction;
        this.displayName = str2;
        this.type = scoreType;
    }

    public String getName() {
        return this.name;
    }

    public ObjectiveAction getAction() {
        return this.action;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public ScoreType getType() {
        return this.type;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.name = netInput.readString();
        this.action = (ObjectiveAction) MagicValues.key(ObjectiveAction.class, Byte.valueOf(netInput.readByte()));
        if (this.action == ObjectiveAction.ADD || this.action == ObjectiveAction.UPDATE) {
            this.displayName = netInput.readString();
            this.type = (ScoreType) MagicValues.key(ScoreType.class, netInput.readString());
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.name);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.action)).intValue());
        if (this.action == ObjectiveAction.ADD || this.action == ObjectiveAction.UPDATE) {
            netOutput.writeString(this.displayName);
            netOutput.writeString((String) MagicValues.value(String.class, this.type));
        }
    }
}
