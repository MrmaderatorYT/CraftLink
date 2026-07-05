package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class alp extends aqy<alp, a> implements ash {
    private static volatile asq<alp> zzcas;
    private static final alp zzffc = new alp();
    private ams zzffb;

    private alp() {
    }

    public static final class a extends aqy.a<alp, a> implements ash {
        private a() {
            super(alp.zzffc);
        }

        /* synthetic */ a(alr alrVar) {
            this();
        }
    }

    public final ams a() {
        return this.zzffb == null ? ams.c() : this.zzffb;
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        alr alrVar = null;
        switch (alr.f2058a[i - 1]) {
            case 1:
                return new alp();
            case 2:
                return new a(alrVar);
            case 3:
                return a(zzffc, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzffb"});
            case 4:
                return zzffc;
            case 5:
                asq<alp> bVar = zzcas;
                if (bVar == null) {
                    synchronized (alp.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzffc);
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

    public static alp b() {
        return zzffc;
    }

    static {
        aqy.a((Class<alp>) alp.class, zzffc);
    }
}
