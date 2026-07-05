package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;

/* loaded from: classes.dex */
public class ServerRespawnPacket implements Packet {
    private Difficulty difficulty;
    private int dimension;
    private GameMode gamemode;
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

    private ServerRespawnPacket() {
    }

    public ServerRespawnPacket(int i, Difficulty difficulty, GameMode gameMode, WorldType worldType) {
        this.dimension = i;
        this.difficulty = difficulty;
        this.gamemode = gameMode;
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
        this.difficulty = Difficulty.values()[netInput.readUnsignedByte()];
        this.gamemode = GameMode.values()[netInput.readUnsignedByte()];
        this.worldType = nameToType(netInput.readString());
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.dimension);
        netOutput.writeByte(this.difficulty.ordinal());
        netOutput.writeByte(this.gamemode.ordinal());
        netOutput.writeString(typeToName(this.worldType));
    }
}
