package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes.dex */
public final class aza extends azd {
    private final View d;

    public aza(axt axtVar, String str, String str2, akp akpVar, int i, int i2, View view) {
        super(axtVar, str, str2, akpVar, i, 57);
        this.d = view;
    }

    @Override // com.google.android.gms.internal.ads.azd
    protected final void a() {
        if (this.d != null) {
            ayb aybVar = new ayb((String) this.c.invoke(null, this.d, this.f2414a.a().getResources().getDisplayMetrics()));
            amr amrVar = new amr();
            amrVar.f2078a = aybVar.f2400a;
            amrVar.f2079b = aybVar.f2401b;
            amrVar.c = aybVar.c;
            this.f2415b.M = amrVar;
        }
    }
}
