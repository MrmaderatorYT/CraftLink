package com.github.steveice10.mc.v1_8.protocol.data.game.values.world.block;

/* loaded from: classes.dex */
public class ExplodedBlockRecord {
    private int x;
    private int y;
    private int z;

    public ExplodedBlockRecord(int i, int i2, int i3) {
        this.x = i;
        this.y = i2;
        this.z = i3;
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExplodedBlockRecord explodedBlockRecord = (ExplodedBlockRecord) obj;
        return this.x == explodedBlockRecord.x && this.y == explodedBlockRecord.y && this.z == explodedBlockRecord.z;
    }

    public int hashCode() {
        return (((this.x * 31) + this.y) * 31) + this.z;
    }
}
