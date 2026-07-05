package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class aiv implements Parcelable.Creator<aiu> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ aiu[] newArray(int i) {
        return new aiu[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ aiu createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        String strG = null;
        int iD = 0;
        String strG2 = null;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 1:
                    iD = SafeParcelReader.d(parcel, iA);
                    break;
                case 2:
                    strG = SafeParcelReader.g(parcel, iA);
                    break;
                case 3:
                    strG2 = SafeParcelReader.g(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new aiu(iD, strG, strG2);
    }
}
