package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class c implements Parcelable.Creator<Status> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status[] newArray(int i) {
        return new Status[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        int iD = 0;
        String strG = null;
        PendingIntent pendingIntent = null;
        int iD2 = 0;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            int iA2 = SafeParcelReader.a(iA);
            if (iA2 != 1000) {
                switch (iA2) {
                    case 1:
                        iD2 = SafeParcelReader.d(parcel, iA);
                        break;
                    case 2:
                        strG = SafeParcelReader.g(parcel, iA);
                        break;
                    case 3:
                        pendingIntent = (PendingIntent) SafeParcelReader.a(parcel, iA, PendingIntent.CREATOR);
                        break;
                    default:
                        SafeParcelReader.b(parcel, iA);
                        break;
                }
            } else {
                iD = SafeParcelReader.d(parcel, iA);
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new Status(iD, iD2, strG, pendingIntent);
    }
}
