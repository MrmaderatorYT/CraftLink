package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

/* loaded from: classes.dex */
public final class bru extends azf implements brs {
    bru(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final com.google.android.gms.dynamic.a k() {
        Parcel parcelA = a(1, z());
        com.google.android.gms.dynamic.a aVarA = a.AbstractBinderC0069a.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarA;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void j() {
        b(2, z());
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final boolean m() {
        Parcel parcelA = a(3, z());
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final boolean b(bqj bqjVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bqjVar);
        Parcel parcelA = a(4, parcelZ);
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void o() {
        b(5, z());
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void p() {
        b(6, z());
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(brh brhVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, brhVar);
        b(7, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(bsa bsaVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bsaVar);
        b(8, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void H() {
        b(9, z());
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void r() {
        b(10, z());
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void n() {
        b(11, z());
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final bqn l() {
        Parcel parcelA = a(12, z());
        bqn bqnVar = (bqn) azh.a(parcelA, bqn.CREATOR);
        parcelA.recycle();
        return bqnVar;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(bqn bqnVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bqnVar);
        b(13, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(nt ntVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, ntVar);
        b(14, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(oa oaVar, String str) {
        Parcel parcelZ = z();
        azh.a(parcelZ, oaVar);
        parcelZ.writeString(str);
        b(15, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final String a() {
        Parcel parcelA = a(18, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(ai aiVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aiVar);
        b(19, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(brd brdVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, brdVar);
        b(20, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(bsg bsgVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bsgVar);
        b(21, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void b(boolean z) {
        Parcel parcelZ = z();
        azh.a(parcelZ, z);
        b(22, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final boolean s() {
        Parcel parcelA = a(23, z());
        boolean zA = azh.a(parcelA);
        parcelA.recycle();
        return zA;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(ue ueVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, ueVar);
        b(24, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(String str) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        b(25, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final bsw t() {
        bsw bsyVar;
        Parcel parcelA = a(26, z());
        IBinder strongBinder = parcelA.readStrongBinder();
        if (strongBinder == null) {
            bsyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            if (iInterfaceQueryLocalInterface instanceof bsw) {
                bsyVar = (bsw) iInterfaceQueryLocalInterface;
            } else {
                bsyVar = new bsy(strongBinder);
            }
        }
        parcelA.recycle();
        return bsyVar;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(buc bucVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, bucVar);
        b(29, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(btc btcVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, btcVar);
        b(30, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final String D() {
        Parcel parcelA = a(31, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final bsa E() {
        bsa bscVar;
        Parcel parcelA = a(32, z());
        IBinder strongBinder = parcelA.readStrongBinder();
        if (strongBinder == null) {
            bscVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            if (iInterfaceQueryLocalInterface instanceof bsa) {
                bscVar = (bsa) iInterfaceQueryLocalInterface;
            } else {
                bscVar = new bsc(strongBinder);
            }
        }
        parcelA.recycle();
        return bscVar;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final brh F() {
        brh brjVar;
        Parcel parcelA = a(33, z());
        IBinder strongBinder = parcelA.readStrongBinder();
        if (strongBinder == null) {
            brjVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            if (iInterfaceQueryLocalInterface instanceof brh) {
                brjVar = (brh) iInterfaceQueryLocalInterface;
            } else {
                brjVar = new brj(strongBinder);
            }
        }
        parcelA.recycle();
        return brjVar;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void c(boolean z) {
        Parcel parcelZ = z();
        azh.a(parcelZ, z);
        b(34, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final String q_() {
        Parcel parcelA = a(35, z());
        String string = parcelA.readString();
        parcelA.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(brx brxVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, brxVar);
        b(36, parcelZ);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final Bundle q() {
        Parcel parcelA = a(37, z());
        Bundle bundle = (Bundle) azh.a(parcelA, Bundle.CREATOR);
        parcelA.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void b(String str) {
        Parcel parcelZ = z();
        parcelZ.writeString(str);
        b(38, parcelZ);
    }
}
