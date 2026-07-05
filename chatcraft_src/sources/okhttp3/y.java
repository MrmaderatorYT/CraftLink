package okhttp3;

import java.util.List;
import javax.annotation.Nullable;
import okhttp3.r;

/* compiled from: Request.java */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    final s f5259a;

    /* renamed from: b, reason: collision with root package name */
    final String f5260b;
    final r c;

    @Nullable
    final z d;
    final Object e;
    private volatile d f;

    y(a aVar) {
        this.f5259a = aVar.f5261a;
        this.f5260b = aVar.f5262b;
        this.c = aVar.c.a();
        this.d = aVar.d;
        this.e = aVar.e != null ? aVar.e : this;
    }

    public s a() {
        return this.f5259a;
    }

    public String b() {
        return this.f5260b;
    }

    public r c() {
        return this.c;
    }

    @Nullable
    public String a(String str) {
        return this.c.a(str);
    }

    public List<String> b(String str) {
        return this.c.b(str);
    }

    @Nullable
    public z d() {
        return this.d;
    }

    public a e() {
        return new a(this);
    }

    public d f() {
        d dVar = this.f;
        if (dVar != null) {
            return dVar;
        }
        d dVarA = d.a(this.c);
        this.f = dVarA;
        return dVarA;
    }

    public boolean g() {
        return this.f5259a.c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f5260b);
        sb.append(", url=");
        sb.append(this.f5259a);
        sb.append(", tag=");
        sb.append(this.e != this ? this.e : null);
        sb.append('}');
        return sb.toString();
    }

    /* compiled from: Request.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        s f5261a;

        /* renamed from: b, reason: collision with root package name */
        String f5262b;
        r.a c;
        z d;
        Object e;

        public a() {
            this.f5262b = "GET";
            this.c = new r.a();
        }

        a(y yVar) {
            this.f5261a = yVar.f5259a;
            this.f5262b = yVar.f5260b;
            this.d = yVar.d;
            this.e = yVar.e;
            this.c = yVar.c.b();
        }

        public a a(s sVar) {
            if (sVar == null) {
                throw new NullPointerException("url == null");
            }
            this.f5261a = sVar;
            return this;
        }

        public a a(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            s sVarE = s.e(str);
            if (sVarE == null) {
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            return a(sVarE);
        }

        public a a(String str, String str2) {
            this.c.c(str, str2);
            return this;
        }

        public a b(String str) {
            this.c.b(str);
            return this;
        }

        public a a(r rVar) {
            this.c = rVar.b();
            return this;
        }

        public a a(d dVar) {
            String string = dVar.toString();
            return string.isEmpty() ? b("Cache-Control") : a("Cache-Control", string);
        }

        public a a(String str, @Nullable z zVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (zVar != null && !okhttp3.internal.b.f.c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (zVar == null && okhttp3.internal.b.f.b(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
            this.f5262b = str;
            this.d = zVar;
            return this;
        }

        public y a() {
            if (this.f5261a == null) {
                throw new IllegalStateException("url == null");
            }
            return new y(this);
        }
    }
}
