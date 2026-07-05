package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public final class amm extends aqy<amm, a> implements ash {
    private static volatile asq<amm> zzcas;
    private static final amm zzfgn = new amm();
    private String zzfgk = BuildConfig.FLAVOR;
    private apo zzfgl = apo.f2149a;
    private int zzfgm;

    public enum b implements arb {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);

        private static final arc<b> g = new amo();
        private final int h;

        @Override // com.google.android.gms.internal.ads.arb
        public final int a() {
            if (this != UNRECOGNIZED) {
                return this.h;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static b a(int i2) {
            switch (i2) {
                case 0:
                    return UNKNOWN_KEYMATERIAL;
                case 1:
                    return SYMMETRIC;
                case 2:
                    return ASYMMETRIC_PRIVATE;
                case 3:
                    return ASYMMETRIC_PUBLIC;
                case 4:
                    return REMOTE;
                default:
                    return null;
            }
        }

        b(int i2) {
            this.h = i2;
        }
    }

    private amm() {
    }

    public static final class a extends aqy.a<amm, a> implements ash {
        private a() {
            super(amm.zzfgn);
        }

        public final a a(String str) {
            b();
            ((amm) this.f2190a).a(str);
            return this;
        }

        public final a a(apo apoVar) {
            b();
            ((amm) this.f2190a).a(apoVar);
            return this;
        }

        public final a a(b bVar) {
            b();
            ((amm) this.f2190a).a(bVar);
            return this;
        }

        /* synthetic */ a(amn amnVar) {
            this();
        }
    }

    public final String a() {
        return this.zzfgk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzfgk = str;
    }

    public final apo b() {
        return this.zzfgl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(apo apoVar) {
        if (apoVar == null) {
            throw new NullPointerException();
        }
        this.zzfgl = apoVar;
    }

    public final b c() {
        b bVarA = b.a(this.zzfgm);
        return bVarA == null ? b.UNRECOGNIZED : bVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(b bVar) {
        if (bVar == null) {
            throw new NullPointerException();
        }
        this.zzfgm = bVar.a();
    }

    public static a d() {
        return (a) ((aqy.a) zzfgn.a(aqy.e.e, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        amn amnVar = null;
        switch (amn.f2075a[i - 1]) {
            case 1:
                return new amm();
            case 2:
                return new a(amnVar);
            case 3:
                return a(zzfgn, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzfgk", "zzfgl", "zzfgm"});
            case 4:
                return zzfgn;
            case 5:
                asq<amm> bVar = zzcas;
                if (bVar == null) {
                    synchronized (amm.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfgn);
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

    public static amm e() {
        return zzfgn;
    }

    static {
        aqy.a((Class<amm>) amm.class, zzfgn);
    }
}
