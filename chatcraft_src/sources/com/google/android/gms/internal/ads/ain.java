package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class ain extends aun<ain> {

    /* renamed from: a, reason: collision with root package name */
    public String f2005a;

    /* renamed from: b, reason: collision with root package name */
    public String f2006b;
    private String c;
    private String d;
    private String e;
    private String f;

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2005a != null) {
            aumVar.a(1, this.f2005a);
        }
        if (this.c != null) {
            aumVar.a(2, this.c);
        }
        if (this.d != null) {
            aumVar.a(3, this.d);
        }
        if (this.e != null) {
            aumVar.a(4, this.e);
        }
        if (this.f != null) {
            aumVar.a(5, this.f);
        }
        if (this.f2006b != null) {
            aumVar.a(6, this.f2006b);
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f2005a != null) {
            iA += aum.b(1, this.f2005a);
        }
        if (this.c != null) {
            iA += aum.b(2, this.c);
        }
        if (this.d != null) {
            iA += aum.b(3, this.d);
        }
        if (this.e != null) {
            iA += aum.b(4, this.e);
        }
        if (this.f != null) {
            iA += aum.b(5, this.f);
        }
        return this.f2006b != null ? iA + aum.b(6, this.f2006b) : iA;
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            if (iA == 0) {
                return this;
            }
            if (iA == 10) {
                this.f2005a = aulVar.e();
            } else if (iA == 18) {
                this.c = aulVar.e();
            } else if (iA == 26) {
                this.d = aulVar.e();
            } else if (iA == 34) {
                this.e = aulVar.e();
            } else if (iA == 42) {
                this.f = aulVar.e();
            } else if (iA != 50) {
                if (!super.a(aulVar, iA)) {
                    return this;
                }
            } else {
                this.f2006b = aulVar.e();
            }
        }
    }
}
