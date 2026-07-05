package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class avm extends aun<avm> {

    /* renamed from: a, reason: collision with root package name */
    public Integer f2316a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f2317b = null;
    public byte[] c = null;

    public avm() {
        this.Z = null;
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2316a != null) {
            aumVar.a(1, this.f2316a.intValue());
        }
        if (this.f2317b != null) {
            aumVar.a(2, this.f2317b);
        }
        if (this.c != null) {
            aumVar.a(3, this.c);
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f2316a != null) {
            iA += aum.b(1, this.f2316a.intValue());
        }
        if (this.f2317b != null) {
            iA += aum.b(2, this.f2317b);
        }
        return this.c != null ? iA + aum.b(3, this.c) : iA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.aus
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final avm a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            if (iA == 0) {
                return this;
            }
            if (iA == 8) {
                int iJ = aulVar.j();
                try {
                    int iC = aulVar.c();
                    if (iC < 0 || iC > 1) {
                        StringBuilder sb = new StringBuilder(36);
                        sb.append(iC);
                        sb.append(" is not a valid enum Type");
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.f2316a = Integer.valueOf(iC);
                } catch (IllegalArgumentException unused) {
                    aulVar.e(iJ);
                    a(aulVar, iA);
                }
            } else if (iA == 18) {
                this.f2317b = aulVar.e();
            } else if (iA != 26) {
                if (!super.a(aulVar, iA)) {
                    return this;
                }
            } else {
                this.c = aulVar.f();
            }
        }
    }
}
