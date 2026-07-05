package com.github.steveice10.mc.v1_9.protocol.data.game.entity.type.object;

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
        return this == obj || ((obj instanceof ProjectileData) && this.ownerId == ((ProjectileData) obj).ownerId);
    }

    public int hashCode() {
        return this.ownerId;
    }
}
