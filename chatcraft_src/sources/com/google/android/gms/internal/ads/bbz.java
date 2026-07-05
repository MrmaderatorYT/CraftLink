package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class bbz implements bck {

    /* renamed from: a, reason: collision with root package name */
    public final int f2508a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f2509b;
    public final long[] c;
    public final long[] d;
    public final long[] e;
    private final long f;

    public bbz(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f2509b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        this.f2508a = iArr.length;
        if (this.f2508a > 0) {
            this.f = jArr2[this.f2508a - 1] + jArr3[this.f2508a - 1];
        } else {
            this.f = 0L;
        }
    }

    @Override // com.google.android.gms.internal.ads.bck
    public final boolean a() {
        return true;
    }

    public final int a(long j) {
        return bkg.a(this.e, j, true, true);
    }

    @Override // com.google.android.gms.internal.ads.bck
    public final long b() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.bck
    public final long b(long j) {
        return this.c[a(j)];
    }
}
