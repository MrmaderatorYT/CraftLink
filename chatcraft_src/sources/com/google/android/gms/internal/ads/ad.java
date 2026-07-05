package com.google.android.gms.internal.ads;

import android.view.View;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class ad extends ag {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.g f1853a;

    /* renamed from: b, reason: collision with root package name */
    private final String f1854b;
    private final String c;

    public ad(com.google.android.gms.ads.internal.g gVar, String str, String str2) {
        this.f1853a = gVar;
        this.f1854b = str;
        this.c = str2;
    }

    @Override // com.google.android.gms.internal.ads.af
    public final String a() {
        return this.f1854b;
    }

    @Override // com.google.android.gms.internal.ads.af
    public final String b() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.af
    public final void a(com.google.android.gms.dynamic.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f1853a.a_((View) com.google.android.gms.dynamic.b.a(aVar));
    }

    @Override // com.google.android.gms.internal.ads.af
    public final void c() {
        this.f1853a.f_();
    }

    @Override // com.google.android.gms.internal.ads.af
    public final void d() {
        this.f1853a.g_();
    }
}
