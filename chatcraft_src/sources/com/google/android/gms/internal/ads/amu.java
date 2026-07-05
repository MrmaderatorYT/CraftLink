package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public final class amu extends aqy<amu, a> implements ash {
    private static volatile asq<amu> zzcas;
    private static final amu zzfhh = new amu();
    private int zzfhe;
    private boolean zzfhf;
    private String zzfhd = BuildConfig.FLAVOR;
    private String zzfgk = BuildConfig.FLAVOR;
    private String zzfhg = BuildConfig.FLAVOR;

    private amu() {
    }

    public static final class a extends aqy.a<amu, a> implements ash {
        private a() {
            super(amu.zzfhh);
        }

        public final a a(String str) {
            b();
            ((amu) this.f2190a).a(str);
            return this;
        }

        public final a b(String str) {
            b();
            ((amu) this.f2190a).b(str);
            return this;
        }

        public final a a(int i) {
            b();
            ((amu) this.f2190a).b(0);
            return this;
        }

        public final a a(boolean z) {
            b();
            ((amu) this.f2190a).a(true);
            return this;
        }

        public final a c(String str) {
            b();
            ((amu) this.f2190a).c(str);
            return this;
        }

        /* synthetic */ a(amv amvVar) {
            this();
        }
    }

    public final String a() {
        return this.zzfhd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzfhd = str;
    }

    public final String b() {
        return this.zzfgk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzfgk = str;
    }

    public final int c() {
        return this.zzfhe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        this.zzfhe = i;
    }

    public final boolean d() {
        return this.zzfhf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z) {
        this.zzfhf = z;
    }

    public final String e() {
        return this.zzfhg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzfhg = str;
    }

    public static a f() {
        return (a) ((aqy.a) zzfhh.a(aqy.e.e, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        amv amvVar = null;
        switch (amv.f2081a[i - 1]) {
            case 1:
                return new amu();
            case 2:
                return new a(amvVar);
            case 3:
                return a(zzfhh, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzfhd", "zzfgk", "zzfhe", "zzfhf", "zzfhg"});
            case 4:
                return zzfhh;
            case 5:
                asq<amu> bVar = zzcas;
                if (bVar == null) {
                    synchronized (amu.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfhh);
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
        aqy.a((Class<amu>) amu.class, zzfhh);
    }
}
