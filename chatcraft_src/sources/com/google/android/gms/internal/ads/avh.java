package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aux;

/* loaded from: classes.dex */
public final class avh extends aun<avh> {

    /* renamed from: a, reason: collision with root package name */
    public Integer f2307a = null;
    private aux.a.c k = null;

    /* renamed from: b, reason: collision with root package name */
    public String f2308b = null;
    public String c = null;
    private String l = null;
    public avi d = null;
    public avn[] e = avn.b();
    public String f = null;
    public avm g = null;
    private Boolean m = null;
    private String[] n = auw.c;
    private String o = null;
    private Boolean p = null;
    private Boolean q = null;
    private byte[] r = null;
    public avo h = null;
    public String[] i = auw.c;
    public String[] j = auw.c;

    public avh() {
        this.Z = null;
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2308b != null) {
            aumVar.a(1, this.f2308b);
        }
        if (this.c != null) {
            aumVar.a(2, this.c);
        }
        if (this.l != null) {
            aumVar.a(3, this.l);
        }
        if (this.e != null && this.e.length > 0) {
            for (int i = 0; i < this.e.length; i++) {
                avn avnVar = this.e[i];
                if (avnVar != null) {
                    aumVar.a(4, avnVar);
                }
            }
        }
        if (this.m != null) {
            aumVar.a(5, this.m.booleanValue());
        }
        if (this.n != null && this.n.length > 0) {
            for (int i2 = 0; i2 < this.n.length; i2++) {
                String str = this.n[i2];
                if (str != null) {
                    aumVar.a(6, str);
                }
            }
        }
        if (this.o != null) {
            aumVar.a(7, this.o);
        }
        if (this.p != null) {
            aumVar.a(8, this.p.booleanValue());
        }
        if (this.q != null) {
            aumVar.a(9, this.q.booleanValue());
        }
        if (this.f2307a != null) {
            aumVar.a(10, this.f2307a.intValue());
        }
        if (this.k != null && this.k != null) {
            aumVar.a(11, this.k.a());
        }
        if (this.d != null) {
            aumVar.a(12, this.d);
        }
        if (this.f != null) {
            aumVar.a(13, this.f);
        }
        if (this.g != null) {
            aumVar.a(14, this.g);
        }
        if (this.r != null) {
            aumVar.a(15, this.r);
        }
        if (this.h != null) {
            aumVar.a(17, this.h);
        }
        if (this.i != null && this.i.length > 0) {
            for (int i3 = 0; i3 < this.i.length; i3++) {
                String str2 = this.i[i3];
                if (str2 != null) {
                    aumVar.a(20, str2);
                }
            }
        }
        if (this.j != null && this.j.length > 0) {
            for (int i4 = 0; i4 < this.j.length; i4++) {
                String str3 = this.j[i4];
                if (str3 != null) {
                    aumVar.a(21, str3);
                }
            }
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f2308b != null) {
            iA += aum.b(1, this.f2308b);
        }
        if (this.c != null) {
            iA += aum.b(2, this.c);
        }
        if (this.l != null) {
            iA += aum.b(3, this.l);
        }
        if (this.e != null && this.e.length > 0) {
            int iB = iA;
            for (int i = 0; i < this.e.length; i++) {
                avn avnVar = this.e[i];
                if (avnVar != null) {
                    iB += aum.b(4, avnVar);
                }
            }
            iA = iB;
        }
        if (this.m != null) {
            this.m.booleanValue();
            iA += aum.b(5) + 1;
        }
        if (this.n != null && this.n.length > 0) {
            int iA2 = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.n.length; i3++) {
                String str = this.n[i3];
                if (str != null) {
                    i2++;
                    iA2 += aum.a(str);
                }
            }
            iA = iA + iA2 + (i2 * 1);
        }
        if (this.o != null) {
            iA += aum.b(7, this.o);
        }
        if (this.p != null) {
            this.p.booleanValue();
            iA += aum.b(8) + 1;
        }
        if (this.q != null) {
            this.q.booleanValue();
            iA += aum.b(9) + 1;
        }
        if (this.f2307a != null) {
            iA += aum.b(10, this.f2307a.intValue());
        }
        if (this.k != null && this.k != null) {
            iA += aum.b(11, this.k.a());
        }
        if (this.d != null) {
            iA += aum.b(12, this.d);
        }
        if (this.f != null) {
            iA += aum.b(13, this.f);
        }
        if (this.g != null) {
            iA += aum.b(14, this.g);
        }
        if (this.r != null) {
            iA += aum.b(15, this.r);
        }
        if (this.h != null) {
            iA += aum.b(17, this.h);
        }
        if (this.i != null && this.i.length > 0) {
            int iA3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < this.i.length; i5++) {
                String str2 = this.i[i5];
                if (str2 != null) {
                    i4++;
                    iA3 += aum.a(str2);
                }
            }
            iA = iA + iA3 + (i4 * 2);
        }
        if (this.j == null || this.j.length <= 0) {
            return iA;
        }
        int iA4 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < this.j.length; i7++) {
            String str3 = this.j[i7];
            if (str3 != null) {
                i6++;
                iA4 += aum.a(str3);
            }
        }
        return iA + iA4 + (i6 * 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.aus
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final avh a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            switch (iA) {
                case 0:
                    return this;
                case 10:
                    this.f2308b = aulVar.e();
                    break;
                case 18:
                    this.c = aulVar.e();
                    break;
                case 26:
                    this.l = aulVar.e();
                    break;
                case 34:
                    int iA2 = auw.a(aulVar, 34);
                    int length = this.e == null ? 0 : this.e.length;
                    avn[] avnVarArr = new avn[iA2 + length];
                    if (length != 0) {
                        System.arraycopy(this.e, 0, avnVarArr, 0, length);
                    }
                    while (length < avnVarArr.length - 1) {
                        avnVarArr[length] = new avn();
                        aulVar.a(avnVarArr[length]);
                        aulVar.a();
                        length++;
                    }
                    avnVarArr[length] = new avn();
                    aulVar.a(avnVarArr[length]);
                    this.e = avnVarArr;
                    break;
                case 40:
                    this.m = Boolean.valueOf(aulVar.d());
                    break;
                case 50:
                    int iA3 = auw.a(aulVar, 50);
                    int length2 = this.n == null ? 0 : this.n.length;
                    String[] strArr = new String[iA3 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.n, 0, strArr, 0, length2);
                    }
                    while (length2 < strArr.length - 1) {
                        strArr[length2] = aulVar.e();
                        aulVar.a();
                        length2++;
                    }
                    strArr[length2] = aulVar.e();
                    this.n = strArr;
                    break;
                case 58:
                    this.o = aulVar.e();
                    break;
                case 64:
                    this.p = Boolean.valueOf(aulVar.d());
                    break;
                case 72:
                    this.q = Boolean.valueOf(aulVar.d());
                    break;
                case 80:
                    int iJ = aulVar.j();
                    try {
                        int iC = aulVar.c();
                        if (iC < 0 || iC > 9) {
                            StringBuilder sb = new StringBuilder(42);
                            sb.append(iC);
                            sb.append(" is not a valid enum ReportType");
                            throw new IllegalArgumentException(sb.toString());
                            break;
                        } else {
                            this.f2307a = Integer.valueOf(iC);
                            break;
                        }
                    } catch (IllegalArgumentException unused) {
                        aulVar.e(iJ);
                        a(aulVar, iA);
                        break;
                    }
                    break;
                case 88:
                    int iJ2 = aulVar.j();
                    int iC2 = aulVar.c();
                    switch (iC2) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            this.k = aux.a.c.a(iC2);
                            break;
                        default:
                            aulVar.e(iJ2);
                            a(aulVar, iA);
                            break;
                    }
                case 98:
                    if (this.d == null) {
                        this.d = new avi();
                    }
                    aulVar.a(this.d);
                    break;
                case 106:
                    this.f = aulVar.e();
                    break;
                case 114:
                    if (this.g == null) {
                        this.g = new avm();
                    }
                    aulVar.a(this.g);
                    break;
                case 122:
                    this.r = aulVar.f();
                    break;
                case 138:
                    if (this.h == null) {
                        this.h = new avo();
                    }
                    aulVar.a(this.h);
                    break;
                case 162:
                    int iA4 = auw.a(aulVar, 162);
                    int length3 = this.i == null ? 0 : this.i.length;
                    String[] strArr2 = new String[iA4 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.i, 0, strArr2, 0, length3);
                    }
                    while (length3 < strArr2.length - 1) {
                        strArr2[length3] = aulVar.e();
                        aulVar.a();
                        length3++;
                    }
                    strArr2[length3] = aulVar.e();
                    this.i = strArr2;
                    break;
                case 170:
                    int iA5 = auw.a(aulVar, 170);
                    int length4 = this.j == null ? 0 : this.j.length;
                    String[] strArr3 = new String[iA5 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.j, 0, strArr3, 0, length4);
                    }
                    while (length4 < strArr3.length - 1) {
                        strArr3[length4] = aulVar.e();
                        aulVar.a();
                        length4++;
                    }
                    strArr3[length4] = aulVar.e();
                    this.j = strArr3;
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
