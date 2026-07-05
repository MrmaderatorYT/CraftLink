package b;

import javax.annotation.Nullable;

/* compiled from: SegmentPool.java */
/* loaded from: classes.dex */
final class p {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    static o f1189a;

    /* renamed from: b, reason: collision with root package name */
    static long f1190b;

    private p() {
    }

    static o a() {
        synchronized (p.class) {
            if (f1189a != null) {
                o oVar = f1189a;
                f1189a = oVar.f;
                oVar.f = null;
                f1190b -= 8192;
                return oVar;
            }
            return new o();
        }
    }

    static void a(o oVar) {
        if (oVar.f != null || oVar.g != null) {
            throw new IllegalArgumentException();
        }
        if (oVar.d) {
            return;
        }
        synchronized (p.class) {
            if (f1190b + 8192 > 65536) {
                return;
            }
            f1190b += 8192;
            oVar.f = f1189a;
            oVar.c = 0;
            oVar.f1188b = 0;
            f1189a = oVar;
        }
    }
}
