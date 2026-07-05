package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class acp implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ach f1841a;

    acp(ach achVar) {
        this.f1841a = achVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1841a.r != null) {
            this.f1841a.r.d();
            this.f1841a.r.f();
        }
    }
}
