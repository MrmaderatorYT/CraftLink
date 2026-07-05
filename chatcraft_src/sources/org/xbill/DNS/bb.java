package org.xbill.DNS;

/* compiled from: NSECRecord.java */
/* loaded from: classes.dex */
public class bb extends bt {

    /* renamed from: a, reason: collision with root package name */
    private bg f5338a;

    /* renamed from: b, reason: collision with root package name */
    private cu f5339b;

    bb() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new bb();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5338a = new bg(tVar);
        this.f5339b = new cu(tVar);
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        this.f5338a.a(vVar, (n) null, false);
        this.f5339b.a(vVar);
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5338a);
        if (!this.f5339b.a()) {
            stringBuffer.append(' ');
            stringBuffer.append(this.f5339b.toString());
        }
        return stringBuffer.toString();
    }
}
