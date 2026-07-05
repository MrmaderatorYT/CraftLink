package com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.type.object;

/* loaded from: classes.dex */
public class FallingBlockData implements ObjectData {
    private int id;
    private int metadata;

    public FallingBlockData(int i, int i2) {
        this.id = i;
        this.metadata = i2;
    }

    public int getId() {
        return this.id;
    }

    public int getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FallingBlockData fallingBlockData = (FallingBlockData) obj;
        return this.id == fallingBlockData.id && this.metadata == fallingBlockData.metadata;
    }

    public int hashCode() {
        return (this.id * 31) + this.metadata;
    }
}
