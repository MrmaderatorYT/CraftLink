package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class ami extends aqy<ami, a> implements ash {
    private static volatile asq<ami> zzcas;
    private static final ami zzfgg = new ami();
    private int zzfek;
    private amk zzfge;

    private ami() {
    }

    public static final class a extends aqy.a<ami, a> implements ash {
        private a() {
            super(ami.zzfgg);
        }

        /* synthetic */ a(amj amjVar) {
            this();
        }
    }

    public final amk a() {
        return this.zzfge == null ? amk.c() : this.zzfge;
    }

    public final int b() {
        return this.zzfek;
    }

    public static ami a(apo apoVar) {
        return (ami) aqy.a(zzfgg, apoVar);
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        amj amjVar = null;
        switch (amj.f2071a[i - 1]) {
            case 1:
                return new ami();
            case 2:
                return new a(amjVar);
            case 3:
                return a(zzfgg, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzfge", "zzfek"});
            case 4:
                return zzfgg;
            case 5:
                asq<ami> bVar = zzcas;
                if (bVar == null) {
                    synchronized (ami.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfgg);
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

    public static ami c() {
        return zzfgg;
    }

    static {
        aqy.a((Class<ami>) ami.class, zzfgg);
    }
}
