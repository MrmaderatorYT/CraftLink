package org.xbill.DNS;

/* compiled from: GenericEDNSOption.java */
/* loaded from: classes.dex */
public class ad extends x {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5309a;

    ad(int i) {
        super(i);
    }

    @Override // org.xbill.DNS.x
    void a(t tVar) {
        this.f5309a = tVar.j();
    }

    @Override // org.xbill.DNS.x
    void a(v vVar) {
        vVar.a(this.f5309a);
    }

    @Override // org.xbill.DNS.x
    String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<");
        stringBuffer.append(org.xbill.DNS.a.a.a(this.f5309a));
        stringBuffer.append(">");
        return stringBuffer.toString();
    }
}
