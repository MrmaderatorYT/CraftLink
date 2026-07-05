package org.xbill.DNS;

/* compiled from: UNKRecord.java */
/* loaded from: classes.dex */
public class cy extends bt {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5395a;

    cy() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new cy();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5395a = tVar.j();
    }

    @Override // org.xbill.DNS.bt
    String b() {
        return a(this.f5395a);
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.a(this.f5395a);
    }
}
