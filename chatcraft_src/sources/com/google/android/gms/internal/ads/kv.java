package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class kv extends azf implements kt {
    kv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
    }

    @Override // com.google.android.gms.internal.ads.kt
    public final int a() {
        Parcel parcelA = a(1, z());
        int i = parcelA.readInt();
        parcelA.recycle();
        return i;
    }
}
