package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class bso extends azf implements bsn {
    bso(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.bsn
    public final IBinder a(com.google.android.gms.dynamic.a aVar, int i) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        parcelZ.writeInt(14300000);
        Parcel parcelA = a(1, parcelZ);
        IBinder strongBinder = parcelA.readStrongBinder();
        parcelA.recycle();
        return strongBinder;
    }
}
