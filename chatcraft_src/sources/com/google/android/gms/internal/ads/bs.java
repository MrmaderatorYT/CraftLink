package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class bs implements Parcelable.Creator<br> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ br[] newArray(int i) {
        return new br[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ br createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        buc bucVar = null;
        int iD = 0;
        boolean zC = false;
        int iD2 = 0;
        boolean zC2 = false;
        int iD3 = 0;
        boolean zC3 = false;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 1:
                    iD = SafeParcelReader.d(parcel, iA);
                    break;
                case 2:
                    zC = SafeParcelReader.c(parcel, iA);
                    break;
                case 3:
                    iD2 = SafeParcelReader.d(parcel, iA);
                    break;
                case 4:
                    zC2 = SafeParcelReader.c(parcel, iA);
                    break;
                case 5:
                    iD3 = SafeParcelReader.d(parcel, iA);
                    break;
                case 6:
                    bucVar = (buc) SafeParcelReader.a(parcel, iA, buc.CREATOR);
                    break;
                case 7:
                    zC3 = SafeParcelReader.c(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new br(iD, zC, iD2, zC2, iD3, bucVar, zC3);
    }
}
