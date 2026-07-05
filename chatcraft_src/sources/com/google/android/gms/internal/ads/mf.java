package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class mf extends azf implements md {
    mf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.md
    public final void a(com.google.android.gms.dynamic.a aVar, String str, Bundle bundle, Bundle bundle2, bqn bqnVar, mg mgVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        parcelZ.writeString(str);
        azh.a(parcelZ, bundle);
        azh.a(parcelZ, bundle2);
        azh.a(parcelZ, bqnVar);
        azh.a(parcelZ, mgVar);
        b(1, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.md
    public final mp a() {
        Parcel parcelA = a(2, z());
        mp mpVar = (mp) azh.a(parcelA, mp.CREATOR);
        parcelA.recycle();
        return mpVar;
    }

    @Override // com.google.android.gms.internal.ads.md
    public final mp b() {
        Parcel parcelA = a(3, z());
        mp mpVar = (mp) azh.a(parcelA, mp.CREATOR);
        parcelA.recycle();
        return mpVar;
    }

    @Override // com.google.android.gms.internal.ads.md
    public final void a(String str, String str2, Bundle bundle, com.google.android.gms.dynamic.a aVar, lu luVar, kq kqVar, bqn bqnVar) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        parcelZ.writeString(str2);
        azh.a(parcelZ, bundle);
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, luVar);
        azh.a(parcelZ, kqVar);
        azh.a(parcelZ, bqnVar);
        b(4, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.md
    public final bsw c() {
        Parcel parcelA = a(5, z());
        bsw bswVarA = bsx.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return bswVarA;
    }

    @Override // com.google.android.gms.internal.ads.md
    public final void a(String str, String str2, Bundle bundle, com.google.android.gms.dynamic.a aVar, lx lxVar, kq kqVar) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        parcelZ.writeString(str2);
        azh.a(parcelZ, bundle);
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, lxVar);
        azh.a(parcelZ, kqVar);
        b(6, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.md
    public final void d() {
        b(7, z());
    }

    @Override // com.google.android.gms.internal.ads.md
    public final void a(String str, String str2, Bundle bundle, com.google.android.gms.dynamic.a aVar, mb mbVar, kq kqVar) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        parcelZ.writeString(str2);
        azh.a(parcelZ, bundle);
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, mbVar);
        azh.a(parcelZ, kqVar);
        b(8, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.md
    public final void e() {
        b(9, z());
    }

    @Override // com.google.android.gms.internal.ads.md
    public final void a(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(10, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.md
    public final void a(String[] strArr, Bundle[] bundleArr) {
        Parcel parcelZ = z();
        parcelZ.writeStringArray(strArr);
        parcelZ.writeTypedArray(bundleArr, 0);
        b(11, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.md
    public final void a(String str, String str2, Bundle bundle, com.google.android.gms.dynamic.a aVar, lz lzVar, kq kqVar) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        parcelZ.writeString(str2);
        azh.a(parcelZ, bundle);
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, lzVar);
        azh.a(parcelZ, kqVar);
        b(12, parcelZ);
    }
}
