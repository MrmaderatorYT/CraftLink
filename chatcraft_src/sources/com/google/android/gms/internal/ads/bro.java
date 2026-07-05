package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class bro extends azg implements brn {
    public bro() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        brh brjVar = null;
        bsg bsjVar = null;
        switch (i) {
            case 1:
                brk brkVarA = a();
                parcel2.writeNoException();
                azh.a(parcel2, brkVarA);
                return true;
            case 2:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    if (iInterfaceQueryLocalInterface instanceof brh) {
                        brjVar = (brh) iInterfaceQueryLocalInterface;
                    } else {
                        brjVar = new brj(strongBinder);
                    }
                }
                a(brjVar);
                parcel2.writeNoException();
                return true;
            case 3:
                a(de.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                a(dh.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                a(parcel.readString(), dn.a(parcel.readStrongBinder()), dk.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                a((br) azh.a(parcel, br.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (iInterfaceQueryLocalInterface2 instanceof bsg) {
                        bsjVar = (bsg) iInterfaceQueryLocalInterface2;
                    } else {
                        bsjVar = new bsj(strongBinder2);
                    }
                }
                a(bsjVar);
                parcel2.writeNoException();
                return true;
            case 8:
                a(dq.a(parcel.readStrongBinder()), (bqn) azh.a(parcel, bqn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 9:
                a((com.google.android.gms.ads.b.j) azh.a(parcel, com.google.android.gms.ads.b.j.CREATOR));
                parcel2.writeNoException();
                return true;
            case 10:
                a(dt.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
            case 12:
            default:
                return false;
            case 13:
                a((ey) azh.a(parcel, ey.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                a(fg.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
        }
    }
}
