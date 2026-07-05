package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.a;

/* loaded from: classes.dex */
final class lq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ a.EnumC0064a f3254a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ lo f3255b;

    lq(lo loVar, a.EnumC0064a enumC0064a) {
        this.f3255b = loVar;
        this.f3254a = enumC0064a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3255b.f3251a.a(lr.a(this.f3254a));
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }
}
