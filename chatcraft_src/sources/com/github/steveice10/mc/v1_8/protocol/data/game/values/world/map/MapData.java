package com.github.steveice10.mc.v1_8.protocol.data.game.values.world.map;

import java.util.Arrays;

/* loaded from: classes.dex */
public class MapData {
    private int columns;
    private byte[] data;
    private int rows;
    private int x;
    private int y;

    public MapData(int i, int i2, int i3, int i4, byte[] bArr) {
        this.columns = i;
        this.rows = i2;
        this.x = i3;
        this.y = i4;
        this.data = bArr;
    }

    public int getColumns() {
        return this.columns;
    }

    public int getRows() {
        return this.rows;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public byte[] getData() {
        return this.data;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MapData mapData = (MapData) obj;
        return this.columns == mapData.columns && this.rows == mapData.rows && this.x == mapData.x && this.y == mapData.y && Arrays.equals(this.data, mapData.data);
    }

    public int hashCode() {
        return (((((((this.columns * 31) + this.rows) * 31) + this.x) * 31) + this.y) * 31) + Arrays.hashCode(this.data);
    }
}
