package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

/* loaded from: classes.dex */
final class aq implements com.google.android.gms.ads.internal.gmsg.ac<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ap f2158a;

    aq(ap apVar) {
        this.f2158a = apVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final void zza(Object obj, Map<String, String> map) {
        try {
            this.f2158a.f2134b = Long.valueOf(Long.parseLong(map.get("timestamp")));
        } catch (NumberFormatException unused) {
            xe.c("Failed to call parse unconfirmedClickTimestamp.");
        }
        this.f2158a.f2133a = map.get("id");
        String str = map.get("asset_id");
        if (this.f2158a.e == null) {
            xe.b("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            this.f2158a.e.a(str);
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }
}
