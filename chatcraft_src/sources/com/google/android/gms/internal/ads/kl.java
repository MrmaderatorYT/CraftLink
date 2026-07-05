package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class kl extends azg implements kk {
    public kl() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static kk a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (iInterfaceQueryLocalInterface instanceof kk) {
            return (kk) iInterfaceQueryLocalInterface;
        }
        return new km(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                kn knVarA = a(parcel.readString());
                parcel2.writeNoException();
                azh.a(parcel2, knVarA);
                return true;
            case 2:
                boolean zB = b(parcel.readString());
                parcel2.writeNoException();
                azh.a(parcel2, zB);
                return true;
            case 3:
                md mdVarC = c(parcel.readString());
                parcel2.writeNoException();
                azh.a(parcel2, mdVarC);
                return true;
            default:
                return false;
        }
    }
}
