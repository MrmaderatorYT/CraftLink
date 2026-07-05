package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bdh implements bdf {

    /* renamed from: a, reason: collision with root package name */
    private final int f2542a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2543b;
    private final bjz c;

    public bdh(bdb bdbVar) {
        this.c = bdbVar.aP;
        this.c.c(12);
        this.f2542a = this.c.o();
        this.f2543b = this.c.o();
    }

    @Override // com.google.android.gms.internal.ads.bdf
    public final int a() {
        return this.f2543b;
    }

    @Override // com.google.android.gms.internal.ads.bdf
    public final int b() {
        return this.f2542a == 0 ? this.c.o() : this.f2542a;
    }

    @Override // com.google.android.gms.internal.ads.bdf
    public final boolean c() {
        return this.f2542a != 0;
    }
}
