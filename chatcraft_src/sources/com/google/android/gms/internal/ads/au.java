package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class au extends cs implements bi {

    /* renamed from: a, reason: collision with root package name */
    private String f2269a;

    /* renamed from: b, reason: collision with root package name */
    private List<at> f2270b;
    private String c;
    private cd d;
    private String e;
    private double f;
    private String g;
    private String h;
    private ao i;
    private Bundle j;
    private bsw k;
    private View l;
    private com.google.android.gms.dynamic.a m;
    private String n;
    private Object o = new Object();
    private bf p;

    public au(String str, List<at> list, String str2, cd cdVar, String str3, double d, String str4, String str5, ao aoVar, Bundle bundle, bsw bswVar, View view, com.google.android.gms.dynamic.a aVar, String str6) {
        this.f2269a = str;
        this.f2270b = list;
        this.c = str2;
        this.d = cdVar;
        this.e = str3;
        this.f = d;
        this.g = str4;
        this.h = str5;
        this.i = aoVar;
        this.j = bundle;
        this.k = bswVar;
        this.l = view;
        this.m = aVar;
        this.n = str6;
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final String a() {
        return "2";
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final String b() {
        return BuildConfig.FLAVOR;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final String e() {
        return this.f2269a;
    }

    @Override // com.google.android.gms.internal.ads.cr, com.google.android.gms.internal.ads.bi
    public final List f() {
        return this.f2270b;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final String g() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final cd h() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final String i() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final double j() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final String k() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final String l() {
        return this.h;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final bsw m() {
        return this.k;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final com.google.android.gms.dynamic.a n() {
        return com.google.android.gms.dynamic.b.a(this.p);
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final void a(bf bfVar) {
        synchronized (this.o) {
            this.p = bfVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final ao c() {
        return this.i;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final Bundle o() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final View d() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final com.google.android.gms.dynamic.a p() {
        return this.m;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final String q() {
        return this.n;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final bz r() {
        return this.i;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final void s() {
        xn.f3583a.post(new av(this));
        this.f2269a = null;
        this.f2270b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0.0d;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.o = null;
        this.k = null;
        this.l = null;
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final void a(Bundle bundle) {
        synchronized (this.o) {
            if (this.p == null) {
                xe.c("#001 Attempt to perform click before app native ad initialized.");
            } else {
                this.p.b(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final boolean b(Bundle bundle) {
        synchronized (this.o) {
            if (this.p == null) {
                xe.c("#002 Attempt to record impression before native ad initialized.");
                return false;
            }
            return this.p.a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.cr
    public final void c(Bundle bundle) {
        synchronized (this.o) {
            if (this.p == null) {
                xe.c("#003 Attempt to report touch event before native ad initialized.");
            } else {
                this.p.c(bundle);
            }
        }
    }

    static /* synthetic */ bf a(au auVar, bf bfVar) {
        auVar.p = null;
        return null;
    }
}
