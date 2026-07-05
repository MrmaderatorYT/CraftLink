package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class bgo implements bfz {

    /* renamed from: a, reason: collision with root package name */
    public final bgn<T> f2651a;

    /* renamed from: b, reason: collision with root package name */
    private final bfw f2652b;
    private final int c;
    private final /* synthetic */ bgn d;

    public bgo(bgn bgnVar, bgn<T> bgnVar2, bfw bfwVar, int i) {
        this.d = bgnVar;
        this.f2651a = bgnVar2;
        this.f2652b = bfwVar;
        this.c = i;
    }

    @Override // com.google.android.gms.internal.ads.bfz
    public final void b() {
    }

    @Override // com.google.android.gms.internal.ads.bfz
    public final boolean a() {
        if (this.d.f2650b) {
            return true;
        }
        return !this.d.f() && this.f2652b.c();
    }

    @Override // com.google.android.gms.internal.ads.bfz
    public final void a_(long j) {
        if (this.d.f2650b && j > this.f2652b.f()) {
            this.f2652b.g();
        } else {
            this.f2652b.a(j, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.bfz
    public final int a(bad badVar, bbs bbsVar, boolean z) {
        if (this.d.f()) {
            return -3;
        }
        return this.f2652b.a(badVar, bbsVar, z, this.d.f2650b, this.d.f2649a);
    }

    public final void c() {
        bjq.b(this.d.e[this.c]);
        this.d.e[this.c] = false;
    }
}
