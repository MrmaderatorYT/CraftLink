package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class df extends azf implements dd {
    df(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.dd
    public final void a(cr crVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, crVar);
        b(1, parcelZ);
    }
}
