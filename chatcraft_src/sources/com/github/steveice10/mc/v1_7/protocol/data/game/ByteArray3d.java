package com.github.steveice10.mc.v1_7.protocol.data.game;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ByteArray3d {
    private byte[] data;

    public ByteArray3d(int i) {
        this.data = new byte[i];
    }

    public ByteArray3d(byte[] bArr) {
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    public int get(int i, int i2, int i3) {
        return this.data[i | (i2 << 8) | (i3 << 4)] & Constants.DimensionIds.NETHER;
    }

    public void set(int i, int i2, int i3, int i4) {
        this.data[i | (i2 << 8) | (i3 << 4)] = (byte) i4;
    }

    public void fill(int i) {
        Arrays.fill(this.data, (byte) i);
    }
}
