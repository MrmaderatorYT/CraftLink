package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class no extends azf implements nm {
    no(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void a(Bundle bundle) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bundle);
        b(1, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void f() {
        b(2, z());
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void g() {
        b(3, z());
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void h() {
        b(4, z());
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void i() {
        b(5, z());
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void b(Bundle bundle) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bundle);
        Parcel parcelA = a(6, parcelZ);
        if (parcelA.readInt() != 0) {
            bundle.readFromParcel(parcelA);
        }
        parcelA.recycle();
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void j() {
        b(7, z());
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void k() {
        b(8, z());
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void l() {
        b(9, z());
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void d() {
        b(10, z());
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final boolean e() {
        Parcel parcelA = a(11, z());
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void a(int i, int i2, Intent intent) {
        Parcel parcelZ = z();
        parcelZ.writeInt(i);
        parcelZ.writeInt(i2);
        azh.a(parcelZ, intent);
        b(12, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void a(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(13, parcelZ);
    }
}
