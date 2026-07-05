package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public final class aux {

    public static final class a extends aqy<a, C0072a> implements ash {
        private static volatile asq<a> zzcas;
        private static final a zzfxm = new a();
        private int zzccg;
        private int zzfxf;
        private b zzfxg;
        private boolean zzfxj;
        private boolean zzfxk;
        private byte zzfxl = 2;
        private apo zzfxh = apo.f2149a;
        private apo zzfxi = apo.f2149a;

        public static final class b extends aqy<b, C0073a> implements ash {
            private static volatile asq<b> zzcas;
            private static final b zzfxr = new b();
            private int zzccg;
            private String zzfxn = BuildConfig.FLAVOR;
            private String zzfxo = BuildConfig.FLAVOR;
            private String zzfxp = BuildConfig.FLAVOR;
            private int zzfxq;

            private b() {
            }

            /* renamed from: com.google.android.gms.internal.ads.aux$a$b$a, reason: collision with other inner class name */
            public static final class C0073a extends aqy.a<b, C0073a> implements ash {
                private C0073a() {
                    super(b.zzfxr);
                }

                /* synthetic */ C0073a(auy auyVar) {
                    this();
                }
            }

            @Override // com.google.android.gms.internal.ads.aqy
            protected final Object a(int i, Object obj, Object obj2) {
                auy auyVar = null;
                switch (auy.f2301a[i - 1]) {
                    case 1:
                        return new b();
                    case 2:
                        return new C0073a(auyVar);
                    case 3:
                        return a(zzfxr, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0004\u0003", new Object[]{"zzccg", "zzfxn", "zzfxo", "zzfxp", "zzfxq"});
                    case 4:
                        return zzfxr;
                    case 5:
                        asq<b> bVar = zzcas;
                        if (bVar == null) {
                            synchronized (b.class) {
                                bVar = zzcas;
                                if (bVar == null) {
                                    bVar = new aqy.b<>(zzfxr);
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
                aqy.a((Class<b>) b.class, zzfxr);
            }
        }

        public enum c implements arb {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);

            private static final arc<c> f = new auz();
            private final int g;

            @Override // com.google.android.gms.internal.ads.arb
            public final int a() {
                return this.g;
            }

            public static c a(int i) {
                switch (i) {
                    case 0:
                        return SAFE;
                    case 1:
                        return DANGEROUS;
                    case 2:
                        return UNKNOWN;
                    case 3:
                        return POTENTIALLY_UNWANTED;
                    case 4:
                        return DANGEROUS_HOST;
                    default:
                        return null;
                }
            }

            public static ard b() {
                return ava.f2303a;
            }

            c(int i) {
                this.g = i;
            }
        }

        private a() {
        }

        /* renamed from: com.google.android.gms.internal.ads.aux$a$a, reason: collision with other inner class name */
        public static final class C0072a extends aqy.a<a, C0072a> implements ash {
            private C0072a() {
                super(a.zzfxm);
            }

            /* synthetic */ C0072a(auy auyVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            auy auyVar = null;
            switch (auy.f2301a[i - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new C0072a(auyVar);
                case 3:
                    return a(zzfxm, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001Ԍ\u0000\u0002\t\u0001\u0003\n\u0002\u0004\n\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"zzccg", "zzfxf", c.b(), "zzfxg", "zzfxh", "zzfxi", "zzfxj", "zzfxk"});
                case 4:
                    return zzfxm;
                case 5:
                    asq<a> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (a.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzfxm);
                                zzcas = bVar;
                            }
                        }
                    }
                    return bVar;
                case 6:
                    return Byte.valueOf(this.zzfxl);
                case 7:
                    this.zzfxl = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            aqy.a((Class<a>) a.class, zzfxm);
        }
    }

    public static final class b extends aqy<b, a> implements ash {
        private static volatile asq<b> zzcas;
        private static final b zzfyn = new b();
        private int zzccg;
        private int zzcch;
        private int zzfxy;
        private C0074b zzfyb;
        private f zzfye;
        private boolean zzfyf;
        private boolean zzfyi;
        private boolean zzfyj;
        private i zzfyk;
        private byte zzfxl = 2;
        private String zzfxo = BuildConfig.FLAVOR;
        private String zzfxz = BuildConfig.FLAVOR;
        private String zzfya = BuildConfig.FLAVOR;
        private arf<h> zzfyc = n();
        private String zzfyd = BuildConfig.FLAVOR;
        private arf<String> zzfyg = aqy.n();
        private String zzfyh = BuildConfig.FLAVOR;
        private apo zzfxh = apo.f2149a;
        private arf<String> zzfyl = aqy.n();
        private arf<String> zzfym = aqy.n();

        /* renamed from: com.google.android.gms.internal.ads.aux$b$b, reason: collision with other inner class name */
        public static final class C0074b extends aqy<C0074b, a> implements ash {
            private static volatile asq<C0074b> zzcas;
            private static final C0074b zzfyp = new C0074b();
            private int zzccg;
            private String zzfyo = BuildConfig.FLAVOR;

            private C0074b() {
            }

            /* renamed from: com.google.android.gms.internal.ads.aux$b$b$a */
            public static final class a extends aqy.a<C0074b, a> implements ash {
                private a() {
                    super(C0074b.zzfyp);
                }

                /* synthetic */ a(auy auyVar) {
                    this();
                }
            }

            @Override // com.google.android.gms.internal.ads.aqy
            protected final Object a(int i, Object obj, Object obj2) {
                auy auyVar = null;
                switch (auy.f2301a[i - 1]) {
                    case 1:
                        return new C0074b();
                    case 2:
                        return new a(auyVar);
                    case 3:
                        return a(zzfyp, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"zzccg", "zzfyo"});
                    case 4:
                        return zzfyp;
                    case 5:
                        asq<C0074b> bVar = zzcas;
                        if (bVar == null) {
                            synchronized (C0074b.class) {
                                bVar = zzcas;
                                if (bVar == null) {
                                    bVar = new aqy.b<>(zzfyp);
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
                aqy.a((Class<C0074b>) C0074b.class, zzfyp);
            }
        }

        public static final class c extends aqy<c, a> implements ash {
            private static volatile asq<c> zzcas;
            private static final c zzfyr = new c();
            private int zzccg;
            private byte zzfxl = 2;
            private apo zzfyq = apo.f2149a;
            private apo zzfgl = apo.f2149a;

            private c() {
            }

            public static final class a extends aqy.a<c, a> implements ash {
                private a() {
                    super(c.zzfyr);
                }

                /* synthetic */ a(auy auyVar) {
                    this();
                }
            }

            @Override // com.google.android.gms.internal.ads.aqy
            protected final Object a(int i, Object obj, Object obj2) {
                auy auyVar = null;
                switch (auy.f2301a[i - 1]) {
                    case 1:
                        return new c();
                    case 2:
                        return new a(auyVar);
                    case 3:
                        return a(zzfyr, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001Ԋ\u0000\u0002\n\u0001", new Object[]{"zzccg", "zzfyq", "zzfgl"});
                    case 4:
                        return zzfyr;
                    case 5:
                        asq<c> bVar = zzcas;
                        if (bVar == null) {
                            synchronized (c.class) {
                                bVar = zzcas;
                                if (bVar == null) {
                                    bVar = new aqy.b<>(zzfyr);
                                    zzcas = bVar;
                                }
                            }
                        }
                        return bVar;
                    case 6:
                        return Byte.valueOf(this.zzfxl);
                    case 7:
                        this.zzfxl = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                aqy.a((Class<c>) c.class, zzfyr);
            }
        }

        public static final class d extends aqy<d, a> implements ash {
            private static volatile asq<d> zzcas;
            private static final d zzfyx = new d();
            private int zzccg;
            private C0075b zzfys;
            private int zzfyw;
            private byte zzfxl = 2;
            private arf<c> zzfyt = n();
            private apo zzfyu = apo.f2149a;
            private apo zzfyv = apo.f2149a;

            /* renamed from: com.google.android.gms.internal.ads.aux$b$d$b, reason: collision with other inner class name */
            public static final class C0075b extends aqy<C0075b, a> implements ash {
                private static volatile asq<C0075b> zzcas;
                private static final C0075b zzfzb = new C0075b();
                private int zzccg;
                private apo zzfyy = apo.f2149a;
                private apo zzfyz = apo.f2149a;
                private apo zzfza = apo.f2149a;

                private C0075b() {
                }

                /* renamed from: com.google.android.gms.internal.ads.aux$b$d$b$a */
                public static final class a extends aqy.a<C0075b, a> implements ash {
                    private a() {
                        super(C0075b.zzfzb);
                    }

                    /* synthetic */ a(auy auyVar) {
                        this();
                    }
                }

                @Override // com.google.android.gms.internal.ads.aqy
                protected final Object a(int i, Object obj, Object obj2) {
                    auy auyVar = null;
                    switch (auy.f2301a[i - 1]) {
                        case 1:
                            return new C0075b();
                        case 2:
                            return new a(auyVar);
                        case 3:
                            return a(zzfzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzccg", "zzfyy", "zzfyz", "zzfza"});
                        case 4:
                            return zzfzb;
                        case 5:
                            asq<C0075b> bVar = zzcas;
                            if (bVar == null) {
                                synchronized (C0075b.class) {
                                    bVar = zzcas;
                                    if (bVar == null) {
                                        bVar = new aqy.b<>(zzfzb);
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

                public static asq<C0075b> a() {
                    return (asq) zzfzb.a(aqy.e.g, (Object) null, (Object) null);
                }

                static {
                    aqy.a((Class<C0075b>) C0075b.class, zzfzb);
                }
            }

            private d() {
            }

            public static final class a extends aqy.a<d, a> implements ash {
                private a() {
                    super(d.zzfyx);
                }

                /* synthetic */ a(auy auyVar) {
                    this();
                }
            }

            @Override // com.google.android.gms.internal.ads.aqy
            protected final Object a(int i, Object obj, Object obj2) {
                auy auyVar = null;
                switch (auy.f2301a[i - 1]) {
                    case 1:
                        return new d();
                    case 2:
                        return new a(auyVar);
                    case 3:
                        return a(zzfyx, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003", new Object[]{"zzccg", "zzfys", "zzfyt", c.class, "zzfyu", "zzfyv", "zzfyw"});
                    case 4:
                        return zzfyx;
                    case 5:
                        asq<d> bVar = zzcas;
                        if (bVar == null) {
                            synchronized (d.class) {
                                bVar = zzcas;
                                if (bVar == null) {
                                    bVar = new aqy.b<>(zzfyx);
                                    zzcas = bVar;
                                }
                            }
                        }
                        return bVar;
                    case 6:
                        return Byte.valueOf(this.zzfxl);
                    case 7:
                        this.zzfxl = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                aqy.a((Class<d>) d.class, zzfyx);
            }
        }

        public static final class e extends aqy<e, a> implements ash {
            private static volatile asq<e> zzcas;
            private static final e zzfze = new e();
            private int zzccg;
            private int zzfyw;
            private C0076b zzfzc;
            private byte zzfxl = 2;
            private arf<c> zzfyt = n();
            private apo zzfyu = apo.f2149a;
            private apo zzfyv = apo.f2149a;
            private apo zzfzd = apo.f2149a;

            /* renamed from: com.google.android.gms.internal.ads.aux$b$e$b, reason: collision with other inner class name */
            public static final class C0076b extends aqy<C0076b, a> implements ash {
                private static volatile asq<C0076b> zzcas;
                private static final C0076b zzfzh = new C0076b();
                private int zzccg;
                private int zzfzf;
                private apo zzfzg = apo.f2149a;
                private apo zzfza = apo.f2149a;

                private C0076b() {
                }

                /* renamed from: com.google.android.gms.internal.ads.aux$b$e$b$a */
                public static final class a extends aqy.a<C0076b, a> implements ash {
                    private a() {
                        super(C0076b.zzfzh);
                    }

                    /* synthetic */ a(auy auyVar) {
                        this();
                    }
                }

                @Override // com.google.android.gms.internal.ads.aqy
                protected final Object a(int i, Object obj, Object obj2) {
                    auy auyVar = null;
                    switch (auy.f2301a[i - 1]) {
                        case 1:
                            return new C0076b();
                        case 2:
                            return new a(auyVar);
                        case 3:
                            return a(zzfzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzccg", "zzfzf", "zzfzg", "zzfza"});
                        case 4:
                            return zzfzh;
                        case 5:
                            asq<C0076b> bVar = zzcas;
                            if (bVar == null) {
                                synchronized (C0076b.class) {
                                    bVar = zzcas;
                                    if (bVar == null) {
                                        bVar = new aqy.b<>(zzfzh);
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

                public static asq<C0076b> a() {
                    return (asq) zzfzh.a(aqy.e.g, (Object) null, (Object) null);
                }

                static {
                    aqy.a((Class<C0076b>) C0076b.class, zzfzh);
                }
            }

            private e() {
            }

            public static final class a extends aqy.a<e, a> implements ash {
                private a() {
                    super(e.zzfze);
                }

                /* synthetic */ a(auy auyVar) {
                    this();
                }
            }

            @Override // com.google.android.gms.internal.ads.aqy
            protected final Object a(int i, Object obj, Object obj2) {
                auy auyVar = null;
                switch (auy.f2301a[i - 1]) {
                    case 1:
                        return new e();
                    case 2:
                        return new a(auyVar);
                    case 3:
                        return a(zzfze, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003\u0006\n\u0004", new Object[]{"zzccg", "zzfzc", "zzfyt", c.class, "zzfyu", "zzfyv", "zzfyw", "zzfzd"});
                    case 4:
                        return zzfze;
                    case 5:
                        asq<e> bVar = zzcas;
                        if (bVar == null) {
                            synchronized (e.class) {
                                bVar = zzcas;
                                if (bVar == null) {
                                    bVar = new aqy.b<>(zzfze);
                                    zzcas = bVar;
                                }
                            }
                        }
                        return bVar;
                    case 6:
                        return Byte.valueOf(this.zzfxl);
                    case 7:
                        this.zzfxl = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                aqy.a((Class<e>) e.class, zzfze);
            }
        }

        public static final class f extends aqy<f, a> implements ash {
            private static volatile asq<f> zzcas;
            private static final f zzfzk = new f();
            private int zzccg;
            private int zzcch;
            private String zzfzi = BuildConfig.FLAVOR;
            private apo zzfzj = apo.f2149a;

            /* renamed from: com.google.android.gms.internal.ads.aux$b$f$b, reason: collision with other inner class name */
            public enum EnumC0077b implements arb {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);

                private static final arc<EnumC0077b> c = new avb();
                private final int d;

                @Override // com.google.android.gms.internal.ads.arb
                public final int a() {
                    return this.d;
                }

                public static EnumC0077b a(int i) {
                    switch (i) {
                        case 0:
                            return TYPE_UNKNOWN;
                        case 1:
                            return TYPE_CREATIVE;
                        default:
                            return null;
                    }
                }

                public static ard b() {
                    return avc.f2304a;
                }

                EnumC0077b(int i) {
                    this.d = i;
                }
            }

            private f() {
            }

            public static final class a extends aqy.a<f, a> implements ash {
                private a() {
                    super(f.zzfzk);
                }

                /* synthetic */ a(auy auyVar) {
                    this();
                }
            }

            @Override // com.google.android.gms.internal.ads.aqy
            protected final Object a(int i, Object obj, Object obj2) {
                auy auyVar = null;
                switch (auy.f2301a[i - 1]) {
                    case 1:
                        return new f();
                    case 2:
                        return new a(auyVar);
                    case 3:
                        return a(zzfzk, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\n\u0002", new Object[]{"zzccg", "zzcch", EnumC0077b.b(), "zzfzi", "zzfzj"});
                    case 4:
                        return zzfzk;
                    case 5:
                        asq<f> bVar = zzcas;
                        if (bVar == null) {
                            synchronized (f.class) {
                                bVar = zzcas;
                                if (bVar == null) {
                                    bVar = new aqy.b<>(zzfzk);
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
                aqy.a((Class<f>) f.class, zzfzk);
            }
        }

        public enum g implements arb {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);

            private static final arc<g> k = new avd();
            private final int l;

            @Override // com.google.android.gms.internal.ads.arb
            public final int a() {
                return this.l;
            }

            public static g a(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            public static ard b() {
                return ave.f2305a;
            }

            g(int i) {
                this.l = i;
            }
        }

        public static final class h extends aqy<h, C0078b> implements ash {
            private static volatile asq<h> zzcas;
            private static final h zzgah = new h();
            private int zzccg;
            private int zzfzz;
            private d zzgaa;
            private e zzgab;
            private int zzgac;
            private int zzgaf;
            private byte zzfxl = 2;
            private String zzfxo = BuildConfig.FLAVOR;
            private are zzgad = m();
            private String zzgae = BuildConfig.FLAVOR;
            private arf<String> zzgag = aqy.n();

            public enum a implements arb {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);

                private static final arc<a> e = new avf();
                private final int f;

                @Override // com.google.android.gms.internal.ads.arb
                public final int a() {
                    return this.f;
                }

                public static a a(int i) {
                    switch (i) {
                        case 0:
                            return AD_RESOURCE_UNKNOWN;
                        case 1:
                            return AD_RESOURCE_CREATIVE;
                        case 2:
                            return AD_RESOURCE_POST_CLICK;
                        case 3:
                            return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                        default:
                            return null;
                    }
                }

                public static ard b() {
                    return avg.f2306a;
                }

                a(int i) {
                    this.f = i;
                }
            }

            private h() {
            }

            /* renamed from: com.google.android.gms.internal.ads.aux$b$h$b, reason: collision with other inner class name */
            public static final class C0078b extends aqy.a<h, C0078b> implements ash {
                private C0078b() {
                    super(h.zzgah);
                }

                /* synthetic */ C0078b(auy auyVar) {
                    this();
                }
            }

            @Override // com.google.android.gms.internal.ads.aqy
            protected final Object a(int i, Object obj, Object obj2) {
                auy auyVar = null;
                switch (auy.f2301a[i - 1]) {
                    case 1:
                        return new h();
                    case 2:
                        return new C0078b(auyVar);
                    case 3:
                        return a(zzgah, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001Ԅ\u0000\u0002\b\u0001\u0003Љ\u0002\u0004Љ\u0003\u0005\u0004\u0004\u0006\u0016\u0007\b\u0005\b\f\u0006\t\u001a", new Object[]{"zzccg", "zzfzz", "zzfxo", "zzgaa", "zzgab", "zzgac", "zzgad", "zzgae", "zzgaf", a.b(), "zzgag"});
                    case 4:
                        return zzgah;
                    case 5:
                        asq<h> bVar = zzcas;
                        if (bVar == null) {
                            synchronized (h.class) {
                                bVar = zzcas;
                                if (bVar == null) {
                                    bVar = new aqy.b<>(zzgah);
                                    zzcas = bVar;
                                }
                            }
                        }
                        return bVar;
                    case 6:
                        return Byte.valueOf(this.zzfxl);
                    case 7:
                        this.zzfxl = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                aqy.a((Class<h>) h.class, zzgah);
            }
        }

        public static final class i extends aqy<i, a> implements ash {
            private static volatile asq<i> zzcas;
            private static final i zzgaq = new i();
            private int zzccg;
            private String zzgan = BuildConfig.FLAVOR;
            private long zzgao;
            private boolean zzgap;

            private i() {
            }

            public static final class a extends aqy.a<i, a> implements ash {
                private a() {
                    super(i.zzgaq);
                }

                /* synthetic */ a(auy auyVar) {
                    this();
                }
            }

            @Override // com.google.android.gms.internal.ads.aqy
            protected final Object a(int i, Object obj, Object obj2) {
                auy auyVar = null;
                switch (auy.f2301a[i - 1]) {
                    case 1:
                        return new i();
                    case 2:
                        return new a(auyVar);
                    case 3:
                        return a(zzgaq, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\u0007\u0002", new Object[]{"zzccg", "zzgan", "zzgao", "zzgap"});
                    case 4:
                        return zzgaq;
                    case 5:
                        asq<i> bVar = zzcas;
                        if (bVar == null) {
                            synchronized (i.class) {
                                bVar = zzcas;
                                if (bVar == null) {
                                    bVar = new aqy.b<>(zzgaq);
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
                aqy.a((Class<i>) i.class, zzgaq);
            }
        }

        private b() {
        }

        public static final class a extends aqy.a<b, a> implements ash {
            private a() {
                super(b.zzfyn);
            }

            /* synthetic */ a(auy auyVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i2, Object obj, Object obj2) {
            auy auyVar = null;
            switch (auy.f2301a[i2 - 1]) {
                case 1:
                    return new b();
                case 2:
                    return new a(auyVar);
                case 3:
                    return a(zzfyn, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001\b\u0002\u0002\b\u0003\u0003\b\u0004\u0004Л\u0005\u0007\b\u0006\u001a\u0007\b\t\b\u0007\n\t\u0007\u000b\n\f\u0000\u000b\f\u0001\f\t\u0005\r\b\u0006\u000e\t\u0007\u000f\n\f\u0011\t\r\u0014\u001a\u0015\u001a", new Object[]{"zzccg", "zzfxo", "zzfxz", "zzfya", "zzfyc", h.class, "zzfyf", "zzfyg", "zzfyh", "zzfyi", "zzfyj", "zzcch", g.b(), "zzfxy", a.c.b(), "zzfyb", "zzfyd", "zzfye", "zzfxh", "zzfyk", "zzfyl", "zzfym"});
                case 4:
                    return zzfyn;
                case 5:
                    asq<b> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (b.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzfyn);
                                zzcas = bVar;
                            }
                        }
                    }
                    return bVar;
                case 6:
                    return Byte.valueOf(this.zzfxl);
                case 7:
                    this.zzfxl = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            aqy.a((Class<b>) b.class, zzfyn);
        }
    }
}
