package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class bsi extends azg implements bsg {
    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        long jA = a();
        parcel2.writeNoException();
        parcel2.writeLong(jA);
        return true;
    }
}
