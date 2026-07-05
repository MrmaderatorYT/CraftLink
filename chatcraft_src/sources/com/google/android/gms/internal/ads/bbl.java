package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* loaded from: classes.dex */
final class bbl {

    /* renamed from: a, reason: collision with root package name */
    private final int f2492a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2493b;
    private final int c;
    private final int d;
    private final int e;
    private final short[] f;
    private int g;
    private short[] h;
    private int i;
    private short[] j;
    private int k;
    private short[] l;
    private int q;
    private int r;
    private int s;
    private int t;
    private int v;
    private int w;
    private int x;
    private int m = 0;
    private int n = 0;
    private int u = 0;
    private float o = 1.0f;
    private float p = 1.0f;

    public bbl(int i, int i2) {
        this.f2492a = i;
        this.f2493b = i2;
        this.c = i / 400;
        this.d = i / 65;
        this.e = this.d * 2;
        this.f = new short[this.e];
        this.g = this.e;
        this.h = new short[this.e * i2];
        this.i = this.e;
        this.j = new short[this.e * i2];
        this.k = this.e;
        this.l = new short[this.e * i2];
    }

    public final void a(float f) {
        this.o = f;
    }

    public final void b(float f) {
        this.p = f;
    }

    public final void a(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining() / this.f2493b;
        int i = (this.f2493b * iRemaining) << 1;
        b(iRemaining);
        shortBuffer.get(this.h, this.q * this.f2493b, i / 2);
        this.q += iRemaining;
        c();
    }

