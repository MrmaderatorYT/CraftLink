package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class ud extends azf implements ub {
    ud(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
    }

    @Override // com.google.android.gms.internal.ads.ub
    public final IBinder a(com.google.android.gms.dynamic.a aVar, kk kkVar, int i) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, kkVar);
        parcelZ.writeInt(14300000);
        Parcel parcelA = a(1, parcelZ);
        IBinder strongBinder = parcelA.readStrongBinder();
        parcelA.recycle();
        return strongBinder;
    }
}
