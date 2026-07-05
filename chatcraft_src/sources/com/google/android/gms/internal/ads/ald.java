package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class ald extends aqy<ald, a> implements ash {
    private static volatile asq<ald> zzcas;
    private static final ald zzfeq = new ald();
    private int zzfek;
    private alf zzfeo;

    private ald() {
    }

    public static final class a extends aqy.a<ald, a> implements ash {
        private a() {
            super(ald.zzfeq);
        }

        /* synthetic */ a(ale aleVar) {
            this();
        }
    }

    public final alf a() {
        return this.zzfeo == null ? alf.b() : this.zzfeo;
    }

    public final int b() {
        return this.zzfek;
    }

    public static ald a(apo apoVar) {
        return (ald) aqy.a(zzfeq, apoVar);
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        ale aleVar = null;
        switch (ale.f2049a[i - 1]) {
            case 1:
                return new ald();
            case 2:
                return new a(aleVar);
            case 3:
                return a(zzfeq, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzfeo", "zzfek"});
            case 4:
                return zzfeq;
            case 5:
                asq<ald> bVar = zzcas;
                if (bVar == null) {
                    synchronized (ald.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfeq);
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
        aqy.a((Class<ald>) ald.class, zzfeq);
    }
}
