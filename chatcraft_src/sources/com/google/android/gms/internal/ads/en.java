package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class en implements Parcelable.Creator<em> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ em[] newArray(int i) {
        return new em[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ em createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        String strG = null;
        byte[] bArrJ = null;
        String[] strArrK = null;
        String[] strArrK2 = null;
        long jE = 0;
        boolean zC = false;
        int iD = 0;
        boolean zC2 = false;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 1:
                    zC = SafeParcelReader.c(parcel, iA);
                    break;
                case 2:
                    strG = SafeParcelReader.g(parcel, iA);
                    break;
                case 3:
                    iD = SafeParcelReader.d(parcel, iA);
                    break;
                case 4:
                    bArrJ = SafeParcelReader.j(parcel, iA);
                    break;
                case 5:
                    strArrK = SafeParcelReader.k(parcel, iA);
                    break;
                case 6:
                    strArrK2 = SafeParcelReader.k(parcel, iA);
                    break;
                case 7:
                    zC2 = SafeParcelReader.c(parcel, iA);
                    break;
                case 8:
                    jE = SafeParcelReader.e(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new em(zC, strG, iD, bArrJ, strArrK, strArrK2, zC2, jE);
    }
}
