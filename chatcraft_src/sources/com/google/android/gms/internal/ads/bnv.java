package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
public final class bnv {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f2887a = new bnw(this);

    /* renamed from: b, reason: collision with root package name */
    private final Object f2888b = new Object();

    @GuardedBy("mLock")
    private boc c;

    @GuardedBy("mLock")
    private Context d;

    @GuardedBy("mLock")
    private boh e;

    public final void a(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.f2888b) {
            if (this.d != null) {
                return;
            }
            this.d = context.getApplicationContext();
            if (((Boolean) bra.e().a(o.bW)).booleanValue()) {
                b();
            } else {
                if (((Boolean) bra.e().a(o.bV)).booleanValue()) {
                    com.google.android.gms.ads.internal.ax.h().a(new bnx(this));
                }
            }
        }
    }

    public final void a() {
        if (((Boolean) bra.e().a(o.bX)).booleanValue()) {
            synchronized (this.f2888b) {
                b();
                com.google.android.gms.ads.internal.ax.e();
                xn.f3583a.removeCallbacks(this.f2887a);
                com.google.android.gms.ads.internal.ax.e();
                xn.f3583a.postDelayed(this.f2887a, ((Long) bra.e().a(o.bY)).longValue());
            }
        }
    }

    public final boa a(bod bodVar) {
        synchronized (this.f2888b) {
            if (this.e == null) {
                return new boa();
            }
            try {
                return this.e.a(bodVar);
            } catch (RemoteException e) {
                xe.b("Unable to call into cache service.", e);
                return new boa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        synchronized (this.f2888b) {
            if (this.d != null && this.c == null) {
                this.c = new boc(this.d, com.google.android.gms.ads.internal.ax.u().a(), new bny(this), new bnz(this));
                this.c.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        synchronized (this.f2888b) {
            if (this.c == null) {
                return;
            }
            if (this.c.f() || this.c.g()) {
                this.c.h();
            }
            this.c = null;
            this.e = null;
            Binder.flushPendingCommands();
        }
    }

    static /* synthetic */ boc a(bnv bnvVar, boc bocVar) {
        bnvVar.c = null;
        return null;
    }
}
