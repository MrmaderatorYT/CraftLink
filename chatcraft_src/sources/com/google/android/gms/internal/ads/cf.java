package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

/* loaded from: classes.dex */
public final class cf extends azf implements cd {
    cf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.cd
    public final com.google.android.gms.dynamic.a a() {
        Parcel parcelA = a(1, z());
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }

    @Override // com.google.android.gms.internal.ads.cd
    public final Uri b() {
        Parcel parcelA = a(2, z());
        Uri uri = (Uri) azh.a(parcelA, Uri.CREATOR);
        parcelA.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.cd
    public final double c() {
        Parcel parcelA = a(3, z());
        double d = parcelA.readDouble();
        parcelA.recycle();
        return d;
    }
}
