package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.bpc;

/* loaded from: classes.dex */
public final class bpv extends aun<bpv> {

    /* renamed from: a, reason: collision with root package name */
    private bpc.d.b f2952a = null;

    /* renamed from: b, reason: collision with root package name */
    private bpx f2953b = null;
    private String c = null;
    private String d = null;

    public bpv() {
        this.Z = null;
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2952a != null && this.f2952a != null) {
            aumVar.a(5, this.f2952a.a());
        }
        if (this.f2953b != null) {
            aumVar.a(6, this.f2953b);
        }
        if (this.c != null) {
            aumVar.a(7, this.c);
        }
        if (this.d != null) {
            aumVar.a(8, this.d);
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f2952a != null && this.f2952a != null) {
            iA += aum.b(5, this.f2952a.a());
        }
        if (this.f2953b != null) {
            iA += aum.b(6, this.f2953b);
        }
        if (this.c != null) {
            iA += aum.b(7, this.c);
        }
        return this.d != null ? iA + aum.b(8, this.d) : iA;
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            if (iA == 0) {
                return this;
            }
            if (iA == 40) {
                int iJ = aulVar.j();
                int iG = aulVar.g();
                switch (iG) {
                    case 0:
                    case 1:
                    case 2:
                        this.f2952a = bpc.d.b.a(iG);
                        break;
                    default:
                        aulVar.e(iJ);
                        a(aulVar, iA);
                        break;
                }
            } else if (iA == 50) {
                if (this.f2953b == null) {
                    this.f2953b = new bpx();
                }
                aulVar.a(this.f2953b);
            } else if (iA == 58) {
                this.c = aulVar.e();
            } else if (iA != 66) {
                if (!super.a(aulVar, iA)) {
                    return this;
                }
            } else {
                this.d = aulVar.e();
            }
        }
    }
}
