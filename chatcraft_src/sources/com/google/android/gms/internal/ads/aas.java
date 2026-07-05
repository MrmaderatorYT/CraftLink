package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class aas implements Parcelable.Creator<aar> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ aar[] newArray(int i) {
        return new aar[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ aar createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        String strG = null;
        int iD = 0;
        int iD2 = 0;
        boolean zC = false;
        boolean zC2 = false;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 2:
                    strG = SafeParcelReader.g(parcel, iA);
                    break;
                case 3:
                    iD = SafeParcelReader.d(parcel, iA);
                    break;
                case 4:
                    iD2 = SafeParcelReader.d(parcel, iA);
                    break;
                case 5:
                    zC = SafeParcelReader.c(parcel, iA);
                    break;
                case 6:
                    zC2 = SafeParcelReader.c(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new aar(strG, iD, iD2, zC, zC2);
    }
}
