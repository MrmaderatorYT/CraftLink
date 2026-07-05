package io.netty.b;

/* compiled from: PoolSubpage.java */
/* loaded from: classes.dex */
final class u<T> {
    static final /* synthetic */ boolean f = !u.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    final r<T> f4402a;

    /* renamed from: b, reason: collision with root package name */
    u<T> f4403b;
    u<T> c;
    boolean d;
    int e;
    private final int g;
    private final int h;
    private final int i;
    private final long[] j;
    private int k;
    private int l;
    private int m;
    private int n;

    u(int i) {
        this.f4402a = null;
        this.g = -1;
        this.h = -1;
        this.e = -1;
        this.i = i;
        this.j = null;
    }

    u(u<T> uVar, r<T> rVar, int i, int i2, int i3, int i4) {
        this.f4402a = rVar;
        this.g = i;
        this.h = i2;
        this.i = i3;
        this.j = new long[i3 >>> 10];
        a(uVar, i4);
    }

    void a(u<T> uVar, int i) {
        this.d = true;
        this.e = i;
        if (i != 0) {
            int i2 = this.i / i;
            this.n = i2;
            this.k = i2;
            this.m = 0;
            this.l = this.k >>> 6;
            if ((this.k & 63) != 0) {
                this.l++;
            }
            for (int i3 = 0; i3 < this.l; i3++) {
                this.j[i3] = 0;
            }
        }
        a(uVar);
    }

    long a() {
        if (this.e == 0) {
            return b(0);
        }
        if (this.n == 0 || !this.d) {
            return -1L;
        }
        int iD = d();
        int i = iD >>> 6;
        int i2 = iD & 63;
        if (!f && ((this.j[i] >>> i2) & 1) != 0) {
            throw new AssertionError();
        }
        long[] jArr = this.j;
        jArr[i] = (1 << i2) | jArr[i];
        int i3 = this.n - 1;
        this.n = i3;
        if (i3 == 0) {
            c();
        }
        return b(iD);
    }

    boolean b(u<T> uVar, int i) {
        if (this.e == 0) {
            return true;
        }
        int i2 = i >>> 6;
        int i3 = i & 63;
        if (!f && ((this.j[i2] >>> i3) & 1) == 0) {
            throw new AssertionError();
        }
        long[] jArr = this.j;
        jArr[i2] = (1 << i3) ^ jArr[i2];
        a(i);
        int i4 = this.n;
        this.n = i4 + 1;
        if (i4 == 0) {
            a(uVar);
            return true;
        }
        if (this.n != this.k || this.f4403b == this.c) {
            return true;
        }
        this.d = false;
        c();
        return false;
    }

    private void a(u<T> uVar) {
        if (!f && (this.f4403b != null || this.c != null)) {
            throw new AssertionError();
        }
        this.f4403b = uVar;
        this.c = uVar.c;
        this.c.f4403b = this;
        uVar.c = this;
    }

    private void c() {
        if (!f && (this.f4403b == null || this.c == null)) {
            throw new AssertionError();
        }
        this.f4403b.c = this.c;
        this.c.f4403b = this.f4403b;
        this.c = null;
        this.f4403b = null;
    }

    private void a(int i) {
        this.m = i;
    }

    private int d() {
        int i = this.m;
        if (i >= 0) {
            this.m = -1;
            return i;
        }
        return e();
    }

    private int e() {
        long[] jArr = this.j;
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            long j = jArr[i2];
            if (((-1) ^ j) != 0) {
                return a(i2, j);
            }
        }
        return -1;
    }

    private int a(int i, long j) {
        int i2 = this.k;
        int i3 = i << 6;
        for (int i4 = 0; i4 < 64; i4++) {
            if ((1 & j) == 0) {
                int i5 = i3 | i4;
                if (i5 < i2) {
                    return i5;
                }
                return -1;
            }
            j >>>= 1;
        }
        return -1;
    }

    private long b(int i) {
        return (i << 32) | 4611686018427387904L | this.g;
    }

    public String toString() {
        if (!this.d) {
            return "(" + this.g + ": not in use)";
        }
        return String.valueOf('(') + this.g + ": " + (this.k - this.n) + '/' + this.k + ", offset: " + this.h + ", length: " + this.i + ", elemSize: " + this.e + ')';
    }

    void b() {
        if (this.f4402a != null) {
            this.f4402a.c();
        }
    }
}
