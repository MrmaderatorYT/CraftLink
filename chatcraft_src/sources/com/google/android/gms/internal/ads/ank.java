package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public final class ank extends aqy<ank, a> implements ash {
    private static volatile asq<ank> zzcas;
    private static final ank zzfik = new ank();
    private int zzccg;
    private String zzfii = BuildConfig.FLAVOR;
    private arf<amu> zzfij = n();

    private ank() {
    }

    public static final class a extends aqy.a<ank, a> implements ash {
        private a() {
            super(ank.zzfik);
        }

        public final a a(String str) {
            b();
            ((ank) this.f2190a).a(str);
            return this;
        }

        public final a a(amu amuVar) {
            b();
            ((ank) this.f2190a).a(amuVar);
            return this;
        }

        /* synthetic */ a(anl anlVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzfii = str;
    }

    public final List<amu> a() {
        return this.zzfij;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(amu amuVar) {
        if (amuVar == null) {
            throw new NullPointerException();
        }
        if (!this.zzfij.a()) {
            arf<amu> arfVar = this.zzfij;
            int size = arfVar.size();
            this.zzfij = arfVar.a(size == 0 ? 10 : size << 1);
        }
        this.zzfij.add(amuVar);
    }

    public static a b() {
        return (a) ((aqy.a) zzfik.a(aqy.e.e, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.ads.aqy
    protected final Object a(int i, Object obj, Object obj2) {
        anl anlVar = null;
        switch (anl.f2090a[i - 1]) {
            case 1:
                return new ank();
            case 2:
                return new a(anlVar);
            case 3:
                return a(zzfik, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzccg", "zzfii", "zzfij", amu.class});
            case 4:
                return zzfik;
            case 5:
                asq<ank> bVar = zzcas;
                if (bVar == null) {
                    synchronized (ank.class) {
                        bVar = zzcas;
                        if (bVar == null) {
                            bVar = new aqy.b<>(zzfik);
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
        aqy.a((Class<ank>) ank.class, zzfik);
    }
}
