package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class alw extends aqy<alw, a> implements ash {
    private static volatile asq<alw> zzcas;
    private static final alw zzffk = new alw();
    private int zzfea;
    private apo zzfei = apo.f2149a;
    private aly zzffj;

    private alw() {
    }

    public static final class a extends aqy.a<alw, a> implements ash {
        private a() {
            super(alw.zzffk);
        }

        public final a a(int i) {
            b();
            ((alw) this.f2190a).b(0);
            return this;
        }

        public final a a(aly alyVar) {
            b();
            ((alw) this.f2190a).a(alyVar);
            return this;
        }

        public final a a(apo apoVar) {
            b();
            ((alw) this.f2190a).b(apoVar);
            return this;
        }

        /* synthetic */ a(alx alxVar) {
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

    public final aly b() {
        return this.zzffj == null ? aly.f() : this.zzffj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(aly alyVar) {
        if (alyVar == null) {
            throw new NullPointerException();
        }
        this.zzffj = alyVar;
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

    public static alw a(apo apoVar) {
        return (alw) aqy.a(zzffk, apoVar);
    }

    public static a d() {
        return (a) ((aqy.a) zzffk.a(aqy.e.e, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        alx alxVar = null;
        switch (alx.f2061a[i - 1]) {
            case 1:
                return new alw();
            case 2:
                return new a(alxVar);
            case 3:
                return a(zzffk, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzfea", "zzffj", "zzfei"});
            case 4:
                return zzffk;
            case 5:
                asq<alw> bVar = zzcas;
                if (bVar == null) {
                    synchronized (alw.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzffk);
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
        aqy.a((Class<alw>) alw.class, zzffk);
    }
}
