package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

@qj
/* loaded from: classes.dex */
public abstract class od implements ahc, yi<Void> {

    /* renamed from: a, reason: collision with root package name */
    protected final Context f3308a;

    /* renamed from: b, reason: collision with root package name */
    protected final afu f3309b;
    protected rm c;
    private final oj d;
    private final wl e;
    private Runnable f;
    private final Object g = new Object();
    private AtomicBoolean h = new AtomicBoolean(true);

    protected od(Context context, wl wlVar, afu afuVar, oj ojVar) {
        this.f3308a = context;
        this.e = wlVar;
        this.c = this.e.f3546b;
        this.f3309b = afuVar;
        this.d = ojVar;
    }

    protected abstract void a();

    @Override // com.google.android.gms.internal.ads.ahc
    public final void a(boolean z) {
        xe.b("WebView finished loading.");
        if (this.h.getAndSet(false)) {
            a(z ? -2 : 0);
            xn.f3583a.removeCallbacks(this.f);
        }
    }

    @Override // com.google.android.gms.internal.ads.yi
    public void b() {
        if (this.h.getAndSet(false)) {
            this.f3309b.stopLoading();
            com.google.android.gms.ads.internal.ax.g();
            xv.a(this.f3309b);
            a(-1);
            xn.f3583a.removeCallbacks(this.f);
        }
    }

    protected void a(int i) {
        if (i != -2) {
            this.c = new rm(i, this.c.j);
        }
        this.f3309b.q();
        oj ojVar = this.d;
        ri riVar = this.e.f3545a;
        ojVar.b(new wk(riVar.c, this.f3309b, this.c.c, i, this.c.e, this.c.i, this.c.k, this.c.j, riVar.i, this.c.g, null, null, null, null, null, this.c.h, this.e.d, this.c.f, this.e.f, this.c.m, this.c.n, this.e.h, null, this.c.A, this.c.B, this.c.C, this.c.D, this.c.E, null, this.c.H, this.c.L, this.e.i, this.e.f3546b.O, this.e.j, this.e.f3546b.Q, this.c.R, this.e.f3546b.S, this.e.f3546b.T, this.e.f3546b.V));
    }

    @Override // com.google.android.gms.internal.ads.yi
    public final /* synthetic */ Void c() {
        com.google.android.gms.common.internal.i.b("Webview render task needs to be called on UI thread.");
        this.f = new oe(this);
        xn.f3583a.postDelayed(this.f, ((Long) bra.e().a(o.bc)).longValue());
        a();
        return null;
    }
}
