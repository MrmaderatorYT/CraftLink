package org.xbill.DNS;

/* compiled from: CERTRecord.java */
/* loaded from: classes.dex */
public class i extends bt {

    /* renamed from: a, reason: collision with root package name */
    private int f5413a;

    /* renamed from: b, reason: collision with root package name */
    private int f5414b;
    private int c;
    private byte[] d;

    i() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new i();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5413a = tVar.h();
        this.f5414b = tVar.h();
        this.c = tVar.g();
        this.d = tVar.j();
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5413a);
        stringBuffer.append(" ");
        stringBuffer.append(this.f5414b);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        if (this.d != null) {
            if (bk.b("multiline")) {
                stringBuffer.append(" (\n");
                stringBuffer.append(org.xbill.DNS.a.c.a(this.d, 64, "\t", true));
            } else {
                stringBuffer.append(" ");
                stringBuffer.append(org.xbill.DNS.a.c.a(this.d));
            }
        }
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.c(this.f5413a);
        vVar.c(this.f5414b);
        vVar.b(this.c);
        vVar.a(this.d);
    }
}
