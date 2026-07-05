package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bfi implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bfg f2613a;

    bfi(bfg bfgVar) {
        this.f2613a = bfgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f2613a.H) {
            return;
        }
        this.f2613a.q.a((bfr) this.f2613a);
    }
}
