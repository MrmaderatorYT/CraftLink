package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

/* loaded from: classes.dex */
public abstract class dq extends azg implements dp {
    public static dp a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
        if (iInterfaceQueryLocalInterface instanceof dp) {
            return (dp) iInterfaceQueryLocalInterface;
        }
        return new dr(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        a(brt.a(parcel.readStrongBinder()), a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
        parcel2.writeNoException();
        return true;
    }
}
