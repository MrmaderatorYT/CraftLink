package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bfu {
    private int i;
    private int j;
    private int k;
    private int l;
    private bab q;

    /* renamed from: a, reason: collision with root package name */
    private int f2626a = 1000;

    /* renamed from: b, reason: collision with root package name */
    private int[] f2627b = new int[this.f2626a];
    private long[] c = new long[this.f2626a];
    private long[] f = new long[this.f2626a];
    private int[] e = new int[this.f2626a];
    private int[] d = new int[this.f2626a];
    private bcn[] g = new bcn[this.f2626a];
    private bab[] h = new bab[this.f2626a];
    private long m = Long.MIN_VALUE;
    private long n = Long.MIN_VALUE;
    private boolean p = true;
    private boolean o = true;

    public final void a() {
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.i = 0;
        this.o = true;
    }

    public final void b() {
        this.m = Long.MIN_VALUE;
        this.n = Long.MIN_VALUE;
    }

    public final int c() {
        return this.j + this.i;
    }

    public final long a(int i) {
        int iC = c() - i;
        bjq.a(iC >= 0 && iC <= this.i);
        if (iC == 0) {
            if (this.j == 0 && this.i == 0) {
                return 0L;
            }
            return this.c[(this.l == 0 ? this.f2626a : this.l) - 1] + this.d[r0];
        }
        this.i -= iC;
        this.l = ((this.l + this.f2626a) - iC) % this.f2626a;
        this.n = Long.MIN_VALUE;
        for (int i2 = this.i - 1; i2 >= 0; i2--) {
            int i3 = (this.k + i2) % this.f2626a;
            this.n = Math.max(this.n, this.f[i3]);
            if ((this.e[i3] & 1) != 0) {
                break;
            }
        }
        return this.c[this.l];
    }

    public final int d() {
        return this.j;
    }

    public final synchronized boolean e() {
        return this.i != 0;
    }

    public final synchronized bab f() {
        if (this.p) {
            return null;
        }
        return this.q;
    }

    public final synchronized long g() {
        return Math.max(this.m, this.n);
    }

    public final synchronized int a(bad badVar, bbs bbsVar, boolean z, boolean z2, bab babVar, bfv bfvVar) {
        if (!e()) {
            if (z2) {
                bbsVar.a(4);
                return -4;
            }
            if (this.q == null || (!z && this.q == babVar)) {
                return -3;
            }
            badVar.f2444a = this.q;
            return -5;
        }
        if (!z && this.h[this.k] == babVar) {
            if (bbsVar.f2503b == null) {
                return -3;
            }
            bbsVar.c = this.f[this.k];
            bbsVar.a(this.e[this.k]);
            bfvVar.f2628a = this.d[this.k];
            bfvVar.f2629b = this.c[this.k];
            bfvVar.d = this.g[this.k];
            this.m = Math.max(this.m, bbsVar.c);
            this.i--;
            this.k++;
            this.j++;
            if (this.k == this.f2626a) {
                this.k = 0;
            }
            bfvVar.c = this.i > 0 ? this.c[this.k] : bfvVar.f2629b + bfvVar.f2628a;
            return -4;
        }
        badVar.f2444a = this.h[this.k];
        return -5;
    }

    public final synchronized long h() {
        if (!e()) {
            return -1L;
        }
        int i = ((this.k + this.i) - 1) % this.f2626a;
        this.k = (this.k + this.i) % this.f2626a;
        this.j += this.i;
        this.i = 0;
        return this.c[i] + this.d[i];
    }

    public final synchronized long a(long j, boolean z) {
        if (e() && j >= this.f[this.k]) {
            if (j > this.n && !z) {
                return -1L;
            }
            int i = this.k;
            int i2 = -1;
            int i3 = 0;
            while (i != this.l && this.f[i] <= j) {
                if ((this.e[i] & 1) != 0) {
                    i2 = i3;
                }
                i = (i + 1) % this.f2626a;
                i3++;
            }
            if (i2 == -1) {
                return -1L;
            }
            this.k = (this.k + i2) % this.f2626a;
            this.j += i2;
            this.i -= i2;
            return this.c[this.k];
        }
        return -1L;
    }

    public final synchronized boolean a(bab babVar) {
        if (babVar == null) {
            this.p = true;
            return false;
        }
        this.p = false;
        if (bkg.a(babVar, this.q)) {
            return false;
        }
        this.q = babVar;
        return true;
    }

    public final synchronized void a(long j, int i, long j2, int i2, bcn bcnVar) {
        if (this.o) {
            if ((i & 1) == 0) {
                return;
            } else {
                this.o = false;
            }
        }
        bjq.b(!this.p);
        a(j);
        this.f[this.l] = j;
        this.c[this.l] = j2;
        this.d[this.l] = i2;
        this.e[this.l] = i;
        this.g[this.l] = bcnVar;
        this.h[this.l] = this.q;
        this.f2627b[this.l] = 0;
        this.i++;
        if (this.i == this.f2626a) {
            int i3 = this.f2626a + 1000;
            int[] iArr = new int[i3];
            long[] jArr = new long[i3];
            long[] jArr2 = new long[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            bcn[] bcnVarArr = new bcn[i3];
            bab[] babVarArr = new bab[i3];
            int i4 = this.f2626a - this.k;
            System.arraycopy(this.c, this.k, jArr, 0, i4);
            System.arraycopy(this.f, this.k, jArr2, 0, i4);
            System.arraycopy(this.e, this.k, iArr2, 0, i4);
            System.arraycopy(this.d, this.k, iArr3, 0, i4);
            System.arraycopy(this.g, this.k, bcnVarArr, 0, i4);
            System.arraycopy(this.h, this.k, babVarArr, 0, i4);
            System.arraycopy(this.f2627b, this.k, iArr, 0, i4);
            int i5 = this.k;
            System.arraycopy(this.c, 0, jArr, i4, i5);
            System.arraycopy(this.f, 0, jArr2, i4, i5);
            System.arraycopy(this.e, 0, iArr2, i4, i5);
            System.arraycopy(this.d, 0, iArr3, i4, i5);
            System.arraycopy(this.g, 0, bcnVarArr, i4, i5);
            System.arraycopy(this.h, 0, babVarArr, i4, i5);
            System.arraycopy(this.f2627b, 0, iArr, i4, i5);
            this.c = jArr;
            this.f = jArr2;
            this.e = iArr2;
            this.d = iArr3;
            this.g = bcnVarArr;
            this.h = babVarArr;
            this.f2627b = iArr;
            this.k = 0;
            this.l = this.f2626a;
            this.i = this.f2626a;
            this.f2626a = i3;
            return;
        }
        this.l++;
        if (this.l == this.f2626a) {
            this.l = 0;
        }
    }

    public final synchronized void a(long j) {
        this.n = Math.max(this.n, j);
    }
}
