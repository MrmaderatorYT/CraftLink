package org.xbill.DNS;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.util.Date;

/* compiled from: TSIGRecord.java */
/* loaded from: classes.dex */
public class cp extends bt {

    /* renamed from: a, reason: collision with root package name */
    private bg f5387a;

    /* renamed from: b, reason: collision with root package name */
    private Date f5388b;
    private int c;
    private byte[] d;
    private int e;
    private int f;
    private byte[] k;

    cp() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new cp();
    }

    public cp(bg bgVar, int i, long j, bg bgVar2, Date date, int i2, byte[] bArr, int i3, int i4, byte[] bArr2) {
        super(bgVar, 250, i, j);
        this.f5387a = a("alg", bgVar2);
        this.f5388b = date;
        this.c = a("fudge", i2);
        this.d = bArr;
        this.e = a("originalID", i3);
        this.f = a("error", i4);
        this.k = bArr2;
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) throws WireParseException {
        this.f5387a = new bg(tVar);
        this.f5388b = new Date(((tVar.h() << 32) + tVar.i()) * 1000);
        this.c = tVar.h();
        this.d = tVar.d(tVar.h());
        this.e = tVar.h();
        this.f = tVar.h();
        int iH = tVar.h();
        if (iH > 0) {
            this.k = tVar.d(iH);
        } else {
            this.k = null;
        }
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5387a);
        stringBuffer.append(" ");
        if (bk.b("multiline")) {
            stringBuffer.append("(\n\t");
        }
        stringBuffer.append(this.f5388b.getTime() / 1000);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        stringBuffer.append(" ");
        stringBuffer.append(this.d.length);
        if (bk.b("multiline")) {
            stringBuffer.append("\n");
            stringBuffer.append(org.xbill.DNS.a.c.a(this.d, 64, "\t", false));
        } else {
            stringBuffer.append(" ");
            stringBuffer.append(org.xbill.DNS.a.c.a(this.d));
        }
        stringBuffer.append(" ");
        stringBuffer.append(bs.b(this.f));
        stringBuffer.append(" ");
        if (this.k == null) {
            stringBuffer.append(0);
        } else {
            stringBuffer.append(this.k.length);
            if (bk.b("multiline")) {
                stringBuffer.append("\n\n\n\t");
            } else {
                stringBuffer.append(" ");
            }
            if (this.f == 18) {
                if (this.k.length != 6) {
                    stringBuffer.append("<invalid BADTIME other data>");
                } else {
                    stringBuffer.append("<server time: ");
                    stringBuffer.append(new Date((((this.k[0] & Constants.DimensionIds.NETHER) << 40) + ((this.k[1] & Constants.DimensionIds.NETHER) << 32) + ((this.k[2] & Constants.DimensionIds.NETHER) << 24) + ((this.k[3] & Constants.DimensionIds.NETHER) << 16) + ((this.k[4] & Constants.DimensionIds.NETHER) << 8) + (this.k[5] & Constants.DimensionIds.NETHER)) * 1000));
                    stringBuffer.append(">");
                }
            } else {
                stringBuffer.append("<");
                stringBuffer.append(org.xbill.DNS.a.c.a(this.k));
                stringBuffer.append(">");
            }
        }
        if (bk.b("multiline")) {
            stringBuffer.append(" )");
        }
        return stringBuffer.toString();
    }

    public bg d() {
        return this.f5387a;
    }

    public Date e() {
        return this.f5388b;
    }

    public int f() {
        return this.c;
    }

    public byte[] g() {
        return this.d;
    }

    public int p() {
        return this.f;
    }

    public byte[] q() {
        return this.k;
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        this.f5387a.a(vVar, (n) null, z);
        long time = this.f5388b.getTime() / 1000;
        vVar.c((int) (time >> 32));
        vVar.a(time & 4294967295L);
        vVar.c(this.c);
        vVar.c(this.d.length);
        vVar.a(this.d);
        vVar.c(this.e);
        vVar.c(this.f);
        if (this.k != null) {
            vVar.c(this.k.length);
            vVar.a(this.k);
        } else {
            vVar.c(0);
        }
    }
}
