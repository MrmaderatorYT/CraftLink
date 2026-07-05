package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bee implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final blc f2579a;

    /* renamed from: b, reason: collision with root package name */
    private final brg f2580b;
    private final Runnable c;

    public bee(blc blcVar, brg brgVar, Runnable runnable) {
        this.f2579a = blcVar;
        this.f2580b = brgVar;
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2579a.h();
        if (this.f2580b.c == null) {
            this.f2579a.a((blc) this.f2580b.f3003a);
        } else {
            this.f2579a.a(this.f2580b.c);
        }
        if (this.f2580b.d) {
            this.f2579a.b("intermediate-response");
        } else {
            this.f2579a.c("done");
        }
        if (this.c != null) {
            this.c.run();
        }
    }
}
