package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class ayp extends azd {
    private static volatile Long d;
    private static final Object e = new Object();

    public ayp(axt axtVar, String str, String str2, akp akpVar, int i, int i2) {
        super(axtVar, str, str2, akpVar, i, 22);
    }

    @Override // com.google.android.gms.internal.ads.azd
    protected final void a() {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = (Long) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.f2415b) {
            this.f2415b.l = d;
        }
    }
}
