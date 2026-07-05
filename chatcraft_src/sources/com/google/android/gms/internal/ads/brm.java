package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class brm extends azf implements brk {
    brm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.brk
    public final void a(bqj bqjVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bqjVar);
        b(1, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brk
    public final String a() {
        Parcel parcelA = a(2, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.brk
    public final boolean c() {
        Parcel parcelA = a(3, z());
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.brk
    public final String b() {
        Parcel parcelA = a(4, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.brk
    public final void a(bqj bqjVar, int i) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bqjVar);
        parcelZ.writeInt(i);
        b(5, parcelZ);
    }
}
