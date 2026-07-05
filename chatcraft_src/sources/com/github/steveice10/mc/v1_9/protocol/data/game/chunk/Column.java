package com.github.steveice10.mc.v1_9.protocol.data.game.chunk;

/* loaded from: classes.dex */
public class Column {
    private byte[] biomeData;
    private Chunk[] chunks;
    private boolean skylight;
    private int x;
    private int z;

    public Column(int i, int i2, Chunk[] chunkArr) {
        this(i, i2, chunkArr, null);
    }

    public Column(int i, int i2, Chunk[] chunkArr, byte[] bArr) {
        if (chunkArr.length != 16) {
            throw new IllegalArgumentException("Chunk array length must be 16.");
        }
        if (bArr != null && bArr.length != 256) {
            throw new IllegalArgumentException("Biome data array length must be 256.");
        }
        this.skylight = false;
        boolean z = false;
        for (int i3 = 0; i3 < chunkArr.length; i3++) {
            if (chunkArr[i3] != null) {
                if (chunkArr[i3].getSkyLight() == null) {
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

    public boolean hasSkylight() {
        return this.skylight;
    }
}
