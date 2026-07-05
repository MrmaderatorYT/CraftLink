package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class acj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ach f1834a;

    acj(ach achVar) {
        this.f1834a = achVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1834a.r != null) {
            this.f1834a.r.b();
        }
    }
}
