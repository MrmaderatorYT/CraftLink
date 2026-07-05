package org.xbill.DNS;

/* compiled from: DSRecord.java */
/* loaded from: classes.dex */
public class w extends bt {

    /* renamed from: a, reason: collision with root package name */
    private int f5438a;

    /* renamed from: b, reason: collision with root package name */
    private int f5439b;
    private int c;
    private byte[] d;

    w() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new w();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5438a = tVar.h();
        this.f5439b = tVar.g();
        this.c = tVar.g();
        this.d = tVar.j();
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5438a);
        stringBuffer.append(" ");
        stringBuffer.append(this.f5439b);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        if (this.d != null) {
            stringBuffer.append(" ");
            stringBuffer.append(org.xbill.DNS.a.a.a(this.d));
        }
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.c(this.f5438a);
        vVar.b(this.f5439b);
        vVar.b(this.c);
        if (this.d != null) {
            vVar.a(this.d);
        }
    }
}
