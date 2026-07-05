package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class vt implements Parcelable.Creator<vs> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ vs[] newArray(int i) {
        return new vs[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ vs createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        String strG = null;
        String strG2 = null;
        ArrayList<String> arrayListM = null;
        ArrayList<String> arrayListM2 = null;
        boolean zC = false;
        boolean zC2 = false;
        boolean zC3 = false;
        boolean zC4 = false;
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
                    zC = SafeParcelReader.c(parcel, iA);
                    break;
                case 5:
                    zC2 = SafeParcelReader.c(parcel, iA);
                    break;
                case 6:
                    arrayListM = SafeParcelReader.m(parcel, iA);
                    break;
                case 7:
                    zC3 = SafeParcelReader.c(parcel, iA);
                    break;
                case 8:
                    zC4 = SafeParcelReader.c(parcel, iA);
                    break;
                case 9:
                    arrayListM2 = SafeParcelReader.m(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new vs(strG, strG2, zC, zC2, arrayListM, zC3, zC4, arrayListM2);
    }
}
