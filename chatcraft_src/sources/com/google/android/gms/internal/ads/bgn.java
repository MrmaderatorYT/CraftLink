package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.bgp;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class bgn<T extends bgp> implements bfz, bga, bjj<bgi> {

    /* renamed from: a, reason: collision with root package name */
    long f2649a;

    /* renamed from: b, reason: collision with root package name */
    boolean f2650b;
    private final int c;
    private final int[] d;
    private final boolean[] e;
    private final T f;
    private final bgb<bgn<T>> g;
    private final bex h;
    private final int i;
    private final bji j = new bji("Loader:ChunkSampleStream");
    private final bgm k = new bgm();
    private final LinkedList<bgg> l = new LinkedList<>();
    private final List<bgg> m = Collections.unmodifiableList(this.l);
    private final bfw n;
    private final bfw[] o;
    private final bgh p;
    private bab q;
    private long r;

    public bgn(int i, int[] iArr, T t, bgb<bgn<T>> bgbVar, biy biyVar, long j, int i2, bex bexVar) {
        this.c = i;
        this.d = iArr;
        this.f = t;
        this.g = bgbVar;
        this.h = bexVar;
        this.i = i2;
        int i3 = 0;
        int length = iArr == null ? 0 : iArr.length;
        this.o = new bfw[length];
        this.e = new boolean[length];
        int i4 = length + 1;
        int[] iArr2 = new int[i4];
        bfw[] bfwVarArr = new bfw[i4];
        this.n = new bfw(biyVar);
        iArr2[0] = i;
        bfwVarArr[0] = this.n;
        while (i3 < length) {
            bfw bfwVar = new bfw(biyVar);
            this.o[i3] = bfwVar;
            int i5 = i3 + 1;
            bfwVarArr[i5] = bfwVar;
            iArr2[i5] = iArr[i3];
            i3 = i5;
        }
        this.p = new bgh(iArr2, bfwVarArr);
        this.r = j;
        this.f2649a = j;
    }

    public final void b(long j) {
        for (int i = 0; i < this.o.length; i++) {
            if (!this.e[i]) {
                this.o[i].a(j, true);
            }
        }
    }

    public final bgo a(long j, int i) {
        for (int i2 = 0; i2 < this.o.length; i2++) {
            if (this.d[i2] == i) {
                bjq.b(!this.e[i2]);
                this.e[i2] = true;
                this.o[i2].a(j, true);
                return new bgo(this, this, this.o[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    public final T c() {
        return this.f;
    }

    public final long d() {
        if (this.f2650b) {
            return Long.MIN_VALUE;
        }
        if (f()) {
            return this.r;
        }
        long jMax = this.f2649a;
        bgg last = this.l.getLast();
        if (!last.g()) {
            last = this.l.size() > 1 ? this.l.get(this.l.size() - 2) : null;
        }
        if (last != null) {
            jMax = Math.max(jMax, last.g);
        }
        return Math.max(jMax, this.n.f());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(long r7) {
        /*
            r6 = this;
            r6.f2649a = r7
            boolean r0 = r6.f()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L1f
            com.google.android.gms.internal.ads.bfw r0 = r6.n
            long r3 = r6.r_()
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 >= 0) goto L16
            r3 = 1
            goto L17
        L16:
            r3 = 0
        L17:
            boolean r0 = r0.a(r7, r3)
            if (r0 == 0) goto L1f
            r0 = 1
            goto L20
        L1f:
            r0 = 0
        L20:
            if (r0 == 0) goto L52
        L22:
            java.util.LinkedList<com.google.android.gms.internal.ads.bgg> r0 = r6.l
            int r0 = r0.size()
            if (r0 <= r2) goto L44
            java.util.LinkedList<com.google.android.gms.internal.ads.bgg> r0 = r6.l
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.ads.bgg r0 = (com.google.android.gms.internal.ads.bgg) r0
            int r0 = r0.a(r1)
            com.google.android.gms.internal.ads.bfw r3 = r6.n
            int r3 = r3.d()
            if (r0 > r3) goto L44
            java.util.LinkedList<com.google.android.gms.internal.ads.bgg> r0 = r6.l
            r0.removeFirst()
            goto L22
        L44:
            com.google.android.gms.internal.ads.bfw[] r0 = r6.o
            int r3 = r0.length
        L47:
            if (r1 >= r3) goto L51
            r4 = r0[r1]
            r4.a(r7, r2)
            int r1 = r1 + 1
            goto L47
        L51:
            return
        L52:
            r6.r = r7
            r6.f2650b = r1
            java.util.LinkedList<com.google.android.gms.internal.ads.bgg> r7 = r6.l
            r7.clear()
            com.google.android.gms.internal.ads.bji r7 = r6.j
            boolean r7 = r7.a()
            if (r7 == 0) goto L69
            com.google.android.gms.internal.ads.bji r7 = r6.j
            r7.b()
            return
        L69:
            com.google.android.gms.internal.ads.bfw r7 = r6.n
            r7.a(r2)
            com.google.android.gms.internal.ads.bfw[] r7 = r6.o
            int r8 = r7.length
        L71:
            if (r1 >= r8) goto L7b
            r0 = r7[r1]
            r0.a(r2)
            int r1 = r1 + 1
            goto L71
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bgn.c(long):void");
    }

    public final void e() {
        this.n.b();
        for (bfw bfwVar : this.o) {
            bfwVar.b();
        }
        this.j.a((Runnable) null);
    }

    @Override // com.google.android.gms.internal.ads.bfz
    public final boolean a() {
        if (this.f2650b) {
            return true;
        }
        return !f() && this.n.c();
    }

    @Override // com.google.android.gms.internal.ads.bfz
    public final void b() throws IOException {
        this.j.a(Integer.MIN_VALUE);
        if (this.j.a()) {
            return;
        }
        this.f.a();
    }

    @Override // com.google.android.gms.internal.ads.bfz
    public final int a(bad badVar, bbs bbsVar, boolean z) {
        if (f()) {
            return -3;
        }
        int iD = this.n.d();
        if (!this.l.isEmpty()) {
            while (this.l.size() > 1 && this.l.get(1).a(0) <= iD) {
                this.l.removeFirst();
            }
            bgg first = this.l.getFirst();
            bab babVar = first.c;
            if (!babVar.equals(this.q)) {
                this.h.a(this.c, babVar, first.d, first.e, first.f);
            }
            this.q = babVar;
        }
        return this.n.a(badVar, bbsVar, z, this.f2650b, this.f2649a);
    }

    @Override // com.google.android.gms.internal.ads.bfz
    public final void a_(long j) {
        if (this.f2650b && j > this.n.f()) {
            this.n.g();
        } else {
            this.n.a(j, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.bga
    public final boolean a(long j) {
        if (this.f2650b || this.j.a()) {
            return false;
        }
        this.f.a(this.l.isEmpty() ? null : this.l.getLast(), this.r != -9223372036854775807L ? this.r : j, this.k);
        boolean z = this.k.f2648b;
        bgi bgiVar = this.k.f2647a;
        bgm bgmVar = this.k;
        bgmVar.f2647a = null;
        bgmVar.f2648b = false;
        if (z) {
            this.r = -9223372036854775807L;
            this.f2650b = true;
            return true;
        }
        if (bgiVar == null) {
            return false;
        }
        if (bgiVar instanceof bgg) {
            this.r = -9223372036854775807L;
            bgg bggVar = (bgg) bgiVar;
            bggVar.a(this.p);
            this.l.add(bggVar);
        }
        this.h.a(bgiVar.f2641a, bgiVar.f2642b, this.c, bgiVar.c, bgiVar.d, bgiVar.e, bgiVar.f, bgiVar.g, this.j.a(bgiVar, this, this.i));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.bga
    public final long r_() {
        if (f()) {
            return this.r;
        }
        if (this.f2650b) {
            return Long.MIN_VALUE;
        }
        return this.l.getLast().g;
    }

    final boolean f() {
        return this.r != -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.bjj
    public final /* synthetic */ int a(bjl bjlVar, long j, long j2, IOException iOException) {
        boolean z;
        bgi bgiVar = (bgi) bjlVar;
        long jE = bgiVar.e();
        boolean z2 = bgiVar instanceof bgg;
        if (this.f.a(bgiVar, !z2 || jE == 0 || this.l.size() > 1, iOException)) {
            if (z2) {
                bgg bggVarRemoveLast = this.l.removeLast();
                bjq.b(bggVarRemoveLast == bgiVar);
                this.n.a(bggVarRemoveLast.a(0));
                int i = 0;
                while (i < this.o.length) {
                    bfw bfwVar = this.o[i];
                    i++;
                    bfwVar.a(bggVarRemoveLast.a(i));
                }
                if (this.l.isEmpty()) {
                    this.r = this.f2649a;
                }
            }
            z = true;
        } else {
            z = false;
        }
        this.h.a(bgiVar.f2641a, bgiVar.f2642b, this.c, bgiVar.c, bgiVar.d, bgiVar.e, bgiVar.f, bgiVar.g, j, j2, jE, iOException, z);
        if (!z) {
            return 0;
        }
        this.g.a(this);
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.bjj
    public final /* synthetic */ void a(bjl bjlVar, long j, long j2, boolean z) {
        bgi bgiVar = (bgi) bjlVar;
        this.h.b(bgiVar.f2641a, bgiVar.f2642b, this.c, bgiVar.c, bgiVar.d, bgiVar.e, bgiVar.f, bgiVar.g, j, j2, bgiVar.e());
        if (z) {
            return;
        }
        this.n.a(true);
        for (bfw bfwVar : this.o) {
            bfwVar.a(true);
        }
        this.g.a(this);
    }

    @Override // com.google.android.gms.internal.ads.bjj
    public final /* synthetic */ void a(bjl bjlVar, long j, long j2) {
        bgi bgiVar = (bgi) bjlVar;
        this.f.a(bgiVar);
        this.h.a(bgiVar.f2641a, bgiVar.f2642b, this.c, bgiVar.c, bgiVar.d, bgiVar.e, bgiVar.f, bgiVar.g, j, j2, bgiVar.e());
        this.g.a(this);
    }
}
