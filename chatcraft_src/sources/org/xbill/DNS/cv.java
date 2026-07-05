package org.xbill.DNS;

/* compiled from: U16NameBase.java */
/* loaded from: classes.dex */
abstract class cv extends bt {

    /* renamed from: a, reason: collision with root package name */
    protected int f5393a;

    /* renamed from: b, reason: collision with root package name */
    protected bg f5394b;

    protected cv() {
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5393a = tVar.h();
        this.f5394b = new bg(tVar);
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5393a);
        stringBuffer.append(" ");
        stringBuffer.append(this.f5394b);
        return stringBuffer.toString();
    }

    protected bg d() {
        return this.f5394b;
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.c(this.f5393a);
        this.f5394b.a(vVar, (n) null, z);
    }
}
