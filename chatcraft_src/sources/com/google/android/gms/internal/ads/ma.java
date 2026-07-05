package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class ma extends azf implements lz {
    ma(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    @Override // com.google.android.gms.internal.ads.lz
    public final void a(String str) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        b(2, parcelZ);
    }
}
