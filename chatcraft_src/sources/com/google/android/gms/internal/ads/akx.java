package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class akx extends aqy<akx, a> implements ash {
    private static volatile asq<akx> zzcas;
    private static final akx zzfel = new akx();
    private akz zzfeh;
    private int zzfek;

    private akx() {
    }

    public static final class a extends aqy.a<akx, a> implements ash {
        private a() {
            super(akx.zzfel);
        }

        /* synthetic */ a(aky akyVar) {
            this();
        }
    }

    public final akz a() {
        return this.zzfeh == null ? akz.b() : this.zzfeh;
    }

    public final int b() {
        return this.zzfek;
    }

    public static akx a(apo apoVar) {
        return (akx) aqy.a(zzfel, apoVar);
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        aky akyVar = null;
        switch (aky.f2045a[i - 1]) {
            case 1:
                return new akx();
            case 2:
                return new a(akyVar);
            case 3:
                return a(zzfel, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzfeh", "zzfek"});
            case 4:
                return zzfel;
            case 5:
                asq<akx> bVar = zzcas;
                if (bVar == null) {
                    synchronized (akx.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfel);
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

    public static akx c() {
        return zzfel;
    }

    static {
        aqy.a((Class<akx>) akx.class, zzfel);
    }
}
