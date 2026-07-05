package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ca extends azg implements bz {
    public ca() {
        super("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public static bz a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
        if (iInterfaceQueryLocalInterface instanceof bz) {
            return (bz) iInterfaceQueryLocalInterface;
        }
        return new cb(iBinder);
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
                List<cd> listB = b();
                parcel2.writeNoException();
                parcel2.writeList(listB);
                return true;
            default:
                return false;
        }
    }
}
