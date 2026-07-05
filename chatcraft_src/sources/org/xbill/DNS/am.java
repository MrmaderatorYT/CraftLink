package org.xbill.DNS;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Lookup.java */
/* loaded from: classes.dex */
public final class am {
    private static final bg[] D = new bg[0];

    /* renamed from: a, reason: collision with root package name */
    static Class f5322a;

    /* renamed from: b, reason: collision with root package name */
    private static bv f5323b;
    private static bg[] c;
    private static Map d;
    private static int e;
    private boolean A;
    private boolean B;
    private boolean C;
    private bv f;
    private bg[] g;
    private k h;
    private boolean i;
    private int j;
    private bg k;
    private int l;
    private int m;
    private boolean n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private List s;
    private bt[] t;
    private int u;
    private String v;
    private boolean w;
    private boolean x;
    private String y;
    private boolean z;

    static {
        a();
    }

    public static synchronized void a() {
        try {
            f5323b = new z();
            c = bw.e().c();
            d = new HashMap();
            e = bw.e().d();
        } catch (UnknownHostException unused) {
            throw new RuntimeException("Failed to initialize resolver");
        }
    }

    public static synchronized bv b() {
        return f5323b;
    }

    public static synchronized k a(int i) {
        k kVar;
        p.a(i);
        kVar = (k) d.get(av.c(i));
        if (kVar == null) {
            kVar = new k(i);
            d.put(av.c(i), kVar);
        }
        return kVar;
    }

    public static synchronized bg[] c() {
        return c;
    }

    private final void e() {
        this.o = 0;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = null;
        this.t = null;
        this.u = -1;
        this.v = null;
        this.w = false;
        this.x = false;
        this.y = null;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        if (this.i) {
            this.h.a();
        }
    }

    public am(bg bgVar, int i, int i2) throws Throwable {
        Class clsA;
        ct.a(i);
        p.a(i2);
        if (!ct.d(i) && i != 255) {
            throw new IllegalArgumentException("Cannot query for meta-types other than ANY");
        }
        this.k = bgVar;
        this.l = i;
        this.m = i2;
        if (f5322a == null) {
            clsA = a("org.xbill.DNS.am");
            f5322a = clsA;
        } else {
            clsA = f5322a;
        }
        synchronized (clsA) {
            this.f = b();
            this.g = c();
            this.h = a(i2);
        }
        this.j = 3;
        this.n = bk.b("verbose");
        this.u = -1;
    }

    static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public am(String str, int i) {
        this(bg.a(str), i, 1);
    }

    private void a(bg bgVar, bg bgVar2) {
        this.p = true;
        this.x = false;
        this.z = false;
        this.A = false;
        this.w = false;
        this.C = false;
        this.o++;
        if (this.o >= 6 || bgVar.equals(bgVar2)) {
            this.u = 1;
            this.v = "CNAME loop";
            this.q = true;
        } else {
            if (this.s == null) {
                this.s = new ArrayList();
            }
            this.s.add(bgVar2);
            a(bgVar);
        }
    }

    private void a(bg bgVar, ch chVar) {
        if (chVar.f()) {
            bq[] bqVarArrG = chVar.g();
            ArrayList arrayList = new ArrayList();
            for (bq bqVar : bqVarArrG) {
                Iterator itC = bqVar.c();
                while (itC.hasNext()) {
                    arrayList.add(itC.next());
                }
            }
            this.u = 0;
            this.t = (bt[]) arrayList.toArray(new bt[arrayList.size()]);
            this.q = true;
            return;
        }
        if (chVar.a()) {
            this.w = true;
            this.r = true;
            if (this.o > 0) {
                this.u = 3;
                this.q = true;
                return;
            }
            return;
        }
        if (chVar.b()) {
            this.u = 4;
            this.t = null;
            this.q = true;
        } else {
            if (chVar.d()) {
                a(chVar.h().L_(), bgVar);
                return;
            }
            if (chVar.e()) {
                try {
                    a(bgVar.a(chVar.i()), bgVar);
                    return;
                } catch (NameTooLongException unused) {
                    this.u = 1;
                    this.v = "Invalid DNAME target";
                    this.q = true;
                    return;
                }
            }
            if (chVar.c()) {
                this.C = true;
            }
        }
    }

    private void a(bg bgVar) {
        ch chVarB = this.h.b(bgVar, this.l, this.j);
        if (this.n) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("lookup ");
            stringBuffer.append(bgVar);
            stringBuffer.append(" ");
            stringBuffer.append(ct.b(this.l));
            printStream.println(stringBuffer.toString());
            System.err.println(chVarB);
        }
        a(bgVar, chVarB);
        if (this.q || this.r) {
            return;
        }
        au auVarA = au.a(bt.a(bgVar, this.l, this.m));
        try {
            au auVarA2 = this.f.a(auVarA);
            int iC = auVarA2.a().c();
            if (iC != 0 && iC != 3) {
                this.x = true;
                this.y = bs.a(iC);
                return;
            }
            if (!auVarA.b().equals(auVarA2.b())) {
                this.x = true;
                this.y = "response does not match query";
                return;
            }
            ch chVarA = this.h.a(auVarA2);
            if (chVarA == null) {
                chVarA = this.h.b(bgVar, this.l, this.j);
            }
            if (this.n) {
                PrintStream printStream2 = System.err;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("queried ");
                stringBuffer2.append(bgVar);
                stringBuffer2.append(" ");
                stringBuffer2.append(ct.b(this.l));
                printStream2.println(stringBuffer2.toString());
                System.err.println(chVarA);
            }
            a(bgVar, chVarA);
        } catch (IOException e2) {
            if (e2 instanceof InterruptedIOException) {
                this.A = true;
            } else {
                this.z = true;
            }
        }
    }

    private void b(bg bgVar, bg bgVar2) {
        this.r = false;
        if (bgVar2 != null) {
            try {
                bgVar = bg.a(bgVar, bgVar2);
            } catch (NameTooLongException unused) {
                this.B = true;
                return;
            }
        }
        a(bgVar);
    }

    public bt[] d() {
        if (this.q) {
            e();
        }
        if (this.k.a()) {
            b(this.k, null);
        } else if (this.g == null) {
            b(this.k, bg.f5343a);
        } else {
            if (this.k.c() > e) {
                b(this.k, bg.f5343a);
            }
            if (this.q) {
                return this.t;
            }
            for (int i = 0; i < this.g.length; i++) {
                b(this.k, this.g[i]);
                if (this.q) {
                    return this.t;
                }
                if (this.p) {
                    break;
                }
            }
        }
        if (!this.q) {
            if (this.x) {
                this.u = 2;
                this.v = this.y;
                this.q = true;
            } else if (this.A) {
                this.u = 2;
                this.v = "timed out";
                this.q = true;
            } else if (this.z) {
                this.u = 2;
                this.v = "network error";
                this.q = true;
            } else if (this.w) {
                this.u = 3;
                this.q = true;
            } else if (this.C) {
                this.u = 1;
                this.v = "referral";
                this.q = true;
            } else if (this.B) {
                this.u = 1;
                this.v = "name too long";
                this.q = true;
            }
        }
        return this.t;
    }
}
