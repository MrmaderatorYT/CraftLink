package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aux;

/* loaded from: classes.dex */
public final class avl extends aun<avl> {

    /* renamed from: a, reason: collision with root package name */
    private aux.b.e.C0076b f2314a = null;

    /* renamed from: b, reason: collision with root package name */
    private avj[] f2315b = avj.b();
    private byte[] c = null;
    private byte[] d = null;
    private Integer e = null;
    private byte[] f = null;

    public avl() {
        this.Z = null;
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2314a != null) {
            aumVar.a(1, this.f2314a);
        }
        if (this.f2315b != null && this.f2315b.length > 0) {
            for (int i = 0; i < this.f2315b.length; i++) {
                avj avjVar = this.f2315b[i];
                if (avjVar != null) {
                    aumVar.a(2, avjVar);
                }
            }
        }
        if (this.c != null) {
            aumVar.a(3, this.c);
        }
        if (this.d != null) {
            aumVar.a(4, this.d);
        }
        if (this.e != null) {
            aumVar.a(5, this.e.intValue());
        }
        if (this.f != null) {
            aumVar.a(6, this.f);
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f2314a != null) {
            iA += zzbqk.c(1, this.f2314a);
        }
        if (this.f2315b != null && this.f2315b.length > 0) {
            for (int i = 0; i < this.f2315b.length; i++) {
                avj avjVar = this.f2315b[i];
                if (avjVar != null) {
                    iA += aum.b(2, avjVar);
                }
            }
        }
        if (this.c != null) {
            iA += aum.b(3, this.c);
        }
        if (this.d != null) {
            iA += aum.b(4, this.d);
        }
        if (this.e != null) {
            iA += aum.b(5, this.e.intValue());
        }
        return this.f != null ? iA + aum.b(6, this.f) : iA;
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            if (iA == 0) {
                return this;
            }
            if (iA == 10) {
                this.f2314a = (aux.b.e.C0076b) aulVar.a(aux.b.e.C0076b.a());
            } else if (iA == 18) {
                int iA2 = auw.a(aulVar, 18);
                int length = this.f2315b == null ? 0 : this.f2315b.length;
                avj[] avjVarArr = new avj[iA2 + length];
                if (length != 0) {
                    System.arraycopy(this.f2315b, 0, avjVarArr, 0, length);
                }
                while (length < avjVarArr.length - 1) {
                    avjVarArr[length] = new avj();
                    aulVar.a(avjVarArr[length]);
                    aulVar.a();
                    length++;
                }
                avjVarArr[length] = new avj();
                aulVar.a(avjVarArr[length]);
                this.f2315b = avjVarArr;
            } else if (iA == 26) {
                this.c = aulVar.f();
            } else if (iA == 34) {
                this.d = aulVar.f();
            } else if (iA == 40) {
                this.e = Integer.valueOf(aulVar.c());
            } else if (iA != 50) {
                if (!super.a(aulVar, iA)) {
                    return this;
                }
            } else {
                this.f = aulVar.f();
            }
        }
    }
}
