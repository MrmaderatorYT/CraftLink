package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class dz extends azf implements dx {
    dz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final String e() {
        Parcel parcelA = a(2, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.dx, com.google.android.gms.internal.ads.bi
    public final List f() {
        Parcel parcelA = a(3, z());
        ArrayList arrayListB = azh.b(parcelA);
        parcelA.recycle();
        return arrayListB;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final String i() {
        Parcel parcelA = a(4, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final cd j() {
        cd cfVar;
        Parcel parcelA = a(5, z());
        IBinder strongBinder = parcelA.readStrongBinder();
        if (strongBinder == null) {
            cfVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            if (iInterfaceQueryLocalInterface instanceof cd) {
                cfVar = (cd) iInterfaceQueryLocalInterface;
            } else {
                cfVar = new cf(strongBinder);
            }
        }
        parcelA.recycle();
        return cfVar;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final String k() {
        Parcel parcelA = a(6, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final String l() {
        Parcel parcelA = a(7, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final double m() {
        Parcel parcelA = a(8, z());
        double d = parcelA.readDouble();
        parcelA.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final String n() {
        Parcel parcelA = a(9, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final String o() {
        Parcel parcelA = a(10, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final bsw p() {
        Parcel parcelA = a(11, z());
        bsw bswVarA = bsx.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return bswVarA;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final String s() {
        Parcel parcelA = a(12, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void v() {
        b(13, z());
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final bz u() {
        bz cbVar;
        Parcel parcelA = a(14, z());
        IBinder strongBinder = parcelA.readStrongBinder();
        if (strongBinder == null) {
            cbVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            if (iInterfaceQueryLocalInterface instanceof bz) {
                cbVar = (bz) iInterfaceQueryLocalInterface;
            } else {
                cbVar = new cb(strongBinder);
            }
        }
        parcelA.recycle();
        return cbVar;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void a(Bundle bundle) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bundle);
        b(15, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final boolean b(Bundle bundle) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bundle);
        Parcel parcelA = a(16, parcelZ);
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void c(Bundle bundle) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bundle);
        b(17, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final com.google.android.gms.dynamic.a q() {
        Parcel parcelA = a(18, z());
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final com.google.android.gms.dynamic.a r() {
        Parcel parcelA = a(19, z());
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final Bundle t() {
        Parcel parcelA = a(20, z());
        Bundle bundle = (Bundle) azh.a(parcelA, Bundle.CREATOR);
        parcelA.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void a(dv dvVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, dvVar);
        b(21, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void y() {
        b(22, z());
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final List g() {
        Parcel parcelA = a(23, z());
        ArrayList arrayListB = azh.b(parcelA);
        parcelA.recycle();
        return arrayListB;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final boolean h() {
        Parcel parcelA = a(24, z());
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void a(bss bssVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bssVar);
        b(25, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void a(bsp bspVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bspVar);
        b(26, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void w() {
        b(27, z());
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void x() {
        b(28, z());
    }
}
