package com.google.android.gms.ads.b;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.bsa;
import com.google.android.gms.internal.ads.bsb;
import com.google.android.gms.internal.ads.qj;

@qj
/* loaded from: classes.dex */
public final class j extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<j> CREATOR = new n();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1478a;

    /* renamed from: b, reason: collision with root package name */
    private final bsa f1479b;

    j(boolean z, IBinder iBinder) {
        this.f1478a = z;
        this.f1479b = iBinder != null ? bsb.a(iBinder) : null;
    }

    public final boolean a() {
        return this.f1478a;
    }

    public final bsa b() {
        return this.f1479b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, a());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f1479b == null ? null : this.f1479b.asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
