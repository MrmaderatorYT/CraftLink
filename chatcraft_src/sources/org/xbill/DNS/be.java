package org.xbill.DNS;

/* compiled from: NULLRecord.java */
/* loaded from: classes.dex */
public class be extends bt {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5340a;

    be() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new be();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5340a = tVar.j();
    }

    @Override // org.xbill.DNS.bt
    String b() {
        return a(this.f5340a);
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.a(this.f5340a);
    }
}
