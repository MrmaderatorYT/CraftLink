package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class fh extends azf implements ff {
    fh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.ff
    public final void a(fb fbVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, fbVar);
        b(1, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.ff
    public final void a(int i) {
        Parcel parcelZ = z();
        parcelZ.writeInt(i);
        b(2, parcelZ);
    }
}
