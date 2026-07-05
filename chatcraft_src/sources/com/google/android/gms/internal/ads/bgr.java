package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class bgr extends bgi {
    private final bgj i;
    private volatile int j;
    private volatile boolean k;

    public bgr(bja bjaVar, bjd bjdVar, bab babVar, int i, Object obj, bgj bgjVar) {
        super(bjaVar, bjdVar, 2, babVar, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.i = bgjVar;
    }

    @Override // com.google.android.gms.internal.ads.bgi
    public final long e() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.bjl
    public final void a() {
        this.k = true;
    }

    @Override // com.google.android.gms.internal.ads.bjl
    public final boolean b() {
        return this.k;
    }

    @Override // com.google.android.gms.internal.ads.bjl
    public final void c() {
        bjd bjdVarA = bkg.a(this.f2641a, this.j);
        try {
            bca bcaVar = new bca(this.h, bjdVarA.c, this.h.a(bjdVarA));
            if (this.j == 0) {
                this.i.a((bgl) null);
            }
            try {
                bcc bccVar = this.i.f2643a;
                int iA = 0;
                while (iA == 0 && !this.k) {
                    iA = bccVar.a(bcaVar, (bcj) null);
                }
                boolean z = true;
                if (iA == 1) {
                    z = false;
                }
                bjq.b(z);
            } finally {
                this.j = (int) (bcaVar.b() - this.f2641a.c);
            }
        } finally {
            bkg.a(this.h);
        }
    }
}
