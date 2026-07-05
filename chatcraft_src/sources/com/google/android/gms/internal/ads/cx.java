package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class cx extends azf implements cv {
    cx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final com.google.android.gms.dynamic.a n() {
        Parcel parcelA = a(2, z());
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final String e() {
        Parcel parcelA = a(3, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.cv, com.google.android.gms.internal.ads.bi
    public final List f() {
        Parcel parcelA = a(4, z());
        ArrayList arrayListB = azh.b(parcelA);
        parcelA.recycle();
        return arrayListB;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final String i() {
        Parcel parcelA = a(5, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final cd j() {
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

    @Override // com.google.android.gms.internal.ads.cv
    public final String k() {
        Parcel parcelA = a(7, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final String l() {
        Parcel parcelA = a(8, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final Bundle o() {
        Parcel parcelA = a(9, z());
        Bundle bundle = (Bundle) azh.a(parcelA, Bundle.CREATOR);
        parcelA.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final void q() {
        b(10, z());
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final bsw m() {
        Parcel parcelA = a(11, z());
        bsw bswVarA = bsx.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return bswVarA;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final void a(Bundle bundle) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bundle);
        b(12, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final boolean b(Bundle bundle) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bundle);
        Parcel parcelA = a(13, parcelZ);
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final void c(Bundle bundle) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bundle);
        b(14, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final bz p() {
        bz cbVar;
        Parcel parcelA = a(15, z());
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

    @Override // com.google.android.gms.internal.ads.cv
    public final com.google.android.gms.dynamic.a g() {
        Parcel parcelA = a(16, z());
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final String h() {
        Parcel parcelA = a(17, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }
}
