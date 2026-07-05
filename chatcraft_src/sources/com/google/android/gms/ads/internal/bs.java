package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.cz;
import com.google.android.gms.internal.ads.xe;

/* loaded from: classes.dex */
final class bs implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ cz f1563a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bn f1564b;

    bs(bn bnVar, cz czVar) {
        this.f1564b = bnVar;
        this.f1563a = czVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f1564b.e.w.get(this.f1563a.b()).a(this.f1563a);
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }
}
