package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.cz;
import com.google.android.gms.internal.ads.xe;

/* loaded from: classes.dex */
final class am implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ cz f1519a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ad f1520b;

    am(ad adVar, cz czVar) {
        this.f1520b = adVar;
        this.f1519a = czVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f1520b.e.w.get(this.f1519a.b()).a(this.f1519a);
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }
}
