package okhttp3.internal.http2;

import b.s;
import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: Hpack.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    static final okhttp3.internal.http2.b[] f5174a = {new okhttp3.internal.http2.b(okhttp3.internal.http2.b.f, BuildConfig.FLAVOR), new okhttp3.internal.http2.b(okhttp3.internal.http2.b.c, "GET"), new okhttp3.internal.http2.b(okhttp3.internal.http2.b.c, "POST"), new okhttp3.internal.http2.b(okhttp3.internal.http2.b.d, "/"), new okhttp3.internal.http2.b(okhttp3.internal.http2.b.d, "/index.html"), new okhttp3.internal.http2.b(okhttp3.internal.http2.b.e, "http"), new okhttp3.internal.http2.b(okhttp3.internal.http2.b.e, "https"), new okhttp3.internal.http2.b(okhttp3.internal.http2.b.f5173b, "200"), new okhttp3.internal.http2.b(okhttp3.internal.http2.b.f5173b, "204"), new okhttp3.internal.http2.b(okhttp3.internal.http2.b.f5173b, "206"), new okhttp3.internal.http2.b(okhttp3.internal.http2.b.f5173b, "304"), new okhttp3.internal.http2.b(okhttp3.internal.http2.b.f5173b, "400"), new okhttp3.internal.http2.b(okhttp3.internal.http2.b.f5173b, "404"), new okhttp3.internal.http2.b(okhttp3.internal.http2.b.f5173b, "500"), new okhttp3.internal.http2.b("accept-charset", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("accept-encoding", "gzip, deflate"), new okhttp3.internal.http2.b("accept-language", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("accept-ranges", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("accept", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("access-control-allow-origin", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("age", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("allow", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("authorization", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("cache-control", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("content-disposition", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("content-encoding", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("content-language", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("content-length", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("content-location", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("content-range", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("content-type", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("cookie", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("date", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("etag", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("expect", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("expires", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("from", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("host", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("if-match", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("if-modified-since", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("if-none-match", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("if-range", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("if-unmodified-since", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("last-modified", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("link", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("location", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("max-forwards", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("proxy-authenticate", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("proxy-authorization", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("range", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("referer", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("refresh", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("retry-after", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("server", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("set-cookie", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("strict-transport-security", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("transfer-encoding", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("user-agent", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("vary", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("via", BuildConfig.FLAVOR), new okhttp3.internal.http2.b("www-authenticate", BuildConfig.FLAVOR)};

    /* renamed from: b, reason: collision with root package name */
    static final Map<b.f, Integer> f5175b = a();

    /* compiled from: Hpack.java */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        okhttp3.internal.http2.b[] f5176a;

        /* renamed from: b, reason: collision with root package name */
        int f5177b;
        int c;
        int d;
        private final List<okhttp3.internal.http2.b> e;
        private final b.e f;
        private final int g;
        private int h;

        a(int i, s sVar) {
            this(i, i, sVar);
        }

        a(int i, int i2, s sVar) {
            this.e = new ArrayList();
            this.f5176a = new okhttp3.internal.http2.b[8];
            this.f5177b = this.f5176a.length - 1;
            this.c = 0;
            this.d = 0;
            this.g = i;
            this.h = i2;
            this.f = b.l.a(sVar);
        }

        private void d() {
            if (this.h < this.d) {
                if (this.h == 0) {
                    e();
                } else {
                    a(this.d - this.h);
                }
            }
        }

        private void e() {
            Arrays.fill(this.f5176a, (Object) null);
            this.f5177b = this.f5176a.length - 1;
            this.c = 0;
            this.d = 0;
        }

        private int a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f5176a.length;
                while (true) {
                    length--;
                    if (length < this.f5177b || i <= 0) {
                        break;
                    }
                    i -= this.f5176a[length].i;
                    this.d -= this.f5176a[length].i;
                    this.c--;
                    i2++;
                }
                System.arraycopy(this.f5176a, this.f5177b + 1, this.f5176a, this.f5177b + 1 + i2, this.c);
                this.f5177b += i2;
            }
            return i2;
        }

        void a() throws IOException {
            while (!this.f.e()) {
                int iH = this.f.h() & Constants.DimensionIds.NETHER;
                if (iH == 128) {
                    throw new IOException("index == 0");
                }
                if ((iH & 128) == 128) {
                    b(a(iH, 127) - 1);
                } else if (iH == 64) {
                    g();
                } else if ((iH & 64) == 64) {
                    e(a(iH, 63) - 1);
                } else if ((iH & 32) == 32) {
                    this.h = a(iH, 31);
                    if (this.h < 0 || this.h > this.g) {
                        throw new IOException("Invalid dynamic table size update " + this.h);
                    }
                    d();
                } else if (iH == 16 || iH == 0) {
                    f();
                } else {
                    d(a(iH, 15) - 1);
                }
            }
        }

        public List<okhttp3.internal.http2.b> b() {
            ArrayList arrayList = new ArrayList(this.e);
            this.e.clear();
            return arrayList;
        }

        private void b(int i) throws IOException {
            if (g(i)) {
                this.e.add(c.f5174a[i]);
                return;
            }
            int iC = c(i - c.f5174a.length);
            if (iC < 0 || iC >= this.f5176a.length) {
                throw new IOException("Header index too large " + (i + 1));
            }
            this.e.add(this.f5176a[iC]);
        }

        private int c(int i) {
            return this.f5177b + 1 + i;
        }

        private void d(int i) throws IOException {
            this.e.add(new okhttp3.internal.http2.b(f(i), c()));
        }

        private void f() throws IOException {
            this.e.add(new okhttp3.internal.http2.b(c.a(c()), c()));
        }

        private void e(int i) {
            a(-1, new okhttp3.internal.http2.b(f(i), c()));
        }

        private void g() {
            a(-1, new okhttp3.internal.http2.b(c.a(c()), c()));
        }

        private b.f f(int i) throws IOException {
            if (g(i)) {
                return c.f5174a[i].g;
            }
            int iC = c(i - c.f5174a.length);
            if (iC < 0 || iC >= this.f5176a.length) {
                throw new IOException("Header index too large " + (i + 1));
            }
            return this.f5176a[iC].g;
        }

        private boolean g(int i) {
            return i >= 0 && i <= c.f5174a.length - 1;
        }

        private void a(int i, okhttp3.internal.http2.b bVar) {
            this.e.add(bVar);
            int i2 = bVar.i;
            if (i != -1) {
                i2 -= this.f5176a[c(i)].i;
            }
            if (i2 > this.h) {
                e();
                return;
            }
            int iA = a((this.d + i2) - this.h);
            if (i == -1) {
                if (this.c + 1 > this.f5176a.length) {
                    okhttp3.internal.http2.b[] bVarArr = new okhttp3.internal.http2.b[this.f5176a.length * 2];
                    System.arraycopy(this.f5176a, 0, bVarArr, this.f5176a.length, this.f5176a.length);
                    this.f5177b = this.f5176a.length - 1;
                    this.f5176a = bVarArr;
                }
                int i3 = this.f5177b;
                this.f5177b = i3 - 1;
                this.f5176a[i3] = bVar;
                this.c++;
            } else {
                this.f5176a[i + c(i) + iA] = bVar;
            }
            this.d += i2;
        }

        private int h() {
            return this.f.h() & Constants.DimensionIds.NETHER;
        }

        int a(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iH = h();
                if ((iH & 128) == 0) {
                    return i2 + (iH << i4);
                }
                i2 += (iH & 127) << i4;
                i4 += 7;
            }
        }

        b.f c() {
            int iH = h();
            boolean z = (iH & 128) == 128;
            int iA = a(iH, 127);
            if (z) {
                return b.f.a(j.a().a(this.f.g(iA)));
            }
            return this.f.c(iA);
        }
    }

    private static Map<b.f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f5174a.length);
        for (int i = 0; i < f5174a.length; i++) {
            if (!linkedHashMap.containsKey(f5174a[i].g)) {
                linkedHashMap.put(f5174a[i].g, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    /* compiled from: Hpack.java */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        int f5178a;

        /* renamed from: b, reason: collision with root package name */
        int f5179b;
        okhttp3.internal.http2.b[] c;
        int d;
        int e;
        int f;
        private final b.c g;
        private final boolean h;
        private int i;
        private boolean j;

        b(b.c cVar) {
            this(4096, true, cVar);
        }

        b(int i, boolean z, b.c cVar) {
            this.i = Integer.MAX_VALUE;
            this.c = new okhttp3.internal.http2.b[8];
            this.d = this.c.length - 1;
            this.e = 0;
            this.f = 0;
            this.f5178a = i;
            this.f5179b = i;
            this.h = z;
            this.g = cVar;
        }

        private void a() {
            Arrays.fill(this.c, (Object) null);
            this.d = this.c.length - 1;
            this.e = 0;
            this.f = 0;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.c.length;
                while (true) {
                    length--;
                    if (length < this.d || i <= 0) {
                        break;
                    }
                    i -= this.c[length].i;
                    this.f -= this.c[length].i;
                    this.e--;
                    i2++;
                }
                System.arraycopy(this.c, this.d + 1, this.c, this.d + 1 + i2, this.e);
                Arrays.fill(this.c, this.d + 1, this.d + 1 + i2, (Object) null);
                this.d += i2;
            }
            return i2;
        }

        private void a(okhttp3.internal.http2.b bVar) {
            int i = bVar.i;
            if (i > this.f5179b) {
                a();
                return;
            }
            b((this.f + i) - this.f5179b);
            if (this.e + 1 > this.c.length) {
                okhttp3.internal.http2.b[] bVarArr = new okhttp3.internal.http2.b[this.c.length * 2];
                System.arraycopy(this.c, 0, bVarArr, this.c.length, this.c.length);
                this.d = this.c.length - 1;
                this.c = bVarArr;
            }
            int i2 = this.d;
            this.d = i2 - 1;
            this.c[i2] = bVar;
            this.e++;
            this.f += i;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void a(java.util.List<okhttp3.internal.http2.b> r14) {
            /*
                Method dump skipped, instructions count: 240
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.c.b.a(java.util.List):void");
        }

        void a(int i, int i2, int i3) {
            if (i < i2) {
                this.g.i(i | i3);
                return;
            }
            this.g.i(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.g.i(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.g.i(i4);
        }

        void a(b.f fVar) {
            if (this.h && j.a().a(fVar) < fVar.h()) {
                b.c cVar = new b.c();
                j.a().a(fVar, cVar);
                b.f fVarO = cVar.o();
                a(fVarO.h(), 127, 128);
                this.g.a(fVarO);
                return;
            }
            a(fVar.h(), 127, 0);
            this.g.a(fVar);
        }

        void a(int i) {
            this.f5178a = i;
            int iMin = Math.min(i, 16384);
            if (this.f5179b == iMin) {
                return;
            }
            if (iMin < this.f5179b) {
                this.i = Math.min(this.i, iMin);
            }
            this.j = true;
            this.f5179b = iMin;
            b();
        }

        private void b() {
            if (this.f5179b < this.f) {
                if (this.f5179b == 0) {
                    a();
                } else {
                    b(this.f - this.f5179b);
                }
            }
        }
    }

    static b.f a(b.f fVar) throws IOException {
        int iH = fVar.h();
        for (int i = 0; i < iH; i++) {
            byte bA = fVar.a(i);
            if (bA >= 65 && bA <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.a());
            }
        }
        return fVar;
    }
}
