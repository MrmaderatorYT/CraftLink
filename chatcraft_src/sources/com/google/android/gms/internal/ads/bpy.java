package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.bpc;

/* loaded from: classes.dex */
public final class bpy extends aun<bpy> {

    /* renamed from: a, reason: collision with root package name */
    private static volatile bpy[] f2958a;

    /* renamed from: b, reason: collision with root package name */
    private bpc.r f2959b = null;
    private bpc.t c = null;
    private bpc.u d = null;
    private bpc.v e = null;
    private bpc.p f = null;
    private bpc.s g = null;
    private bpz h = null;
    private Integer i = null;
    private Integer j = null;
    private bpc.n k = null;
    private Integer l = null;
    private Integer m = null;
    private Integer n = null;
    private Integer o = null;
    private Integer p = null;
    private Long q = null;

    public static bpy[] b() {
        if (f2958a == null) {
            synchronized (aur.f2286b) {
                if (f2958a == null) {
                    f2958a = new bpy[0];
                }
            }
        }
        return f2958a;
    }

    public bpy() {
        this.Z = null;
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2959b != null) {
            aumVar.a(5, this.f2959b);
        }
        if (this.c != null) {
            aumVar.a(6, this.c);
        }
        if (this.d != null) {
            aumVar.a(7, this.d);
        }
        if (this.e != null) {
            aumVar.a(8, this.e);
        }
        if (this.f != null) {
            aumVar.a(9, this.f);
        }
        if (this.g != null) {
            aumVar.a(10, this.g);
        }
        if (this.h != null) {
            aumVar.a(11, this.h);
        }
        if (this.i != null) {
            aumVar.a(12, this.i.intValue());
        }
        if (this.j != null) {
            aumVar.a(13, this.j.intValue());
        }
        if (this.k != null) {
            aumVar.a(14, this.k);
        }
        if (this.l != null) {
            aumVar.a(15, this.l.intValue());
        }
        if (this.m != null) {
            aumVar.a(16, this.m.intValue());
        }
        if (this.n != null) {
            aumVar.a(17, this.n.intValue());
        }
        if (this.o != null) {
            aumVar.a(18, this.o.intValue());
        }
        if (this.p != null) {
            aumVar.a(19, this.p.intValue());
        }
        if (this.q != null) {
            aumVar.a(20, this.q.longValue());
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f2959b != null) {
            iA += zzbqk.c(5, this.f2959b);
        }
        if (this.c != null) {
            iA += zzbqk.c(6, this.c);
        }
        if (this.d != null) {
            iA += zzbqk.c(7, this.d);
        }
        if (this.e != null) {
            iA += zzbqk.c(8, this.e);
        }
        if (this.f != null) {
            iA += zzbqk.c(9, this.f);
        }
        if (this.g != null) {
            iA += zzbqk.c(10, this.g);
        }
        if (this.h != null) {
            iA += aum.b(11, this.h);
        }
        if (this.i != null) {
            iA += aum.b(12, this.i.intValue());
        }
        if (this.j != null) {
            iA += aum.b(13, this.j.intValue());
        }
        if (this.k != null) {
            iA += zzbqk.c(14, this.k);
        }
        if (this.l != null) {
            iA += aum.b(15, this.l.intValue());
        }
        if (this.m != null) {
            iA += aum.b(16, this.m.intValue());
        }
        if (this.n != null) {
            iA += aum.b(17, this.n.intValue());
        }
        if (this.o != null) {
            iA += aum.b(18, this.o.intValue());
        }
        if (this.p != null) {
            iA += aum.b(19, this.p.intValue());
        }
        return this.q != null ? iA + aum.c(20, this.q.longValue()) : iA;
    }

    @Override // com.google.android.gms.internal.ads.aus
    public final /* synthetic */ aus a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            switch (iA) {
                case 0:
                    return this;
                case 42:
                    this.f2959b = (bpc.r) aulVar.a(bpc.r.a());
                    break;
                case 50:
                    this.c = (bpc.t) aulVar.a(bpc.t.a());
                    break;
                case 58:
                    this.d = (bpc.u) aulVar.a(bpc.u.a());
                    break;
                case 66:
                    this.e = (bpc.v) aulVar.a(bpc.v.a());
                    break;
                case 74:
                    this.f = (bpc.p) aulVar.a(bpc.p.a());
                    break;
                case 82:
                    this.g = (bpc.s) aulVar.a(bpc.s.a());
                    break;
                case 90:
                    if (this.h == null) {
                        this.h = new bpz();
                    }
                    aulVar.a(this.h);
                    break;
                case 96:
                    this.i = Integer.valueOf(aulVar.g());
                    break;
                case 104:
                    this.j = Integer.valueOf(aulVar.g());
                    break;
                case 114:
                    this.k = (bpc.n) aulVar.a(bpc.n.a());
                    break;
                case 120:
                    this.l = Integer.valueOf(aulVar.g());
                    break;
                case 128:
                    this.m = Integer.valueOf(aulVar.g());
                    break;
                case 136:
                    this.n = Integer.valueOf(aulVar.g());
                    break;
                case 144:
                    this.o = Integer.valueOf(aulVar.g());
                    break;
                case 152:
                    this.p = Integer.valueOf(aulVar.g());
                    break;
                case 160:
                    this.q = Long.valueOf(aulVar.h());
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
