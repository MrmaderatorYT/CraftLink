package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class l implements Parcelable.Creator<k> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k[] newArray(int i) {
        return new k[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        Bundle bundleI = null;
        com.google.android.gms.common.c[] cVarArr = null;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 1:
                    bundleI = SafeParcelReader.i(parcel, iA);
                    break;
                case 2:
                    cVarArr = (com.google.android.gms.common.c[]) SafeParcelReader.b(parcel, iA, com.google.android.gms.common.c.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new k(bundleI, cVarArr);
    }
}
