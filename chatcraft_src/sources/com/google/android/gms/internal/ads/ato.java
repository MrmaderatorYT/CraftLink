package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
abstract class ato<T, B> {
    ato() {
    }

    abstract B a();

    abstract T a(B b2);

    abstract void a(B b2, int i, int i2);

    abstract void a(B b2, int i, long j);

    abstract void a(B b2, int i, apo apoVar);

    abstract void a(B b2, int i, T t);

    abstract void a(T t, auk aukVar);

    abstract void a(Object obj, T t);

    abstract boolean a(asw aswVar);

    abstract T b(Object obj);

    abstract void b(B b2, int i, long j);

    abstract void b(T t, auk aukVar);

    abstract void b(Object obj, B b2);

    abstract B c(Object obj);

    abstract T c(T t, T t2);

    abstract void d(Object obj);

    abstract int e(T t);

    abstract int f(T t);

    final boolean a(B b2, asw aswVar) throws zzbrl {
        int iB = aswVar.b();
        int i = iB >>> 3;
        switch (iB & 7) {
            case 0:
                a((ato<T, B>) b2, i, aswVar.g());
                return true;
            case 1:
                b(b2, i, aswVar.i());
                return true;
            case 2:
                a((ato<T, B>) b2, i, aswVar.n());
                return true;
            case 3:
                B bA = a();
                int i2 = (i << 3) | 4;
                while (aswVar.a() != Integer.MAX_VALUE && a((ato<T, B>) bA, aswVar)) {
                }
                if (i2 != aswVar.b()) {
                    throw zzbrl.e();
                }
                a((ato<T, B>) b2, i, (int) a((ato<T, B>) bA));
                return true;
            case 4:
                return false;
            case 5:
                a((ato<T, B>) b2, i, aswVar.j());
                return true;
            default:
                throw zzbrl.f();
        }
    }
}
