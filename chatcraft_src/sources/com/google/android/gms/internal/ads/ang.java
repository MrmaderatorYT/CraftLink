package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public final class ang extends aqy<ang, a> implements ash {
    private static volatile asq<ang> zzcas;
    private static final ang zzfia = new ang();
    private String zzfhy = BuildConfig.FLAVOR;
    private ams zzfhz;

    private ang() {
    }

    public static final class a extends aqy.a<ang, a> implements ash {
        private a() {
            super(ang.zzfia);
        }

        /* synthetic */ a(anh anhVar) {
            this();
        }
    }

    public final String a() {
        return this.zzfhy;
    }

    public final ams b() {
        return this.zzfhz == null ? ams.c() : this.zzfhz;
    }

    public static ang a(apo apoVar) {
        return (ang) aqy.a(zzfia, apoVar);
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        anh anhVar = null;
        switch (anh.f2087a[i - 1]) {
            case 1:
                return new ang();
            case 2:
                return new a(anhVar);
            case 3:
                return a(zzfia, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzfhy", "zzfhz"});
            case 4:
                return zzfia;
            case 5:
                asq<ang> bVar = zzcas;
                if (bVar == null) {
                    synchronized (ang.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfia);
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

    public static ang c() {
        return zzfia;
    }

    static {
        aqy.a((Class<ang>) ang.class, zzfia);
    }
}
