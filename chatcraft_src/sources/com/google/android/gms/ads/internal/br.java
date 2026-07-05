package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.xe;

/* loaded from: classes.dex */
final class br implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.ads.aw f1561a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bn f1562b;

    br(bn bnVar, com.google.android.gms.internal.ads.aw awVar) {
        this.f1562b = bnVar;
        this.f1561a = awVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f1562b.e.s != null) {
                this.f1562b.e.s.a(this.f1561a);
                this.f1562b.a(this.f1561a.n());
            }
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }
}
