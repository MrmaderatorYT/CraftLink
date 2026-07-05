package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes.dex */
final class btu implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ btt f3027a;

    btu(btt bttVar) {
        this.f3027a = bttVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3027a.f3026a != null) {
            try {
                this.f3027a.f3026a.a(1);
            } catch (RemoteException e) {
                aan.c("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
