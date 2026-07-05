package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes.dex */
public final class lg extends bsx {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3237a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private volatile bsz f3238b;

    @Override // com.google.android.gms.internal.ads.bsw
    public final void a() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final void b() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final void a(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final boolean c() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final int d() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final float e() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final float f() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final void a(bsz bszVar) {
        synchronized (this.f3237a) {
            this.f3238b = bszVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final bsz g() {
        bsz bszVar;
        synchronized (this.f3237a) {
            bszVar = this.f3238b;
        }
        return bszVar;
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final float h() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final boolean i() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final boolean j() throws RemoteException {
        throw new RemoteException();
    }
}
