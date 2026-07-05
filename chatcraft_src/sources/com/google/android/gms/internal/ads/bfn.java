package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bfn implements bfz {

    /* renamed from: a, reason: collision with root package name */
    private final int f2622a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bfg f2623b;

    public bfn(bfg bfgVar, int i) {
        this.f2623b = bfgVar;
        this.f2622a = i;
    }

    @Override // com.google.android.gms.internal.ads.bfz
    public final boolean a() {
        return this.f2623b.a(this.f2622a);
    }

    @Override // com.google.android.gms.internal.ads.bfz
    public final void b() {
        this.f2623b.g();
    }

    @Override // com.google.android.gms.internal.ads.bfz
    public final int a(bad badVar, bbs bbsVar, boolean z) {
        return this.f2623b.a(this.f2622a, badVar, bbsVar, z);
    }

    @Override // com.google.android.gms.internal.ads.bfz
    public final void a_(long j) {
        this.f2623b.a(this.f2622a, j);
    }
}
