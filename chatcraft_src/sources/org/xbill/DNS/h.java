package org.xbill.DNS;

/* compiled from: CAARecord.java */
/* loaded from: classes.dex */
public class h extends bt {

    /* renamed from: a, reason: collision with root package name */
    private int f5411a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f5412b;
    private byte[] c;

    h() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new h();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5411a = tVar.g();
        this.f5412b = tVar.k();
        this.c = tVar.j();
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5411a);
        stringBuffer.append(" ");
        stringBuffer.append(a(this.f5412b, false));
        stringBuffer.append(" ");
        stringBuffer.append(a(this.c, true));
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.b(this.f5411a);
        vVar.b(this.f5412b);
        vVar.a(this.c);
    }
}
