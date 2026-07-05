package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class all extends aqy<all, a> implements ash {
    private static volatile asq<all> zzcas;
    private static final all zzfeu = new all();
    private int zzfea;
    private apo zzfei = apo.f2149a;

    private all() {
    }

    public static final class a extends aqy.a<all, a> implements ash {
        private a() {
            super(all.zzfeu);
        }

        public final a a(int i) {
            b();
            ((all) this.f2190a).b(0);
            return this;
        }

        public final a a(apo apoVar) {
            b();
            ((all) this.f2190a).b(apoVar);
            return this;
        }

        /* synthetic */ a(alm almVar) {
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

    public static all a(apo apoVar) {
        return (all) aqy.a(zzfeu, apoVar);
    }

    public static a c() {
        return (a) ((aqy.a) zzfeu.a(aqy.e.e, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        alm almVar = null;
        switch (alm.f2053a[i - 1]) {
            case 1:
                return new all();
            case 2:
                return new a(almVar);
            case 3:
                return a(zzfeu, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzfea", "zzfei"});
            case 4:
                return zzfeu;
            case 5:
                asq<all> bVar = zzcas;
                if (bVar == null) {
                    synchronized (all.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfeu);
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
        aqy.a((Class<all>) all.class, zzfeu);
    }
}
