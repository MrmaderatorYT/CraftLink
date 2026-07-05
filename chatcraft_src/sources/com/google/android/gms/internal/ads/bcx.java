package com.google.android.gms.internal.ads;

import com.github.steveice10.mc.v1_5.util.Constants;

/* loaded from: classes.dex */
final class bcx {

    /* renamed from: a, reason: collision with root package name */
    private final bjz f2529a = new bjz(8);

    /* renamed from: b, reason: collision with root package name */
    private int f2530b;

    public final boolean a(bce bceVar) {
        long jC = bceVar.c();
        long j = 1024;
        if (jC != -1 && jC <= 1024) {
            j = jC;
        }
        int i = (int) j;
        bceVar.c(this.f2529a.f2752a, 0, 4);
        long j2 = this.f2529a.j();
        this.f2530b = 4;
        while (j2 != 440786851) {
            int i2 = this.f2530b + 1;
            this.f2530b = i2;
            if (i2 == i) {
                return false;
            }
            bceVar.c(this.f2529a.f2752a, 0, 1);
            j2 = ((j2 << 8) & (-256)) | (this.f2529a.f2752a[0] & Constants.DimensionIds.NETHER);
        }
        long jB = b(bceVar);
        long j3 = this.f2530b;
        if (jB == Long.MIN_VALUE || (jC != -1 && j3 + jB >= jC)) {
            return false;
        }
        while (true) {
            long j4 = j3 + jB;
            if (this.f2530b >= j4) {
                return ((long) this.f2530b) == j4;
            }
            if (b(bceVar) == Long.MIN_VALUE) {
                return false;
            }
            long jB2 = b(bceVar);
            if (jB2 < 0 || jB2 > 2147483647L) {
                break;
            }
            if (jB2 != 0) {
                bceVar.c((int) jB2);
                this.f2530b = (int) (this.f2530b + jB2);
            }
        }
        return false;
    }

    private final long b(bce bceVar) {
        int i = 0;
        bceVar.c(this.f2529a.f2752a, 0, 1);
        int i2 = this.f2529a.f2752a[0] & Constants.DimensionIds.NETHER;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (i3 ^ (-1));
        bceVar.c(this.f2529a.f2752a, 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.f2529a.f2752a[i] & Constants.DimensionIds.NETHER) + (i5 << 8);
        }
        this.f2530b += i4 + 1;
        return i5;
    }
}
