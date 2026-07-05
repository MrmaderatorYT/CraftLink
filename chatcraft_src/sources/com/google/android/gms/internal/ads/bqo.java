package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class bqo implements Parcelable.Creator<bqn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bqn[] newArray(int i) {
        return new bqn[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bqn createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        String strG = null;
        bqn[] bqnVarArr = null;
        int iD = 0;
        int iD2 = 0;
        boolean zC = false;
        int iD3 = 0;
        int iD4 = 0;
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
                    iD = SafeParcelReader.d(parcel, iA);
                    break;
                case 4:
                    iD2 = SafeParcelReader.d(parcel, iA);
                    break;
                case 5:
                    zC = SafeParcelReader.c(parcel, iA);
                    break;
                case 6:
                    iD3 = SafeParcelReader.d(parcel, iA);
                    break;
                case 7:
                    iD4 = SafeParcelReader.d(parcel, iA);
                    break;
                case 8:
                    bqnVarArr = (bqn[]) SafeParcelReader.b(parcel, iA, bqn.CREATOR);
                    break;
                case 9:
                    zC2 = SafeParcelReader.c(parcel, iA);
                    break;
                case 10:
                    zC3 = SafeParcelReader.c(parcel, iA);
                    break;
                case 11:
                    zC4 = SafeParcelReader.c(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new bqn(strG, iD, iD2, zC, iD3, iD4, bqnVarArr, zC2, zC3, zC4);
    }
}
