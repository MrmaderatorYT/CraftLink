package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.wk;
import com.google.android.gms.internal.ads.xe;

/* loaded from: classes.dex */
final class al implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1517a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ wk f1518b;
    private final /* synthetic */ ad c;

    al(ad adVar, String str, wk wkVar) {
        this.c = adVar;
        this.f1517a = str;
        this.f1518b = wkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.c.e.w.get(this.f1517a).a((com.google.android.gms.internal.ads.ay) this.f1518b.C);
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }
}
