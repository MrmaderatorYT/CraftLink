package com.google.android.gms.ads.internal;

/* loaded from: classes.dex */
final /* synthetic */ class bb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final an f1542a;

    private bb(an anVar) {
        this.f1542a = anVar;
    }

    static Runnable a(an anVar) {
        return new bb(anVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1542a.b();
    }
}
