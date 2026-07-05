package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class bsm extends azf implements bsk {
    bsm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final void a() {
        b(1, z());
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final void a(float f) {
        Parcel parcelZ = z();
        parcelZ.writeFloat(f);
        b(2, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final void a(String str) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        b(3, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final void a(boolean z) {
        Parcel parcelZ = z();
        azh.a(parcelZ, z);
        b(4, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final void a(com.google.android.gms.dynamic.a aVar, String str) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        parcelZ.writeString(str);
        b(5, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final void a(String str, com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        azh.a(parcelZ, aVar);
        b(6, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final float b() {
        Parcel parcelA = a(7, z());
        float f = parcelA.readFloat();
        parcelA.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final boolean c() {
        Parcel parcelA = a(8, z());
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final String d() {
        Parcel parcelA = a(9, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final void b(String str) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        b(10, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final void a(kk kkVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, kkVar);
        b(11, parcelZ);
    }
}
