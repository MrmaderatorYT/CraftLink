package com.google.android.gms.internal.ads;

import android.location.Location;
import java.util.Date;
import java.util.Set;

@qj
/* loaded from: classes.dex */
public final class lh implements com.google.android.gms.ads.mediation.a {

    /* renamed from: a, reason: collision with root package name */
    private final Date f3239a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3240b;
    private final Set<String> c;
    private final boolean d;
    private final Location e;
    private final int f;
    private final boolean g;

    public lh(Date date, int i, Set<String> set, Location location, boolean z, int i2, boolean z2) {
        this.f3239a = date;
        this.f3240b = i;
        this.c = set;
        this.e = location;
        this.d = z;
        this.f = i2;
        this.g = z2;
    }

    @Override // com.google.android.gms.ads.mediation.a
    @Deprecated
    public final Date a() {
        return this.f3239a;
    }

    @Override // com.google.android.gms.ads.mediation.a
    @Deprecated
    public final int b() {
        return this.f3240b;
    }

    @Override // com.google.android.gms.ads.mediation.a
    public final Set<String> c() {
        return this.c;
    }

    @Override // com.google.android.gms.ads.mediation.a
    public final Location d() {
        return this.e;
    }

    @Override // com.google.android.gms.ads.mediation.a
    public final boolean f() {
        return this.d;
    }

    @Override // com.google.android.gms.ads.mediation.a
    public final int e() {
        return this.f;
    }

    @Override // com.google.android.gms.ads.mediation.a
    @Deprecated
    public final boolean g() {
        return this.g;
    }
}
