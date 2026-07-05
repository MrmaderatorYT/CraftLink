package com.github.steveice10.mc.v1_8.protocol.data.game.values.world.map;

/* loaded from: classes.dex */
public class MapPlayer {
    private int centerX;
    private int centerZ;
    private int iconRotation;
    private int iconSize;

    public MapPlayer(int i, int i2, int i3, int i4) {
        this.centerX = i;
        this.centerZ = i2;
        this.iconSize = i3;
        this.iconRotation = i4;
    }

    public int getCenterX() {
        return this.centerX;
    }

    public int getCenterZ() {
        return this.centerZ;
    }

    public int getIconSize() {
        return this.iconSize;
    }

    public int getIconRotation() {
        return this.iconRotation;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MapPlayer mapPlayer = (MapPlayer) obj;
        return this.centerX == mapPlayer.centerX && this.centerZ == mapPlayer.centerZ && this.iconRotation == mapPlayer.iconRotation && this.iconSize == mapPlayer.iconSize;
    }

    public int hashCode() {
        return (((((this.centerX * 31) + this.centerZ) * 31) + this.iconSize) * 31) + this.iconRotation;
    }
}
