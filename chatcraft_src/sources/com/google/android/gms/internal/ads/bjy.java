package com.google.android.gms.internal.ads;

import com.github.steveice10.mc.v1_5.util.Constants;

/* loaded from: classes.dex */
public final class bjy {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f2750a;

    /* renamed from: b, reason: collision with root package name */
    private int f2751b;
    private int c;
    private int d;

    public bjy() {
    }

    public bjy(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private bjy(byte[] bArr, int i) {
        this.f2750a = bArr;
        this.d = i;
    }

    public final int a(int i) {
        int i2;
        int i3;
        boolean z = false;
        if (i == 0) {
            return 0;
        }
        int i4 = i / 8;
        int i5 = i;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            if (this.c != 0) {
                i3 = ((this.f2750a[this.f2751b + 1] & Constants.DimensionIds.NETHER) >>> (8 - this.c)) | ((this.f2750a[this.f2751b] & Constants.DimensionIds.NETHER) << this.c);
            } else {
                i3 = this.f2750a[this.f2751b];
            }
            i5 -= 8;
            i6 |= (255 & i3) << i5;
            this.f2751b++;
        }
        if (i5 > 0) {
            int i8 = this.c + i5;
            byte b2 = (byte) (255 >> (8 - i5));
            if (i8 > 8) {
                i2 = (b2 & (((this.f2750a[this.f2751b] & Constants.DimensionIds.NETHER) << (i8 - 8)) | ((255 & this.f2750a[this.f2751b + 1]) >> (16 - i8)))) | i6;
                this.f2751b++;
            } else {
                i2 = (b2 & ((this.f2750a[this.f2751b] & Constants.DimensionIds.NETHER) >> (8 - i8))) | i6;
                if (i8 == 8) {
                    this.f2751b++;
                }
            }
            i6 = i2;
            this.c = i8 % 8;
        }
        if (this.f2751b >= 0 && this.c >= 0 && this.c < 8 && (this.f2751b < this.d || (this.f2751b == this.d && this.c == 0))) {
            z = true;
        }
        bjq.b(z);
        return i6;
    }
}
