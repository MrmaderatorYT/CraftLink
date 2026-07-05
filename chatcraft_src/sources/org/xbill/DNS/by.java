package org.xbill.DNS;

import java.util.Date;

/* compiled from: SIGBase.java */
/* loaded from: classes.dex */
abstract class by extends bt {

    /* renamed from: a, reason: collision with root package name */
    protected int f5362a;

    /* renamed from: b, reason: collision with root package name */
    protected int f5363b;
    protected int c;
    protected long d;
    protected Date e;
    protected Date f;
    protected int k;
    protected bg l;
    protected byte[] m;

    protected by() {
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5362a = tVar.h();
        this.f5363b = tVar.g();
        this.c = tVar.g();
        this.d = tVar.i();
        this.e = new Date(tVar.i() * 1000);
        this.f = new Date(tVar.i() * 1000);
        this.k = tVar.h();
        this.l = new bg(tVar);
        this.m = tVar.j();
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(ct.b(this.f5362a));
        stringBuffer.append(" ");
        stringBuffer.append(this.f5363b);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        stringBuffer.append(" ");
        stringBuffer.append(this.d);
        stringBuffer.append(" ");
        if (bk.b("multiline")) {
            stringBuffer.append("(\n\t");
        }
        stringBuffer.append(ab.a(this.e));
        stringBuffer.append(" ");
        stringBuffer.append(ab.a(this.f));
        stringBuffer.append(" ");
        stringBuffer.append(this.k);
        stringBuffer.append(" ");
        stringBuffer.append(this.l);
        if (bk.b("multiline")) {
            stringBuffer.append("\n");
            stringBuffer.append(org.xbill.DNS.a.c.a(this.m, 64, "\t", true));
        } else {
            stringBuffer.append(" ");
            stringBuffer.append(org.xbill.DNS.a.c.a(this.m));
        }
        return stringBuffer.toString();
    }

    public int d() {
        return this.f5362a;
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.c(this.f5362a);
        vVar.b(this.f5363b);
        vVar.b(this.c);
        vVar.a(this.d);
        vVar.a(this.e.getTime() / 1000);
        vVar.a(this.f.getTime() / 1000);
        vVar.c(this.k);
        this.l.a(vVar, (n) null, z);
        vVar.a(this.m);
    }
}
