package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public final class ny extends azg implements nw {
    public static nw a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
        if (iInterfaceQueryLocalInterface instanceof nw) {
            return (nw) iInterfaceQueryLocalInterface;
        }
        return new nz(iBinder);
    }
}
