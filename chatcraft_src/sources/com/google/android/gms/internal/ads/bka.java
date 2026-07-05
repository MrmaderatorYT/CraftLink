package com.google.android.gms.internal.ads;

import com.github.steveice10.mc.v1_5.util.Constants;

/* loaded from: classes.dex */
public final class bka {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f2756a;

    /* renamed from: b, reason: collision with root package name */
    private int f2757b;
    private int c;
    private int d = 0;

    public bka(byte[] bArr, int i, int i2) {
        this.f2756a = bArr;
        this.c = i;
        this.f2757b = i2;
        e();
    }

    public final void a(int i) {
        int i2 = this.c;
        this.c += i / 8;
        this.d += i % 8;
        if (this.d > 7) {
            this.c++;
            this.d -= 8;
        }
        while (true) {
            i2++;
            if (i2 <= this.c) {
                if (c(i2)) {
                    this.c++;
                    i2 += 2;
                }
            } else {
                e();
                return;
            }
        }
    }

    public final boolean a() {
        return b(1) == 1;
    }

    public final int b(int i) {
        int i2;
        int i3;
        if (i == 0) {
            return 0;
        }
        int i4 = i / 8;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = c(this.c + 1) ? this.c + 2 : this.c + 1;
            if (this.d != 0) {
                i3 = ((this.f2756a[i7] & Constants.DimensionIds.NETHER) >>> (8 - this.d)) | ((this.f2756a[this.c] & Constants.DimensionIds.NETHER) << this.d);
            } else {
                i3 = this.f2756a[this.c];
            }
            i -= 8;
            i5 |= (255 & i3) << i;
            this.c = i7;
        }
        if (i > 0) {
            int i8 = this.d + i;
            byte b2 = (byte) (255 >> (8 - i));
            int i9 = c(this.c + 1) ? this.c + 2 : this.c + 1;
            if (i8 > 8) {
                i2 = (b2 & (((255 & this.f2756a[i9]) >> (16 - i8)) | ((this.f2756a[this.c] & Constants.DimensionIds.NETHER) << (i8 - 8)))) | i5;
                this.c = i9;
            } else {
                i2 = (b2 & ((255 & this.f2756a[this.c]) >> (8 - i8))) | i5;
                if (i8 == 8) {
                    this.c = i9;
                }
            }
            i5 = i2;
            this.d = i8 % 8;
        }
        e();
        return i5;
    }

    public final int b() {
        return d();
    }

    public final int c() {
        int iD = d();
        return (iD % 2 == 0 ? -1 : 1) * ((iD + 1) / 2);
    }

    private final int d() {
        int i = 0;
        while (!a()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? b(i) : 0);
    }

    private final boolean c(int i) {
        return 2 <= i && i < this.f2757b && this.f2756a[i] == 3 && this.f2756a[i + (-2)] == 0 && this.f2756a[i - 1] == 0;
    }

    private final void e() {
        bjq.b(this.c >= 0 && this.d >= 0 && this.d < 8 && (this.c < this.f2757b || (this.c == this.f2757b && this.d == 0)));
    }
}
