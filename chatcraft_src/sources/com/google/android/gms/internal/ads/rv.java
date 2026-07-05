package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class rv extends azf implements rt {
    rv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.rt
    public final void a(rm rmVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, rmVar);
        b(1, parcelZ);
    }
}
