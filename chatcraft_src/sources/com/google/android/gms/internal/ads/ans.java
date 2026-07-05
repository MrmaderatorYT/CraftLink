package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class ans extends aun<ans> {

    /* renamed from: a, reason: collision with root package name */
    private Long f2096a = null;

    /* renamed from: b, reason: collision with root package name */
    private Integer f2097b = null;
    private Boolean c = null;
    private int[] d = auw.f2291a;
    private Long e = null;

    public ans() {
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2096a != null) {
            aumVar.b(1, this.f2096a.longValue());
        }
        if (this.f2097b != null) {
            aumVar.a(2, this.f2097b.intValue());
        }
        if (this.c != null) {
            aumVar.a(3, this.c.booleanValue());
        }
        if (this.d != null && this.d.length > 0) {
            for (int i = 0; i < this.d.length; i++) {
                aumVar.a(4, this.d[i]);
            }
        }
        if (this.e != null) {
            aumVar.a(5, this.e.longValue());
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f2096a != null) {
            iA += aum.d(1, this.f2096a.longValue());
        }
        if (this.f2097b != null) {
            iA += aum.b(2, this.f2097b.intValue());
        }
        if (this.c != null) {
            this.c.booleanValue();
            iA += aum.b(3) + 1;
        }
        if (this.d != null && this.d.length > 0) {
            int iA2 = 0;
            for (int i = 0; i < this.d.length; i++) {
                iA2 += aum.a(this.d[i]);
            }
            iA = iA + iA2 + (this.d.length * 1);
        }
        return this.e != null ? iA + aum.c(5, this.e.longValue()) : iA;
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            if (iA == 0) {
                return this;
            }
            if (iA == 8) {
                this.f2096a = Long.valueOf(aulVar.h());
            } else if (iA == 16) {
                this.f2097b = Integer.valueOf(aulVar.g());
            } else if (iA == 24) {
                this.c = Boolean.valueOf(aulVar.d());
            } else if (iA == 32) {
                int iA2 = auw.a(aulVar, 32);
                int length = this.d == null ? 0 : this.d.length;
                int[] iArr = new int[iA2 + length];
                if (length != 0) {
                    System.arraycopy(this.d, 0, iArr, 0, length);
                }
                while (length < iArr.length - 1) {
                    iArr[length] = aulVar.g();
                    aulVar.a();
                    length++;
                }
                iArr[length] = aulVar.g();
                this.d = iArr;
            } else if (iA == 34) {
                int iC = aulVar.c(aulVar.g());
                int iJ = aulVar.j();
                int i = 0;
                while (aulVar.i() > 0) {
                    aulVar.g();
                    i++;
                }
                aulVar.e(iJ);
                int length2 = this.d == null ? 0 : this.d.length;
                int[] iArr2 = new int[i + length2];
                if (length2 != 0) {
                    System.arraycopy(this.d, 0, iArr2, 0, length2);
                }
                while (length2 < iArr2.length) {
                    iArr2[length2] = aulVar.g();
                    length2++;
                }
                this.d = iArr2;
                aulVar.d(iC);
            } else if (iA != 40) {
                if (!super.a(aulVar, iA)) {
                    return this;
                }
            } else {
                this.e = Long.valueOf(aulVar.h());
            }
        }
    }
}
