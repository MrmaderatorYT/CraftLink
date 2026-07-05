package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class bhk implements bgu {

    /* renamed from: a, reason: collision with root package name */
    private final bjm f2669a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f2670b;
    private final bir c;
    private final int d;
    private final bhm[] e;
    private final bja f;
    private final long g;
    private final int h;
    private bho i;
    private int j;
    private IOException k;
    private boolean l;

    public bhk(bjm bjmVar, bho bhoVar, int i, int[] iArr, bir birVar, int i2, bja bjaVar, long j, int i3, boolean z, boolean z2) {
        this.f2669a = bjmVar;
        this.i = bhoVar;
        this.f2670b = iArr;
        this.c = birVar;
        this.d = i2;
        this.f = bjaVar;
        this.j = i;
        this.g = j;
        this.h = i3;
        long jB = bhoVar.b(i);
        ArrayList<bhu> arrayListB = b();
        this.e = new bhm[birVar.b()];
        for (int i4 = 0; i4 < this.e.length; i4++) {
            this.e[i4] = new bhm(jB, arrayListB.get(birVar.b(i4)), z, z2);
        }
    }

    @Override // com.google.android.gms.internal.ads.bgu
    public final void a(bho bhoVar, int i) {
        try {
            this.i = bhoVar;
            this.j = i;
            long jB = this.i.b(this.j);
            ArrayList<bhu> arrayListB = b();
            for (int i2 = 0; i2 < this.e.length; i2++) {
                this.e[i2].a(jB, arrayListB.get(this.c.b(i2)));
            }
        } catch (zzkz e) {
            this.k = e;
        }
    }

    @Override // com.google.android.gms.internal.ads.bgp
    public final void a() throws IOException {
        if (this.k != null) {
            throw this.k;
        }
        this.f2669a.c();
    }

    @Override // com.google.android.gms.internal.ads.bgp
    public final void a(bgs bgsVar, long j, bgm bgmVar) {
        long jCurrentTimeMillis;
        int iA;
        int iF;
        boolean z;
        bgg bgqVar;
        bht bhtVarA;
        bhk bhkVar = this;
        if (bhkVar.k != null) {
            return;
        }
        bhkVar.c.a(bgsVar != null ? bgsVar.g - j : 0L);
        bhm bhmVar = bhkVar.e[bhkVar.c.d()];
        if (bhmVar.f2673a != null) {
            bhu bhuVar = bhmVar.f2674b;
            bht bhtVarC = bhmVar.f2673a.c() == null ? bhuVar.c() : null;
            bht bhtVarD = bhmVar.c == null ? bhuVar.d() : null;
            if (bhtVarC != null || bhtVarD != null) {
                bja bjaVar = bhkVar.f;
                bab babVarC = bhkVar.c.c();
                int iE = bhkVar.c.e();
                Object objF = bhkVar.c.f();
                String str = bhmVar.f2674b.f2690b;
                if (bhtVarC != null) {
                    bhtVarA = bhtVarC.a(bhtVarD, str);
                    if (bhtVarA == null) {
                        bhtVarA = bhtVarC;
                    }
                } else {
                    bhtVarA = bhtVarD;
                }
                bgmVar.f2647a = new bgr(bjaVar, new bjd(bhtVarA.a(str), bhtVarA.f2687a, bhtVarA.f2688b, bhmVar.f2674b.f()), babVarC, iE, objF, bhmVar.f2673a);
                return;
            }
        }
        if (bhkVar.g != 0) {
            jCurrentTimeMillis = (SystemClock.elapsedRealtime() + bhkVar.g) * 1000;
        } else {
            jCurrentTimeMillis = System.currentTimeMillis() * 1000;
        }
        int iB = bhmVar.b();
        boolean z2 = true;
        if (iB == 0) {
            if (bhkVar.i.f2678b && bhkVar.j >= bhkVar.i.a() - 1) {
                z2 = false;
            }
            bgmVar.f2648b = z2;
            return;
        }
        int iA2 = bhmVar.a();
        if (iB == -1) {
            long j2 = (jCurrentTimeMillis - (bhkVar.i.f2677a * 1000)) - (bhkVar.i.a(bhkVar.j).f2686b * 1000);
            if (bhkVar.i.d != -9223372036854775807L) {
                iA2 = Math.max(iA2, bhmVar.a(j2 - (bhkVar.i.d * 1000)));
            }
            iA = bhmVar.a(j2) - 1;
        } else {
            iA = (iB + iA2) - 1;
        }
        if (bgsVar == null) {
            iF = bkg.a(bhmVar.a(j), iA2, iA);
        } else {
            iF = bgsVar.f();
            if (iF < iA2) {
                bhkVar.k = new zzkz();
                return;
            }
        }
        int i = iF;
        if (i > iA) {
            bhkVar = this;
        } else if (!bhkVar.l || i < iA) {
            int iMin = Math.min(bhkVar.h, (iA - i) + 1);
            bja bjaVar2 = bhkVar.f;
            int i2 = bhkVar.d;
            bab babVarC2 = bhkVar.c.c();
            int iE2 = bhkVar.c.e();
            Object objF2 = bhkVar.c.f();
            bhu bhuVar2 = bhmVar.f2674b;
            long jA = bhmVar.a(i);
            bht bhtVarC2 = bhmVar.c(i);
            String str2 = bhuVar2.f2690b;
            if (bhmVar.f2673a == null) {
                bgqVar = new bgt(bjaVar2, new bjd(bhtVarC2.a(str2), bhtVarC2.f2687a, bhtVarC2.f2688b, bhuVar2.f()), babVarC2, iE2, objF2, jA, bhmVar.b(i), i, i2, babVarC2);
            } else {
                int i3 = 1;
                int i4 = 1;
                while (i3 < iMin) {
                    bht bhtVarA2 = bhtVarC2.a(bhmVar.c(i + i3), str2);
                    if (bhtVarA2 == null) {
                        break;
                    }
                    i4++;
                    i3++;
                    bhtVarC2 = bhtVarA2;
                }
                bgqVar = new bgq(bjaVar2, new bjd(bhtVarC2.a(str2), bhtVarC2.f2687a, bhtVarC2.f2688b, bhuVar2.f()), babVarC2, iE2, objF2, jA, bhmVar.b((i + i4) - 1), i, i4, -bhuVar2.c, bhmVar.f2673a);
            }
            bgmVar.f2647a = bgqVar;
            return;
        }
        if (bhkVar.i.f2678b) {
            z = true;
            if (bhkVar.j >= bhkVar.i.a() - 1) {
                z = false;
            }
        } else {
            z = true;
        }
        bgmVar.f2648b = z;
    }

    @Override // com.google.android.gms.internal.ads.bgp
    public final void a(bgi bgiVar) {
        bck bckVarB;
        if (bgiVar instanceof bgr) {
            bhm bhmVar = this.e[this.c.a(((bgr) bgiVar).c)];
            if (bhmVar.c != null || (bckVarB = bhmVar.f2673a.b()) == null) {
                return;
            }
            bhmVar.c = new bhj((bbz) bckVarB);
        }
    }

    @Override // com.google.android.gms.internal.ads.bgp
    public final boolean a(bgi bgiVar, boolean z, Exception exc) {
        int i;
        bhm bhmVar;
        int iB;
        if (!z) {
            return false;
        }
        boolean z2 = true;
        if (!this.i.f2678b && (bgiVar instanceof bgs) && (exc instanceof zzpd) && ((zzpd) exc).f3678a == 404 && (iB = (bhmVar = this.e[this.c.a(bgiVar.c)]).b()) != -1 && iB != 0) {
            if (((bgs) bgiVar).f() > (bhmVar.a() + iB) - 1) {
                this.l = true;
                return true;
            }
        }
        bir birVar = this.c;
        int iA = this.c.a(bgiVar.c);
        if (!(exc instanceof zzpd) || ((i = ((zzpd) exc).f3678a) != 404 && i != 410)) {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        boolean zA = birVar.a(iA, 60000L);
        int i2 = ((zzpd) exc).f3678a;
        if (zA) {
            String strValueOf = String.valueOf(birVar.a(iA));
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 77);
            sb.append("Blacklisted: duration=60000, responseCode=");
            sb.append(i2);
            sb.append(", format=");
            sb.append(strValueOf);
            Log.w("ChunkedTrackBlacklist", sb.toString());
        } else {
            String strValueOf2 = String.valueOf(birVar.a(iA));
            StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 92);
            sb2.append("Blacklisting failed (cannot blacklist last enabled track): responseCode=");
            sb2.append(i2);
            sb2.append(", format=");
            sb2.append(strValueOf2);
            Log.w("ChunkedTrackBlacklist", sb2.toString());
        }
        return zA;
    }

    private final ArrayList<bhu> b() {
        List<bhn> list = this.i.a(this.j).c;
        ArrayList<bhu> arrayList = new ArrayList<>();
        for (int i : this.f2670b) {
            arrayList.addAll(list.get(i).c);
        }
        return arrayList;
    }
}
