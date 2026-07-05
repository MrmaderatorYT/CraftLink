package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class k extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<k> CREATOR = new l();

    /* renamed from: a, reason: collision with root package name */
    public final long f3694a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3695b;
    public final boolean c;
    public final String d;
    public final String e;
    public final String f;
    public final Bundle g;

    k(long j, long j2, boolean z, String str, String str2, String str3, Bundle bundle) {
        this.f3694a = j;
        this.f3695b = j2;
        this.c = z;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f3694a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f3695b);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.d, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.e, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, this.f, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, this.g, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
