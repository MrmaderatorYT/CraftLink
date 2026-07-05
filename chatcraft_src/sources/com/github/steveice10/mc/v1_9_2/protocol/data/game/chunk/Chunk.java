package com.github.steveice10.mc.v1_9_2.protocol.data.game.chunk;

/* loaded from: classes.dex */
public class Chunk {
    private NibbleArray3d blocklight;
    private BlockStorage blocks;
    private NibbleArray3d skylight;

    public Chunk(boolean z) {
        this(new BlockStorage(), new NibbleArray3d(4096), z ? new NibbleArray3d(4096) : null);
    }

    public Chunk(BlockStorage blockStorage, NibbleArray3d nibbleArray3d, NibbleArray3d nibbleArray3d2) {
        this.blocks = blockStorage;
        this.blocklight = nibbleArray3d;
        this.skylight = nibbleArray3d2;
    }

    public BlockStorage getBlocks() {
        return this.blocks;
    }

    public NibbleArray3d getBlockLight() {
        return this.blocklight;
    }

    public NibbleArray3d getSkyLight() {
        return this.skylight;
    }

    public boolean isEmpty() {
        return this.blocks.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Chunk) {
                Chunk chunk = (Chunk) obj;
                if (!this.blocks.equals(chunk.blocks) || !this.blocklight.equals(chunk.blocklight) || ((this.skylight != null || chunk.skylight != null) && (this.skylight == null || !this.skylight.equals(chunk.skylight)))) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.blocks.hashCode() * 31) + this.blocklight.hashCode()) * 31) + (this.skylight != null ? this.skylight.hashCode() : 0);
    }
}
