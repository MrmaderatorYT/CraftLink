package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class oh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ wk f3314a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ of f3315b;

    oh(of ofVar, wk wkVar) {
        this.f3315b = ofVar;
        this.f3314a = wkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f3315b.c) {
            of ofVar = this.f3315b;
            ofVar.f3311a.b(this.f3314a);
        }
    }
}
