package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class azm extends azf implements azk {
    azm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    @Override // com.google.android.gms.internal.ads.azk
    public final void a(com.google.android.gms.dynamic.a aVar, String str) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        parcelZ.writeString(str);
        b(2, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.azk
    public final void a() {
        b(3, z());
    }

    @Override // com.google.android.gms.internal.ads.azk
    public final void a(int[] iArr) {
        Parcel parcelZ = z();
        parcelZ.writeIntArray(null);
        b(4, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.azk
    public final void a(byte[] bArr) {
        Parcel parcelZ = z();
        parcelZ.writeByteArray(bArr);
        b(5, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.azk
    public final void a(int i) {
        Parcel parcelZ = z();
        parcelZ.writeInt(i);
        b(6, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.azk
    public final void b(int i) {
        Parcel parcelZ = z();
        parcelZ.writeInt(i);
        b(7, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.azk
    public final void a(com.google.android.gms.dynamic.a aVar, String str, String str2) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        parcelZ.writeString(str);
        parcelZ.writeString(null);
        b(8, parcelZ);
    }
}
