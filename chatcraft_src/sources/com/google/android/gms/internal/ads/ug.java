package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class ug extends azf implements ue {
    ug(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.ue
    public final void a() {
        b(1, z());
    }

    @Override // com.google.android.gms.internal.ads.ue
    public final void b() {
        b(2, z());
    }

    @Override // com.google.android.gms.internal.ads.ue
    public final void c() {
        b(3, z());
    }

    @Override // com.google.android.gms.internal.ads.ue
    public final void d() {
        b(4, z());
    }

    @Override // com.google.android.gms.internal.ads.ue
    public final void a(tt ttVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, ttVar);
        b(5, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.ue
    public final void e() {
        b(6, z());
    }

    @Override // com.google.android.gms.internal.ads.ue
    public final void a(int i) {
        Parcel parcelZ = z();
        parcelZ.writeInt(i);
        b(7, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.ue
    public final void f() {
        b(8, z());
    }
}
