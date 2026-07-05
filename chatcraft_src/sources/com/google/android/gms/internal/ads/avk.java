package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aux;

/* loaded from: classes.dex */
public final class avk extends aun<avk> {

    /* renamed from: b, reason: collision with root package name */
    private aux.b.d.C0075b f2313b = null;

    /* renamed from: a, reason: collision with root package name */
    public avj[] f2312a = avj.b();
    private byte[] c = null;
    private byte[] d = null;
    private Integer e = null;

    public avk() {
        this.Z = null;
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2313b != null) {
            aumVar.a(1, this.f2313b);
        }
        if (this.f2312a != null && this.f2312a.length > 0) {
            for (int i = 0; i < this.f2312a.length; i++) {
                avj avjVar = this.f2312a[i];
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
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f2313b != null) {
            iA += zzbqk.c(1, this.f2313b);
        }
        if (this.f2312a != null && this.f2312a.length > 0) {
            for (int i = 0; i < this.f2312a.length; i++) {
                avj avjVar = this.f2312a[i];
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
        return this.e != null ? iA + aum.b(5, this.e.intValue()) : iA;
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            if (iA == 0) {
                return this;
            }
            if (iA == 10) {
                this.f2313b = (aux.b.d.C0075b) aulVar.a(aux.b.d.C0075b.a());
            } else if (iA == 18) {
                int iA2 = auw.a(aulVar, 18);
                int length = this.f2312a == null ? 0 : this.f2312a.length;
                avj[] avjVarArr = new avj[iA2 + length];
                if (length != 0) {
                    System.arraycopy(this.f2312a, 0, avjVarArr, 0, length);
                }
                while (length < avjVarArr.length - 1) {
                    avjVarArr[length] = new avj();
                    aulVar.a(avjVarArr[length]);
                    aulVar.a();
                    length++;
                }
                avjVarArr[length] = new avj();
                aulVar.a(avjVarArr[length]);
                this.f2312a = avjVarArr;
            } else if (iA == 26) {
                this.c = aulVar.f();
            } else if (iA == 34) {
                this.d = aulVar.f();
            } else if (iA != 40) {
                if (!super.a(aulVar, iA)) {
                    return this;
                }
            } else {
                this.e = Integer.valueOf(aulVar.c());
            }
        }
    }
}
