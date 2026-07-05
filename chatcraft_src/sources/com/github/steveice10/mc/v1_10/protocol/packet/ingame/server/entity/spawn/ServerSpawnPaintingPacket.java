package com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.spawn;

import com.github.steveice10.mc.v1_10.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_10.protocol.data.game.entity.metadata.Position;
import com.github.steveice10.mc.v1_10.protocol.data.game.entity.type.PaintingType;
import com.github.steveice10.mc.v1_10.protocol.data.game.entity.type.object.HangingDirection;
import com.github.steveice10.mc.v1_10.protocol.util.NetUtil;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.util.UUID;

/* loaded from: classes.dex */
public class ServerSpawnPaintingPacket implements Packet {
    private HangingDirection direction;
    private int entityId;
    private PaintingType paintingType;
    private Position position;
    private UUID uuid;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerSpawnPaintingPacket() {
    }

    public ServerSpawnPaintingPacket(int i, UUID uuid, PaintingType paintingType, Position position, HangingDirection hangingDirection) {
        this.entityId = i;
        this.uuid = uuid;
        this.paintingType = paintingType;
        this.position = position;
        this.direction = hangingDirection;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public PaintingType getPaintingType() {
        return this.paintingType;
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
        this.uuid = netInput.readUUID();
        this.paintingType = (PaintingType) MagicValues.key(PaintingType.class, netInput.readString());
        this.position = NetUtil.readPosition(netInput);
        this.direction = (HangingDirection) MagicValues.key(HangingDirection.class, Integer.valueOf(netInput.readUnsignedByte()));
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeUUID(this.uuid);
        netOutput.writeString((String) MagicValues.value(String.class, this.paintingType));
        NetUtil.writePosition(netOutput, this.position);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.direction)).intValue());
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
