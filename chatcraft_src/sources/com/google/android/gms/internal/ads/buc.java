package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

@qj
/* loaded from: classes.dex */
public final class buc extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<buc> CREATOR = new bud();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3034a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3035b;
    public final boolean c;

    public buc(com.google.android.gms.ads.k kVar) {
        this(kVar.a(), kVar.b(), kVar.c());
    }

    public buc(boolean z, boolean z2, boolean z3) {
        this.f3034a = z;
        this.f3035b = z2;
        this.c = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f3034a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.f3035b);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
