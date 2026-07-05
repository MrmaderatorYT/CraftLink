package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.internal.ads.nn;
import com.google.android.gms.internal.ads.qj;

@qj
/* loaded from: classes.dex */
public final class s extends nn {

    /* renamed from: a, reason: collision with root package name */
    private AdOverlayInfoParcel f1641a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f1642b;
    private boolean c = false;
    private boolean d = false;

    public s(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f1641a = adOverlayInfoParcel;
        this.f1642b = activity;
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void a(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void a(com.google.android.gms.dynamic.a aVar) {
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void d() {
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final boolean e() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void f() {
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void g() {
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void l() {
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void a(Bundle bundle) {
        boolean z = bundle != null ? bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false) : false;
        if (this.f1641a == null) {
            this.f1642b.finish();
            return;
        }
        if (z) {
            this.f1642b.finish();
            return;
        }
        if (bundle == null) {
            if (this.f1641a.f1623b != null) {
                this.f1641a.f1623b.e();
            }
            if (this.f1642b.getIntent() != null && this.f1642b.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) && this.f1641a.c != null) {
                this.f1641a.c.g();
            }
        }
        ax.b();
        if (a.a(this.f1642b, this.f1641a.f1622a, this.f1641a.i)) {
            return;
        }
        this.f1642b.finish();
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void h() {
        if (this.c) {
            this.f1642b.finish();
            return;
        }
        this.c = true;
        if (this.f1641a.c != null) {
            this.f1641a.c.f();
        }
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void b(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.c);
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void i() {
        if (this.f1641a.c != null) {
            this.f1641a.c.d();
        }
        if (this.f1642b.isFinishing()) {
            a();
        }
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void j() {
        if (this.f1642b.isFinishing()) {
            a();
        }
    }

    @Override // com.google.android.gms.internal.ads.nm
    public final void k() {
        if (this.f1642b.isFinishing()) {
            a();
        }
    }

    private final synchronized void a() {
        if (!this.d) {
            if (this.f1641a.c != null) {
                this.f1641a.c.p_();
            }
            this.d = true;
        }
    }
}
