package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.scoreboard;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerDisplayScoreboardPacket implements Packet {
    private String name;
    private Position position;

    public enum Position {
        PLAYER_LIST,
        SIDEBAR,
        BELOW_NAME
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerDisplayScoreboardPacket() {
    }

    public ServerDisplayScoreboardPacket(Position position, String str) {
        this.position = position;
        this.name = str;
    }

    public Position getPosition() {
        return this.position;
    }

    public String getScoreboardName() {
        return this.name;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.position = Position.values()[netInput.readByte()];
        this.name = netInput.readString();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.position.ordinal());
        netOutput.writeString(this.name);
    }
}
