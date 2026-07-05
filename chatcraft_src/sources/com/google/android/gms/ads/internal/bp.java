package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.xe;

/* loaded from: classes.dex */
final class bp implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.ads.bb f1557a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bn f1558b;

    bp(bn bnVar, com.google.android.gms.internal.ads.bb bbVar) {
        this.f1558b = bnVar;
        this.f1557a = bbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f1558b.e.t != null) {
                this.f1558b.e.t.a(this.f1557a);
                this.f1558b.a(this.f1557a.q());
            }
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }
}
