package com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.player;

import com.github.steveice10.mc.v1_9.protocol.data.game.entity.metadata.Position;
import com.github.steveice10.mc.v1_9.protocol.util.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerPlayerUseBedPacket implements Packet {
    private int entityId;
    private Position position;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerPlayerUseBedPacket() {
    }

    public ServerPlayerUseBedPacket(int i, Position position) {
        this.entityId = i;
        this.position = position;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public Position getPosition() {
        return this.position;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.position = NetUtil.readPosition(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        NetUtil.writePosition(netOutput, this.position);
    }
}
