package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class apu extends aun<apu> {

    /* renamed from: a, reason: collision with root package name */
    public Long f2153a = null;

    /* renamed from: b, reason: collision with root package name */
    private String f2154b = null;
    private byte[] c = null;

    public apu() {
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2153a != null) {
            aumVar.b(1, this.f2153a.longValue());
        }
        if (this.f2154b != null) {
            aumVar.a(3, this.f2154b);
        }
        if (this.c != null) {
            aumVar.a(4, this.c);
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f2153a != null) {
            iA += aum.d(1, this.f2153a.longValue());
        }
        if (this.f2154b != null) {
            iA += aum.b(3, this.f2154b);
        }
        return this.c != null ? iA + aum.b(4, this.c) : iA;
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            if (iA == 0) {
                return this;
            }
            if (iA == 8) {
                this.f2153a = Long.valueOf(aulVar.h());
            } else if (iA == 26) {
                this.f2154b = aulVar.e();
            } else if (iA != 34) {
                if (!super.a(aulVar, iA)) {
                    return this;
                }
            } else {
                this.c = aulVar.f();
            }
        }
    }
}
