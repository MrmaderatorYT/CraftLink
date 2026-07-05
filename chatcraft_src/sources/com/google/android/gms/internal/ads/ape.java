package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class ape {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f2139a = new byte[256];

    /* renamed from: b, reason: collision with root package name */
    private int f2140b;
    private int c;

    public ape(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.f2139a[i] = (byte) i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            i2 = (i2 + this.f2139a[i3] + bArr[i3 % bArr.length]) & 255;
            byte b2 = this.f2139a[i3];
            this.f2139a[i3] = this.f2139a[i2];
            this.f2139a[i2] = b2;
        }
        this.f2140b = 0;
        this.c = 0;
    }

    public final void a(byte[] bArr) {
        int i = this.f2140b;
        int i2 = this.c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = (i2 + this.f2139a[i]) & 255;
            byte b2 = this.f2139a[i];
            this.f2139a[i] = this.f2139a[i2];
            this.f2139a[i2] = b2;
            bArr[i3] = (byte) (bArr[i3] ^ this.f2139a[(this.f2139a[i] + this.f2139a[i2]) & 255]);
        }
        this.f2140b = i;
        this.c = i2;
    }
}
