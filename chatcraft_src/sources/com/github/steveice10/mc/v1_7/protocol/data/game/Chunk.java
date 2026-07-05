package com.github.steveice10.mc.v1_7.protocol.data.game;

/* loaded from: classes.dex */
public class Chunk {
    private NibbleArray3d blocklight;
    private ByteArray3d blocks;
    private NibbleArray3d extendedBlocks;
    private NibbleArray3d metadata;
    private NibbleArray3d skylight;

    public Chunk(boolean z, boolean z2) {
        this(new ByteArray3d(4096), new NibbleArray3d(4096), new NibbleArray3d(4096), z ? new NibbleArray3d(4096) : null, z2 ? new NibbleArray3d(4096) : null);
    }

    public Chunk(ByteArray3d byteArray3d, NibbleArray3d nibbleArray3d, NibbleArray3d nibbleArray3d2, NibbleArray3d nibbleArray3d3, NibbleArray3d nibbleArray3d4) {
        this.blocks = byteArray3d;
        this.metadata = nibbleArray3d;
        this.blocklight = nibbleArray3d2;
        this.skylight = nibbleArray3d3;
        this.extendedBlocks = nibbleArray3d4;
    }

    public ByteArray3d getBlocks() {
        return this.blocks;
    }

    public NibbleArray3d getMetadata() {
        return this.metadata;
    }

    public NibbleArray3d getBlockLight() {
        return this.blocklight;
    }

    public NibbleArray3d getSkyLight() {
        return this.skylight;
    }

    public NibbleArray3d getExtendedBlocks() {
        return this.extendedBlocks;
    }

    public void deleteExtendedBlocks() {
        this.extendedBlocks = null;
    }

    public boolean isEmpty() {
        for (byte b2 : this.blocks.getData()) {
            if (b2 != 0) {
                return false;
            }
        }
        return true;
    }
}
