package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class mq implements Parcelable.Creator<mp> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ mp[] newArray(int i) {
        return new mp[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ mp createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        int iD = 0;
        int iD2 = 0;
        int iD3 = 0;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 1:
                    iD = SafeParcelReader.d(parcel, iA);
                    break;
                case 2:
                    iD2 = SafeParcelReader.d(parcel, iA);
                    break;
                case 3:
                    iD3 = SafeParcelReader.d(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new mp(iD, iD2, iD3);
    }
}
