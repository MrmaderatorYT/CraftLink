package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class ua extends azf implements ty {
    ua(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void a(uk ukVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, ukVar);
        b(1, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void a() {
        b(2, z());
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void a(ue ueVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, ueVar);
        b(3, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final boolean c() {
        Parcel parcelA = a(5, z());
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void d() {
        b(6, z());
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void e() {
        b(7, z());
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void f() {
        b(8, z());
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void b(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(9, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void c(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(10, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void d(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(11, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final String g() {
        Parcel parcelA = a(12, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void b(String str) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        b(13, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void a(brx brxVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, brxVar);
        b(14, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final Bundle b() {
        Parcel parcelA = a(15, z());
        Bundle bundle = (Bundle) azh.a(parcelA, Bundle.CREATOR);
        parcelA.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void a(tw twVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, twVar);
        b(16, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void a(String str) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        b(17, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void a(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(18, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void c(String str) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        b(19, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.ty
    public final void a(boolean z) {
        Parcel parcelZ = z();
        azh.a(parcelZ, z);
        b(34, parcelZ);
    }
}
