package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import java.util.List;

/* loaded from: classes.dex */
public abstract class cw extends azg implements cv {
    public cw() {
        super("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
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
                String strI = i();
                parcel2.writeNoException();
                parcel2.writeString(strI);
                return true;
            case 6:
                cd cdVarJ = j();
                parcel2.writeNoException();
                azh.a(parcel2, cdVarJ);
                return true;
            case 7:
                String strK = k();
                parcel2.writeNoException();
                parcel2.writeString(strK);
                return true;
            case 8:
                String strL = l();
                parcel2.writeNoException();
                parcel2.writeString(strL);
                return true;
            case 9:
                Bundle bundleO = o();
                parcel2.writeNoException();
                azh.b(parcel2, bundleO);
                return true;
            case 10:
                q();
                parcel2.writeNoException();
                return true;
            case 11:
                bsw bswVarM = m();
                parcel2.writeNoException();
                azh.a(parcel2, bswVarM);
                return true;
            case 12:
                a((Bundle) azh.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                boolean zB = b((Bundle) azh.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                azh.a(parcel2, zB);
                return true;
            case 14:
                c((Bundle) azh.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                bz bzVarP = p();
                parcel2.writeNoException();
                azh.a(parcel2, bzVarP);
                return true;
            case 16:
                com.google.android.gms.dynamic.a aVarG = g();
                parcel2.writeNoException();
                azh.a(parcel2, aVarG);
                return true;
            case 17:
                String strH = h();
                parcel2.writeNoException();
                parcel2.writeString(strH);
                return true;
            default:
                return false;
        }
    }
}
