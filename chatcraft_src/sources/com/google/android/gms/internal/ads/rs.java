package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class rs extends azf implements rq {
    rs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.rq
    public final rm a(ri riVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, riVar);
        Parcel parcelA = a(1, parcelZ);
        rm rmVar = (rm) azh.a(parcelA, rm.CREATOR);
        parcelA.recycle();
        return rmVar;
    }

    @Override // com.google.android.gms.internal.ads.rq
    public final void a(ri riVar, rt rtVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, riVar);
        azh.a(parcelZ, rtVar);
        b(2, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.rq
    public final void a(sc scVar, rw rwVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, scVar);
        azh.a(parcelZ, rwVar);
        b(4, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.rq
    public final void b(sc scVar, rw rwVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, scVar);
        azh.a(parcelZ, rwVar);
        b(5, parcelZ);
    }
}
