package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class bsy extends azf implements bsw {
    bsy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final void a() {
        b(1, z());
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final void b() {
        b(2, z());
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final void a(boolean z) {
        Parcel parcelZ = z();
        azh.a(parcelZ, z);
        b(3, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final boolean c() {
        Parcel parcelA = a(4, z());
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final int d() {
        Parcel parcelA = a(5, z());
        int i = parcelA.readInt();
        parcelA.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final float e() {
        Parcel parcelA = a(6, z());
        float f = parcelA.readFloat();
        parcelA.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final float f() {
        Parcel parcelA = a(7, z());
        float f = parcelA.readFloat();
        parcelA.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final void a(bsz bszVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bszVar);
        b(8, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final float h() {
        Parcel parcelA = a(9, z());
        float f = parcelA.readFloat();
        parcelA.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final boolean i() {
        Parcel parcelA = a(10, z());
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final bsz g() {
        bsz btbVar;
        Parcel parcelA = a(11, z());
        IBinder strongBinder = parcelA.readStrongBinder();
        if (strongBinder == null) {
            btbVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            if (iInterfaceQueryLocalInterface instanceof bsz) {
                btbVar = (bsz) iInterfaceQueryLocalInterface;
            } else {
                btbVar = new btb(strongBinder);
            }
        }
        parcelA.recycle();
        return btbVar;
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final boolean j() {
        Parcel parcelA = a(12, z());
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }
}
