package com.github.steveice10.mc.v1_8.protocol.data.game;

/* loaded from: classes.dex */
public class Position {
    private int x;
    private int y;
    private int z;

    public Position(int i, int i2, int i3) {
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
        Position position = (Position) obj;
        return this.x == position.x && this.y == position.y && this.z == position.z;
    }

    public int hashCode() {
        return (((this.x * 31) + this.y) * 31) + this.z;
    }
}
