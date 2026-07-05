package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes.dex */
final class bts implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ btr f3025a;

    bts(btr btrVar) {
        this.f3025a = btrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3025a.f3024a.f3023a != null) {
            try {
                this.f3025a.f3024a.f3023a.a(1);
            } catch (RemoteException e) {
                aan.c("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
