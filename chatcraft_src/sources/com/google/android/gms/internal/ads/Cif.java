package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.ads.if, reason: invalid class name */
/* loaded from: classes.dex */
final class Cif implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ip f3163a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ hk f3164b;
    private final /* synthetic */ hv c;

    Cif(hv hvVar, ip ipVar, hk hkVar) {
        this.c = hvVar;
        this.f3163a = ipVar;
        this.f3164b = hkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.c.f3146a) {
            if (this.f3163a.e() != -1 && this.f3163a.e() != 1) {
                this.f3163a.d();
                Executor executor = abq.f1816a;
                hk hkVar = this.f3164b;
                hkVar.getClass();
                executor.execute(ig.a(hkVar));
                xe.a("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}
