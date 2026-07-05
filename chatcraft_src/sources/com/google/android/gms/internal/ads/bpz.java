package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.bpc;

/* loaded from: classes.dex */
public final class bpz extends aun<bpz> {

    /* renamed from: a, reason: collision with root package name */
    private bpx f2960a = null;

    /* renamed from: b, reason: collision with root package name */
    private bpj f2961b = null;
    private bpc.q c = null;
    private bpc.n d = null;

    public bpz() {
        this.Z = null;
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2960a != null) {
            aumVar.a(1, this.f2960a);
        }
        if (this.f2961b != null && this.f2961b != null) {
            aumVar.a(2, this.f2961b.a());
        }
        if (this.c != null) {
            aumVar.a(3, this.c);
        }
        if (this.d != null) {
            aumVar.a(4, this.d);
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f2960a != null) {
            iA += aum.b(1, this.f2960a);
        }
        if (this.f2961b != null && this.f2961b != null) {
            iA += aum.b(2, this.f2961b.a());
        }
        if (this.c != null) {
            iA += zzbqk.c(3, this.c);
        }
        return this.d != null ? iA + zzbqk.c(4, this.d) : iA;
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            if (iA == 0) {
                return this;
            }
            if (iA == 10) {
                if (this.f2960a == null) {
                    this.f2960a = new bpx();
                }
                aulVar.a(this.f2960a);
            } else if (iA == 16) {
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
                this.f2961b = bpj.a(iG);
            } else if (iA == 26) {
                this.c = (bpc.q) aulVar.a(bpc.q.a());
            } else if (iA != 34) {
                if (!super.a(aulVar, iA)) {
                    return this;
                }
            } else {
                this.d = (bpc.n) aulVar.a(bpc.n.a());
            }
        }
    }
}
