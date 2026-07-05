package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class afz implements com.google.android.gms.ads.internal.overlay.n {

    /* renamed from: a, reason: collision with root package name */
    private afu f1948a;

    /* renamed from: b, reason: collision with root package name */
    private com.google.android.gms.ads.internal.overlay.n f1949b;

    public afz(afu afuVar, com.google.android.gms.ads.internal.overlay.n nVar) {
        this.f1948a = afuVar;
        this.f1949b = nVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.n
    public final void d() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.n
    public final void f() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.n
    public final void g() {
        this.f1949b.g();
        this.f1948a.p();
    }

    @Override // com.google.android.gms.ads.internal.overlay.n
    public final void p_() {
        this.f1949b.p_();
        this.f1948a.o();
    }
}
