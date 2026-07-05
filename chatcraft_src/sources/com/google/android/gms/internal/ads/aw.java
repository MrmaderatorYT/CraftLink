package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class aw extends cw implements bi {

    /* renamed from: a, reason: collision with root package name */
    private String f2333a;

    /* renamed from: b, reason: collision with root package name */
    private List<at> f2334b;
    private String c;
    private cd d;
    private String e;
    private String f;
    private ao g;
    private Bundle h;
    private bsw i;
    private View j;
    private com.google.android.gms.dynamic.a k;
    private String l;
    private Object m = new Object();
    private bf n;

    public aw(String str, List<at> list, String str2, cd cdVar, String str3, String str4, ao aoVar, Bundle bundle, bsw bswVar, View view, com.google.android.gms.dynamic.a aVar, String str5) {
        this.f2333a = str;
        this.f2334b = list;
        this.c = str2;
        this.d = cdVar;
        this.e = str3;
        this.f = str4;
        this.g = aoVar;
        this.h = bundle;
        this.i = bswVar;
        this.j = view;
        this.k = aVar;
        this.l = str5;
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final String a() {
        return "1";
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final String b() {
        return BuildConfig.FLAVOR;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final String e() {
        return this.f2333a;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final com.google.android.gms.dynamic.a g() {
        return this.k;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final String h() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.cv, com.google.android.gms.internal.ads.bi
    public final List f() {
        return this.f2334b;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final String i() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final cd j() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final String k() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final String l() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final bsw m() {
        return this.i;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final com.google.android.gms.dynamic.a n() {
        return com.google.android.gms.dynamic.b.a(this.n);
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final void a(bf bfVar) {
        synchronized (this.m) {
            this.n = bfVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final ao c() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final Bundle o() {
        return this.h;
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final View d() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final bz p() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final void q() {
        xn.f3583a.post(new ax(this));
        this.f2333a = null;
        this.f2334b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.m = null;
        this.i = null;
        this.j = null;
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final void a(Bundle bundle) {
        synchronized (this.m) {
            if (this.n == null) {
                xe.c("#001 Attempt to perform click before app native ad initialized.");
            } else {
                this.n.b(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final boolean b(Bundle bundle) {
        synchronized (this.m) {
            if (this.n == null) {
                xe.c("#002 Attempt to record impression before native ad initialized.");
                return false;
            }
            return this.n.a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.cv
    public final void c(Bundle bundle) {
        synchronized (this.m) {
            if (this.n == null) {
                xe.c("#003 Attempt to report touch event before native ad initialized.");
            } else {
                this.n.c(bundle);
            }
        }
    }

    static /* synthetic */ bf a(aw awVar, bf bfVar) {
        awVar.n = null;
        return null;
    }
}
