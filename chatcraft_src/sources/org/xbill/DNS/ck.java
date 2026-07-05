package org.xbill.DNS;

/* compiled from: SingleNameBase.java */
/* loaded from: classes.dex */
abstract class ck extends bt {

    /* renamed from: a, reason: collision with root package name */
    protected bg f5378a;

    protected ck() {
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5378a = new bg(tVar);
    }

    @Override // org.xbill.DNS.bt
    String b() {
        return this.f5378a.toString();
    }

    protected bg d() {
        return this.f5378a;
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        this.f5378a.a(vVar, (n) null, z);
    }
}
