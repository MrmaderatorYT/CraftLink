package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class ays extends azd {
    public ays(axt axtVar, String str, String str2, akp akpVar, int i, int i2) {
        super(axtVar, str, str2, akpVar, i, 3);
    }

    @Override // com.google.android.gms.internal.ads.azd
    protected final void a() {
        synchronized (this.f2415b) {
            axg axgVar = new axg((String) this.c.invoke(null, this.f2414a.a()));
            synchronized (this.f2415b) {
                this.f2415b.c = Long.valueOf(axgVar.f2367a);
                this.f2415b.O = Long.valueOf(axgVar.f2368b);
            }
        }
    }
}
