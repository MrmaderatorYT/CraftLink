package io.netty.b;

/* compiled from: PoolChunk.java */
/* loaded from: classes.dex */
final class r<T> {
    static final /* synthetic */ boolean g = !r.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    final q<T> f4398a;

    /* renamed from: b, reason: collision with root package name */
    final T f4399b;
    final boolean c;
    s<T> d;
    r<T> e;
    r<T> f;
    private final byte[] h;
    private final byte[] i;
    private final u<T>[] j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private final int p;
    private final int q;
    private final byte r;
    private int s;

    private static int b(long j) {
        return (int) j;
    }

    private static int c(long j) {
        return (int) (j >>> 32);
    }

    r(q<T> qVar, T t, int i, int i2, int i3, int i4) {
        this.c = false;
        this.f4398a = qVar;
        this.f4399b = t;
        this.l = i;
        this.m = i3;
        this.n = i2;
        this.o = i4;
        this.r = (byte) (i2 + 1);
        this.p = j(i4);
        this.k = (i - 1) ^ (-1);
        this.s = i4;
        if (!g && i2 >= 30) {
            throw new AssertionError("maxOrder should be < 30, but is: " + i2);
        }
        this.q = 1 << i2;
        this.h = new byte[this.q << 1];
        this.i = new byte[this.h.length];
        int i5 = 0;
        int i6 = 1;
        while (i5 <= i2) {
            int i7 = 1 << i5;
            int i8 = i6;
            for (int i9 = 0; i9 < i7; i9++) {
                byte b2 = (byte) i5;
                this.h[i8] = b2;
                this.i[i8] = b2;
                i8++;
            }
            i5++;
            i6 = i8;
        }
        this.j = b(this.q);
    }

    r(q<T> qVar, T t, int i) {
        this.c = true;
        this.f4398a = qVar;
        this.f4399b = t;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.r = (byte) (this.n + 1);
        this.o = i;
        this.p = j(this.o);
        this.q = 0;
    }

    private u<T>[] b(int i) {
        return new u[i];
    }

    public int a() {
        int i = this.s;
        if (i == 0) {
            return 100;
        }
        int i2 = (int) ((i * 100) / this.o);
        if (i2 == 0) {
            return 99;
        }
        return 100 - i2;
    }

    long a(int i) {
        if ((this.k & i) != 0) {
            return f(i);
        }
        return g(i);
    }

    private void c(int i) {
        while (i > 1) {
            int i2 = i >>> 1;
            byte bH = h(i);
            byte bH2 = h(i ^ 1);
            if (bH < bH2) {
                bH2 = bH;
            }
            a(i2, bH2);
            i = i2;
        }
    }

    private void d(int i) {
        int i2 = i(i) + 1;
        while (i > 1) {
            int i3 = i >>> 1;
            byte bH = h(i);
            byte bH2 = h(i ^ 1);
            i2--;
            if (bH == i2 && bH2 == i2) {
                a(i3, (byte) (i2 - 1));
            } else {
                if (bH < bH2) {
                    bH2 = bH;
                }
                a(i3, bH2);
            }
            i = i3;
        }
    }

    private int e(int i) {
        int i2;
        int i3 = 1 << i;
        int i4 = -i3;
        byte bH = h(1);
        if (bH > i) {
            return -1;
        }
        int i5 = 1;
        while (true) {
            if (bH >= i) {
                i2 = i5 & i4;
                if (i2 != 0) {
                    break;
                }
            }
            i5 <<= 1;
            bH = h(i5);
            if (bH > i) {
                i5 ^= 1;
                bH = h(i5);
            }
        }
        byte bH2 = h(i5);
        if (!g && (bH2 != i || i2 != i3)) {
            throw new AssertionError(String.format("val = %d, id & initial = %d, d = %d", Byte.valueOf(bH2), Integer.valueOf(i2), Integer.valueOf(i)));
        }
        a(i5, this.r);
        c(i5);
        return i5;
    }

    private long f(int i) {
        int iE = e(this.n - (j(i) - this.m));
        if (iE < 0) {
            return iE;
        }
        this.s -= k(iE);
        return iE;
    }

    private long g(int i) {
        u<T> uVarE = this.f4398a.e(i);
        synchronized (uVarE) {
            int iE = e(this.n);
            if (iE < 0) {
                return iE;
            }
            u<T>[] uVarArr = this.j;
            int i2 = this.l;
            this.s -= i2;
            int iM = m(iE);
            u<T> uVar = uVarArr[iM];
            if (uVar == null) {
                u<T> uVar2 = new u<>(uVarE, this, iE, l(iE), i2, i);
                uVarArr[iM] = uVar2;
                uVar = uVar2;
            } else {
                uVar.a(uVarE, i);
            }
            return uVar.a();
        }
    }

    void a(long j) {
        int iB = b(j);
        int iC = c(j);
        if (iC != 0) {
            u<T> uVar = this.j[m(iB)];
            if (!g && (uVar == null || !uVar.d)) {
                throw new AssertionError();
            }
            u<T> uVarE = this.f4398a.e(uVar.e);
            synchronized (uVarE) {
                if (uVar.b(uVarE, iC & 1073741823)) {
                    return;
                }
            }
        }
        this.s += k(iB);
        a(iB, i(iB));
        d(iB);
    }

    void a(w<T> wVar, long j, int i) {
        int iB = b(j);
        int iC = c(j);
        if (iC == 0) {
            byte bH = h(iB);
            if (!g && bH != this.r) {
                throw new AssertionError(String.valueOf((int) bH));
            }
            wVar.a(this, j, l(iB), i, k(iB), this.f4398a.f4394b.d());
            return;
        }
        a(wVar, j, iC, i);
    }

    void b(w<T> wVar, long j, int i) {
        a(wVar, j, c(j), i);
    }

    private void a(w<T> wVar, long j, int i, int i2) {
        if (!g && i == 0) {
            throw new AssertionError();
        }
        int iB = b(j);
        u<T> uVar = this.j[m(iB)];
        if (!g && !uVar.d) {
            throw new AssertionError();
        }
        if (!g && i2 > uVar.e) {
            throw new AssertionError();
        }
        wVar.a(this, j, l(iB) + ((i & 1073741823) * uVar.e), i2, uVar.e, this.f4398a.f4394b.d());
    }

    private byte h(int i) {
        return this.h[i];
    }

    private void a(int i, byte b2) {
        this.h[i] = b2;
    }

    private byte i(int i) {
        return this.i[i];
    }

    private static int j(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    private int k(int i) {
        return 1 << (this.p - i(i));
    }

    private int l(int i) {
        return ((1 << i(i)) ^ i) * k(i);
    }

    private int m(int i) {
        return i ^ this.q;
    }

    public int b() {
        return this.o;
    }

    public String toString() {
        return "Chunk(" + Integer.toHexString(System.identityHashCode(this)) + ": " + a() + "%, " + (this.o - this.s) + '/' + this.o + ')';
    }

    void c() {
        this.f4398a.a(this);
    }
}
