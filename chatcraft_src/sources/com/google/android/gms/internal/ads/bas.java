package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bas implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bbr f2461a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bar f2462b;

    bas(bar barVar, bbr bbrVar) {
        this.f2462b = barVar;
        this.f2461a = bbrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2462b.f2460b.a(this.f2461a);
    }
}
