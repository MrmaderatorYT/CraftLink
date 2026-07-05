package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class btd implements Parcelable.Creator<btc> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ btc[] newArray(int i) {
        return new btc[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ btc createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        int iD = 0;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(iA) == 2) {
                iD = SafeParcelReader.d(parcel, iA);
            } else {
                SafeParcelReader.b(parcel, iA);
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new btc(iD);
    }
}
