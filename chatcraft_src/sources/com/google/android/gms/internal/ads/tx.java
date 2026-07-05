package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class tx extends azf implements tw {
    tx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    @Override // com.google.android.gms.internal.ads.tw
    public final void a(tt ttVar, String str) {
        Parcel parcelZ = z();
        azh.a(parcelZ, ttVar);
        parcelZ.writeString(str);
        b(1, parcelZ);
    }
}
