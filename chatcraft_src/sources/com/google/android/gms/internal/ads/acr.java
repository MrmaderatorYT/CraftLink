package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class acr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ach f1843a;

    acr(ach achVar) {
        this.f1843a = achVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1843a.r != null) {
            this.f1843a.r.d();
        }
    }
}
