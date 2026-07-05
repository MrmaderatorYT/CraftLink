package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class aps extends apy {
    private final int c;
    private final int d;

    aps(byte[] bArr, int i, int i2) {
        super(bArr);
        b(i, i + i2, bArr.length);
        this.c = i;
        this.d = i2;
    }

    @Override // com.google.android.gms.internal.ads.apy, com.google.android.gms.internal.ads.apo
    public final byte a(int i) {
        int iA = a();
        if (((iA - (i + 1)) | i) >= 0) {
            return this.f2157b[this.c + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(iA);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.ads.apy, com.google.android.gms.internal.ads.apo
    public final int a() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.apy
    protected final int g() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.apy, com.google.android.gms.internal.ads.apo
    protected final void a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f2157b, g(), bArr, 0, i3);
    }
}
