package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class m implements Parcelable.Creator<c> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c[] newArray(int i) {
        return new c[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        String strG = null;
        IBinder iBinderH = null;
        Scope[] scopeArr = null;
        Bundle bundleI = null;
        Account account = null;
        com.google.android.gms.common.c[] cVarArr = null;
        com.google.android.gms.common.c[] cVarArr2 = null;
        int iD = 0;
        int iD2 = 0;
        int iD3 = 0;
        boolean zC = false;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 1:
                    iD = SafeParcelReader.d(parcel, iA);
                    break;
                case 2:
                    iD2 = SafeParcelReader.d(parcel, iA);
                    break;
                case 3:
                    iD3 = SafeParcelReader.d(parcel, iA);
                    break;
                case 4:
                    strG = SafeParcelReader.g(parcel, iA);
                    break;
                case 5:
                    iBinderH = SafeParcelReader.h(parcel, iA);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.b(parcel, iA, Scope.CREATOR);
                    break;
                case 7:
                    bundleI = SafeParcelReader.i(parcel, iA);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.a(parcel, iA, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
                case 10:
                    cVarArr = (com.google.android.gms.common.c[]) SafeParcelReader.b(parcel, iA, com.google.android.gms.common.c.CREATOR);
                    break;
                case 11:
                    cVarArr2 = (com.google.android.gms.common.c[]) SafeParcelReader.b(parcel, iA, com.google.android.gms.common.c.CREATOR);
                    break;
                case 12:
                    zC = SafeParcelReader.c(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new c(iD, iD2, iD3, strG, iBinderH, scopeArr, bundleI, account, cVarArr, cVarArr2, zC);
    }
}
