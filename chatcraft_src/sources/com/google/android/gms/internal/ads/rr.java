package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class rr extends azg implements rq {
    public rr() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        rt rvVar = null;
        rw rxVar = null;
        rw rxVar2 = null;
        switch (i) {
            case 1:
                rm rmVarA = a((ri) azh.a(parcel, ri.CREATOR));
                parcel2.writeNoException();
                azh.b(parcel2, rmVarA);
                return true;
            case 2:
                ri riVar = (ri) azh.a(parcel, ri.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (iInterfaceQueryLocalInterface instanceof rt) {
                        rvVar = (rt) iInterfaceQueryLocalInterface;
                    } else {
                        rvVar = new rv(strongBinder);
                    }
                }
                a(riVar, rvVar);
                parcel2.writeNoException();
                return true;
            case 3:
            default:
                return false;
            case 4:
                sc scVar = (sc) azh.a(parcel, sc.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (iInterfaceQueryLocalInterface2 instanceof rw) {
                        rxVar2 = (rw) iInterfaceQueryLocalInterface2;
                    } else {
                        rxVar2 = new rx(strongBinder2);
                    }
                }
                a(scVar, rxVar2);
                parcel2.writeNoException();
                return true;
            case 5:
                sc scVar2 = (sc) azh.a(parcel, sc.CREATOR);
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (iInterfaceQueryLocalInterface3 instanceof rw) {
                        rxVar = (rw) iInterfaceQueryLocalInterface3;
                    } else {
                        rxVar = new rx(strongBinder3);
                    }
                }
                b(scVar2, rxVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
