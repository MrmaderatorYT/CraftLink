package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class di extends azf implements dg {
    di(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.dg
    public final void a(cv cvVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, cvVar);
        b(1, parcelZ);
    }
}
