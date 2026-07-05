package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class ii implements aby {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ip f3168a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ hv f3169b;

    ii(hv hvVar, ip ipVar) {
        this.f3169b = hvVar;
        this.f3168a = ipVar;
    }

    @Override // com.google.android.gms.internal.ads.aby
    public final void a() {
        synchronized (this.f3169b.f3146a) {
            this.f3169b.h = 1;
            xe.a("Failed loading new engine. Marking new engine destroyable.");
            this.f3168a.c();
        }
    }
}
