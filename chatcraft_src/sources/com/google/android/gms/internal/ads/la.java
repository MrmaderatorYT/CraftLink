package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;
import java.util.List;

/* loaded from: classes.dex */
public abstract class la extends azg implements kz {
    public la() {
        super("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            case 3:
                List listB = b();
                parcel2.writeNoException();
                parcel2.writeList(listB);
                return true;
            case 4:
                String strC = c();
                parcel2.writeNoException();
                parcel2.writeString(strC);
                return true;
            case 5:
                cd cdVarD = d();
                parcel2.writeNoException();
                azh.a(parcel2, cdVarD);
                return true;
            case 6:
                String strE = e();
                parcel2.writeNoException();
                parcel2.writeString(strE);
                return true;
            case 7:
                String strF = f();
                parcel2.writeNoException();
                parcel2.writeString(strF);
                return true;
            case 8:
                g();
                parcel2.writeNoException();
                return true;
            case 9:
                a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 10:
                b(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                boolean zH = h();
                parcel2.writeNoException();
                azh.a(parcel2, zH);
                return true;
            case 12:
                boolean zI = i();
                parcel2.writeNoException();
                azh.a(parcel2, zI);
                return true;
            case 13:
                Bundle bundleJ = j();
                parcel2.writeNoException();
                azh.b(parcel2, bundleJ);
                return true;
            case 14:
                c(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                com.google.android.gms.dynamic.a aVarK = k();
                parcel2.writeNoException();
                azh.a(parcel2, aVarK);
                return true;
            case 16:
                bsw bswVarL = l();
                parcel2.writeNoException();
                azh.a(parcel2, bswVarL);
                return true;
            case 17:
            case 18:
            default:
                return false;
            case 19:
                bz bzVarM = m();
                parcel2.writeNoException();
                azh.a(parcel2, bzVarM);
                return true;
            case 20:
                com.google.android.gms.dynamic.a aVarN = n();
                parcel2.writeNoException();
                azh.a(parcel2, aVarN);
                return true;
            case 21:
                com.google.android.gms.dynamic.a aVarO = o();
                parcel2.writeNoException();
                azh.a(parcel2, aVarO);
                return true;
            case 22:
                a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), a.AbstractBinderC0069a.a(parcel.readStrongBinder()), a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
        }
    }
}
