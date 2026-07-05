package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class bfw implements bcm {

    /* renamed from: a, reason: collision with root package name */
    private final biy f2630a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2631b;
    private final bfu c = new bfu();
    private final bfv d = new bfv();
    private final bjz e = new bjz(32);
    private final AtomicInteger f = new AtomicInteger();
    private bfx g;
    private bfx h;
    private bab i;
    private boolean j;
    private bab k;
    private long l;
    private long m;
    private int n;
    private bfy o;

    public bfw(biy biyVar) {
        this.f2630a = biyVar;
        this.f2631b = biyVar.c();
        this.n = this.f2631b;
        this.g = new bfx(0L, this.f2631b);
        this.h = this.g;
    }

    public final void a(boolean z) {
        int andSet = this.f.getAndSet(z ? 0 : 2);
        j();
        this.c.b();
        if (andSet == 2) {
            this.i = null;
        }
    }

    public final int a() {
        return this.c.c();
    }

    public final void a(int i) {
        this.m = this.c.a(i);
        long j = this.m;
        if (j == this.g.f2632a) {
            a(this.g);
            this.g = new bfx(j, this.f2631b);
            this.h = this.g;
            return;
        }
        bfx bfxVar = this.g;
        bfx bfxVar2 = this.g.e;
        while (true) {
            bfx bfxVar3 = bfxVar2;
            bfx bfxVar4 = bfxVar;
            bfxVar = bfxVar3;
            if (j > bfxVar.f2632a) {
                bfxVar2 = bfxVar.e;
            } else {
                a(bfxVar);
                this.h = bfxVar4;
                this.h.e = new bfx(this.h.f2633b, this.f2631b);
                this.n = (int) (j - this.h.f2632a);
                return;
            }
        }
    }

    public final void b() {
        if (this.f.getAndSet(2) == 0) {
            j();
        }
    }

    public final boolean c() {
        return this.c.e();
    }

    public final int d() {
        return this.c.d();
    }

    public final bab e() {
        return this.c.f();
    }

    public final long f() {
        return this.c.g();
    }

    public final void g() {
        long jH = this.c.h();
        if (jH != -1) {
            b(jH);
        }
    }

    public final boolean a(long j, boolean z) {
        long jA = this.c.a(j, z);
        if (jA == -1) {
            return false;
        }
        b(jA);
        return true;
    }

    public final int a(bad badVar, bbs bbsVar, boolean z, boolean z2, long j) {
        int iG;
        switch (this.c.a(badVar, bbsVar, z, z2, this.i, this.d)) {
            case -5:
                this.i = badVar.f2444a;
                return -5;
            case -4:
                if (bbsVar.c()) {
                    return -4;
                }
                if (bbsVar.c < j) {
                    bbsVar.b(Integer.MIN_VALUE);
                }
                if (bbsVar.e()) {
                    bfv bfvVar = this.d;
                    long j2 = bfvVar.f2629b;
                    this.e.a(1);
                    a(j2, this.e.f2752a, 1);
                    long j3 = j2 + 1;
                    byte b2 = this.e.f2752a[0];
                    boolean z3 = (b2 & 128) != 0;
                    int i = b2 & 127;
                    if (bbsVar.f2502a.f2496a == null) {
                        bbsVar.f2502a.f2496a = new byte[16];
                    }
                    a(j3, bbsVar.f2502a.f2496a, i);
                    long j4 = j3 + i;
                    if (z3) {
                        this.e.a(2);
                        a(j4, this.e.f2752a, 2);
                        j4 += 2;
                        iG = this.e.g();
                    } else {
                        iG = 1;
                    }
                    int[] iArr = bbsVar.f2502a.f2497b;
                    if (iArr == null || iArr.length < iG) {
                        iArr = new int[iG];
                    }
                    int[] iArr2 = iArr;
                    int[] iArr3 = bbsVar.f2502a.c;
                    if (iArr3 == null || iArr3.length < iG) {
                        iArr3 = new int[iG];
                    }
                    int[] iArr4 = iArr3;
                    if (z3) {
                        int i2 = iG * 6;
                        this.e.a(i2);
                        a(j4, this.e.f2752a, i2);
                        j4 += i2;
                        this.e.c(0);
                        for (int i3 = 0; i3 < iG; i3++) {
                            iArr2[i3] = this.e.g();
                            iArr4[i3] = this.e.o();
                        }
                    } else {
                        iArr2[0] = 0;
                        iArr4[0] = bfvVar.f2628a - ((int) (j4 - bfvVar.f2629b));
                    }
                    bcn bcnVar = bfvVar.d;
                    bbsVar.f2502a.a(iG, iArr2, iArr4, bcnVar.f2519b, bbsVar.f2502a.f2496a, bcnVar.f2518a);
                    int i4 = (int) (j4 - bfvVar.f2629b);
                    bfvVar.f2629b += i4;
                    bfvVar.f2628a -= i4;
                }
                bbsVar.d(this.d.f2628a);
                long j5 = this.d.f2629b;
                ByteBuffer byteBuffer = bbsVar.f2503b;
                int i5 = this.d.f2628a;
                b(j5);
                while (i5 > 0) {
                    int i6 = (int) (j5 - this.g.f2632a);
                    int iMin = Math.min(i5, this.f2631b - i6);
                    bix bixVar = this.g.d;
                    byteBuffer.put(bixVar.f2717a, bixVar.a(i6), iMin);
                    j5 += iMin;
                    i5 -= iMin;
                    if (j5 == this.g.f2633b) {
                        this.f2630a.a(bixVar);
                        this.g = this.g.a();
                    }
                }
                b(this.d.c);
                return -4;
            case -3:
                return -3;
            default:
                throw new IllegalStateException();
        }
    }

    private final void a(long j, byte[] bArr, int i) {
        b(j);
        int i2 = 0;
        while (i2 < i) {
            int i3 = (int) (j - this.g.f2632a);
            int iMin = Math.min(i - i2, this.f2631b - i3);
            bix bixVar = this.g.d;
            System.arraycopy(bixVar.f2717a, bixVar.a(i3), bArr, i2, iMin);
            j += iMin;
            i2 += iMin;
            if (j == this.g.f2633b) {
                this.f2630a.a(bixVar);
                this.g = this.g.a();
            }
        }
    }

    private final void b(long j) {
        while (j >= this.g.f2633b) {
            this.f2630a.a(this.g.d);
            this.g = this.g.a();
        }
    }

    public final void a(bfy bfyVar) {
        this.o = bfyVar;
    }

    public final void a(long j) {
        if (this.l != j) {
            this.l = j;
            this.j = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.bcm
    public final void a(bab babVar) {
        bab babVarA;
        long j = this.l;
        if (babVar == null) {
            babVarA = null;
        } else {
            babVarA = (j == 0 || babVar.q == Long.MAX_VALUE) ? babVar : babVar.a(babVar.q + j);
        }
        boolean zA = this.c.a(babVarA);
        this.k = babVar;
        this.j = false;
        if (this.o == null || !zA) {
            return;
        }
        this.o.a(babVarA);
    }

    @Override // com.google.android.gms.internal.ads.bcm
    public final int a(bce bceVar, int i, boolean z) throws EOFException {
        if (!h()) {
            int iA = bceVar.a(i);
            if (iA != -1) {
                return iA;
            }
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        try {
            int iB = b(i);
            bix bixVar = this.h.d;
            int iA2 = bceVar.a(bixVar.f2717a, bixVar.a(this.n), iB);
            if (iA2 == -1) {
                if (z) {
                    return -1;
                }
                throw new EOFException();
            }
            this.n += iA2;
            this.m += iA2;
            return iA2;
        } finally {
            i();
        }
    }

    @Override // com.google.android.gms.internal.ads.bcm
    public final void a(bjz bjzVar, int i) {
        if (!h()) {
            bjzVar.d(i);
            return;
        }
        while (i > 0) {
            int iB = b(i);
            bix bixVar = this.h.d;
            bjzVar.a(bixVar.f2717a, bixVar.a(this.n), iB);
            this.n += iB;
            this.m += iB;
            i -= iB;
        }
        i();
    }

    @Override // com.google.android.gms.internal.ads.bcm
    public final void a(long j, int i, int i2, int i3, bcn bcnVar) {
        if (this.j) {
            a(this.k);
        }
        if (!h()) {
            this.c.a(j);
            return;
        }
        try {
            this.c.a(j + this.l, i, (this.m - i2) - i3, i2, bcnVar);
        } finally {
            i();
        }
    }

    private final boolean h() {
        return this.f.compareAndSet(0, 1);
    }

    private final void i() {
        if (this.f.compareAndSet(1, 0)) {
            return;
        }
        j();
    }

    private final void j() {
        this.c.a();
        a(this.g);
        this.g = new bfx(0L, this.f2631b);
        this.h = this.g;
        this.m = 0L;
        this.n = this.f2631b;
        this.f2630a.b();
    }

    private final void a(bfx bfxVar) {
        if (bfxVar.c) {
            boolean z = this.h.c;
            bix[] bixVarArr = new bix[(z ? 1 : 0) + (((int) (this.h.f2632a - bfxVar.f2632a)) / this.f2631b)];
            for (int i = 0; i < bixVarArr.length; i++) {
                bixVarArr[i] = bfxVar.d;
                bfxVar = bfxVar.a();
            }
            this.f2630a.a(bixVarArr);
        }
    }

    private final int b(int i) {
        if (this.n == this.f2631b) {
            this.n = 0;
            if (this.h.c) {
                this.h = this.h.e;
            }
            bfx bfxVar = this.h;
            bix bixVarA = this.f2630a.a();
            bfx bfxVar2 = new bfx(this.h.f2633b, this.f2631b);
            bfxVar.d = bixVarA;
            bfxVar.e = bfxVar2;
            bfxVar.c = true;
        }
        return Math.min(i, this.f2631b - this.n);
    }
}
