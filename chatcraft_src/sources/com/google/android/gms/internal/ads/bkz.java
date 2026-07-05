package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bkz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2785a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ long f2786b;
    private final /* synthetic */ long c;
    private final /* synthetic */ bkx d;

    bkz(bkx bkxVar, String str, long j, long j2) {
        this.d = bkxVar;
        this.f2785a = str;
        this.f2786b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.f2782b.a(this.f2785a, this.f2786b, this.c);
    }
}
