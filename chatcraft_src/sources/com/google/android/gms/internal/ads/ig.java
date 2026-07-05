package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class ig implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final hk f3165a;

    private ig(hk hkVar) {
        this.f3165a = hkVar;
    }

    static Runnable a(hk hkVar) {
        return new ig(hkVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3165a.a();
    }
}
