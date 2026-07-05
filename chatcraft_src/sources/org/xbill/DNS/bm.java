package org.xbill.DNS;

/* compiled from: PXRecord.java */
/* loaded from: classes.dex */
public class bm extends bt {

    /* renamed from: a, reason: collision with root package name */
    private int f5349a;

    /* renamed from: b, reason: collision with root package name */
    private bg f5350b;
    private bg c;

    bm() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new bm();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5349a = tVar.h();
        this.f5350b = new bg(tVar);
        this.c = new bg(tVar);
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5349a);
        stringBuffer.append(" ");
        stringBuffer.append(this.f5350b);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.c(this.f5349a);
        this.f5350b.a(vVar, (n) null, z);
        this.c.a(vVar, (n) null, z);
    }
}
