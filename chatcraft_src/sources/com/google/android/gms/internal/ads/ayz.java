package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class ayz extends azd {
    public ayz(axt axtVar, String str, String str2, akp akpVar, int i, int i2) {
        super(axtVar, str, str2, akpVar, i, 48);
    }

    @Override // com.google.android.gms.internal.ads.azd
    protected final void a() {
        this.f2415b.E = 2;
        boolean zBooleanValue = ((Boolean) this.c.invoke(null, this.f2414a.a())).booleanValue();
        synchronized (this.f2415b) {
            try {
                if (zBooleanValue) {
                    this.f2415b.E = 1;
                } else {
                    this.f2415b.E = 0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
