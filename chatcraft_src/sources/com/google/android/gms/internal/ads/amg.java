package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class amg extends aqy<amg, a> implements ash {
    private static volatile asq<amg> zzcas;
    private static final amg zzfgf = new amg();
    private int zzfea;
    private apo zzfei = apo.f2149a;
    private amk zzfge;

    private amg() {
    }

    public static final class a extends aqy.a<amg, a> implements ash {
        private a() {
            super(amg.zzfgf);
        }

        public final a a(int i) {
            b();
            ((amg) this.f2190a).b(0);
            return this;
        }

        public final a a(amk amkVar) {
            b();
            ((amg) this.f2190a).a(amkVar);
            return this;
        }

        public final a a(apo apoVar) {
            b();
            ((amg) this.f2190a).b(apoVar);
            return this;
        }

        /* synthetic */ a(amh amhVar) {
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

    public final amk b() {
        return this.zzfge == null ? amk.c() : this.zzfge;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(amk amkVar) {
        if (amkVar == null) {
            throw new NullPointerException();
        }
        this.zzfge = amkVar;
    }

    public final apo c() {
        return this.zzfei;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(apo apoVar) {
        if (apoVar == null) {
            throw new NullPointerException();
        }
        this.zzfei = apoVar;
    }

    public static amg a(apo apoVar) {
        return (amg) aqy.a(zzfgf, apoVar);
    }

    public static a d() {
        return (a) ((aqy.a) zzfgf.a(aqy.e.e, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        amh amhVar = null;
        switch (amh.f2070a[i - 1]) {
            case 1:
                return new amg();
            case 2:
                return new a(amhVar);
            case 3:
                return a(zzfgf, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzfea", "zzfge", "zzfei"});
            case 4:
                return zzfgf;
            case 5:
                asq<amg> bVar = zzcas;
                if (bVar == null) {
                    synchronized (amg.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfgf);
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

    public static amg e() {
        return zzfgf;
    }

    static {
        aqy.a((Class<amg>) amg.class, zzfgf);
    }
}
