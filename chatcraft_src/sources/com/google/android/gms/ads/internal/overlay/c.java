package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.qj;

@qj
/* loaded from: classes.dex */
public final class c extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<c> CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    public final String f1624a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1625b;
    public final String c;
    public final String d;
    public final String e;
    public final Intent f;
    private final String g;
    private final String h;

    public c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(str, str2, str3, str4, str5, str6, str7, null);
    }

    public c(Intent intent) {
        this(null, null, null, null, null, null, null, intent);
    }

    public c(String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent) {
        this.g = str;
        this.f1624a = str2;
        this.f1625b = str3;
        this.c = str4;
        this.d = str5;
        this.e = str6;
        this.h = str7;
        this.f = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.g, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.f1624a, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.f1625b, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.c, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, this.d, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, this.e, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, this.h, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, (Parcelable) this.f, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
