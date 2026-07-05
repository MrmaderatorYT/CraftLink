package org.xbill.DNS;

/* compiled from: ISDNRecord.java */
/* loaded from: classes.dex */
public class ah extends bt {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5316a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f5317b;

    ah() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new ah();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5316a = tVar.k();
        if (tVar.b() > 0) {
            this.f5317b = tVar.k();
        }
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.b(this.f5316a);
        if (this.f5317b != null) {
            vVar.b(this.f5317b);
        }
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a(this.f5316a, true));
        if (this.f5317b != null) {
            stringBuffer.append(" ");
            stringBuffer.append(a(this.f5317b, true));
        }
        return stringBuffer.toString();
    }
}
