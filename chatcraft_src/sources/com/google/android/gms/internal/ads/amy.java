package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public final class amy extends aqy<amy, a> implements ash {
    private static volatile asq<amy> zzcas;
    private static final amy zzfhq = new amy();
    private int zzccg;
    private int zzfhi;
    private arf<b> zzfhp = n();

    public static final class b extends aqy<b, a> implements ash {
        private static volatile asq<b> zzcas;
        private static final b zzfhr = new b();
        private String zzfgk = BuildConfig.FLAVOR;
        private int zzfhb;
        private int zzfhm;
        private int zzfhn;

        private b() {
        }

        public static final class a extends aqy.a<b, a> implements ash {
            private a() {
                super(b.zzfhr);
            }

            public final a a(String str) {
                b();
                ((b) this.f2190a).a(str);
                return this;
            }

            public final a a(amp ampVar) {
                b();
                ((b) this.f2190a).a(ampVar);
                return this;
            }

            public final a a(int i) {
                b();
                ((b) this.f2190a).b(i);
                return this;
            }

            public final a a(ani aniVar) {
                b();
                ((b) this.f2190a).a(aniVar);
                return this;
            }

            /* synthetic */ a(amz amzVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzfgk = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(amp ampVar) {
            if (ampVar == null) {
                throw new NullPointerException();
            }
            this.zzfhm = ampVar.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i) {
            this.zzfhn = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(ani aniVar) {
            if (aniVar == null) {
                throw new NullPointerException();
            }
            this.zzfhb = aniVar.a();
        }

        public static a a() {
            return (a) ((aqy.a) zzfhr.a(aqy.e.e, (Object) null, (Object) null));
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            amz amzVar = null;
            switch (amz.f2083a[i - 1]) {
                case 1:
                    return new b();
                case 2:
                    return new a(amzVar);
                case 3:
                    return a(zzfhr, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzfgk", "zzfhm", "zzfhn", "zzfhb"});
                case 4:
                    return zzfhr;
                case 5:
                    asq<b> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (b.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzfhr);
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
            aqy.a((Class<b>) b.class, zzfhr);
        }
    }

    private amy() {
    }

    public static final class a extends aqy.a<amy, a> implements ash {
        private a() {
            super(amy.zzfhq);
        }

        public final a a(int i) {
            b();
            ((amy) this.f2190a).b(i);
            return this;
        }

        public final a a(b bVar) {
            b();
            ((amy) this.f2190a).a(bVar);
            return this;
        }

        /* synthetic */ a(amz amzVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        this.zzfhi = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(b bVar) {
        if (bVar == null) {
            throw new NullPointerException();
        }
        if (!this.zzfhp.a()) {
            arf<b> arfVar = this.zzfhp;
            int size = arfVar.size();
            this.zzfhp = arfVar.a(size == 0 ? 10 : size << 1);
        }
        this.zzfhp.add(bVar);
    }

    public static a a() {
        return (a) ((aqy.a) zzfhq.a(aqy.e.e, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        amz amzVar = null;
        switch (amz.f2083a[i - 1]) {
            case 1:
                return new amy();
            case 2:
                return new a(amzVar);
            case 3:
                return a(zzfhq, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzccg", "zzfhi", "zzfhp", b.class});
            case 4:
                return zzfhq;
            case 5:
                asq<amy> bVar = zzcas;
                if (bVar == null) {
                    synchronized (amy.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfhq);
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
        aqy.a((Class<amy>) amy.class, zzfhq);
    }
}
