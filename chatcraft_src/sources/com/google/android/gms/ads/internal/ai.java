package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.xe;

/* loaded from: classes.dex */
final class ai implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.ads.au f1511a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ad f1512b;

    ai(ad adVar, com.google.android.gms.internal.ads.au auVar) {
        this.f1512b = adVar;
        this.f1511a = auVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f1512b.e.r != null) {
                this.f1512b.e.r.a(this.f1511a);
                this.f1512b.a(this.f1511a.n());
            }
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }
}
