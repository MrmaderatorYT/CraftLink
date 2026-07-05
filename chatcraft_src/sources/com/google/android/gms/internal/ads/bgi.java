package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public abstract class bgi implements bjl {

    /* renamed from: a, reason: collision with root package name */
    public final bjd f2641a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2642b;
    public final bab c;
    public final int d;
    public final Object e;
    public final long f;
    public final long g;
    protected final bja h;

    public bgi(bja bjaVar, bjd bjdVar, int i, bab babVar, int i2, Object obj, long j, long j2) {
        this.h = (bja) bjq.a(bjaVar);
        this.f2641a = (bjd) bjq.a(bjdVar);
        this.f2642b = i;
        this.c = babVar;
        this.d = i2;
        this.e = obj;
        this.f = j;
        this.g = j2;
    }

    public abstract long e();
}
