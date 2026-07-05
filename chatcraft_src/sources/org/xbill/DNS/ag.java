package org.xbill.DNS;

import java.net.InetAddress;

/* compiled from: IPSECKEYRecord.java */
/* loaded from: classes.dex */
public class ag extends bt {

    /* renamed from: a, reason: collision with root package name */
    private int f5314a;

    /* renamed from: b, reason: collision with root package name */
    private int f5315b;
    private int c;
    private Object d;
    private byte[] e;

    ag() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new ag();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) throws WireParseException {
        this.f5314a = tVar.g();
        this.f5315b = tVar.g();
        this.c = tVar.g();
        switch (this.f5315b) {
            case 0:
                this.d = null;
                break;
            case 1:
                this.d = InetAddress.getByAddress(tVar.d(4));
                break;
            case 2:
                this.d = InetAddress.getByAddress(tVar.d(16));
                break;
            case 3:
                this.d = new bg(tVar);
                break;
            default:
                throw new WireParseException("invalid gateway type");
        }
        if (tVar.b() > 0) {
            this.e = tVar.j();
        }
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5314a);
        stringBuffer.append(" ");
        stringBuffer.append(this.f5315b);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        stringBuffer.append(" ");
        switch (this.f5315b) {
            case 0:
                stringBuffer.append(".");
                break;
            case 1:
            case 2:
                stringBuffer.append(((InetAddress) this.d).getHostAddress());
                break;
            case 3:
                stringBuffer.append(this.d);
                break;
        }
        if (this.e != null) {
            stringBuffer.append(" ");
            stringBuffer.append(org.xbill.DNS.a.c.a(this.e));
        }
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.b(this.f5314a);
        vVar.b(this.f5315b);
        vVar.b(this.c);
        switch (this.f5315b) {
            case 1:
            case 2:
                vVar.a(((InetAddress) this.d).getAddress());
                break;
            case 3:
                ((bg) this.d).a(vVar, (n) null, z);
                break;
        }
        if (this.e != null) {
            vVar.a(this.e);
        }
    }
}
