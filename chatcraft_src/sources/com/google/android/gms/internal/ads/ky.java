package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ky extends azf implements kw {
    ky(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final String a() {
        Parcel parcelA = a(2, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final List b() {
        Parcel parcelA = a(3, z());
        ArrayList arrayListB = azh.b(parcelA);
        parcelA.recycle();
        return arrayListB;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final String c() {
        Parcel parcelA = a(4, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final cd d() {
        Parcel parcelA = a(5, z());
        cd cdVarA = ce.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return cdVarA;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final String e() {
        Parcel parcelA = a(6, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final double f() {
        Parcel parcelA = a(7, z());
        double d = parcelA.readDouble();
        parcelA.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final String g() {
        Parcel parcelA = a(8, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final String h() {
        Parcel parcelA = a(9, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void i() {
        b(10, z());
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void a(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(11, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void b(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(12, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final boolean j() {
        Parcel parcelA = a(13, z());
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final boolean k() {
        Parcel parcelA = a(14, z());
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final Bundle l() {
        Parcel parcelA = a(15, z());
        Bundle bundle = (Bundle) azh.a(parcelA, Bundle.CREATOR);
        parcelA.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void c(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(16, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final bsw m() {
        Parcel parcelA = a(17, z());
        bsw bswVarA = bsx.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return bswVarA;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final com.google.android.gms.dynamic.a n() {
        Parcel parcelA = a(18, z());
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final bz o() {
        Parcel parcelA = a(19, z());
        bz bzVarA = ca.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return bzVarA;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final com.google.android.gms.dynamic.a p() {
        Parcel parcelA = a(20, z());
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final com.google.android.gms.dynamic.a q() {
        Parcel parcelA = a(21, z());
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void a(com.google.android.gms.dynamic.a aVar, com.google.android.gms.dynamic.a aVar2, com.google.android.gms.dynamic.a aVar3) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, aVar2);
        azh.a(parcelZ, aVar3);
        b(22, parcelZ);
    }
}
