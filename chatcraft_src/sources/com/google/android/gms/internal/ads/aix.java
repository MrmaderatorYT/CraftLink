package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class aix implements Parcelable.Creator<aiw> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ aiw[] newArray(int i) {
        return new aiw[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ aiw createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        int iD = 0;
        byte[] bArrJ = null;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 1:
                    iD = SafeParcelReader.d(parcel, iA);
                    break;
                case 2:
                    bArrJ = SafeParcelReader.j(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new aiw(iD, bArrJ);
    }
}
