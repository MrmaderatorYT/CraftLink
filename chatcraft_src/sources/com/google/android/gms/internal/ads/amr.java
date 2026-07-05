package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class amr extends aun<amr> {
    private Long d = null;
    private Long e = null;

    /* renamed from: a, reason: collision with root package name */
    public Long f2078a = null;

    /* renamed from: b, reason: collision with root package name */
    public Long f2079b = null;
    public Long c = null;

    public amr() {
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.d != null) {
            aumVar.b(1, this.d.longValue());
        }
        if (this.e != null) {
            aumVar.b(2, this.e.longValue());
        }
        if (this.f2078a != null) {
            aumVar.b(3, this.f2078a.longValue());
        }
        if (this.f2079b != null) {
            aumVar.b(4, this.f2079b.longValue());
        }
        if (this.c != null) {
            aumVar.b(5, this.c.longValue());
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.d != null) {
            iA += aum.d(1, this.d.longValue());
        }
        if (this.e != null) {
            iA += aum.d(2, this.e.longValue());
        }
        if (this.f2078a != null) {
            iA += aum.d(3, this.f2078a.longValue());
        }
        if (this.f2079b != null) {
            iA += aum.d(4, this.f2079b.longValue());
        }
        return this.c != null ? iA + aum.d(5, this.c.longValue()) : iA;
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            if (iA == 0) {
                return this;
            }
            if (iA == 8) {
                this.d = Long.valueOf(aulVar.h());
            } else if (iA == 16) {
                this.e = Long.valueOf(aulVar.h());
            } else if (iA == 24) {
                this.f2078a = Long.valueOf(aulVar.h());
            } else if (iA == 32) {
                this.f2079b = Long.valueOf(aulVar.h());
            } else if (iA != 40) {
                if (!super.a(aulVar, iA)) {
                    return this;
                }
            } else {
                this.c = Long.valueOf(aulVar.h());
            }
        }
    }
}
