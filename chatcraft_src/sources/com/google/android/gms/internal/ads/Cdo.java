package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.ads.do, reason: invalid class name */
/* loaded from: classes.dex */
public final class Cdo extends azf implements dm {
    Cdo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.dm
    public final void a(cz czVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, czVar);
        b(1, parcelZ);
    }
}
