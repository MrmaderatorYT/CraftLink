package org.xbill.DNS;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/* compiled from: LOCRecord.java */
/* loaded from: classes.dex */
public class al extends bt {

    /* renamed from: a, reason: collision with root package name */
    private static NumberFormat f5320a = new DecimalFormat();

    /* renamed from: b, reason: collision with root package name */
    private static NumberFormat f5321b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long k;
    private long l;

    static {
        f5320a.setMinimumIntegerDigits(2);
        f5321b = new DecimalFormat();
        f5321b.setMinimumIntegerDigits(3);
    }

    al() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new al();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) throws WireParseException {
        if (tVar.g() != 0) {
            throw new WireParseException("Invalid LOC version");
        }
        this.c = b(tVar.g());
        this.d = b(tVar.g());
        this.e = b(tVar.g());
        this.f = tVar.i();
        this.k = tVar.i();
        this.l = tVar.i();
    }

    private void a(StringBuffer stringBuffer, NumberFormat numberFormat, long j, long j2) {
        stringBuffer.append(j / j2);
        long j3 = j % j2;
        if (j3 != 0) {
            stringBuffer.append(".");
            stringBuffer.append(numberFormat.format(j3));
        }
    }

    private String a(long j, char c, char c2) {
        StringBuffer stringBuffer = new StringBuffer();
        long j2 = j - 2147483648L;
        if (j2 < 0) {
            j2 = -j2;
            c = c2;
        }
        stringBuffer.append(j2 / 3600000);
        long j3 = j2 % 3600000;
        stringBuffer.append(" ");
        stringBuffer.append(j3 / 60000);
        stringBuffer.append(" ");
        a(stringBuffer, f5321b, j3 % 60000, 1000L);
        stringBuffer.append(" ");
        stringBuffer.append(c);
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a(this.f, 'N', 'S'));
        stringBuffer.append(" ");
        stringBuffer.append(a(this.k, 'E', 'W'));
        stringBuffer.append(" ");
        a(stringBuffer, f5320a, this.l - 10000000, 100L);
        stringBuffer.append("m ");
        a(stringBuffer, f5320a, this.c, 100L);
        stringBuffer.append("m ");
        a(stringBuffer, f5320a, this.d, 100L);
        stringBuffer.append("m ");
        a(stringBuffer, f5320a, this.e, 100L);
        stringBuffer.append("m");
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.b(0);
        vVar.b(b(this.c));
        vVar.b(b(this.d));
        vVar.b(b(this.e));
        vVar.a(this.f);
        vVar.a(this.k);
        vVar.a(this.l);
    }

    private static long b(int i) throws WireParseException {
        long j = i >> 4;
        int i2 = i & 15;
        if (j > 9 || i2 > 9) {
            throw new WireParseException("Invalid LOC Encoding");
        }
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return j;
            }
            j *= 10;
            i2 = i3;
        }
    }

    private int b(long j) {
        byte b2 = 0;
        while (j > 9) {
            b2 = (byte) (b2 + 1);
            j /= 10;
        }
        return (int) ((j << 4) + b2);
    }
}
