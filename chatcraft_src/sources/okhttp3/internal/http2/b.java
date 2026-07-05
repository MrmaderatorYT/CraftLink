package okhttp3.internal.http2;

/* compiled from: Header.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b.f f5172a = b.f.a(":");

    /* renamed from: b, reason: collision with root package name */
    public static final b.f f5173b = b.f.a(":status");
    public static final b.f c = b.f.a(":method");
    public static final b.f d = b.f.a(":path");
    public static final b.f e = b.f.a(":scheme");
    public static final b.f f = b.f.a(":authority");
    public final b.f g;
    public final b.f h;
    final int i;

    public b(String str, String str2) {
        this(b.f.a(str), b.f.a(str2));
    }

    public b(b.f fVar, String str) {
        this(fVar, b.f.a(str));
    }

    public b(b.f fVar, b.f fVar2) {
        this.g = fVar;
        this.h = fVar2;
        this.i = fVar.h() + 32 + fVar2.h();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.g.equals(bVar.g) && this.h.equals(bVar.h);
    }

    public int hashCode() {
        return ((527 + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return okhttp3.internal.c.a("%s: %s", this.g.a(), this.h.a());
    }
}
