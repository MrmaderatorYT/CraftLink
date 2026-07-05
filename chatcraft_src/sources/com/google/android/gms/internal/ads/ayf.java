package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;

/* loaded from: classes.dex */
public final class ayf extends azd {
    private final Activity d;
    private final View e;

    public ayf(axt axtVar, String str, String str2, akp akpVar, int i, int i2, View view, Activity activity) {
        super(axtVar, str, str2, akpVar, i, 62);
        this.e = view;
        this.d = activity;
    }

    @Override // com.google.android.gms.internal.ads.azd
    protected final void a() {
        if (this.e == null) {
            return;
        }
        boolean zBooleanValue = ((Boolean) bra.e().a(o.bg)).booleanValue();
        Object[] objArr = (Object[]) this.c.invoke(null, this.e, this.d, Boolean.valueOf(zBooleanValue));
        synchronized (this.f2415b) {
            this.f2415b.Q = Long.valueOf(((Long) objArr[0]).longValue());
            this.f2415b.R = Long.valueOf(((Long) objArr[1]).longValue());
            if (zBooleanValue) {
                this.f2415b.S = (String) objArr[2];
            }
        }
    }
}
