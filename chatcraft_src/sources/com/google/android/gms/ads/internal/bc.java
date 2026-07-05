package com.google.android.gms.ads.internal;

/* loaded from: classes.dex */
final /* synthetic */ class bc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final an f1543a;

    private bc(an anVar) {
        this.f1543a = anVar;
    }

    static Runnable a(an anVar) {
        return new bc(anVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1543a.c();
    }
}
