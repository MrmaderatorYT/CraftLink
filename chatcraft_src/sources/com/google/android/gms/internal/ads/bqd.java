package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class bqd implements Parcelable.Creator<bqc> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bqc[] newArray(int i) {
        return new bqc[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bqc createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        String strG = null;
        String strG2 = null;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 1:
                    strG = SafeParcelReader.g(parcel, iA);
                    break;
                case 2:
                    strG2 = SafeParcelReader.g(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new bqc(strG, strG2);
    }
}
