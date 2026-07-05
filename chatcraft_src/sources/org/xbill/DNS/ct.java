package org.xbill.DNS;

import java.util.HashMap;

/* compiled from: Type.java */
/* loaded from: classes.dex */
public final class ct {

    /* renamed from: a, reason: collision with root package name */
    private static a f5390a = new a();

    public static boolean d(int i) {
        if (i == 41) {
            return false;
        }
        switch (i) {
            case 249:
            case 250:
            case 251:
            case 252:
            case 253:
            case 254:
            case 255:
                return false;
            default:
                return true;
        }
    }

    /* compiled from: Type.java */
    private static class a extends av {

        /* renamed from: a, reason: collision with root package name */
        private HashMap f5391a;

        public a() {
            super("Type", 2);
            a("TYPE");
            this.f5391a = new HashMap();
        }

        public void a(int i, String str, bt btVar) {
            super.a(i, str);
            this.f5391a.put(av.c(i), btVar);
        }

        @Override // org.xbill.DNS.av
        public void a(int i) {
            ct.a(i);
        }

        public bt e(int i) {
            a(i);
            return (bt) this.f5391a.get(c(i));
        }
    }

    static {
        f5390a.a(1, "A", new f());
        f5390a.a(2, "NS", new bd());
        f5390a.a(3, "MD", new ao());
        f5390a.a(4, "MF", new ap());
        f5390a.a(5, "CNAME", new j());
        f5390a.a(6, "SOA", new cb());
        f5390a.a(7, "MB", new an());
        f5390a.a(8, "MG", new aq());
        f5390a.a(9, "MR", new as());
        f5390a.a(10, "NULL", new be());
        f5390a.a(11, "WKS", new da());
        f5390a.a(12, "PTR", new bl());
        f5390a.a(13, "HINFO", new ae());
        f5390a.a(14, "MINFO", new ar());
        f5390a.a(15, "MX", new at());
        f5390a.a(16, "TXT", new cs());
        f5390a.a(17, "RP", new bo());
        f5390a.a(18, "AFSDB", new c());
        f5390a.a(19, "X25", new db());
        f5390a.a(20, "ISDN", new ah());
        f5390a.a(21, "RT", new br());
        f5390a.a(22, "NSAP", new ax());
        f5390a.a(23, "NSAP-PTR", new ay());
        f5390a.a(24, "SIG", new bz());
        f5390a.a(25, "KEY", new aj());
        f5390a.a(26, "PX", new bm());
        f5390a.a(27, "GPOS", new ac());
        f5390a.a(28, "AAAA", new b());
        f5390a.a(29, "LOC", new al());
        f5390a.a(30, "NXT", new bf());
        f5390a.a(31, "EID");
        f5390a.a(32, "NIMLOC");
        f5390a.a(33, "SRV", new cd());
        f5390a.a(34, "ATMA");
        f5390a.a(35, "NAPTR", new aw());
        f5390a.a(36, "KX", new ak());
        f5390a.a(37, "CERT", new i());
        f5390a.a(38, "A6", new org.xbill.DNS.a());
        f5390a.a(39, "DNAME", new s());
        f5390a.a(41, "OPT", new bi());
        f5390a.a(42, "APL", new d());
        f5390a.a(43, "DS", new w());
        f5390a.a(44, "SSHFP", new ce());
        f5390a.a(45, "IPSECKEY", new ag());
        f5390a.a(46, "RRSIG", new bp());
        f5390a.a(47, "NSEC", new bb());
        f5390a.a(48, "DNSKEY", new u());
        f5390a.a(49, "DHCID", new q());
        f5390a.a(50, "NSEC3", new ba());
        f5390a.a(51, "NSEC3PARAM", new az());
        f5390a.a(52, "TLSA", new cn());
        f5390a.a(53, "SMIMEA", new ca());
        f5390a.a(61, "OPENPGPKEY", new bh());
        f5390a.a(99, "SPF", new cc());
        f5390a.a(249, "TKEY", new cm());
        f5390a.a(250, "TSIG", new cp());
        f5390a.a(251, "IXFR");
        f5390a.a(252, "AXFR");
        f5390a.a(253, "MAILB");
        f5390a.a(254, "MAILA");
        f5390a.a(255, "ANY");
        f5390a.a(256, "URI", new cz());
        f5390a.a(257, "CAA", new h());
        f5390a.a(32769, "DLV", new r());
    }

    public static void a(int i) {
        if (i < 0 || i > 65535) {
            throw new InvalidTypeException(i);
        }
    }

    public static String b(int i) {
        return f5390a.d(i);
    }

    static bt c(int i) {
        return f5390a.e(i);
    }
}
