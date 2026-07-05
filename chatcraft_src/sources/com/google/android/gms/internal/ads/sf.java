package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class sf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ wl f3441a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ se f3442b;

    sf(se seVar, wl wlVar) {
        this.f3442b = seVar;
        this.f3441a = wlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3442b.h.a(this.f3441a);
        if (this.f3442b.l != null) {
            this.f3442b.l.a();
            this.f3442b.l = null;
        }
    }
}
