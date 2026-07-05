package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.bpc;

/* loaded from: classes.dex */
public final class bps extends aun<bps> {

    /* renamed from: a, reason: collision with root package name */
    public Integer f2946a = null;
    private bpj c = null;
    private bpc.b d = null;

    /* renamed from: b, reason: collision with root package name */
    public bpt f2947b = null;
    private bpc.a[] e = new bpc.a[0];
    private bpc.c f = null;
    private bpc.j g = null;
    private bpc.i h = null;
    private bpc.f i = null;
    private bpc.g j = null;
    private bpy[] k = bpy.b();

    public bps() {
        this.Z = null;
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2946a != null) {
            aumVar.a(7, this.f2946a.intValue());
        }
        if (this.c != null && this.c != null) {
            aumVar.a(8, this.c.a());
        }
        if (this.d != null) {
            aumVar.a(9, this.d);
        }
        if (this.f2947b != null) {
            aumVar.a(10, this.f2947b);
        }
        if (this.e != null && this.e.length > 0) {
            for (int i = 0; i < this.e.length; i++) {
                bpc.a aVar = this.e[i];
                if (aVar != null) {
                    aumVar.a(11, aVar);
                }
            }
        }
        if (this.f != null) {
            aumVar.a(12, this.f);
        }
        if (this.g != null) {
            aumVar.a(13, this.g);
        }
        if (this.h != null) {
            aumVar.a(14, this.h);
        }
        if (this.i != null) {
            aumVar.a(15, this.i);
        }
        if (this.j != null) {
            aumVar.a(16, this.j);
        }
        if (this.k != null && this.k.length > 0) {
            for (int i2 = 0; i2 < this.k.length; i2++) {
                bpy bpyVar = this.k[i2];
                if (bpyVar != null) {
                    aumVar.a(17, bpyVar);
                }
            }
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f2946a != null) {
            iA += aum.b(7, this.f2946a.intValue());
        }
        if (this.c != null && this.c != null) {
            iA += aum.b(8, this.c.a());
        }
        if (this.d != null) {
            iA += zzbqk.c(9, this.d);
        }
        if (this.f2947b != null) {
            iA += aum.b(10, this.f2947b);
        }
        if (this.e != null && this.e.length > 0) {
            int iC = iA;
            for (int i = 0; i < this.e.length; i++) {
                bpc.a aVar = this.e[i];
                if (aVar != null) {
                    iC += zzbqk.c(11, aVar);
                }
            }
            iA = iC;
        }
        if (this.f != null) {
            iA += zzbqk.c(12, this.f);
        }
        if (this.g != null) {
            iA += zzbqk.c(13, this.g);
        }
        if (this.h != null) {
            iA += zzbqk.c(14, this.h);
        }
        if (this.i != null) {
            iA += zzbqk.c(15, this.i);
        }
        if (this.j != null) {
            iA += zzbqk.c(16, this.j);
        }
        if (this.k != null && this.k.length > 0) {
            for (int i2 = 0; i2 < this.k.length; i2++) {
                bpy bpyVar = this.k[i2];
                if (bpyVar != null) {
                    iA += aum.b(17, bpyVar);
                }
            }
        }
        return iA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.aus
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final bps a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            switch (iA) {
                case 0:
                    return this;
                case 56:
                    int iJ = aulVar.j();
                    try {
                        int iG = aulVar.g();
                        if (iG < 0 || iG > 9) {
                            StringBuilder sb = new StringBuilder(43);
                            sb.append(iG);
                            sb.append(" is not a valid enum AdInitiater");
                            throw new IllegalArgumentException(sb.toString());
                            break;
                        } else {
                            this.f2946a = Integer.valueOf(iG);
                            break;
                        }
                    } catch (IllegalArgumentException unused) {
                        aulVar.e(iJ);
                        a(aulVar, iA);
                        break;
                    }
                    break;
                case 64:
                    int iJ2 = aulVar.j();
                    int iG2 = aulVar.g();
                    if (iG2 != 1000) {
                        switch (iG2) {
                            case 0:
                            case 1:
                                break;
                            default:
                                aulVar.e(iJ2);
                                a(aulVar, iA);
                                continue;
                        }
                    }
                    this.c = bpj.a(iG2);
                    break;
                case 74:
                    this.d = (bpc.b) aulVar.a(bpc.b.a());
                    break;
                case 82:
                    if (this.f2947b == null) {
                        this.f2947b = new bpt();
                    }
                    aulVar.a(this.f2947b);
                    break;
                case 90:
                    int iA2 = auw.a(aulVar, 90);
                    int length = this.e == null ? 0 : this.e.length;
                    bpc.a[] aVarArr = new bpc.a[iA2 + length];
                    if (length != 0) {
                        System.arraycopy(this.e, 0, aVarArr, 0, length);
                    }
                    while (length < aVarArr.length - 1) {
                        aVarArr[length] = (bpc.a) aulVar.a(bpc.a.a());
                        aulVar.a();
                        length++;
                    }
                    aVarArr[length] = (bpc.a) aulVar.a(bpc.a.a());
                    this.e = aVarArr;
                    break;
                case 98:
                    this.f = (bpc.c) aulVar.a(bpc.c.a());
                    break;
                case 106:
                    this.g = (bpc.j) aulVar.a(bpc.j.a());
                    break;
                case 114:
                    this.h = (bpc.i) aulVar.a(bpc.i.a());
                    break;
                case 122:
                    this.i = (bpc.f) aulVar.a(bpc.f.a());
                    break;
                case 130:
                    this.j = (bpc.g) aulVar.a(bpc.g.a());
                    break;
                case 138:
                    int iA3 = auw.a(aulVar, 138);
                    int length2 = this.k == null ? 0 : this.k.length;
                    bpy[] bpyVarArr = new bpy[iA3 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.k, 0, bpyVarArr, 0, length2);
                    }
                    while (length2 < bpyVarArr.length - 1) {
                        bpyVarArr[length2] = new bpy();
                        aulVar.a(bpyVarArr[length2]);
                        aulVar.a();
                        length2++;
                    }
                    bpyVarArr[length2] = new bpy();
                    aulVar.a(bpyVarArr[length2]);
                    this.k = bpyVarArr;
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
