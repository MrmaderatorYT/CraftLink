package com.github.steveice10.mc.v1_10.protocol.data.game.world.map;

/* loaded from: classes.dex */
public class MapIcon {
    private int centerX;
    private int centerZ;
    private int iconRotation;
    private MapIconType iconType;

    public MapIcon(int i, int i2, MapIconType mapIconType, int i3) {
        this.centerX = i;
        this.centerZ = i2;
        this.iconType = mapIconType;
        this.iconRotation = i3;
    }

    public int getCenterX() {
        return this.centerX;
    }

    public int getCenterZ() {
        return this.centerZ;
    }

    public MapIconType getIconType() {
        return this.iconType;
    }

    public int getIconRotation() {
        return this.iconRotation;
    }

    public boolean equals(Object obj) {
        if (obj instanceof MapIcon) {
            MapIcon mapIcon = (MapIcon) obj;
            if (this.centerX == mapIcon.centerX && this.centerZ == mapIcon.centerZ && this.iconType == mapIcon.iconType && this.iconRotation == mapIcon.iconRotation) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((this.centerX * 31) + this.centerZ) * 31) + this.iconRotation) * 31) + (this.iconType != null ? this.iconType.hashCode() : 0);
    }
}
