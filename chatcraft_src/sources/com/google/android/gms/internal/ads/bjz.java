package com.google.android.gms.internal.ads;

import com.github.steveice10.mc.v1_5.util.Constants;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public final class bjz {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f2752a;

    /* renamed from: b, reason: collision with root package name */
    private int f2753b;
    private int c;

    public bjz() {
    }

    public bjz(int i) {
        this.f2752a = new byte[i];
        this.c = i;
    }

    public bjz(byte[] bArr) {
        this.f2752a = bArr;
        this.c = bArr.length;
    }

    public final void a(int i) {
        a(e() < i ? new byte[i] : this.f2752a, i);
    }

    public final void a(byte[] bArr, int i) {
        this.f2752a = bArr;
        this.c = i;
        this.f2753b = 0;
    }

    public final void a() {
        this.f2753b = 0;
        this.c = 0;
    }

    public final int b() {
        return this.c - this.f2753b;
    }

    public final int c() {
        return this.c;
    }

    public final void b(int i) {
        bjq.a(i >= 0 && i <= this.f2752a.length);
        this.c = i;
    }

    public final int d() {
        return this.f2753b;
    }

    public final int e() {
        if (this.f2752a == null) {
            return 0;
        }
        return this.f2752a.length;
    }

    public final void c(int i) {
        bjq.a(i >= 0 && i <= this.c);
        this.f2753b = i;
    }

    public final void d(int i) {
        c(this.f2753b + i);
    }

    public final void a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f2752a, this.f2753b, bArr, i, i2);
        this.f2753b += i2;
    }

    public final int f() {
        byte[] bArr = this.f2752a;
        int i = this.f2753b;
        this.f2753b = i + 1;
        return bArr[i] & Constants.DimensionIds.NETHER;
    }

    public final int g() {
        byte[] bArr = this.f2752a;
        int i = this.f2753b;
        this.f2753b = i + 1;
        int i2 = (bArr[i] & Constants.DimensionIds.NETHER) << 8;
        byte[] bArr2 = this.f2752a;
        int i3 = this.f2753b;
        this.f2753b = i3 + 1;
        return i2 | (bArr2[i3] & Constants.DimensionIds.NETHER);
    }

    public final int h() {
        byte[] bArr = this.f2752a;
        int i = this.f2753b;
        this.f2753b = i + 1;
        int i2 = bArr[i] & Constants.DimensionIds.NETHER;
        byte[] bArr2 = this.f2752a;
        int i3 = this.f2753b;
        this.f2753b = i3 + 1;
        return i2 | ((bArr2[i3] & Constants.DimensionIds.NETHER) << 8);
    }

    public final short i() {
        byte[] bArr = this.f2752a;
        int i = this.f2753b;
        this.f2753b = i + 1;
        int i2 = (bArr[i] & Constants.DimensionIds.NETHER) << 8;
        byte[] bArr2 = this.f2752a;
        int i3 = this.f2753b;
        this.f2753b = i3 + 1;
        return (short) (i2 | (bArr2[i3] & Constants.DimensionIds.NETHER));
    }

    public final long j() {
        byte[] bArr = this.f2752a;
        this.f2753b = this.f2753b + 1;
        byte[] bArr2 = this.f2752a;
        this.f2753b = this.f2753b + 1;
        long j = ((bArr[r1] & 255) << 24) | ((bArr2[r5] & 255) << 16);
        byte[] bArr3 = this.f2752a;
        this.f2753b = this.f2753b + 1;
        long j2 = j | ((bArr3[r5] & 255) << 8);
        byte[] bArr4 = this.f2752a;
        this.f2753b = this.f2753b + 1;
        return j2 | (255 & bArr4[r5]);
    }

    public final long k() {
        byte[] bArr = this.f2752a;
        this.f2753b = this.f2753b + 1;
        byte[] bArr2 = this.f2752a;
        this.f2753b = this.f2753b + 1;
        long j = (bArr[r1] & 255) | ((bArr2[r5] & 255) << 8);
        byte[] bArr3 = this.f2752a;
        this.f2753b = this.f2753b + 1;
        long j2 = j | ((bArr3[r5] & 255) << 16);
        byte[] bArr4 = this.f2752a;
        this.f2753b = this.f2753b + 1;
        return j2 | ((255 & bArr4[r5]) << 24);
    }

    public final int l() {
        byte[] bArr = this.f2752a;
        int i = this.f2753b;
        this.f2753b = i + 1;
        int i2 = (bArr[i] & Constants.DimensionIds.NETHER) << 24;
        byte[] bArr2 = this.f2752a;
        int i3 = this.f2753b;
        this.f2753b = i3 + 1;
        int i4 = i2 | ((bArr2[i3] & Constants.DimensionIds.NETHER) << 16);
        byte[] bArr3 = this.f2752a;
        int i5 = this.f2753b;
        this.f2753b = i5 + 1;
        int i6 = i4 | ((bArr3[i5] & Constants.DimensionIds.NETHER) << 8);
        byte[] bArr4 = this.f2752a;
        int i7 = this.f2753b;
        this.f2753b = i7 + 1;
        return i6 | (bArr4[i7] & Constants.DimensionIds.NETHER);
    }

    public final long m() {
        byte[] bArr = this.f2752a;
        this.f2753b = this.f2753b + 1;
        byte[] bArr2 = this.f2752a;
        this.f2753b = this.f2753b + 1;
        long j = ((bArr[r1] & 255) << 56) | ((bArr2[r5] & 255) << 48);
        byte[] bArr3 = this.f2752a;
        this.f2753b = this.f2753b + 1;
        long j2 = j | ((bArr3[r5] & 255) << 40);
        byte[] bArr4 = this.f2752a;
        this.f2753b = this.f2753b + 1;
        long j3 = j2 | ((bArr4[r5] & 255) << 32);
        byte[] bArr5 = this.f2752a;
        this.f2753b = this.f2753b + 1;
        long j4 = j3 | ((bArr5[r5] & 255) << 24);
        byte[] bArr6 = this.f2752a;
        this.f2753b = this.f2753b + 1;
        long j5 = j4 | ((bArr6[r5] & 255) << 16);
        byte[] bArr7 = this.f2752a;
        this.f2753b = this.f2753b + 1;
        long j6 = j5 | ((bArr7[r5] & 255) << 8);
        byte[] bArr8 = this.f2752a;
        this.f2753b = this.f2753b + 1;
        return j6 | (255 & bArr8[r5]);
    }

    public final int n() {
        byte[] bArr = this.f2752a;
        int i = this.f2753b;
        this.f2753b = i + 1;
        int i2 = (bArr[i] & Constants.DimensionIds.NETHER) << 8;
        byte[] bArr2 = this.f2752a;
        int i3 = this.f2753b;
        this.f2753b = i3 + 1;
        int i4 = i2 | (bArr2[i3] & Constants.DimensionIds.NETHER);
        this.f2753b += 2;
        return i4;
    }

    public final int o() {
        int iL = l();
        if (iL >= 0) {
            return iL;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(iL);
        throw new IllegalStateException(sb.toString());
    }

    public final long p() {
        long jM = m();
        if (jM >= 0) {
            return jM;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(jM);
        throw new IllegalStateException(sb.toString());
    }

    public final String e(int i) {
        if (i == 0) {
            return BuildConfig.FLAVOR;
        }
        int i2 = (this.f2753b + i) - 1;
        String str = new String(this.f2752a, this.f2753b, (i2 >= this.c || this.f2752a[i2] != 0) ? i : i - 1);
        this.f2753b += i;
        return str;
    }

    public final String q() {
        if (b() == 0) {
            return null;
        }
        int i = this.f2753b;
        while (i < this.c && this.f2752a[i] != 0) {
            i++;
        }
        String str = new String(this.f2752a, this.f2753b, i - this.f2753b);
        this.f2753b = i;
        if (this.f2753b < this.c) {
            this.f2753b++;
        }
        return str;
    }
}
