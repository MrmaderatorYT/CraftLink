package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class btb extends azf implements bsz {
    btb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // com.google.android.gms.internal.ads.bsz
    public final void a() {
        b(1, z());
    }

    @Override // com.google.android.gms.internal.ads.bsz
    public final void b() {
        b(2, z());
    }

    @Override // com.google.android.gms.internal.ads.bsz
    public final void c() {
        b(3, z());
    }

    @Override // com.google.android.gms.internal.ads.bsz
    public final void d() {
        b(4, z());
    }

    @Override // com.google.android.gms.internal.ads.bsz
    public final void a(boolean z) {
        Parcel parcelZ = z();
        azh.a(parcelZ, z);
        b(5, parcelZ);
    }
}
