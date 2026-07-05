package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public abstract class aic extends azg implements aib {
    public static aib a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.measurement.IMeasurementManager");
        if (iInterfaceQueryLocalInterface instanceof aib) {
            return (aib) iInterfaceQueryLocalInterface;
        }
        return new aid(iBinder);
    }
}
