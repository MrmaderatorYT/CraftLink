package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.e;

/* loaded from: classes.dex */
public class c extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<c> CREATOR = new m();

    /* renamed from: a, reason: collision with root package name */
    String f1723a;

    /* renamed from: b, reason: collision with root package name */
    IBinder f1724b;
    Scope[] c;
    Bundle d;
    Account e;
    com.google.android.gms.common.c[] f;
    com.google.android.gms.common.c[] g;
    private final int h;
    private final int i;
    private int j;
    private boolean k;

    public c(int i) {
        this.h = 4;
        this.j = com.google.android.gms.common.d.f1702a;
        this.i = i;
        this.k = true;
    }

    c(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, com.google.android.gms.common.c[] cVarArr, com.google.android.gms.common.c[] cVarArr2, boolean z) {
        this.h = i;
        this.i = i2;
        this.j = i3;
        if ("com.google.android.gms".equals(str)) {
            this.f1723a = "com.google.android.gms";
        } else {
            this.f1723a = str;
        }
        if (i < 2) {
            this.e = iBinder != null ? a.a(e.a.a(iBinder)) : null;
        } else {
            this.f1724b = iBinder;
            this.e = account;
        }
        this.c = scopeArr;
        this.d = bundle;
        this.f = cVarArr;
        this.g = cVarArr2;
        this.k = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.h);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.i);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.j);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.f1723a, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.f1724b, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, (Parcelable[]) this.c, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, this.d, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, (Parcelable) this.e, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 10, (Parcelable[]) this.f, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 11, (Parcelable[]) this.g, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 12, this.k);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
