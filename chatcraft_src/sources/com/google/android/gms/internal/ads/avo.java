package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class avo extends aun<avo> {

    /* renamed from: a, reason: collision with root package name */
    public String f2320a = null;

    /* renamed from: b, reason: collision with root package name */
    public Long f2321b = null;
    public Boolean c = null;

    public avo() {
        this.Z = null;
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2320a != null) {
            aumVar.a(1, this.f2320a);
        }
        if (this.f2321b != null) {
            aumVar.b(2, this.f2321b.longValue());
        }
        if (this.c != null) {
            aumVar.a(3, this.c.booleanValue());
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f2320a != null) {
            iA += aum.b(1, this.f2320a);
        }
        if (this.f2321b != null) {
            iA += aum.d(2, this.f2321b.longValue());
        }
        if (this.c == null) {
            return iA;
        }
        this.c.booleanValue();
        return iA + aum.b(3) + 1;
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            if (iA == 0) {
                return this;
            }
            if (iA == 10) {
                this.f2320a = aulVar.e();
            } else if (iA == 16) {
                this.f2321b = Long.valueOf(aulVar.b());
            } else if (iA != 24) {
                if (!super.a(aulVar, iA)) {
                    return this;
                }
            } else {
                this.c = Boolean.valueOf(aulVar.d());
            }
        }
    }
}
