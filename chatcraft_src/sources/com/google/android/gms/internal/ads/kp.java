package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;
import java.util.List;

/* loaded from: classes.dex */
public final class kp extends azf implements kn {
    kp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqn bqnVar, bqj bqjVar, String str, kq kqVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, bqnVar);
        azh.a(parcelZ, bqjVar);
        parcelZ.writeString(str);
        azh.a(parcelZ, kqVar);
        b(1, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final com.google.android.gms.dynamic.a a() {
        Parcel parcelA = a(2, z());
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqj bqjVar, String str, kq kqVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, bqjVar);
        parcelZ.writeString(str);
        azh.a(parcelZ, kqVar);
        b(3, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void b() {
        b(4, z());
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void c() {
        b(5, z());
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqn bqnVar, bqj bqjVar, String str, String str2, kq kqVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, bqnVar);
        azh.a(parcelZ, bqjVar);
        parcelZ.writeString(str);
        parcelZ.writeString(str2);
        azh.a(parcelZ, kqVar);
        b(6, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqj bqjVar, String str, String str2, kq kqVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, bqjVar);
        parcelZ.writeString(str);
        parcelZ.writeString(str2);
        azh.a(parcelZ, kqVar);
        b(7, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void d() {
        b(8, z());
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void e() {
        b(9, z());
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqj bqjVar, String str, vc vcVar, String str2) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, bqjVar);
        parcelZ.writeString(str);
        azh.a(parcelZ, vcVar);
        parcelZ.writeString(str2);
        b(10, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(bqj bqjVar, String str) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bqjVar);
        parcelZ.writeString(str);
        b(11, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void f() {
        b(12, z());
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final boolean g() {
        Parcel parcelA = a(13, z());
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqj bqjVar, String str, String str2, kq kqVar, br brVar, List<String> list) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, bqjVar);
        parcelZ.writeString(str);
        parcelZ.writeString(str2);
        azh.a(parcelZ, kqVar);
        azh.a(parcelZ, brVar);
        parcelZ.writeStringList(list);
        b(14, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final kw h() {
        kw kyVar;
        Parcel parcelA = a(15, z());
        IBinder strongBinder = parcelA.readStrongBinder();
        if (strongBinder == null) {
            kyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            if (iInterfaceQueryLocalInterface instanceof kw) {
                kyVar = (kw) iInterfaceQueryLocalInterface;
            } else {
                kyVar = new ky(strongBinder);
            }
        }
        parcelA.recycle();
        return kyVar;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final kz i() {
        kz lbVar;
        Parcel parcelA = a(16, z());
        IBinder strongBinder = parcelA.readStrongBinder();
        if (strongBinder == null) {
            lbVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            if (iInterfaceQueryLocalInterface instanceof kz) {
                lbVar = (kz) iInterfaceQueryLocalInterface;
            } else {
                lbVar = new lb(strongBinder);
            }
        }
        parcelA.recycle();
        return lbVar;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final Bundle j() {
        Parcel parcelA = a(17, z());
        Bundle bundle = (Bundle) azh.a(parcelA, Bundle.CREATOR);
        parcelA.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final Bundle k() {
        Parcel parcelA = a(18, z());
        Bundle bundle = (Bundle) azh.a(parcelA, Bundle.CREATOR);
        parcelA.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final Bundle l() {
        Parcel parcelA = a(19, z());
        Bundle bundle = (Bundle) azh.a(parcelA, Bundle.CREATOR);
        parcelA.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(bqj bqjVar, String str, String str2) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bqjVar);
        parcelZ.writeString(str);
        parcelZ.writeString(str2);
        b(20, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        b(21, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final boolean m() {
        Parcel parcelA = a(22, z());
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, vc vcVar, List<String> list) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, vcVar);
        parcelZ.writeStringList(list);
        b(23, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final cz n() {
        Parcel parcelA = a(24, z());
        cz czVarA = da.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return czVarA;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(boolean z) {
        Parcel parcelZ = z();
        azh.a(parcelZ, z);
        b(25, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final bsw o() {
        Parcel parcelA = a(26, z());
        bsw bswVarA = bsx.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return bswVarA;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final lc p() {
        lc lfVar;
        Parcel parcelA = a(27, z());
        IBinder strongBinder = parcelA.readStrongBinder();
        if (strongBinder == null) {
            lfVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            if (iInterfaceQueryLocalInterface instanceof lc) {
                lfVar = (lc) iInterfaceQueryLocalInterface;
            } else {
                lfVar = new lf(strongBinder);
            }
        }
        parcelA.recycle();
        return lfVar;
    }
}
