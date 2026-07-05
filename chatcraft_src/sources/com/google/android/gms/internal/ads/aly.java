package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class aly extends aqy<aly, a> implements ash {
    private static volatile asq<aly> zzcas;
    private static final aly zzffn = new aly();
    private int zzfea;
    private alu zzffd;
    private apo zzffl = apo.f2149a;
    private apo zzffm = apo.f2149a;

    private aly() {
    }

    public static final class a extends aqy.a<aly, a> implements ash {
        private a() {
            super(aly.zzffn);
        }

        public final a a(int i) {
            b();
            ((aly) this.f2190a).b(0);
            return this;
        }

        public final a a(alu aluVar) {
            b();
            ((aly) this.f2190a).a(aluVar);
            return this;
        }

        public final a a(apo apoVar) {
            b();
            ((aly) this.f2190a).b(apoVar);
            return this;
        }

        public final a b(apo apoVar) {
            b();
            ((aly) this.f2190a).c(apoVar);
            return this;
        }

        /* synthetic */ a(alz alzVar) {
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

    public final alu b() {
        return this.zzffd == null ? alu.d() : this.zzffd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(alu aluVar) {
        if (aluVar == null) {
            throw new NullPointerException();
        }
        this.zzffd = aluVar;
    }

    public final apo c() {
        return this.zzffl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(apo apoVar) {
        if (apoVar == null) {
            throw new NullPointerException();
        }
        this.zzffl = apoVar;
    }

    public final apo d() {
        return this.zzffm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(apo apoVar) {
        if (apoVar == null) {
            throw new NullPointerException();
        }
        this.zzffm = apoVar;
    }

    public static aly a(apo apoVar) {
        return (aly) aqy.a(zzffn, apoVar);
    }

    public static a e() {
        return (a) ((aqy.a) zzffn.a(aqy.e.e, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        alz alzVar = null;
        switch (alz.f2062a[i - 1]) {
            case 1:
                return new aly();
            case 2:
                return new a(alzVar);
            case 3:
                return a(zzffn, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzfea", "zzffd", "zzffl", "zzffm"});
            case 4:
                return zzffn;
            case 5:
                asq<aly> bVar = zzcas;
                if (bVar == null) {
                    synchronized (aly.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzffn);
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

    public static aly f() {
        return zzffn;
    }

    static {
        aqy.a((Class<aly>) aly.class, zzffn);
    }
}
