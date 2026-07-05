package org.xbill.DNS;

/* compiled from: DClass.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private static av f5430a = new a();

    /* compiled from: DClass.java */
    private static class a extends av {
        public a() {
            super("DClass", 2);
            a("CLASS");
        }

        @Override // org.xbill.DNS.av
        public void a(int i) {
            p.a(i);
        }
    }

    static {
        f5430a.a(1, "IN");
        f5430a.a(3, "CH");
        f5430a.b(3, "CHAOS");
        f5430a.a(4, "HS");
        f5430a.b(4, "HESIOD");
        f5430a.a(254, "NONE");
        f5430a.a(255, "ANY");
    }

    public static void a(int i) {
        if (i < 0 || i > 65535) {
            throw new InvalidDClassException(i);
        }
    }

    public static String b(int i) {
        return f5430a.d(i);
    }
}
