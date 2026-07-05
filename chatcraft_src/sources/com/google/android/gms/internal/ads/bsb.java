package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class bsb extends azg implements bsa {
    public bsb() {
        super("com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    public static bsa a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
        if (iInterfaceQueryLocalInterface instanceof bsa) {
            return (bsa) iInterfaceQueryLocalInterface;
        }
        return new bsc(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        a(parcel.readString(), parcel.readString());
        parcel2.writeNoException();
        return true;
    }
}
