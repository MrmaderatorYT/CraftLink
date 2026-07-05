package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public abstract class aqa {

    /* renamed from: a, reason: collision with root package name */
    int f2159a;

    /* renamed from: b, reason: collision with root package name */
    int f2160b;
    aqd c;
    private int d;
    private boolean e;

    public static long a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static aqa a(byte[] bArr, int i, int i2) {
        return a(bArr, i, i2, false);
    }

    public static int g(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract int a();

    public abstract <T extends asf> T a(asq<T> asqVar, aqk aqkVar);

    public abstract void a(int i);

    public abstract double b();

    public abstract boolean b(int i);

    public abstract float c();

    public abstract int d(int i);

    public abstract long d();

    public abstract long e();

    public abstract void e(int i);

    public abstract int f();

    public abstract void f(int i);

    public abstract long g();

    public abstract int h();

    public abstract boolean i();

    public abstract String j();

    public abstract String k();

    public abstract apo l();

    public abstract int m();

    public abstract int n();

    public abstract int o();

    public abstract long p();

    public abstract int q();

    public abstract long r();

    abstract long s();

    public abstract boolean t();

    public abstract int u();

    static aqa a(byte[] bArr, int i, int i2, boolean z) {
        aqc aqcVar = new aqc(bArr, i, i2, z);
        try {
            aqcVar.d(i2);
            return aqcVar;
        } catch (zzbrl e) {
            throw new IllegalArgumentException(e);
        }
    }

    private aqa() {
        this.f2160b = 100;
        this.d = Integer.MAX_VALUE;
        this.e = false;
    }

    public final int c(int i) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder(47);
            sb.append("Recursion limit cannot be negative: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        int i2 = this.f2160b;
        this.f2160b = i;
        return i2;
    }
}
