package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bat implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2463a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ long f2464b;
    private final /* synthetic */ long c;
    private final /* synthetic */ bar d;

    bat(bar barVar, String str, long j, long j2) {
        this.d = barVar;
        this.f2463a = str;
        this.f2464b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.f2460b.a(this.f2463a, this.f2464b, this.c);
    }
}
