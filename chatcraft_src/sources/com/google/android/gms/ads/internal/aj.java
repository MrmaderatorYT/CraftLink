package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.xe;

/* loaded from: classes.dex */
final class aj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.ads.bb f1513a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ad f1514b;

    aj(ad adVar, com.google.android.gms.internal.ads.bb bbVar) {
        this.f1514b = adVar;
        this.f1513a = bbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f1514b.e.t != null) {
                this.f1514b.e.t.a(this.f1513a);
                this.f1514b.a(this.f1513a.q());
            }
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }
}
