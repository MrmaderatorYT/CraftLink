package org.xbill.DNS;

/* compiled from: SMIMEARecord.java */
/* loaded from: classes.dex */
public class ca extends bt {

    /* renamed from: a, reason: collision with root package name */
    private int f5364a;

    /* renamed from: b, reason: collision with root package name */
    private int f5365b;
    private int c;
    private byte[] d;

    ca() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new ca();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5364a = tVar.g();
        this.f5365b = tVar.g();
        this.c = tVar.g();
        this.d = tVar.j();
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5364a);
        stringBuffer.append(" ");
        stringBuffer.append(this.f5365b);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        stringBuffer.append(" ");
        stringBuffer.append(org.xbill.DNS.a.a.a(this.d));
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.b(this.f5364a);
        vVar.b(this.f5365b);
        vVar.b(this.c);
        vVar.a(this.d);
    }
}
