package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class aon {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f2118a;

    public static aon a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new aon(bArr, 0, bArr.length);
    }

    public final byte[] a() {
        byte[] bArr = new byte[this.f2118a.length];
        System.arraycopy(this.f2118a, 0, bArr, 0, this.f2118a.length);
        return bArr;
    }

    private aon(byte[] bArr, int i, int i2) {
        this.f2118a = new byte[i2];
        System.arraycopy(bArr, 0, this.f2118a, 0, i2);
    }
}
