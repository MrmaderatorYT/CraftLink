package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class bsj extends azf implements bsg {
    bsj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
    }

    @Override // com.google.android.gms.internal.ads.bsg
    public final long a() {
        Parcel parcelA = a(1, z());
        long j = parcelA.readLong();
        parcelA.recycle();
        return j;
    }
}
