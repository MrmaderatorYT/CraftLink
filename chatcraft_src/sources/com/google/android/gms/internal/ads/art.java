package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class art extends aun<art> {

    /* renamed from: a, reason: collision with root package name */
    public byte[][] f2214a = auw.d;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f2215b = null;
    public Integer c;
    private Integer d;

    public art() {
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2214a != null && this.f2214a.length > 0) {
            for (int i = 0; i < this.f2214a.length; i++) {
                byte[] bArr = this.f2214a[i];
                if (bArr != null) {
                    aumVar.a(1, bArr);
                }
            }
        }
        if (this.f2215b != null) {
            aumVar.a(2, this.f2215b);
        }
        if (this.d != null) {
            aumVar.a(3, this.d.intValue());
        }
        if (this.c != null) {
            aumVar.a(4, this.c.intValue());
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f2214a != null && this.f2214a.length > 0) {
            int iB = 0;
            int i = 0;
            for (int i2 = 0; i2 < this.f2214a.length; i2++) {
                byte[] bArr = this.f2214a[i2];
                if (bArr != null) {
                    i++;
                    iB += aum.b(bArr);
                }
            }
            iA = iA + iB + (i * 1);
        }
        if (this.f2215b != null) {
            iA += aum.b(2, this.f2215b);
        }
        if (this.d != null) {
            iA += aum.b(3, this.d.intValue());
        }
        return this.c != null ? iA + aum.b(4, this.c.intValue()) : iA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.aus
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final art a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            if (iA == 0) {
                return this;
            }
            if (iA == 10) {
                int iA2 = auw.a(aulVar, 10);
                int length = this.f2214a == null ? 0 : this.f2214a.length;
                byte[][] bArr = new byte[iA2 + length][];
                if (length != 0) {
                    System.arraycopy(this.f2214a, 0, bArr, 0, length);
                }
                while (length < bArr.length - 1) {
                    bArr[length] = aulVar.f();
                    aulVar.a();
                    length++;
                }
                bArr[length] = aulVar.f();
                this.f2214a = bArr;
            } else if (iA == 18) {
                this.f2215b = aulVar.f();
            } else if (iA == 24) {
                int iJ = aulVar.j();
                try {
                    this.d = Integer.valueOf(ajo.b(aulVar.g()));
                } catch (IllegalArgumentException unused) {
                    aulVar.e(iJ);
                    a(aulVar, iA);
                }
            } else if (iA != 32) {
                if (!super.a(aulVar, iA)) {
                    return this;
                }
            } else {
                int iJ2 = aulVar.j();
                try {
                    this.c = Integer.valueOf(ajo.c(aulVar.g()));
                } catch (IllegalArgumentException unused2) {
                    aulVar.e(iJ2);
                    a(aulVar, iA);
                }
            }
        }
    }
}
