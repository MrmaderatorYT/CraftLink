package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

/* loaded from: classes.dex */
public abstract class ve extends azg implements vc {
    public ve() {
        super("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public static vc a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        if (iInterfaceQueryLocalInterface instanceof vc) {
            return (vc) iInterfaceQueryLocalInterface;
        }
        return new vf(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                break;
            case 2:
                a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                b(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                break;
            case 4:
                c(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                break;
            case 5:
                d(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                break;
            case 6:
                e(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                break;
            case 7:
                a(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), (vh) azh.a(parcel, vh.CREATOR));
                break;
            case 8:
                f(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                break;
            case 9:
                b(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                g(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                break;
            case 11:
                h(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                break;
            case 12:
                a((Bundle) azh.a(parcel, Bundle.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
