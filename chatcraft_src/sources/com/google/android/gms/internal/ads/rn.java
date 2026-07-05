package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class rn implements Parcelable.Creator<rm> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ rm[] newArray(int i) {
        return new rm[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ rm createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        long jE = 0;
        long jE2 = 0;
        long jE3 = 0;
        long jE4 = 0;
        String strG = null;
        String strG2 = null;
        ArrayList<String> arrayListM = null;
        ArrayList<String> arrayListM2 = null;
        ArrayList<String> arrayListM3 = null;
        String strG3 = null;
        String strG4 = null;
        String strG5 = null;
        String strG6 = null;
        ry ryVar = null;
        String strG7 = null;
        String strG8 = null;
        vh vhVar = null;
        ArrayList<String> arrayListM4 = null;
        ArrayList<String> arrayListM5 = null;
        ro roVar = null;
        String strG9 = null;
        ArrayList<String> arrayListM6 = null;
        String strG10 = null;
        vs vsVar = null;
        String strG11 = null;
        Bundle bundleI = null;
        ArrayList<String> arrayListM7 = null;
        String strG12 = null;
        String strG13 = null;
        int iD = 0;
        int iD2 = 0;
        boolean zC = false;
        int iD3 = 0;
        boolean zC2 = false;
        boolean zC3 = false;
        boolean zC4 = false;
        boolean zC5 = false;
        boolean zC6 = false;
        boolean zC7 = false;
        boolean zC8 = false;
        boolean zC9 = false;
        boolean zC10 = false;
        boolean zC11 = false;
        boolean zC12 = false;
        boolean zC13 = false;
        boolean zC14 = false;
        boolean zC15 = false;
        int iD4 = 0;
        boolean zC16 = false;
        boolean zC17 = false;
        boolean zC18 = false;
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
                case 4:
                    arrayListM = SafeParcelReader.m(parcel, iA);
                    break;
                case 5:
                    iD2 = SafeParcelReader.d(parcel, iA);
                    break;
                case 6:
                    arrayListM2 = SafeParcelReader.m(parcel, iA);
                    break;
                case 7:
                    jE = SafeParcelReader.e(parcel, iA);
                    break;
                case 8:
                    zC = SafeParcelReader.c(parcel, iA);
                    break;
                case 9:
                    jE2 = SafeParcelReader.e(parcel, iA);
                    break;
                case 10:
                    arrayListM3 = SafeParcelReader.m(parcel, iA);
                    break;
                case 11:
                    jE3 = SafeParcelReader.e(parcel, iA);
                    break;
                case 12:
                    iD3 = SafeParcelReader.d(parcel, iA);
                    break;
                case 13:
                    strG3 = SafeParcelReader.g(parcel, iA);
                    break;
                case 14:
                    jE4 = SafeParcelReader.e(parcel, iA);
                    break;
                case 15:
                    strG4 = SafeParcelReader.g(parcel, iA);
                    break;
                case 16:
                case 17:
                case 20:
                case 27:
                case 41:
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
                case 18:
                    zC2 = SafeParcelReader.c(parcel, iA);
                    break;
                case 19:
                    strG5 = SafeParcelReader.g(parcel, iA);
                    break;
                case 21:
                    strG6 = SafeParcelReader.g(parcel, iA);
                    break;
                case 22:
                    zC3 = SafeParcelReader.c(parcel, iA);
                    break;
                case 23:
                    zC4 = SafeParcelReader.c(parcel, iA);
                    break;
                case 24:
                    zC5 = SafeParcelReader.c(parcel, iA);
                    break;
                case 25:
                    zC6 = SafeParcelReader.c(parcel, iA);
                    break;
                case 26:
                    zC7 = SafeParcelReader.c(parcel, iA);
                    break;
                case 28:
                    ryVar = (ry) SafeParcelReader.a(parcel, iA, ry.CREATOR);
                    break;
                case 29:
                    strG7 = SafeParcelReader.g(parcel, iA);
                    break;
                case 30:
                    strG8 = SafeParcelReader.g(parcel, iA);
                    break;
                case 31:
                    zC8 = SafeParcelReader.c(parcel, iA);
                    break;
                case 32:
                    zC9 = SafeParcelReader.c(parcel, iA);
                    break;
                case 33:
                    vhVar = (vh) SafeParcelReader.a(parcel, iA, vh.CREATOR);
                    break;
                case 34:
                    arrayListM4 = SafeParcelReader.m(parcel, iA);
                    break;
                case 35:
                    arrayListM5 = SafeParcelReader.m(parcel, iA);
                    break;
                case 36:
                    zC10 = SafeParcelReader.c(parcel, iA);
                    break;
                case 37:
                    roVar = (ro) SafeParcelReader.a(parcel, iA, ro.CREATOR);
                    break;
                case 38:
                    zC11 = SafeParcelReader.c(parcel, iA);
                    break;
                case 39:
                    strG9 = SafeParcelReader.g(parcel, iA);
                    break;
                case 40:
                    arrayListM6 = SafeParcelReader.m(parcel, iA);
                    break;
                case 42:
                    zC12 = SafeParcelReader.c(parcel, iA);
                    break;
                case 43:
                    strG10 = SafeParcelReader.g(parcel, iA);
                    break;
                case 44:
                    vsVar = (vs) SafeParcelReader.a(parcel, iA, vs.CREATOR);
                    break;
                case 45:
                    strG11 = SafeParcelReader.g(parcel, iA);
                    break;
                case 46:
                    zC13 = SafeParcelReader.c(parcel, iA);
                    break;
                case 47:
                    zC14 = SafeParcelReader.c(parcel, iA);
                    break;
                case 48:
                    bundleI = SafeParcelReader.i(parcel, iA);
                    break;
                case 49:
                    zC15 = SafeParcelReader.c(parcel, iA);
                    break;
                case 50:
                    iD4 = SafeParcelReader.d(parcel, iA);
                    break;
                case 51:
                    zC16 = SafeParcelReader.c(parcel, iA);
                    break;
                case 52:
                    arrayListM7 = SafeParcelReader.m(parcel, iA);
                    break;
                case 53:
                    zC17 = SafeParcelReader.c(parcel, iA);
                    break;
                case 54:
                    strG12 = SafeParcelReader.g(parcel, iA);
                    break;
                case 55:
                    strG13 = SafeParcelReader.g(parcel, iA);
                    break;
                case 56:
                    zC18 = SafeParcelReader.c(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new rm(iD, strG, strG2, arrayListM, iD2, arrayListM2, jE, zC, jE2, arrayListM3, jE3, iD3, strG3, jE4, strG4, zC2, strG5, strG6, zC3, zC4, zC5, zC6, zC7, ryVar, strG7, strG8, zC8, zC9, vhVar, arrayListM4, arrayListM5, zC10, roVar, zC11, strG9, arrayListM6, zC12, strG10, vsVar, strG11, zC13, zC14, bundleI, zC15, iD4, zC16, arrayListM7, zC17, strG12, strG13, zC18);
    }
}
