package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class rk implements Parcelable.Creator<ri> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ri[] newArray(int i) {
        return new ri[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ri createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        long jE = 0;
        long jE2 = 0;
        Bundle bundleI = null;
        bqj bqjVar = null;
        bqn bqnVar = null;
        String strG = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String strG2 = null;
        String strG3 = null;
        String strG4 = null;
        aar aarVar = null;
        Bundle bundleI2 = null;
        ArrayList<String> arrayListM = null;
        Bundle bundleI3 = null;
        String strG5 = null;
        String strG6 = null;
        ArrayList<String> arrayListM2 = null;
        String strG7 = null;
        br brVar = null;
        ArrayList<String> arrayListM3 = null;
        String strG8 = null;
        String strG9 = null;
        String strG10 = null;
        Bundle bundleI4 = null;
        String strG11 = null;
        btc btcVar = null;
        Bundle bundleI5 = null;
        String strG12 = null;
        String strG13 = null;
        String strG14 = null;
        ArrayList<Integer> arrayListL = null;
        String strG15 = null;
        ArrayList<String> arrayListM4 = null;
        ArrayList<String> arrayListM5 = null;
        String strG16 = null;
        ey eyVar = null;
        String strG17 = null;
        Bundle bundleI6 = null;
        int iD = 0;
        int iD2 = 0;
        boolean zC = false;
        int iD3 = 0;
        int iD4 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean zC2 = false;
        int iD5 = 0;
        int iD6 = 0;
        boolean zC3 = false;
        boolean zC4 = false;
        boolean zC5 = false;
        int iD7 = 0;
        boolean zC6 = false;
        boolean zC7 = false;
        int iD8 = 0;
        boolean zC8 = false;
        boolean zC9 = false;
        boolean zC10 = false;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 1:
                    iD = SafeParcelReader.d(parcel, iA);
                    break;
                case 2:
                    bundleI = SafeParcelReader.i(parcel, iA);
                    break;
                case 3:
                    bqjVar = (bqj) SafeParcelReader.a(parcel, iA, bqj.CREATOR);
                    break;
                case 4:
                    bqnVar = (bqn) SafeParcelReader.a(parcel, iA, bqn.CREATOR);
                    break;
                case 5:
                    strG = SafeParcelReader.g(parcel, iA);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.a(parcel, iA, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) SafeParcelReader.a(parcel, iA, PackageInfo.CREATOR);
                    break;
                case 8:
                    strG2 = SafeParcelReader.g(parcel, iA);
                    break;
                case 9:
                    strG3 = SafeParcelReader.g(parcel, iA);
                    break;
                case 10:
                    strG4 = SafeParcelReader.g(parcel, iA);
                    break;
                case 11:
                    aarVar = (aar) SafeParcelReader.a(parcel, iA, aar.CREATOR);
                    break;
                case 12:
                    bundleI2 = SafeParcelReader.i(parcel, iA);
                    break;
                case 13:
                    iD2 = SafeParcelReader.d(parcel, iA);
                    break;
                case 14:
                    arrayListM = SafeParcelReader.m(parcel, iA);
                    break;
                case 15:
                    bundleI3 = SafeParcelReader.i(parcel, iA);
                    break;
                case 16:
                    zC = SafeParcelReader.c(parcel, iA);
                    break;
                case 17:
                case 22:
                case 23:
                case 24:
                case 32:
                case 62:
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
                case 18:
                    iD3 = SafeParcelReader.d(parcel, iA);
                    break;
                case 19:
                    iD4 = SafeParcelReader.d(parcel, iA);
                    break;
                case 20:
                    f = SafeParcelReader.f(parcel, iA);
                    break;
                case 21:
                    strG5 = SafeParcelReader.g(parcel, iA);
                    break;
                case 25:
                    jE = SafeParcelReader.e(parcel, iA);
                    break;
                case 26:
                    strG6 = SafeParcelReader.g(parcel, iA);
                    break;
                case 27:
                    arrayListM2 = SafeParcelReader.m(parcel, iA);
                    break;
                case 28:
                    strG7 = SafeParcelReader.g(parcel, iA);
                    break;
                case 29:
                    brVar = (br) SafeParcelReader.a(parcel, iA, br.CREATOR);
                    break;
                case 30:
                    arrayListM3 = SafeParcelReader.m(parcel, iA);
                    break;
                case 31:
                    jE2 = SafeParcelReader.e(parcel, iA);
                    break;
                case 33:
                    strG8 = SafeParcelReader.g(parcel, iA);
                    break;
                case 34:
                    f2 = SafeParcelReader.f(parcel, iA);
                    break;
                case 35:
                    iD5 = SafeParcelReader.d(parcel, iA);
                    break;
                case 36:
                    iD6 = SafeParcelReader.d(parcel, iA);
                    break;
                case 37:
                    zC3 = SafeParcelReader.c(parcel, iA);
                    break;
                case 38:
                    zC4 = SafeParcelReader.c(parcel, iA);
                    break;
                case 39:
                    strG9 = SafeParcelReader.g(parcel, iA);
                    break;
                case 40:
                    zC2 = SafeParcelReader.c(parcel, iA);
                    break;
                case 41:
                    strG10 = SafeParcelReader.g(parcel, iA);
                    break;
                case 42:
                    zC5 = SafeParcelReader.c(parcel, iA);
                    break;
                case 43:
                    iD7 = SafeParcelReader.d(parcel, iA);
                    break;
                case 44:
                    bundleI4 = SafeParcelReader.i(parcel, iA);
                    break;
                case 45:
                    strG11 = SafeParcelReader.g(parcel, iA);
                    break;
                case 46:
                    btcVar = (btc) SafeParcelReader.a(parcel, iA, btc.CREATOR);
                    break;
                case 47:
                    zC6 = SafeParcelReader.c(parcel, iA);
                    break;
                case 48:
                    bundleI5 = SafeParcelReader.i(parcel, iA);
                    break;
                case 49:
                    strG12 = SafeParcelReader.g(parcel, iA);
                    break;
                case 50:
                    strG13 = SafeParcelReader.g(parcel, iA);
                    break;
                case 51:
                    strG14 = SafeParcelReader.g(parcel, iA);
                    break;
                case 52:
                    zC7 = SafeParcelReader.c(parcel, iA);
                    break;
                case 53:
                    arrayListL = SafeParcelReader.l(parcel, iA);
                    break;
                case 54:
                    strG15 = SafeParcelReader.g(parcel, iA);
                    break;
                case 55:
                    arrayListM4 = SafeParcelReader.m(parcel, iA);
                    break;
                case 56:
                    iD8 = SafeParcelReader.d(parcel, iA);
                    break;
                case 57:
                    zC8 = SafeParcelReader.c(parcel, iA);
                    break;
                case 58:
                    zC9 = SafeParcelReader.c(parcel, iA);
                    break;
                case 59:
                    zC10 = SafeParcelReader.c(parcel, iA);
                    break;
                case 60:
                    arrayListM5 = SafeParcelReader.m(parcel, iA);
                    break;
                case 61:
                    strG16 = SafeParcelReader.g(parcel, iA);
                    break;
                case 63:
                    eyVar = (ey) SafeParcelReader.a(parcel, iA, ey.CREATOR);
                    break;
                case 64:
                    strG17 = SafeParcelReader.g(parcel, iA);
                    break;
                case 65:
                    bundleI6 = SafeParcelReader.i(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new ri(iD, bundleI, bqjVar, bqnVar, strG, applicationInfo, packageInfo, strG2, strG3, strG4, aarVar, bundleI2, iD2, arrayListM, bundleI3, zC, iD3, iD4, f, strG5, jE, strG6, arrayListM2, strG7, brVar, arrayListM3, jE2, strG8, f2, zC2, iD5, iD6, zC3, zC4, strG9, strG10, zC5, iD7, bundleI4, strG11, btcVar, zC6, bundleI5, strG12, strG13, strG14, zC7, arrayListL, strG15, arrayListM4, iD8, zC8, zC9, zC10, arrayListM5, strG16, eyVar, strG17, bundleI6);
    }
}
