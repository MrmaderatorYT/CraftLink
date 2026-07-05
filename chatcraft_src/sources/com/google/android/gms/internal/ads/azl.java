package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public abstract class azl extends azg implements azk {
    public static azk a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.clearcut.IClearcut");
        if (iInterfaceQueryLocalInterface instanceof azk) {
            return (azk) iInterfaceQueryLocalInterface;
        }
        return new azm(iBinder);
    }
}
