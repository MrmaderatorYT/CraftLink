package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class aev implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ aeu f1913a;

    aev(aeu aeuVar) {
        this.f1913a = aeuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.ax.C().b(this.f1913a);
    }
}
