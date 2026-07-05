package com.google.android.gms.internal.ads;

import java.io.IOException;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public final class aul {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f2276a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2277b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int i;
    private aqa l;
    private int h = Integer.MAX_VALUE;
    private int j = 64;
    private int k = 67108864;

    public static aul a(byte[] bArr, int i, int i2) {
        return new aul(bArr, 0, i2);
    }

    public final int a() throws zzbuy {
        if (this.f == this.d) {
            this.g = 0;
            return 0;
        }
        this.g = g();
        if (this.g == 0) {
            throw new zzbuy("Protocol message contained an invalid tag (zero).");
        }
        return this.g;
    }

    public final void a(int i) throws zzbuy {
        if (this.g != i) {
            throw new zzbuy("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean b(int i) throws zzbuy {
        int iA;
        switch (i & 7) {
            case 0:
                g();
                return true;
            case 1:
                l();
                l();
                l();
                l();
                l();
                l();
                l();
                l();
                return true;
            case 2:
                f(g());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                l();
                l();
                l();
                l();
                return true;
            default:
                throw new zzbuy("Protocol message tag had invalid wire type.");
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

    public final long b() {
        return h();
    }

    public final int c() {
        return g();
    }

    public final boolean d() {
        return g() != 0;
    }

    public final String e() throws zzbuy {
        int iG = g();
        if (iG < 0) {
            throw zzbuy.b();
        }
        if (iG > this.d - this.f) {
            throw zzbuy.a();
        }
        String str = new String(this.f2276a, this.f, iG, aur.f2285a);
        this.f += iG;
        return str;
    }

    public final void a(aus ausVar) throws zzbuy {
        int iG = g();
        if (this.i >= this.j) {
            throw new zzbuy("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iC = c(iG);
        this.i++;
        ausVar.a(this);
        a(0);
        this.i--;
        d(iC);
    }

    public final byte[] f() throws zzbuy {
        int iG = g();
        if (iG < 0) {
            throw zzbuy.b();
        }
        if (iG == 0) {
            return auw.e;
        }
        if (iG > this.d - this.f) {
            throw zzbuy.a();
        }
        byte[] bArr = new byte[iG];
        System.arraycopy(this.f2276a, this.f, bArr, 0, iG);
        this.f += iG;
        return bArr;
    }

    public final int g() throws zzbuy {
        byte bL = l();
        if (bL >= 0) {
            return bL;
        }
        int i = bL & 127;
        byte bL2 = l();
        if (bL2 >= 0) {
            return i | (bL2 << 7);
        }
        int i2 = i | ((bL2 & 127) << 7);
        byte bL3 = l();
        if (bL3 >= 0) {
            return i2 | (bL3 << 14);
        }
        int i3 = i2 | ((bL3 & 127) << 14);
        byte bL4 = l();
        if (bL4 >= 0) {
            return i3 | (bL4 << 21);
        }
        int i4 = i3 | ((bL4 & 127) << 21);
        byte bL5 = l();
        int i5 = i4 | (bL5 << 28);
        if (bL5 >= 0) {
            return i5;
        }
        for (int i6 = 0; i6 < 5; i6++) {
            if (l() >= 0) {
                return i5;
            }
        }
        throw zzbuy.c();
    }

    public final long h() throws zzbuy {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & 127) << i;
            if ((l() & 128) == 0) {
                return j;
            }
        }
        throw zzbuy.c();
    }

    private aul(byte[] bArr, int i, int i2) {
        this.f2276a = bArr;
        this.f2277b = i;
        int i3 = i2 + i;
        this.d = i3;
        this.c = i3;
        this.f = i;
    }

    public final <T extends aqy<T, ?>> T a(asq<T> asqVar) throws IOException {
        try {
            if (this.l == null) {
                this.l = aqa.a(this.f2276a, this.f2277b, this.c);
            }
            int iU = this.l.u();
            int i = this.f - this.f2277b;
            if (iU > i) {
                throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", Integer.valueOf(iU), Integer.valueOf(i)));
            }
            this.l.f(i - iU);
            this.l.c(this.j - this.i);
            T t = (T) this.l.a(asqVar, aqk.b());
            b(this.g);
            return t;
        } catch (zzbrl e) {
            throw new zzbuy(BuildConfig.FLAVOR, e);
        }
    }

    public final int c(int i) throws zzbuy {
        if (i < 0) {
            throw zzbuy.b();
        }
        int i2 = i + this.f;
        int i3 = this.h;
        if (i2 > i3) {
            throw zzbuy.a();
        }
        this.h = i2;
        k();
        return i3;
    }

    private final void k() {
        this.d += this.e;
        int i = this.d;
        if (i > this.h) {
            this.e = i - this.h;
            this.d -= this.e;
        } else {
            this.e = 0;
        }
    }

    public final void d(int i) {
        this.h = i;
        k();
    }

    public final int i() {
        if (this.h == Integer.MAX_VALUE) {
            return -1;
        }
        return this.h - this.f;
    }

    public final int j() {
        return this.f - this.f2277b;
    }

    public final byte[] a(int i, int i2) {
        if (i2 == 0) {
            return auw.e;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f2276a, this.f2277b + i, bArr, 0, i2);
        return bArr;
    }

    public final void e(int i) {
        b(i, this.g);
    }

    final void b(int i, int i2) {
        if (i > this.f - this.f2277b) {
            int i3 = this.f - this.f2277b;
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is beyond current ");
            sb.append(i3);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i < 0) {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
        this.f = this.f2277b + i;
        this.g = i2;
    }

    private final byte l() throws zzbuy {
        if (this.f == this.d) {
            throw zzbuy.a();
        }
        byte[] bArr = this.f2276a;
        int i = this.f;
        this.f = i + 1;
        return bArr[i];
    }

    private final void f(int i) throws zzbuy {
        if (i < 0) {
            throw zzbuy.b();
        }
        if (this.f + i > this.h) {
            f(this.h - this.f);
            throw zzbuy.a();
        }
        if (i <= this.d - this.f) {
            this.f += i;
            return;
        }
        throw zzbuy.a();
    }
}
