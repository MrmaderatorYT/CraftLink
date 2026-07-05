package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class ih implements aca<hk> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ip f3166a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ hv f3167b;

    ih(hv hvVar, ip ipVar) {
        this.f3167b = hvVar;
        this.f3166a = ipVar;
    }

    @Override // com.google.android.gms.internal.ads.aca
    public final /* synthetic */ void a(hk hkVar) {
        synchronized (this.f3167b.f3146a) {
            this.f3167b.h = 0;
            if (this.f3167b.g != null && this.f3166a != this.f3167b.g) {
                xe.a("New JS engine is loaded, marking previous one as destroyable.");
                this.f3167b.g.c();
            }
            this.f3167b.g = this.f3166a;
        }
    }
}
