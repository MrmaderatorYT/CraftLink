package com.github.steveice10.mc.v1_9.protocol.packet.ingame.server;

import com.github.steveice10.mc.v1_9.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9.protocol.data.game.entity.player.GameMode;
import com.github.steveice10.mc.v1_9.protocol.data.game.setting.Difficulty;
import com.github.steveice10.mc.v1_9.protocol.data.game.world.WorldType;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerJoinGamePacket implements Packet {
    private Difficulty difficulty;
    private int dimension;
    private int entityId;
    private GameMode gamemode;
    private boolean hardcore;
    private int maxPlayers;
    private boolean reducedDebugInfo;
    private WorldType worldType;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerJoinGamePacket() {
    }

    public ServerJoinGamePacket(int i, boolean z, GameMode gameMode, int i2, Difficulty difficulty, int i3, WorldType worldType, boolean z2) {
        this.entityId = i;
        this.hardcore = z;
        this.gamemode = gameMode;
        this.dimension = i2;
        this.difficulty = difficulty;
        this.maxPlayers = i3;
        this.worldType = worldType;
        this.reducedDebugInfo = z2;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public boolean getHardcore() {
        return this.hardcore;
    }

    public GameMode getGameMode() {
        return this.gamemode;
    }

    public int getDimension() {
        return this.dimension;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    public WorldType getWorldType() {
        return this.worldType;
    }

    public boolean getReducedDebugInfo() {
        return this.reducedDebugInfo;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        int unsignedByte = netInput.readUnsignedByte();
        this.hardcore = (unsignedByte & 8) == 8;
        this.gamemode = (GameMode) MagicValues.key(GameMode.class, Integer.valueOf(unsignedByte & (-9)));
        this.dimension = netInput.readByte();
        this.difficulty = (Difficulty) MagicValues.key(Difficulty.class, Integer.valueOf(netInput.readUnsignedByte()));
        this.maxPlayers = netInput.readUnsignedByte();
        this.worldType = (WorldType) MagicValues.key(WorldType.class, netInput.readString().toLowerCase());
        this.reducedDebugInfo = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        int iIntValue = ((Integer) MagicValues.value(Integer.class, this.gamemode)).intValue();
        if (this.hardcore) {
            iIntValue |= 8;
        }
        netOutput.writeByte(iIntValue);
        netOutput.writeByte(this.dimension);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.difficulty)).intValue());
        netOutput.writeByte(this.maxPlayers);
        netOutput.writeString((String) MagicValues.value(String.class, this.worldType));
        netOutput.writeBoolean(this.reducedDebugInfo);
    }
}
