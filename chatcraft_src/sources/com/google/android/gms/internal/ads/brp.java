package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class brp extends azf implements brn {
    brp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final brk a() {
        brk brmVar;
        Parcel parcelA = a(1, z());
        IBinder strongBinder = parcelA.readStrongBinder();
        if (strongBinder == null) {
            brmVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            if (iInterfaceQueryLocalInterface instanceof brk) {
                brmVar = (brk) iInterfaceQueryLocalInterface;
            } else {
                brmVar = new brm(strongBinder);
            }
        }
        parcelA.recycle();
        return brmVar;
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(brh brhVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, brhVar);
        b(2, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(dd ddVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, ddVar);
        b(3, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(dg dgVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, dgVar);
        b(4, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(String str, dm dmVar, dj djVar) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        azh.a(parcelZ, dmVar);
        azh.a(parcelZ, djVar);
        b(5, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(br brVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, brVar);
        b(6, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(bsg bsgVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bsgVar);
        b(7, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(dp dpVar, bqn bqnVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, dpVar);
        azh.a(parcelZ, bqnVar);
        b(8, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(com.google.android.gms.ads.b.j jVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, jVar);
        b(9, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(ds dsVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, dsVar);
        b(10, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(ey eyVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, eyVar);
        b(13, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(ff ffVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, ffVar);
        b(14, parcelZ);
    }
}
