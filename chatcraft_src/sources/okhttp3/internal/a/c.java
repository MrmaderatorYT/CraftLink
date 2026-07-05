package okhttp3.internal.a;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.aa;
import okhttp3.r;
import okhttp3.y;

/* compiled from: CacheStrategy.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final y f5088a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final aa f5089b;

    c(y yVar, aa aaVar) {
        this.f5088a = yVar;
        this.f5089b = aaVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
    
        if (r3.m().d() == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(okhttp3.aa r3, okhttp3.y r4) {
        /*
            int r0 = r3.c()
            r1 = 0
            switch(r0) {
                case 200: goto L30;
                case 203: goto L30;
                case 204: goto L30;
                case 300: goto L30;
                case 301: goto L30;
                case 302: goto L9;
                case 307: goto L9;
                case 308: goto L30;
                case 404: goto L30;
                case 405: goto L30;
                case 410: goto L30;
                case 414: goto L30;
                case 501: goto L30;
                default: goto L8;
            }
        L8:
            goto L46
        L9:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.a(r0)
            if (r0 != 0) goto L30
            okhttp3.d r0 = r3.m()
            int r0 = r0.c()
            r2 = -1
            if (r0 != r2) goto L30
            okhttp3.d r0 = r3.m()
            boolean r0 = r0.e()
            if (r0 != 0) goto L30
            okhttp3.d r0 = r3.m()
            boolean r0 = r0.d()
            if (r0 == 0) goto L46
        L30:
            okhttp3.d r3 = r3.m()
            boolean r3 = r3.b()
            if (r3 != 0) goto L45
            okhttp3.d r3 = r4.f()
            boolean r3 = r3.b()
            if (r3 != 0) goto L45
            r1 = 1
        L45:
            return r1
        L46:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.a.c.a(okhttp3.aa, okhttp3.y):boolean");
    }

    /* compiled from: CacheStrategy.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final long f5090a;

        /* renamed from: b, reason: collision with root package name */
        final y f5091b;
        final aa c;
        private Date d;
        private String e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l;

        public a(long j, y yVar, aa aaVar) {
            this.l = -1;
            this.f5090a = j;
            this.f5091b = yVar;
            this.c = aaVar;
            if (aaVar != null) {
                this.i = aaVar.n();
                this.j = aaVar.o();
                r rVarG = aaVar.g();
                int iA = rVarG.a();
                for (int i = 0; i < iA; i++) {
                    String strA = rVarG.a(i);
                    String strB = rVarG.b(i);
                    if ("Date".equalsIgnoreCase(strA)) {
                        this.d = okhttp3.internal.b.d.a(strB);
                        this.e = strB;
                    } else if ("Expires".equalsIgnoreCase(strA)) {
                        this.h = okhttp3.internal.b.d.a(strB);
                    } else if ("Last-Modified".equalsIgnoreCase(strA)) {
                        this.f = okhttp3.internal.b.d.a(strB);
                        this.g = strB;
                    } else if ("ETag".equalsIgnoreCase(strA)) {
                        this.k = strB;
                    } else if ("Age".equalsIgnoreCase(strA)) {
                        this.l = okhttp3.internal.b.e.b(strB, -1);
                    }
                }
            }
        }

        public c a() {
            c cVarB = b();
            return (cVarB.f5088a == null || !this.f5091b.f().i()) ? cVarB : new c(null, null);
        }

        private c b() {
            String str;
            String str2;
            if (this.c == null) {
                return new c(this.f5091b, null);
            }
            if (this.f5091b.g() && this.c.f() == null) {
                return new c(this.f5091b, null);
            }
            if (!c.a(this.c, this.f5091b)) {
                return new c(this.f5091b, null);
            }
            okhttp3.d dVarF = this.f5091b.f();
            if (dVarF.a() || a(this.f5091b)) {
                return new c(this.f5091b, null);
            }
            okhttp3.d dVarM = this.c.m();
            if (dVarM.j()) {
                return new c(null, this.c);
            }
            long jD = d();
            long jC = c();
            if (dVarF.c() != -1) {
                jC = Math.min(jC, TimeUnit.SECONDS.toMillis(dVarF.c()));
            }
            long millis = 0;
            long millis2 = dVarF.h() != -1 ? TimeUnit.SECONDS.toMillis(dVarF.h()) : 0L;
            if (!dVarM.f() && dVarF.g() != -1) {
                millis = TimeUnit.SECONDS.toMillis(dVarF.g());
            }
            if (!dVarM.a()) {
                long j = millis2 + jD;
                if (j < millis + jC) {
                    aa.a aVarI = this.c.i();
                    if (j >= jC) {
                        aVarI.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jD > 86400000 && e()) {
                        aVarI.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new c(null, aVarI.a());
                }
            }
            if (this.k != null) {
                str = "If-None-Match";
                str2 = this.k;
            } else if (this.f != null) {
                str = "If-Modified-Since";
                str2 = this.g;
            } else if (this.d != null) {
                str = "If-Modified-Since";
                str2 = this.e;
            } else {
                return new c(this.f5091b, null);
            }
            r.a aVarB = this.f5091b.c().b();
            okhttp3.internal.a.f5084a.a(aVarB, str, str2);
            return new c(this.f5091b.e().a(aVarB.a()).a(), this.c);
        }

        private long c() {
            long time;
            long time2;
            if (this.c.m().c() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.c());
            }
            if (this.h != null) {
                if (this.d != null) {
                    time2 = this.d.getTime();
                } else {
                    time2 = this.j;
                }
                long time3 = this.h.getTime() - time2;
                if (time3 > 0) {
                    return time3;
                }
                return 0L;
            }
            if (this.f == null || this.c.a().a().k() != null) {
                return 0L;
            }
            if (this.d != null) {
                time = this.d.getTime();
            } else {
                time = this.i;
            }
            long time4 = time - this.f.getTime();
            if (time4 > 0) {
                return time4 / 10;
            }
            return 0L;
        }

        private long d() {
            long jMax = this.d != null ? Math.max(0L, this.j - this.d.getTime()) : 0L;
            if (this.l != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(this.l));
            }
            return jMax + (this.j - this.i) + (this.f5090a - this.j);
        }

        private boolean e() {
            return this.c.m().c() == -1 && this.h == null;
        }

        private static boolean a(y yVar) {
            return (yVar.a("If-Modified-Since") == null && yVar.a("If-None-Match") == null) ? false : true;
        }
    }
}