    public final void b(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.f2493b, this.r);
        shortBuffer.put(this.j, 0, this.f2493b * iMin);
        this.r -= iMin;
        System.arraycopy(this.j, iMin * this.f2493b, this.j, 0, this.r * this.f2493b);
    }

    public final void a() {
        int i = this.q;
        int i2 = this.r + ((int) ((((i / (this.o / this.p)) + this.s) / this.p) + 0.5f));
        b((this.e * 2) + i);
        for (int i3 = 0; i3 < this.e * 2 * this.f2493b; i3++) {
            this.h[(this.f2493b * i) + i3] = 0;
        }
        this.q += this.e * 2;
        c();
        if (this.r > i2) {
            this.r = i2;
        }
        this.q = 0;
        this.t = 0;
        this.s = 0;
    }

    public final int b() {
        return this.r;
    }

    private final void a(int i) {
        if (this.r + i > this.i) {
            this.i += (this.i / 2) + i;
            this.j = Arrays.copyOf(this.j, this.i * this.f2493b);
        }
    }

    private final void b(int i) {
        if (this.q + i > this.g) {
            this.g += (this.g / 2) + i;
            this.h = Arrays.copyOf(this.h, this.g * this.f2493b);
        }
    }

    private final void a(short[] sArr, int i, int i2) {
        a(i2);
        System.arraycopy(sArr, i * this.f2493b, this.j, this.r * this.f2493b, this.f2493b * i2);
        this.r += i2;
    }

    private final void b(short[] sArr, int i, int i2) {
        int i3 = this.e / i2;
        int i4 = this.f2493b * i2;
        int i5 = i * this.f2493b;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                i7 += sArr[(i6 * i4) + i5 + i8];
            }
            this.f[i6] = (short) (i7 / i4);
        }
    }

    private final int a(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.f2493b;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 255;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i6 < i5 * i2) {
                i6 = i2;
                i5 = i9;
            }
            if (i9 * i8 > i7 * i2) {
                i8 = i2;
                i7 = i9;
            }
            i2++;
        }
        this.w = i5 / i6;
        this.x = i7 / i8;
        return i6;
    }

    private final void c() {
        int iA;
        int i;
        int i2;
        int i3 = this.r;
        float f = this.o / this.p;
        double d = f;
        int i4 = 1;
        if (d > 1.00001d || d < 0.99999d) {
            if (this.q >= this.e) {
                int i5 = this.q;
                int i6 = 0;
                while (true) {
                    if (this.t > 0) {
                        int iMin = Math.min(this.e, this.t);
                        a(this.h, i6, iMin);
                        this.t -= iMin;
                        i6 += iMin;
                    } else {
                        short[] sArr = this.h;
                        int i7 = this.f2492a > 4000 ? this.f2492a / 4000 : 1;
                        if (this.f2493b == i4 && i7 == i4) {
                            iA = a(sArr, i6, this.c, this.d);
                        } else {
                            b(sArr, i6, i7);
                            int iA2 = a(this.f, 0, this.c / i7, this.d / i7);
                            if (i7 != i4) {
                                int i8 = iA2 * i7;
                                int i9 = i7 << 2;
                                int i10 = i8 - i9;
                                int i11 = i8 + i9;
                                if (i10 < this.c) {
                                    i10 = this.c;
                                }
                                if (i11 > this.d) {
                                    i11 = this.d;
                                }
                                if (this.f2493b == i4) {
                                    iA = a(sArr, i6, i10, i11);
                                } else {
                                    b(sArr, i6, i4);
                                    iA = a(this.f, 0, i10, i11);
                                }
                            } else {
                                iA = iA2;
                            }
                        }
                        int i12 = this.w;
                        int i13 = i12 != 0 && this.u != 0 && this.x <= i12 * 3 && (i12 << 1) > this.v * 3 ? this.u : iA;
                        this.v = this.w;
                        this.u = iA;
                        if (d > 1.0d) {
                            short[] sArr2 = this.h;
                            if (f >= 2.0f) {
                                i2 = (int) (i13 / (f - 1.0f));
                            } else {
                                this.t = (int) ((i13 * (2.0f - f)) / (f - 1.0f));
                                i2 = i13;
                            }
                            a(i2);
                            int i14 = i2;
                            a(i2, this.f2493b, this.j, this.r, sArr2, i6, sArr2, i6 + i13);
                            this.r += i14;
                            i6 += i13 + i14;
                        } else {
                            int i15 = i13;
                            int i16 = i6;
                            short[] sArr3 = this.h;
                            if (f < 0.5f) {
                                i = (int) ((i15 * f) / (1.0f - f));
                            } else {
                                this.t = (int) ((i15 * ((2.0f * f) - 1.0f)) / (1.0f - f));
                                i = i15;
                            }
                            int i17 = i15 + i;
                            a(i17);
                            System.arraycopy(sArr3, this.f2493b * i16, this.j, this.r * this.f2493b, this.f2493b * i15);
                            a(i, this.f2493b, this.j, this.r + i15, sArr3, i16 + i15, sArr3, i16);
                            this.r += i17;
                            i6 = i16 + i;
                        }
                    }
                    if (this.e + i6 > i5) {
                        break;
                    } else {
                        i4 = 1;
                    }
                }
                int i18 = this.q - i6;
                System.arraycopy(this.h, i6 * this.f2493b, this.h, 0, this.f2493b * i18);
                this.q = i18;
            }
        } else {
            a(this.h, 0, this.q);
            this.q = 0;
        }
        if (this.p != 1.0f) {
            float f2 = this.p;
            if (this.r != i3) {
                int i19 = (int) (this.f2492a / f2);
                int i20 = this.f2492a;
                while (true) {
                    if (i19 <= 16384 && i20 <= 16384) {
                        break;
                    }
                    i19 /= 2;
                    i20 /= 2;
                }
                int i21 = this.r - i3;
                if (this.s + i21 > this.k) {
                    this.k += (this.k / 2) + i21;
                    this.l = Arrays.copyOf(this.l, this.k * this.f2493b);
                }
                System.arraycopy(this.j, this.f2493b * i3, this.l, this.s * this.f2493b, this.f2493b * i21);
                this.r = i3;
                this.s += i21;
                int i22 = 0;
                while (true) {
                    int i23 = 1;
                    if (i22 >= this.s - 1) {
                        break;
                    }
                    while ((this.m + i23) * i19 > this.n * i20) {
                        a(i23);
                        for (int i24 = 0; i24 < this.f2493b; i24++) {
                            short[] sArr4 = this.j;
                            int i25 = (this.r * this.f2493b) + i24;
                            short[] sArr5 = this.l;
                            int i26 = (this.f2493b * i22) + i24;
                            short s = sArr5[i26];
                            short s2 = sArr5[i26 + this.f2493b];
                            int i27 = this.n * i20;
                            int i28 = this.m * i19;
                            int i29 = (this.m + 1) * i19;
                            int i30 = i29 - i27;
                            int i31 = i29 - i28;
                            sArr4[i25] = (short) (((s * i30) + ((i31 - i30) * s2)) / i31);
                        }
                        i23 = 1;
                        this.n++;
                        this.r++;
                    }
                    this.m += i23;
                    if (this.m == i20) {
                        this.m = 0;
                        bjq.b(this.n == i19);
                        this.n = 0;
                    }
                    i22++;
                }
                int i32 = this.s - 1;
                if (i32 != 0) {
                    System.arraycopy(this.l, this.f2493b * i32, this.l, 0, (this.s - i32) * this.f2493b);
                    this.s -= i32;
                }
            }
        }
    }

    private static void a(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }
}
