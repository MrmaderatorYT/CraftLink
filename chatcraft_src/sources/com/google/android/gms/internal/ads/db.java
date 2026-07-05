package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class db extends azf implements cz {
    db(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final String a(String str) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        Parcel parcelA = a(1, parcelZ);
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final cd b(String str) {
        cd cfVar;
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        Parcel parcelA = a(2, parcelZ);
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

    @Override // com.google.android.gms.internal.ads.cz
    public final List<String> e() {
        Parcel parcelA = a(3, z());
        ArrayList<String> arrayListCreateStringArrayList = parcelA.createStringArrayList();
        parcelA.recycle();
        return arrayListCreateStringArrayList;
    }

    @Override // com.google.android.gms.internal.ads.cz, com.google.android.gms.internal.ads.bh
    public final String b() {
        Parcel parcelA = a(4, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final void c(String str) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        b(5, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final void h() {
        b(6, z());
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final bsw g() {
        Parcel parcelA = a(7, z());
        bsw bswVarA = bsx.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return bswVarA;
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final void j() {
        b(8, z());
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final com.google.android.gms.dynamic.a i() {
        Parcel parcelA = a(9, z());
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final boolean a(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        Parcel parcelA = a(10, parcelZ);
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final com.google.android.gms.dynamic.a f() {
        Parcel parcelA = a(11, z());
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }
}
