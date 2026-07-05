package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class akv extends aqy<akv, a> implements ash {
    private static volatile asq<akv> zzcas;
    private static final akv zzfej = new akv();
    private int zzfea;
    private akz zzfeh;
    private apo zzfei = apo.f2149a;

    private akv() {
    }

    public static final class a extends aqy.a<akv, a> implements ash {
        private a() {
            super(akv.zzfej);
        }

        public final a a(int i) {
            b();
            ((akv) this.f2190a).b(0);
            return this;
        }

        public final a a(akz akzVar) {
            b();
            ((akv) this.f2190a).a(akzVar);
            return this;
        }

        public final a a(apo apoVar) {
            b();
            ((akv) this.f2190a).b(apoVar);
            return this;
        }

        /* synthetic */ a(akw akwVar) {
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

    public final akz b() {
        return this.zzfeh == null ? akz.b() : this.zzfeh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(akz akzVar) {
        if (akzVar == null) {
            throw new NullPointerException();
        }
        this.zzfeh = akzVar;
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

    public static akv a(apo apoVar) {
        return (akv) aqy.a(zzfej, apoVar);
    }

    public static a d() {
        return (a) ((aqy.a) zzfej.a(aqy.e.e, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        akw akwVar = null;
        switch (akw.f2044a[i - 1]) {
            case 1:
                return new akv();
            case 2:
                return new a(akwVar);
            case 3:
                return a(zzfej, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzfea", "zzfeh", "zzfei"});
            case 4:
                return zzfej;
            case 5:
                asq<akv> bVar = zzcas;
                if (bVar == null) {
                    synchronized (akv.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfej);
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

    public static akv e() {
        return zzfej;
    }

    static {
        aqy.a((Class<akv>) akv.class, zzfej);
    }
}
