package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.SparseArray;
import com.github.steveice10.mc.v1_5.util.Constants;
import com.google.android.gms.internal.ads.bbt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

/* loaded from: classes.dex */
public final class bdn implements bcc {

    /* renamed from: a, reason: collision with root package name */
    private static final bcg f2552a = new bdo();

    /* renamed from: b, reason: collision with root package name */
    private static final int f2553b = bkg.f("seig");
    private static final byte[] c = {-94, Constants.MobIds.ZOMBIE_PIGMAN, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private int A;
    private int B;
    private boolean C;
    private bcf D;
    private bcm E;
    private bcm[] F;
    private boolean G;
    private final int d;
    private final bdx e;
    private final SparseArray<bdq> f;
    private final bjz g;
    private final bjz h;
    private final bjz i;
    private final bjz j;
    private final bkd k;
    private final bjz l;
    private final byte[] m;
    private final Stack<bda> n;
    private final LinkedList<bdp> o;
    private int p;
    private int q;
    private long r;
    private int s;
    private bjz t;
    private long u;
    private int v;
    private long w;
    private long x;
    private bdq y;
    private int z;

    public bdn() {
        this(0);
    }

    @Override // com.google.android.gms.internal.ads.bcc
    public final void c() {
    }

    public bdn(int i) {
        this(i, null);
    }

    private bdn(int i, bkd bkdVar) {
        this(i, null, null);
    }

    private bdn(int i, bkd bkdVar, bdx bdxVar) {
        this.d = i;
        this.k = null;
        this.e = null;
        this.l = new bjz(16);
        this.g = new bjz(bjw.f2746a);
        this.h = new bjz(5);
        this.i = new bjz();
        this.j = new bjz(1);
        this.m = new byte[16];
        this.n = new Stack<>();
        this.o = new LinkedList<>();
        this.f = new SparseArray<>();
        this.w = -9223372036854775807L;
        this.x = -9223372036854775807L;
        a();
    }

    @Override // com.google.android.gms.internal.ads.bcc
    public final boolean a(bce bceVar) {
        return bdw.a(bceVar);
    }

    @Override // com.google.android.gms.internal.ads.bcc
    public final void a(bcf bcfVar) {
        this.D = bcfVar;
    }

    @Override // com.google.android.gms.internal.ads.bcc
    public final void a(long j, long j2) {
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            this.f.valueAt(i).a();
        }
        this.o.clear();
        this.v = 0;
        this.n.clear();
        a();
    }

    /* JADX WARN: Removed duplicated region for block: B:207:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x054a A[LOOP:7: B:224:0x054a->B:226:0x0550, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0611 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0610 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x037a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0370 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0230  */
    @Override // com.google.android.gms.internal.ads.bcc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(com.google.android.gms.internal.ads.bce r29, com.google.android.gms.internal.ads.bcj r30) throws com.google.android.gms.internal.ads.zzfx {
        /*
            Method dump skipped, instructions count: 1570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bdn.a(com.google.android.gms.internal.ads.bce, com.google.android.gms.internal.ads.bcj):int");
    }

    private final void a() {
        this.p = 0;
        this.s = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x064f  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x065a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a(long r55) throws com.google.android.gms.internal.ads.zzfx {
        /*
            Method dump skipped, instructions count: 1798
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bdn.a(long):void");
    }

    private static void a(bjz bjzVar, int i, bdz bdzVar) throws zzfx {
        bjzVar.c(i + 8);
        int iB = bcz.b(bjzVar.l());
        if ((iB & 1) != 0) {
            throw new zzfx("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iB & 2) != 0;
        int iO = bjzVar.o();
        if (iO != bdzVar.f) {
            int i2 = bdzVar.f;
            StringBuilder sb = new StringBuilder(41);
            sb.append("Length mismatch: ");
            sb.append(iO);
            sb.append(", ");
            sb.append(i2);
            throw new zzfx(sb.toString());
        }
        Arrays.fill(bdzVar.n, 0, iO, z);
        bdzVar.a(bjzVar.b());
        bjzVar.a(bdzVar.q.f2752a, 0, bdzVar.p);
        bdzVar.q.c(0);
        bdzVar.r = false;
    }

    private static bbt a(List<bdb> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            bdb bdbVar = list.get(i);
            if (bdbVar.aO == bcz.U) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bdbVar.aP.f2752a;
                UUID uuidA = bdv.a(bArr);
                if (uuidA == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new bbt.a(uuidA, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new bbt(arrayList);
    }
}
