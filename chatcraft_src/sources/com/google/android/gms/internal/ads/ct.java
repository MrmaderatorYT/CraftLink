package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ct extends azf implements cr {
    ct(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final com.google.android.gms.dynamic.a n() {
        Parcel parcelA = a(2, z());
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final String e() {
        Parcel parcelA = a(3, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.cr, com.google.android.gms.internal.ads.bi
    public final List f() {
        Parcel parcelA = a(4, z());
        ArrayList arrayListB = azh.b(parcelA);
        parcelA.recycle();
        return arrayListB;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final String g() {
        Parcel parcelA = a(5, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final cd h() {
        cd cfVar;
        Parcel parcelA = a(6, z());
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

    @Override // com.google.android.gms.internal.ads.cr
    public final String i() {
        Parcel parcelA = a(7, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final double j() {
        Parcel parcelA = a(8, z());
        double d = parcelA.readDouble();
        parcelA.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final String k() {
        Parcel parcelA = a(9, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final String l() {
        Parcel parcelA = a(10, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final Bundle o() {
        Parcel parcelA = a(11, z());
        Bundle bundle = (Bundle) azh.a(parcelA, Bundle.CREATOR);
        parcelA.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final void s() {
        b(12, z());
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final bsw m() {
        Parcel parcelA = a(13, z());
        bsw bswVarA = bsx.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return bswVarA;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final void a(Bundle bundle) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bundle);
        b(14, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final boolean b(Bundle bundle) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bundle);
        Parcel parcelA = a(15, parcelZ);
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final void c(Bundle bundle) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bundle);
        b(16, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final bz r() {
        bz cbVar;
        Parcel parcelA = a(17, z());
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

    @Override // com.google.android.gms.internal.ads.cr
    public final com.google.android.gms.dynamic.a p() {
        Parcel parcelA = a(18, z());
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final String q() {
        Parcel parcelA = a(19, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }
}
