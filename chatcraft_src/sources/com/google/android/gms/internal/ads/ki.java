package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes.dex */
final class ki implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ka f3230a;

    ki(kh khVar, ka kaVar) {
        this.f3230a = kaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3230a.c.c();
        } catch (RemoteException e) {
            xe.c("Could not destroy mediation adapter.", e);
        }
    }
}
