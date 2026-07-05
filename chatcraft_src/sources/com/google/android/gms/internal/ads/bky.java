package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bky implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bbr f2783a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bkx f2784b;

    bky(bkx bkxVar, bbr bbrVar) {
        this.f2784b = bkxVar;
        this.f2783a = bbrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2784b.f2782b.a(this.f2783a);
    }
}
