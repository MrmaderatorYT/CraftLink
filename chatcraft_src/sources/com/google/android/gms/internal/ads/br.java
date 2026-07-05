package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

@qj
/* loaded from: classes.dex */
public final class br extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<br> CREATOR = new bs();

    /* renamed from: a, reason: collision with root package name */
    public final int f2996a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2997b;
    public final int c;
    public final boolean d;
    public final int e;
    public final buc f;
    private final boolean g;

    public br(com.google.android.gms.ads.b.d dVar) {
        this(3, dVar.a(), dVar.b(), dVar.c(), dVar.d(), dVar.e() != null ? new buc(dVar.e()) : null, dVar.f());
    }

    public br(int i, boolean z, int i2, boolean z2, int i3, buc bucVar, boolean z3) {
        this.f2996a = i;
        this.f2997b = z;
        this.c = i2;
        this.d = z2;
        this.e = i3;
        this.f = bucVar;
        this.g = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f2996a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f2997b);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.d);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.e);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, (Parcelable) this.f, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, this.g);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
