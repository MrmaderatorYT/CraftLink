package org.xbill.DNS;

/* compiled from: NSAPRecord.java */
/* loaded from: classes.dex */
public class ax extends bt {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5332a;

    ax() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new ax();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5332a = tVar.j();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.a(this.f5332a);
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("0x");
        stringBuffer.append(org.xbill.DNS.a.a.a(this.f5332a));
        return stringBuffer.toString();
    }
}
