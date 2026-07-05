package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public abstract class aio extends azg implements aim {
    public static aim a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.omid.IOmid");
        if (iInterfaceQueryLocalInterface instanceof aim) {
            return (aim) iInterfaceQueryLocalInterface;
        }
        return new aip(iBinder);
    }
}
