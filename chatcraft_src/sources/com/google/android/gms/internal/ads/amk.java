package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class amk extends aqy<amk, a> implements ash {
    private static volatile asq<amk> zzcas;
    private static final amk zzfgj = new amk();
    private int zzfgh;
    private int zzfgi;

    private amk() {
    }

    public static final class a extends aqy.a<amk, a> implements ash {
        private a() {
            super(amk.zzfgj);
        }

        /* synthetic */ a(aml amlVar) {
            this();
        }
    }

    public final ame a() {
        ame ameVarA = ame.a(this.zzfgh);
        return ameVarA == null ? ame.UNRECOGNIZED : ameVarA;
    }

    public final int b() {
        return this.zzfgi;
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        aml amlVar = null;
        switch (aml.f2072a[i - 1]) {
            case 1:
                return new amk();
            case 2:
                return new a(amlVar);
            case 3:
                return a(zzfgj, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzfgh", "zzfgi"});
            case 4:
                return zzfgj;
            case 5:
                asq<amk> bVar = zzcas;
                if (bVar == null) {
                    synchronized (amk.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfgj);
                            zzcas = bVar;
                        }
                    }
                }
                return bVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static amk c() {
        return zzfgj;
    }

    static {
        aqy.a((Class<amk>) amk.class, zzfgj);
    }
}
