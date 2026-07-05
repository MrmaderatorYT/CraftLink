package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bav implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f2467a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ long f2468b;
    private final /* synthetic */ long c;
    private final /* synthetic */ bar d;

    bav(bar barVar, int i, long j, long j2) {
        this.d = barVar;
        this.f2467a = i;
        this.f2468b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.f2460b.a(this.f2467a, this.f2468b, this.c);
    }
}
