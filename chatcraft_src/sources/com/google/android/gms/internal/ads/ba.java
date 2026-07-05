package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class ba implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ay f2439a;

    ba(ay ayVar) {
        this.f2439a = ayVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f2439a.h != null) {
            this.f2439a.h.l();
            this.f2439a.h.k();
        }
        ay.a(this.f2439a, null);
    }
}
