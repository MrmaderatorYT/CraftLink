package com.google.android.gms.internal.ads;

import android.os.Bundle;

@qj
/* loaded from: classes.dex */
public final class uv extends ve {

    /* renamed from: a, reason: collision with root package name */
    private volatile ut f3503a;

    /* renamed from: b, reason: collision with root package name */
    private volatile uw f3504b;
    private volatile uu c;
    private volatile va d;

    public uv(uu uuVar) {
        this.c = uuVar;
    }

    public final void a(ut utVar) {
        this.f3503a = utVar;
    }

    public final void a(uw uwVar) {
        this.f3504b = uwVar;
    }

    public final void a(va vaVar) {
        this.d = vaVar;
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void a(com.google.android.gms.dynamic.a aVar) {
        if (this.f3503a != null) {
            this.f3503a.g();
        }
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void a(com.google.android.gms.dynamic.a aVar, int i) {
        if (this.f3503a != null) {
            this.f3503a.a(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void b(com.google.android.gms.dynamic.a aVar) {
        if (this.f3504b != null) {
            this.f3504b.a(com.google.android.gms.dynamic.b.a(aVar).getClass().getName());
        }
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void c(com.google.android.gms.dynamic.a aVar) {
        if (this.c != null) {
            this.c.l_();
        }
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void d(com.google.android.gms.dynamic.a aVar) {
        if (this.c != null) {
            this.c.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void e(com.google.android.gms.dynamic.a aVar) {
        if (this.c != null) {
            this.c.c();
        }
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void a(com.google.android.gms.dynamic.a aVar, vh vhVar) {
        if (this.c != null) {
            this.c.a(vhVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void f(com.google.android.gms.dynamic.a aVar) {
        if (this.c != null) {
            this.c.n_();
        }
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void b(com.google.android.gms.dynamic.a aVar, int i) {
        if (this.f3504b != null) {
            this.f3504b.a(com.google.android.gms.dynamic.b.a(aVar).getClass().getName(), i);
        }
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void g(com.google.android.gms.dynamic.a aVar) {
        if (this.c != null) {
            this.c.o_();
        }
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void h(com.google.android.gms.dynamic.a aVar) {
        if (this.c != null) {
            this.c.m_();
        }
    }

    @Override // com.google.android.gms.internal.ads.vc
    public final void a(Bundle bundle) {
        if (this.d != null) {
            this.d.a(bundle);
        }
    }
}
