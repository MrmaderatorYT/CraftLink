package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import java.util.concurrent.Future;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
/* loaded from: classes.dex */
public final class un extends xa implements ut, uw, va {

    /* renamed from: a, reason: collision with root package name */
    public final String f3493a;

    /* renamed from: b, reason: collision with root package name */
    private final wl f3494b;
    private final Context c;
    private final vb d;
    private final uw e;
    private final String g;
    private final jt h;
    private final long i;
    private uq l;
    private Future m;
    private volatile com.google.android.gms.ads.internal.gmsg.j n;
    private int j = 0;
    private int k = 3;
    private final Object f = new Object();

    public un(Context context, String str, String str2, jt jtVar, wl wlVar, vb vbVar, uw uwVar, long j) {
        this.c = context;
        this.f3493a = str;
        this.g = str2;
        this.h = jtVar;
        this.f3494b = wlVar;
        this.d = vbVar;
        this.e = uwVar;
        this.i = j;
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void c_() {
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void a() {
        if (this.d == null || this.d.b() == null || this.d.a() == null) {
            return;
        }
        uv uvVarB = this.d.b();
        uvVarB.a((uw) null);
        uvVarB.a((ut) this);
        uvVarB.a((va) this);
        bqj bqjVar = this.f3494b.f3545a.c;
        kn knVarA = this.d.a();
        try {
            if (knVarA.g()) {
                aac.f1778a.post(new uo(this, bqjVar, knVarA));
            } else {
                aac.f1778a.post(new up(this, knVarA, bqjVar, uvVarB));
            }
        } catch (RemoteException e) {
            xe.c("Fail to check if adapter is initialized.", e);
            a(this.f3493a, 0);
        }
        long jB = com.google.android.gms.ads.internal.ax.l().b();
        while (true) {
            synchronized (this.f) {
                if (this.j != 0) {
                    this.l = new us().a(com.google.android.gms.ads.internal.ax.l().b() - jB).a(1 == this.j ? 6 : this.k).a(this.f3493a).b(this.h.d).a();
                } else if (!a(jB)) {
                    this.l = new us().a(this.k).a(com.google.android.gms.ads.internal.ax.l().b() - jB).a(this.f3493a).b(this.h.d).a();
                }
            }
        }
        uvVarB.a((uw) null);
        uvVarB.a((ut) null);
        if (this.j == 1) {
            this.e.a(this.f3493a);
        } else {
            this.e.a(this.f3493a, this.k);
        }
    }

    public final Future d() {
        if (this.m != null) {
            return this.m;
        }
        abl ablVar = (abl) c();
        this.m = ablVar;
        return ablVar;
    }

    public final uq e() {
        uq uqVar;
        synchronized (this.f) {
            uqVar = this.l;
        }
        return uqVar;
    }

    public final jt f() {
        return this.h;
    }

    private final boolean a(long j) throws InterruptedException {
        long jB = this.i - (com.google.android.gms.ads.internal.ax.l().b() - j);
        if (jB <= 0) {
            this.k = 4;
            return false;
        }
        try {
            this.f.wait(jB);
            return true;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            this.k = 5;
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.uw
    public final void a(String str) {
        synchronized (this.f) {
            this.j = 1;
            this.f.notify();
        }
    }

    @Override // com.google.android.gms.internal.ads.uw
    public final void a(String str, int i) {
        synchronized (this.f) {
            this.j = 2;
            this.k = i;
            this.f.notify();
        }
    }

    @Override // com.google.android.gms.internal.ads.ut
    public final void g() {
        a(this.f3494b.f3545a.c, this.d.a());
    }

    @Override // com.google.android.gms.internal.ads.ut
    public final void a(int i) {
        a(this.f3493a, 0);
    }

    public final void a(com.google.android.gms.ads.internal.gmsg.j jVar) {
        this.n = jVar;
    }

    @Override // com.google.android.gms.internal.ads.va
    public final void a(Bundle bundle) {
        com.google.android.gms.ads.internal.gmsg.j jVar = this.n;
        if (jVar != null) {
            jVar.a(BuildConfig.FLAVOR, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(bqj bqjVar, kn knVar) {
        this.d.b().a((uw) this);
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.f3493a)) {
                knVar.a(bqjVar, this.g, this.h.f3209a);
            } else {
                knVar.a(bqjVar, this.g);
            }
        } catch (RemoteException e) {
            xe.c("Fail to load ad from adapter.", e);
            a(this.f3493a, 0);
        }
    }
}
