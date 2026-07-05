package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class alh extends aqy<alh, a> implements ash {
    private static volatile asq<alh> zzcas;
    private static final alh zzfes = new alh();
    private int zzfea;
    private apo zzfei = apo.f2149a;

    private alh() {
    }

    public static final class a extends aqy.a<alh, a> implements ash {
        private a() {
            super(alh.zzfes);
        }

        public final a a(int i) {
            b();
            ((alh) this.f2190a).b(0);
            return this;
        }

        public final a a(apo apoVar) {
            b();
            ((alh) this.f2190a).b(apoVar);
            return this;
        }

        /* synthetic */ a(ali aliVar) {
            this();
        }
    }

    public final int a() {
        return this.zzfea;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        this.zzfea = i;
    }

    public final apo b() {
        return this.zzfei;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(apo apoVar) {
        if (apoVar == null) {
            throw new NullPointerException();
        }
        this.zzfei = apoVar;
    }

    public static alh a(apo apoVar) {
        return (alh) aqy.a(zzfes, apoVar);
    }

    public static a c() {
        return (a) ((aqy.a) zzfes.a(aqy.e.e, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        ali aliVar = null;
        switch (ali.f2051a[i - 1]) {
            case 1:
                return new alh();
            case 2:
                return new a(aliVar);
            case 3:
                return a(zzfes, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzfea", "zzfei"});
            case 4:
                return zzfes;
            case 5:
                asq<alh> bVar = zzcas;
                if (bVar == null) {
                    synchronized (alh.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfes);
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
        aqy.a((Class<alh>) alh.class, zzfes);
    }
}
