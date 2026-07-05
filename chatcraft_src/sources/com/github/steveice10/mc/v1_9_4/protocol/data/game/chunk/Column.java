package com.github.steveice10.mc.v1_9_4.protocol.data.game.chunk;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;

/* loaded from: classes.dex */
public class Column {
    private byte[] biomeData;
    private Chunk[] chunks;
    private boolean skylight;
    private CompoundTag[] tileEntities;
    private int x;
    private int z;

    public Column(int i, int i2, Chunk[] chunkArr, CompoundTag[] compoundTagArr) {
        this(i, i2, chunkArr, null, compoundTagArr);
    }

    public Column(int i, int i2, Chunk[] chunkArr, byte[] bArr, CompoundTag[] compoundTagArr) {
        if (chunkArr.length != 16) {
            throw new IllegalArgumentException("Chunk array length must be 16.");
        }
        if (bArr != null && bArr.length != 256) {
            throw new IllegalArgumentException("Biome data array length must be 256.");
        }
        this.skylight = false;
        boolean z = false;
        for (Chunk chunk : chunkArr) {
            if (chunk != null) {
                if (chunk.getSkyLight() == null) {
                    z = true;
                } else {
                    this.skylight = true;
                }
            }
        }
        if (z && this.skylight) {
            throw new IllegalArgumentException("Either all chunks must have skylight values or none must have them.");
        }
        this.x = i;
        this.z = i2;
        this.chunks = chunkArr;
        this.biomeData = bArr;
        this.tileEntities = compoundTagArr;
    }

    public int getX() {
        return this.x;
    }

    public int getZ() {
        return this.z;
    }

    public Chunk[] getChunks() {
        return this.chunks;
    }

    public boolean hasBiomeData() {
        return this.biomeData != null;
    }

    public byte[] getBiomeData() {
        return this.biomeData;
    }

    public CompoundTag[] getTileEntities() {
        return this.tileEntities;
    }

    public boolean hasSkylight() {
        return this.skylight;
    }
}
