package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.xe;

/* loaded from: classes.dex */
final class ak implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.ads.aw f1515a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ad f1516b;

    ak(ad adVar, com.google.android.gms.internal.ads.aw awVar) {
        this.f1516b = adVar;
        this.f1515a = awVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f1516b.e.s != null) {
                this.f1516b.e.s.a(this.f1515a);
                this.f1516b.a(this.f1515a.n());
            }
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }
}
