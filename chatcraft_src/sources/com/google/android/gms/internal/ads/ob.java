package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public final class ob extends azg implements oa {
    public static oa a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
        if (iInterfaceQueryLocalInterface instanceof oa) {
            return (oa) iInterfaceQueryLocalInterface;
        }
        return new oc(iBinder);
    }
}
