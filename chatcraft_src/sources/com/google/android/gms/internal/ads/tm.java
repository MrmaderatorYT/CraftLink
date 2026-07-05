package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@qj
/* loaded from: classes.dex */
public final class tm {

    /* renamed from: a, reason: collision with root package name */
    private static final kj f3477a = new kj();

    /* renamed from: b, reason: collision with root package name */
    private final kk f3478b;
    private final com.google.android.gms.ads.internal.ay c;
    private final Map<String, vb> d = new HashMap();
    private final uu e;
    private final com.google.android.gms.ads.internal.gmsg.j f;
    private final oj g;

    public tm(com.google.android.gms.ads.internal.ay ayVar, kk kkVar, uu uuVar, com.google.android.gms.ads.internal.gmsg.j jVar, oj ojVar) {
        this.c = ayVar;
        this.f3478b = kkVar;
        this.e = uuVar;
        this.f = jVar;
        this.g = ojVar;
    }

    public static boolean a(wk wkVar, wk wkVar2) {
        return true;
    }

    public final com.google.android.gms.ads.internal.gmsg.j a() {
        return this.f;
    }

    public final oj b() {
        return this.g;
    }

    public final vb a(String str) {
        vb vbVar;
        vb vbVar2 = this.d.get(str);
        if (vbVar2 != null) {
            return vbVar2;
        }
        try {
            kk kkVar = this.f3478b;
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                kkVar = f3477a;
            }
            vbVar = new vb(kkVar.a(str), this.e);
        } catch (Exception e) {
            e = e;
        }
        try {
            this.d.put(str, vbVar);
            return vbVar;
        } catch (Exception e2) {
            e = e2;
            vbVar2 = vbVar;
            String strValueOf = String.valueOf(str);
            xe.c(strValueOf.length() != 0 ? "Fail to instantiate adapter ".concat(strValueOf) : new String("Fail to instantiate adapter "), e);
            return vbVar2;
        }
    }

    public final void c() {
        this.c.L = 0;
        com.google.android.gms.ads.internal.ay ayVar = this.c;
        com.google.android.gms.ads.internal.ax.d();
        ux uxVar = new ux(this.c.c, this.c.k, this);
        String strValueOf = String.valueOf(uxVar.getClass().getName());
        xe.b(strValueOf.length() != 0 ? "AdRenderer: ".concat(strValueOf) : new String("AdRenderer: "));
        uxVar.c();
        ayVar.h = uxVar;
    }

    public final void a(boolean z) {
        vb vbVarA = a(this.c.j.q);
        if (vbVarA == null || vbVarA.a() == null) {
            return;
        }
        try {
            vbVarA.a().a(z);
            vbVarA.a().f();
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }

    public final void d() {
        com.google.android.gms.common.internal.i.b("pause must be called on the main UI thread.");
        Iterator<String> it = this.d.keySet().iterator();
        while (it.hasNext()) {
            try {
                vb vbVar = this.d.get(it.next());
                if (vbVar != null && vbVar.a() != null) {
                    vbVar.a().d();
                }
            } catch (RemoteException e) {
                xe.d("#007 Could not call remote method.", e);
            }
        }
    }

    public final void e() {
        com.google.android.gms.common.internal.i.b("resume must be called on the main UI thread.");
        Iterator<String> it = this.d.keySet().iterator();
        while (it.hasNext()) {
            try {
                vb vbVar = this.d.get(it.next());
                if (vbVar != null && vbVar.a() != null) {
                    vbVar.a().e();
                }
            } catch (RemoteException e) {
                xe.d("#007 Could not call remote method.", e);
            }
        }
    }

    public final void f() {
        com.google.android.gms.common.internal.i.b("destroy must be called on the main UI thread.");
        Iterator<String> it = this.d.keySet().iterator();
        while (it.hasNext()) {
            try {
                vb vbVar = this.d.get(it.next());
                if (vbVar != null && vbVar.a() != null) {
                    vbVar.a().c();
                }
            } catch (RemoteException e) {
                xe.d("#007 Could not call remote method.", e);
            }
        }
    }

    public final void a(Context context) {
        Iterator<vb> it = this.d.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().a().a(com.google.android.gms.dynamic.b.a(context));
            } catch (RemoteException e) {
                xe.b("Unable to call Adapter.onContextChanged.", e);
            }
        }
    }

    public final void g() {
        if (this.c.j == null || this.c.j.o == null) {
            return;
        }
        com.google.android.gms.ads.internal.ax.y();
        kc.a(this.c.c, this.c.e.f1790a, this.c.j, this.c.f1537b, false, this.c.j.o.l);
    }

    public final void h() {
        if (this.c.j == null || this.c.j.o == null) {
            return;
        }
        com.google.android.gms.ads.internal.ax.y();
        kc.a(this.c.c, this.c.e.f1790a, this.c.j, this.c.f1537b, false, this.c.j.o.n);
    }

    public final vh a(vh vhVar) {
        if (this.c.j != null && this.c.j.r != null && !TextUtils.isEmpty(this.c.j.r.k)) {
            vhVar = new vh(this.c.j.r.k, this.c.j.r.l);
        }
        if (this.c.j != null && this.c.j.o != null) {
            com.google.android.gms.ads.internal.ax.y();
            kc.a(this.c.c, this.c.e.f1790a, this.c.j.o.m, this.c.G, this.c.H, vhVar);
        }
        return vhVar;
    }
}
