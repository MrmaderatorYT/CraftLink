package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public final class ams extends aqy<ams, a> implements ash {
    private static volatile asq<ams> zzcas;
    private static final ams zzfhc = new ams();
    private String zzfgk = BuildConfig.FLAVOR;
    private apo zzfgl = apo.f2149a;
    private int zzfhb;

    private ams() {
    }

    public static final class a extends aqy.a<ams, a> implements ash {
        private a() {
            super(ams.zzfhc);
        }

        /* synthetic */ a(amt amtVar) {
            this();
        }
    }

    public final String a() {
        return this.zzfgk;
    }

    public final apo b() {
        return this.zzfgl;
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        amt amtVar = null;
        switch (amt.f2080a[i - 1]) {
            case 1:
                return new ams();
            case 2:
                return new a(amtVar);
            case 3:
                return a(zzfhc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzfgk", "zzfgl", "zzfhb"});
            case 4:
                return zzfhc;
            case 5:
                asq<ams> bVar = zzcas;
                if (bVar == null) {
                    synchronized (ams.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfhc);
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

    public static ams c() {
        return zzfhc;
    }

    static {
        aqy.a((Class<ams>) ams.class, zzfhc);
    }
}
