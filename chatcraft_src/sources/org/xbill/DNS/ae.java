package org.xbill.DNS;

/* compiled from: HINFORecord.java */
/* loaded from: classes.dex */
public class ae extends bt {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5310a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f5311b;

    ae() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new ae();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5310a = tVar.k();
        this.f5311b = tVar.k();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.b(this.f5310a);
        vVar.b(this.f5311b);
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a(this.f5310a, true));
        stringBuffer.append(" ");
        stringBuffer.append(a(this.f5311b, true));
        return stringBuffer.toString();
    }
}
