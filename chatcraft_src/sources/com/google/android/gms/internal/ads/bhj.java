package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class bhj implements bhi {

    /* renamed from: a, reason: collision with root package name */
    private final bbz f2668a;

    public bhj(bbz bbzVar) {
        this.f2668a = bbzVar;
    }

    @Override // com.google.android.gms.internal.ads.bhi
    public final int a() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.bhi
    public final boolean b() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.bhi
    public final int a(long j) {
        return this.f2668a.f2508a;
    }

    @Override // com.google.android.gms.internal.ads.bhi
    public final long a(int i) {
        return this.f2668a.e[i];
    }

    @Override // com.google.android.gms.internal.ads.bhi
    public final long a(int i, long j) {
        return this.f2668a.d[i];
    }

    @Override // com.google.android.gms.internal.ads.bhi
    public final bht b(int i) {
        return new bht(null, this.f2668a.c[i], this.f2668a.f2509b[i]);
    }

    @Override // com.google.android.gms.internal.ads.bhi
    public final int a(long j, long j2) {
        return this.f2668a.a(j);
    }
}
