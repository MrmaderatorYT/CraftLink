package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class brj extends azf implements brh {
    brj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void a() {
        b(1, z());
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void a(int i) {
        Parcel parcelZ = z();
        parcelZ.writeInt(i);
        b(2, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void b() {
        b(3, z());
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void c() {
        b(4, z());
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void d() {
        b(5, z());
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void f() {
        b(6, z());
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void e() {
        b(7, z());
    }
}
