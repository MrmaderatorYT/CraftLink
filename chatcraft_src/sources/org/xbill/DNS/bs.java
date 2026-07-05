package org.xbill.DNS;

/* compiled from: Rcode.java */
/* loaded from: classes.dex */
public final class bs {

    /* renamed from: a, reason: collision with root package name */
    private static av f5355a = new av("DNS Rcode", 2);

    /* renamed from: b, reason: collision with root package name */
    private static av f5356b = new av("TSIG rcode", 2);

    static {
        f5355a.b(4095);
        f5355a.a("RESERVED");
        f5355a.a(true);
        f5355a.a(0, "NOERROR");
        f5355a.a(1, "FORMERR");
        f5355a.a(2, "SERVFAIL");
        f5355a.a(3, "NXDOMAIN");
        f5355a.a(4, "NOTIMP");
        f5355a.b(4, "NOTIMPL");
        f5355a.a(5, "REFUSED");
        f5355a.a(6, "YXDOMAIN");
        f5355a.a(7, "YXRRSET");
        f5355a.a(8, "NXRRSET");
        f5355a.a(9, "NOTAUTH");
        f5355a.a(10, "NOTZONE");
        f5355a.a(16, "BADVERS");
        f5356b.b(65535);
        f5356b.a("RESERVED");
        f5356b.a(true);
        f5356b.a(f5355a);
        f5356b.a(16, "BADSIG");
        f5356b.a(17, "BADKEY");
        f5356b.a(18, "BADTIME");
        f5356b.a(19, "BADMODE");
    }

    public static String a(int i) {
        return f5355a.d(i);
    }

    public static String b(int i) {
        return f5356b.d(i);
    }
}
