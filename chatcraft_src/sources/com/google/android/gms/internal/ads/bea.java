package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bea {

    /* renamed from: a, reason: collision with root package name */
    public final int f2571a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f2572b;
    public final int[] c;
    public final int d;
    public final long[] e;
    public final int[] f;

    public bea(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        bjq.a(iArr.length == jArr2.length);
        bjq.a(jArr.length == jArr2.length);
        bjq.a(iArr2.length == jArr2.length);
        this.f2572b = jArr;
        this.c = iArr;
        this.d = i;
        this.e = jArr2;
        this.f = iArr2;
        this.f2571a = jArr.length;
    }

    public final int a(long j) {
        for (int iA = bkg.a(this.e, j, true, false); iA >= 0; iA--) {
            if ((this.f[iA] & 1) != 0) {
                return iA;
            }
        }
        return -1;
    }

    public final int b(long j) {
        for (int iB = bkg.b(this.e, j, true, false); iB < this.e.length; iB++) {
            if ((this.f[iB] & 1) != 0) {
                return iB;
            }
        }
        return -1;
    }
}
