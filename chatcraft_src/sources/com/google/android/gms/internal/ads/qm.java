package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.bou;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class qm extends xa implements ra {

    /* renamed from: a, reason: collision with root package name */
    private final ql f3396a;

    /* renamed from: b, reason: collision with root package name */
    private final rj f3397b;
    private final Object c = new Object();
    private final Context d;
    private final bos e;
    private final box f;
    private ri g;
    private Runnable h;

    @GuardedBy("mCancelLock")
    private boolean i;

    @GuardedBy("mCancelLock")
    private yi j;
    private rm k;
    private ju l;

    public qm(Context context, rj rjVar, ql qlVar, box boxVar) {
        this.f3396a = qlVar;
        this.d = context;
        this.f3397b = rjVar;
        this.f = boxVar;
        this.e = new bos(this.f);
        this.e.a(new bot(this) { // from class: com.google.android.gms.internal.ads.qn

            /* renamed from: a, reason: collision with root package name */
            private final qm f3398a;

            {
                this.f3398a = this;
            }

            @Override // com.google.android.gms.internal.ads.bot
            public final void a(bpw bpwVar) {
                this.f3398a.b(bpwVar);
            }
        });
        final bpx bpxVar = new bpx();
        bpxVar.f2956a = Integer.valueOf(this.f3397b.j.f1791b);
        bpxVar.f2957b = Integer.valueOf(this.f3397b.j.c);
        bpxVar.c = Integer.valueOf(this.f3397b.j.d ? 0 : 2);
        this.e.a(new bot(bpxVar) { // from class: com.google.android.gms.internal.ads.qo

            /* renamed from: a, reason: collision with root package name */
            private final bpx f3399a;

            {
                this.f3399a = bpxVar;
            }

            @Override // com.google.android.gms.internal.ads.bot
            public final void a(bpw bpwVar) {
                bpwVar.c.f2951b = this.f3399a;
            }
        });
        if (this.f3397b.f != null) {
            this.e.a(new bot(this) { // from class: com.google.android.gms.internal.ads.qp

                /* renamed from: a, reason: collision with root package name */
                private final qm f3400a;

                {
                    this.f3400a = this;
                }

                @Override // com.google.android.gms.internal.ads.bot
                public final void a(bpw bpwVar) {
                    this.f3400a.a(bpwVar);
                }
            });
        }
        bqn bqnVar = this.f3397b.c;
        if (bqnVar.d && "interstitial_mb".equals(bqnVar.f2974a)) {
            this.e.a(qq.f3401a);
        } else if (bqnVar.d && "reward_mb".equals(bqnVar.f2974a)) {
            this.e.a(qr.f3402a);
        } else if (bqnVar.h || bqnVar.d) {
            this.e.a(qt.f3404a);
        } else {
            this.e.a(qs.f3403a);
        }
        this.e.a(bou.a.b.AD_REQUEST);
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void a() throws IllegalAccessException, qw, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String string;
        xe.b("AdLoaderBackgroundTask started.");
        this.h = new Runnable(this) { // from class: com.google.android.gms.internal.ads.qu

            /* renamed from: a, reason: collision with root package name */
            private final qm f3405a;

            {
                this.f3405a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f3405a.d();
            }
        };
        xn.f3583a.postDelayed(this.h, ((Long) bra.e().a(o.bb)).longValue());
        long jB = com.google.android.gms.ads.internal.ax.l().b();
        if (this.f3397b.f3425b.c != null && (string = this.f3397b.f3425b.c.getString("_ad")) != null) {
            this.g = new ri(this.f3397b, jB, null, null, null, null);
            a(sw.a(this.d, this.g, string));
        } else {
            final acb acbVar = new acb();
            xl.a(new Runnable(this, acbVar) { // from class: com.google.android.gms.internal.ads.qv

                /* renamed from: a, reason: collision with root package name */
                private final qm f3406a;

                /* renamed from: b, reason: collision with root package name */
                private final abx f3407b;

                {
                    this.f3406a = this;
                    this.f3407b = acbVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f3406a.a(this.f3407b);
                }
            });
            this.g = new ri(this.f3397b, jB, com.google.android.gms.ads.internal.ax.E().c(this.d), com.google.android.gms.ads.internal.ax.E().d(this.d), com.google.android.gms.ads.internal.ax.E().e(this.d), com.google.android.gms.ads.internal.ax.E().f(this.d));
            acbVar.a(this.g);
        }
    }

    private final void a(int i, String str) {
        ri riVar;
        if (i == 3 || i == -1) {
            xe.d(str);
        } else {
            xe.e(str);
        }
        if (this.k == null) {
            this.k = new rm(i);
        } else {
            this.k = new rm(i, this.k.j);
        }
        if (this.g != null) {
            riVar = this.g;
        } else {
            riVar = new ri(this.f3397b, -1L, null, null, null, null);
        }
        this.f3396a.a(new wl(riVar, this.k, this.l, null, i, -1L, this.k.m, null, this.e, null));
    }

    @Override // com.google.android.gms.internal.ads.ra
    public final void a(rm rmVar) throws IllegalAccessException, qw, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Boolean boolValueOf;
        JSONObject jSONObject;
        xe.b("Received ad response.");
        this.k = rmVar;
        String str = this.k.U;
        if (!TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.ax.E().f(this.d, str);
        }
        long jB = com.google.android.gms.ads.internal.ax.l().b();
        synchronized (this.c) {
            boolValueOf = null;
            this.j = null;
        }
        com.google.android.gms.ads.internal.ax.i().k().d(this.k.F);
        if (((Boolean) bra.e().a(o.aC)).booleanValue()) {
            if (this.k.N) {
                com.google.android.gms.ads.internal.ax.i().k().c(this.g.e);
            } else {
                com.google.android.gms.ads.internal.ax.i().k().d(this.g.e);
            }
        }
        try {
            if (this.k.d != -2 && this.k.d != -3) {
                int i = this.k.d;
                StringBuilder sb = new StringBuilder(66);
                sb.append("There was a problem getting an ad response. ErrorCode: ");
                sb.append(i);
                throw new qw(sb.toString(), this.k.d);
            }
            if (this.k.d != -3) {
                if (TextUtils.isEmpty(this.k.f3428b)) {
                    throw new qw("No fill from ad server.", 3);
                }
                com.google.android.gms.ads.internal.ax.i().k().a(this.k.t);
                if (this.k.g) {
                    try {
                        this.l = new ju(this.k.f3428b);
                        com.google.android.gms.ads.internal.ax.i().a(this.l.h);
                    } catch (JSONException e) {
                        xe.b("Could not parse mediation config.", e);
                        String strValueOf = String.valueOf(this.k.f3428b);
                        throw new qw(strValueOf.length() != 0 ? "Could not parse mediation config: ".concat(strValueOf) : new String("Could not parse mediation config: "), 0);
                    }
                } else {
                    com.google.android.gms.ads.internal.ax.i().a(this.k.I);
                }
                if (!TextUtils.isEmpty(this.k.G)) {
                    xe.b("Received cookie from server. Setting webview cookie in CookieManager.");
                    CookieManager cookieManagerC = com.google.android.gms.ads.internal.ax.g().c(this.d);
                    if (cookieManagerC != null) {
                        cookieManagerC.setCookie("googleads.g.doubleclick.net", this.k.G);
                    }
                }
            }
            bqn bqnVarA = this.g.d.g != null ? a(this.g) : null;
            com.google.android.gms.ads.internal.ax.i().k().b(this.k.u);
            com.google.android.gms.ads.internal.ax.i().k().c(this.k.M);
            if (TextUtils.isEmpty(this.k.q)) {
                jSONObject = null;
            } else {
                try {
                    jSONObject = new JSONObject(this.k.q);
                } catch (Exception e2) {
                    xe.b("Error parsing the JSON for Active View.", e2);
                }
            }
            Bundle bundle = this.g.c.m;
            if (this.k.P == 2) {
                boolValueOf = true;
                Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                    bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
                }
                bundle2.putBoolean("render_test_ad_label", true);
            } else if (this.k.P == 1) {
                boolValueOf = false;
            } else if (this.k.P == 0) {
                boolValueOf = Boolean.valueOf(zu.a(bundle));
            }
            Boolean bool = boolValueOf;
            if (this.k.V) {
                Bundle bundle3 = bundle.getBundle(AdMobAdapter.class.getName());
                if (bundle3 == null) {
                    bundle3 = new Bundle();
                    bundle.putBundle(AdMobAdapter.class.getName(), bundle3);
                }
                bundle3.putBoolean("is_analytics_logging_enabled", true);
            }
            this.f3396a.a(new wl(this.g, this.k, this.l, bqnVarA, -2, jB, this.k.m, jSONObject, this.e, bool));
            xn.f3583a.removeCallbacks(this.h);
        } catch (qw e3) {
            a(e3.a(), e3.getMessage());
            xn.f3583a.removeCallbacks(this.h);
        }
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void c_() {
        synchronized (this.c) {
            if (this.j != null) {
                this.j.b();
            }
        }
    }

    private final bqn a(ri riVar) throws qw, NumberFormatException {
        int i;
        if (((this.g == null || this.g.V == null || this.g.V.size() <= 1) ? false : true) && this.l != null && !this.l.u) {
            return null;
        }
        if (this.k.y) {
            for (bqn bqnVar : riVar.d.g) {
                if (bqnVar.i) {
                    return new bqn(bqnVar, riVar.d.g);
                }
            }
        }
        if (this.k.l == null) {
            throw new qw("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] strArrSplit = this.k.l.split("x");
        if (strArrSplit.length != 2) {
            String strValueOf = String.valueOf(this.k.l);
            throw new qw(strValueOf.length() != 0 ? "Invalid ad size format from the ad response: ".concat(strValueOf) : new String("Invalid ad size format from the ad response: "), 0);
        }
        try {
            int i2 = Integer.parseInt(strArrSplit[0]);
            int i3 = Integer.parseInt(strArrSplit[1]);
            for (bqn bqnVar2 : riVar.d.g) {
                float f = this.d.getResources().getDisplayMetrics().density;
                int i4 = bqnVar2.e == -1 ? (int) (bqnVar2.f / f) : bqnVar2.e;
                if (bqnVar2.f2975b == -2) {
                    i = (int) (bqnVar2.c / f);
                } else {
                    i = bqnVar2.f2975b;
                }
                if (i2 == i4 && i3 == i && !bqnVar2.i) {
                    return new bqn(bqnVar2, riVar.d.g);
                }
            }
            String strValueOf2 = String.valueOf(this.k.l);
            throw new qw(strValueOf2.length() != 0 ? "The ad size from the ad response was not one of the requested sizes: ".concat(strValueOf2) : new String("The ad size from the ad response was not one of the requested sizes: "), 0);
        } catch (NumberFormatException unused) {
            String strValueOf3 = String.valueOf(this.k.l);
            throw new qw(strValueOf3.length() != 0 ? "Invalid ad size number from the ad response: ".concat(strValueOf3) : new String("Invalid ad size number from the ad response: "), 0);
        }
    }

    final /* synthetic */ void a(abx abxVar) {
        yi rgVar;
        synchronized (this.c) {
            if (this.i) {
                xe.e("Request task was already canceled");
                return;
            }
            aar aarVar = this.f3397b.j;
            Context context = this.d;
            if (new qy(context).a(aarVar)) {
                xe.b("Fetching ad response from local ad request service.");
                rgVar = new rf(context, abxVar, this);
                rgVar.c();
            } else {
                xe.b("Fetching ad response from remote ad request service.");
                bra.a();
                if (!aac.c(context, 12451000)) {
                    xe.e("Failed to connect to remote ad request service.");
                    rgVar = null;
                } else {
                    rgVar = new rg(context, aarVar, abxVar, this);
                }
            }
            this.j = rgVar;
            if (this.j == null) {
                a(0, "Could not start the ad request service.");
                xn.f3583a.removeCallbacks(this.h);
            }
        }
    }

    final /* synthetic */ void d() {
        synchronized (this.c) {
            this.i = true;
            if (this.j != null) {
                c_();
            }
            a(2, "Timed out waiting for ad response.");
        }
    }

    final /* synthetic */ void a(bpw bpwVar) {
        bpwVar.c.f2950a = this.f3397b.f.packageName;
    }

    final /* synthetic */ void b(bpw bpwVar) {
        bpwVar.f2954a = this.f3397b.v;
    }
}
