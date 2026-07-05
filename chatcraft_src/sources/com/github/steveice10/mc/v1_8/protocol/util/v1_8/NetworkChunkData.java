package com.github.steveice10.mc.v1_8.protocol.util.v1_8;

/* loaded from: classes.dex */
public class NetworkChunkData {
    private byte[] data;
    private boolean fullChunk;
    private int mask;
    private boolean sky;

    public NetworkChunkData(int i, boolean z, boolean z2, byte[] bArr) {
        this.mask = i;
        this.fullChunk = z;
        this.sky = z2;
        this.data = bArr;
    }

    public int getMask() {
        return this.mask;
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NetworkChunkData networkChunkData = (NetworkChunkData) obj;
        return this.fullChunk == networkChunkData.fullChunk && this.mask == networkChunkData.mask && this.sky == networkChunkData.sky;
    }

    public int hashCode() {
        return (((this.mask * 31) + (this.fullChunk ? 1 : 0)) * 31) + (this.sky ? 1 : 0);
    }
}
