package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;

@qj
/* loaded from: classes.dex */
public final class adb {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1857a;

    /* renamed from: b, reason: collision with root package name */
    private final adk f1858b;
    private final ViewGroup c;
    private acv d;

    public adb(Context context, ViewGroup viewGroup, afu afuVar) {
        this(context, viewGroup, afuVar, null);
    }

    private adb(Context context, ViewGroup viewGroup, adk adkVar, acv acvVar) {
        this.f1857a = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.c = viewGroup;
        this.f1858b = adkVar;
        this.d = null;
    }

    public final void a(int i, int i2, int i3, int i4) {
        com.google.android.gms.common.internal.i.b("The underlay may only be modified from the UI thread.");
        if (this.d != null) {
            this.d.a(i, i2, i3, i4);
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, boolean z, adj adjVar) {
        if (this.d != null) {
            return;
        }
        u.a(this.f1858b.j().a(), this.f1858b.c(), "vpr2");
        this.d = new acv(this.f1857a, this.f1858b, i5, z, this.f1858b.j().a(), adjVar);
        this.c.addView(this.d, 0, new ViewGroup.LayoutParams(-1, -1));
        this.d.a(i, i2, i3, i4);
        this.f1858b.a(false);
    }

    public final acv a() {
        com.google.android.gms.common.internal.i.b("getAdVideoUnderlay must be called from the UI thread.");
        return this.d;
    }

    public final void b() {
        com.google.android.gms.common.internal.i.b("onPause must be called from the UI thread.");
        if (this.d != null) {
            this.d.i();
        }
    }

    public final void c() {
        com.google.android.gms.common.internal.i.b("onDestroy must be called from the UI thread.");
        if (this.d != null) {
            this.d.n();
            this.c.removeView(this.d);
            this.d = null;
        }
    }
}
