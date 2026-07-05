package org.xbill.DNS;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: ClientSubnetOption.java */
/* loaded from: classes.dex */
public class m extends x {

    /* renamed from: a, reason: collision with root package name */
    private int f5424a;

    /* renamed from: b, reason: collision with root package name */
    private int f5425b;
    private int c;
    private InetAddress d;

    m() {
        super(8);
    }

    @Override // org.xbill.DNS.x
    void a(t tVar) throws WireParseException {
        this.f5424a = tVar.h();
        if (this.f5424a != 1 && this.f5424a != 2) {
            throw new WireParseException("unknown address family");
        }
        this.f5425b = tVar.g();
        if (this.f5425b > g.a(this.f5424a) * 8) {
            throw new WireParseException("invalid source netmask");
        }
        this.c = tVar.g();
        if (this.c > g.a(this.f5424a) * 8) {
            throw new WireParseException("invalid scope netmask");
        }
        byte[] bArrJ = tVar.j();
        if (bArrJ.length != (this.f5425b + 7) / 8) {
            throw new WireParseException("invalid address");
        }
        byte[] bArr = new byte[g.a(this.f5424a)];
        System.arraycopy(bArrJ, 0, bArr, 0, bArrJ.length);
        try {
            this.d = InetAddress.getByAddress(bArr);
            if (!g.a(this.d, this.f5425b).equals(this.d)) {
                throw new WireParseException("invalid padding");
            }
        } catch (UnknownHostException e) {
            throw new WireParseException("invalid address", e);
        }
    }

    @Override // org.xbill.DNS.x
    void a(v vVar) {
        vVar.c(this.f5424a);
        vVar.b(this.f5425b);
        vVar.b(this.c);
        vVar.a(this.d.getAddress(), 0, (this.f5425b + 7) / 8);
    }

    @Override // org.xbill.DNS.x
    String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.d.getHostAddress());
        stringBuffer.append("/");
        stringBuffer.append(this.f5425b);
        stringBuffer.append(", scope netmask ");
        stringBuffer.append(this.c);
        return stringBuffer.toString();
    }
}
