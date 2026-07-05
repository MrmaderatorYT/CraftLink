package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class ak extends azf implements ai {
    ak(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.ai
    public final void a(af afVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, afVar);
        b(1, parcelZ);
    }
}
