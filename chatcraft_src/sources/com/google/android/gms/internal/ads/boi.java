package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class boi extends azf implements boh {
    boi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    @Override // com.google.android.gms.internal.ads.boh
    public final boa a(bod bodVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bodVar);
        Parcel parcelA = a(1, parcelZ);
        boa boaVar = (boa) azh.a(parcelA, boa.CREATOR);
        parcelA.recycle();
        return boaVar;
    }
}
