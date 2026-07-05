package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

/* loaded from: classes.dex */
public abstract class fc extends azg implements fb {
    public fc() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        fd feVar;
        switch (i) {
            case 3:
                bsw bswVarE = e();
                parcel2.writeNoException();
                azh.a(parcel2, bswVarE);
                return true;
            case 4:
                f();
                parcel2.writeNoException();
                return true;
            case 5:
                com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcel.readStrongBinder());
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    feVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                    if (iInterfaceQueryLocalInterface instanceof fd) {
                        feVar = (fd) iInterfaceQueryLocalInterface;
                    } else {
                        feVar = new fe(strongBinder);
                    }
                }
                a(aVarA, feVar);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
