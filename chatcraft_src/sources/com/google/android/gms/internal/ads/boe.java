package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class boe implements Parcelable.Creator<bod> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bod[] newArray(int i) {
        return new bod[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bod createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        long jE = 0;
        long jE2 = 0;
        String strG = null;
        String strG2 = null;
        String strG3 = null;
        String strG4 = null;
        Bundle bundleI = null;
        boolean zC = false;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 2:
                    strG = SafeParcelReader.g(parcel, iA);
                    break;
                case 3:
                    jE = SafeParcelReader.e(parcel, iA);
                    break;
                case 4:
                    strG2 = SafeParcelReader.g(parcel, iA);
                    break;
                case 5:
                    strG3 = SafeParcelReader.g(parcel, iA);
                    break;
                case 6:
                    strG4 = SafeParcelReader.g(parcel, iA);
                    break;
                case 7:
                    bundleI = SafeParcelReader.i(parcel, iA);
                    break;
                case 8:
                    zC = SafeParcelReader.c(parcel, iA);
                    break;
                case 9:
                    jE2 = SafeParcelReader.e(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new bod(strG, jE, strG2, strG3, strG4, bundleI, zC, jE2);
    }
}
