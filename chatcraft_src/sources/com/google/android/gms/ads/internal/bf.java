package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.aar;
import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.aga;
import com.google.android.gms.internal.ads.ahh;
import com.google.android.gms.internal.ads.bqn;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.ni;
import com.google.android.gms.internal.ads.oi;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.vv;
import com.google.android.gms.internal.ads.wk;
import com.google.android.gms.internal.ads.wl;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.xn;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class bf extends ba implements g, ni {
    private boolean k;

    public bf(Context context, bqn bqnVar, String str, kk kkVar, aar aarVar, bt btVar) {
        super(context, bqnVar, str, kkVar, aarVar, btVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected afu a(wl wlVar, bu buVar, vv vvVar) {
        View nextView = this.e.f.getNextView();
        if (nextView instanceof afu) {
            ((afu) nextView).destroy();
        }
        if (nextView != 0) {
            this.e.f.removeView(nextView);
        }
        ax.f();
        afu afuVarA = aga.a(this.e.c, ahh.a(this.e.i), this.e.i.f2974a, false, false, this.e.d, this.e.e, this.f1496a, this, this.i, wlVar.i);
        if (this.e.i.g == null) {
            a(afuVarA.getView());
        }
        afuVarA.w().a(this, this, this, this, this, false, null, buVar, this, vvVar);
        a(afuVarA);
        afuVarA.b(wlVar.f3545a.v);
        return afuVarA;
    }

    protected final void a(afu afuVar) {
        afuVar.a("/trackActiveViewUnit", new bg(this));
    }

    @Override // com.google.android.gms.ads.internal.a
    protected void x() {
        super.x();
        if (this.k) {
            if (((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.bC)).booleanValue()) {
                b(this.e.j.f3544b);
            }
        }
    }

    final void b(afu afuVar) {
        if (this.e.j != null) {
            this.g.a(this.e.i, this.e.j, afuVar.getView(), afuVar);
            this.k = false;
        } else {
            this.k = true;
            xe.e("Request to enable ActiveView before adState is available.");
        }
    }

    @Override // com.google.android.gms.ads.internal.a
    protected void a(wl wlVar, com.google.android.gms.internal.ads.ac acVar) {
        if (wlVar.e != -2) {
            xn.f3583a.post(new bh(this, wlVar));
            return;
        }
        if (wlVar.d != null) {
            this.e.i = wlVar.d;
        }
        if (wlVar.f3546b.g && !wlVar.f3546b.z) {
            this.e.L = 0;
            ay ayVar = this.e;
            ax.d();
            ayVar.h = oi.a(this.e.c, this, wlVar, this.e.d, null, this.j, this, acVar);
            return;
        }
        xn.f3583a.post(new bi(this, wlVar, this.i.c.a(this.e.c, this.e.e, wlVar.f3546b), acVar));
    }

    @Override // com.google.android.gms.ads.internal.ba, com.google.android.gms.ads.internal.a
    protected boolean a(wk wkVar, wk wkVar2) {
        if (this.e.d() && this.e.f != null) {
            this.e.f.a().c(wkVar2.A);
        }
        try {
            if (wkVar2.f3544b != null && !wkVar2.n && wkVar2.M && !wkVar2.f3543a.c.containsKey("sdk_less_server_data")) {
                try {
                    wkVar2.f3544b.L();
                } catch (Throwable unused) {
                    xe.a("Could not render test Ad label.");
                }
            }
        } catch (RuntimeException unused2) {
            xe.a("Could not render test AdLabel.");
        }
        if (wkVar2 != null && wkVar2.f3544b != null) {
            wkVar2.f3544b.f(wkVar2.P);
        }
        return super.a(wkVar, wkVar2);
    }

    @Override // com.google.android.gms.ads.internal.a, com.google.android.gms.internal.ads.brs
    public final void a(com.google.android.gms.internal.ads.ai aiVar) {
        com.google.android.gms.common.internal.i.b("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.e.D = aiVar;
    }

    @Override // com.google.android.gms.ads.internal.g
    public final void a_(View view) {
        this.e.K = view;
        b(new wk(this.e.k, null, null, null, null, null, null, null));
    }

    @Override // com.google.android.gms.ads.internal.g
    public final void f_() {
        e();
    }

    @Override // com.google.android.gms.ads.internal.g
    public final void g_() {
        ac();
        n();
    }

    protected final boolean K() {
        return (this.e.k == null || this.e.k.f3546b == null || !this.e.k.f3546b.Q) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.ni
    public final void a(int i, int i2, int i3, int i4) {
        w();
    }

    @Override // com.google.android.gms.internal.ads.ni
    public final void L() {
        u();
    }
}
