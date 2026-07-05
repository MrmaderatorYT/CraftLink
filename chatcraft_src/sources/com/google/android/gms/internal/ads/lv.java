package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class lv extends azf implements lu {
    lv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.lu
    public final void a(String str) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        b(2, parcelZ);
    }
}
