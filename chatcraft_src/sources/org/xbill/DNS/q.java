package org.xbill.DNS;

/* compiled from: DHCIDRecord.java */
/* loaded from: classes.dex */
public class q extends bt {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5431a;

    q() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new q();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5431a = tVar.j();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.a(this.f5431a);
    }

    @Override // org.xbill.DNS.bt
    String b() {
        return org.xbill.DNS.a.c.a(this.f5431a);
    }
}
