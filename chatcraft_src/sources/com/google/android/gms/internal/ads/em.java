package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

@qj
/* loaded from: classes.dex */
public final class em extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<em> CREATOR = new en();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3068a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3069b;
    public final int c;
    public final byte[] d;
    public final String[] e;
    public final String[] f;
    public final boolean g;
    public final long h;

    em(boolean z, String str, int i, byte[] bArr, String[] strArr, String[] strArr2, boolean z2, long j) {
        this.f3068a = z;
        this.f3069b = str;
        this.c = i;
        this.d = bArr;
        this.e = strArr;
        this.f = strArr2;
        this.g = z2;
        this.h = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f3068a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f3069b, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.d, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.e, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, this.f, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, this.g);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, this.h);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
