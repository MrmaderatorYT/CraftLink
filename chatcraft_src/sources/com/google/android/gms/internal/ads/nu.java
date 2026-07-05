package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public final class nu extends azg implements nt {
    public static nt a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        if (iInterfaceQueryLocalInterface instanceof nt) {
            return (nt) iInterfaceQueryLocalInterface;
        }
        return new nv(iBinder);
    }
}
