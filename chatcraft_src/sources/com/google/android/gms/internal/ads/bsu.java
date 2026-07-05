package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class bsu extends azf implements bss {
    bsu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    @Override // com.google.android.gms.internal.ads.bss
    public final String a() {
        Parcel parcelA = a(1, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }
}
