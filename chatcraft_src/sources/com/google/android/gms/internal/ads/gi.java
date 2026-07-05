package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes.dex */
final class gi implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ gj f3096a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ gk f3097b;

    gi(fj fjVar, gj gjVar, gk gkVar) {
        this.f3096a = gjVar;
        this.f3097b = gkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3096a.a(this.f3097b);
        } catch (RemoteException e) {
            xe.c("Could not propagate interstitial ad event.", e);
        }
    }
}
