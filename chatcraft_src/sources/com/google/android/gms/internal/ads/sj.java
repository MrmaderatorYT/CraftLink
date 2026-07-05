package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class sj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ se f3447a;

    sj(se seVar) {
        this.f3447a = seVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3447a.l != null) {
            this.f3447a.l.a();
            this.f3447a.l = null;
        }
    }
}
