package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.bpc;

/* loaded from: classes.dex */
public final class bpt extends aun<bpt> {

    /* renamed from: a, reason: collision with root package name */
    public String f2948a = null;

    /* renamed from: b, reason: collision with root package name */
    private bpc.a[] f2949b = new bpc.a[0];
    private bpj c = null;
    private bpj d = null;
    private bpj e = null;

    public bpt() {
        this.Z = null;
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2948a != null) {
            aumVar.a(1, this.f2948a);
        }
        if (this.f2949b != null && this.f2949b.length > 0) {
            for (int i = 0; i < this.f2949b.length; i++) {
                bpc.a aVar = this.f2949b[i];
                if (aVar != null) {
                    aumVar.a(2, aVar);
                }
            }
        }
        if (this.c != null && this.c != null) {
            aumVar.a(3, this.c.a());
        }
        if (this.d != null && this.d != null) {
            aumVar.a(4, this.d.a());
        }
        if (this.e != null && this.e != null) {
            aumVar.a(5, this.e.a());
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f2948a != null) {
            iA += aum.b(1, this.f2948a);
        }
        if (this.f2949b != null && this.f2949b.length > 0) {
            for (int i = 0; i < this.f2949b.length; i++) {
                bpc.a aVar = this.f2949b[i];
                if (aVar != null) {
                    iA += zzbqk.c(2, aVar);
                }
            }
        }
        if (this.c != null && this.c != null) {
            iA += aum.b(3, this.c.a());
        }
        if (this.d != null && this.d != null) {
            iA += aum.b(4, this.d.a());
        }
        return (this.e == null || this.e == null) ? iA : iA + aum.b(5, this.e.a());
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            if (iA == 0) {
                return this;
            }
            if (iA == 10) {
                this.f2948a = aulVar.e();
            } else if (iA == 18) {
                int iA2 = auw.a(aulVar, 18);
                int length = this.f2949b == null ? 0 : this.f2949b.length;
                bpc.a[] aVarArr = new bpc.a[iA2 + length];
                if (length != 0) {
                    System.arraycopy(this.f2949b, 0, aVarArr, 0, length);
                }
                while (length < aVarArr.length - 1) {
                    aVarArr[length] = (bpc.a) aulVar.a(bpc.a.a());
                    aulVar.a();
                    length++;
                }
                aVarArr[length] = (bpc.a) aulVar.a(bpc.a.a());
                this.f2949b = aVarArr;
            } else if (iA == 24) {
                int iJ = aulVar.j();
                int iG = aulVar.g();
                if (iG != 1000) {
                    switch (iG) {
                        case 0:
                        case 1:
                            break;
                        default:
                            aulVar.e(iJ);
                            a(aulVar, iA);
                            continue;
                    }
                }
                this.c = bpj.a(iG);
            } else if (iA == 32) {
                int iJ2 = aulVar.j();
                int iG2 = aulVar.g();
                if (iG2 != 1000) {
                    switch (iG2) {
                        case 0:
                        case 1:
                            break;
                        default:
                            aulVar.e(iJ2);
                            a(aulVar, iA);
                            continue;
                    }
                }
                this.d = bpj.a(iG2);
            } else if (iA != 40) {
                if (!super.a(aulVar, iA)) {
                    return this;
                }
            } else {
                int iJ3 = aulVar.j();
                int iG3 = aulVar.g();
                if (iG3 != 1000) {
                    switch (iG3) {
                        case 0:
                        case 1:
                            break;
                        default:
                            aulVar.e(iJ3);
                            a(aulVar, iA);
                            continue;
                    }
                }
                this.e = bpj.a(iG3);
            }
        }
    }
}
