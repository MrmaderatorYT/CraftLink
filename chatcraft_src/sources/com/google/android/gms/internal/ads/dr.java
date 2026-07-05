package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class dr extends azf implements dp {
    dr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.dp
    public final void a(brs brsVar, com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, brsVar);
        azh.a(parcelZ, aVar);
        b(1, parcelZ);
    }
}
