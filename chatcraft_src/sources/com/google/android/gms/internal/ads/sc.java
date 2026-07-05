package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class sc extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<sc> CREATOR = new sd();

    /* renamed from: a, reason: collision with root package name */
    private final Bundle f3437a;

    /* renamed from: b, reason: collision with root package name */
    private final aar f3438b;
    private final ApplicationInfo c;
    private final String d;
    private final List<String> e;

    @Nullable
    private final PackageInfo f;
    private final String g;
    private final boolean h;
    private final String i;

    public sc(Bundle bundle, aar aarVar, ApplicationInfo applicationInfo, String str, List<String> list, @Nullable PackageInfo packageInfo, String str2, boolean z, String str3) {
        this.f3437a = bundle;
        this.f3438b = aarVar;
        this.d = str;
        this.c = applicationInfo;
        this.e = list;
        this.f = packageInfo;
        this.g = str2;
        this.h = z;
        this.i = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f3437a, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, (Parcelable) this.f3438b, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, (Parcelable) this.c, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.d, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 5, this.e, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, (Parcelable) this.f, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, this.g, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, this.h);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, this.i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
