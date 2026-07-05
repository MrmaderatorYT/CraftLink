package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class s implements Parcelable.Creator<r> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ r[] newArray(int i) {
        return new r[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ r createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        String strG = null;
        boolean zC = false;
        boolean zC2 = false;
        boolean zC3 = false;
        float f = 0.0f;
        int iD = 0;
        boolean zC4 = false;
        boolean zC5 = false;
        boolean zC6 = false;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 2:
                    zC = SafeParcelReader.c(parcel, iA);
                    break;
                case 3:
                    zC2 = SafeParcelReader.c(parcel, iA);
                    break;
                case 4:
                    strG = SafeParcelReader.g(parcel, iA);
                    break;
                case 5:
                    zC3 = SafeParcelReader.c(parcel, iA);
                    break;
                case 6:
                    f = SafeParcelReader.f(parcel, iA);
                    break;
                case 7:
                    iD = SafeParcelReader.d(parcel, iA);
                    break;
                case 8:
                    zC4 = SafeParcelReader.c(parcel, iA);
                    break;
                case 9:
                    zC5 = SafeParcelReader.c(parcel, iA);
                    break;
                case 10:
                    zC6 = SafeParcelReader.c(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new r(zC, zC2, strG, zC3, f, iD, zC4, zC5, zC6);
    }
}
