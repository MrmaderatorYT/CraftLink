package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bau implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bab f2465a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bar f2466b;

    bau(bar barVar, bab babVar) {
        this.f2466b = barVar;
        this.f2465a = babVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2466b.f2460b.a(this.f2465a);
    }
}
