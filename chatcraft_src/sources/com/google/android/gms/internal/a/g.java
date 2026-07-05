package com.google.android.gms.internal.a;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class g extends a implements e {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // com.google.android.gms.internal.a.e
    public final String a() {
        Parcel parcelA = a(1, s_());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.a.e
    public final boolean a(boolean z) {
        Parcel parcelS_ = s_();
        c.a(parcelS_, true);
        Parcel parcelA = a(2, parcelS_);
        boolean zA = c.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.a.e
    public final boolean b() {
        Parcel parcelA = a(6, s_());
        boolean zA = c.a(parcelA);
        parcelA.recycle();
        return zA;
    }
}
