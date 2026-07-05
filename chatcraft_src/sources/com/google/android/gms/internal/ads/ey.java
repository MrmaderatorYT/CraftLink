package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class ey extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<ey> CREATOR = new fa();

    /* renamed from: a, reason: collision with root package name */
    public final int f3078a;

    public ey(int i) {
        this.f3078a = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f3078a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
