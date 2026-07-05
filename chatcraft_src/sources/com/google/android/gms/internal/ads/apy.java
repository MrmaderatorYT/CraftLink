package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
class apy extends apx {

    /* renamed from: b, reason: collision with root package name */
    protected final byte[] f2157b;

    apy(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.f2157b = bArr;
    }

    protected int g() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.apo
    public byte a(int i) {
        return this.f2157b[i];
    }

    @Override // com.google.android.gms.internal.ads.apo
    public int a() {
        return this.f2157b.length;
    }

    @Override // com.google.android.gms.internal.ads.apo
    public final apo a(int i, int i2) {
        int iB = b(0, i2, a());
        if (iB == 0) {
            return apo.f2149a;
        }
        return new aps(this.f2157b, g(), iB);
    }

    @Override // com.google.android.gms.internal.ads.apo
    protected void a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f2157b, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.ads.apo
    final void a(apn apnVar) {
        apnVar.a(this.f2157b, g(), a());
    }

    @Override // com.google.android.gms.internal.ads.apo
    protected final String a(Charset charset) {
        return new String(this.f2157b, g(), a(), charset);
    }

    @Override // com.google.android.gms.internal.ads.apo
    public final boolean d() {
        int iG = g();
        return atx.a(this.f2157b, iG, a() + iG);
    }

    @Override // com.google.android.gms.internal.ads.apo
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof apo) || a() != ((apo) obj).a()) {
            return false;
        }
        if (a() == 0) {
            return true;
        }
        if (obj instanceof apy) {
            apy apyVar = (apy) obj;
            int iF = f();
            int iF2 = apyVar.f();
            if (iF == 0 || iF2 == 0 || iF == iF2) {
                return a(apyVar, 0, a());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.ads.apx
    final boolean a(apo apoVar, int i, int i2) {
        if (i2 > apoVar.a()) {
            int iA = a();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(iA);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 > apoVar.a()) {
            int iA2 = apoVar.a();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(iA2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (apoVar instanceof apy) {
            apy apyVar = (apy) apoVar;
            byte[] bArr = this.f2157b;
            byte[] bArr2 = apyVar.f2157b;
            int iG = g() + i2;
            int iG2 = g();
            int iG3 = apyVar.g();
            while (iG2 < iG) {
                if (bArr[iG2] != bArr2[iG3]) {
                    return false;
                }
                iG2++;
                iG3++;
            }
            return true;
        }
        return apoVar.a(0, i2).equals(a(0, i2));
    }

    @Override // com.google.android.gms.internal.ads.apo
    protected final int a(int i, int i2, int i3) {
        return ara.a(i, this.f2157b, g(), i3);
    }

    @Override // com.google.android.gms.internal.ads.apo
    public final aqa e() {
        return aqa.a(this.f2157b, g(), a(), true);
    }
}
