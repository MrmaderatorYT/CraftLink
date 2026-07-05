package org.xbill.DNS;

import java.io.IOException;
import java.io.PrintStream;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import org.xbill.DNS.co;

/* compiled from: ZoneTransferIn.java */
/* loaded from: classes.dex */
public class dc {

    /* renamed from: a, reason: collision with root package name */
    private bg f5404a;

    /* renamed from: b, reason: collision with root package name */
    private int f5405b;
    private int c;
    private long d;
    private boolean e;
    private c f;
    private SocketAddress g;
    private SocketAddress h;
    private cl i;
    private co j;
    private co.a k;
    private long l = 900000;
    private int m;
    private long n;
    private long o;
    private bt p;
    private int q;

    /* compiled from: ZoneTransferIn.java */
    public interface c {
        void a();

        void a(bt btVar);

        void b();

        void b(bt btVar);

        void c(bt btVar);
    }

    static long a(bt btVar) {
        return b(btVar);
    }

    /* compiled from: ZoneTransferIn.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public long f5408a;

        /* renamed from: b, reason: collision with root package name */
        public long f5409b;
        public List c;
        public List d;

        b(dd ddVar) {
            this();
        }

        private b() {
            this.c = new ArrayList();
            this.d = new ArrayList();
        }
    }

    /* compiled from: ZoneTransferIn.java */
    private static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private List f5406a;

        /* renamed from: b, reason: collision with root package name */
        private List f5407b;

        private a() {
        }

        a(dd ddVar) {
            this();
        }

        static List a(a aVar) {
            return aVar.f5406a;
        }

        static List b(a aVar) {
            return aVar.f5407b;
        }

        @Override // org.xbill.DNS.dc.c
        public void a() {
            this.f5406a = new ArrayList();
        }

        @Override // org.xbill.DNS.dc.c
        public void b() {
            this.f5407b = new ArrayList();
        }

        @Override // org.xbill.DNS.dc.c
        public void a(bt btVar) {
            b bVar = new b(null);
            bVar.d.add(btVar);
            bVar.f5408a = dc.a(btVar);
            this.f5407b.add(bVar);
        }

        @Override // org.xbill.DNS.dc.c
        public void b(bt btVar) {
            b bVar = (b) this.f5407b.get(this.f5407b.size() - 1);
            bVar.c.add(btVar);
            bVar.f5409b = dc.a(btVar);
        }

        @Override // org.xbill.DNS.dc.c
        public void c(bt btVar) {
            List list;
            if (this.f5407b != null) {
                b bVar = (b) this.f5407b.get(this.f5407b.size() - 1);
                if (bVar.c.size() > 0) {
                    list = bVar.c;
                } else {
                    list = bVar.d;
                }
            } else {
                list = this.f5406a;
            }
            list.add(btVar);
        }
    }

    private dc() {
    }

    private dc(bg bgVar, int i, long j, boolean z, SocketAddress socketAddress, co coVar) {
        this.h = socketAddress;
        this.j = coVar;
        if (bgVar.a()) {
            this.f5404a = bgVar;
        } else {
            try {
                this.f5404a = bg.a(bgVar, bg.f5343a);
            } catch (NameTooLongException unused) {
                throw new IllegalArgumentException("ZoneTransferIn: name too long");
            }
        }
        this.f5405b = i;
        this.c = 1;
        this.d = j;
        this.e = z;
        this.m = 0;
    }

    public static dc a(bg bgVar, SocketAddress socketAddress, co coVar) {
        return new dc(bgVar, 252, 0L, false, socketAddress, coVar);
    }

    public void a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("timeout cannot be negative");
        }
        this.l = i * 1000;
    }

    public void a(SocketAddress socketAddress) {
        this.g = socketAddress;
    }

    private void c() throws IOException {
        this.i = new cl(System.currentTimeMillis() + this.l);
        if (this.g != null) {
            this.i.a(this.g);
        }
        this.i.b(this.h);
    }

    private void d() {
        bt btVarA = bt.a(this.f5404a, this.f5405b, this.c);
        au auVar = new au();
        auVar.a().d(0);
        auVar.a(btVarA, 0);
        if (this.f5405b == 251) {
            auVar.a(new cb(this.f5404a, this.c, 0L, bg.f5343a, bg.f5343a, this.d, 0L, 0L, 0L, 0L), 2);
        }
        if (this.j != null) {
            this.j.a(auVar, (cp) null);
            this.k = new co.a(this.j, auVar.c());
        }
        this.i.a(auVar.c(65535));
    }

    private static long b(bt btVar) {
        return ((cb) btVar).d();
    }

    private void a(String str) {
        if (bk.b("verbose")) {
            PrintStream printStream = System.out;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f5404a);
            stringBuffer.append(": ");
            stringBuffer.append(str);
            printStream.println(stringBuffer.toString());
        }
    }

    private void b(String str) throws ZoneTransferException {
        throw new ZoneTransferException(str);
    }

    private void e() throws ZoneTransferException {
        if (!this.e) {
            b("server doesn't support IXFR");
        }
        a("falling back to AXFR");
        this.f5405b = 252;
        this.m = 0;
    }

    private void c(bt btVar) throws ZoneTransferException {
        int iK = btVar.k();
        switch (this.m) {
            case 0:
                if (iK != 6) {
                    b("missing initial SOA");
                }
                this.p = btVar;
                this.n = b(btVar);
                if (this.f5405b == 251 && cg.a(this.n, this.d) <= 0) {
                    a("up to date");
                    this.m = 7;
                    break;
                } else {
                    this.m = 1;
                    break;
                }
                break;
            case 1:
                if (this.f5405b == 251 && iK == 6 && b(btVar) == this.d) {
                    this.q = 251;
                    this.f.b();
                    a("got incremental response");
                    this.m = 2;
                } else {
                    this.q = 252;
                    this.f.a();
                    this.f.c(this.p);
                    a("got nonincremental response");
                    this.m = 6;
                }
                c(btVar);
                break;
            case 2:
                this.f.a(btVar);
                this.m = 3;
                break;
            case 3:
                if (iK == 6) {
                    this.o = b(btVar);
                    this.m = 4;
                    c(btVar);
                    break;
                } else {
                    this.f.c(btVar);
                    break;
                }
            case 4:
                this.f.b(btVar);
                this.m = 5;
                break;
            case 5:
                if (iK == 6) {
                    long jB = b(btVar);
                    if (jB != this.n) {
                        if (jB != this.o) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("IXFR out of sync: expected serial ");
                            stringBuffer.append(this.o);
                            stringBuffer.append(" , got ");
                            stringBuffer.append(jB);
                            b(stringBuffer.toString());
                        } else {
                            this.m = 2;
                            c(btVar);
                            break;
                        }
                    } else {
                        this.m = 7;
                        break;
                    }
                }
                this.f.c(btVar);
                break;
            case 6:
                if (iK != 1 || btVar.m() == this.c) {
                    this.f.c(btVar);
                    if (iK == 6) {
                        this.m = 7;
                        break;
                    }
                }
                break;
            case 7:
                b("extra data");
                break;
            default:
                b("invalid state");
                break;
        }
    }

    private void f() {
        try {
            if (this.i != null) {
                this.i.a();
            }
        } catch (IOException unused) {
        }
    }

    private au a(byte[] bArr) throws WireParseException {
        try {
            return new au(bArr);
        } catch (IOException e) {
            if (e instanceof WireParseException) {
                throw ((WireParseException) e);
            }
            throw new WireParseException("Error parsing message");
        }
    }

    private void g() throws ZoneTransferException, WireParseException {
        d();
        while (this.m != 7) {
            byte[] bArrB = this.i.b();
            au auVarA = a(bArrB);
            if (auVarA.a().c() == 0 && this.k != null) {
                auVarA.c();
                if (this.k.a(auVarA, bArrB) != 0) {
                    b("TSIG failure");
                }
            }
            bt[] btVarArrA = auVarA.a(1);
            if (this.m == 0) {
                int iG = auVarA.g();
                if (iG != 0) {
                    if (this.f5405b == 251 && iG == 4) {
                        e();
                        g();
                        return;
                    }
                    b(bs.a(iG));
                }
                bt btVarB = auVarA.b();
                if (btVarB != null && btVarB.k() != this.f5405b) {
                    b("invalid question section");
                }
                if (btVarArrA.length == 0 && this.f5405b == 251) {
                    e();
                    g();
                    return;
                }
            }
            for (bt btVar : btVarArrA) {
                c(btVar);
            }
            if (this.m == 7 && this.k != null && !auVarA.e()) {
                b("last message must be signed");
            }
        }
    }

    public void a(c cVar) {
        this.f = cVar;
        try {
            c();
            g();
        } finally {
            f();
        }
    }

    public List a() {
        a aVar = new a(null);
        a(aVar);
        if (a.a(aVar) != null) {
            return a.a(aVar);
        }
        return a.b(aVar);
    }

    private a h() {
        if (this.f instanceof a) {
            return (a) this.f;
        }
        throw new IllegalArgumentException("ZoneTransferIn used callback interface");
    }

    public List b() {
        return a.a(h());
    }
}
