package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.h;

/* loaded from: classes.dex */
public final class Status extends com.google.android.gms.common.internal.safeparcel.a implements ReflectedParcelable {
    private final int h;
    private final int i;
    private final String j;
    private final PendingIntent k;

    /* renamed from: a, reason: collision with root package name */
    public static final Status f1688a = new Status(0);

    /* renamed from: b, reason: collision with root package name */
    public static final Status f1689b = new Status(14);
    public static final Status c = new Status(8);
    public static final Status d = new Status(15);
    public static final Status e = new Status(16);
    private static final Status g = new Status(17);
    public static final Status f = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new c();

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.h = i;
        this.i = i2;
        this.j = str;
        this.k = pendingIntent;
    }

    public Status(int i) {
        this(i, null);
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public final String a() {
        return this.j;
    }

    public final int b() {
        return this.i;
    }

    public final int hashCode() {
        return h.a(Integer.valueOf(this.h), Integer.valueOf(this.i), this.j, this.k);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.h == status.h && this.i == status.i && h.a(this.j, status.j) && h.a(this.k, status.k);
    }

    public final String c() {
        if (this.j != null) {
            return this.j;
        }
        return a.a(this.i);
    }

    public final String toString() {
        return h.a(this).a("statusCode", c()).a("resolution", this.k).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, b());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, a(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, (Parcelable) this.k, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1000, this.h);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
