package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class so implements Parcelable.Creator<sn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ sn[] newArray(int i) {
        return new sn[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ sn createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        String strG = null;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(iA) == 2) {
                strG = SafeParcelReader.g(parcel, iA);
            } else {
                SafeParcelReader.b(parcel, iA);
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new sn(strG);
    }
}
