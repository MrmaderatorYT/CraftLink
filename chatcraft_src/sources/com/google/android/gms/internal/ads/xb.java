package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class xb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ xa f3572a;

    xb(xa xaVar) {
        this.f3572a = xaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3572a.f3571b = Thread.currentThread();
        this.f3572a.a();
    }
}
