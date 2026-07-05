package org.xbill.DNS;

/* compiled from: Flags.java */
/* loaded from: classes.dex */
public final class aa {

    /* renamed from: a, reason: collision with root package name */
    private static av f5304a = new av("DNS Header Flag", 3);

    static {
        f5304a.b(15);
        f5304a.a("FLAG");
        f5304a.a(true);
        f5304a.a(0, "qr");
        f5304a.a(5, "aa");
        f5304a.a(6, "tc");
        f5304a.a(7, "rd");
        f5304a.a(8, "ra");
        f5304a.a(10, "ad");
        f5304a.a(11, "cd");
    }

    public static String a(int i) {
        return f5304a.d(i);
    }

    public static boolean b(int i) {
        f5304a.a(i);
        return (i < 1 || i > 4) && i < 12;
    }
}
