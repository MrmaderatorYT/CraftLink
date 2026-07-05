package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.entity.spawn;

import com.github.steveice10.mc.v1_8.protocol.data.game.Position;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.Art;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.HangingDirection;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerSpawnPaintingPacket implements Packet {
    private Art art;
    private HangingDirection direction;
    private int entityId;
    private Position position;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerSpawnPaintingPacket() {
    }

    public ServerSpawnPaintingPacket(int i, Art art, Position position, HangingDirection hangingDirection) {
        this.entityId = i;
        this.art = art;
        this.position = position;
        this.direction = hangingDirection;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public Art getArt() {
        return this.art;
    }

    public Position getPosition() {
        return this.position;
    }

    public HangingDirection getDirection() {
        return this.direction;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.art = (Art) MagicValues.key(Art.class, netInput.readString());
        this.position = NetUtil.readPosition(netInput);
        this.direction = (HangingDirection) MagicValues.key(HangingDirection.class, Integer.valueOf(netInput.readUnsignedByte()));
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeString((String) MagicValues.value(String.class, this.art));
        NetUtil.writePosition(netOutput, this.position);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.direction)).intValue());
    }
}
