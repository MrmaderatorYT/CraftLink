package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class bgq extends bgg {
    private final int j;
    private final long k;
    private final bgj l;
    private volatile int m;
    private volatile boolean n;
    private volatile boolean o;

    public bgq(bja bjaVar, bjd bjdVar, bab babVar, int i, Object obj, long j, long j2, int i2, int i3, long j3, bgj bgjVar) {
        super(bjaVar, bjdVar, babVar, i, obj, j, j2, i2);
        this.j = i3;
        this.k = j3;
        this.l = bgjVar;
    }

    @Override // com.google.android.gms.internal.ads.bgs
    public final int f() {
        return this.i + this.j;
    }

    @Override // com.google.android.gms.internal.ads.bgs
    public final boolean g() {
        return this.o;
    }

    @Override // com.google.android.gms.internal.ads.bgi
    public final long e() {
        return this.m;
    }

    @Override // com.google.android.gms.internal.ads.bjl
    public final void a() {
        this.n = true;
    }

    @Override // com.google.android.gms.internal.ads.bjl
    public final boolean b() {
        return this.n;
    }

    @Override // com.google.android.gms.internal.ads.bjl
    public final void c() {
        bjd bjdVarA = bkg.a(this.f2641a, this.m);
        try {
            bca bcaVar = new bca(this.h, bjdVarA.c, this.h.a(bjdVarA));
            if (this.m == 0) {
                bgh bghVarD = d();
                bghVarD.a(this.k);
                this.l.a(bghVarD);
            }
            try {
                bcc bccVar = this.l.f2643a;
                int iA = 0;
                while (iA == 0 && !this.n) {
                    iA = bccVar.a(bcaVar, (bcj) null);
                }
                bjq.b(iA != 1);
                bkg.a(this.h);
                this.o = true;
            } finally {
                this.m = (int) (bcaVar.b() - this.f2641a.c);
            }
        } catch (Throwable th) {
            bkg.a(this.h);
            throw th;
        }
    }
}
