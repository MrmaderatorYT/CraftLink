package com.github.steveice10.mc.v1_9_2.protocol.data.game.chunk;

import java.util.Arrays;

/* loaded from: classes.dex */
public class FlexibleStorage {
    private final int bitsPerEntry;
    private final long[] data;
    private final long maxEntryValue;
    private final int size;

    public FlexibleStorage(int i, int i2) {
        this(i, new long[roundToNearest(i2 * i, 64) / 64]);
    }

    public FlexibleStorage(int i, long[] jArr) {
        if (i < 1 || i > 32) {
            throw new IllegalArgumentException("BitsPerEntry cannot be outside of accepted range.");
        }
        this.bitsPerEntry = i;
        this.data = jArr;
        this.size = (this.data.length * 64) / this.bitsPerEntry;
        this.maxEntryValue = (1 << this.bitsPerEntry) - 1;
    }

    private static int roundToNearest(int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i == 0) {
            return i2;
        }
        if (i < 0) {
            i2 *= -1;
        }
        int i3 = i % i2;
        return i3 != 0 ? (i + i2) - i3 : i;
    }

    public long[] getData() {
        return this.data;
    }

    public int getBitsPerEntry() {
        return this.bitsPerEntry;
    }

    public int getSize() {
        return this.size;
    }

    public int get(int i) {
        if (i < 0 || i > this.size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int i2 = this.bitsPerEntry * i;
        int i3 = i2 / 64;
        int i4 = (((i + 1) * this.bitsPerEntry) - 1) / 64;
        int i5 = i2 % 64;
        if (i3 == i4) {
            return (int) ((this.data[i3] >>> i5) & this.maxEntryValue);
        }
        return (int) (((this.data[i3] >>> i5) | (this.data[i4] << (64 - i5))) & this.maxEntryValue);
    }

    public void set(int i, int i2) {
        if (i < 0 || i > this.size - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 >= 0) {
            long j = i2;
            if (j <= this.maxEntryValue) {
                int i3 = this.bitsPerEntry * i;
                int i4 = i3 / 64;
                int i5 = (((i + 1) * this.bitsPerEntry) - 1) / 64;
                int i6 = i3 % 64;
                this.data[i4] = (this.data[i4] & ((this.maxEntryValue << i6) ^ (-1))) | ((this.maxEntryValue & j) << i6);
                if (i4 != i5) {
                    int i7 = 64 - i6;
                    this.data[i5] = ((j & this.maxEntryValue) >> i7) | ((this.data[i5] >>> i7) << i7);
                    return;
                }
                return;
            }
        }
        throw new IllegalArgumentException("Value cannot be outside of accepted range.");
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FlexibleStorage) {
                FlexibleStorage flexibleStorage = (FlexibleStorage) obj;
                if (!Arrays.equals(this.data, flexibleStorage.data) || this.bitsPerEntry != flexibleStorage.bitsPerEntry || this.size != flexibleStorage.size || this.maxEntryValue != flexibleStorage.maxEntryValue) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((Arrays.hashCode(this.data) * 31) + this.bitsPerEntry) * 31) + this.size) * 31) + ((int) this.maxEntryValue);
    }
}
