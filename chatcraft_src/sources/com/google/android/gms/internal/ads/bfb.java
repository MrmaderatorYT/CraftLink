package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes.dex */
final class bfb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bjd f2603a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ int f2604b;
    private final /* synthetic */ int c;
    private final /* synthetic */ bab d;
    private final /* synthetic */ int e;
    private final /* synthetic */ Object f;
    private final /* synthetic */ long g;
    private final /* synthetic */ long h;
    private final /* synthetic */ long i;
    private final /* synthetic */ long j;
    private final /* synthetic */ long k;
    private final /* synthetic */ IOException l;
    private final /* synthetic */ boolean m;
    private final /* synthetic */ bex n;

    bfb(bex bexVar, bjd bjdVar, int i, int i2, bab babVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
        this.n = bexVar;
        this.f2603a = bjdVar;
        this.f2604b = i;
        this.c = i2;
        this.d = babVar;
        this.e = i3;
        this.f = obj;
        this.g = j;
        this.h = j2;
        this.i = j3;
        this.j = j4;
        this.k = j5;
        this.l = iOException;
        this.m = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.f2596b.a(this.f2603a, this.f2604b, this.c, this.d, this.e, this.f, this.n.b(this.g), this.n.b(this.h), this.i, this.j, this.k, this.l, this.m);
    }
}
