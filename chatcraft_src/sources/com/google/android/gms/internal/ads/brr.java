package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class brr extends azf implements brq {
    brr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
    }

    @Override // com.google.android.gms.internal.ads.brq
    public final IBinder a(com.google.android.gms.dynamic.a aVar, String str, kk kkVar, int i) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        parcelZ.writeString(str);
        azh.a(parcelZ, kkVar);
        parcelZ.writeInt(14300000);
        Parcel parcelA = a(1, parcelZ);
        IBinder strongBinder = parcelA.readStrongBinder();
        parcelA.recycle();
        return strongBinder;
    }
}
