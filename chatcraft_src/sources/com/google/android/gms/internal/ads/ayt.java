package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes.dex */
public final class ayt extends azd {
    private List<Long> d;

    public ayt(axt axtVar, String str, String str2, akp akpVar, int i, int i2) {
        super(axtVar, str, str2, akpVar, i, 31);
        this.d = null;
    }

    @Override // com.google.android.gms.internal.ads.azd
    protected final void a() {
        this.f2415b.p = -1L;
        this.f2415b.q = -1L;
        if (this.d == null) {
            this.d = (List) this.c.invoke(null, this.f2414a.a());
        }
        if (this.d == null || this.d.size() != 2) {
            return;
        }
        synchronized (this.f2415b) {
            this.f2415b.p = Long.valueOf(this.d.get(0).longValue());
            this.f2415b.q = Long.valueOf(this.d.get(1).longValue());
        }
    }
}
