package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class acq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ach f1842a;

    acq(ach achVar) {
        this.f1842a = achVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1842a.r != null) {
            this.f1842a.r.c();
        }
    }
}
