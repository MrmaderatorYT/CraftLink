package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class dl extends azf implements dj {
    dl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    @Override // com.google.android.gms.internal.ads.dj
    public final void a(cz czVar, String str) {
        Parcel parcelZ = z();
        azh.a(parcelZ, czVar);
        parcelZ.writeString(str);
        b(1, parcelZ);
    }
}
