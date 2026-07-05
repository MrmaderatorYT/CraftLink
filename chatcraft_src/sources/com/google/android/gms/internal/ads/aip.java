package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

/* loaded from: classes.dex */
public final class aip extends azf implements aim {
    aip(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.omid.IOmid");
    }

    @Override // com.google.android.gms.internal.ads.aim
    public final boolean a(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        Parcel parcelA = a(2, parcelZ);
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.aim
    public final void b(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(4, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.aim
    public final void a(com.google.android.gms.dynamic.a aVar, com.google.android.gms.dynamic.a aVar2) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, aVar2);
        b(5, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.aim
    public final String a() {
        Parcel parcelA = a(6, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.aim
    public final void c(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(7, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.aim
    public final com.google.android.gms.dynamic.a a(String str, com.google.android.gms.dynamic.a aVar, String str2, String str3, String str4, String str5) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        azh.a(parcelZ, aVar);
        parcelZ.writeString(str2);
        parcelZ.writeString(str3);
        parcelZ.writeString(str4);
        parcelZ.writeString(str5);
        Parcel parcelA = a(9, parcelZ);
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }
}
