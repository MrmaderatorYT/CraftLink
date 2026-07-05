package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class oe implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ od f3310a;

    oe(od odVar) {
        this.f3310a = odVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3310a.h.get()) {
            xe.c("Timed out waiting for WebView to finish loading.");
            this.f3310a.b();
        }
    }
}
