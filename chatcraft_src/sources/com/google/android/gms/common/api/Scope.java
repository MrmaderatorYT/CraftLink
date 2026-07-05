package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.i;

/* loaded from: classes.dex */
public final class Scope extends com.google.android.gms.common.internal.safeparcel.a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    private final int f1686a;

    /* renamed from: b, reason: collision with root package name */
    private final String f1687b;

    Scope(int i, String str) {
        i.a(str, (Object) "scopeUri must not be null or empty");
        this.f1686a = i;
        this.f1687b = str;
    }

    public final String a() {
        return this.f1687b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f1687b.equals(((Scope) obj).f1687b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1687b.hashCode();
    }

    public final String toString() {
        return this.f1687b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f1686a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, a(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
