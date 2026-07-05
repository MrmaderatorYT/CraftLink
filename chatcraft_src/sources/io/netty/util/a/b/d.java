package io.netty.util.a.b;

import io.netty.util.a.r;

/* compiled from: InternalLoggerFactory.java */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile d f4648a = c(d.class.getName());

    protected abstract c b(String str);

    static {
        try {
            Class.forName(r.class.getName(), true, d.class.getClassLoader());
        } catch (Exception unused) {
        }
    }

    private static d c(String str) {
        try {
            try {
                k kVar = new k(true);
                kVar.b(str).a("Using SLF4J as the default logging framework");
                return kVar;
            } catch (Throwable unused) {
                d dVar = f.f4651a;
                dVar.b(str).a("Using java.util.logging as the default logging framework");
                return dVar;
            }
        } catch (Throwable unused2) {
            d dVar2 = h.f4654a;
            dVar2.b(str).a("Using Log4J as the default logging framework");
            return dVar2;
        }
    }

    public static d a() {
        return f4648a;
    }

    public static c a(Class<?> cls) {
        return a(cls.getName());
    }

    public static c a(String str) {
        return a().b(str);
    }
}
