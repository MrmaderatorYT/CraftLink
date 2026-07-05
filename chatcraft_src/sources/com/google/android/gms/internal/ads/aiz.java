package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class aiz extends azf implements aiy {
    aiz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    @Override // com.google.android.gms.internal.ads.aiy
    public final aiw a(aiu aiuVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aiuVar);
        Parcel parcelA = a(1, parcelZ);
        aiw aiwVar = (aiw) azh.a(parcelA, aiw.CREATOR);
        parcelA.recycle();
        return aiwVar;
    }
}
