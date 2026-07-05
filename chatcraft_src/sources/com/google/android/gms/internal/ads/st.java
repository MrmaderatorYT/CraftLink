package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes.dex */
final class st implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ri f3456a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ rt f3457b;
    private final /* synthetic */ sr c;

    st(sr srVar, ri riVar, rt rtVar) {
        this.c = srVar;
        this.f3456a = riVar;
        this.f3457b = rtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        rm rmVar;
        try {
            rmVar = this.c.a(this.f3456a);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.ax.i().a(e, "AdRequestServiceImpl.loadAdAsync");
            xe.c("Could not fetch ad response due to an Exception.", e);
            rmVar = null;
        }
        if (rmVar == null) {
            rmVar = new rm(0);
        }
        try {
            this.f3457b.a(rmVar);
        } catch (RemoteException e2) {
            xe.c("Fail to forward ad response.", e2);
        }
    }
}
