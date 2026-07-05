package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class cb extends azf implements bz {
    cb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    @Override // com.google.android.gms.internal.ads.bz
    public final String a() {
        Parcel parcelA = a(2, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.bz
    public final List<cd> b() {
        Parcel parcelA = a(3, z());
        ArrayList arrayListB = azh.b(parcelA);
        parcelA.recycle();
        return arrayListB;
    }
}
