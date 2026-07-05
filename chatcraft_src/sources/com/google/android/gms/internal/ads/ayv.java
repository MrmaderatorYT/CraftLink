package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class ayv extends azd {
    private final StackTraceElement[] d;

    public ayv(axt axtVar, String str, String str2, akp akpVar, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(axtVar, str, str2, akpVar, i, 45);
        this.d = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.azd
    protected final void a() {
        if (this.d != null) {
            axr axrVar = new axr((String) this.c.invoke(null, this.d));
            synchronized (this.f2415b) {
                this.f2415b.B = axrVar.f2382a;
                if (axrVar.f2383b.booleanValue()) {
                    this.f2415b.J = Integer.valueOf(!axrVar.c.booleanValue() ? 1 : 0);
                } else {
                    this.f2415b.J = 2;
                }
            }
        }
    }
}
