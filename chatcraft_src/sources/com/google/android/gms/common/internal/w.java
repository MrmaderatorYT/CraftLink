package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class w implements Parcelable.Creator<v> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ v[] newArray(int i) {
        return new v[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ v createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        int iD = 0;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(iA) == 1) {
                iD = SafeParcelReader.d(parcel, iA);
            } else {
                SafeParcelReader.b(parcel, iA);
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new v(iD);
    }
}
