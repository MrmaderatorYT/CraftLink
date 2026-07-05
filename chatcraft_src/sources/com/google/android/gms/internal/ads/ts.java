package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class ts implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ wl f3484a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ tq f3485b;

    ts(tq tqVar, wl wlVar) {
        this.f3485b = tqVar;
        this.f3484a = wlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3485b.b(new wk(this.f3484a, null, null, null, null, null, null, null));
    }
}
