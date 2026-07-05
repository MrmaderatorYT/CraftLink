package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.SystemClock;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
public abstract class of extends xa {

    /* renamed from: a, reason: collision with root package name */
    protected final oj f3311a;

    /* renamed from: b, reason: collision with root package name */
    protected final Context f3312b;
    protected final Object c;
    protected final Object d;
    protected final wl e;

    @GuardedBy("mLock")
    protected rm f;

    protected of(Context context, wl wlVar, oj ojVar) {
        super(true);
        this.c = new Object();
        this.d = new Object();
        this.f3312b = context;
        this.e = wlVar;
        this.f = wlVar.f3546b;
        this.f3311a = ojVar;
    }

    protected abstract wk a(int i);

    protected abstract void a(long j);

    @Override // com.google.android.gms.internal.ads.xa
    public void c_() {
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void a() {
        synchronized (this.c) {
            xe.b("AdRendererBackgroundTask started.");
            int i = this.e.e;
            try {
                a(SystemClock.elapsedRealtime());
            } catch (zzapk e) {
                int iA = e.a();
                if (iA == 3 || iA == -1) {
                    xe.d(e.getMessage());
                } else {
                    xe.e(e.getMessage());
                }
                if (this.f == null) {
                    this.f = new rm(iA);
                } else {
                    this.f = new rm(iA, this.f.j);
                }
                xn.f3583a.post(new og(this));
                i = iA;
            }
            xn.f3583a.post(new oh(this, a(i)));
        }
    }
}
