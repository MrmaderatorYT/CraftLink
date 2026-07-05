package com.google.android.gms.internal.ads;

@qj
/* loaded from: classes.dex */
final class adn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private acv f1870a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1871b = false;

    adn(acv acvVar) {
        this.f1870a = acvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1871b) {
            return;
        }
        this.f1870a.o();
        c();
    }

    public final void a() {
        this.f1871b = true;
        this.f1870a.o();
    }

    public final void b() {
        this.f1871b = false;
        c();
    }

    private final void c() {
        xn.f3583a.removeCallbacks(this);
        xn.f3583a.postDelayed(this, 250L);
    }
}
