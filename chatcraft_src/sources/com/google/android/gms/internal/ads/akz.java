package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class akz extends aqy<akz, a> implements ash {
    private static volatile asq<akz> zzcas;
    private static final akz zzfen = new akz();
    private int zzfem;

    private akz() {
    }

    public static final class a extends aqy.a<akz, a> implements ash {
        private a() {
            super(akz.zzfen);
        }

        /* synthetic */ a(ala alaVar) {
            this();
        }
    }

    public final int a() {
        return this.zzfem;
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        ala alaVar = null;
        switch (ala.f2047a[i - 1]) {
            case 1:
                return new akz();
            case 2:
                return new a(alaVar);
            case 3:
                return a(zzfen, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzfem"});
            case 4:
                return zzfen;
            case 5:
                asq<akz> bVar = zzcas;
                if (bVar == null) {
                    synchronized (akz.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfen);
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

    public static akz b() {
        return zzfen;
    }

    static {
        aqy.a((Class<akz>) akz.class, zzfen);
    }
}
