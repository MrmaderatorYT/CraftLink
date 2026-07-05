package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class s extends com.google.android.gms.internal.b.a implements f {
    s(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // com.google.android.gms.common.internal.f
    public final void a(int i, IBinder iBinder, Bundle bundle) {
        Parcel parcelB = b();
        parcelB.writeInt(i);
        parcelB.writeStrongBinder(iBinder);
        com.google.android.gms.internal.b.c.a(parcelB, bundle);
        b(1, parcelB);
    }

    @Override // com.google.android.gms.common.internal.f
    public final void a(int i, Bundle bundle) {
        Parcel parcelB = b();
        parcelB.writeInt(i);
        com.google.android.gms.internal.b.c.a(parcelB, bundle);
        b(2, parcelB);
    }

    @Override // com.google.android.gms.common.internal.f
    public final void a(int i, IBinder iBinder, k kVar) {
        Parcel parcelB = b();
        parcelB.writeInt(i);
        parcelB.writeStrongBinder(iBinder);
        com.google.android.gms.internal.b.c.a(parcelB, kVar);
        b(3, parcelB);
    }
}
