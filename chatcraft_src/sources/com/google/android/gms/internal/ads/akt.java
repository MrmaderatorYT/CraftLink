package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class akt extends aqy<akt, a> implements ash {
    private static volatile asq<akt> zzcas;
    private static final akt zzfeg = new akt();
    private akx zzfee;
    private ami zzfef;

    private akt() {
    }

    public static final class a extends aqy.a<akt, a> implements ash {
        private a() {
            super(akt.zzfeg);
        }

        /* synthetic */ a(aku akuVar) {
            this();
        }
    }

    public final akx a() {
        return this.zzfee == null ? akx.c() : this.zzfee;
    }

    public final ami b() {
        return this.zzfef == null ? ami.c() : this.zzfef;
    }

    public static akt a(apo apoVar) {
        return (akt) aqy.a(zzfeg, apoVar);
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        aku akuVar = null;
        switch (aku.f2043a[i - 1]) {
            case 1:
                return new akt();
            case 2:
                return new a(akuVar);
            case 3:
                return a(zzfeg, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzfee", "zzfef"});
            case 4:
                return zzfeg;
            case 5:
                asq<akt> bVar = zzcas;
                if (bVar == null) {
                    synchronized (akt.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfeg);
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
        aqy.a((Class<akt>) akt.class, zzfeg);
    }
}
