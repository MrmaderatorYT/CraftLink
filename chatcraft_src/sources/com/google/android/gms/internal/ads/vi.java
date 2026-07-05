package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class vi implements Parcelable.Creator<vh> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ vh[] newArray(int i) {
        return new vh[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ vh createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        String strG = null;
        int iD = 0;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 2:
                    strG = SafeParcelReader.g(parcel, iA);
                    break;
                case 3:
                    iD = SafeParcelReader.d(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new vh(strG, iD);
    }
}
