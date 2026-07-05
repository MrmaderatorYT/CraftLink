package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class av implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ au f2302a;

    av(au auVar) {
        this.f2302a = auVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f2302a.p != null) {
            this.f2302a.p.l();
            this.f2302a.p.k();
            this.f2302a.p.n();
        }
        au.a(this.f2302a, null);
    }
}
