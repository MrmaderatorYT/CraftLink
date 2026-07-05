package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public final class bpc {

    public static final class a extends aqy<a, b> implements ash {
        private static volatile asq<a> zzcas;
        private static final a zzccj = new a();
        private int zzccg;
        private int zzcch;
        private l zzcci;

        /* renamed from: com.google.android.gms.internal.ads.bpc$a$a, reason: collision with other inner class name */
        public enum EnumC0080a implements arb {
            AD_FORMAT_TYPE_UNSPECIFIED(0),
            BANNER(1),
            INTERSTITIAL(2),
            NATIVE_EXPRESS(3),
            NATIVE_CONTENT(4),
            NATIVE_APP_INSTALL(5),
            NATIVE_CUSTOM_TEMPLATE(6),
            DFP_BANNER(7),
            DFP_INTERSTITIAL(8),
            REWARD_BASED_VIDEO_AD(9),
            BANNER_SEARCH_ADS(10);

            private static final arc<EnumC0080a> l = new bpe();
            private final int m;

            @Override // com.google.android.gms.internal.ads.arb
            public final int a() {
                return this.m;
            }

            public static EnumC0080a a(int i) {
                switch (i) {
                    case 0:
                        return AD_FORMAT_TYPE_UNSPECIFIED;
                    case 1:
                        return BANNER;
                    case 2:
                        return INTERSTITIAL;
                    case 3:
                        return NATIVE_EXPRESS;
                    case 4:
                        return NATIVE_CONTENT;
                    case 5:
                        return NATIVE_APP_INSTALL;
                    case 6:
                        return NATIVE_CUSTOM_TEMPLATE;
                    case 7:
                        return DFP_BANNER;
                    case 8:
                        return DFP_INTERSTITIAL;
                    case 9:
                        return REWARD_BASED_VIDEO_AD;
                    case 10:
                        return BANNER_SEARCH_ADS;
                    default:
                        return null;
                }
            }

            public static ard b() {
                return bpf.f2936a;
            }

            EnumC0080a(int i) {
                this.m = i;
            }
        }

        private a() {
        }

        public static final class b extends aqy.a<a, b> implements ash {
            private b() {
                super(a.zzccj);
            }

            /* synthetic */ b(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new b(bpdVar);
                case 3:
                    return a(zzccj, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzccg", "zzcch", EnumC0080a.b(), "zzcci"});
                case 4:
                    return zzccj;
                case 5:
                    asq<a> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (a.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzccj);
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

        public static asq<a> a() {
            return (asq) zzccj.a(aqy.e.g, (Object) null, (Object) null);
        }

        static {
            aqy.a((Class<a>) a.class, zzccj);
        }
    }

    public static final class b extends aqy<b, a> implements ash {
        private static volatile asq<b> zzcas;
        private static final b zzcda = new b();
        private int zzccg;
        private String zzccx = BuildConfig.FLAVOR;
        private arf<a> zzccy = n();
        private int zzccz;

        private b() {
        }

        public static final class a extends aqy.a<b, a> implements ash {
            private a() {
                super(b.zzcda);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new b();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcda, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\b\u0000\u0002\u001b\u0003\f\u0001", new Object[]{"zzccg", "zzccx", "zzccy", a.class, "zzccz", bpj.b()});
                case 4:
                    return zzcda;
                case 5:
                    asq<b> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (b.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcda);
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

        public static asq<b> a() {
            return (asq) zzcda.a(aqy.e.g, (Object) null, (Object) null);
        }

        static {
            aqy.a((Class<b>) b.class, zzcda);
        }
    }

    public static final class c extends aqy<c, a> implements ash {
        private static volatile asq<c> zzcas;
        private static final c zzcdh = new c();
        private int zzccg;
        private int zzcdb;
        private n zzcdc;
        private n zzcdd;
        private n zzcde;
        private arf<n> zzcdf = n();
        private int zzcdg;

        private c() {
        }

        public static final class a extends aqy.a<c, a> implements ash {
            private a() {
                super(c.zzcdh);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new c();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcdh, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u0004\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003\u0005\u001b\u0006\u0004\u0004", new Object[]{"zzccg", "zzcdb", "zzcdc", "zzcdd", "zzcde", "zzcdf", n.class, "zzcdg"});
                case 4:
                    return zzcdh;
                case 5:
                    asq<c> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (c.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcdh);
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

        public static asq<c> a() {
            return (asq) zzcdh.a(aqy.e.g, (Object) null, (Object) null);
        }

        static {
            aqy.a((Class<c>) c.class, zzcdh);
        }
    }

    public static final class d extends aqy<d, a> implements ash {
        private static volatile asq<d> zzcas;
        private static final d zzcdm = new d();
        private int zzccg;
        private int zzcdi;
        private o zzcdj;
        private String zzcdk = BuildConfig.FLAVOR;
        private String zzcdl = BuildConfig.FLAVOR;

        public enum b implements arb {
            PLATFORM_UNSPECIFIED(0),
            IOS(1),
            ANDROID(2);

            private static final arc<b> d = new bph();
            private final int e;

            @Override // com.google.android.gms.internal.ads.arb
            public final int a() {
                return this.e;
            }

            public static b a(int i) {
                switch (i) {
                    case 0:
                        return PLATFORM_UNSPECIFIED;
                    case 1:
                        return IOS;
                    case 2:
                        return ANDROID;
                    default:
                        return null;
                }
            }

            public static ard b() {
                return bpi.f2939a;
            }

            b(int i) {
                this.e = i;
            }
        }

        private d() {
        }

        public static final class a extends aqy.a<d, a> implements ash {
            private a() {
                super(d.zzcdm);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new d();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcdm, "\u0001\u0004\u0000\u0001\u0005\b\u0004\u0000\u0000\u0000\u0005\f\u0000\u0006\t\u0001\u0007\b\u0002\b\b\u0003", new Object[]{"zzccg", "zzcdi", b.b(), "zzcdj", "zzcdk", "zzcdl"});
                case 4:
                    return zzcdm;
                case 5:
                    asq<d> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (d.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcdm);
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
            aqy.a((Class<d>) d.class, zzcdm);
        }
    }

    public static final class e extends aqy<e, a> implements ash {
        private static volatile asq<e> zzcas;
        private static final e zzcdz = new e();
        private int zzccg;
        private int zzcdw;
        private n zzcdy;
        private String zzcdv = BuildConfig.FLAVOR;
        private are zzcdx = m();

        private e() {
        }

        public static final class a extends aqy.a<e, a> implements ash {
            private a() {
                super(e.zzcdz);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new e();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcdz, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\b\u0000\u0002\f\u0001\u0003\u0016\u0004\t\u0002", new Object[]{"zzccg", "zzcdv", "zzcdw", bpj.b(), "zzcdx", "zzcdy"});
                case 4:
                    return zzcdz;
                case 5:
                    asq<e> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (e.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcdz);
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
            aqy.a((Class<e>) e.class, zzcdz);
        }
    }

    public static final class f extends aqy<f, a> implements ash {
        private static volatile asq<f> zzcas;
        private static final f zzceb = new f();
        private int zzccg;
        private are zzcdx = m();
        private int zzcea;

        private f() {
        }

        public static final class a extends aqy.a<f, a> implements ash {
            private a() {
                super(f.zzceb);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new f();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzceb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u0016", new Object[]{"zzccg", "zzcea", bpj.b(), "zzcdx"});
                case 4:
                    return zzceb;
                case 5:
                    asq<f> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (f.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzceb);
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

        public static asq<f> a() {
            return (asq) zzceb.a(aqy.e.g, (Object) null, (Object) null);
        }

        static {
            aqy.a((Class<f>) f.class, zzceb);
        }
    }

    public static final class g extends aqy<g, a> implements ash {
        private static volatile asq<g> zzcas;
        private static final g zzcee = new g();
        private int zzccg;
        private n zzcdy;
        private int zzcea;
        private e zzcec;
        private arf<m> zzced = n();

        private g() {
        }

        public static final class a extends aqy.a<g, a> implements ash {
            private a() {
                super(g.zzcee);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new g();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcee, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\t\u0000\u0002\u001b\u0003\f\u0001\u0004\t\u0002", new Object[]{"zzccg", "zzcec", "zzced", m.class, "zzcea", bpj.b(), "zzcdy"});
                case 4:
                    return zzcee;
                case 5:
                    asq<g> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (g.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcee);
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

        public static asq<g> a() {
            return (asq) zzcee.a(aqy.e.g, (Object) null, (Object) null);
        }

        static {
            aqy.a((Class<g>) g.class, zzcee);
        }
    }

    public static final class h extends aqy<h, a> implements ash {
        private static volatile asq<h> zzcas;
        private static final h zzceg = new h();
        private int zzccg;
        private int zzcch;
        private int zzcef;

        public enum b implements arb {
            CELLULAR_NETWORK_TYPE_UNSPECIFIED(0),
            TWO_G(1),
            THREE_G(2),
            LTE(4);

            private static final arc<b> e = new bpm();
            private final int f;

            @Override // com.google.android.gms.internal.ads.arb
            public final int a() {
                return this.f;
            }

            public static b a(int i) {
                if (i != 4) {
                    switch (i) {
                        case 0:
                            return CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                        case 1:
                            return TWO_G;
                        case 2:
                            return THREE_G;
                        default:
                            return null;
                    }
                }
                return LTE;
            }

            public static ard b() {
                return bpn.f2943a;
            }

            b(int i) {
                this.f = i;
            }
        }

        public enum c implements arb {
            NETWORKTYPE_UNSPECIFIED(0),
            CELL(1),
            WIFI(2);

            private static final arc<c> d = new bpo();
            private final int e;

            @Override // com.google.android.gms.internal.ads.arb
            public final int a() {
                return this.e;
            }

            public static c a(int i) {
                switch (i) {
                    case 0:
                        return NETWORKTYPE_UNSPECIFIED;
                    case 1:
                        return CELL;
                    case 2:
                        return WIFI;
                    default:
                        return null;
                }
            }

            public static ard b() {
                return bpp.f2944a;
            }

            c(int i) {
                this.e = i;
            }
        }

        private h() {
        }

        public static final class a extends aqy.a<h, a> implements ash {
            private a() {
                super(h.zzceg);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new h();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzceg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001", new Object[]{"zzccg", "zzcch", c.b(), "zzcef", b.b()});
                case 4:
                    return zzceg;
                case 5:
                    asq<h> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (h.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzceg);
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

        public static asq<h> a() {
            return (asq) zzceg.a(aqy.e.g, (Object) null, (Object) null);
        }

        static {
            aqy.a((Class<h>) h.class, zzceg);
        }
    }

    public static final class i extends aqy<i, a> implements ash {
        private static volatile asq<i> zzcas;
        private static final i zzces = new i();
        private int zzccg;
        private int zzceq;
        private n zzcer;

        private i() {
        }

        public static final class a extends aqy.a<i, a> implements ash {
            private a() {
                super(i.zzces);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new i();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzces, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzccg", "zzceq", bpj.b(), "zzcer"});
                case 4:
                    return zzces;
                case 5:
                    asq<i> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (i.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzces);
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

        public static asq<i> a() {
            return (asq) zzces.a(aqy.e.g, (Object) null, (Object) null);
        }

        static {
            aqy.a((Class<i>) i.class, zzces);
        }
    }

    public static final class j extends aqy<j, a> implements ash {
        private static volatile asq<j> zzcas;
        private static final j zzcfe = new j();
        private int zzccg;
        private int zzcet = 1000;
        private int zzceu = 1000;
        private int zzcev;
        private int zzcew;
        private int zzcex;
        private int zzcey;
        private int zzcez;
        private int zzcfa;
        private int zzcfb;
        private int zzcfc;
        private k zzcfd;

        private j() {
        }

        public static final class a extends aqy.a<j, a> implements ash {
            private a() {
                super(j.zzcfe);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new j();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcfe, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0004\u0005\u0007\u0004\u0006\b\u0004\u0007\t\u0004\b\n\u0004\t\u000b\t\n", new Object[]{"zzccg", "zzcet", bpj.b(), "zzceu", bpj.b(), "zzcev", "zzcew", "zzcex", "zzcey", "zzcez", "zzcfa", "zzcfb", "zzcfc", "zzcfd"});
                case 4:
                    return zzcfe;
                case 5:
                    asq<j> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (j.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcfe);
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

        public static asq<j> a() {
            return (asq) zzcfe.a(aqy.e.g, (Object) null, (Object) null);
        }

        static {
            aqy.a((Class<j>) j.class, zzcfe);
        }
    }

    public static final class k extends aqy<k, a> implements ash {
        private static volatile asq<k> zzcas;
        private static final k zzcfh = new k();
        private int zzccg;
        private int zzcff;
        private int zzcfg;

        private k() {
        }

        public static final class a extends aqy.a<k, a> implements ash {
            private a() {
                super(k.zzcfh);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new k();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcfh, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzccg", "zzcff", "zzcfg"});
                case 4:
                    return zzcfh;
                case 5:
                    asq<k> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (k.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcfh);
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
            aqy.a((Class<k>) k.class, zzcfh);
        }
    }

    public static final class l extends aqy<l, a> implements ash {
        private static volatile asq<l> zzcas;
        private static final l zzcfk = new l();
        private int zzccg;
        private int zzcfi;
        private int zzcfj;

        private l() {
        }

        public static final class a extends aqy.a<l, a> implements ash {
            private a() {
                super(l.zzcfk);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new l();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcfk, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzccg", "zzcfi", "zzcfj"});
                case 4:
                    return zzcfk;
                case 5:
                    asq<l> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (l.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcfk);
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
            aqy.a((Class<l>) l.class, zzcfk);
        }
    }

    public static final class m extends aqy<m, a> implements ash {
        private static volatile asq<m> zzcas;
        private static final m zzcfl = new m();
        private int zzccg;
        private String zzcdv = BuildConfig.FLAVOR;
        private int zzcdw;
        private n zzcdy;

        private m() {
        }

        public static final class a extends aqy.a<m, a> implements ash {
            private a() {
                super(m.zzcfl);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new m();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcfl, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\t\u0002", new Object[]{"zzccg", "zzcdv", "zzcdw", bpj.b(), "zzcdy"});
                case 4:
                    return zzcfl;
                case 5:
                    asq<m> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (m.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcfl);
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
            aqy.a((Class<m>) m.class, zzcfl);
        }
    }

    public static final class n extends aqy<n, a> implements ash {
        private static volatile asq<n> zzcas;
        private static final n zzcfo = new n();
        private int zzccg;
        private int zzcfm;
        private int zzcfn;

        private n() {
        }

        public static final class a extends aqy.a<n, a> implements ash {
            private a() {
                super(n.zzcfo);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new n();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcfo, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzccg", "zzcfm", "zzcfn"});
                case 4:
                    return zzcfo;
                case 5:
                    asq<n> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (n.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcfo);
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

        public static asq<n> a() {
            return (asq) zzcfo.a(aqy.e.g, (Object) null, (Object) null);
        }

        static {
            aqy.a((Class<n>) n.class, zzcfo);
        }
    }

    public static final class o extends aqy<o, a> implements ash {
        private static volatile asq<o> zzcas;
        private static final o zzcfs = new o();
        private int zzccg;
        private int zzcfp;
        private int zzcfq;
        private int zzcfr;

        private o() {
        }

        public static final class a extends aqy.a<o, a> implements ash {
            private a() {
                super(o.zzcfs);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new o();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcfs, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002", new Object[]{"zzccg", "zzcfp", "zzcfq", "zzcfr"});
                case 4:
                    return zzcfs;
                case 5:
                    asq<o> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (o.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcfs);
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
            aqy.a((Class<o>) o.class, zzcfs);
        }
    }

    public static final class p extends aqy<p, a> implements ash {
        private static volatile asq<p> zzcas;
        private static final p zzcfv = new p();
        private int zzccg;
        private int zzcea = 1000;
        private q zzcft;
        private n zzcfu;

        private p() {
        }

        public static final class a extends aqy.a<p, a> implements ash {
            private a() {
                super(p.zzcfv);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new p();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcfv, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzccg", "zzcea", bpj.b(), "zzcft", "zzcfu"});
                case 4:
                    return zzcfv;
                case 5:
                    asq<p> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (p.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcfv);
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

        public static asq<p> a() {
            return (asq) zzcfv.a(aqy.e.g, (Object) null, (Object) null);
        }

        static {
            aqy.a((Class<p>) p.class, zzcfv);
        }
    }

    public static final class q extends aqy<q, a> implements ash {
        private static volatile asq<q> zzcas;
        private static final q zzcfx = new q();
        private int zzccg;
        private int zzcfw;

        public enum b implements arb {
            VIDEO_ERROR_CODE_UNSPECIFIED(0),
            OPENGL_RENDERING_FAILED(1),
            CACHE_LOAD_FAILED(2),
            ANDROID_TARGET_API_TOO_LOW(3);

            private static final arc<b> e = new bpq();
            private final int f;

            @Override // com.google.android.gms.internal.ads.arb
            public final int a() {
                return this.f;
            }

            public static b a(int i) {
                switch (i) {
                    case 0:
                        return VIDEO_ERROR_CODE_UNSPECIFIED;
                    case 1:
                        return OPENGL_RENDERING_FAILED;
                    case 2:
                        return CACHE_LOAD_FAILED;
                    case 3:
                        return ANDROID_TARGET_API_TOO_LOW;
                    default:
                        return null;
                }
            }

            public static ard b() {
                return bpr.f2945a;
            }

            b(int i) {
                this.f = i;
            }
        }

        private q() {
        }

        public static final class a extends aqy.a<q, a> implements ash {
            private a() {
                super(q.zzcfx);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new q();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcfx, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"zzccg", "zzcfw", b.b()});
                case 4:
                    return zzcfx;
                case 5:
                    asq<q> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (q.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcfx);
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

        public static asq<q> a() {
            return (asq) zzcfx.a(aqy.e.g, (Object) null, (Object) null);
        }

        static {
            aqy.a((Class<q>) q.class, zzcfx);
        }
    }

    public static final class r extends aqy<r, a> implements ash {
        private static volatile asq<r> zzcas;
        private static final r zzcgg = new r();
        private int zzccg;
        private int zzcea = 1000;
        private q zzcft;
        private int zzcgd;
        private int zzcge;
        private int zzcgf;

        private r() {
        }

        public static final class a extends aqy.a<r, a> implements ash {
            private a() {
                super(r.zzcgg);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new r();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcgg, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004", new Object[]{"zzccg", "zzcea", bpj.b(), "zzcft", "zzcgd", "zzcge", "zzcgf"});
                case 4:
                    return zzcgg;
                case 5:
                    asq<r> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (r.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcgg);
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

        public static asq<r> a() {
            return (asq) zzcgg.a(aqy.e.g, (Object) null, (Object) null);
        }

        static {
            aqy.a((Class<r>) r.class, zzcgg);
        }
    }

    public static final class s extends aqy<s, a> implements ash {
        private static volatile asq<s> zzcas;
        private static final s zzcgh = new s();
        private int zzccg;
        private int zzcea = 1000;
        private q zzcft;
        private n zzcfu;

        private s() {
        }

        public static final class a extends aqy.a<s, a> implements ash {
            private a() {
                super(s.zzcgh);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new s();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcgh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzccg", "zzcea", bpj.b(), "zzcft", "zzcfu"});
                case 4:
                    return zzcgh;
                case 5:
                    asq<s> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (s.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcgh);
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

        public static asq<s> a() {
            return (asq) zzcgh.a(aqy.e.g, (Object) null, (Object) null);
        }

        static {
            aqy.a((Class<s>) s.class, zzcgh);
        }
    }

    public static final class t extends aqy<t, a> implements ash {
        private static volatile asq<t> zzcas;
        private static final t zzcgj = new t();
        private int zzccg;
        private int zzcea = 1000;
        private q zzcft;
        private int zzcgd;
        private int zzcge;
        private int zzcgf;
        private long zzcgi;

        private t() {
        }

        public static final class a extends aqy.a<t, a> implements ash {
            private a() {
                super(t.zzcgj);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new t();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcgj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0003\u0005", new Object[]{"zzccg", "zzcea", bpj.b(), "zzcft", "zzcgd", "zzcge", "zzcgf", "zzcgi"});
                case 4:
                    return zzcgj;
                case 5:
                    asq<t> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (t.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcgj);
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

        public static asq<t> a() {
            return (asq) zzcgj.a(aqy.e.g, (Object) null, (Object) null);
        }

        static {
            aqy.a((Class<t>) t.class, zzcgj);
        }
    }

    public static final class u extends aqy<u, a> implements ash {
        private static volatile asq<u> zzcas;
        private static final u zzcgk = new u();
        private int zzccg;
        private int zzcea = 1000;
        private q zzcft;
        private n zzcfu;

        private u() {
        }

        public static final class a extends aqy.a<u, a> implements ash {
            private a() {
                super(u.zzcgk);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new u();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcgk, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzccg", "zzcea", bpj.b(), "zzcft", "zzcfu"});
                case 4:
                    return zzcgk;
                case 5:
                    asq<u> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (u.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcgk);
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

        public static asq<u> a() {
            return (asq) zzcgk.a(aqy.e.g, (Object) null, (Object) null);
        }

        static {
            aqy.a((Class<u>) u.class, zzcgk);
        }
    }

    public static final class v extends aqy<v, a> implements ash {
        private static volatile asq<v> zzcas;
        private static final v zzcgl = new v();
        private int zzccg;
        private int zzcea = 1000;
        private q zzcft;

        private v() {
        }

        public static final class a extends aqy.a<v, a> implements ash {
            private a() {
                super(v.zzcgl);
            }

            /* synthetic */ a(bpd bpdVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bpd bpdVar = null;
            switch (bpd.f2935a[i - 1]) {
                case 1:
                    return new v();
                case 2:
                    return new a(bpdVar);
                case 3:
                    return a(zzcgl, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzccg", "zzcea", bpj.b(), "zzcft"});
                case 4:
                    return zzcgl;
                case 5:
                    asq<v> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (v.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcgl);
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

        public static asq<v> a() {
            return (asq) zzcgl.a(aqy.e.g, (Object) null, (Object) null);
        }

        static {
            aqy.a((Class<v>) v.class, zzcgl);
        }
    }
}
