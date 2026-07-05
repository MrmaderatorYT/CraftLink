package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;

/* loaded from: classes.dex */
public class ServerJoinGamePacket implements Packet {
    private Difficulty difficulty;
    private int dimension;
    private int entityId;
    private GameMode gamemode;
    private boolean hardcore;
    private int maxPlayers;
    private WorldType worldType;

    public enum Difficulty {
        PEACEFUL,
        EASY,
        NORMAL,
        HARD
    }

    public enum GameMode {
        SURVIVAL,
        CREATIVE,
        ADVENTURE
    }

    public enum WorldType {
        DEFAULT,
        FLAT,
        LARGE_BIOMES,
        AMPLIFIED,
        DEFAULT_1_1
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerJoinGamePacket() {
    }

    public ServerJoinGamePacket(int i, boolean z, GameMode gameMode, int i2, Difficulty difficulty, int i3, WorldType worldType) {
        this.entityId = i;
        this.hardcore = z;
        this.gamemode = gameMode;
        this.dimension = i2;
        this.difficulty = difficulty;
        this.maxPlayers = i3;
        this.worldType = worldType;
    }

    private static String typeToName(WorldType worldType) throws IOException {
        if (worldType == WorldType.DEFAULT) {
            return "default";
        }
        if (worldType == WorldType.FLAT) {
            return "flat";
        }
        if (worldType == WorldType.LARGE_BIOMES) {
            return "largeBiomes";
        }
        if (worldType == WorldType.AMPLIFIED) {
            return "amplified";
        }
        if (worldType == WorldType.DEFAULT_1_1) {
            return "default_1_1";
        }
        throw new IOException("Unmapped world type: " + worldType);
    }

    private static WorldType nameToType(String str) throws IOException {
        if (str.equalsIgnoreCase("default")) {
            return WorldType.DEFAULT;
        }
        if (str.equalsIgnoreCase("flat")) {
            return WorldType.FLAT;
        }
        if (str.equalsIgnoreCase("largeBiomes")) {
            return WorldType.LARGE_BIOMES;
        }
        if (str.equalsIgnoreCase("amplified")) {
            return WorldType.AMPLIFIED;
        }
        if (str.equalsIgnoreCase("default_1_1")) {
            return WorldType.DEFAULT_1_1;
        }
        throw new IOException("Unknown world type: " + str);
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

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        int unsignedByte = netInput.readUnsignedByte();
        this.hardcore = (unsignedByte & 8) == 8;
        this.gamemode = GameMode.values()[unsignedByte & (-9)];
        this.dimension = netInput.readByte();
        this.difficulty = Difficulty.values()[netInput.readUnsignedByte()];
        this.maxPlayers = netInput.readUnsignedByte();
        this.worldType = nameToType(netInput.readString());
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        int iOrdinal = this.gamemode.ordinal();
        if (this.hardcore) {
            iOrdinal |= 8;
        }
        netOutput.writeByte(iOrdinal);
        netOutput.writeByte(this.dimension);
        netOutput.writeByte(this.difficulty.ordinal());
        netOutput.writeByte(this.maxPlayers);
        netOutput.writeString(typeToName(this.worldType));
    }
}
