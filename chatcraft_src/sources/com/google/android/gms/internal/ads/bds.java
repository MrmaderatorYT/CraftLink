package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Stack;

/* loaded from: classes.dex */
public final class bds implements bcc, bck {

    /* renamed from: a, reason: collision with root package name */
    private static final bcg f2560a = new bdt();

    /* renamed from: b, reason: collision with root package name */
    private static final int f2561b = bkg.f("qt  ");
    private int g;
    private int h;
    private long i;
    private int j;
    private bjz k;
    private int l;
    private int m;
    private bcf n;
    private bdu[] o;
    private long p;
    private boolean q;
    private final bjz e = new bjz(16);
    private final Stack<bda> f = new Stack<>();
    private final bjz c = new bjz(bjw.f2746a);
    private final bjz d = new bjz(4);

    @Override // com.google.android.gms.internal.ads.bck
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.bcc
    public final void c() {
    }

    @Override // com.google.android.gms.internal.ads.bcc
    public final boolean a(bce bceVar) {
        return bdw.b(bceVar);
    }

    @Override // com.google.android.gms.internal.ads.bcc
    public final void a(bcf bcfVar) {
        this.n = bcfVar;
    }

    @Override // com.google.android.gms.internal.ads.bcc
    public final void a(long j, long j2) {
        this.f.clear();
        this.j = 0;
        this.l = 0;
        this.m = 0;
        if (j == 0) {
            d();
            return;
        }
        if (this.o != null) {
            for (bdu bduVar : this.o) {
                bea beaVar = bduVar.f2563b;
                int iA = beaVar.a(j2);
                if (iA == -1) {
                    iA = beaVar.b(j2);
                }
                bduVar.d = iA;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x019e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02b3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0206  */
    @Override // com.google.android.gms.internal.ads.bcc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(com.google.android.gms.internal.ads.bce r25, com.google.android.gms.internal.ads.bcj r26) throws com.google.android.gms.internal.ads.zzfx {
        /*
            Method dump skipped, instructions count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bds.a(com.google.android.gms.internal.ads.bce, com.google.android.gms.internal.ads.bcj):int");
    }

    @Override // com.google.android.gms.internal.ads.bck
    public final long b() {
        return this.p;
    }

    @Override // com.google.android.gms.internal.ads.bck
    public final long b(long j) {
        long j2 = Long.MAX_VALUE;
        for (bdu bduVar : this.o) {
            bea beaVar = bduVar.f2563b;
            int iA = beaVar.a(j);
            if (iA == -1) {
                iA = beaVar.b(j);
            }
            long j3 = beaVar.f2572b[iA];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    private final void d() {
        this.g = 0;
        this.j = 0;
    }

    private final void a(long j) throws zzfx {
        bdx bdxVarA;
        while (!this.f.isEmpty() && this.f.peek().aP == j) {
            bda bdaVarPop = this.f.pop();
            if (bdaVarPop.aO == bcz.B) {
                long jMax = -9223372036854775807L;
                ArrayList arrayList = new ArrayList();
                bem bemVarA = null;
                bch bchVar = new bch();
                bdb bdbVarD = bdaVarPop.d(bcz.az);
                if (bdbVarD != null && (bemVarA = bdc.a(bdbVarD, this.q)) != null) {
                    bchVar.a(bemVarA);
                }
                for (int i = 0; i < bdaVarPop.aR.size(); i++) {
                    bda bdaVar = bdaVarPop.aR.get(i);
                    if (bdaVar.aO == bcz.D && (bdxVarA = bdc.a(bdaVar, bdaVarPop.d(bcz.C), -9223372036854775807L, (bbt) null, this.q)) != null) {
                        bea beaVarA = bdc.a(bdxVarA, bdaVar.e(bcz.E).e(bcz.F).e(bcz.G), bchVar);
                        if (beaVarA.f2571a != 0) {
                            bdu bduVar = new bdu(bdxVarA, beaVarA, this.n.a(i, bdxVarA.f2566b));
                            bab babVarA = bdxVarA.f.a(beaVarA.d + 30);
                            if (bdxVarA.f2566b == 1) {
                                if (bchVar.a()) {
                                    babVarA = babVarA.a(bchVar.f2514a, bchVar.f2515b);
                                }
                                if (bemVarA != null) {
                                    babVarA = babVarA.a(bemVarA);
                                }
                            }
                            bduVar.c.a(babVarA);
                            jMax = Math.max(jMax, bdxVarA.e);
                            arrayList.add(bduVar);
                        }
                    }
                }
                this.p = jMax;
                this.o = (bdu[]) arrayList.toArray(new bdu[arrayList.size()]);
                this.n.a();
                this.n.a(this);
                this.f.clear();
                this.g = 2;
            } else if (!this.f.isEmpty()) {
                this.f.peek().a(bdaVarPop);
            }
        }
        if (this.g != 2) {
            d();
        }
    }
}
