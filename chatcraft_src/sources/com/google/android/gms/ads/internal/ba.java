package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import com.google.android.gms.internal.ads.aar;
import com.google.android.gms.internal.ads.aaz;
import com.google.android.gms.internal.ads.abl;
import com.google.android.gms.internal.ads.abq;
import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.bnb;
import com.google.android.gms.internal.ads.bou;
import com.google.android.gms.internal.ads.box;
import com.google.android.gms.internal.ads.bqj;
import com.google.android.gms.internal.ads.bqn;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.btc;
import com.google.android.gms.internal.ads.cz;
import com.google.android.gms.internal.ads.dj;
import com.google.android.gms.internal.ads.gr;
import com.google.android.gms.internal.ads.jv;
import com.google.android.gms.internal.ads.kc;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.qm;
import com.google.android.gms.internal.ads.rj;
import com.google.android.gms.internal.ads.se;
import com.google.android.gms.internal.ads.wk;
import com.google.android.gms.internal.ads.wo;
import com.google.android.gms.internal.ads.xa;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.xl;
import com.google.android.gms.internal.ads.xn;
import com.google.android.gms.internal.ads.xv;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class ba extends a implements aq, com.google.android.gms.ads.internal.overlay.n, jv {
    protected final kk j;
    private transient boolean k;

    public ba(Context context, bqn bqnVar, String str, kk kkVar, aar aarVar, bt btVar) {
        this(new ay(context, bqnVar, str, aarVar), kkVar, null, btVar);
    }

    private ba(ay ayVar, kk kkVar, an anVar, bt btVar) {
        super(ayVar, null, btVar);
        this.j = kkVar;
        this.k = false;
    }

    public final boolean a(bqj bqjVar, com.google.android.gms.internal.ads.ac acVar, int i) {
        wo woVarH;
        if (!X()) {
            return false;
        }
        ax.e();
        bnb bnbVarN = ax.i().k().n();
        Bundle bundleA = bnbVarN == null ? null : xn.a(bnbVarN);
        this.d.a();
        this.e.L = 0;
        if (((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.bL)).booleanValue()) {
            woVarH = ax.i().k().h();
            ax.m().a(this.e.c, this.e.e, false, woVarH, woVarH != null ? woVarH.d() : null, this.e.f1537b, null);
        } else {
            woVarH = null;
        }
        return a(a(bqjVar, bundleA, woVarH, i), acVar);
    }

    public final boolean a(rj rjVar, com.google.android.gms.internal.ads.ac acVar) {
        xa qmVar;
        this.f1496a = acVar;
        acVar.a("seq_num", rjVar.g);
        acVar.a("request_id", rjVar.v);
        acVar.a("session_id", rjVar.h);
        if (rjVar.f != null) {
            acVar.a("app_version", String.valueOf(rjVar.f.versionCode));
        }
        ay ayVar = this.e;
        ax.a();
        Context context = this.e.c;
        box boxVar = this.i.d;
        if (rjVar.f3425b.c.getBundle("sdk_less_server_data") != null) {
            qmVar = new se(context, rjVar, this, boxVar);
        } else {
            qmVar = new qm(context, rjVar, this, boxVar);
        }
        qmVar.h();
        ayVar.g = qmVar;
        return true;
    }

    @Override // com.google.android.gms.ads.internal.a
    public boolean a(bqj bqjVar, com.google.android.gms.internal.ads.ac acVar) {
        return a(bqjVar, acVar, 1);
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.oj
    public final void b(wk wkVar) {
        super.b(wkVar);
        if (wkVar.o != null) {
            xe.b("Disable the debug gesture detector on the mediation ad frame.");
            if (this.e.f != null) {
                this.e.f.d();
            }
            xe.b("Pinging network fill URLs.");
            ax.y();
            kc.a(this.e.c, this.e.e.f1790a, wkVar, this.e.f1537b, false, wkVar.o.j);
            if (wkVar.r != null && wkVar.r.g != null && wkVar.r.g.size() > 0) {
                xe.b("Pinging urls remotely");
                ax.e().a(this.e.c, wkVar.r.g);
            }
        } else {
            xe.b("Enable the debug gesture detector on the admob ad frame.");
            if (this.e.f != null) {
                this.e.f.c();
            }
        }
        if (wkVar.d != 3 || wkVar.r == null || wkVar.r.f == null) {
            return;
        }
        xe.b("Pinging no fill URLs.");
        ax.y();
        kc.a(this.e.c, this.e.e.f1790a, wkVar, this.e.f1537b, false, wkVar.r.f);
    }

    @Override // com.google.android.gms.ads.internal.a
    protected boolean a(wk wkVar, wk wkVar2) {
        int i;
        if (wkVar != null && wkVar.s != null) {
            wkVar.s.a((jv) null);
        }
        if (wkVar2.s != null) {
            wkVar2.s.a((jv) this);
        }
        int i2 = 0;
        if (wkVar2.r != null) {
            i2 = wkVar2.r.s;
            i = wkVar2.r.t;
        } else {
            i = 0;
        }
        this.e.J.a(i2, i);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.bqa
    public void e() {
        if (this.e.j == null) {
            xe.e("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (this.e.j.r != null && this.e.j.r.c != null) {
            ax.y();
            kc.a(this.e.c, this.e.e.f1790a, this.e.j, this.e.f1537b, false, a(this.e.j.r.c, this.e.j.P));
        }
        if (this.e.j.o != null && this.e.j.o.f != null) {
            ax.y();
            kc.a(this.e.c, this.e.e.f1790a, this.e.j, this.e.f1537b, false, this.e.j.o.f);
        }
        super.e();
    }

    @Override // com.google.android.gms.ads.internal.a
    final boolean a(wk wkVar) {
        bqj bqjVar;
        boolean z = false;
        if (this.f != null) {
            bqjVar = this.f;
            this.f = null;
        } else {
            bqjVar = wkVar.f3543a;
            if (bqjVar.c != null) {
                z = bqjVar.c.getBoolean("_noRefresh", false);
            }
        }
        return a(bqjVar, wkVar, z);
    }

    protected boolean a(bqj bqjVar, wk wkVar, boolean z) {
        if (!z && this.e.d()) {
            if (wkVar.i > 0) {
                this.d.a(bqjVar, wkVar.i);
            } else if (wkVar.r != null && wkVar.r.j > 0) {
                this.d.a(bqjVar, wkVar.r.j);
            } else if (!wkVar.n && wkVar.d == 2) {
                this.d.b(bqjVar);
            }
        }
        return this.d.e();
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public void o() {
        com.google.android.gms.common.internal.i.b("pause must be called on the main UI thread.");
        if (this.e.j != null && this.e.j.f3544b != null && this.e.d()) {
            ax.g();
            xv.a(this.e.j.f3544b);
        }
        if (this.e.j != null && this.e.j.p != null) {
            try {
                this.e.j.p.d();
            } catch (RemoteException unused) {
                xe.e("Could not pause mediation adapter.");
            }
        }
        this.g.c(this.e.j);
        this.d.b();
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public void p() {
        com.google.android.gms.common.internal.i.b("resume must be called on the main UI thread.");
        afu afuVar = (this.e.j == null || this.e.j.f3544b == null) ? null : this.e.j.f3544b;
        if (afuVar != null && this.e.d()) {
            ax.g();
            xv.b(this.e.j.f3544b);
        }
        if (this.e.j != null && this.e.j.p != null) {
            try {
                this.e.j.p.e();
            } catch (RemoteException unused) {
                xe.e("Could not resume mediation adapter.");
            }
        }
        if (afuVar == null || !afuVar.F()) {
            this.d.c();
        }
        this.g.d(this.e.j);
    }

    @Override // com.google.android.gms.ads.internal.a
    protected final boolean c(bqj bqjVar) {
        return super.c(bqjVar) && !this.k;
    }

    protected boolean X() {
        ax.e();
        if (xn.a(this.e.c, "android.permission.INTERNET")) {
            ax.e();
            if (xn.a(this.e.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.n
    public void p_() {
        this.k = false;
        u();
        this.e.l.c();
    }

    @Override // com.google.android.gms.ads.internal.overlay.n
    public void g() {
        this.k = true;
        w();
    }

    @Override // com.google.android.gms.ads.internal.overlay.n
    public final void d() {
        this.g.c(this.e.j);
    }

    @Override // com.google.android.gms.ads.internal.overlay.n
    public final void f() {
        this.g.d(this.e.j);
    }

    public void W() {
        xe.e("Mediated ad does not support onVideoEnd callback");
    }

    public void U() {
        e();
    }

    @Override // com.google.android.gms.internal.ads.jv
    public final void Y() {
        p_();
    }

    @Override // com.google.android.gms.internal.ads.jv
    public final void Z() {
        v();
    }

    @Override // com.google.android.gms.internal.ads.jv
    public final void aa() {
        g();
    }

    @Override // com.google.android.gms.internal.ads.jv
    public final void ab() {
        if (this.e.j != null) {
            String str = this.e.j.q;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74);
            sb.append("Mediation adapter ");
            sb.append(str);
            sb.append(" refreshed, but mediation adapters should never refresh.");
            xe.e(sb.toString());
        }
        a(this.e.j, true);
        b(this.e.j, true);
        x();
    }

    public void V() {
        ac();
    }

    @Override // com.google.android.gms.internal.ads.jv
    public final void b(String str, String str2) {
        a(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.jv
    public final void a(cz czVar, String str) {
        String strB;
        dj djVar = null;
        if (czVar != null) {
            try {
                strB = czVar.b();
            } catch (RemoteException e) {
                xe.c("Unable to call onCustomClick.", e);
                return;
            }
        } else {
            strB = null;
        }
        if (this.e.v != null && strB != null) {
            djVar = this.e.v.get(strB);
        }
        if (djVar == null) {
            xe.e("Mediation adapter invoked onCustomClick but no listeners were set.");
        } else {
            djVar.a(czVar, str);
        }
    }

    private final rj a(bqj bqjVar, Bundle bundle, wo woVar, int i) throws JSONException {
        PackageInfo packageInfoB;
        Bundle bundle2;
        long jA;
        String string;
        JSONArray jSONArrayOptJSONArray;
        ApplicationInfo applicationInfo = this.e.c.getApplicationInfo();
        try {
            packageInfoB = com.google.android.gms.common.b.c.a(this.e.c).b(applicationInfo.packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfoB = null;
        }
        DisplayMetrics displayMetrics = this.e.c.getResources().getDisplayMetrics();
        if (this.e.f == null || this.e.f.getParent() == null) {
            bundle2 = null;
        } else {
            int[] iArr = new int[2];
            this.e.f.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            int width = this.e.f.getWidth();
            int height = this.e.f.getHeight();
            int i4 = (!this.e.f.isShown() || i2 + width <= 0 || i3 + height <= 0 || i2 > displayMetrics.widthPixels || i3 > displayMetrics.heightPixels) ? 0 : 1;
            Bundle bundle3 = new Bundle(5);
            bundle3.putInt("x", i2);
            bundle3.putInt("y", i3);
            bundle3.putInt("width", width);
            bundle3.putInt("height", height);
            bundle3.putInt("visible", i4);
            bundle2 = bundle3;
        }
        this.e.l = ax.i().n().a(ax.l(), this.e.f1537b);
        this.e.l.a(bqjVar);
        ax.e();
        String strA = xn.a(this.e.c, this.e.f, this.e.i);
        if (this.e.q != null) {
            try {
                jA = this.e.q.a();
            } catch (RemoteException unused2) {
                xe.e("Cannot get correlation id, default to 0.");
            }
        } else {
            jA = 0;
        }
        String string2 = UUID.randomUUID().toString();
        Bundle bundleA = ax.i().n().a(this.e.c, this);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i5 = 0; i5 < this.e.w.size(); i5++) {
            String strB = this.e.w.b(i5);
            arrayList.add(strB);
            if (this.e.v.containsKey(strB) && this.e.v.get(strB) != null) {
                arrayList2.add(strB);
            }
        }
        abl ablVarA = xl.a(new bd(this));
        abl ablVarA2 = xl.a(new be(this));
        String strC = woVar != null ? woVar.c() : null;
        if (this.e.I == null || this.e.I.size() <= 0) {
            string = null;
        } else {
            int i6 = packageInfoB != null ? packageInfoB.versionCode : 0;
            if (i6 > ax.i().k().g()) {
                ax.i().k().m();
                ax.i().k().a(i6);
            } else {
                JSONObject jSONObjectL = ax.i().k().l();
                if (jSONObjectL != null && (jSONArrayOptJSONArray = jSONObjectL.optJSONArray(this.e.f1537b)) != null) {
                    string = jSONArrayOptJSONArray.toString();
                }
            }
            string = null;
        }
        bqn bqnVar = this.e.i;
        String str = this.e.f1537b;
        String strE = this.e.l.e();
        String strF = bra.f();
        aar aarVar = this.e.e;
        List<String> list = this.e.I;
        boolean zA = ax.i().k().a();
        int i7 = displayMetrics.widthPixels;
        int i8 = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        List<String> listA = com.google.android.gms.internal.ads.o.a();
        String str2 = this.e.f1536a;
        com.google.android.gms.internal.ads.br brVar = this.e.x;
        String strF2 = this.e.f();
        float fA = ax.j().a();
        boolean zB = ax.j().b();
        ax.e();
        int iJ = xn.j(this.e.c);
        ax.e();
        int iD = xn.d(this.e.f);
        boolean z = this.e.c instanceof Activity;
        boolean zF = ax.i().k().f();
        boolean zC = ax.i().c();
        int iA = ax.C().a();
        ax.e();
        Bundle bundleC = xn.c();
        String strA2 = ax.o().a();
        btc btcVar = this.e.A;
        boolean zB2 = ax.o().b();
        Bundle bundleJ = gr.a().j();
        boolean zE = ax.i().k().e(this.e.f1537b);
        List<Integer> list2 = this.e.C;
        boolean zA2 = com.google.android.gms.common.b.c.a(this.e.c).a();
        boolean zD = ax.i().d();
        ax.g();
        return new rj(bundle2, bqjVar, bqnVar, str, applicationInfo, packageInfoB, strE, strF, aarVar, bundleA, list, arrayList, bundle, zA, i7, i8, f, strA, jA, string2, listA, str2, brVar, strF2, fA, zB, iJ, iD, z, zF, ablVarA, strC, zC, iA, bundleC, strA2, btcVar, zB2, bundleJ, zE, ablVarA2, list2, string, arrayList2, i, zA2, zD, xv.e(), (ArrayList) aaz.a(ax.i().m(), (Object) null, 1000L, TimeUnit.MILLISECONDS), ax.e().m(this.e.c), this.e.z, ax.e().n(this.e.c));
    }

    public final void ac() {
        a(this.e.j, false);
    }

    protected void a(wk wkVar, boolean z) {
        if (wkVar == null) {
            xe.e("Ad state was null when trying to ping impression URLs.");
            return;
        }
        if (wkVar == null) {
            xe.e("Ad state was null when trying to ping impression URLs.");
        } else {
            xe.b("Pinging Impression URLs.");
            if (this.e.l != null) {
                this.e.l.a();
            }
            wkVar.K.a(bou.a.b.AD_IMPRESSION);
            if (wkVar.e != null && !wkVar.D) {
                ax.e();
                xn.a(this.e.c, this.e.e.f1790a, a(wkVar.e, wkVar.P));
                wkVar.D = true;
            }
        }
        if (!wkVar.F || z) {
            if (wkVar.r != null && wkVar.r.d != null) {
                ax.y();
                kc.a(this.e.c, this.e.e.f1790a, wkVar, this.e.f1537b, z, a(wkVar.r.d, wkVar.P));
            }
            if (wkVar.o != null && wkVar.o.g != null) {
                ax.y();
                kc.a(this.e.c, this.e.e.f1790a, wkVar, this.e.f1537b, z, wkVar.o.g);
            }
            wkVar.F = true;
        }
    }

    protected final void b(wk wkVar, boolean z) {
        if (wkVar == null) {
            return;
        }
        if (wkVar != null && wkVar.f != null && !wkVar.E) {
            ax.e();
            xn.a(this.e.c, this.e.e.f1790a, a(wkVar.f));
            wkVar.E = true;
        }
        if (!wkVar.G || z) {
            if (wkVar.r != null && wkVar.r.e != null) {
                ax.y();
                kc.a(this.e.c, this.e.e.f1790a, wkVar, this.e.f1537b, z, a(wkVar.r.e));
            }
            if (wkVar.o != null && wkVar.o.h != null) {
                ax.y();
                kc.a(this.e.c, this.e.e.f1790a, wkVar, this.e.f1537b, z, wkVar.o.h);
            }
            wkVar.G = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final String a() {
        if (this.e.j == null) {
            return null;
        }
        return this.e.j.q;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final String q_() {
        if (this.e.j == null) {
            return null;
        }
        return c(this.e.j);
    }

    static String c(wk wkVar) {
        if (wkVar == null) {
            return null;
        }
        String str = wkVar.q;
        if (("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) && wkVar.o != null) {
            try {
                return new JSONObject(wkVar.o.k).getString("class_name");
            } catch (NullPointerException | JSONException unused) {
            }
        }
        return str;
    }

    public void H() {
        xe.e("showInterstitial is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.aq
    public final void h_() {
        Executor executor = abq.f1816a;
        an anVar = this.d;
        anVar.getClass();
        executor.execute(bb.a(anVar));
    }

    @Override // com.google.android.gms.ads.internal.aq
    public final void i_() {
        Executor executor = abq.f1816a;
        an anVar = this.d;
        anVar.getClass();
        executor.execute(bc.a(anVar));
    }
}
