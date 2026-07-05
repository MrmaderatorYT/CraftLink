package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.internal.ads.aar;
import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.bqa;
import com.google.android.gms.internal.ads.qj;

@qj
/* loaded from: classes.dex */
public final class AdOverlayInfoParcel extends com.google.android.gms.common.internal.safeparcel.a implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new m();

    /* renamed from: a, reason: collision with root package name */
    public final c f1622a;

    /* renamed from: b, reason: collision with root package name */
    public final bqa f1623b;
    public final n c;
    public final afu d;
    public final com.google.android.gms.ads.internal.gmsg.l e;
    public final String f;
    public final boolean g;
    public final String h;
    public final t i;
    public final int j;
    public final int k;
    public final String l;
    public final aar m;
    public final String n;
    public final com.google.android.gms.ads.internal.r o;
    public final com.google.android.gms.ads.internal.gmsg.j p;

    public static void a(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    public AdOverlayInfoParcel(bqa bqaVar, n nVar, t tVar, afu afuVar, int i, aar aarVar, String str, com.google.android.gms.ads.internal.r rVar) {
        this.f1622a = null;
        this.f1623b = bqaVar;
        this.c = nVar;
        this.d = afuVar;
        this.p = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = null;
        this.i = tVar;
        this.j = i;
        this.k = 1;
        this.l = null;
        this.m = aarVar;
        this.n = str;
        this.o = rVar;
    }

    public AdOverlayInfoParcel(bqa bqaVar, n nVar, t tVar, afu afuVar, boolean z, int i, aar aarVar) {
        this.f1622a = null;
        this.f1623b = bqaVar;
        this.c = nVar;
        this.d = afuVar;
        this.p = null;
        this.e = null;
        this.f = null;
        this.g = z;
        this.h = null;
        this.i = tVar;
        this.j = i;
        this.k = 2;
        this.l = null;
        this.m = aarVar;
        this.n = null;
        this.o = null;
    }

    public AdOverlayInfoParcel(bqa bqaVar, n nVar, com.google.android.gms.ads.internal.gmsg.j jVar, com.google.android.gms.ads.internal.gmsg.l lVar, t tVar, afu afuVar, boolean z, int i, String str, aar aarVar) {
        this.f1622a = null;
        this.f1623b = bqaVar;
        this.c = nVar;
        this.d = afuVar;
        this.p = jVar;
        this.e = lVar;
        this.f = null;
        this.g = z;
        this.h = null;
        this.i = tVar;
        this.j = i;
        this.k = 3;
        this.l = str;
        this.m = aarVar;
        this.n = null;
        this.o = null;
    }

    public AdOverlayInfoParcel(bqa bqaVar, n nVar, com.google.android.gms.ads.internal.gmsg.j jVar, com.google.android.gms.ads.internal.gmsg.l lVar, t tVar, afu afuVar, boolean z, int i, String str, String str2, aar aarVar) {
        this.f1622a = null;
        this.f1623b = bqaVar;
        this.c = nVar;
        this.d = afuVar;
        this.p = jVar;
        this.e = lVar;
        this.f = str2;
        this.g = z;
        this.h = str;
        this.i = tVar;
        this.j = i;
        this.k = 3;
        this.l = null;
        this.m = aarVar;
        this.n = null;
        this.o = null;
    }

    public AdOverlayInfoParcel(c cVar, bqa bqaVar, n nVar, t tVar, aar aarVar) {
        this.f1622a = cVar;
        this.f1623b = bqaVar;
        this.c = nVar;
        this.d = null;
        this.p = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = null;
        this.i = tVar;
        this.j = -1;
        this.k = 4;
        this.l = null;
        this.m = aarVar;
        this.n = null;
        this.o = null;
    }

    AdOverlayInfoParcel(c cVar, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i, int i2, String str3, aar aarVar, String str4, com.google.android.gms.ads.internal.r rVar, IBinder iBinder6) {
        this.f1622a = cVar;
        this.f1623b = (bqa) com.google.android.gms.dynamic.b.a(a.AbstractBinderC0069a.a(iBinder));
        this.c = (n) com.google.android.gms.dynamic.b.a(a.AbstractBinderC0069a.a(iBinder2));
        this.d = (afu) com.google.android.gms.dynamic.b.a(a.AbstractBinderC0069a.a(iBinder3));
        this.p = (com.google.android.gms.ads.internal.gmsg.j) com.google.android.gms.dynamic.b.a(a.AbstractBinderC0069a.a(iBinder6));
        this.e = (com.google.android.gms.ads.internal.gmsg.l) com.google.android.gms.dynamic.b.a(a.AbstractBinderC0069a.a(iBinder4));
        this.f = str;
        this.g = z;
        this.h = str2;
        this.i = (t) com.google.android.gms.dynamic.b.a(a.AbstractBinderC0069a.a(iBinder5));
        this.j = i;
        this.k = i2;
        this.l = str3;
        this.m = aarVar;
        this.n = str4;
        this.o = rVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, (Parcelable) this.f1622a, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, com.google.android.gms.dynamic.b.a(this.f1623b).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, com.google.android.gms.dynamic.b.a(this.c).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, com.google.android.gms.dynamic.b.a(this.d).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, com.google.android.gms.dynamic.b.a(this.e).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, this.f, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, this.g);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, this.h, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 10, com.google.android.gms.dynamic.b.a(this.i).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 11, this.j);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 12, this.k);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 13, this.l, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 14, (Parcelable) this.m, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 16, this.n, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 17, (Parcelable) this.o, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 18, com.google.android.gms.dynamic.b.a(this.p).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
