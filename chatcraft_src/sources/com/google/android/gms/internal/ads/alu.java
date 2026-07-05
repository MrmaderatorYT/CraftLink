package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class alu extends aqy<alu, a> implements ash {
    private static volatile asq<alu> zzcas;
    private static final alu zzffi = new alu();
    private ama zzfff;
    private alp zzffg;
    private int zzffh;

    private alu() {
    }

    public static final class a extends aqy.a<alu, a> implements ash {
        private a() {
            super(alu.zzffi);
        }

        /* synthetic */ a(alv alvVar) {
            this();
        }
    }

    public final ama a() {
        return this.zzfff == null ? ama.d() : this.zzfff;
    }

    public final alp b() {
        return this.zzffg == null ? alp.b() : this.zzffg;
    }

    public final aln c() {
        aln alnVarA = aln.a(this.zzffh);
        return alnVarA == null ? aln.UNRECOGNIZED : alnVarA;
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        alv alvVar = null;
        switch (alv.f2060a[i - 1]) {
            case 1:
                return new alu();
            case 2:
                return new a(alvVar);
            case 3:
                return a(zzffi, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzfff", "zzffg", "zzffh"});
            case 4:
                return zzffi;
            case 5:
                asq<alu> bVar = zzcas;
                if (bVar == null) {
                    synchronized (alu.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzffi);
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

    public static alu d() {
        return zzffi;
    }

    static {
        aqy.a((Class<alu>) alu.class, zzffi);
    }
}
