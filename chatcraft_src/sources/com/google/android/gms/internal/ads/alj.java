package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class alj extends aqy<alj, a> implements ash {
    private static volatile asq<alj> zzcas;
    private static final alj zzfet = new alj();
    private int zzfek;

    private alj() {
    }

    public static final class a extends aqy.a<alj, a> implements ash {
        private a() {
            super(alj.zzfet);
        }

        /* synthetic */ a(alk alkVar) {
            this();
        }
    }

    public final int a() {
        return this.zzfek;
    }

    public static alj a(apo apoVar) {
        return (alj) aqy.a(zzfet, apoVar);
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        alk alkVar = null;
        switch (alk.f2052a[i - 1]) {
            case 1:
                return new alj();
            case 2:
                return new a(alkVar);
            case 3:
                return a(zzfet, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\u000b", new Object[]{"zzfek"});
            case 4:
                return zzfet;
            case 5:
                asq<alj> bVar = zzcas;
                if (bVar == null) {
                    synchronized (alj.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfet);
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

    static {
        aqy.a((Class<alj>) alj.class, zzfet);
    }
}
