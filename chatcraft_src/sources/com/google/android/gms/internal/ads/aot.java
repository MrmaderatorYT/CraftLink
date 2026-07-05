package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class aot extends aun<aot> {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f2122a = null;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f2123b = null;
    public byte[] c = null;
    public byte[] d = null;

    public aot() {
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2122a != null) {
            aumVar.a(1, this.f2122a);
        }
        if (this.f2123b != null) {
            aumVar.a(2, this.f2123b);
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
        if (this.f2122a != null) {
            iA += aum.b(1, this.f2122a);
        }
        if (this.f2123b != null) {
            iA += aum.b(2, this.f2123b);
        }
        if (this.c != null) {
            iA += aum.b(3, this.c);
        }
        return this.d != null ? iA + aum.b(4, this.d) : iA;
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            if (iA == 0) {
                return this;
            }
            if (iA == 10) {
                this.f2122a = aulVar.f();
            } else if (iA == 18) {
                this.f2123b = aulVar.f();
            } else if (iA == 26) {
                this.c = aulVar.f();
            } else if (iA != 34) {
                if (!super.a(aulVar, iA)) {
                    return this;
                }
            } else {
                this.d = aulVar.f();
            }
        }
    }
}
