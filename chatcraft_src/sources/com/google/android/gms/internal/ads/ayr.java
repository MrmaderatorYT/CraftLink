package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class ayr extends azd {
    private static volatile String d;
    private static final Object e = new Object();

    public ayr(axt axtVar, String str, String str2, akp akpVar, int i, int i2) {
        super(axtVar, str, str2, akpVar, i, 1);
    }

    @Override // com.google.android.gms.internal.ads.azd
    protected final void a() {
        this.f2415b.f2038a = "E";
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = (String) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.f2415b) {
            this.f2415b.f2038a = d;
        }
    }
}
