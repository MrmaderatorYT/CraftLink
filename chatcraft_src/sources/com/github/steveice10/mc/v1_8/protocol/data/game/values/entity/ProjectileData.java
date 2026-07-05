package com.github.steveice10.mc.v1_8.protocol.data.game.values.entity;

/* loaded from: classes.dex */
public class ProjectileData implements ObjectData {
    private int ownerId;

    public ProjectileData(int i) {
        this.ownerId = i;
    }

    public int getOwnerId() {
        return this.ownerId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.ownerId == ((ProjectileData) obj).ownerId;
    }

    public int hashCode() {
        return this.ownerId;
    }
}
