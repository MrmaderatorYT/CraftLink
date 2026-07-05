package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class tv extends azf implements tt {
    tv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    @Override // com.google.android.gms.internal.ads.tt
    public final String a() {
        Parcel parcelA = a(1, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.tt
    public final int b() {
        Parcel parcelA = a(2, z());
        int i = parcelA.readInt();
        parcelA.recycle();
        return i;
    }
}
