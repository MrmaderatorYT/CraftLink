package org.xbill.DNS;

/* compiled from: Opcode.java */
/* loaded from: classes.dex */
public final class bj {

    /* renamed from: a, reason: collision with root package name */
    private static av f5347a = new av("DNS Opcode", 2);

    static {
        f5347a.b(15);
        f5347a.a("RESERVED");
        f5347a.a(true);
        f5347a.a(0, "QUERY");
        f5347a.a(1, "IQUERY");
        f5347a.a(2, "STATUS");
        f5347a.a(4, "NOTIFY");
        f5347a.a(5, "UPDATE");
    }

    public static String a(int i) {
        return f5347a.d(i);
    }
}
