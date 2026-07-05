package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class aym extends azd {
    private long d;

    public aym(axt axtVar, String str, String str2, akp akpVar, long j, int i, int i2) {
        super(axtVar, str, str2, akpVar, i, 25);
        this.d = j;
    }

    @Override // com.google.android.gms.internal.ads.azd
    protected final void a() {
        long jLongValue = ((Long) this.c.invoke(null, new Object[0])).longValue();
        synchronized (this.f2415b) {
            this.f2415b.X = Long.valueOf(jLongValue);
            if (this.d != 0) {
                this.f2415b.j = Long.valueOf(jLongValue - this.d);
                this.f2415b.m = Long.valueOf(this.d);
            }
        }
    }
}
