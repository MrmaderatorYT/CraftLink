package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.aar;
import com.google.android.gms.internal.ads.bqj;
import com.google.android.gms.internal.ads.bqn;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.brh;
import com.google.android.gms.internal.ads.brl;
import com.google.android.gms.internal.ads.bsg;
import com.google.android.gms.internal.ads.dd;
import com.google.android.gms.internal.ads.dg;
import com.google.android.gms.internal.ads.dj;
import com.google.android.gms.internal.ads.dm;
import com.google.android.gms.internal.ads.dp;
import com.google.android.gms.internal.ads.ds;
import com.google.android.gms.internal.ads.ey;
import com.google.android.gms.internal.ads.ff;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.xn;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class i extends brl {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1611a;

    /* renamed from: b, reason: collision with root package name */
    private final brh f1612b;
    private final kk c;
    private final dd d;
    private final ds e;
    private final ff f;
    private final dg g;
    private final dp h;
    private final bqn i;
    private final com.google.android.gms.ads.b.j j;
    private final androidx.b.g<String, dm> k;
    private final androidx.b.g<String, dj> l;
    private final com.google.android.gms.internal.ads.br m;
    private final ey n;
    private final bsg o;
    private final String p;
    private final aar q;
    private WeakReference<ba> r;
    private final bt s;
    private final Object t = new Object();

    i(Context context, String str, kk kkVar, aar aarVar, brh brhVar, dd ddVar, ds dsVar, ff ffVar, dg dgVar, androidx.b.g<String, dm> gVar, androidx.b.g<String, dj> gVar2, com.google.android.gms.internal.ads.br brVar, ey eyVar, bsg bsgVar, bt btVar, dp dpVar, bqn bqnVar, com.google.android.gms.ads.b.j jVar) {
        this.f1611a = context;
        this.p = str;
        this.c = kkVar;
        this.q = aarVar;
        this.f1612b = brhVar;
        this.g = dgVar;
        this.d = ddVar;
        this.e = dsVar;
        this.f = ffVar;
        this.k = gVar;
        this.l = gVar2;
        this.m = brVar;
        this.n = eyVar;
        this.o = bsgVar;
        this.s = btVar;
        this.h = dpVar;
        this.i = bqnVar;
        this.j = jVar;
        com.google.android.gms.internal.ads.o.a(this.f1611a);
    }

    @Override // com.google.android.gms.internal.ads.brk
    public final void a(bqj bqjVar) {
        a(new j(this, bqjVar));
    }

    @Override // com.google.android.gms.internal.ads.brk
    public final void a(bqj bqjVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Number of ads has to be more than 0");
        }
        a(new k(this, bqjVar, i));
    }

    private final void a(int i) {
        if (this.f1612b != null) {
            try {
                this.f1612b.a(0);
            } catch (RemoteException e) {
                xe.c("Failed calling onAdFailedToLoad.", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(bqj bqjVar) {
        if (!((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.bH)).booleanValue() && this.e != null) {
            a(0);
            return;
        }
        bn bnVar = new bn(this.f1611a, this.s, this.i, this.p, this.c, this.q);
        this.r = new WeakReference<>(bnVar);
        dp dpVar = this.h;
        com.google.android.gms.common.internal.i.b("setOnPublisherAdViewLoadedListener must be called on the main UI thread.");
        bnVar.e.B = dpVar;
        if (this.j != null) {
            if (this.j.b() != null) {
                bnVar.a(this.j.b());
            }
            bnVar.b(this.j.a());
        }
        dd ddVar = this.d;
        com.google.android.gms.common.internal.i.b("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        bnVar.e.r = ddVar;
        ds dsVar = this.e;
        com.google.android.gms.common.internal.i.b("setOnUnifiedNativeAdLoadedListener must be called on the main UI thread.");
        bnVar.e.t = dsVar;
        dg dgVar = this.g;
        com.google.android.gms.common.internal.i.b("setOnContentAdLoadedListener must be called on the main UI thread.");
        bnVar.e.s = dgVar;
        androidx.b.g<String, dm> gVar = this.k;
        com.google.android.gms.common.internal.i.b("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        bnVar.e.w = gVar;
        androidx.b.g<String, dj> gVar2 = this.l;
        com.google.android.gms.common.internal.i.b("setOnCustomClickListener must be called on the main UI thread.");
        bnVar.e.v = gVar2;
        com.google.android.gms.internal.ads.br brVar = this.m;
        com.google.android.gms.common.internal.i.b("setNativeAdOptions must be called on the main UI thread.");
        bnVar.e.x = brVar;
        bnVar.b(f());
        bnVar.a(this.f1612b);
        bnVar.a(this.o);
        ArrayList arrayList = new ArrayList();
        if (e()) {
            arrayList.add(1);
        }
        if (this.h != null) {
            arrayList.add(2);
        }
        bnVar.c(arrayList);
        if (e()) {
            bqjVar.c.putBoolean("ina", true);
        }
        if (this.h != null) {
            bqjVar.c.putBoolean("iba", true);
        }
        bnVar.b(bqjVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(bqj bqjVar, int i) {
        if (!((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.bH)).booleanValue() && this.e != null) {
            a(0);
            return;
        }
        if (!((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.bI)).booleanValue() && this.f != null) {
            a(0);
            return;
        }
        ad adVar = new ad(this.f1611a, this.s, bqn.a(this.f1611a), this.p, this.c, this.q);
        this.r = new WeakReference<>(adVar);
        dd ddVar = this.d;
        com.google.android.gms.common.internal.i.b("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        adVar.e.r = ddVar;
        ds dsVar = this.e;
        com.google.android.gms.common.internal.i.b("setOnUnifiedNativeAdLoadedListener must be called on the main UI thread.");
        adVar.e.t = dsVar;
        ff ffVar = this.f;
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: setInstreamAdLoadCallback");
        adVar.e.u = ffVar;
        dg dgVar = this.g;
        com.google.android.gms.common.internal.i.b("setOnContentAdLoadedListener must be called on the main UI thread.");
        adVar.e.s = dgVar;
        androidx.b.g<String, dm> gVar = this.k;
        com.google.android.gms.common.internal.i.b("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        adVar.e.w = gVar;
        adVar.a(this.f1612b);
        androidx.b.g<String, dj> gVar2 = this.l;
        com.google.android.gms.common.internal.i.b("setOnCustomClickListener must be called on the main UI thread.");
        adVar.e.v = gVar2;
        adVar.b(f());
        com.google.android.gms.internal.ads.br brVar = this.m;
        com.google.android.gms.common.internal.i.b("setNativeAdOptions must be called on the main UI thread.");
        adVar.e.x = brVar;
        ey eyVar = this.n;
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.: setInstreamAdConfiguration");
        adVar.e.z = eyVar;
        adVar.a(this.o);
        adVar.b(i);
        adVar.b(bqjVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d() {
        return this.f == null && this.h != null;
    }

    private final boolean e() {
        if (this.d == null && this.g == null && this.e == null) {
            return this.k != null && this.k.size() > 0;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.brk
    public final String a() {
        synchronized (this.t) {
            if (this.r == null) {
                return null;
            }
            ba baVar = this.r.get();
            return baVar != null ? baVar.a() : null;
        }
    }

    @Override // com.google.android.gms.internal.ads.brk
    public final String b() {
        synchronized (this.t) {
            if (this.r == null) {
                return null;
            }
            ba baVar = this.r.get();
            return baVar != null ? baVar.q_() : null;
        }
    }

    @Override // com.google.android.gms.internal.ads.brk
    public final boolean c() {
        synchronized (this.t) {
            if (this.r == null) {
                return false;
            }
            ba baVar = this.r.get();
            return baVar != null ? baVar.s() : false;
        }
    }

    private final List<String> f() {
        ArrayList arrayList = new ArrayList();
        if (this.g != null) {
            arrayList.add("1");
        }
        if (this.d != null) {
            arrayList.add("2");
        }
        if (this.e != null) {
            arrayList.add("6");
        }
        if (this.k.size() > 0) {
            arrayList.add("3");
        }
        if (this.f != null) {
            arrayList.add("2");
            arrayList.add("1");
        }
        return arrayList;
    }

    private static void a(Runnable runnable) {
        xn.f3583a.post(runnable);
    }
}
