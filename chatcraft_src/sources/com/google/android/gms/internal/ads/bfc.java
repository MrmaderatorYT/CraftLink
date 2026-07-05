package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bfc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f2605a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bab f2606b;
    private final /* synthetic */ int c;
    private final /* synthetic */ Object d;
    private final /* synthetic */ long e;
    private final /* synthetic */ bex f;

    bfc(bex bexVar, int i, bab babVar, int i2, Object obj, long j) {
        this.f = bexVar;
        this.f2605a = i;
        this.f2606b = babVar;
        this.c = i2;
        this.d = obj;
        this.e = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f.f2596b.a(this.f2605a, this.f2606b, this.c, this.d, this.f.b(this.e));
    }
}
