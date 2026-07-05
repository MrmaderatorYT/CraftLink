package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* loaded from: classes.dex */
final class wi implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f3541a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ abv f3542b;

    wi(wh whVar, Context context, abv abvVar) {
        this.f3541a = context;
        this.f3542b = abvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3542b.b(AdvertisingIdClient.getAdvertisingIdInfo(this.f3541a));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.f3542b.a(e);
            aan.b("Exception while getting advertising Id info", e);
        }
    }
}
