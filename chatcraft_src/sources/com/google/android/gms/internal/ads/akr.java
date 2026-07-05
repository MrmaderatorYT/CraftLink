package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class akr extends aqy<akr, a> implements ash {
    private static volatile asq<akr> zzcas;
    private static final akr zzfed = new akr();
    private int zzfea;
    private akv zzfeb;
    private amg zzfec;

    private akr() {
    }

    public static final class a extends aqy.a<akr, a> implements ash {
        private a() {
            super(akr.zzfed);
        }

        public final a a(int i) {
            b();
            ((akr) this.f2190a).b(i);
            return this;
        }

        public final a a(akv akvVar) {
            b();
            ((akr) this.f2190a).a(akvVar);
            return this;
        }

        public final a a(amg amgVar) {
            b();
            ((akr) this.f2190a).a(amgVar);
            return this;
        }

        /* synthetic */ a(aks aksVar) {
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

    public final akv b() {
        return this.zzfeb == null ? akv.e() : this.zzfeb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(akv akvVar) {
        if (akvVar == null) {
            throw new NullPointerException();
        }
        this.zzfeb = akvVar;
    }

    public final amg c() {
        return this.zzfec == null ? amg.e() : this.zzfec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(amg amgVar) {
        if (amgVar == null) {
            throw new NullPointerException();
        }
        this.zzfec = amgVar;
    }

    public static akr a(apo apoVar) {
        return (akr) aqy.a(zzfed, apoVar);
    }

    public static a d() {
        return (a) ((aqy.a) zzfed.a(aqy.e.e, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        aks aksVar = null;
        switch (aks.f2042a[i - 1]) {
            case 1:
                return new akr();
            case 2:
                return new a(aksVar);
            case 3:
                return a(zzfed, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzfea", "zzfeb", "zzfec"});
            case 4:
                return zzfed;
            case 5:
                asq<akr> bVar = zzcas;
                if (bVar == null) {
                    synchronized (akr.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfed);
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
        aqy.a((Class<akr>) akr.class, zzfed);
    }
}
