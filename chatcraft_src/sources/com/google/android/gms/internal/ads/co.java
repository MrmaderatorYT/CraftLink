package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class co extends azf implements cm {
    co(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    @Override // com.google.android.gms.internal.ads.cm
    public final void a(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(1, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.cm
    public final void a() {
        b(2, z());
    }

    @Override // com.google.android.gms.internal.ads.cm
    public final void b(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(3, parcelZ);
    }
}
