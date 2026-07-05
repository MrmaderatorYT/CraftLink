package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

/* loaded from: classes.dex */
public abstract class tz extends azg implements ty {
    public tz() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public static ty a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        if (iInterfaceQueryLocalInterface instanceof ty) {
            return (ty) iInterfaceQueryLocalInterface;
        }
        return new ua(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 34) {
            ue ugVar = null;
            tw txVar = null;
            switch (i) {
                case 1:
                    a((uk) azh.a(parcel, uk.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    a();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    IBinder strongBinder = parcel.readStrongBinder();
                    if (strongBinder != null) {
                        IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                        if (iInterfaceQueryLocalInterface instanceof ue) {
                            ugVar = (ue) iInterfaceQueryLocalInterface;
                        } else {
                            ugVar = new ug(strongBinder);
                        }
                    }
                    a(ugVar);
                    parcel2.writeNoException();
                    return true;
                default:
                    switch (i) {
                        case 5:
                            boolean zC = c();
                            parcel2.writeNoException();
                            azh.a(parcel2, zC);
                            return true;
                        case 6:
                            d();
                            parcel2.writeNoException();
                            return true;
                        case 7:
                            e();
                            parcel2.writeNoException();
                            return true;
                        case 8:
                            f();
                            parcel2.writeNoException();
                            return true;
                        case 9:
                            b(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 10:
                            c(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 11:
                            d(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 12:
                            String strG = g();
                            parcel2.writeNoException();
                            parcel2.writeString(strG);
                            return true;
                        case 13:
                            b(parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 14:
                            a(bry.a(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 15:
                            Bundle bundleB = b();
                            parcel2.writeNoException();
                            azh.b(parcel2, bundleB);
                            return true;
                        case 16:
                            IBinder strongBinder2 = parcel.readStrongBinder();
                            if (strongBinder2 != null) {
                                IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
                                if (iInterfaceQueryLocalInterface2 instanceof tw) {
                                    txVar = (tw) iInterfaceQueryLocalInterface2;
                                } else {
                                    txVar = new tx(strongBinder2);
                                }
                            }
                            a(txVar);
                            parcel2.writeNoException();
                            return true;
                        case 17:
                            a(parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 18:
                            a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 19:
                            c(parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        default:
                            return false;
                    }
            }
        }
        a(azh.a(parcel));
        parcel2.writeNoException();
        return true;
    }
}
