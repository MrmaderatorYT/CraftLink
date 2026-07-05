package org.xbill.DNS;

import java.util.Date;

/* compiled from: TKEYRecord.java */
/* loaded from: classes.dex */
public class cm extends bt {

    /* renamed from: a, reason: collision with root package name */
    private bg f5379a;

    /* renamed from: b, reason: collision with root package name */
    private Date f5380b;
    private Date c;
    private int d;
    private int e;
    private byte[] f;
    private byte[] k;

    cm() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new cm();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) throws WireParseException {
        this.f5379a = new bg(tVar);
        this.f5380b = new Date(tVar.i() * 1000);
        this.c = new Date(tVar.i() * 1000);
        this.d = tVar.h();
        this.e = tVar.h();
        int iH = tVar.h();
        if (iH > 0) {
            this.f = tVar.d(iH);
        } else {
            this.f = null;
        }
        int iH2 = tVar.h();
        if (iH2 > 0) {
            this.k = tVar.d(iH2);
        } else {
            this.k = null;
        }
    }

    protected String d() {
        switch (this.d) {
            case 1:
                return "SERVERASSIGNED";
            case 2:
                return "DIFFIEHELLMAN";
            case 3:
                return "GSSAPI";
            case 4:
                return "RESOLVERASSIGNED";
            case 5:
                return "DELETE";
            default:
                return Integer.toString(this.d);
        }
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5379a);
        stringBuffer.append(" ");
        if (bk.b("multiline")) {
            stringBuffer.append("(\n\t");
        }
        stringBuffer.append(ab.a(this.f5380b));
        stringBuffer.append(" ");
        stringBuffer.append(ab.a(this.c));
        stringBuffer.append(" ");
        stringBuffer.append(d());
        stringBuffer.append(" ");
        stringBuffer.append(bs.b(this.e));
        if (bk.b("multiline")) {
            stringBuffer.append("\n");
            if (this.f != null) {
                stringBuffer.append(org.xbill.DNS.a.c.a(this.f, 64, "\t", false));
                stringBuffer.append("\n");
            }
            if (this.k != null) {
                stringBuffer.append(org.xbill.DNS.a.c.a(this.k, 64, "\t", false));
            }
            stringBuffer.append(" )");
        } else {
            stringBuffer.append(" ");
            if (this.f != null) {
                stringBuffer.append(org.xbill.DNS.a.c.a(this.f));
                stringBuffer.append(" ");
            }
            if (this.k != null) {
                stringBuffer.append(org.xbill.DNS.a.c.a(this.k));
            }
        }
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        this.f5379a.a(vVar, (n) null, z);
        vVar.a(this.f5380b.getTime() / 1000);
        vVar.a(this.c.getTime() / 1000);
        vVar.c(this.d);
        vVar.c(this.e);
        if (this.f != null) {
            vVar.c(this.f.length);
            vVar.a(this.f);
        } else {
            vVar.c(0);
        }
        if (this.k != null) {
            vVar.c(this.k.length);
            vVar.a(this.k);
        } else {
            vVar.c(0);
        }
    }
}
