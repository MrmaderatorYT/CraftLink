package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.spawn;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerSpawnPaintingPacket implements Packet {
    private Art art;
    private Direction direction;
    private int entityId;
    private int x;
    private int y;
    private int z;

    public enum Art {
        Kebab,
        Aztec,
        Alban,
        Aztec2,
        Bomb,
        Plant,
        Wasteland,
        Pool,
        Courbet,
        Sea,
        Sunset,
        Creebet,
        Wanderer,
        Graham,
        Match,
        Bust,
        Stage,
        Void,
        SkullAndRoses,
        Wither,
        Fighters,
        Pointer,
        Pigscene,
        BurningSkull,
        Skeleton,
        DonkeyKong
    }

    public enum Direction {
        BOTTOM,
        TOP,
        EAST,
        WEST,
        NORTH,
        SOUTH
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerSpawnPaintingPacket() {
    }

    public ServerSpawnPaintingPacket(int i, Art art, int i2, int i3, int i4, Direction direction) {
        this.entityId = i;
        this.art = art;
        this.x = i2;
        this.y = i3;
        this.z = i4;
        this.direction = direction;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public Art getArt() {
        return this.art;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public Direction getDirection() {
        return this.direction;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.art = Art.valueOf(netInput.readString());
        this.x = netInput.readInt();
        this.y = netInput.readInt();
        this.z = netInput.readInt();
        this.direction = Direction.values()[netInput.readInt()];
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeString(this.art.name());
        netOutput.writeInt(this.x);
        netOutput.writeInt(this.y);
        netOutput.writeInt(this.z);
        netOutput.writeInt(this.direction.ordinal());
    }
}
