package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bey implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bjd f2597a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ int f2598b;
    private final /* synthetic */ int c;
    private final /* synthetic */ bab d;
    private final /* synthetic */ int e;
    private final /* synthetic */ Object f;
    private final /* synthetic */ long g;
    private final /* synthetic */ long h;
    private final /* synthetic */ long i;
    private final /* synthetic */ bex j;

    bey(bex bexVar, bjd bjdVar, int i, int i2, bab babVar, int i3, Object obj, long j, long j2, long j3) {
        this.j = bexVar;
        this.f2597a = bjdVar;
        this.f2598b = i;
        this.c = i2;
        this.d = babVar;
        this.e = i3;
        this.f = obj;
        this.g = j;
        this.h = j2;
        this.i = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.f2596b.a(this.f2597a, this.f2598b, this.c, this.d, this.e, this.f, this.j.b(this.g), this.j.b(this.h), this.i);
    }
}
