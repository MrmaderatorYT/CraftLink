package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@qj
/* loaded from: classes.dex */
public final class oq extends xa {

    /* renamed from: a, reason: collision with root package name */
    private final oj f3322a;

    /* renamed from: b, reason: collision with root package name */
    private final rm f3323b;
    private final wl c;
    private final ot d;
    private final Object e;
    private Future<wk> f;

    public oq(Context context, com.google.android.gms.ads.internal.ad adVar, wl wlVar, axe axeVar, oj ojVar, ac acVar) {
        this(wlVar, ojVar, new ot(context, adVar, new yz(context), axeVar, wlVar, acVar));
    }

    private oq(wl wlVar, oj ojVar, ot otVar) {
        this.e = new Object();
        this.c = wlVar;
        this.f3323b = wlVar.f3546b;
        this.f3322a = ojVar;
        this.d = otVar;
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void a() throws ExecutionException, InterruptedException, TimeoutException {
        int i;
        wk wkVar = null;
        try {
            try {
                synchronized (this.e) {
                    this.f = xl.a(this.d);
                }
                wkVar = this.f.get(60000L, TimeUnit.MILLISECONDS);
                i = -2;
            } catch (InterruptedException | CancellationException | ExecutionException unused) {
                i = 0;
            }
        } catch (TimeoutException unused2) {
            xe.e("Timed out waiting for native ad.");
            this.f.cancel(true);
            i = 2;
        }
        xn.f3583a.post(new or(this, wkVar != null ? wkVar : new wk(this.c.f3545a.c, null, null, i, null, null, this.f3323b.k, this.f3323b.j, this.c.f3545a.i, false, null, null, null, null, null, this.f3323b.h, this.c.d, this.f3323b.f, this.c.f, this.f3323b.m, this.f3323b.n, this.c.h, null, null, null, null, this.c.f3546b.D, this.c.f3546b.E, null, null, this.f3323b.L, this.c.i, this.c.f3546b.O, false, this.c.f3546b.Q, null, this.c.f3546b.S, this.c.f3546b.T, this.c.f3546b.V)));
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void c_() {
        synchronized (this.e) {
            if (this.f != null) {
                this.f.cancel(true);
            }
        }
    }
}
