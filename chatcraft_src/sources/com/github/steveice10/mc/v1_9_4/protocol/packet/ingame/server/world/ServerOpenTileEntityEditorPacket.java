package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.metadata.Position;
import com.github.steveice10.mc.v1_9_4.protocol.util.NetUtil;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerOpenTileEntityEditorPacket implements Packet {
    private Position position;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerOpenTileEntityEditorPacket() {
    }

    public ServerOpenTileEntityEditorPacket(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.position = NetUtil.readPosition(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        NetUtil.writePosition(netOutput, this.position);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
