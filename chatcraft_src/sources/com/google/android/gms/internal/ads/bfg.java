package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import java.io.IOException;

/* loaded from: classes.dex */
final class bfg implements bcf, bfq, bfy, bjj<bfl> {
    private boolean[] A;
    private boolean B;
    private long D;
    private int F;
    private boolean G;
    private boolean H;

    /* renamed from: a, reason: collision with root package name */
    private final Uri f2610a;

    /* renamed from: b, reason: collision with root package name */
    private final bja f2611b;
    private final int c;
    private final Handler d;
    private final bfp e;
    private final bft f;
    private final biy g;
    private final String h;
    private final long i;
    private final bfm k;
    private bfr q;
    private bck r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private bgf x;
    private long y;
    private boolean[] z;
    private final bji j = new bji("Loader:ExtractorMediaPeriod");
    private final bjs l = new bjs();
    private final Runnable m = new bfh(this);
    private final Runnable n = new bfi(this);
    private final Handler o = new Handler();
    private long E = -9223372036854775807L;
    private final SparseArray<bfw> p = new SparseArray<>();
    private long C = -1;

    public bfg(Uri uri, bja bjaVar, bcc[] bccVarArr, int i, Handler handler, bfp bfpVar, bft bftVar, biy biyVar, String str, int i2) {
        this.f2610a = uri;
        this.f2611b = bjaVar;
        this.c = i;
        this.d = handler;
        this.e = bfpVar;
        this.f = bftVar;
        this.g = biyVar;
        this.h = str;
        this.i = i2;
        this.k = new bfm(bccVarArr, this);
    }

    @Override // com.google.android.gms.internal.ads.bfq
    public final void b(long j) {
    }

    public final void b() {
        this.j.a(new bfj(this, this.k));
        this.o.removeCallbacksAndMessages(null);
        this.H = true;
    }

    @Override // com.google.android.gms.internal.ads.bfq
    public final void a(bfr bfrVar, long j) {
        this.q = bfrVar;
        this.l.a();
        i();
    }

