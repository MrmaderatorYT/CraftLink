package com.google.android.gms.internal.ads;

import android.util.Pair;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
final class bgw implements bfq, bgb<bgn<bgu>> {

    /* renamed from: a, reason: collision with root package name */
    final int f2653a;

    /* renamed from: b, reason: collision with root package name */
    private final bgv f2654b;
    private final int c;
    private final bex d;
    private final long e;
    private final bjm f;
    private final biy g;
    private final bgf h;
    private final bgx[] i;
    private bfr j;
    private bgn<bgu>[] k = new bgn[0];
    private bfe l = new bfe(this.k);
    private bho m;
    private int n;
    private List<bhn> o;

    public bgw(int i, bho bhoVar, int i2, bgv bgvVar, int i3, bex bexVar, long j, bjm bjmVar, biy biyVar) {
        int i4;
        boolean z;
        boolean z2;
        bhr bhrVar;
        int i5;
        this.f2653a = i;
        this.m = bhoVar;
        this.n = i2;
        this.f2654b = bgvVar;
        this.c = i3;
        this.d = bexVar;
        this.e = j;
        this.f = bjmVar;
        this.g = biyVar;
        this.o = bhoVar.a(i2).c;
        List<bhn> list = this.o;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        for (int i6 = 0; i6 < size; i6++) {
            sparseIntArray.put(list.get(i6).f2675a, i6);
        }
        int[][] iArr = new int[size][];
        boolean[] zArr = new boolean[size];
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            if (!zArr[i8]) {
                zArr[i8] = true;
                List<bhr> list2 = list.get(i8).e;
                int i9 = 0;
                while (true) {
                    if (i9 >= list2.size()) {
                        bhrVar = null;
                        break;
                    }
                    bhr bhrVar2 = list2.get(i9);
                    if ("urn:mpeg:dash:adaptation-set-switching:2016".equals(bhrVar2.f2683a)) {
                        bhrVar = bhrVar2;
                        break;
                    }
                    i9++;
                }
                if (bhrVar == null) {
                    i5 = i7 + 1;
                    iArr[i7] = new int[]{i8};
                } else {
                    String[] strArrSplit = bhrVar.f2684b.split(",");
                    int[] iArr2 = new int[strArrSplit.length + 1];
                    iArr2[0] = i8;
                    int i10 = 0;
                    while (i10 < strArrSplit.length) {
                        int i11 = sparseIntArray.get(Integer.parseInt(strArrSplit[i10]));
                        zArr[i11] = true;
                        i10++;
                        iArr2[i10] = i11;
                    }
                    i5 = i7 + 1;
                    iArr[i7] = iArr2;
                }
                i7 = i5;
            }
        }
        iArr = i7 < size ? (int[][]) Arrays.copyOf(iArr, i7) : iArr;
        int length = iArr.length;
        boolean[] zArr2 = new boolean[length];
        boolean[] zArr3 = new boolean[length];
        int i12 = length;
        for (int i13 = 0; i13 < length; i13++) {
            int[] iArr3 = iArr[i13];
            int length2 = iArr3.length;
            int i14 = 0;
            while (true) {
                if (i14 >= length2) {
                    z = false;
                    break;
                }
                List<bhu> list3 = list.get(iArr3[i14]).c;
                for (int i15 = 0; i15 < list3.size(); i15++) {
                    if (!list3.get(i15).d.isEmpty()) {
                        z = true;
                        break;
                    }
                }
                i14++;
            }
            if (z) {
                zArr2[i13] = true;
                i12++;
            }
            int[] iArr4 = iArr[i13];
            int length3 = iArr4.length;
            int i16 = 0;
            while (true) {
                if (i16 >= length3) {
                    z2 = false;
                    break;
                }
                List<bhr> list4 = list.get(iArr4[i16]).d;
                for (int i17 = 0; i17 < list4.size(); i17++) {
                    if ("urn:scte:dash:cc:cea-608:2015".equals(list4.get(i17).f2683a)) {
                        z2 = true;
                        break;
                    }
                }
                i16++;
            }
            if (z2) {
                zArr3[i13] = true;
                i12++;
            }
        }
        bgd[] bgdVarArr = new bgd[i12];
        bgx[] bgxVarArr = new bgx[i12];
        int i18 = 0;
        int i19 = 0;
        while (i18 < length) {
            int[] iArr5 = iArr[i18];
            ArrayList arrayList = new ArrayList();
            for (int i20 : iArr5) {
                arrayList.addAll(list.get(i20).c);
            }
            bab[] babVarArr = new bab[arrayList.size()];
            for (int i21 = 0; i21 < babVarArr.length; i21++) {
                babVarArr[i21] = ((bhu) arrayList.get(i21)).f2689a;
            }
            bhn bhnVar = list.get(iArr5[0]);
            boolean z3 = zArr2[i18];
            boolean z4 = zArr3[i18];
            bgdVarArr[i19] = new bgd(babVarArr);
            int i22 = i19 + 1;
            List<bhn> list5 = list;
            bgxVarArr[i19] = new bgx(bhnVar.f2676b, iArr5, i19, true, z3, z4);
            if (z3) {
                int i23 = bhnVar.f2675a;
                StringBuilder sb = new StringBuilder(16);
                sb.append(i23);
                sb.append(":emsg");
                i4 = length;
                bgdVarArr[i22] = new bgd(bab.a(sb.toString(), "application/x-emsg", null, -1, null));
                bgxVarArr[i22] = new bgx(4, iArr5, i19, false, false, false);
                i22++;
            } else {
                i4 = length;
            }
            if (z4) {
                int i24 = bhnVar.f2675a;
                StringBuilder sb2 = new StringBuilder(18);
                sb2.append(i24);
                sb2.append(":cea608");
                bgdVarArr[i22] = new bgd(bab.a(sb2.toString(), "application/cea-608", (String) null, -1, 0, (String) null, (bbt) null));
                bgxVarArr[i22] = new bgx(3, iArr5, i19, false, false, false);
                i19 = i22 + 1;
            } else {
                i19 = i22;
            }
            i18++;
            list = list5;
            length = i4;
        }
        Pair pairCreate = Pair.create(new bgf(bgdVarArr), bgxVarArr);
        this.h = (bgf) pairCreate.first;
        this.i = (bgx[]) pairCreate.second;
    }

    @Override // com.google.android.gms.internal.ads.bfq
    public final long e() {
        return -9223372036854775807L;
    }

    public final void a(bho bhoVar, int i) {
        this.m = bhoVar;
        this.n = i;
        this.o = bhoVar.a(i).c;
        if (this.k != null) {
            for (bgn<bgu> bgnVar : this.k) {
                ((bgu) bgnVar.c()).a(bhoVar, i);
            }
            this.j.a((bfr) this);
        }
    }

    public final void b() {
        for (bgn<bgu> bgnVar : this.k) {
            bgnVar.e();
        }
    }

    @Override // com.google.android.gms.internal.ads.bfq
    public final void a(bfr bfrVar, long j) {
        this.j = bfrVar;
        bfrVar.a((bfq) this);
    }

    @Override // com.google.android.gms.internal.ads.bfq
    public final void c() {
        this.f.c();
    }

    @Override // com.google.android.gms.internal.ads.bfq
    public final bgf d() {
        return this.h;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0140  */
    @Override // com.google.android.gms.internal.ads.bfq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a(com.google.android.gms.internal.ads.bir[] r30, boolean[] r31, com.google.android.gms.internal.ads.bfz[] r32, boolean[] r33, long r34) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bgw.a(com.google.android.gms.internal.ads.bir[], boolean[], com.google.android.gms.internal.ads.bfz[], boolean[], long):long");
    }

    @Override // com.google.android.gms.internal.ads.bfq
    public final void b(long j) {
        for (bgn<bgu> bgnVar : this.k) {
            bgnVar.b(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.bfq, com.google.android.gms.internal.ads.bga
    public final boolean a(long j) {
        return this.l.a(j);
    }

    @Override // com.google.android.gms.internal.ads.bfq, com.google.android.gms.internal.ads.bga
    public final long r_() {
        return this.l.r_();
    }

    @Override // com.google.android.gms.internal.ads.bfq
    public final long f() {
        long jMin = Long.MAX_VALUE;
        for (bgn<bgu> bgnVar : this.k) {
            long jD = bgnVar.d();
            if (jD != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jD);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.gms.internal.ads.bfq
    public final long c(long j) {
        for (bgn<bgu> bgnVar : this.k) {
            bgnVar.c(j);
        }
        return j;
    }

    private static void a(bfz bfzVar) {
        if (bfzVar instanceof bgo) {
            ((bgo) bfzVar).c();
        }
    }

    @Override // com.google.android.gms.internal.ads.bgb
    public final /* synthetic */ void a(bga bgaVar) {
        this.j.a((bfr) this);
    }
}
