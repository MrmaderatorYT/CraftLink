package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

/* loaded from: classes.dex */
public final class cj extends azf implements ch {
    cj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.ch
    public final void a(String str, com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        azh.a(parcelZ, aVar);
        b(1, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.ch
    public final com.google.android.gms.dynamic.a a(String str) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        Parcel parcelA = a(2, parcelZ);
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }

    @Override // com.google.android.gms.internal.ads.ch
    public final void a(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(3, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.ch
    public final void a() {
        b(4, z());
    }

    @Override // com.google.android.gms.internal.ads.ch
    public final void a(com.google.android.gms.dynamic.a aVar, int i) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        parcelZ.writeInt(i);
        b(5, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.ch
    public final void b(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(6, parcelZ);
    }
}
