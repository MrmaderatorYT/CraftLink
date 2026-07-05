package com.github.steveice10.mc.v1_7_7.protocol.util;

/* loaded from: classes.dex */
public class NetworkChunkData {
    private byte[] data;
    private int extendedMask;
    private boolean fullChunk;
    private int mask;
    private boolean sky;

    public NetworkChunkData(int i, int i2, boolean z, boolean z2, byte[] bArr) {
        this.mask = i;
        this.extendedMask = i2;
        this.fullChunk = z;
        this.sky = z2;
        this.data = bArr;
    }

    public int getMask() {
        return this.mask;
    }

    public int getExtendedMask() {
        return this.extendedMask;
    }

    public boolean isFullChunk() {
        return this.fullChunk;
    }

    public boolean hasSkyLight() {
        return this.sky;
    }

    public byte[] getData() {
        return this.data;
    }
}
