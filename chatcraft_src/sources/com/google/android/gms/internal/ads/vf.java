package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class vf extends azf implements vc {
    vf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void a(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(1, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void a(com.google.android.gms.dynamic.a aVar, int i) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        parcelZ.writeInt(i);
        b(2, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void b(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(3, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void c(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(4, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void d(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(5, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void e(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(6, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void a(com.google.android.gms.dynamic.a aVar, vh vhVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, vhVar);
        b(7, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void f(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(8, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void b(com.google.android.gms.dynamic.a aVar, int i) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        parcelZ.writeInt(i);
        b(9, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void g(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(10, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void h(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(11, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void a(Bundle bundle) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bundle);
        b(12, parcelZ);
    }
}
