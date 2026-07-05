package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
final class xr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f3591a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ xn f3592b;

    xr(xn xnVar, Context context) {
        this.f3592b = xnVar;
        this.f3591a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f3592b.f3584b) {
            this.f3592b.d = xn.d(this.f3591a);
            this.f3592b.f3584b.notifyAll();
        }
    }
}
