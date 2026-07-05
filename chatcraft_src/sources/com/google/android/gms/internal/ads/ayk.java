package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class ayk extends azd {
    public ayk(axt axtVar, String str, String str2, akp akpVar, int i, int i2) {
        super(axtVar, str, str2, akpVar, i, 5);
    }

    @Override // com.google.android.gms.internal.ads.azd
    protected final void a() {
        this.f2415b.d = -1L;
        this.f2415b.e = -1L;
        int[] iArr = (int[]) this.c.invoke(null, this.f2414a.a());
        synchronized (this.f2415b) {
            this.f2415b.d = Long.valueOf(iArr[0]);
            this.f2415b.e = Long.valueOf(iArr[1]);
            if (iArr[2] != Integer.MIN_VALUE) {
                this.f2415b.N = Long.valueOf(iArr[2]);
            }
        }
    }
}
