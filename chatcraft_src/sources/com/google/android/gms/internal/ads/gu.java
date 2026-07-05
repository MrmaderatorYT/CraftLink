package com.google.android.gms.internal.ads;

@qj
/* loaded from: classes.dex */
final class gu {

    /* renamed from: a, reason: collision with root package name */
    private static final gr f3115a = gr.a();

    /* renamed from: b, reason: collision with root package name */
    private static final float f3116b = ((Float) bra.e().a(o.aO)).floatValue();
    private static final long c = ((Long) bra.e().a(o.aM)).longValue();
    private static final float d = ((Float) bra.e().a(o.aP)).floatValue();
    private static final long e = ((Long) bra.e().a(o.aN)).longValue();

    static boolean a() {
        int iH = f3115a.h();
        int i = f3115a.i();
        int iG = f3115a.g() + f3115a.f();
        int iA = Integer.MAX_VALUE;
        if (i > ((iH >= 16 || e == 0) ? d != 0.0f ? ((int) (d * iH)) + 1 : Integer.MAX_VALUE : a(e, iH))) {
            return false;
        }
        if (iH < 16 && c != 0) {
            iA = a(c, iH);
        } else if (f3116b != 0.0f) {
            iA = (int) (f3116b * iH);
        }
        return iG <= iA;
    }

    private static int a(long j, int i) {
        return (int) ((j >>> ((i % 16) * 4)) & 15);
    }
}
