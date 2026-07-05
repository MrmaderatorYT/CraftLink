package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class alq extends aun<alq> {
    private static volatile alq[] t;
    public Integer g;
    public Integer k;

    /* renamed from: a, reason: collision with root package name */
    public Long f2056a = null;

    /* renamed from: b, reason: collision with root package name */
    public Long f2057b = null;
    public Long c = null;
    public Long d = null;
    public Long e = null;
    public Long f = null;
    public Long h = null;
    public Long i = null;
    public Long j = null;
    public Long l = null;
    public Long m = null;
    public Long n = null;
    public Long o = null;
    public Long p = null;
    public Long q = null;
    public Long r = null;
    public Long s = null;
    private Long u = null;
    private Long v = null;

    public static alq[] b() {
        if (t == null) {
            synchronized (aur.f2286b) {
                if (t == null) {
                    t = new alq[0];
                }
            }
        }
        return t;
    }

    public alq() {
        this.aa = -1;
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    public final void a(aum aumVar) throws zzbus {
        if (this.f2056a != null) {
            aumVar.b(1, this.f2056a.longValue());
        }
        if (this.f2057b != null) {
            aumVar.b(2, this.f2057b.longValue());
        }
        if (this.c != null) {
            aumVar.b(3, this.c.longValue());
        }
        if (this.d != null) {
            aumVar.b(4, this.d.longValue());
        }
        if (this.e != null) {
            aumVar.b(5, this.e.longValue());
        }
        if (this.f != null) {
            aumVar.b(6, this.f.longValue());
        }
        if (this.g != null) {
            aumVar.a(7, this.g.intValue());
        }
        if (this.h != null) {
            aumVar.b(8, this.h.longValue());
        }
        if (this.i != null) {
            aumVar.b(9, this.i.longValue());
        }
        if (this.j != null) {
            aumVar.b(10, this.j.longValue());
        }
        if (this.k != null) {
            aumVar.a(11, this.k.intValue());
        }
        if (this.l != null) {
            aumVar.b(12, this.l.longValue());
        }
        if (this.m != null) {
            aumVar.b(13, this.m.longValue());
        }
        if (this.n != null) {
            aumVar.b(14, this.n.longValue());
        }
        if (this.o != null) {
            aumVar.b(15, this.o.longValue());
        }
        if (this.p != null) {
            aumVar.b(16, this.p.longValue());
        }
        if (this.q != null) {
            aumVar.b(17, this.q.longValue());
        }
        if (this.r != null) {
            aumVar.b(18, this.r.longValue());
        }
        if (this.s != null) {
            aumVar.b(19, this.s.longValue());
        }
        if (this.u != null) {
            aumVar.b(20, this.u.longValue());
        }
        if (this.v != null) {
            aumVar.b(21, this.v.longValue());
        }
        super.a(aumVar);
    }

    @Override // com.google.android.gms.internal.ads.aun, com.google.android.gms.internal.ads.aus
    protected final int a() {
        int iA = super.a();
        if (this.f2056a != null) {
            iA += aum.d(1, this.f2056a.longValue());
        }
        if (this.f2057b != null) {
            iA += aum.d(2, this.f2057b.longValue());
        }
        if (this.c != null) {
            iA += aum.d(3, this.c.longValue());
        }
        if (this.d != null) {
            iA += aum.d(4, this.d.longValue());
        }
        if (this.e != null) {
            iA += aum.d(5, this.e.longValue());
        }
        if (this.f != null) {
            iA += aum.d(6, this.f.longValue());
        }
        if (this.g != null) {
            iA += aum.b(7, this.g.intValue());
        }
        if (this.h != null) {
            iA += aum.d(8, this.h.longValue());
        }
        if (this.i != null) {
            iA += aum.d(9, this.i.longValue());
        }
        if (this.j != null) {
            iA += aum.d(10, this.j.longValue());
        }
        if (this.k != null) {
            iA += aum.b(11, this.k.intValue());
        }
        if (this.l != null) {
            iA += aum.d(12, this.l.longValue());
        }
        if (this.m != null) {
            iA += aum.d(13, this.m.longValue());
        }
        if (this.n != null) {
            iA += aum.d(14, this.n.longValue());
        }
        if (this.o != null) {
            iA += aum.d(15, this.o.longValue());
        }
        if (this.p != null) {
            iA += aum.d(16, this.p.longValue());
        }
        if (this.q != null) {
            iA += aum.d(17, this.q.longValue());
        }
        if (this.r != null) {
            iA += aum.d(18, this.r.longValue());
        }
        if (this.s != null) {
            iA += aum.d(19, this.s.longValue());
        }
        if (this.u != null) {
            iA += aum.d(20, this.u.longValue());
        }
        return this.v != null ? iA + aum.d(21, this.v.longValue()) : iA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.aus
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final alq a(aul aulVar) throws zzbuy {
        while (true) {
            int iA = aulVar.a();
            switch (iA) {
                case 0:
                    return this;
                case 8:
                    this.f2056a = Long.valueOf(aulVar.h());
                    break;
                case 16:
                    this.f2057b = Long.valueOf(aulVar.h());
                    break;
                case 24:
                    this.c = Long.valueOf(aulVar.h());
                    break;
                case 32:
                    this.d = Long.valueOf(aulVar.h());
                    break;
                case 40:
                    this.e = Long.valueOf(aulVar.h());
                    break;
                case 48:
                    this.f = Long.valueOf(aulVar.h());
                    break;
                case 56:
                    int iJ = aulVar.j();
                    try {
                        this.g = Integer.valueOf(ajo.a(aulVar.g()));
                        break;
                    } catch (IllegalArgumentException unused) {
                        aulVar.e(iJ);
                        a(aulVar, iA);
                        break;
                    }
                case 64:
                    this.h = Long.valueOf(aulVar.h());
                    break;
                case 72:
                    this.i = Long.valueOf(aulVar.h());
                    break;
                case 80:
                    this.j = Long.valueOf(aulVar.h());
                    break;
                case 88:
                    int iJ2 = aulVar.j();
                    try {
                        this.k = Integer.valueOf(ajo.a(aulVar.g()));
                        break;
                    } catch (IllegalArgumentException unused2) {
                        aulVar.e(iJ2);
                        a(aulVar, iA);
                        break;
                    }
                case 96:
                    this.l = Long.valueOf(aulVar.h());
                    break;
                case 104:
                    this.m = Long.valueOf(aulVar.h());
                    break;
                case 112:
                    this.n = Long.valueOf(aulVar.h());
                    break;
                case 120:
                    this.o = Long.valueOf(aulVar.h());
                    break;
                case 128:
                    this.p = Long.valueOf(aulVar.h());
                    break;
                case 136:
                    this.q = Long.valueOf(aulVar.h());
                    break;
                case 144:
                    this.r = Long.valueOf(aulVar.h());
                    break;
                case 152:
                    this.s = Long.valueOf(aulVar.h());
                    break;
                case 160:
                    this.u = Long.valueOf(aulVar.h());
                    break;
                case 168:
                    this.v = Long.valueOf(aulVar.h());
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
