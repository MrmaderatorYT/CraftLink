package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.r;

/* compiled from: Response.java */
/* loaded from: classes.dex */
public final class aa implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    final y f5049a;

    /* renamed from: b, reason: collision with root package name */
    final w f5050b;
    final int c;
    final String d;

    @Nullable
    final q e;
    final r f;

    @Nullable
    final ab g;

    @Nullable
    final aa h;

    @Nullable
    final aa i;

    @Nullable
    final aa j;
    final long k;
    final long l;
    private volatile d m;

    aa(a aVar) {
        this.f5049a = aVar.f5051a;
        this.f5050b = aVar.f5052b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f.a();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    public y a() {
        return this.f5049a;
    }

    public w b() {
        return this.f5050b;
    }

    public int c() {
        return this.c;
    }

    public boolean d() {
        return this.c >= 200 && this.c < 300;
    }

    public String e() {
        return this.d;
    }

    public q f() {
        return this.e;
    }

    @Nullable
    public String a(String str) {
        return a(str, null);
    }

    @Nullable
    public String a(String str, @Nullable String str2) {
        String strA = this.f.a(str);
        return strA != null ? strA : str2;
    }

    public r g() {
        return this.f;
    }

    @Nullable
    public ab h() {
        return this.g;
    }

    public a i() {
        return new a(this);
    }

    @Nullable
    public aa j() {
        return this.h;
    }

    @Nullable
    public aa k() {
        return this.i;
    }

    @Nullable
    public aa l() {
        return this.j;
    }

    public d m() {
        d dVar = this.m;
        if (dVar != null) {
            return dVar;
        }
        d dVarA = d.a(this.f);
        this.m = dVarA;
        return dVarA;
    }

    public long n() {
        return this.k;
    }

    public long o() {
        return this.l;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.g == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        this.g.close();
    }

    public String toString() {
        return "Response{protocol=" + this.f5050b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.f5049a.a() + '}';
    }

    /* compiled from: Response.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        y f5051a;

        /* renamed from: b, reason: collision with root package name */
        w f5052b;
        int c;
        String d;

        @Nullable
        q e;
        r.a f;
        ab g;
        aa h;
        aa i;
        aa j;
        long k;
        long l;

        public a() {
            this.c = -1;
            this.f = new r.a();
        }

        a(aa aaVar) {
            this.c = -1;
            this.f5051a = aaVar.f5049a;
            this.f5052b = aaVar.f5050b;
            this.c = aaVar.c;
            this.d = aaVar.d;
            this.e = aaVar.e;
            this.f = aaVar.f.b();
            this.g = aaVar.g;
            this.h = aaVar.h;
            this.i = aaVar.i;
            this.j = aaVar.j;
            this.k = aaVar.k;
            this.l = aaVar.l;
        }

        public a a(y yVar) {
            this.f5051a = yVar;
            return this;
        }

        public a a(w wVar) {
            this.f5052b = wVar;
            return this;
        }

        public a a(int i) {
            this.c = i;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a a(@Nullable q qVar) {
            this.e = qVar;
            return this;
        }

        public a a(String str, String str2) {
            this.f.a(str, str2);
            return this;
        }

        public a a(r rVar) {
            this.f = rVar.b();
            return this;
        }

        public a a(@Nullable ab abVar) {
            this.g = abVar;
            return this;
        }

        public a a(@Nullable aa aaVar) {
            if (aaVar != null) {
                a("networkResponse", aaVar);
            }
            this.h = aaVar;
            return this;
        }

        public a b(@Nullable aa aaVar) {
            if (aaVar != null) {
                a("cacheResponse", aaVar);
            }
            this.i = aaVar;
            return this;
        }

        private void a(String str, aa aaVar) {
            if (aaVar.g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (aaVar.h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (aaVar.i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (aaVar.j == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        public a c(@Nullable aa aaVar) {
            if (aaVar != null) {
                d(aaVar);
            }
            this.j = aaVar;
            return this;
        }

        private void d(aa aaVar) {
            if (aaVar.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(long j) {
            this.k = j;
            return this;
        }

        public a b(long j) {
            this.l = j;
            return this;
        }

        public aa a() {
            if (this.f5051a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f5052b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.c < 0) {
                throw new IllegalStateException("code < 0: " + this.c);
            }
            if (this.d == null) {
                throw new IllegalStateException("message == null");
            }
            return new aa(this);
        }
    }
}
