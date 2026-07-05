package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class btz implements Parcelable.Creator<bty> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bty[] newArray(int i) {
        return new bty[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bty createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        String strG = null;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(iA) == 15) {
                strG = SafeParcelReader.g(parcel, iA);
            } else {
                SafeParcelReader.b(parcel, iA);
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new bty(strG);
    }
}
