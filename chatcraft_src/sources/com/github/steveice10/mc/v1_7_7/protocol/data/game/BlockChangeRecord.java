package com.github.steveice10.mc.v1_7_7.protocol.data.game;

/* loaded from: classes.dex */
public class BlockChangeRecord {
    private int id;
    private int metadata;
    private int x;
    private int y;
    private int z;

    public BlockChangeRecord(int i, int i2, int i3, int i4, int i5) {
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.id = i4;
        this.metadata = i5;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public int getId() {
        return this.id;
    }

    public int getMetadata() {
        return this.metadata;
    }
}
