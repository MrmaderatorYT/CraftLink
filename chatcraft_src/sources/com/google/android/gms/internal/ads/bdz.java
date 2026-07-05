package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bdz {

    /* renamed from: a, reason: collision with root package name */
    public bdk f2569a;

    /* renamed from: b, reason: collision with root package name */
    public long f2570b;
    public long c;
    public long d;
    public int e;
    public int f;
    public long[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public long[] k;
    public boolean[] l;
    public boolean m;
    public boolean[] n;
    public bdy o;
    public int p;
    public bjz q;
    public boolean r;
    public long s;

    bdz() {
    }

    public final void a(int i) {
        if (this.q == null || this.q.c() < i) {
            this.q = new bjz(i);
        }
        this.p = i;
        this.m = true;
        this.r = true;
    }

    public final long b(int i) {
        return this.k[i] + this.j[i];
    }
}
