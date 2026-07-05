package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes.dex */
final class btx implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ btw f3029a;

    btx(btw btwVar) {
        this.f3029a = btwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3029a.f3028a != null) {
            try {
                this.f3029a.f3028a.a(1);
            } catch (RemoteException e) {
                aan.c("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
