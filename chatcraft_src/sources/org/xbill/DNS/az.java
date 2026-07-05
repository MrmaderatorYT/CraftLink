package org.xbill.DNS;

/* compiled from: NSEC3PARAMRecord.java */
/* loaded from: classes.dex */
public class az extends bt {

    /* renamed from: a, reason: collision with root package name */
    private int f5333a;

    /* renamed from: b, reason: collision with root package name */
    private int f5334b;
    private int c;
    private byte[] d;

    az() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new az();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) throws WireParseException {
        this.f5333a = tVar.g();
        this.f5334b = tVar.g();
        this.c = tVar.h();
        int iG = tVar.g();
        if (iG > 0) {
            this.d = tVar.d(iG);
        } else {
            this.d = null;
        }
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.b(this.f5333a);
        vVar.b(this.f5334b);
        vVar.c(this.c);
        if (this.d != null) {
            vVar.b(this.d.length);
            vVar.a(this.d);
        } else {
            vVar.b(0);
        }
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5333a);
        stringBuffer.append(' ');
        stringBuffer.append(this.f5334b);
        stringBuffer.append(' ');
        stringBuffer.append(this.c);
        stringBuffer.append(' ');
        if (this.d == null) {
            stringBuffer.append('-');
        } else {
            stringBuffer.append(org.xbill.DNS.a.a.a(this.d));
        }
        return stringBuffer.toString();
    }
}
