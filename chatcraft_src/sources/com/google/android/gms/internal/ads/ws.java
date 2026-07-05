package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class ws {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3557a;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f3558b;
    private volatile long c;

    private ws() {
        this.f3557a = new Object();
        this.f3558b = wt.f3559a;
        this.c = 0L;
    }

    private final void a(int i, int i2) {
        d();
        long jA = com.google.android.gms.ads.internal.ax.l().a();
        synchronized (this.f3557a) {
            if (this.f3558b != i) {
                return;
            }
            this.f3558b = i2;
            if (this.f3558b == wt.c) {
                this.c = jA;
            }
        }
    }

    private final void d() {
        long jA = com.google.android.gms.ads.internal.ax.l().a();
        synchronized (this.f3557a) {
            if (this.f3558b == wt.c) {
                if (this.c + ((Long) bra.e().a(o.cI)).longValue() <= jA) {
                    this.f3558b = wt.f3559a;
                }
            }
        }
    }

    public final void a(boolean z) {
        if (z) {
            a(wt.f3559a, wt.f3560b);
        } else {
            a(wt.f3560b, wt.f3559a);
        }
    }

    public final boolean a() {
        d();
        return this.f3558b == wt.f3560b;
    }

    public final boolean b() {
        d();
        return this.f3558b == wt.c;
    }

    public final void c() {
        a(wt.f3560b, wt.c);
    }

    /* synthetic */ ws(wr wrVar) {
        this();
    }
}
