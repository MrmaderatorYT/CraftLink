package com.github.steveice10.mc.v1_9.protocol.data.game.entity.metadata;

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
        if (this != obj) {
            if (obj instanceof Position) {
                Position position = (Position) obj;
                if (this.x != position.x || this.y != position.y || this.z != position.z) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.x * 31) + this.y) * 31) + this.z;
    }
}
