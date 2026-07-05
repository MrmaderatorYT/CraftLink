package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class kr extends azg implements kq {
    public kr() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static kq a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        if (iInterfaceQueryLocalInterface instanceof kq) {
            return (kq) iInterfaceQueryLocalInterface;
        }
        return new ks(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        kt kvVar;
        switch (i) {
            case 1:
                a();
                break;
            case 2:
                b();
                break;
            case 3:
                a(parcel.readInt());
                break;
            case 4:
                c();
                break;
            case 5:
                d();
                break;
            case 6:
                e();
                break;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    kvVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    if (iInterfaceQueryLocalInterface instanceof kt) {
                        kvVar = (kt) iInterfaceQueryLocalInterface;
                    } else {
                        kvVar = new kv(strongBinder);
                    }
                }
                a(kvVar);
                break;
            case 8:
                f();
                break;
            case 9:
                a(parcel.readString(), parcel.readString());
                break;
            case 10:
                a(da.a(parcel.readStrongBinder()), parcel.readString());
                break;
            case 11:
                g();
                break;
            case 12:
                a(parcel.readString());
                break;
            case 13:
                h();
                break;
            case 14:
                a((vh) azh.a(parcel, vh.CREATOR));
                break;
            case 15:
                i();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
