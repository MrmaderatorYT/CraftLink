package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;
import java.util.List;

/* loaded from: classes.dex */
public final class amw extends aqy<amw, a> implements ash {
    private static volatile asq<amw> zzcas;
    private static final amw zzfhk = new amw();
    private int zzccg;
    private int zzfhi;
    private arf<b> zzfhj = n();

    public static final class b extends aqy<b, a> implements ash {
        private static volatile asq<b> zzcas;
        private static final b zzfho = new b();
        private int zzfhb;
        private amm zzfhl;
        private int zzfhm;
        private int zzfhn;

        private b() {
        }

        public static final class a extends aqy.a<b, a> implements ash {
            private a() {
                super(b.zzfho);
            }

            /* synthetic */ a(amx amxVar) {
                this();
            }
        }

        public final boolean a() {
            return this.zzfhl != null;
        }

        public final amm b() {
            return this.zzfhl == null ? amm.e() : this.zzfhl;
        }

        public final amp c() {
            amp ampVarA = amp.a(this.zzfhm);
            return ampVarA == null ? amp.UNRECOGNIZED : ampVarA;
        }

        public final int d() {
            return this.zzfhn;
        }

        public final ani e() {
            ani aniVarA = ani.a(this.zzfhb);
            return aniVarA == null ? ani.UNRECOGNIZED : aniVarA;
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            amx amxVar = null;
            switch (amx.f2082a[i - 1]) {
                case 1:
                    return new b();
                case 2:
                    return new a(amxVar);
                case 3:
                    return a(zzfho, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzfhl", "zzfhm", "zzfhn", "zzfhb"});
                case 4:
                    return zzfho;
                case 5:
                    asq<b> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (b.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzfho);
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
            aqy.a((Class<b>) b.class, zzfho);
        }
    }

    private amw() {
    }

    public static final class a extends aqy.a<amw, a> implements ash {
        private a() {
            super(amw.zzfhk);
        }

        /* synthetic */ a(amx amxVar) {
            this();
        }
    }

    public final int a() {
        return this.zzfhi;
    }

    public final List<b> b() {
        return this.zzfhj;
    }

    public final int c() {
        return this.zzfhj.size();
    }

    public static amw a(byte[] bArr) {
        return (amw) aqy.a(zzfhk, bArr);
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        amx amxVar = null;
        switch (amx.f2082a[i - 1]) {
            case 1:
                return new amw();
            case 2:
                return new a(amxVar);
            case 3:
                return a(zzfhk, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzccg", "zzfhi", "zzfhj", b.class});
            case 4:
                return zzfhk;
            case 5:
                asq<amw> bVar = zzcas;
                if (bVar == null) {
                    synchronized (amw.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfhk);
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
        aqy.a((Class<amw>) amw.class, zzfhk);
    }
}
