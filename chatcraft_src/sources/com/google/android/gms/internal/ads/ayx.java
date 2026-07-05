package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class ayx extends azd {
    private final ayc d;
    private long e;

    public ayx(axt axtVar, String str, String str2, akp akpVar, int i, int i2, ayc aycVar) {
        super(axtVar, str, str2, akpVar, i, 53);
        this.d = aycVar;
        if (aycVar != null) {
            this.e = aycVar.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.azd
    protected final void a() {
        if (this.d != null) {
            this.f2415b.I = (Long) this.c.invoke(null, Long.valueOf(this.e));
        }
    }
}
