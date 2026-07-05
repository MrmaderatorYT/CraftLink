package com.github.steveice10.mc.v1_9_4.protocol.data.game.world.map;

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
        if (obj instanceof MapPlayer) {
            MapPlayer mapPlayer = (MapPlayer) obj;
            if (this.centerX == mapPlayer.centerX && this.centerZ == mapPlayer.centerZ && this.iconSize == mapPlayer.iconSize && this.iconRotation == mapPlayer.iconRotation) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((this.centerX * 31) + this.centerZ) * 31) + this.iconRotation) * 31) + this.iconSize;
    }
}
