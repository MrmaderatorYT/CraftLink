package com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.scoreboard;

import com.github.steveice10.mc.v1_10.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_10.protocol.data.game.scoreboard.ScoreboardPosition;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerDisplayScoreboardPacket implements Packet {
    private String name;
    private ScoreboardPosition position;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerDisplayScoreboardPacket() {
    }

    public ServerDisplayScoreboardPacket(ScoreboardPosition scoreboardPosition, String str) {
        this.position = scoreboardPosition;
        this.name = str;
    }

    public ScoreboardPosition getPosition() {
        return this.position;
    }

    public String getScoreboardName() {
        return this.name;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.position = (ScoreboardPosition) MagicValues.key(ScoreboardPosition.class, Byte.valueOf(netInput.readByte()));
        this.name = netInput.readString();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.position)).intValue());
        netOutput.writeString(this.name);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
