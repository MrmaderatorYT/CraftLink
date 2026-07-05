package org.xbill.DNS;

/* compiled from: RPRecord.java */
/* loaded from: classes.dex */
public class bo extends bt {

    /* renamed from: a, reason: collision with root package name */
    private bg f5351a;

    /* renamed from: b, reason: collision with root package name */
    private bg f5352b;

    bo() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new bo();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5351a = new bg(tVar);
        this.f5352b = new bg(tVar);
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5351a);
        stringBuffer.append(" ");
        stringBuffer.append(this.f5352b);
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        this.f5351a.a(vVar, (n) null, z);
        this.f5352b.a(vVar, (n) null, z);
    }
}
