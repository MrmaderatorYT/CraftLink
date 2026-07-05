package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bmd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2831a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ long f2832b;
    private final /* synthetic */ blc c;

    bmd(blc blcVar, String str, long j) {
        this.c = blcVar;
        this.f2831a = str;
        this.f2832b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.f2793a.a(this.f2831a, this.f2832b);
        this.c.f2793a.a(this.c.toString());
    }
}
