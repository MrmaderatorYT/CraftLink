package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class km extends azf implements kk {
    km(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    @Override // com.google.android.gms.internal.ads.kk
    public final kn a(String str) {
        kn kpVar;
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        Parcel parcelA = a(1, parcelZ);
        IBinder strongBinder = parcelA.readStrongBinder();
        if (strongBinder == null) {
            kpVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (iInterfaceQueryLocalInterface instanceof kn) {
                kpVar = (kn) iInterfaceQueryLocalInterface;
            } else {
                kpVar = new kp(strongBinder);
            }
        }
        parcelA.recycle();
        return kpVar;
    }

    @Override // com.google.android.gms.internal.ads.kk
    public final boolean b(String str) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        Parcel parcelA = a(2, parcelZ);
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.kk
    public final md c(String str) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        Parcel parcelA = a(3, parcelZ);
        md mdVarA = me.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return mdVarA;
    }
}
