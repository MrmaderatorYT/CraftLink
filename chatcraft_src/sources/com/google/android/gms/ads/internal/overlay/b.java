package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<c> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c[] newArray(int i) {
        return new c[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        String strG = null;
        String strG2 = null;
        String strG3 = null;
        String strG4 = null;
        String strG5 = null;
        String strG6 = null;
        String strG7 = null;
        Intent intent = null;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 2:
                    strG = SafeParcelReader.g(parcel, iA);
                    break;
                case 3:
                    strG2 = SafeParcelReader.g(parcel, iA);
                    break;
                case 4:
                    strG3 = SafeParcelReader.g(parcel, iA);
                    break;
                case 5:
                    strG4 = SafeParcelReader.g(parcel, iA);
                    break;
                case 6:
                    strG5 = SafeParcelReader.g(parcel, iA);
                    break;
                case 7:
                    strG6 = SafeParcelReader.g(parcel, iA);
                    break;
                case 8:
                    strG7 = SafeParcelReader.g(parcel, iA);
                    break;
                case 9:
                    intent = (Intent) SafeParcelReader.a(parcel, iA, Intent.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new c(strG, strG2, strG3, strG4, strG5, strG6, strG7, intent);
    }
}
