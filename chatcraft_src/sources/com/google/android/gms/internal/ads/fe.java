package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class fe extends azf implements fd {
    fe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.fd
    public final void a() {
        b(1, z());
    }

    @Override // com.google.android.gms.internal.ads.fd
    public final void a(int i) {
        Parcel parcelZ = z();
        parcelZ.writeInt(i);
        b(2, parcelZ);
    }
}
