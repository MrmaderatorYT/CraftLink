package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class ayw extends azd {
    public ayw(axt axtVar, String str, String str2, akp akpVar, int i, int i2) {
        super(axtVar, str, str2, akpVar, i, 51);
    }

    @Override // com.google.android.gms.internal.ads.azd
    protected final void a() {
        synchronized (this.f2415b) {
            axs axsVar = new axs((String) this.c.invoke(null, new Object[0]));
            this.f2415b.G = axsVar.f2384a;
            this.f2415b.H = axsVar.f2385b;
        }
    }
}
