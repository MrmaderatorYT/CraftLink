package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.dynamic.a;

/* loaded from: classes.dex */
public abstract class bsl extends azg implements bsk {
    public bsl() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                a();
                parcel2.writeNoException();
                return true;
            case 2:
                a(parcel.readFloat());
                parcel2.writeNoException();
                return true;
            case 3:
                a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                a(azh.a(parcel));
                parcel2.writeNoException();
                return true;
            case 5:
                a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                a(parcel.readString(), a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                float fB = b();
                parcel2.writeNoException();
                parcel2.writeFloat(fB);
                return true;
            case 8:
                boolean zC = c();
                parcel2.writeNoException();
                azh.a(parcel2, zC);
                return true;
            case 9:
                String strD = d();
                parcel2.writeNoException();
                parcel2.writeString(strD);
                return true;
            case 10:
                b(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                a(kl.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
