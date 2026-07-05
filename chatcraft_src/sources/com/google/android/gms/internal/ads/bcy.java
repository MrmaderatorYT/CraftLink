package com.google.android.gms.internal.ads;

import com.github.steveice10.mc.v1_5.util.Constants;

/* loaded from: classes.dex */
final class bcy {

    /* renamed from: a, reason: collision with root package name */
    private static final long[] f2531a = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f2532b = new byte[8];
    private int c;
    private int d;

    public final void a() {
        this.c = 0;
        this.d = 0;
    }

    public final long a(bce bceVar, boolean z, boolean z2, int i) {
        if (this.c == 0) {
            if (!bceVar.a(this.f2532b, 0, 1, z)) {
                return -1L;
            }
            this.d = a(this.f2532b[0] & Constants.DimensionIds.NETHER);
            if (this.d == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.c = 1;
        }
        if (this.d > i) {
            this.c = 0;
            return -2L;
        }
        if (this.d != 1) {
            bceVar.b(this.f2532b, 1, this.d - 1);
        }
        this.c = 0;
        return a(this.f2532b, this.d, z2);
    }

    public final int b() {
        return this.d;
    }

    public static int a(int i) {
        for (int i2 = 0; i2 < f2531a.length; i2++) {
            if ((f2531a[i2] & i) != 0) {
                return i2 + 1;
            }
        }
        return -1;
    }

    public static long a(byte[] bArr, int i, boolean z) {
        long j = bArr[0] & 255;
        if (z) {
            j &= f2531a[i - 1] ^ (-1);
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (bArr[i2] & 255);
        }
        return j;
    }
}
