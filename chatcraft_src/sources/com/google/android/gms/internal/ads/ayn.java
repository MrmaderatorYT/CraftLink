package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class ayn extends azd {
    public ayn(axt axtVar, String str, String str2, akp akpVar, int i, int i2) {
        super(axtVar, str, str2, akpVar, i, 24);
    }

    @Override // com.google.android.gms.internal.ads.azd
    /* renamed from: b */
    public final Void call() throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f2414a.b()) {
            return super.call();
        }
        if (!this.f2414a.g()) {
            return null;
        }
        c();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.azd
    protected final void a() throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f2414a.g()) {
            c();
            return;
        }
        synchronized (this.f2415b) {
            this.f2415b.U = (String) this.c.invoke(null, this.f2414a.a());
        }
    }

    private final void c() throws ExecutionException, InterruptedException, TimeoutException {
        AdvertisingIdClient advertisingIdClientM = this.f2414a.m();
        if (advertisingIdClientM == null) {
            return;
        }
        try {
            AdvertisingIdClient.Info info = advertisingIdClientM.getInfo();
            String strA = aya.a(info.getId());
            if (strA != null) {
                synchronized (this.f2415b) {
                    this.f2415b.U = strA;
                    this.f2415b.W = Boolean.valueOf(info.isLimitAdTrackingEnabled());
                    this.f2415b.V = 5;
                }
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.azd, java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return call();
    }
}
