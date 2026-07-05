package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class ahm implements com.google.android.gms.ads.internal.overlay.n {

    /* renamed from: a, reason: collision with root package name */
    private afu f1986a;

    /* renamed from: b, reason: collision with root package name */
    private com.google.android.gms.ads.internal.overlay.n f1987b;

    public ahm(afu afuVar, com.google.android.gms.ads.internal.overlay.n nVar) {
        this.f1986a = afuVar;
        this.f1987b = nVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.n
    public final void d() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.n
    public final void f() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.n
    public final void g() {
        this.f1987b.g();
        this.f1986a.p();
    }

    @Override // com.google.android.gms.ads.internal.overlay.n
    public final void p_() {
        this.f1987b.p_();
        this.f1986a.o();
    }
}
