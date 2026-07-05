package org.xbill.DNS;

/* compiled from: X25Record.java */
/* loaded from: classes.dex */
public class db extends bt {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5403a;

    db() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new db();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5403a = tVar.k();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.b(this.f5403a);
    }

    @Override // org.xbill.DNS.bt
    String b() {
        return a(this.f5403a, true);
    }
}
