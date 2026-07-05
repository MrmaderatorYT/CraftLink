package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class avn extends aun<avn> {
    private static volatile avn[] f;

    /* renamed from: a, reason: collision with root package name */
    public Integer f2318a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f2319b = null;
    public avk c = null;
    private avl g = null;
    private Integer h = null;
    private int[] i = auw.f2291a;
    private String j = null;
    public Integer d = null;
    public String[] e = auw.c;

    public static avn[] b() {
        if (f == null) {
            synchronized (aur.f2286b) {
                if (f == null) {
                    f = new avn[0];
                }
            }
        }
        return f;
    }

    public avn() {
        this.Z = null;
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        aumVar.a(1, this.f2318a.intValue());
        if (this.f2319b != null) {
            aumVar.a(2, this.f2319b);
        }
        if (this.c != null) {
            aumVar.a(3, this.c);
        }
        if (this.g != null) {
            aumVar.a(4, this.g);
        }
        if (this.h != null) {
            aumVar.a(5, this.h.intValue());
        }
        if (this.i != null && this.i.length > 0) {
            for (int i = 0; i < this.i.length; i++) {
                aumVar.a(6, this.i[i]);
            }
        }
        if (this.j != null) {
            aumVar.a(7, this.j);
        }
        if (this.d != null) {
            aumVar.a(8, this.d.intValue());
        }
        if (this.e != null && this.e.length > 0) {
            for (int i2 = 0; i2 < this.e.length; i2++) {
                String str = this.e[i2];
                if (str != null) {
                    aumVar.a(9, str);
                }
            }
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a() + aum.b(1, this.f2318a.intValue());
        if (this.f2319b != null) {
            iA += aum.b(2, this.f2319b);
        }
        if (this.c != null) {
            iA += aum.b(3, this.c);
        }
        if (this.g != null) {
            iA += aum.b(4, this.g);
        }
        if (this.h != null) {
            iA += aum.b(5, this.h.intValue());
        }
        if (this.i != null && this.i.length > 0) {
            int iA2 = 0;
            for (int i = 0; i < this.i.length; i++) {
                iA2 += aum.a(this.i[i]);
            }
            iA = iA + iA2 + (this.i.length * 1);
        }
        if (this.j != null) {
            iA += aum.b(7, this.j);
        }
        if (this.d != null) {
            iA += aum.b(8, this.d.intValue());
        }
        if (this.e == null || this.e.length <= 0) {
            return iA;
        }
        int iA3 = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.e.length; i3++) {
            String str = this.e[i3];
            if (str != null) {
                i2++;
                iA3 += aum.a(str);
            }
        }
        return iA + iA3 + (i2 * 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.aus
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final avn a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            switch (iA) {
                case 0:
                    return this;
                case 8:
                    this.f2318a = Integer.valueOf(aulVar.c());
                    break;
                case 18:
                    this.f2319b = aulVar.e();
                    break;
                case 26:
                    if (this.c == null) {
                        this.c = new avk();
                    }
                    aulVar.a(this.c);
                    break;
                case 34:
                    if (this.g == null) {
                        this.g = new avl();
                    }
                    aulVar.a(this.g);
                    break;
                case 40:
                    this.h = Integer.valueOf(aulVar.c());
                    break;
                case 48:
                    int iA2 = auw.a(aulVar, 48);
                    int length = this.i == null ? 0 : this.i.length;
                    int[] iArr = new int[iA2 + length];
                    if (length != 0) {
                        System.arraycopy(this.i, 0, iArr, 0, length);
                    }
                    while (length < iArr.length - 1) {
                        iArr[length] = aulVar.c();
                        aulVar.a();
                        length++;
                    }
                    iArr[length] = aulVar.c();
                    this.i = iArr;
                    break;
                case 50:
                    int iC = aulVar.c(aulVar.g());
                    int iJ = aulVar.j();
                    int i = 0;
                    while (aulVar.i() > 0) {
                        aulVar.c();
                        i++;
                    }
                    aulVar.e(iJ);
                    int length2 = this.i == null ? 0 : this.i.length;
                    int[] iArr2 = new int[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.i, 0, iArr2, 0, length2);
                    }
                    while (length2 < iArr2.length) {
                        iArr2[length2] = aulVar.c();
                        length2++;
                    }
                    this.i = iArr2;
                    aulVar.d(iC);
                    break;
                case 58:
                    this.j = aulVar.e();
                    break;
                case 64:
                    int iJ2 = aulVar.j();
                    try {
                        int iC2 = aulVar.c();
                        if (iC2 < 0 || iC2 > 3) {
                            StringBuilder sb = new StringBuilder(46);
                            sb.append(iC2);
                            sb.append(" is not a valid enum AdResourceType");
                            throw new IllegalArgumentException(sb.toString());
                            break;
                        } else {
                            this.d = Integer.valueOf(iC2);
                            break;
                        }
                    } catch (IllegalArgumentException unused) {
                        aulVar.e(iJ2);
                        a(aulVar, iA);
                        break;
                    }
                    break;
                case 74:
                    int iA3 = auw.a(aulVar, 74);
                    int length3 = this.e == null ? 0 : this.e.length;
                    String[] strArr = new String[iA3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.e, 0, strArr, 0, length3);
                    }
                    while (length3 < strArr.length - 1) {
                        strArr[length3] = aulVar.e();
                        aulVar.a();
                        length3++;
                    }
                    strArr[length3] = aulVar.e();
                    this.e = strArr;
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
