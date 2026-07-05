package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bb f2510a;

    bc(bb bbVar) {
        this.f2510a = bbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f2510a.s != null) {
            this.f2510a.s.l();
            this.f2510a.s.k();
            this.f2510a.s.n();
        }
        bb.a(this.f2510a, null);
    }
}
