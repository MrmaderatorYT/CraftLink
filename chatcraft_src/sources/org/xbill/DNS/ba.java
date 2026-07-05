package org.xbill.DNS;

/* compiled from: NSEC3Record.java */
/* loaded from: classes.dex */
public class ba extends bt {
    private static final org.xbill.DNS.a.b k = new org.xbill.DNS.a.b("0123456789ABCDEFGHIJKLMNOPQRSTUV=", false, false);

    /* renamed from: a, reason: collision with root package name */
    private int f5336a;

    /* renamed from: b, reason: collision with root package name */
    private int f5337b;
    private int c;
    private byte[] d;
    private byte[] e;
    private cu f;

    ba() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new ba();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) throws WireParseException {
        this.f5336a = tVar.g();
        this.f5337b = tVar.g();
        this.c = tVar.h();
        int iG = tVar.g();
        if (iG > 0) {
            this.d = tVar.d(iG);
        } else {
            this.d = null;
        }
        this.e = tVar.d(tVar.g());
        this.f = new cu(tVar);
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.b(this.f5336a);
        vVar.b(this.f5337b);
        vVar.c(this.c);
        if (this.d != null) {
            vVar.b(this.d.length);
            vVar.a(this.d);
        } else {
            vVar.b(0);
        }
        vVar.b(this.e.length);
        vVar.a(this.e);
        this.f.a(vVar);
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5336a);
        stringBuffer.append(' ');
        stringBuffer.append(this.f5337b);
        stringBuffer.append(' ');
        stringBuffer.append(this.c);
        stringBuffer.append(' ');
        if (this.d == null) {
            stringBuffer.append('-');
        } else {
            stringBuffer.append(org.xbill.DNS.a.a.a(this.d));
        }
        stringBuffer.append(' ');
        stringBuffer.append(k.a(this.e));
        if (!this.f.a()) {
            stringBuffer.append(' ');
            stringBuffer.append(this.f.toString());
        }
        return stringBuffer.toString();
    }
}
