package org.xbill.DNS;

/* compiled from: SOARecord.java */
/* loaded from: classes.dex */
public class cb extends bt {

    /* renamed from: a, reason: collision with root package name */
    private bg f5366a;

    /* renamed from: b, reason: collision with root package name */
    private bg f5367b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long k;

    cb() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new cb();
    }

    public cb(bg bgVar, int i, long j, bg bgVar2, bg bgVar3, long j2, long j3, long j4, long j5, long j6) {
        super(bgVar, 6, i, j);
        this.f5366a = a("host", bgVar2);
        this.f5367b = a("admin", bgVar3);
        this.c = a("serial", j2);
        this.d = a("refresh", j3);
        this.e = a("retry", j4);
        this.f = a("expire", j5);
        this.k = a("minimum", j6);
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5366a = new bg(tVar);
        this.f5367b = new bg(tVar);
        this.c = tVar.i();
        this.d = tVar.i();
        this.e = tVar.i();
        this.f = tVar.i();
        this.k = tVar.i();
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5366a);
        stringBuffer.append(" ");
        stringBuffer.append(this.f5367b);
        if (bk.b("multiline")) {
            stringBuffer.append(" (\n\t\t\t\t\t");
            stringBuffer.append(this.c);
            stringBuffer.append("\t; serial\n\t\t\t\t\t");
            stringBuffer.append(this.d);
            stringBuffer.append("\t; refresh\n\t\t\t\t\t");
            stringBuffer.append(this.e);
            stringBuffer.append("\t; retry\n\t\t\t\t\t");
            stringBuffer.append(this.f);
            stringBuffer.append("\t; expire\n\t\t\t\t\t");
            stringBuffer.append(this.k);
            stringBuffer.append(" )\t; minimum");
        } else {
            stringBuffer.append(" ");
            stringBuffer.append(this.c);
            stringBuffer.append(" ");
            stringBuffer.append(this.d);
            stringBuffer.append(" ");
            stringBuffer.append(this.e);
            stringBuffer.append(" ");
            stringBuffer.append(this.f);
            stringBuffer.append(" ");
            stringBuffer.append(this.k);
        }
        return stringBuffer.toString();
    }

    public long d() {
        return this.c;
    }

    public long e() {
        return this.k;
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        this.f5366a.a(vVar, nVar, z);
        this.f5367b.a(vVar, nVar, z);
        vVar.a(this.c);
        vVar.a(this.d);
        vVar.a(this.e);
        vVar.a(this.f);
        vVar.a(this.k);
    }
}
