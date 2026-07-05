package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class bpx extends aun<bpx> {

    /* renamed from: a, reason: collision with root package name */
    public Integer f2956a = null;

    /* renamed from: b, reason: collision with root package name */
    public Integer f2957b = null;
    public Integer c = null;

    public bpx() {
        this.Z = null;
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2956a != null) {
            aumVar.a(1, this.f2956a.intValue());
        }
        if (this.f2957b != null) {
            aumVar.a(2, this.f2957b.intValue());
        }
        if (this.c != null) {
            aumVar.a(3, this.c.intValue());
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f2956a != null) {
            iA += aum.b(1, this.f2956a.intValue());
        }
        if (this.f2957b != null) {
            iA += aum.b(2, this.f2957b.intValue());
        }
        return this.c != null ? iA + aum.b(3, this.c.intValue()) : iA;
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            if (iA == 0) {
                return this;
            }
            if (iA == 8) {
                this.f2956a = Integer.valueOf(aulVar.g());
            } else if (iA == 16) {
                this.f2957b = Integer.valueOf(aulVar.g());
            } else if (iA != 24) {
                if (!super.a(aulVar, iA)) {
                    return this;
                }
            } else {
                this.c = Integer.valueOf(aulVar.g());
            }
        }
    }
}
