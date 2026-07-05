package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class aid extends azf implements aib {
    aid(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.measurement.IMeasurementManager");
    }

    @Override // com.google.android.gms.internal.ads.aib
    public final void a(ahz ahzVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, ahzVar);
        b(1, parcelZ);
    }
}
