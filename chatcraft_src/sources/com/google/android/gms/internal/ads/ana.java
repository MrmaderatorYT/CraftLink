package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class ana extends aqy<ana, a> implements ash {
    private static volatile asq<ana> zzcas;
    private static final ana zzfht = new ana();
    private int zzfea;
    private anc zzfhs;

    private ana() {
    }

    public static final class a extends aqy.a<ana, a> implements ash {
        private a() {
            super(ana.zzfht);
        }

        public final a a(int i) {
            b();
            ((ana) this.f2190a).b(0);
            return this;
        }

        public final a a(anc ancVar) {
            b();
            ((ana) this.f2190a).a(ancVar);
            return this;
        }

        /* synthetic */ a(anb anbVar) {
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

    public final anc b() {
        return this.zzfhs == null ? anc.b() : this.zzfhs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(anc ancVar) {
        if (ancVar == null) {
            throw new NullPointerException();
        }
        this.zzfhs = ancVar;
    }

    public static ana a(apo apoVar) {
        return (ana) aqy.a(zzfht, apoVar);
    }

    public static a c() {
        return (a) ((aqy.a) zzfht.a(aqy.e.e, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        anb anbVar = null;
        switch (anb.f2084a[i - 1]) {
            case 1:
                return new ana();
            case 2:
                return new a(anbVar);
            case 3:
                return a(zzfht, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzfea", "zzfhs"});
            case 4:
                return zzfht;
            case 5:
                asq<ana> bVar = zzcas;
                if (bVar == null) {
                    synchronized (ana.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfht);
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
        aqy.a((Class<ana>) ana.class, zzfht);
    }
}
