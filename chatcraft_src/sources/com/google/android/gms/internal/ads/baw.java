package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class baw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bbr f2469a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bar f2470b;

    baw(bar barVar, bbr bbrVar) {
        this.f2470b = barVar;
        this.f2469a = bbrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2469a.a();
        this.f2470b.f2460b.b(this.f2469a);
    }
}
