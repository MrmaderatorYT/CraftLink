package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class mr implements com.google.android.gms.ads.internal.overlay.n {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzanu f3274a;

    mr(zzanu zzanuVar) {
        this.f3274a = zzanuVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.n
    public final void p_() {
        aan.b("AdMobCustomTabsAdapter overlay is closed.");
        this.f3274a.f3656b.c(this.f3274a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.n
    public final void d() {
        aan.b("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.n
    public final void f() {
        aan.b("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.n
    public final void g() {
        aan.b("Opening AdMobCustomTabsAdapter overlay.");
        this.f3274a.f3656b.b(this.f3274a);
    }
}
