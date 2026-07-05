package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class ul implements Parcelable.Creator<uk> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ uk[] newArray(int i) {
        return new uk[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ uk createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        bqj bqjVar = null;
        String strG = null;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 2:
                    bqjVar = (bqj) SafeParcelReader.a(parcel, iA, bqj.CREATOR);
                    break;
                case 3:
                    strG = SafeParcelReader.g(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new uk(bqjVar, strG);
    }
}
