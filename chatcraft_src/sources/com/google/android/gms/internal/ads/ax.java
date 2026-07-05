package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class ax implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ aw f2360a;

    ax(aw awVar) {
        this.f2360a = awVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f2360a.n != null) {
            this.f2360a.n.l();
            this.f2360a.n.k();
            this.f2360a.n.n();
        }
        aw.a(this.f2360a, null);
    }
}
