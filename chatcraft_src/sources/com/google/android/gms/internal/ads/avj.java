package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class avj extends aun<avj> {
    private static volatile avj[] c;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f2310a = null;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f2311b = null;

    public static avj[] b() {
        if (c == null) {
            synchronized (aur.f2286b) {
                if (c == null) {
                    c = new avj[0];
                }
            }
        }
        return c;
    }

    public avj() {
        this.Z = null;
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        aumVar.a(1, this.f2310a);
        if (this.f2311b != null) {
            aumVar.a(2, this.f2311b);
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a() + aum.b(1, this.f2310a);
        return this.f2311b != null ? iA + aum.b(2, this.f2311b) : iA;
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            if (iA == 0) {
                return this;
            }
            if (iA == 10) {
                this.f2310a = aulVar.f();
            } else if (iA != 18) {
                if (!super.a(aulVar, iA)) {
                    return this;
                }
            } else {
                this.f2311b = aulVar.f();
            }
        }
    }
}
