package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class bb extends dy implements bi {

    /* renamed from: a, reason: collision with root package name */
    private String f2477a;

    /* renamed from: b, reason: collision with root package name */
    private List<at> f2478b;
    private String e;
    private cd f;
    private String g;
    private String h;
    private double i;
    private String j;
    private String k;
    private ao l;
    private bsw m;
    private View n;
    private com.google.android.gms.dynamic.a o;
    private String p;
    private Bundle q;
    private bf s;
    private final Object r = new Object();
    private List<Object> c = null;
    private boolean d = false;

    public bb(String str, List<at> list, String str2, cd cdVar, String str3, String str4, double d, String str5, String str6, ao aoVar, bsw bswVar, View view, com.google.android.gms.dynamic.a aVar, String str7, Bundle bundle) {
        this.f2477a = str;
        this.f2478b = list;
        this.e = str2;
        this.f = cdVar;
        this.g = str3;
        this.h = str4;
        this.i = d;
        this.j = str5;
        this.k = str6;
        this.l = aoVar;
        this.m = bswVar;
        this.n = view;
        this.o = aVar;
        this.p = str7;
        this.q = bundle;
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final String a() {
        return "6";
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void a(bsp bspVar) {
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void a(bss bssVar) {
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final String b() {
        return BuildConfig.FLAVOR;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final List g() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final boolean h() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final String e() {
        return this.f2477a;
    }

    @Override // com.google.android.gms.internal.ads.dx, com.google.android.gms.internal.ads.bi
    public final List f() {
        return this.f2478b;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final String i() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final cd j() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final String k() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final String l() {
        return this.h;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final double m() {
        return this.i;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final String n() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final String o() {
        return this.k;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final bsw p() {
        return this.m;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final com.google.android.gms.dynamic.a q() {
        return com.google.android.gms.dynamic.b.a(this.s);
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final void a(bf bfVar) {
        synchronized (this.r) {
            this.s = bfVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final ao c() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final View d() {
        return this.n;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final com.google.android.gms.dynamic.a r() {
        return this.o;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final String s() {
        return this.p;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final Bundle t() {
        return this.q;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final bz u() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void v() {
        xn.f3583a.post(new bc(this));
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void a(Bundle bundle) {
        synchronized (this.r) {
            if (this.s == null) {
                xe.c("#001 Attempt to perform click before app native ad initialized.");
            } else {
                this.s.b(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final boolean b(Bundle bundle) {
        synchronized (this.r) {
            if (this.s == null) {
                xe.c("#002 Attempt to record impression before native ad initialized.");
                return false;
            }
            return this.s.a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void c(Bundle bundle) {
        synchronized (this.r) {
            if (this.s == null) {
                xe.c("#003 Attempt to report touch event before native ad initialized.");
            } else {
                this.s.c(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void a(dv dvVar) {
        this.s.a(dvVar);
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void w() {
        synchronized (this.r) {
            if (this.s == null) {
                return;
            }
            this.s.f();
        }
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void x() {
        synchronized (this.r) {
            if (this.s == null) {
                return;
            }
            this.s.g();
        }
    }

    @Override // com.google.android.gms.internal.ads.dx
    public final void y() {
        this.s.d();
    }

    static /* synthetic */ bf a(bb bbVar, bf bfVar) {
        bbVar.s = null;
        return null;
    }
}
