package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_8.protocol.data.game.Position;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.NetUtil;
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
}
