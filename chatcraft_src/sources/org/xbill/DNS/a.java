package org.xbill.DNS;

import java.net.InetAddress;

/* compiled from: A6Record.java */
/* loaded from: classes.dex */
public class a extends bt {

    /* renamed from: a, reason: collision with root package name */
    private int f5299a;

    /* renamed from: b, reason: collision with root package name */
    private InetAddress f5300b;
    private bg c;

    a() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new a();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) throws WireParseException {
        this.f5299a = tVar.g();
        int i = ((128 - this.f5299a) + 7) / 8;
        if (this.f5299a < 128) {
            byte[] bArr = new byte[16];
            tVar.a(bArr, 16 - i, i);
            this.f5300b = InetAddress.getByAddress(bArr);
        }
        if (this.f5299a > 0) {
            this.c = new bg(tVar);
        }
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5299a);
        if (this.f5300b != null) {
            stringBuffer.append(" ");
            stringBuffer.append(this.f5300b.getHostAddress());
        }
        if (this.c != null) {
            stringBuffer.append(" ");
            stringBuffer.append(this.c);
        }
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.b(this.f5299a);
        if (this.f5300b != null) {
            int i = ((128 - this.f5299a) + 7) / 8;
            vVar.a(this.f5300b.getAddress(), 16 - i, i);
        }
        if (this.c != null) {
            this.c.a(vVar, (n) null, z);
        }
    }
}
