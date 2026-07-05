package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class bql implements Parcelable.Creator<bqj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bqj[] newArray(int i) {
        return new bqj[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bqj createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        Bundle bundleI = null;
        ArrayList<String> arrayListM = null;
        String strG = null;
        bty btyVar = null;
        Location location = null;
        String strG2 = null;
        Bundle bundleI2 = null;
        Bundle bundleI3 = null;
        ArrayList<String> arrayListM2 = null;
        String strG3 = null;
        String strG4 = null;
        bqc bqcVar = null;
        String strG5 = null;
        long jE = 0;
        int iD = 0;
        int iD2 = 0;
        boolean zC = false;
        int iD3 = 0;
        boolean zC2 = false;
        boolean zC3 = false;
        int iD4 = 0;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 1:
                    iD = SafeParcelReader.d(parcel, iA);
                    break;
                case 2:
                    jE = SafeParcelReader.e(parcel, iA);
                    break;
                case 3:
                    bundleI = SafeParcelReader.i(parcel, iA);
                    break;
                case 4:
                    iD2 = SafeParcelReader.d(parcel, iA);
                    break;
                case 5:
                    arrayListM = SafeParcelReader.m(parcel, iA);
                    break;
                case 6:
                    zC = SafeParcelReader.c(parcel, iA);
                    break;
                case 7:
                    iD3 = SafeParcelReader.d(parcel, iA);
                    break;
                case 8:
                    zC2 = SafeParcelReader.c(parcel, iA);
                    break;
                case 9:
                    strG = SafeParcelReader.g(parcel, iA);
                    break;
                case 10:
                    btyVar = (bty) SafeParcelReader.a(parcel, iA, bty.CREATOR);
                    break;
                case 11:
                    location = (Location) SafeParcelReader.a(parcel, iA, Location.CREATOR);
                    break;
                case 12:
                    strG2 = SafeParcelReader.g(parcel, iA);
                    break;
                case 13:
                    bundleI2 = SafeParcelReader.i(parcel, iA);
                    break;
                case 14:
                    bundleI3 = SafeParcelReader.i(parcel, iA);
                    break;
                case 15:
                    arrayListM2 = SafeParcelReader.m(parcel, iA);
                    break;
                case 16:
                    strG3 = SafeParcelReader.g(parcel, iA);
                    break;
                case 17:
                    strG4 = SafeParcelReader.g(parcel, iA);
                    break;
                case 18:
                    zC3 = SafeParcelReader.c(parcel, iA);
                    break;
                case 19:
                    bqcVar = (bqc) SafeParcelReader.a(parcel, iA, bqc.CREATOR);
                    break;
                case 20:
                    iD4 = SafeParcelReader.d(parcel, iA);
                    break;
                case 21:
                    strG5 = SafeParcelReader.g(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new bqj(iD, jE, bundleI, iD2, arrayListM, zC, iD3, zC2, strG, btyVar, location, strG2, bundleI2, bundleI3, arrayListM2, strG3, strG4, zC3, bqcVar, iD4, strG5);
    }
}
