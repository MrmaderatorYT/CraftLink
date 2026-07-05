package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.xe;

/* loaded from: classes.dex */
final class bq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.ads.au f1559a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bn f1560b;

    bq(bn bnVar, com.google.android.gms.internal.ads.au auVar) {
        this.f1560b = bnVar;
        this.f1559a = auVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f1560b.e.r != null) {
                this.f1560b.e.r.a(this.f1559a);
                this.f1560b.a(this.f1559a.n());
            }
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }
}
