package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class f extends am implements d {
    f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.d
    public final void a(Bundle bundle) {
        Parcel parcelA = a();
        ao.a(parcelA, bundle);
        a(1, parcelA);
    }
}
