package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class agn extends aun<agn> {

    /* renamed from: a, reason: collision with root package name */
    public String f1970a = null;

    /* renamed from: b, reason: collision with root package name */
    public Long f1971b = null;
    private String c = null;
    private String d = null;
    private String e = null;
    private Long f = null;
    private Long g = null;
    private String h = null;
    private Long i = null;
    private String j = null;

    public agn() {
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f1970a != null) {
            aumVar.a(1, this.f1970a);
        }
        if (this.f1971b != null) {
            aumVar.b(2, this.f1971b.longValue());
        }
        if (this.c != null) {
            aumVar.a(3, this.c);
        }
        if (this.d != null) {
            aumVar.a(4, this.d);
        }
        if (this.e != null) {
            aumVar.a(5, this.e);
        }
        if (this.f != null) {
            aumVar.b(6, this.f.longValue());
        }
        if (this.g != null) {
            aumVar.b(7, this.g.longValue());
        }
        if (this.h != null) {
            aumVar.a(8, this.h);
        }
        if (this.i != null) {
            aumVar.b(9, this.i.longValue());
        }
        if (this.j != null) {
            aumVar.a(10, this.j);
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f1970a != null) {
            iA += aum.b(1, this.f1970a);
        }
        if (this.f1971b != null) {
            iA += aum.d(2, this.f1971b.longValue());
        }
        if (this.c != null) {
            iA += aum.b(3, this.c);
        }
        if (this.d != null) {
            iA += aum.b(4, this.d);
        }
        if (this.e != null) {
            iA += aum.b(5, this.e);
        }
        if (this.f != null) {
            iA += aum.d(6, this.f.longValue());
        }
        if (this.g != null) {
            iA += aum.d(7, this.g.longValue());
        }
        if (this.h != null) {
            iA += aum.b(8, this.h);
        }
        if (this.i != null) {
            iA += aum.d(9, this.i.longValue());
        }
        return this.j != null ? iA + aum.b(10, this.j) : iA;
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            switch (iA) {
                case 0:
                    return this;
                case 10:
                    this.f1970a = aulVar.e();
                    break;
                case 16:
                    this.f1971b = Long.valueOf(aulVar.h());
                    break;
                case 26:
                    this.c = aulVar.e();
                    break;
                case 34:
                    this.d = aulVar.e();
                    break;
                case 42:
                    this.e = aulVar.e();
                    break;
                case 48:
                    this.f = Long.valueOf(aulVar.h());
                    break;
                case 56:
                    this.g = Long.valueOf(aulVar.h());
                    break;
                case 66:
                    this.h = aulVar.e();
                    break;
                case 72:
                    this.i = Long.valueOf(aulVar.h());
                    break;
                case 82:
                    this.j = aulVar.e();
                    break;
                default:
                    if (!super.a(aulVar, iA)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
