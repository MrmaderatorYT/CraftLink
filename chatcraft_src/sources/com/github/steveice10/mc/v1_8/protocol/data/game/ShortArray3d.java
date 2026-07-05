package com.github.steveice10.mc.v1_8.protocol.data.game;

import java.util.Arrays;

/* loaded from: classes.dex */
public class ShortArray3d {
    private short[] data;

    public ShortArray3d(int i) {
        this.data = new short[i];
    }

    public ShortArray3d(short[] sArr) {
        this.data = sArr;
    }

    public short[] getData() {
        return this.data;
    }

    public int get(int i, int i2, int i3) {
        return this.data[i | (i2 << 8) | (i3 << 4)] & 65535;
    }

    public void set(int i, int i2, int i3, int i4) {
        this.data[i | (i2 << 8) | (i3 << 4)] = (short) i4;
    }

    public int getBlock(int i, int i2, int i3) {
        return get(i, i2, i3) >> 4;
    }

    public void setBlock(int i, int i2, int i3, int i4) {
        set(i, i2, i3, (i4 << 4) | getData(i, i2, i3));
    }

    public int getData(int i, int i2, int i3) {
        return get(i, i2, i3) & 15;
    }

    public void setData(int i, int i2, int i3, int i4) {
        set(i, i2, i3, i4 | (getBlock(i, i2, i3) << 4));
    }

    public void setBlockAndData(int i, int i2, int i3, int i4, int i5) {
        set(i, i2, i3, (i4 << 4) | i5);
    }

    public void fill(int i) {
        Arrays.fill(this.data, (short) i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Arrays.equals(this.data, ((ShortArray3d) obj).data);
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }
}
