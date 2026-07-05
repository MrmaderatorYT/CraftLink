package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.bpc;

/* loaded from: classes.dex */
public final class bpw extends aun<bpw> {
    private Integer e = null;

    /* renamed from: a, reason: collision with root package name */
    public String f2954a = null;
    private Integer f = null;
    private bpj g = null;
    private bpx h = null;

    /* renamed from: b, reason: collision with root package name */
    public long[] f2955b = auw.f2292b;
    public bpu c = null;
    private bpv i = null;
    private bpc.h j = null;
    public bps d = null;

    public bpw() {
        this.Z = null;
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.e != null) {
            aumVar.a(9, this.e.intValue());
        }
        if (this.f2954a != null) {
            aumVar.a(10, this.f2954a);
        }
        if (this.f != null) {
            int iIntValue = this.f.intValue();
            aumVar.c(11, 0);
            aumVar.c(iIntValue);
        }
        if (this.g != null && this.g != null) {
            aumVar.a(12, this.g.a());
        }
        if (this.h != null) {
            aumVar.a(13, this.h);
        }
        if (this.f2955b != null && this.f2955b.length > 0) {
            for (int i = 0; i < this.f2955b.length; i++) {
                aumVar.a(14, this.f2955b[i]);
            }
        }
        if (this.c != null) {
            aumVar.a(15, this.c);
        }
        if (this.i != null) {
            aumVar.a(16, this.i);
        }
        if (this.j != null) {
            aumVar.a(17, this.j);
        }
        if (this.d != null) {
            aumVar.a(18, this.d);
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.e != null) {
            iA += aum.b(9, this.e.intValue());
        }
        if (this.f2954a != null) {
            iA += aum.b(10, this.f2954a);
        }
        if (this.f != null) {
            iA += aum.b(11) + aum.d(this.f.intValue());
        }
        if (this.g != null && this.g != null) {
            iA += aum.b(12, this.g.a());
        }
        if (this.h != null) {
            iA += aum.b(13, this.h);
        }
        if (this.f2955b != null && this.f2955b.length > 0) {
            int iA2 = 0;
            for (int i = 0; i < this.f2955b.length; i++) {
                iA2 += aum.a(this.f2955b[i]);
            }
            iA = iA + iA2 + (this.f2955b.length * 1);
        }
        if (this.c != null) {
            iA += aum.b(15, this.c);
        }
        if (this.i != null) {
            iA += aum.b(16, this.i);
        }
        if (this.j != null) {
            iA += zzbqk.c(17, this.j);
        }
        return this.d != null ? iA + aum.b(18, this.d) : iA;
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            switch (iA) {
                case 0:
                    return this;
                case 72:
                    this.e = Integer.valueOf(aulVar.g());
                    break;
                case 82:
                    this.f2954a = aulVar.e();
                    break;
                case 88:
                    this.f = Integer.valueOf(aulVar.g());
                    break;
                case 96:
                    int iJ = aulVar.j();
                    int iG = aulVar.g();
                    if (iG != 1000) {
                        switch (iG) {
                            case 0:
                            case 1:
                                break;
                            default:
                                aulVar.e(iJ);
                                a(aulVar, iA);
                                continue;
                        }
                    }
                    this.g = bpj.a(iG);
                    break;
                case 106:
                    if (this.h == null) {
                        this.h = new bpx();
                    }
                    aulVar.a(this.h);
                    break;
                case 112:
                    int iA2 = auw.a(aulVar, 112);
                    int length = this.f2955b == null ? 0 : this.f2955b.length;
                    long[] jArr = new long[iA2 + length];
                    if (length != 0) {
                        System.arraycopy(this.f2955b, 0, jArr, 0, length);
                    }
                    while (length < jArr.length - 1) {
                        jArr[length] = aulVar.h();
                        aulVar.a();
                        length++;
                    }
                    jArr[length] = aulVar.h();
                    this.f2955b = jArr;
                    break;
                case 114:
                    int iC = aulVar.c(aulVar.g());
                    int iJ2 = aulVar.j();
                    int i = 0;
                    while (aulVar.i() > 0) {
                        aulVar.h();
                        i++;
                    }
                    aulVar.e(iJ2);
                    int length2 = this.f2955b == null ? 0 : this.f2955b.length;
                    long[] jArr2 = new long[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.f2955b, 0, jArr2, 0, length2);
                    }
                    while (length2 < jArr2.length) {
                        jArr2[length2] = aulVar.h();
                        length2++;
                    }
                    this.f2955b = jArr2;
                    aulVar.d(iC);
                    break;
                case 122:
                    if (this.c == null) {
                        this.c = new bpu();
                    }
                    aulVar.a(this.c);
                    break;
                case 130:
                    if (this.i == null) {
                        this.i = new bpv();
                    }
                    aulVar.a(this.i);
                    break;
                case 138:
                    this.j = (bpc.h) aulVar.a(bpc.h.a());
                    break;
                case 146:
                    if (this.d == null) {
                        this.d = new bps();
                    }
                    aulVar.a(this.d);
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
