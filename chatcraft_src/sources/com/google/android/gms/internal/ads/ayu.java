package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class ayu extends azd {
    private final boolean d;

    public ayu(axt axtVar, String str, String str2, akp akpVar, int i, int i2) {
        super(axtVar, str, str2, akpVar, i, 61);
        this.d = axtVar.j();
    }

    @Override // com.google.android.gms.internal.ads.azd
    protected final void a() {
        long jLongValue = ((Long) this.c.invoke(null, this.f2414a.a(), Boolean.valueOf(this.d))).longValue();
        synchronized (this.f2415b) {
            this.f2415b.P = Long.valueOf(jLongValue);
        }
    }
}
