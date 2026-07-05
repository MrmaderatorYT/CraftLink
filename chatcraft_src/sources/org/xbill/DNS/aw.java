package org.xbill.DNS;

/* compiled from: NAPTRRecord.java */
/* loaded from: classes.dex */
public class aw extends bt {

    /* renamed from: a, reason: collision with root package name */
    private int f5330a;

    /* renamed from: b, reason: collision with root package name */
    private int f5331b;
    private byte[] c;
    private byte[] d;
    private byte[] e;
    private bg f;

    aw() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new aw();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5330a = tVar.h();
        this.f5331b = tVar.h();
        this.c = tVar.k();
        this.d = tVar.k();
        this.e = tVar.k();
        this.f = new bg(tVar);
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5330a);
        stringBuffer.append(" ");
        stringBuffer.append(this.f5331b);
        stringBuffer.append(" ");
        stringBuffer.append(a(this.c, true));
        stringBuffer.append(" ");
        stringBuffer.append(a(this.d, true));
        stringBuffer.append(" ");
        stringBuffer.append(a(this.e, true));
        stringBuffer.append(" ");
        stringBuffer.append(this.f);
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.c(this.f5330a);
        vVar.c(this.f5331b);
        vVar.b(this.c);
        vVar.b(this.d);
        vVar.b(this.e);
        this.f.a(vVar, (n) null, z);
    }

    @Override // org.xbill.DNS.bt
    public bg c() {
        return this.f;
    }
}
