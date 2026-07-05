package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class awz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ awy f2359a;

    awz(awy awyVar) {
        this.f2359a = awyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f2359a.f2358b != null) {
            return;
        }
        synchronized (awy.d) {
            if (this.f2359a.f2358b != null) {
                return;
            }
            boolean zBooleanValue = ((Boolean) bra.e().a(o.bd)).booleanValue();
            if (zBooleanValue) {
                try {
                    awy.f2357a = new box(this.f2359a.c.f2387a, "ADSHIELD", null);
                } catch (Throwable unused) {
                    zBooleanValue = false;
                }
            }
            this.f2359a.f2358b = Boolean.valueOf(zBooleanValue);
            awy.d.open();
        }
    }
}
