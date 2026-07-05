package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import java.util.List;

/* loaded from: classes.dex */
public abstract class cs extends azg implements cr {
    public cs() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                com.google.android.gms.dynamic.a aVarN = n();
                parcel2.writeNoException();
                azh.a(parcel2, aVarN);
                return true;
            case 3:
                String strE = e();
                parcel2.writeNoException();
                parcel2.writeString(strE);
                return true;
            case 4:
                List listF = f();
                parcel2.writeNoException();
                parcel2.writeList(listF);
                return true;
            case 5:
                String strG = g();
                parcel2.writeNoException();
                parcel2.writeString(strG);
                return true;
            case 6:
                cd cdVarH = h();
                parcel2.writeNoException();
                azh.a(parcel2, cdVarH);
                return true;
            case 7:
                String strI = i();
                parcel2.writeNoException();
                parcel2.writeString(strI);
                return true;
            case 8:
                double dJ = j();
                parcel2.writeNoException();
                parcel2.writeDouble(dJ);
                return true;
            case 9:
                String strK = k();
                parcel2.writeNoException();
                parcel2.writeString(strK);
                return true;
            case 10:
                String strL = l();
                parcel2.writeNoException();
                parcel2.writeString(strL);
                return true;
            case 11:
                Bundle bundleO = o();
                parcel2.writeNoException();
                azh.b(parcel2, bundleO);
                return true;
            case 12:
                s();
                parcel2.writeNoException();
                return true;
            case 13:
                bsw bswVarM = m();
                parcel2.writeNoException();
                azh.a(parcel2, bswVarM);
                return true;
            case 14:
                a((Bundle) azh.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                boolean zB = b((Bundle) azh.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                azh.a(parcel2, zB);
                return true;
            case 16:
                c((Bundle) azh.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 17:
                bz bzVarR = r();
                parcel2.writeNoException();
                azh.a(parcel2, bzVarR);
                return true;
            case 18:
                com.google.android.gms.dynamic.a aVarP = p();
                parcel2.writeNoException();
                azh.a(parcel2, aVarP);
                return true;
            case 19:
                String strQ = q();
                parcel2.writeNoException();
                parcel2.writeString(strQ);
                return true;
            default:
                return false;
        }
    }
}
