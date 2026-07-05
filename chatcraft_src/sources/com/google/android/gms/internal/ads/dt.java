package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class dt extends azg implements ds {
    public dt() {
        super("com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    public static ds a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
        if (iInterfaceQueryLocalInterface instanceof ds) {
            return (ds) iInterfaceQueryLocalInterface;
        }
        return new du(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        dx dzVar;
        if (i != 1) {
            return false;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        if (strongBinder == null) {
            dzVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
            if (iInterfaceQueryLocalInterface instanceof dx) {
                dzVar = (dx) iInterfaceQueryLocalInterface;
            } else {
                dzVar = new dz(strongBinder);
            }
        }
        a(dzVar);
        parcel2.writeNoException();
        return true;
    }
}
