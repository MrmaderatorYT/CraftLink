package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class te implements Callable<ta> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f3468a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ td f3469b;

    te(td tdVar, Context context) {
        this.f3469b = tdVar;
        this.f3468a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ com.google.android.gms.internal.ads.ta call() {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.td r0 = r6.f3469b
            java.util.WeakHashMap r0 = com.google.android.gms.internal.ads.td.a(r0)
            android.content.Context r1 = r6.f3468a
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.ads.tf r0 = (com.google.android.gms.internal.ads.tf) r0
            if (r0 == 0) goto L42
            long r1 = r0.f3470a
            com.google.android.gms.internal.ads.d<java.lang.Long> r3 = com.google.android.gms.internal.ads.o.aX
            com.google.android.gms.internal.ads.l r4 = com.google.android.gms.internal.ads.bra.e()
            java.lang.Object r3 = r4.a(r3)
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            long r1 = r1 + r3
            com.google.android.gms.common.util.c r3 = com.google.android.gms.ads.internal.ax.l()
            long r3 = r3.a()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L31
            r1 = 1
            goto L32
        L31:
            r1 = 0
        L32:
            if (r1 != 0) goto L42
            com.google.android.gms.internal.ads.tc r1 = new com.google.android.gms.internal.ads.tc
            android.content.Context r2 = r6.f3468a
            com.google.android.gms.internal.ads.ta r0 = r0.f3471b
            r1.<init>(r2, r0)
            com.google.android.gms.internal.ads.ta r0 = r1.a()
            goto L4d
        L42:
            com.google.android.gms.internal.ads.tc r0 = new com.google.android.gms.internal.ads.tc
            android.content.Context r1 = r6.f3468a
            r0.<init>(r1)
            com.google.android.gms.internal.ads.ta r0 = r0.a()
        L4d:
            com.google.android.gms.internal.ads.td r1 = r6.f3469b
            java.util.WeakHashMap r1 = com.google.android.gms.internal.ads.td.a(r1)
            android.content.Context r2 = r6.f3468a
            com.google.android.gms.internal.ads.tf r3 = new com.google.android.gms.internal.ads.tf
            com.google.android.gms.internal.ads.td r4 = r6.f3469b
            r3.<init>(r4, r0)
            r1.put(r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.te.call():java.lang.Object");
    }
}
