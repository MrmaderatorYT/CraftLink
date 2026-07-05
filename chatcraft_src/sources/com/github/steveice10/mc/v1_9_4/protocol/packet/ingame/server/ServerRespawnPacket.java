package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server;

import com.github.steveice10.mc.v1_9_4.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.player.GameMode;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.setting.Difficulty;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.world.WorldType;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerRespawnPacket implements Packet {
    private Difficulty difficulty;
    private int dimension;
    private GameMode gamemode;
    private WorldType worldType;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerRespawnPacket() {
    }

    public ServerRespawnPacket(int i, Difficulty difficulty, GameMode gameMode, WorldType worldType) {
        this.dimension = i;
        this.difficulty = difficulty;
        this.gamemode = gameMode;
        this.worldType = worldType;
    }

    public int getDimension() {
        return this.dimension;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public GameMode getGameMode() {
        return this.gamemode;
    }

    public WorldType getWorldType() {
        return this.worldType;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.dimension = netInput.readInt();
        this.difficulty = (Difficulty) MagicValues.key(Difficulty.class, Integer.valueOf(netInput.readUnsignedByte()));
        this.gamemode = (GameMode) MagicValues.key(GameMode.class, Integer.valueOf(netInput.readUnsignedByte()));
        this.worldType = (WorldType) MagicValues.key(WorldType.class, netInput.readString().toLowerCase());
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.dimension);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.difficulty)).intValue());
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.gamemode)).intValue());
        netOutput.writeString((String) MagicValues.value(String.class, this.worldType));
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
