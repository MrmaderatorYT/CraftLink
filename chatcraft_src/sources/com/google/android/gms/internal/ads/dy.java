package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* loaded from: classes.dex */
public abstract class dy extends azg implements dx {
    public dy() {
        super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        dv dwVar;
        switch (i) {
            case 2:
                String strE = e();
                parcel2.writeNoException();
                parcel2.writeString(strE);
                return true;
            case 3:
                List listF = f();
                parcel2.writeNoException();
                parcel2.writeList(listF);
                return true;
            case 4:
                String strI = i();
                parcel2.writeNoException();
                parcel2.writeString(strI);
                return true;
            case 5:
                cd cdVarJ = j();
                parcel2.writeNoException();
                azh.a(parcel2, cdVarJ);
                return true;
            case 6:
                String strK = k();
                parcel2.writeNoException();
                parcel2.writeString(strK);
                return true;
            case 7:
                String strL = l();
                parcel2.writeNoException();
                parcel2.writeString(strL);
                return true;
            case 8:
                double dM = m();
                parcel2.writeNoException();
                parcel2.writeDouble(dM);
                return true;
            case 9:
                String strN = n();
                parcel2.writeNoException();
                parcel2.writeString(strN);
                return true;
            case 10:
                String strO = o();
                parcel2.writeNoException();
                parcel2.writeString(strO);
                return true;
            case 11:
                bsw bswVarP = p();
                parcel2.writeNoException();
                azh.a(parcel2, bswVarP);
                return true;
            case 12:
                String strS = s();
                parcel2.writeNoException();
                parcel2.writeString(strS);
                return true;
            case 13:
                v();
                parcel2.writeNoException();
                return true;
            case 14:
                bz bzVarU = u();
                parcel2.writeNoException();
                azh.a(parcel2, bzVarU);
                return true;
            case 15:
                a((Bundle) azh.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 16:
                boolean zB = b((Bundle) azh.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                azh.a(parcel2, zB);
                return true;
            case 17:
                c((Bundle) azh.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 18:
                com.google.android.gms.dynamic.a aVarQ = q();
                parcel2.writeNoException();
                azh.a(parcel2, aVarQ);
                return true;
            case 19:
                com.google.android.gms.dynamic.a aVarR = r();
                parcel2.writeNoException();
                azh.a(parcel2, aVarR);
                return true;
            case 20:
                Bundle bundleT = t();
                parcel2.writeNoException();
                azh.b(parcel2, bundleT);
                return true;
            case 21:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    dwVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
                    if (iInterfaceQueryLocalInterface instanceof dv) {
                        dwVar = (dv) iInterfaceQueryLocalInterface;
                    } else {
                        dwVar = new dw(strongBinder);
                    }
                }
                a(dwVar);
                parcel2.writeNoException();
                return true;
            case 22:
                y();
                parcel2.writeNoException();
                return true;
            case 23:
                List listG = g();
                parcel2.writeNoException();
                parcel2.writeList(listG);
                return true;
            case 24:
                boolean zH = h();
                parcel2.writeNoException();
                azh.a(parcel2, zH);
                return true;
            case 25:
                a(bst.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 26:
                a(bsq.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 27:
                w();
                parcel2.writeNoException();
                return true;
            case 28:
                x();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
