package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class du extends azf implements ds {
    du(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.ds
    public final void a(dx dxVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, dxVar);
        b(1, parcelZ);
    }
}
