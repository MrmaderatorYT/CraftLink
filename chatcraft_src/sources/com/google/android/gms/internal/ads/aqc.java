package com.google.android.gms.internal.ads;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.util.Arrays;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
final class aqc extends aqa {
    private final byte[] d;
    private final boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    private aqc(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.k = Integer.MAX_VALUE;
        this.d = bArr;
        this.f = i2 + i;
        this.h = i;
        this.i = this.h;
        this.e = z;
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final int a() throws zzbrl {
        if (t()) {
            this.j = 0;
            return 0;
        }
        this.j = v();
        if ((this.j >>> 3) == 0) {
            throw zzbrl.d();
        }
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final void a(int i) throws zzbrl {
        if (this.j != i) {
            throw zzbrl.e();
        }
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final boolean b(int i) throws zzbrl {
        int iA;
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.f - this.h >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.d;
                        int i3 = this.h;
                        this.h = i3 + 1;
                        if (bArr[i3] < 0) {
                            i2++;
                        }
                    }
                    throw zzbrl.c();
                }
                while (i2 < 10) {
                    if (A() < 0) {
                        i2++;
                    }
                }
                throw zzbrl.c();
                return true;
            case 1:
                f(8);
                return true;
            case 2:
                f(v());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                f(4);
                return true;
            default:
                throw zzbrl.f();
        }
        do {
            iA = a();
            if (iA != 0) {
            }
            a(((i >>> 3) << 3) | 4);
            return true;
        } while (b(iA));
        a(((i >>> 3) << 3) | 4);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final double b() {
        return Double.longBitsToDouble(y());
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final float c() {
        return Float.intBitsToFloat(x());
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final long d() {
        return w();
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final long e() {
        return w();
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final int f() {
        return v();
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final long g() {
        return y();
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final int h() {
        return x();
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final boolean i() {
        return w() != 0;
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final String j() throws zzbrl {
        int iV = v();
        if (iV > 0 && iV <= this.f - this.h) {
            String str = new String(this.d, this.h, iV, ara.f2199a);
            this.h += iV;
            return str;
        }
        if (iV == 0) {
            return BuildConfig.FLAVOR;
        }
        if (iV < 0) {
            throw zzbrl.b();
        }
        throw zzbrl.a();
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final String k() throws zzbrl {
        int iV = v();
        if (iV > 0 && iV <= this.f - this.h) {
            String strB = atx.b(this.d, this.h, iV);
            this.h += iV;
            return strB;
        }
        if (iV == 0) {
            return BuildConfig.FLAVOR;
        }
        if (iV <= 0) {
            throw zzbrl.b();
        }
        throw zzbrl.a();
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final <T extends asf> T a(asq<T> asqVar, aqk aqkVar) throws zzbrl {
        int iV = v();
        if (this.f2159a >= this.f2160b) {
            throw zzbrl.g();
        }
        int iD = d(iV);
        this.f2159a++;
        T tA = asqVar.a(this, aqkVar);
        a(0);
        this.f2159a--;
        e(iD);
        return tA;
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final apo l() throws zzbrl {
        byte[] bArrCopyOfRange;
        int iV = v();
        if (iV > 0 && iV <= this.f - this.h) {
            apo apoVarA = apo.a(this.d, this.h, iV);
            this.h += iV;
            return apoVarA;
        }
        if (iV == 0) {
            return apo.f2149a;
        }
        if (iV > 0 && iV <= this.f - this.h) {
            int i = this.h;
            this.h += iV;
            bArrCopyOfRange = Arrays.copyOfRange(this.d, i, this.h);
        } else {
            if (iV > 0) {
                throw zzbrl.a();
            }
            if (iV == 0) {
                bArrCopyOfRange = ara.f2200b;
            } else {
                throw zzbrl.b();
            }
        }
        return apo.b(bArrCopyOfRange);
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final int m() {
        return v();
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final int n() {
        return v();
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final int o() {
        return x();
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final long p() {
        return y();
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final int q() {
        return g(v());
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final long r() {
        return a(w());
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
    
        if (r1[r2] >= 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int v() {
        /*
            r5 = this;
            int r0 = r5.h
            int r1 = r5.f
            if (r1 == r0) goto L6d
            byte[] r1 = r5.d
            int r2 = r0 + 1
            r0 = r1[r0]
            if (r0 < 0) goto L11
            r5.h = r2
            return r0
        L11:
            int r3 = r5.f
            int r3 = r3 - r2
            r4 = 9
            if (r3 < r4) goto L6d
            int r3 = r2 + 1
            r2 = r1[r2]
            int r2 = r2 << 7
            r0 = r0 ^ r2
            if (r0 >= 0) goto L24
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L6a
        L24:
            int r2 = r3 + 1
            r3 = r1[r3]
            int r3 = r3 << 14
            r0 = r0 ^ r3
            if (r0 < 0) goto L31
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2f:
            r3 = r2
            goto L6a
        L31:
            int r3 = r2 + 1
            r2 = r1[r2]
            int r2 = r2 << 21
            r0 = r0 ^ r2
            if (r0 >= 0) goto L3f
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            goto L6a
        L3f:
            int r2 = r3 + 1
            r3 = r1[r3]
            int r4 = r3 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r3 >= 0) goto L2f
            int r3 = r2 + 1
            r2 = r1[r2]
            if (r2 >= 0) goto L6a
            int r2 = r3 + 1
            r3 = r1[r3]
            if (r3 >= 0) goto L2f
            int r3 = r2 + 1
            r2 = r1[r2]
            if (r2 >= 0) goto L6a
            int r2 = r3 + 1
            r3 = r1[r3]
            if (r3 >= 0) goto L2f
            int r3 = r2 + 1
            r1 = r1[r2]
            if (r1 < 0) goto L6d
        L6a:
            r5.h = r3
            return r0
        L6d:
            long r0 = r5.s()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aqc.v():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b5, code lost:
    
        if (r1[r0] >= 0) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long w() {
        /*
            Method dump skipped, instructions count: 192
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aqc.w():long");
    }

    @Override // com.google.android.gms.internal.ads.aqa
    final long s() throws zzbrl {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & 127) << i;
            if ((A() & 128) == 0) {
                return j;
            }
        }
        throw zzbrl.c();
    }

    private final int x() throws zzbrl {
        int i = this.h;
        if (this.f - i < 4) {
            throw zzbrl.a();
        }
        byte[] bArr = this.d;
        this.h = i + 4;
        return ((bArr[i + 3] & Constants.DimensionIds.NETHER) << 24) | (bArr[i] & Constants.DimensionIds.NETHER) | ((bArr[i + 1] & Constants.DimensionIds.NETHER) << 8) | ((bArr[i + 2] & Constants.DimensionIds.NETHER) << 16);
    }

    private final long y() throws zzbrl {
        int i = this.h;
        if (this.f - i < 8) {
            throw zzbrl.a();
        }
        byte[] bArr = this.d;
        this.h = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final int d(int i) throws zzbrl {
        if (i < 0) {
            throw zzbrl.b();
        }
        int iU = i + u();
        int i2 = this.k;
        if (iU > i2) {
            throw zzbrl.a();
        }
        this.k = iU;
        z();
        return i2;
    }

    private final void z() {
        this.f += this.g;
        int i = this.f - this.i;
        if (i > this.k) {
            this.g = i - this.k;
            this.f -= this.g;
        } else {
            this.g = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final void e(int i) {
        this.k = i;
        z();
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final boolean t() {
        return this.h == this.f;
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final int u() {
        return this.h - this.i;
    }

    private final byte A() throws zzbrl {
        if (this.h == this.f) {
            throw zzbrl.a();
        }
        byte[] bArr = this.d;
        int i = this.h;
        this.h = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.gms.internal.ads.aqa
    public final void f(int i) throws zzbrl {
        if (i >= 0 && i <= this.f - this.h) {
            this.h += i;
        } else {
            if (i < 0) {
                throw zzbrl.b();
            }
            throw zzbrl.a();
        }
    }
}
