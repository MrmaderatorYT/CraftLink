package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bax implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f2471a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bar f2472b;

    bax(bar barVar, int i) {
        this.f2472b = barVar;
        this.f2471a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2472b.f2460b.a(this.f2471a);
    }
}
