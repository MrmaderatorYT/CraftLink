package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class mp extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<mp> CREATOR = new mq();

    /* renamed from: a, reason: collision with root package name */
    private final int f3272a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3273b;
    private final int c;

    public static mp a(ail ailVar) {
        throw new NoSuchMethodError();
    }

    mp(int i, int i2, int i3) {
        this.f3272a = i;
        this.f3273b = i2;
        this.c = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f3272a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f3273b);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }

    public final String toString() {
        int i = this.f3272a;
        int i2 = this.f3273b;
        int i3 = this.c;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i);
        sb.append(".");
        sb.append(i2);
        sb.append(".");
        sb.append(i3);
        return sb.toString();
    }
}
