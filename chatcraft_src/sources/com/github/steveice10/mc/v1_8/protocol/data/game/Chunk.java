package com.github.steveice10.mc.v1_8.protocol.data.game;

/* loaded from: classes.dex */
public class Chunk {
    private NibbleArray3d blocklight;
    private ShortArray3d blocks;
    private NibbleArray3d skylight;

    public Chunk(boolean z) {
        this(new ShortArray3d(4096), new NibbleArray3d(4096), z ? new NibbleArray3d(4096) : null);
    }

    public Chunk(ShortArray3d shortArray3d, NibbleArray3d nibbleArray3d, NibbleArray3d nibbleArray3d2) {
        this.blocks = shortArray3d;
        this.blocklight = nibbleArray3d;
        this.skylight = nibbleArray3d2;
    }

    public ShortArray3d getBlocks() {
        return this.blocks;
    }

    public NibbleArray3d getBlockLight() {
        return this.blocklight;
    }

    public NibbleArray3d getSkyLight() {
        return this.skylight;
    }

    public boolean isEmpty() {
        for (short s : this.blocks.getData()) {
            if (s != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Chunk chunk = (Chunk) obj;
        if (this.blocklight.equals(chunk.blocklight) && this.blocks.equals(chunk.blocks)) {
            return this.skylight == null ? chunk.skylight == null : this.skylight.equals(chunk.skylight);
        }
        return false;
    }

    public int hashCode() {
        return (((this.blocks.hashCode() * 31) + this.blocklight.hashCode()) * 31) + (this.skylight != null ? this.skylight.hashCode() : 0);
    }
}
