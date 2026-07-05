package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class mc extends azf implements mb {
    mc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    @Override // com.google.android.gms.internal.ads.mb
    public final void a(String str) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        b(3, parcelZ);
    }
}
