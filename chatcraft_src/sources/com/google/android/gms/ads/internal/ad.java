package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import com.google.android.gms.internal.ads.aan;
import com.google.android.gms.internal.ads.aar;
import com.google.android.gms.internal.ads.abl;
import com.google.android.gms.internal.ads.abv;
import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.bll;
import com.google.android.gms.internal.ads.bqj;
import com.google.android.gms.internal.ads.bqn;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.bsw;
import com.google.android.gms.internal.ads.bsz;
import com.google.android.gms.internal.ads.cz;
import com.google.android.gms.internal.ads.dj;
import com.google.android.gms.internal.ads.dm;
import com.google.android.gms.internal.ads.ju;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.kn;
import com.google.android.gms.internal.ads.kw;
import com.google.android.gms.internal.ads.kz;
import com.google.android.gms.internal.ads.nt;
import com.google.android.gms.internal.ads.oi;
import com.google.android.gms.internal.ads.pn;
import com.google.android.gms.internal.ads.pr;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.wk;
import com.google.android.gms.internal.ads.wl;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.xl;
import com.google.android.gms.internal.ads.xn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class ad extends ba implements com.google.android.gms.internal.ads.bg {
    private final Object k;
    private boolean l;
    private abv<com.google.android.gms.internal.ads.bh> m;
    private afu n;
    private afu o;
    private boolean p;
    private int q;

    @GuardedBy("mLock")
    private pn r;
    private final String s;

    public ad(Context context, bt btVar, bqn bqnVar, String str, kk kkVar, aar aarVar) {
        this(context, btVar, bqnVar, str, kkVar, aarVar, false);
    }

    public ad(Context context, bt btVar, bqn bqnVar, String str, kk kkVar, aar aarVar, boolean z) {
        super(context, bqnVar, str, kkVar, aarVar, btVar);
        this.k = new Object();
        this.m = new abv<>();
        this.q = 1;
        this.s = UUID.randomUUID().toString();
        this.l = z;
    }

    public final String j_() {
        return this.s;
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.ads.internal.a
    public final boolean a(bqj bqjVar, com.google.android.gms.internal.ads.ac acVar) {
        try {
            k_();
            return super.a(bqjVar, acVar, this.q);
        } catch (Exception e) {
            if (!aan.a(4)) {
                return false;
            }
            Log.i("Ads", "Error initializing webview.", e);
            return false;
        }
    }

    final void k_() {
        synchronized (this.k) {
            xe.a("Initializing webview native ads utills");
            this.r = new pr(this.e.c, this, this.s, this.e.d, this.e.e);
        }
    }

    public final pn I() {
        pn pnVar;
        synchronized (this.k) {
            pnVar = this.r;
        }
        return pnVar;
    }

    @Override // com.google.android.gms.ads.internal.a
    public final void a(final wl wlVar, com.google.android.gms.internal.ads.ac acVar) throws JSONException {
        if (wlVar.d != null) {
            this.e.i = wlVar.d;
        }
        if (wlVar.e != -2) {
            xn.f3583a.post(new Runnable(this, wlVar) { // from class: com.google.android.gms.ads.internal.ae

                /* renamed from: a, reason: collision with root package name */
                private final ad f1503a;

                /* renamed from: b, reason: collision with root package name */
                private final wl f1504b;

                {
                    this.f1503a = this;
                    this.f1504b = wlVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f1503a.b(new wk(this.f1504b, null, null, null, null, null, null, null));
                }
            });
            return;
        }
        int i = wlVar.f3545a.Y;
        if (i == 1) {
            this.e.L = 0;
            ay ayVar = this.e;
            ax.d();
            ayVar.h = oi.a(this.e.c, this, wlVar, this.e.d, null, this.j, this, acVar);
            String strValueOf = String.valueOf(this.e.h.getClass().getName());
            xe.b(strValueOf.length() != 0 ? "AdRenderer: ".concat(strValueOf) : new String("AdRenderer: "));
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONObject(wlVar.f3546b.f3428b).getJSONArray("slots");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONArray jSONArrayOptJSONArray = jSONArray2.getJSONObject(i2).optJSONArray("ads");
                for (int i3 = 0; jSONArrayOptJSONArray != null && i3 < jSONArrayOptJSONArray.length(); i3++) {
                    jSONArray.put(jSONArrayOptJSONArray.get(i3));
                }
            }
            af();
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < i; i4++) {
                arrayList.add(xl.a(new ag(this, i4, jSONArray, i, wlVar)));
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                try {
                    xn.f3583a.post(new ah(this, (com.google.android.gms.internal.ads.bh) ((abl) arrayList.get(i5)).get(((Long) bra.e().a(com.google.android.gms.internal.ads.o.bc)).longValue(), TimeUnit.MILLISECONDS), i5, arrayList));
                } catch (InterruptedException e) {
                    aan.c(BuildConfig.FLAVOR, e);
                    Thread.currentThread().interrupt();
                } catch (CancellationException | ExecutionException | TimeoutException e2) {
                    aan.c(BuildConfig.FLAVOR, e2);
                }
            }
        } catch (JSONException e3) {
            xe.c("Malformed native ad response", e3);
            a(0);
        }
    }

    @Override // com.google.android.gms.ads.internal.a
    protected final void a(int i) {
        a(i, false);
    }

    @Override // com.google.android.gms.ads.internal.a
    protected final void a(int i, boolean z) {
        af();
        super.a(i, z);
    }

    @Override // com.google.android.gms.ads.internal.ba
    protected final boolean a(bqj bqjVar, wk wkVar, boolean z) {
        return this.d.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0360  */
    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.ads.internal.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final boolean a(com.google.android.gms.internal.ads.wk r28, com.google.android.gms.internal.ads.wk r29) {
        /*
            Method dump skipped, instructions count: 908
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.ad.a(com.google.android.gms.internal.ads.wk, com.google.android.gms.internal.ads.wk):boolean");
    }

    protected final void a(com.google.android.gms.dynamic.a aVar) {
        Object objA = aVar != null ? com.google.android.gms.dynamic.b.a(aVar) : null;
        if (objA instanceof com.google.android.gms.internal.ads.bf) {
            ((com.google.android.gms.internal.ads.bf) objA).e();
        }
        super.b(this.e.j, false);
    }

    protected final Future<com.google.android.gms.internal.ads.bh> J() {
        return this.m;
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final void o() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final void p() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    private final void a(com.google.android.gms.internal.ads.au auVar) {
        xn.f3583a.post(new ai(this, auVar));
    }

    private final void a(com.google.android.gms.internal.ads.bb bbVar) {
        xn.f3583a.post(new aj(this, bbVar));
    }

    private final void a(com.google.android.gms.internal.ads.aw awVar) {
        xn.f3583a.post(new ak(this, awVar));
    }

    private final void a(String str, boolean z) {
        String str2;
        if (z) {
            if (this.o == null && this.n == null) {
                return;
            }
            boolean z2 = this.o != null;
            boolean z3 = this.n != null;
            afu afuVar = null;
            if (z2) {
                str2 = null;
                afuVar = this.o;
            } else if (z3) {
                afuVar = this.n;
                str2 = "javascript";
            } else {
                str2 = null;
            }
            if (afuVar.getWebView() != null && ax.v().a(this.e.c)) {
                int i = this.e.e.f1791b;
                int i2 = this.e.e.c;
                StringBuilder sb = new StringBuilder(23);
                sb.append(i);
                sb.append(".");
                sb.append(i2);
                this.h = ax.v().a(sb.toString(), afuVar.getWebView(), BuildConfig.FLAVOR, "javascript", str2, str);
                if (this.h == null) {
                    return;
                }
                afuVar.a(this.h);
                if (z3) {
                    com.google.android.gms.dynamic.a aVar = this.h;
                    View view = this.n.getView();
                    if (view != null) {
                        ax.v().a(aVar, view);
                    }
                }
                ax.v().a(this.h);
            }
        }
    }

    private final boolean ad() {
        return this.e.j != null && this.e.j.N;
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final void b(View view) {
        boolean z = this.o != null;
        if (!ad() || this.h == null || !z || view == null) {
            return;
        }
        ax.v().a(this.h, view);
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final void K() {
        if (ad() && this.h != null) {
            afu afuVar = null;
            if (this.o != null) {
                afuVar = this.o;
            } else if (this.n != null) {
                afuVar = this.n;
            }
            if (afuVar != null) {
                afuVar.a("onSdkImpression", new HashMap());
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.a
    protected final void x() {
        d(false);
    }

    @Override // com.google.android.gms.ads.internal.a
    protected final void d(boolean z) {
        super.d(z);
        if (this.p) {
            if (((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.bC)).booleanValue()) {
                L();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final void a(com.google.android.gms.internal.ads.bf bfVar) {
        if (this.e.j.k != null && this.e.z == null) {
            ax.i().f().a(this.e.i, this.e.j, new bll(bfVar), (afu) null);
        }
    }

    public final void L() {
        if (this.e.j == null || this.n == null) {
            this.p = true;
            xe.e("Request to enable ActiveView before adState is available.");
        } else {
            ax.i().f().a(this.e.i, this.e.j, this.n.getView(), this.n);
            this.p = false;
        }
    }

    public final void M() {
        this.p = false;
        if (this.e.j == null || this.n == null) {
            xe.e("Request to enable ActiveView before adState is available.");
        } else {
            ax.i().f().a(this.e.j);
        }
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final String D() {
        return this.e.f1537b;
    }

    public final void b(List<String> list) {
        com.google.android.gms.common.internal.i.b("setNativeTemplates must be called on the main UI thread.");
        this.e.I = list;
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final dj c(String str) {
        com.google.android.gms.common.internal.i.b("getOnCustomClickListener must be called on the main UI thread.");
        if (this.e.v == null) {
            return null;
        }
        return this.e.v.get(str);
    }

    public final androidx.b.g<String, dm> N() {
        com.google.android.gms.common.internal.i.b("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.e.w;
    }

    public final void b(int i) {
        com.google.android.gms.common.internal.i.b("setMaxNumberOfAds must be called on the main UI thread.");
        this.q = i;
    }

    public final void a(afu afuVar) {
        this.n = afuVar;
    }

    public final void b(afu afuVar) {
        this.o = afuVar;
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final void O() {
        if (this.n != null) {
            this.n.destroy();
            this.n = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final void P() {
        this.h = null;
        if (this.o != null) {
            this.o.destroy();
            this.o = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final void a(com.google.android.gms.internal.ads.bd bdVar) {
        if (this.n != null) {
            this.n.a(bdVar);
        }
    }

    public final void Q() {
        if (this.n != null && this.n.b() != null && this.e.x != null && this.e.x.f != null) {
            this.n.b().a(this.e.x.f);
        } else {
            if (this.e.u == null || this.n == null || this.n.b() == null) {
                return;
            }
            this.n.b().a(false, true, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final boolean R() {
        if (ae() != null) {
            return ae().p;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final boolean S() {
        if (ae() != null) {
            return ae().q;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.bg
    public final boolean T() {
        if (ae() != null) {
            return ae().r;
        }
        return false;
    }

    private final ju ae() {
        if (this.e.j == null || !this.e.j.n) {
            return null;
        }
        return this.e.j.r;
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final void a(nt ntVar) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final void a(com.google.android.gms.internal.ads.ai aiVar) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.internal.ads.brs
    public final void H() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.internal.ads.jv
    public final void U() {
        if (this.e.j != null && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.e.j.q)) {
            z();
        } else {
            super.U();
        }
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.internal.ads.jv
    public final void V() {
        if (this.e.j != null && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.e.j.q)) {
            y();
        } else {
            super.V();
        }
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.internal.ads.jv
    public final void W() {
        bsz bszVarG;
        wk wkVar = this.e.j;
        if (wkVar.p == null) {
            super.W();
            return;
        }
        try {
            kn knVar = wkVar.p;
            bsw bswVarG = null;
            kw kwVarH = knVar.h();
            if (kwVarH != null) {
                bswVarG = kwVarH.m();
            } else {
                kz kzVarI = knVar.i();
                if (kzVarI != null) {
                    bswVarG = kzVarI.l();
                } else {
                    cz czVarN = knVar.n();
                    if (czVarN != null) {
                        bswVarG = czVarN.g();
                    }
                }
            }
            if (bswVarG == null || (bszVarG = bswVarG.g()) == null) {
                return;
            }
            bszVarG.d();
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.google.android.gms.internal.ads.bb b(com.google.android.gms.internal.ads.bh bhVar) {
        com.google.android.gms.internal.ads.bb bbVar;
        Object objA;
        Object obj = null;
        if (bhVar instanceof com.google.android.gms.internal.ads.aw) {
            com.google.android.gms.internal.ads.aw awVar = (com.google.android.gms.internal.ads.aw) bhVar;
            bbVar = new com.google.android.gms.internal.ads.bb(awVar.e(), awVar.f(), awVar.i(), awVar.j(), awVar.k(), awVar.l(), -1.0d, null, null, awVar.c(), awVar.m(), awVar.d(), awVar.g(), awVar.h(), awVar.o());
            if (awVar.n() != null) {
                objA = com.google.android.gms.dynamic.b.a(awVar.n());
                obj = objA;
            }
        } else if (bhVar instanceof com.google.android.gms.internal.ads.au) {
            com.google.android.gms.internal.ads.au auVar = (com.google.android.gms.internal.ads.au) bhVar;
            bbVar = new com.google.android.gms.internal.ads.bb(auVar.e(), auVar.f(), auVar.g(), auVar.h(), auVar.i(), null, auVar.j(), auVar.k(), auVar.l(), auVar.c(), auVar.m(), auVar.d(), auVar.p(), auVar.q(), auVar.o());
            if (auVar.n() != null) {
                objA = com.google.android.gms.dynamic.b.a(auVar.n());
                obj = objA;
            }
        } else {
            bbVar = null;
        }
        if (obj instanceof com.google.android.gms.internal.ads.bj) {
            bbVar.a((com.google.android.gms.internal.ads.bj) obj);
        }
        return bbVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(ay ayVar, ay ayVar2) {
        if (ayVar2.r == null) {
            ayVar2.r = ayVar.r;
        }
        if (ayVar2.s == null) {
            ayVar2.s = ayVar.s;
        }
        if (ayVar2.v == null) {
            ayVar2.v = ayVar.v;
        }
        if (ayVar2.w == null) {
            ayVar2.w = ayVar.w;
        }
        if (ayVar2.y == null) {
            ayVar2.y = ayVar.y;
        }
        if (ayVar2.x == null) {
            ayVar2.x = ayVar.x;
        }
        if (ayVar2.I == null) {
            ayVar2.I = ayVar.I;
        }
        if (ayVar2.l == null) {
            ayVar2.l = ayVar.l;
        }
        if (ayVar2.J == null) {
            ayVar2.J = ayVar.J;
        }
        if (ayVar2.m == null) {
            ayVar2.m = ayVar.m;
        }
        if (ayVar2.n == null) {
            ayVar2.n = ayVar.n;
        }
        if (ayVar2.i == null) {
            ayVar2.i = ayVar.i;
        }
        if (ayVar2.j == null) {
            ayVar2.j = ayVar.j;
        }
        if (ayVar2.k == null) {
            ayVar2.k = ayVar.k;
        }
    }

    private final void af() {
        pn pnVarI = I();
        if (pnVarI != null) {
            pnVarI.a();
        }
    }
}
