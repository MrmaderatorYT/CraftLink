package com.google.android.gms.internal.ads;

import android.content.Context;

@qj
/* loaded from: classes.dex */
public class ok extends od {
    ok(Context context, wl wlVar, afu afuVar, oj ojVar) {
        super(context, wlVar, afuVar, ojVar);
    }

    protected void d() {
    }

    @Override // com.google.android.gms.internal.ads.od
    protected final void a() {
        if (this.c.d != -2) {
            return;
        }
        this.f3309b.w().a(this);
        d();
        xe.b("Loading HTML in WebView.");
        this.f3309b.a(this.c.f3427a, this.c.f3428b, (String) null);
    }
}
