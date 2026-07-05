package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class fa implements Parcelable.Creator<ey> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ey[] newArray(int i) {
        return new ey[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ey createFromParcel(Parcel parcel) {
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
        return new ey(iD);
    }
}
