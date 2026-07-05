package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes.dex */
final class aqd implements asw {

    /* renamed from: a, reason: collision with root package name */
    private final aqa f2161a;

    /* renamed from: b, reason: collision with root package name */
    private int f2162b;
    private int c;
    private int d = 0;

    public static aqd a(aqa aqaVar) {
        return aqaVar.c != null ? aqaVar.c : new aqd(aqaVar);
    }

    private aqd(aqa aqaVar) {
        this.f2161a = (aqa) ara.a(aqaVar, "input");
        this.f2161a.c = this;
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final int a() {
        if (this.d != 0) {
            this.f2162b = this.d;
            this.d = 0;
        } else {
            this.f2162b = this.f2161a.a();
        }
        if (this.f2162b == 0 || this.f2162b == this.c) {
            return Integer.MAX_VALUE;
        }
        return this.f2162b >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final int b() {
        return this.f2162b;
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final boolean c() {
        if (this.f2161a.t() || this.f2162b == this.c) {
            return false;
        }
        return this.f2161a.b(this.f2162b);
    }

    private final void a(int i) throws zzbrm {
        if ((this.f2162b & 7) != i) {
            throw zzbrl.f();
        }
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final double d() throws zzbrm {
        a(1);
        return this.f2161a.b();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final float e() throws zzbrm {
        a(5);
        return this.f2161a.c();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final long f() throws zzbrm {
        a(0);
        return this.f2161a.d();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final long g() throws zzbrm {
        a(0);
        return this.f2161a.e();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final int h() throws zzbrm {
        a(0);
        return this.f2161a.f();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final long i() throws zzbrm {
        a(1);
        return this.f2161a.g();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final int j() throws zzbrm {
        a(5);
        return this.f2161a.h();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final boolean k() throws zzbrm {
        a(0);
        return this.f2161a.i();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final String l() throws zzbrm {
        a(2);
        return this.f2161a.j();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final String m() throws zzbrm {
        a(2);
        return this.f2161a.k();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final <T> T a(asx<T> asxVar, aqk aqkVar) throws zzbrm {
        a(2);
        return (T) c(asxVar, aqkVar);
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final <T> T b(asx<T> asxVar, aqk aqkVar) throws zzbrm {
        a(3);
        return (T) d(asxVar, aqkVar);
    }

    private final <T> T c(asx<T> asxVar, aqk aqkVar) throws zzbrl {
        int iM = this.f2161a.m();
        if (this.f2161a.f2159a >= this.f2161a.f2160b) {
            throw zzbrl.g();
        }
        int iD = this.f2161a.d(iM);
        T tA = asxVar.a();
        this.f2161a.f2159a++;
        asxVar.a(tA, this, aqkVar);
        asxVar.c(tA);
        this.f2161a.a(0);
        aqa aqaVar = this.f2161a;
        aqaVar.f2159a--;
        this.f2161a.e(iD);
        return tA;
    }

    private final <T> T d(asx<T> asxVar, aqk aqkVar) {
        int i = this.c;
        this.c = ((this.f2162b >>> 3) << 3) | 4;
        try {
            T tA = asxVar.a();
            asxVar.a(tA, this, aqkVar);
            asxVar.c(tA);
            if (this.f2162b == this.c) {
                return tA;
            }
            throw zzbrl.h();
        } finally {
            this.c = i;
        }
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final apo n() throws zzbrm {
        a(2);
        return this.f2161a.l();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final int o() throws zzbrm {
        a(0);
        return this.f2161a.m();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final int p() throws zzbrm {
        a(0);
        return this.f2161a.n();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final int q() throws zzbrm {
        a(5);
        return this.f2161a.o();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final long r() throws zzbrm {
        a(1);
        return this.f2161a.p();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final int s() throws zzbrm {
        a(0);
        return this.f2161a.q();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final long t() throws zzbrm {
        a(0);
        return this.f2161a.r();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final void a(List<Double> list) throws zzbrl {
        int iA;
        int iA2;
        if (list instanceof aqh) {
            aqh aqhVar = (aqh) list;
            switch (this.f2162b & 7) {
                case 1:
                    break;
                case 2:
                    int iM = this.f2161a.m();
                    b(iM);
                    int iU = this.f2161a.u() + iM;
                    do {
                        aqhVar.a(this.f2161a.b());
                    } while (this.f2161a.u() < iU);
                    return;
                default:
                    throw zzbrl.f();
            }
            do {
                aqhVar.a(this.f2161a.b());
                if (this.f2161a.t()) {
                    return;
                } else {
                    iA2 = this.f2161a.a();
                }
            } while (iA2 == this.f2162b);
            this.d = iA2;
            return;
        }
        switch (this.f2162b & 7) {
            case 1:
                break;
            case 2:
                int iM2 = this.f2161a.m();
                b(iM2);
                int iU2 = this.f2161a.u() + iM2;
                do {
                    list.add(Double.valueOf(this.f2161a.b()));
                } while (this.f2161a.u() < iU2);
                return;
            default:
                throw zzbrl.f();
        }
        do {
            list.add(Double.valueOf(this.f2161a.b()));
            if (this.f2161a.t()) {
                return;
            } else {
                iA = this.f2161a.a();
            }
        } while (iA == this.f2162b);
        this.d = iA;
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final void b(List<Float> list) throws zzbrl {
        int iA;
        int iA2;
        if (list instanceof aqv) {
            aqv aqvVar = (aqv) list;
            int i = this.f2162b & 7;
            if (i == 2) {
                int iM = this.f2161a.m();
                c(iM);
                int iU = this.f2161a.u() + iM;
                do {
                    aqvVar.a(this.f2161a.c());
                } while (this.f2161a.u() < iU);
                return;
            }
            if (i == 5) {
                do {
                    aqvVar.a(this.f2161a.c());
                    if (this.f2161a.t()) {
                        return;
                    } else {
                        iA2 = this.f2161a.a();
                    }
                } while (iA2 == this.f2162b);
                this.d = iA2;
                return;
            }
            throw zzbrl.f();
        }
        int i2 = this.f2162b & 7;
        if (i2 == 2) {
            int iM2 = this.f2161a.m();
            c(iM2);
            int iU2 = this.f2161a.u() + iM2;
            do {
                list.add(Float.valueOf(this.f2161a.c()));
            } while (this.f2161a.u() < iU2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Float.valueOf(this.f2161a.c()));
                if (this.f2161a.t()) {
                    return;
                } else {
                    iA = this.f2161a.a();
                }
            } while (iA == this.f2162b);
            this.d = iA;
            return;
        }
        throw zzbrl.f();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final void c(List<Long> list) throws zzbrl {
        int iA;
        int iA2;
        if (list instanceof ars) {
            ars arsVar = (ars) list;
            int i = this.f2162b & 7;
            if (i == 0) {
                do {
                    arsVar.a(this.f2161a.d());
                    if (this.f2161a.t()) {
                        return;
                    } else {
                        iA2 = this.f2161a.a();
                    }
                } while (iA2 == this.f2162b);
                this.d = iA2;
                return;
            }
            if (i == 2) {
                int iU = this.f2161a.u() + this.f2161a.m();
                do {
                    arsVar.a(this.f2161a.d());
                } while (this.f2161a.u() < iU);
                d(iU);
                return;
            }
            throw zzbrl.f();
        }
        int i2 = this.f2162b & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.f2161a.d()));
                if (this.f2161a.t()) {
                    return;
                } else {
                    iA = this.f2161a.a();
                }
            } while (iA == this.f2162b);
            this.d = iA;
            return;
        }
        if (i2 == 2) {
            int iU2 = this.f2161a.u() + this.f2161a.m();
            do {
                list.add(Long.valueOf(this.f2161a.d()));
            } while (this.f2161a.u() < iU2);
            d(iU2);
            return;
        }
        throw zzbrl.f();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final void d(List<Long> list) throws zzbrl {
        int iA;
        int iA2;
        if (list instanceof ars) {
            ars arsVar = (ars) list;
            int i = this.f2162b & 7;
            if (i == 0) {
                do {
                    arsVar.a(this.f2161a.e());
                    if (this.f2161a.t()) {
                        return;
                    } else {
                        iA2 = this.f2161a.a();
                    }
                } while (iA2 == this.f2162b);
                this.d = iA2;
                return;
            }
            if (i == 2) {
                int iU = this.f2161a.u() + this.f2161a.m();
                do {
                    arsVar.a(this.f2161a.e());
                } while (this.f2161a.u() < iU);
                d(iU);
                return;
            }
            throw zzbrl.f();
        }
        int i2 = this.f2162b & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.f2161a.e()));
                if (this.f2161a.t()) {
                    return;
                } else {
                    iA = this.f2161a.a();
                }
            } while (iA == this.f2162b);
            this.d = iA;
            return;
        }
        if (i2 == 2) {
            int iU2 = this.f2161a.u() + this.f2161a.m();
            do {
                list.add(Long.valueOf(this.f2161a.e()));
            } while (this.f2161a.u() < iU2);
            d(iU2);
            return;
        }
        throw zzbrl.f();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final void e(List<Integer> list) throws zzbrl {
        int iA;
        int iA2;
        if (list instanceof aqz) {
            aqz aqzVar = (aqz) list;
            int i = this.f2162b & 7;
            if (i == 0) {
                do {
                    aqzVar.c(this.f2161a.f());
                    if (this.f2161a.t()) {
                        return;
                    } else {
                        iA2 = this.f2161a.a();
                    }
                } while (iA2 == this.f2162b);
                this.d = iA2;
                return;
            }
            if (i == 2) {
                int iU = this.f2161a.u() + this.f2161a.m();
                do {
                    aqzVar.c(this.f2161a.f());
                } while (this.f2161a.u() < iU);
                d(iU);
                return;
            }
            throw zzbrl.f();
        }
        int i2 = this.f2162b & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.f2161a.f()));
                if (this.f2161a.t()) {
                    return;
                } else {
                    iA = this.f2161a.a();
                }
            } while (iA == this.f2162b);
            this.d = iA;
            return;
        }
        if (i2 == 2) {
            int iU2 = this.f2161a.u() + this.f2161a.m();
            do {
                list.add(Integer.valueOf(this.f2161a.f()));
            } while (this.f2161a.u() < iU2);
            d(iU2);
            return;
        }
        throw zzbrl.f();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final void f(List<Long> list) throws zzbrl {
        int iA;
        int iA2;
        if (list instanceof ars) {
            ars arsVar = (ars) list;
            switch (this.f2162b & 7) {
                case 1:
                    break;
                case 2:
                    int iM = this.f2161a.m();
                    b(iM);
                    int iU = this.f2161a.u() + iM;
                    do {
                        arsVar.a(this.f2161a.g());
                    } while (this.f2161a.u() < iU);
                    return;
                default:
                    throw zzbrl.f();
            }
            do {
                arsVar.a(this.f2161a.g());
                if (this.f2161a.t()) {
                    return;
                } else {
                    iA2 = this.f2161a.a();
                }
            } while (iA2 == this.f2162b);
            this.d = iA2;
            return;
        }
        switch (this.f2162b & 7) {
            case 1:
                break;
            case 2:
                int iM2 = this.f2161a.m();
                b(iM2);
                int iU2 = this.f2161a.u() + iM2;
                do {
                    list.add(Long.valueOf(this.f2161a.g()));
                } while (this.f2161a.u() < iU2);
                return;
            default:
                throw zzbrl.f();
        }
        do {
            list.add(Long.valueOf(this.f2161a.g()));
            if (this.f2161a.t()) {
                return;
            } else {
                iA = this.f2161a.a();
            }
        } while (iA == this.f2162b);
        this.d = iA;
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final void g(List<Integer> list) throws zzbrl {
        int iA;
        int iA2;
        if (list instanceof aqz) {
            aqz aqzVar = (aqz) list;
            int i = this.f2162b & 7;
            if (i == 2) {
                int iM = this.f2161a.m();
                c(iM);
                int iU = this.f2161a.u() + iM;
                do {
                    aqzVar.c(this.f2161a.h());
                } while (this.f2161a.u() < iU);
                return;
            }
            if (i == 5) {
                do {
                    aqzVar.c(this.f2161a.h());
                    if (this.f2161a.t()) {
                        return;
                    } else {
                        iA2 = this.f2161a.a();
                    }
                } while (iA2 == this.f2162b);
                this.d = iA2;
                return;
            }
            throw zzbrl.f();
        }
        int i2 = this.f2162b & 7;
        if (i2 == 2) {
            int iM2 = this.f2161a.m();
            c(iM2);
            int iU2 = this.f2161a.u() + iM2;
            do {
                list.add(Integer.valueOf(this.f2161a.h()));
            } while (this.f2161a.u() < iU2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.f2161a.h()));
                if (this.f2161a.t()) {
                    return;
                } else {
                    iA = this.f2161a.a();
                }
            } while (iA == this.f2162b);
            this.d = iA;
            return;
        }
        throw zzbrl.f();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final void h(List<Boolean> list) throws zzbrl {
        int iA;
        int iA2;
        if (list instanceof apm) {
            apm apmVar = (apm) list;
            int i = this.f2162b & 7;
            if (i == 0) {
                do {
                    apmVar.a(this.f2161a.i());
                    if (this.f2161a.t()) {
                        return;
                    } else {
                        iA2 = this.f2161a.a();
                    }
                } while (iA2 == this.f2162b);
                this.d = iA2;
                return;
            }
            if (i == 2) {
                int iU = this.f2161a.u() + this.f2161a.m();
                do {
                    apmVar.a(this.f2161a.i());
                } while (this.f2161a.u() < iU);
                d(iU);
                return;
            }
            throw zzbrl.f();
        }
        int i2 = this.f2162b & 7;
        if (i2 == 0) {
            do {
                list.add(Boolean.valueOf(this.f2161a.i()));
                if (this.f2161a.t()) {
                    return;
                } else {
                    iA = this.f2161a.a();
                }
            } while (iA == this.f2162b);
            this.d = iA;
            return;
        }
        if (i2 == 2) {
            int iU2 = this.f2161a.u() + this.f2161a.m();
            do {
                list.add(Boolean.valueOf(this.f2161a.i()));
            } while (this.f2161a.u() < iU2);
            d(iU2);
            return;
        }
        throw zzbrl.f();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final void i(List<String> list) throws zzbrm {
        a(list, false);
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final void j(List<String> list) throws zzbrm {
        a(list, true);
    }

    private final void a(List<String> list, boolean z) throws zzbrm {
        int iA;
        int iA2;
        if ((this.f2162b & 7) != 2) {
            throw zzbrl.f();
        }
        if ((list instanceof arn) && !z) {
            arn arnVar = (arn) list;
            do {
                arnVar.a(n());
                if (this.f2161a.t()) {
                    return;
                } else {
                    iA2 = this.f2161a.a();
                }
            } while (iA2 == this.f2162b);
            this.d = iA2;
            return;
        }
        do {
            list.add(z ? m() : l());
            if (this.f2161a.t()) {
                return;
            } else {
                iA = this.f2161a.a();
            }
        } while (iA == this.f2162b);
        this.d = iA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.asw
    public final <T> void a(List<T> list, asx<T> asxVar, aqk aqkVar) throws zzbrm {
        int iA;
        if ((this.f2162b & 7) != 2) {
            throw zzbrl.f();
        }
        int i = this.f2162b;
        do {
            list.add(c(asxVar, aqkVar));
            if (this.f2161a.t() || this.d != 0) {
                return;
            } else {
                iA = this.f2161a.a();
            }
        } while (iA == i);
        this.d = iA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.asw
    public final <T> void b(List<T> list, asx<T> asxVar, aqk aqkVar) throws zzbrm {
        int iA;
        if ((this.f2162b & 7) != 3) {
            throw zzbrl.f();
        }
        int i = this.f2162b;
        do {
            list.add(d(asxVar, aqkVar));
            if (this.f2161a.t() || this.d != 0) {
                return;
            } else {
                iA = this.f2161a.a();
            }
        } while (iA == i);
        this.d = iA;
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final void k(List<apo> list) throws zzbrm {
        int iA;
        if ((this.f2162b & 7) != 2) {
            throw zzbrl.f();
        }
        do {
            list.add(n());
            if (this.f2161a.t()) {
                return;
            } else {
                iA = this.f2161a.a();
            }
        } while (iA == this.f2162b);
        this.d = iA;
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final void l(List<Integer> list) throws zzbrl {
        int iA;
        int iA2;
        if (list instanceof aqz) {
            aqz aqzVar = (aqz) list;
            int i = this.f2162b & 7;
            if (i == 0) {
                do {
                    aqzVar.c(this.f2161a.m());
                    if (this.f2161a.t()) {
                        return;
                    } else {
                        iA2 = this.f2161a.a();
                    }
                } while (iA2 == this.f2162b);
                this.d = iA2;
                return;
            }
            if (i == 2) {
                int iU = this.f2161a.u() + this.f2161a.m();
                do {
                    aqzVar.c(this.f2161a.m());
                } while (this.f2161a.u() < iU);
                d(iU);
                return;
            }
            throw zzbrl.f();
        }
        int i2 = this.f2162b & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.f2161a.m()));
                if (this.f2161a.t()) {
                    return;
                } else {
                    iA = this.f2161a.a();
                }
            } while (iA == this.f2162b);
            this.d = iA;
            return;
        }
        if (i2 == 2) {
            int iU2 = this.f2161a.u() + this.f2161a.m();
            do {
                list.add(Integer.valueOf(this.f2161a.m()));
            } while (this.f2161a.u() < iU2);
            d(iU2);
            return;
        }
        throw zzbrl.f();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final void m(List<Integer> list) throws zzbrl {
        int iA;
        int iA2;
        if (list instanceof aqz) {
            aqz aqzVar = (aqz) list;
            int i = this.f2162b & 7;
            if (i == 0) {
                do {
                    aqzVar.c(this.f2161a.n());
                    if (this.f2161a.t()) {
                        return;
                    } else {
                        iA2 = this.f2161a.a();
                    }
                } while (iA2 == this.f2162b);
                this.d = iA2;
                return;
            }
            if (i == 2) {
                int iU = this.f2161a.u() + this.f2161a.m();
                do {
                    aqzVar.c(this.f2161a.n());
                } while (this.f2161a.u() < iU);
                d(iU);
                return;
            }
            throw zzbrl.f();
        }
        int i2 = this.f2162b & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.f2161a.n()));
                if (this.f2161a.t()) {
                    return;
                } else {
                    iA = this.f2161a.a();
                }
            } while (iA == this.f2162b);
            this.d = iA;
            return;
        }
        if (i2 == 2) {
            int iU2 = this.f2161a.u() + this.f2161a.m();
            do {
                list.add(Integer.valueOf(this.f2161a.n()));
            } while (this.f2161a.u() < iU2);
            d(iU2);
            return;
        }
        throw zzbrl.f();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final void n(List<Integer> list) throws zzbrl {
        int iA;
        int iA2;
        if (list instanceof aqz) {
            aqz aqzVar = (aqz) list;
            int i = this.f2162b & 7;
            if (i == 2) {
                int iM = this.f2161a.m();
                c(iM);
                int iU = this.f2161a.u() + iM;
                do {
                    aqzVar.c(this.f2161a.o());
                } while (this.f2161a.u() < iU);
                return;
            }
            if (i == 5) {
                do {
                    aqzVar.c(this.f2161a.o());
                    if (this.f2161a.t()) {
                        return;
                    } else {
                        iA2 = this.f2161a.a();
                    }
                } while (iA2 == this.f2162b);
                this.d = iA2;
                return;
            }
            throw zzbrl.f();
        }
        int i2 = this.f2162b & 7;
        if (i2 == 2) {
            int iM2 = this.f2161a.m();
            c(iM2);
            int iU2 = this.f2161a.u() + iM2;
            do {
                list.add(Integer.valueOf(this.f2161a.o()));
            } while (this.f2161a.u() < iU2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.f2161a.o()));
                if (this.f2161a.t()) {
                    return;
                } else {
                    iA = this.f2161a.a();
                }
            } while (iA == this.f2162b);
            this.d = iA;
            return;
        }
        throw zzbrl.f();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final void o(List<Long> list) throws zzbrl {
        int iA;
        int iA2;
        if (list instanceof ars) {
            ars arsVar = (ars) list;
            switch (this.f2162b & 7) {
                case 1:
                    break;
                case 2:
                    int iM = this.f2161a.m();
                    b(iM);
                    int iU = this.f2161a.u() + iM;
                    do {
                        arsVar.a(this.f2161a.p());
                    } while (this.f2161a.u() < iU);
                    return;
                default:
                    throw zzbrl.f();
            }
            do {
                arsVar.a(this.f2161a.p());
                if (this.f2161a.t()) {
                    return;
                } else {
                    iA2 = this.f2161a.a();
                }
            } while (iA2 == this.f2162b);
            this.d = iA2;
            return;
        }
        switch (this.f2162b & 7) {
            case 1:
                break;
            case 2:
                int iM2 = this.f2161a.m();
                b(iM2);
                int iU2 = this.f2161a.u() + iM2;
                do {
                    list.add(Long.valueOf(this.f2161a.p()));
                } while (this.f2161a.u() < iU2);
                return;
            default:
                throw zzbrl.f();
        }
        do {
            list.add(Long.valueOf(this.f2161a.p()));
            if (this.f2161a.t()) {
                return;
            } else {
                iA = this.f2161a.a();
            }
        } while (iA == this.f2162b);
        this.d = iA;
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final void p(List<Integer> list) throws zzbrl {
        int iA;
        int iA2;
        if (list instanceof aqz) {
            aqz aqzVar = (aqz) list;
            int i = this.f2162b & 7;
            if (i == 0) {
                do {
                    aqzVar.c(this.f2161a.q());
                    if (this.f2161a.t()) {
                        return;
                    } else {
                        iA2 = this.f2161a.a();
                    }
                } while (iA2 == this.f2162b);
                this.d = iA2;
                return;
            }
            if (i == 2) {
                int iU = this.f2161a.u() + this.f2161a.m();
                do {
                    aqzVar.c(this.f2161a.q());
                } while (this.f2161a.u() < iU);
                d(iU);
                return;
            }
            throw zzbrl.f();
        }
        int i2 = this.f2162b & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.f2161a.q()));
                if (this.f2161a.t()) {
                    return;
                } else {
                    iA = this.f2161a.a();
                }
            } while (iA == this.f2162b);
            this.d = iA;
            return;
        }
        if (i2 == 2) {
            int iU2 = this.f2161a.u() + this.f2161a.m();
            do {
                list.add(Integer.valueOf(this.f2161a.q()));
            } while (this.f2161a.u() < iU2);
            d(iU2);
            return;
        }
        throw zzbrl.f();
    }

    @Override // com.google.android.gms.internal.ads.asw
    public final void q(List<Long> list) throws zzbrl {
        int iA;
        int iA2;
        if (list instanceof ars) {
            ars arsVar = (ars) list;
            int i = this.f2162b & 7;
            if (i == 0) {
                do {
                    arsVar.a(this.f2161a.r());
                    if (this.f2161a.t()) {
                        return;
                    } else {
                        iA2 = this.f2161a.a();
                    }
                } while (iA2 == this.f2162b);
                this.d = iA2;
                return;
            }
            if (i == 2) {
                int iU = this.f2161a.u() + this.f2161a.m();
                do {
                    arsVar.a(this.f2161a.r());
                } while (this.f2161a.u() < iU);
                d(iU);
                return;
            }
            throw zzbrl.f();
        }
        int i2 = this.f2162b & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.f2161a.r()));
                if (this.f2161a.t()) {
                    return;
                } else {
                    iA = this.f2161a.a();
                }
            } while (iA == this.f2162b);
            this.d = iA;
            return;
        }
        if (i2 == 2) {
            int iU2 = this.f2161a.u() + this.f2161a.m();
            do {
                list.add(Long.valueOf(this.f2161a.r()));
            } while (this.f2161a.u() < iU2);
            d(iU2);
            return;
        }
        throw zzbrl.f();
    }

    private static void b(int i) throws zzbrl {
        if ((i & 7) != 0) {
            throw zzbrl.h();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005e, code lost:
    
        r6.put(r1, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.asw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <K, V> void a(java.util.Map<K, V> r6, com.google.android.gms.internal.ads.ary<K, V> r7, com.google.android.gms.internal.ads.aqk r8) throws com.google.android.gms.internal.ads.zzbrm {
        /*
            r5 = this;
            r0 = 2
            r5.a(r0)
            com.google.android.gms.internal.ads.aqa r0 = r5.f2161a
            int r0 = r0.m()
            com.google.android.gms.internal.ads.aqa r1 = r5.f2161a
            int r0 = r1.d(r0)
            K r1 = r7.f2220b
            V r2 = r7.d
        L14:
            int r3 = r5.a()     // Catch: java.lang.Throwable -> L67
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r3 == r4) goto L5e
            com.google.android.gms.internal.ads.aqa r4 = r5.f2161a     // Catch: java.lang.Throwable -> L67
            boolean r4 = r4.t()     // Catch: java.lang.Throwable -> L67
            if (r4 != 0) goto L5e
            switch(r3) {
                case 1: goto L3b;
                case 2: goto L2d;
                default: goto L28;
            }
        L28:
            boolean r3 = r5.c()     // Catch: com.google.android.gms.internal.ads.zzbrm -> L4f java.lang.Throwable -> L67
            goto L44
        L2d:
            com.google.android.gms.internal.ads.aue r3 = r7.c     // Catch: com.google.android.gms.internal.ads.zzbrm -> L4f java.lang.Throwable -> L67
            V r4 = r7.d     // Catch: com.google.android.gms.internal.ads.zzbrm -> L4f java.lang.Throwable -> L67
            java.lang.Class r4 = r4.getClass()     // Catch: com.google.android.gms.internal.ads.zzbrm -> L4f java.lang.Throwable -> L67
            java.lang.Object r3 = r5.a(r3, r4, r8)     // Catch: com.google.android.gms.internal.ads.zzbrm -> L4f java.lang.Throwable -> L67
            r2 = r3
            goto L14
        L3b:
            com.google.android.gms.internal.ads.aue r3 = r7.f2219a     // Catch: com.google.android.gms.internal.ads.zzbrm -> L4f java.lang.Throwable -> L67
            r4 = 0
            java.lang.Object r3 = r5.a(r3, r4, r4)     // Catch: com.google.android.gms.internal.ads.zzbrm -> L4f java.lang.Throwable -> L67
            r1 = r3
            goto L14
        L44:
            if (r3 == 0) goto L47
            goto L14
        L47:
            com.google.android.gms.internal.ads.zzbrl r3 = new com.google.android.gms.internal.ads.zzbrl     // Catch: com.google.android.gms.internal.ads.zzbrm -> L4f java.lang.Throwable -> L67
            java.lang.String r4 = "Unable to parse map entry."
            r3.<init>(r4)     // Catch: com.google.android.gms.internal.ads.zzbrm -> L4f java.lang.Throwable -> L67
            throw r3     // Catch: com.google.android.gms.internal.ads.zzbrm -> L4f java.lang.Throwable -> L67
        L4f:
            boolean r3 = r5.c()     // Catch: java.lang.Throwable -> L67
            if (r3 == 0) goto L56
            goto L14
        L56:
            com.google.android.gms.internal.ads.zzbrl r6 = new com.google.android.gms.internal.ads.zzbrl     // Catch: java.lang.Throwable -> L67
            java.lang.String r7 = "Unable to parse map entry."
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L67
            throw r6     // Catch: java.lang.Throwable -> L67
        L5e:
            r6.put(r1, r2)     // Catch: java.lang.Throwable -> L67
            com.google.android.gms.internal.ads.aqa r6 = r5.f2161a
            r6.e(r0)
            return
        L67:
            r6 = move-exception
            com.google.android.gms.internal.ads.aqa r7 = r5.f2161a
            r7.e(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aqd.a(java.util.Map, com.google.android.gms.internal.ads.ary, com.google.android.gms.internal.ads.aqk):void");
    }

    private final Object a(aue aueVar, Class<?> cls, aqk aqkVar) throws zzbrm {
        switch (aqe.f2163a[aueVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(k());
            case 2:
                return n();
            case 3:
                return Double.valueOf(d());
            case 4:
                return Integer.valueOf(p());
            case 5:
                return Integer.valueOf(j());
            case 6:
                return Long.valueOf(i());
            case 7:
                return Float.valueOf(e());
            case 8:
                return Integer.valueOf(h());
            case 9:
                return Long.valueOf(g());
            case 10:
                a(2);
                return c(ass.a().a((Class) cls), aqkVar);
            case 11:
                return Integer.valueOf(q());
            case 12:
                return Long.valueOf(r());
            case 13:
                return Integer.valueOf(s());
            case 14:
                return Long.valueOf(t());
            case 15:
                return m();
            case 16:
                return Integer.valueOf(o());
            case 17:
                return Long.valueOf(f());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void c(int i) throws zzbrl {
        if ((i & 3) != 0) {
            throw zzbrl.h();
        }
    }

    private final void d(int i) throws zzbrl {
        if (this.f2161a.u() != i) {
            throw zzbrl.a();
        }
    }
}