    @Override // com.google.android.gms.internal.ads.bfq
    public final void c() throws IOException {
        this.j.a(Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.bfq
    public final bgf d() {
        return this.x;
    }

    @Override // com.google.android.gms.internal.ads.bfq
    public final long a(bir[] birVarArr, boolean[] zArr, bfz[] bfzVarArr, boolean[] zArr2, long j) {
        bjq.b(this.t);
        for (int i = 0; i < birVarArr.length; i++) {
            if (bfzVarArr[i] != null && (birVarArr[i] == null || !zArr[i])) {
                int i2 = ((bfn) bfzVarArr[i]).f2622a;
                bjq.b(this.z[i2]);
                this.w--;
                this.z[i2] = false;
                this.p.valueAt(i2).b();
                bfzVarArr[i] = null;
            }
        }
        boolean z = false;
        for (int i3 = 0; i3 < birVarArr.length; i3++) {
            if (bfzVarArr[i3] == null && birVarArr[i3] != null) {
                bir birVar = birVarArr[i3];
                bjq.b(birVar.b() == 1);
                bjq.b(birVar.b(0) == 0);
                int iA = this.x.a(birVar.a());
                bjq.b(!this.z[iA]);
                this.w++;
                this.z[iA] = true;
                bfzVarArr[i3] = new bfn(this, iA);
                zArr2[i3] = true;
                z = true;
            }
        }
        if (!this.u) {
            int size = this.p.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!this.z[i4]) {
                    this.p.valueAt(i4).b();
                }
            }
        }
        if (this.w == 0) {
            this.v = false;
            if (this.j.a()) {
                this.j.b();
            }
        } else if (!this.u ? j != 0 : z) {
            j = c(j);
            for (int i5 = 0; i5 < bfzVarArr.length; i5++) {
                if (bfzVarArr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.u = true;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.bfq, com.google.android.gms.internal.ads.bga
    public final boolean a(long j) {
        if (this.G) {
            return false;
        }
        if (this.t && this.w == 0) {
            return false;
        }
        boolean zA = this.l.a();
        if (this.j.a()) {
            return zA;
        }
        i();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.bfq, com.google.android.gms.internal.ads.bga
    public final long r_() {
        if (this.w == 0) {
            return Long.MIN_VALUE;
        }
        return f();
    }

    @Override // com.google.android.gms.internal.ads.bfq
    public final long e() {
        if (!this.v) {
            return -9223372036854775807L;
        }
        this.v = false;
        return this.D;
    }

    @Override // com.google.android.gms.internal.ads.bfq
    public final long f() {
        long jK;
        if (this.G) {
            return Long.MIN_VALUE;
        }
        if (l()) {
            return this.E;
        }
        if (this.B) {
            jK = Long.MAX_VALUE;
            int size = this.p.size();
            for (int i = 0; i < size; i++) {
                if (this.A[i]) {
                    jK = Math.min(jK, this.p.valueAt(i).f());
                }
            }
        } else {
            jK = k();
        }
        return jK == Long.MIN_VALUE ? this.D : jK;
    }

    @Override // com.google.android.gms.internal.ads.bfq
    public final long c(long j) {
        if (!this.r.a()) {
            j = 0;
        }
        this.D = j;
        int size = this.p.size();
        boolean zA = !l();
        for (int i = 0; zA && i < size; i++) {
            if (this.z[i]) {
                zA = this.p.valueAt(i).a(j, false);
            }
        }
        if (!zA) {
            this.E = j;
            this.G = false;
            if (this.j.a()) {
                this.j.b();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    this.p.valueAt(i2).a(this.z[i2]);
                }
            }
        }
        this.v = false;
        return j;
    }

    final boolean a(int i) {
        if (this.G) {
            return true;
        }
        return !l() && this.p.valueAt(i).c();
    }

    final void g() {
        this.j.a(Integer.MIN_VALUE);
    }

    final int a(int i, bad badVar, bbs bbsVar, boolean z) {
        if (this.v || l()) {
            return -3;
        }
        return this.p.valueAt(i).a(badVar, bbsVar, z, this.G, this.D);
    }

    final void a(int i, long j) {
        bfw bfwVarValueAt = this.p.valueAt(i);
        if (this.G && j > bfwVarValueAt.f()) {
            bfwVarValueAt.g();
        } else {
            bfwVarValueAt.a(j, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.bcf
    public final bcm a(int i, int i2) {
        bfw bfwVar = this.p.get(i);
        if (bfwVar != null) {
            return bfwVar;
        }
        bfw bfwVar2 = new bfw(this.g);
        bfwVar2.a(this);
        this.p.put(i, bfwVar2);
        return bfwVar2;
    }

    @Override // com.google.android.gms.internal.ads.bcf
    public final void a() {
        this.s = true;
        this.o.post(this.m);
    }

    @Override // com.google.android.gms.internal.ads.bcf
    public final void a(bck bckVar) {
        this.r = bckVar;
        this.o.post(this.m);
    }

    @Override // com.google.android.gms.internal.ads.bfy
    public final void a(bab babVar) {
        this.o.post(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        if (this.H || this.t || this.r == null || !this.s) {
            return;
        }
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            if (this.p.valueAt(i).e() == null) {
                return;
            }
        }
        this.l.b();
        bgd[] bgdVarArr = new bgd[size];
        this.A = new boolean[size];
        this.z = new boolean[size];
        this.y = this.r.b();
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < size) {
                bab babVarE = this.p.valueAt(i2).e();
                bgdVarArr[i2] = new bgd(babVarE);
                String str = babVarE.e;
                if (!bjv.b(str) && !bjv.a(str)) {
                    z = false;
                }
                this.A[i2] = z;
                this.B = z | this.B;
                i2++;
            } else {
                this.x = new bgf(bgdVarArr);
                this.t = true;
                this.f.a(new bgc(this.y, this.r.a()), null);
                this.q.a((bfq) this);
                return;
            }
        }
    }

    private final void a(bfl bflVar) {
        if (this.C == -1) {
            this.C = bflVar.i;
        }
    }

    private final void i() {
        bfl bflVar = new bfl(this, this.f2610a, this.f2611b, this.k, this.l);
        if (this.t) {
            bjq.b(l());
            if (this.y != -9223372036854775807L && this.E >= this.y) {
                this.G = true;
                this.E = -9223372036854775807L;
                return;
            } else {
                bflVar.a(this.r.b(this.E), this.E);
                this.E = -9223372036854775807L;
            }
        }
        this.F = j();
        int i = this.c;
        if (i == -1) {
            i = (this.t && this.C == -1 && (this.r == null || this.r.b() == -9223372036854775807L)) ? 6 : 3;
        }
        this.j.a(bflVar, this, i);
    }

    private final int j() {
        int size = this.p.size();
        int iA = 0;
        for (int i = 0; i < size; i++) {
            iA += this.p.valueAt(i).a();
        }
        return iA;
    }

    private final long k() {
        int size = this.p.size();
        long jMax = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            jMax = Math.max(jMax, this.p.valueAt(i).f());
        }
        return jMax;
    }

    private final boolean l() {
        return this.E != -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.bjj
    public final /* synthetic */ int a(bjl bjlVar, long j, long j2, IOException iOException) {
        bfl bflVar = (bfl) bjlVar;
        a(bflVar);
        if (this.d != null && this.e != null) {
            this.d.post(new bfk(this, iOException));
        }
        if (iOException instanceof zzmb) {
            return 3;
        }
        boolean z = j() > this.F;
        if (this.C == -1 && (this.r == null || this.r.b() == -9223372036854775807L)) {
            this.D = 0L;
            this.v = this.t;
            int size = this.p.size();
            for (int i = 0; i < size; i++) {
                this.p.valueAt(i).a(!this.t || this.z[i]);
            }
            bflVar.a(0L, 0L);
        }
        this.F = j();
        return z ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.bjj
    public final /* synthetic */ void a(bjl bjlVar, long j, long j2, boolean z) {
        a((bfl) bjlVar);
        if (z || this.w <= 0) {
            return;
        }
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            this.p.valueAt(i).a(this.z[i]);
        }
        this.q.a((bfr) this);
    }

    @Override // com.google.android.gms.internal.ads.bjj
    public final /* synthetic */ void a(bjl bjlVar, long j, long j2) {
        a((bfl) bjlVar);
        this.G = true;
        if (this.y == -9223372036854775807L) {
            long jK = k();
            this.y = jK == Long.MIN_VALUE ? 0L : jK + 10000;
            this.f.a(new bgc(this.y, this.r.a()), null);
        }
        this.q.a((bfr) this);
    }
}
