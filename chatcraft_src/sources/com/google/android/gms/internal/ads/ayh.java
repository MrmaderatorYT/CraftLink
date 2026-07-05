package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ayh extends azd {
    private static aze<String> d = new aze<>();
    private final Context e;

    public ayh(axt axtVar, String str, String str2, akp akpVar, int i, int i2, Context context) {
        super(axtVar, str, str2, akpVar, i, 29);
        this.e = context;
    }

    @Override // com.google.android.gms.internal.ads.azd
    protected final void a() {
        this.f2415b.o = "E";
        AtomicReference<String> atomicReferenceA = d.a(this.e.getPackageName());
        if (atomicReferenceA.get() == null) {
            synchronized (atomicReferenceA) {
                if (atomicReferenceA.get() == null) {
                    atomicReferenceA.set((String) this.c.invoke(null, this.e));
                }
            }
        }
        String str = atomicReferenceA.get();
        synchronized (this.f2415b) {
            this.f2415b.o = atu.a(str.getBytes(), true);
        }
    }
}
