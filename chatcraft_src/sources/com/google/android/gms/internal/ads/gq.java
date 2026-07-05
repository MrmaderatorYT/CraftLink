package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class gq {

    /* renamed from: a, reason: collision with root package name */
    com.google.android.gms.ads.internal.m f3107a;

    /* renamed from: b, reason: collision with root package name */
    bqj f3108b;
    fj c;
    long d;
    boolean e;
    boolean f;
    private final /* synthetic */ gp g;

    gq(gp gpVar, fi fiVar) {
        this.g = gpVar;
        this.f3107a = fiVar.b(gpVar.c);
        this.c = new fj();
        fj fjVar = this.c;
        com.google.android.gms.ads.internal.m mVar = this.f3107a;
        mVar.a((brh) new fk(fjVar));
        mVar.a((bsa) new fs(fjVar));
        mVar.a((ai) new fu(fjVar));
        mVar.a((brd) new fw(fjVar));
        mVar.a((ue) new fy(fjVar));
    }

    gq(gp gpVar, fi fiVar, bqj bqjVar) {
        this(gpVar, fiVar);
        this.f3108b = bqjVar;
    }

    final boolean a() {
        if (this.e) {
            return false;
        }
        this.f = this.f3107a.b(gn.b(this.f3108b != null ? this.f3108b : this.g.f3106b));
        this.e = true;
        this.d = com.google.android.gms.ads.internal.ax.l().a();
        return true;
    }
}
