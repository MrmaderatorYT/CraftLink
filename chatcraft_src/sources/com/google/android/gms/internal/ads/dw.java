package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class dw extends azf implements dv {
    dw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    @Override // com.google.android.gms.internal.ads.dv
    public final void a(String str) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        b(1, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.dv
    public final void a() {
        b(2, z());
    }
}
