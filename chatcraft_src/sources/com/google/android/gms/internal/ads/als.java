package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class als extends aqy<als, a> implements ash {
    private static volatile asq<als> zzcas;
    private static final als zzffe = new als();
    private alu zzffd;

    private als() {
    }

    public static final class a extends aqy.a<als, a> implements ash {
        private a() {
            super(als.zzffe);
        }

        /* synthetic */ a(alt altVar) {
            this();
        }
    }

    public final alu a() {
        return this.zzffd == null ? alu.d() : this.zzffd;
    }

    public static als a(apo apoVar) {
        return (als) aqy.a(zzffe, apoVar);
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        alt altVar = null;
        switch (alt.f2059a[i - 1]) {
            case 1:
                return new als();
            case 2:
                return new a(altVar);
            case 3:
                return a(zzffe, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzffd"});
            case 4:
                return zzffe;
            case 5:
                asq<als> bVar = zzcas;
                if (bVar == null) {
                    synchronized (als.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzffe);
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
        aqy.a((Class<als>) als.class, zzffe);
    }
}
