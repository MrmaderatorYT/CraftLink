package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class ib implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final hk f3156a;

    private ib(hk hkVar) {
        this.f3156a = hkVar;
    }

    static Runnable a(hk hkVar) {
        return new ib(hkVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3156a.a();
    }
}
