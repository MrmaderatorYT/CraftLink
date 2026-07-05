package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public final class anc extends aqy<anc, a> implements ash {
    private static volatile asq<anc> zzcas;
    private static final anc zzfhv = new anc();
    private String zzfhu = BuildConfig.FLAVOR;

    private anc() {
    }

    public static final class a extends aqy.a<anc, a> implements ash {
        private a() {
            super(anc.zzfhv);
        }

        /* synthetic */ a(and andVar) {
            this();
        }
    }

    public final String a() {
        return this.zzfhu;
    }

    public static anc a(apo apoVar) {
        return (anc) aqy.a(zzfhv, apoVar);
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        and andVar = null;
        switch (and.f2085a[i - 1]) {
            case 1:
                return new anc();
            case 2:
                return new a(andVar);
            case 3:
                return a(zzfhv, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzfhu"});
            case 4:
                return zzfhv;
            case 5:
                asq<anc> bVar = zzcas;
                if (bVar == null) {
                    synchronized (anc.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfhv);
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

    public static anc b() {
        return zzfhv;
    }

    static {
        aqy.a((Class<anc>) anc.class, zzfhv);
    }
}
