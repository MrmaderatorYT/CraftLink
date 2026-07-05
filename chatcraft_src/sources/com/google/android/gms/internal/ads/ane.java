package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class ane extends aqy<ane, a> implements ash {
    private static volatile asq<ane> zzcas;
    private static final ane zzfhx = new ane();
    private int zzfea;
    private ang zzfhw;

    private ane() {
    }

    public static final class a extends aqy.a<ane, a> implements ash {
        private a() {
            super(ane.zzfhx);
        }

        public final a a(int i) {
            b();
            ((ane) this.f2190a).b(0);
            return this;
        }

        public final a a(ang angVar) {
            b();
            ((ane) this.f2190a).a(angVar);
            return this;
        }

        /* synthetic */ a(anf anfVar) {
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

    public final ang b() {
        return this.zzfhw == null ? ang.c() : this.zzfhw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ang angVar) {
        if (angVar == null) {
            throw new NullPointerException();
        }
        this.zzfhw = angVar;
    }

    public static ane a(apo apoVar) {
        return (ane) aqy.a(zzfhx, apoVar);
    }

    public static a c() {
        return (a) ((aqy.a) zzfhx.a(aqy.e.e, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        anf anfVar = null;
        switch (anf.f2086a[i - 1]) {
            case 1:
                return new ane();
            case 2:
                return new a(anfVar);
            case 3:
                return a(zzfhx, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzfea", "zzfhw"});
            case 4:
                return zzfhx;
            case 5:
                asq<ane> bVar = zzcas;
                if (bVar == null) {
                    synchronized (ane.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfhx);
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
        aqy.a((Class<ane>) ane.class, zzfhx);
    }
}
