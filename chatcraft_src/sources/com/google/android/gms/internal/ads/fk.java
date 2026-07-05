package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class fk extends bri {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ fj f3084a;

    fk(fj fjVar) {
        this.f3084a = fjVar;
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void a() {
        this.f3084a.f3083a.add(new fl(this));
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void a(int i) {
        this.f3084a.f3083a.add(new fm(this, i));
        xe.a("Pooled interstitial failed to load.");
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void b() {
        this.f3084a.f3083a.add(new fn(this));
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void c() {
        this.f3084a.f3083a.add(new fo(this));
        xe.a("Pooled interstitial loaded.");
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void d() {
        this.f3084a.f3083a.add(new fp(this));
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void e() {
        this.f3084a.f3083a.add(new fq(this));
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void f() {
        this.f3084a.f3083a.add(new fr(this));
    }
}
