package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class brt extends azg implements brs {
    public brt() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static brs a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (iInterfaceQueryLocalInterface instanceof brs) {
            return (brs) iInterfaceQueryLocalInterface;
        }
        return new bru(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        brh brjVar = null;
        brx brzVar = null;
        bsg bsjVar = null;
        brd brfVar = null;
        bsa bscVar = null;
        switch (i) {
            case 1:
                com.google.android.gms.dynamic.a aVarK = k();
                parcel2.writeNoException();
                azh.a(parcel2, aVarK);
                return true;
            case 2:
                j();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zM = m();
                parcel2.writeNoException();
                azh.a(parcel2, zM);
                return true;
            case 4:
                boolean zB = b((bqj) azh.a(parcel, bqj.CREATOR));
                parcel2.writeNoException();
                azh.a(parcel2, zB);
                return true;
            case 5:
                o();
                parcel2.writeNoException();
                return true;
            case 6:
                p();
                parcel2.writeNoException();
                return true;
            case 7:
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
            case 8:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    if (iInterfaceQueryLocalInterface2 instanceof bsa) {
                        bscVar = (bsa) iInterfaceQueryLocalInterface2;
                    } else {
                        bscVar = new bsc(strongBinder2);
                    }
                }
                a(bscVar);
                parcel2.writeNoException();
                return true;
            case 9:
                H();
                parcel2.writeNoException();
                return true;
            case 10:
                r();
                parcel2.writeNoException();
                return true;
            case 11:
                n();
                parcel2.writeNoException();
                return true;
            case 12:
                bqn bqnVarL = l();
                parcel2.writeNoException();
                azh.b(parcel2, bqnVarL);
                return true;
            case 13:
                a((bqn) azh.a(parcel, bqn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                a(nu.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                a(ob.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            case 19:
                a(aj.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    if (iInterfaceQueryLocalInterface3 instanceof brd) {
                        brfVar = (brd) iInterfaceQueryLocalInterface3;
                    } else {
                        brfVar = new brf(strongBinder3);
                    }
                }
                a(brfVar);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (iInterfaceQueryLocalInterface4 instanceof bsg) {
                        bsjVar = (bsg) iInterfaceQueryLocalInterface4;
                    } else {
                        bsjVar = new bsj(strongBinder4);
                    }
                }
                a(bsjVar);
                parcel2.writeNoException();
                return true;
            case 22:
                b(azh.a(parcel));
                parcel2.writeNoException();
                return true;
            case 23:
                boolean zS = s();
                parcel2.writeNoException();
                azh.a(parcel2, zS);
                return true;
            case 24:
                a(uf.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 25:
                a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 26:
                bsw bswVarT = t();
                parcel2.writeNoException();
                azh.a(parcel2, bswVarT);
                return true;
            case 29:
                a((buc) azh.a(parcel, buc.CREATOR));
                parcel2.writeNoException();
                return true;
            case 30:
                a((btc) azh.a(parcel, btc.CREATOR));
                parcel2.writeNoException();
                return true;
            case 31:
                String strD = D();
                parcel2.writeNoException();
                parcel2.writeString(strD);
                return true;
            case 32:
                bsa bsaVarE = E();
                parcel2.writeNoException();
                azh.a(parcel2, bsaVarE);
                return true;
            case 33:
                brh brhVarF = F();
                parcel2.writeNoException();
                azh.a(parcel2, brhVarF);
                return true;
            case 34:
                c(azh.a(parcel));
                parcel2.writeNoException();
                return true;
            case 35:
                String strQ_ = q_();
                parcel2.writeNoException();
                parcel2.writeString(strQ_);
                return true;
            case 36:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    if (iInterfaceQueryLocalInterface5 instanceof brx) {
                        brzVar = (brx) iInterfaceQueryLocalInterface5;
                    } else {
                        brzVar = new brz(strongBinder5);
                    }
                }
                a(brzVar);
                parcel2.writeNoException();
                return true;
            case 37:
                Bundle bundleQ = q();
                parcel2.writeNoException();
                azh.b(parcel2, bundleQ);
                return true;
            case 38:
                b(parcel.readString());
                parcel2.writeNoException();
                return true;
        }
    }
}
