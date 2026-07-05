package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class el implements Parcelable.Creator<ek> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ek[] newArray(int i) {
        return new ek[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ek createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        String strG = null;
        String[] strArrK = null;
        String[] strArrK2 = null;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 1:
                    strG = SafeParcelReader.g(parcel, iA);
                    break;
                case 2:
                    strArrK = SafeParcelReader.k(parcel, iA);
                    break;
                case 3:
                    strArrK2 = SafeParcelReader.k(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new ek(strG, strArrK, strArrK2);
    }
}
