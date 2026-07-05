package org.xbill.DNS;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.security.PublicKey;

/* compiled from: KEYBase.java */
/* loaded from: classes.dex */
abstract class ai extends bt {

    /* renamed from: a, reason: collision with root package name */
    protected int f5318a;

    /* renamed from: b, reason: collision with root package name */
    protected int f5319b;
    protected int c;
    protected byte[] d;
    protected int e = -1;
    protected PublicKey f = null;

    protected ai() {
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5318a = tVar.h();
        this.f5319b = tVar.g();
        this.c = tVar.g();
        if (tVar.b() > 0) {
            this.d = tVar.j();
        }
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5318a);
        stringBuffer.append(" ");
        stringBuffer.append(this.f5319b);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        if (this.d != null) {
            if (bk.b("multiline")) {
                stringBuffer.append(" (\n");
                stringBuffer.append(org.xbill.DNS.a.c.a(this.d, 64, "\t", true));
                stringBuffer.append(" ; key_tag = ");
                stringBuffer.append(N_());
            } else {
                stringBuffer.append(" ");
                stringBuffer.append(org.xbill.DNS.a.c.a(this.d));
            }
        }
        return stringBuffer.toString();
    }

    public int N_() {
        int i;
        if (this.e >= 0) {
            return this.e;
        }
        v vVar = new v();
        int i2 = 0;
        a(vVar, (n) null, false);
        byte[] bArrB = vVar.b();
        if (this.c == 1) {
            i = ((bArrB[bArrB.length - 3] & Constants.DimensionIds.NETHER) << 8) + (bArrB[bArrB.length - 2] & Constants.DimensionIds.NETHER);
        } else {
            int i3 = 0;
            while (i2 < bArrB.length - 1) {
                i3 += ((bArrB[i2] & Constants.DimensionIds.NETHER) << 8) + (bArrB[i2 + 1] & Constants.DimensionIds.NETHER);
                i2 += 2;
            }
            if (i2 < bArrB.length) {
                i3 += (bArrB[i2] & Constants.DimensionIds.NETHER) << 8;
            }
            i = i3 + ((i3 >> 16) & 65535);
        }
        this.e = i & 65535;
        return this.e;
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.c(this.f5318a);
        vVar.b(this.f5319b);
        vVar.b(this.c);
        if (this.d != null) {
            vVar.a(this.d);
        }
    }
}
