package com.github.steveice10.mc.v1_8.protocol.util.v1_8;

import com.github.steveice10.mc.v1_8.protocol.data.game.Chunk;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ParsedChunkData {
    private byte[] biomes;
    private Chunk[] chunks;

    public ParsedChunkData(Chunk[] chunkArr, byte[] bArr) {
        this.chunks = chunkArr;
        this.biomes = bArr;
    }

    public Chunk[] getChunks() {
        return this.chunks;
    }

    public byte[] getBiomes() {
        return this.biomes;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ParsedChunkData parsedChunkData = (ParsedChunkData) obj;
        return Arrays.equals(this.biomes, parsedChunkData.biomes) && Arrays.equals(this.chunks, parsedChunkData.chunks);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.chunks) * 31) + (this.biomes != null ? Arrays.hashCode(this.biomes) : 0);
    }
}
