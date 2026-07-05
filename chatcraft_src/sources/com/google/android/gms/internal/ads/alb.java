package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class alb extends aqy<alb, a> implements ash {
    private static volatile asq<alb> zzcas;
    private static final alb zzfep = new alb();
    private int zzfea;
    private apo zzfei = apo.f2149a;
    private alf zzfeo;

    private alb() {
    }

    public static final class a extends aqy.a<alb, a> implements ash {
        private a() {
            super(alb.zzfep);
        }

        public final a a(int i) {
            b();
            ((alb) this.f2190a).b(0);
            return this;
        }

        public final a a(alf alfVar) {
            b();
            ((alb) this.f2190a).a(alfVar);
            return this;
        }

        public final a a(apo apoVar) {
            b();
            ((alb) this.f2190a).b(apoVar);
            return this;
        }

        /* synthetic */ a(alc alcVar) {
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

    public final alf b() {
        return this.zzfeo == null ? alf.b() : this.zzfeo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(alf alfVar) {
        if (alfVar == null) {
            throw new NullPointerException();
        }
        this.zzfeo = alfVar;
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

    public static alb a(apo apoVar) {
        return (alb) aqy.a(zzfep, apoVar);
    }

    public static a d() {
        return (a) ((aqy.a) zzfep.a(aqy.e.e, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        alc alcVar = null;
        switch (alc.f2048a[i - 1]) {
            case 1:
                return new alb();
            case 2:
                return new a(alcVar);
            case 3:
                return a(zzfep, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzfea", "zzfeo", "zzfei"});
            case 4:
                return zzfep;
            case 5:
                asq<alb> bVar = zzcas;
                if (bVar == null) {
                    synchronized (alb.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfep);
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
        aqy.a((Class<alb>) alb.class, zzfep);
    }
}
