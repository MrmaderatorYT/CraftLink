package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.bpc;

/* loaded from: classes.dex */
public final class bpu extends aun<bpu> {

    /* renamed from: a, reason: collision with root package name */
    public String f2950a = null;
    private bpc.n c = null;
    private Integer d = null;

    /* renamed from: b, reason: collision with root package name */
    public bpx f2951b = null;
    private Integer e = null;
    private bpj f = null;
    private bpj g = null;
    private bpj h = null;

    public bpu() {
        this.Z = null;
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2950a != null) {
            aumVar.a(1, this.f2950a);
        }
        if (this.c != null) {
            aumVar.a(2, this.c);
        }
        if (this.d != null) {
            aumVar.a(3, this.d.intValue());
        }
        if (this.f2951b != null) {
            aumVar.a(4, this.f2951b);
        }
        if (this.e != null) {
            aumVar.a(5, this.e.intValue());
        }
        if (this.f != null && this.f != null) {
            aumVar.a(6, this.f.a());
        }
        if (this.g != null && this.g != null) {
            aumVar.a(7, this.g.a());
        }
        if (this.h != null && this.h != null) {
            aumVar.a(8, this.h.a());
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f2950a != null) {
            iA += aum.b(1, this.f2950a);
        }
        if (this.c != null) {
            iA += zzbqk.c(2, this.c);
        }
        if (this.d != null) {
            iA += aum.b(3, this.d.intValue());
        }
        if (this.f2951b != null) {
            iA += aum.b(4, this.f2951b);
        }
        if (this.e != null) {
            iA += aum.b(5, this.e.intValue());
        }
        if (this.f != null && this.f != null) {
            iA += aum.b(6, this.f.a());
        }
        if (this.g != null && this.g != null) {
            iA += aum.b(7, this.g.a());
        }
        return (this.h == null || this.h == null) ? iA : iA + aum.b(8, this.h.a());
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            if (iA == 0) {
                return this;
            }
            if (iA == 10) {
                this.f2950a = aulVar.e();
            } else if (iA == 18) {
                this.c = (bpc.n) aulVar.a(bpc.n.a());
            } else if (iA == 24) {
                this.d = Integer.valueOf(aulVar.g());
            } else if (iA == 34) {
                if (this.f2951b == null) {
                    this.f2951b = new bpx();
                }
                aulVar.a(this.f2951b);
            } else if (iA == 40) {
                this.e = Integer.valueOf(aulVar.g());
            } else if (iA == 48) {
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
                this.f = bpj.a(iG);
            } else if (iA == 56) {
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
                this.g = bpj.a(iG2);
            } else if (iA != 64) {
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
                this.h = bpj.a(iG3);
            }
        }
    }
}
