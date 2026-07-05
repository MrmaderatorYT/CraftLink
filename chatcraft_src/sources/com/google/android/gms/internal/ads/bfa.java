package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bfa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bjd f2601a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ int f2602b;
    private final /* synthetic */ int c;
    private final /* synthetic */ bab d;
    private final /* synthetic */ int e;
    private final /* synthetic */ Object f;
    private final /* synthetic */ long g;
    private final /* synthetic */ long h;
    private final /* synthetic */ long i;
    private final /* synthetic */ long j;
    private final /* synthetic */ long k;
    private final /* synthetic */ bex l;

    bfa(bex bexVar, bjd bjdVar, int i, int i2, bab babVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        this.l = bexVar;
        this.f2601a = bjdVar;
        this.f2602b = i;
        this.c = i2;
        this.d = babVar;
        this.e = i3;
        this.f = obj;
        this.g = j;
        this.h = j2;
        this.i = j3;
        this.j = j4;
        this.k = j5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.l.f2596b.b(this.f2601a, this.f2602b, this.c, this.d, this.e, this.f, this.l.b(this.g), this.l.b(this.h), this.i, this.j, this.k);
    }
}
