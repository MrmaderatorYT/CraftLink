package com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.world;

import com.github.steveice10.mc.v1_10.protocol.data.game.entity.metadata.Position;
import com.github.steveice10.mc.v1_10.protocol.util.NetUtil;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientUpdateSignPacket implements Packet {
    private String[] lines;
    private Position position;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientUpdateSignPacket() {
    }

    public ClientUpdateSignPacket(Position position, String[] strArr) {
        if (strArr.length != 4) {
            throw new IllegalArgumentException("Lines must contain exactly 4 strings!");
        }
        this.position = position;
        this.lines = strArr;
    }

    public Position getPosition() {
        return this.position;
    }

    public String[] getLines() {
        return this.lines;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.position = NetUtil.readPosition(netInput);
        this.lines = new String[4];
        for (int i = 0; i < this.lines.length; i++) {
            this.lines[i] = netInput.readString();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        NetUtil.writePosition(netOutput, this.position);
        for (String str : this.lines) {
            netOutput.writeString(str);
        }
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
