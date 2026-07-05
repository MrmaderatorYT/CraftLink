package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class alf extends aqy<alf, a> implements ash {
    private static volatile asq<alf> zzcas;
    private static final alf zzfer = new alf();
    private int zzfem;

    private alf() {
    }

    public static final class a extends aqy.a<alf, a> implements ash {
        private a() {
            super(alf.zzfer);
        }

        /* synthetic */ a(alg algVar) {
            this();
        }
    }

    public final int a() {
        return this.zzfem;
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        alg algVar = null;
        switch (alg.f2050a[i - 1]) {
            case 1:
                return new alf();
            case 2:
                return new a(algVar);
            case 3:
                return a(zzfer, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzfem"});
            case 4:
                return zzfer;
            case 5:
                asq<alf> bVar = zzcas;
                if (bVar == null) {
                    synchronized (alf.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfer);
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

    public static alf b() {
        return zzfer;
    }

    static {
        aqy.a((Class<alf>) alf.class, zzfer);
    }
}
