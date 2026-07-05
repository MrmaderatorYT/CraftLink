package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.oi;
import com.google.android.gms.internal.ads.vv;
import com.google.android.gms.internal.ads.wl;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.xn;
import com.google.android.gms.internal.ads.zzbgq;

/* loaded from: classes.dex */
final class bi implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ wl f1549a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ vv f1550b;
    final /* synthetic */ bf c;
    private final /* synthetic */ com.google.android.gms.internal.ads.ac d;

    bi(bf bfVar, wl wlVar, vv vvVar, com.google.android.gms.internal.ads.ac acVar) {
        this.c = bfVar;
        this.f1549a = wlVar;
        this.f1550b = vvVar;
        this.d = acVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1549a.f3546b.r && this.c.e.D != null) {
            String strA = null;
            if (this.f1549a.f3546b.f3427a != null) {
                ax.e();
                strA = xn.a(this.f1549a.f3546b.f3427a);
            }
            com.google.android.gms.internal.ads.ad adVar = new com.google.android.gms.internal.ads.ad(this.c, strA, this.f1549a.f3546b.f3428b);
            this.c.e.L = 1;
            try {
                this.c.c = false;
                this.c.e.D.a(adVar);
                return;
            } catch (RemoteException e) {
                xe.d("#007 Could not call remote method.", e);
                this.c.c = true;
            }
        }
        bu buVar = new bu(this.c.e.c, this.f1550b, this.f1549a.f3546b.E);
        try {
            afu afuVarA = this.c.a(this.f1549a, buVar, this.f1550b);
            afuVarA.f(this.c.e.k.f3546b.V);
            afuVarA.setOnTouchListener(new bk(this, buVar));
            afuVarA.setOnClickListener(new bl(this, buVar));
            this.c.e.L = 0;
            ay ayVar = this.c.e;
            ax.d();
            ayVar.h = oi.a(this.c.e.c, this.c, this.f1549a, this.c.e.d, afuVarA, this.c.j, this.c, this.d);
        } catch (zzbgq e2) {
            xe.b("Could not obtain webview.", e2);
            xn.f3583a.post(new bj(this));
        }
    }
}
