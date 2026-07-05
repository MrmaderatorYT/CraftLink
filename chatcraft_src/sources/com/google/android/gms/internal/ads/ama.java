package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class ama extends aqy<ama, a> implements ash {
    private static volatile asq<ama> zzcas;
    private static final ama zzffr = new ama();
    private int zzffo;
    private int zzffp;
    private apo zzffq = apo.f2149a;

    private ama() {
    }

    public static final class a extends aqy.a<ama, a> implements ash {
        private a() {
            super(ama.zzffr);
        }

        /* synthetic */ a(amb ambVar) {
            this();
        }
    }

    public final amc a() {
        amc amcVarA = amc.a(this.zzffo);
        return amcVarA == null ? amc.UNRECOGNIZED : amcVarA;
    }

    public final ame b() {
        ame ameVarA = ame.a(this.zzffp);
        return ameVarA == null ? ame.UNRECOGNIZED : ameVarA;
    }

    public final apo c() {
        return this.zzffq;
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        amb ambVar = null;
        switch (amb.f2065a[i - 1]) {
            case 1:
                return new ama();
            case 2:
                return new a(ambVar);
            case 3:
                return a(zzffr, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzffo", "zzffp", "zzffq"});
            case 4:
                return zzffr;
            case 5:
                asq<ama> bVar = zzcas;
                if (bVar == null) {
                    synchronized (ama.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzffr);
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

    public static ama d() {
        return zzffr;
    }

    static {
        aqy.a((Class<ama>) ama.class, zzffr);
    }
}
