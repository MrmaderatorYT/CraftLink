package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class aia extends azg implements ahz {
    public aia() {
        super("com.google.android.gms.ads.measurement.IAppMeasurementProxy");
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                a((Bundle) azh.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                Bundle bundleB = b((Bundle) azh.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                azh.b(parcel2, bundleB);
                return true;
            case 3:
                a(parcel.readString(), parcel.readString(), (Bundle) azh.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 4:
                a(parcel.readString(), parcel.readString(), a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                Map mapA = a(parcel.readString(), parcel.readString(), azh.a(parcel));
                parcel2.writeNoException();
                parcel2.writeMap(mapA);
                return true;
            case 6:
                int iA = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iA);
                return true;
            case 7:
                c((Bundle) azh.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 8:
                b(parcel.readString(), parcel.readString(), (Bundle) azh.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 9:
                List listA = a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeList(listA);
                return true;
            case 10:
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            case 11:
                String strB = b();
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            case 12:
                long jC = c();
                parcel2.writeNoException();
                parcel2.writeLong(jC);
                return true;
            case 13:
                b(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 14:
                c(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 15:
                a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
                String strD = d();
                parcel2.writeNoException();
                parcel2.writeString(strD);
                return true;
            case 17:
                String strE = e();
                parcel2.writeNoException();
                parcel2.writeString(strE);
                return true;
            case 18:
                String strF = f();
                parcel2.writeNoException();
                parcel2.writeString(strF);
                return true;
            default:
                return false;
        }
    }
}
