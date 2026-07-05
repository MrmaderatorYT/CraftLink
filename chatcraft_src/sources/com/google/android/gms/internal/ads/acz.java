package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class acz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ acv f1852a;

    acz(acv acvVar) {
        this.f1852a = acvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1852a.a("surfaceDestroyed", new String[0]);
    }
}
