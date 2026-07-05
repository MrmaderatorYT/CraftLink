package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class bgt extends bgg {
    private final int j;
    private final bab k;
    private volatile int l;
    private volatile boolean m;
    private volatile boolean n;

    public bgt(bja bjaVar, bjd bjdVar, bab babVar, int i, Object obj, long j, long j2, int i2, int i3, bab babVar2) {
        super(bjaVar, bjdVar, babVar, i, obj, j, j2, i2);
        this.j = i3;
        this.k = babVar2;
    }

    @Override // com.google.android.gms.internal.ads.bgs
    public final boolean g() {
        return this.n;
    }

    @Override // com.google.android.gms.internal.ads.bgi
    public final long e() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.bjl
    public final void a() {
        this.m = true;
    }

    @Override // com.google.android.gms.internal.ads.bjl
    public final boolean b() {
        return this.m;
    }

    @Override // com.google.android.gms.internal.ads.bjl
    public final void c() {
        try {
            long jA = this.h.a(bkg.a(this.f2641a, this.l));
            if (jA != -1) {
                jA += this.l;
            }
            bca bcaVar = new bca(this.h, this.l, jA);
            bgh bghVarD = d();
            bghVarD.a(0L);
            bcm bcmVarA = bghVarD.a(0, this.j);
            bcmVarA.a(this.k);
            for (int iA = 0; iA != -1; iA = bcmVarA.a(bcaVar, Integer.MAX_VALUE, true)) {
                this.l += iA;
            }
            bcmVarA.a(this.f, 1, this.l, 0, null);
            bkg.a(this.h);
            this.n = true;
        } catch (Throwable th) {
            bkg.a(this.h);
            throw th;
        }
    }
}
