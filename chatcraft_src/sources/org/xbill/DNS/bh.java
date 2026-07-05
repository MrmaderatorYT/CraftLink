package org.xbill.DNS;

/* compiled from: OPENPGPKEYRecord.java */
/* loaded from: classes.dex */
public class bh extends bt {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5345a;

    bh() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new bh();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5345a = tVar.j();
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f5345a != null) {
            if (bk.b("multiline")) {
                stringBuffer.append("(\n");
                stringBuffer.append(org.xbill.DNS.a.c.a(this.f5345a, 64, "\t", true));
            } else {
                stringBuffer.append(org.xbill.DNS.a.c.a(this.f5345a));
            }
        }
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.a(this.f5345a);
    }
}
