package com.google.android.gms.internal.ads;

import android.util.Log;

/* loaded from: classes.dex */
final class azx {

    /* renamed from: a, reason: collision with root package name */
    public final bfq f2433a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2434b;
    public final int c;
    public final bfz[] d;
    public final long e;
    public int f;
    public long g;
    public boolean h;
    public boolean i;
    public boolean j;
    public azx k;
    public biw l;
    private final boolean[] m;
    private final bag[] n;
    private final bah[] o;
    private final biu p;
    private final bae q;
    private final bfs r;
    private biw s;

    public azx(bag[] bagVarArr, bah[] bahVarArr, long j, biu biuVar, bae baeVar, bfs bfsVar, Object obj, int i, int i2, boolean z, long j2) {
        this.n = bagVarArr;
        this.o = bahVarArr;
        this.e = j;
        this.p = biuVar;
        this.q = baeVar;
        this.r = bfsVar;
        this.f2434b = bjq.a(obj);
        this.c = i;
        this.f = i2;
        this.h = z;
        this.g = j2;
        this.d = new bfz[bagVarArr.length];
        this.m = new boolean[bagVarArr.length];
        this.f2433a = bfsVar.a(i2, baeVar.d());
    }

    public final long a() {
        return this.e - this.g;
    }

    public final void a(int i, boolean z) {
        this.f = i;
        this.h = z;
    }

    public final boolean b() {
        if (this.i) {
            return !this.j || this.f2433a.f() == Long.MIN_VALUE;
        }
        return false;
    }

    public final boolean c() {
        boolean z;
        biw biwVarA = this.p.a(this.o, this.f2433a.d());
        biw biwVar = this.s;
        if (biwVar == null) {
            z = false;
            break;
        }
        for (int i = 0; i < biwVarA.f2716b.f2712a; i++) {
            if (!biwVarA.a(biwVar, i)) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            return false;
        }
        this.l = biwVarA;
        return true;
    }

    public final long a(long j, boolean z) {
        return a(j, false, new boolean[this.n.length]);
    }

    public final long a(long j, boolean z, boolean[] zArr) {
        bit bitVar = this.l.f2716b;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= bitVar.f2712a) {
                break;
            }
            boolean[] zArr2 = this.m;
            if (z || !this.l.a(this.s, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long jA = this.f2433a.a(bitVar.a(), this.m, this.d, zArr, j);
        this.s = this.l;
        this.j = false;
        for (int i2 = 0; i2 < this.d.length; i2++) {
            if (this.d[i2] != null) {
                bjq.b(bitVar.a(i2) != null);
                this.j = true;
            } else {
                bjq.b(bitVar.a(i2) == null);
            }
        }
        this.q.a(this.n, this.l.f2715a, bitVar);
        return jA;
    }

    public final void d() {
        try {
            this.r.a(this.f2433a);
        } catch (RuntimeException e) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e);
        }
    }
}
