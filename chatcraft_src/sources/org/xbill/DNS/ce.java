package org.xbill.DNS;

/* compiled from: SSHFPRecord.java */
/* loaded from: classes.dex */
public class ce extends bt {

    /* renamed from: a, reason: collision with root package name */
    private int f5370a;

    /* renamed from: b, reason: collision with root package name */
    private int f5371b;
    private byte[] c;

    ce() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new ce();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5370a = tVar.g();
        this.f5371b = tVar.g();
        this.c = tVar.j();
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5370a);
        stringBuffer.append(" ");
        stringBuffer.append(this.f5371b);
        stringBuffer.append(" ");
        stringBuffer.append(org.xbill.DNS.a.a.a(this.c));
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.b(this.f5370a);
        vVar.b(this.f5371b);
        vVar.a(this.c);
    }
}
