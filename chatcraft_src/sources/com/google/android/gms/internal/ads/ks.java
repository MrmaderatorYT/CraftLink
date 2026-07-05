package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class ks extends azf implements kq {
    ks(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void a() {
        b(1, z());
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void b() {
        b(2, z());
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void a(int i) {
        Parcel parcelZ = z();
        parcelZ.writeInt(i);
        b(3, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void c() {
        b(4, z());
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void d() {
        b(5, z());
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void e() {
        b(6, z());
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void a(kt ktVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, ktVar);
        b(7, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void f() {
        b(8, z());
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void a(String str, String str2) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        parcelZ.writeString(str2);
        b(9, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void a(cz czVar, String str) {
        Parcel parcelZ = z();
        azh.a(parcelZ, czVar);
        parcelZ.writeString(str);
        b(10, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void g() {
        b(11, z());
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void a(String str) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        b(12, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void h() {
        b(13, z());
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void a(vh vhVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, vhVar);
        b(14, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kq
    public final void i() {
        b(15, z());
    }
}
