package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class ce extends azg implements cd {
    public ce() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static cd a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        if (iInterfaceQueryLocalInterface instanceof cd) {
            return (cd) iInterfaceQueryLocalInterface;
        }
        return new cf(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                com.google.android.gms.dynamic.a aVarA = a();
                parcel2.writeNoException();
                azh.a(parcel2, aVarA);
                return true;
            case 2:
                Uri uriB = b();
                parcel2.writeNoException();
                azh.b(parcel2, uriB);
                return true;
            case 3:
                double dC = c();
                parcel2.writeNoException();
                parcel2.writeDouble(dC);
                return true;
            default:
                return false;
        }
    }
}
