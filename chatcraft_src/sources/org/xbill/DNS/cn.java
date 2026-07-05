package org.xbill.DNS;

/* compiled from: TLSARecord.java */
/* loaded from: classes.dex */
public class cn extends bt {

    /* renamed from: a, reason: collision with root package name */
    private int f5381a;

    /* renamed from: b, reason: collision with root package name */
    private int f5382b;
    private int c;
    private byte[] d;

    cn() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new cn();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5381a = tVar.g();
        this.f5382b = tVar.g();
        this.c = tVar.g();
        this.d = tVar.j();
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5381a);
        stringBuffer.append(" ");
        stringBuffer.append(this.f5382b);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        stringBuffer.append(" ");
        stringBuffer.append(org.xbill.DNS.a.a.a(this.d));
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.b(this.f5381a);
        vVar.b(this.f5382b);
        vVar.b(this.c);
        vVar.a(this.d);
    }
}
