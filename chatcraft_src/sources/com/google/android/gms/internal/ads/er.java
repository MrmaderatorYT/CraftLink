package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class er extends azf implements eq {
    er(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    @Override // com.google.android.gms.internal.ads.eq
    public final void a(ek ekVar, eo eoVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, ekVar);
        azh.a(parcelZ, eoVar);
        c(2, parcelZ);
    }
}
