package org.xbill.DNS;

/* compiled from: GPOSRecord.java */
/* loaded from: classes.dex */
public class ac extends bt {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5307a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f5308b;
    private byte[] c;

    ac() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new ac();
    }

    private void a(double d, double d2) {
        if (d < -90.0d || d > 90.0d) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("illegal longitude ");
            stringBuffer.append(d);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        if (d2 < -180.0d || d2 > 180.0d) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("illegal latitude ");
            stringBuffer2.append(d2);
            throw new IllegalArgumentException(stringBuffer2.toString());
        }
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) throws WireParseException {
        this.f5308b = tVar.k();
        this.f5307a = tVar.k();
        this.c = tVar.k();
        try {
            a(d(), f());
        } catch (IllegalArgumentException e) {
            throw new WireParseException(e.getMessage());
        }
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a(this.f5308b, true));
        stringBuffer.append(" ");
        stringBuffer.append(a(this.f5307a, true));
        stringBuffer.append(" ");
        stringBuffer.append(a(this.c, true));
        return stringBuffer.toString();
    }

    public String O_() {
        return a(this.f5308b, false);
    }

    public double d() {
        return Double.parseDouble(O_());
    }

    public String e() {
        return a(this.f5307a, false);
    }

    public double f() {
        return Double.parseDouble(e());
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.b(this.f5308b);
        vVar.b(this.f5307a);
        vVar.b(this.c);
    }
}
