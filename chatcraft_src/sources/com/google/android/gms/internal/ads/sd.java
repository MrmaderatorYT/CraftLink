package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class sd implements Parcelable.Creator<sc> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ sc[] newArray(int i) {
        return new sc[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ sc createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        Bundle bundleI = null;
        aar aarVar = null;
        ApplicationInfo applicationInfo = null;
        String strG = null;
        ArrayList<String> arrayListM = null;
        PackageInfo packageInfo = null;
        String strG2 = null;
        String strG3 = null;
        boolean zC = false;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 1:
                    bundleI = SafeParcelReader.i(parcel, iA);
                    break;
                case 2:
                    aarVar = (aar) SafeParcelReader.a(parcel, iA, aar.CREATOR);
                    break;
                case 3:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.a(parcel, iA, ApplicationInfo.CREATOR);
                    break;
                case 4:
                    strG = SafeParcelReader.g(parcel, iA);
                    break;
                case 5:
                    arrayListM = SafeParcelReader.m(parcel, iA);
                    break;
                case 6:
                    packageInfo = (PackageInfo) SafeParcelReader.a(parcel, iA, PackageInfo.CREATOR);
                    break;
                case 7:
                    strG2 = SafeParcelReader.g(parcel, iA);
                    break;
                case 8:
                    zC = SafeParcelReader.c(parcel, iA);
                    break;
                case 9:
                    strG3 = SafeParcelReader.g(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new sc(bundleI, aarVar, applicationInfo, strG, arrayListM, packageInfo, strG2, zC, strG3);
    }
}
