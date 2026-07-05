package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class aqu extends aun<aqu> {

    /* renamed from: a, reason: collision with root package name */
    public String f2184a = null;

    public aqu() {
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2184a != null) {
            aumVar.a(1, this.f2184a);
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        return this.f2184a != null ? iA + aum.b(1, this.f2184a) : iA;
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            if (iA == 0) {
                return this;
            }
            if (iA != 10) {
                if (!super.a(aulVar, iA)) {
                    return this;
                }
            } else {
                this.f2184a = aulVar.e();
            }
        }
    }
}
