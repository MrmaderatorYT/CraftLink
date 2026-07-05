package org.xbill.DNS;

/* compiled from: URIRecord.java */
/* loaded from: classes.dex */
public class cz extends bt {

    /* renamed from: a, reason: collision with root package name */
    private int f5396a;

    /* renamed from: b, reason: collision with root package name */
    private int f5397b;
    private byte[] c = new byte[0];

    cz() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new cz();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5396a = tVar.h();
        this.f5397b = tVar.h();
        this.c = tVar.j();
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(this.f5396a);
        stringBuffer2.append(" ");
        stringBuffer.append(stringBuffer2.toString());
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(this.f5397b);
        stringBuffer3.append(" ");
        stringBuffer.append(stringBuffer3.toString());
        stringBuffer.append(a(this.c, true));
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.c(this.f5396a);
        vVar.c(this.f5397b);
        vVar.a(this.c);
    }
}
