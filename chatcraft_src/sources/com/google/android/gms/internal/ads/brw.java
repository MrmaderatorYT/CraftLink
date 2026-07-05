package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class brw extends azf implements brv {
    brw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.brv
    public final IBinder a(com.google.android.gms.dynamic.a aVar, bqn bqnVar, String str, kk kkVar, int i, int i2) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, bqnVar);
        parcelZ.writeString(str);
        azh.a(parcelZ, kkVar);
        parcelZ.writeInt(14300000);
        parcelZ.writeInt(i2);
        Parcel parcelA = a(2, parcelZ);
        IBinder strongBinder = parcelA.readStrongBinder();
        parcelA.recycle();
        return strongBinder;
    }
}
