package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class c extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<c> CREATOR = new i();

    /* renamed from: a, reason: collision with root package name */
    private final String f1700a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    private final int f1701b;
    private final long c;

    public c(String str, int i, long j) {
        this.f1700a = str;
        this.f1701b = i;
        this.c = j;
    }

    public String a() {
        return this.f1700a;
    }

    public long b() {
        return this.c == -1 ? this.f1701b : this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, a(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f1701b);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, b());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return ((a() != null && a().equals(cVar.a())) || (a() == null && cVar.a() == null)) && b() == cVar.b();
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.h.a(a(), Long.valueOf(b()));
    }

    public String toString() {
        return com.google.android.gms.common.internal.h.a(this).a("name", a()).a("version", Long.valueOf(b())).toString();
    }
}
