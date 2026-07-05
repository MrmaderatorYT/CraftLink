package org.xbill.DNS;

/* compiled from: MINFORecord.java */
/* loaded from: classes.dex */
public class ar extends bt {

    /* renamed from: a, reason: collision with root package name */
    private bg f5324a;

    /* renamed from: b, reason: collision with root package name */
    private bg f5325b;

    ar() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new ar();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5324a = new bg(tVar);
        this.f5325b = new bg(tVar);
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5324a);
        stringBuffer.append(" ");
        stringBuffer.append(this.f5325b);
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        this.f5324a.a(vVar, (n) null, z);
        this.f5325b.a(vVar, (n) null, z);
    }
}
