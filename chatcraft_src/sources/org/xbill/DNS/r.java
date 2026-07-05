package org.xbill.DNS;

/* compiled from: DLVRecord.java */
/* loaded from: classes.dex */
public class r extends bt {

    /* renamed from: a, reason: collision with root package name */
    private int f5432a;

    /* renamed from: b, reason: collision with root package name */
    private int f5433b;
    private int c;
    private byte[] d;

    r() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new r();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5432a = tVar.h();
        this.f5433b = tVar.g();
        this.c = tVar.g();
        this.d = tVar.j();
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5432a);
        stringBuffer.append(" ");
        stringBuffer.append(this.f5433b);
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
        vVar.c(this.f5432a);
        vVar.b(this.f5433b);
        vVar.b(this.c);
        if (this.d != null) {
            vVar.a(this.d);
        }
    }
}
