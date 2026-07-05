package com.github.steveice10.mc.v1_6_4.util;

import com.github.steveice10.mc.v1_7.protocol.data.game.Chunk;

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
}
