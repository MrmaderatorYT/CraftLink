package org.xbill.DNS;

import java.util.BitSet;

/* compiled from: NXTRecord.java */
/* loaded from: classes.dex */
public class bf extends bt {

    /* renamed from: a, reason: collision with root package name */
    private bg f5341a;

    /* renamed from: b, reason: collision with root package name */
    private BitSet f5342b;

    bf() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new bf();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) throws WireParseException {
        this.f5341a = new bg(tVar);
        this.f5342b = new BitSet();
        int iB = tVar.b();
        for (int i = 0; i < iB; i++) {
            int iG = tVar.g();
            for (int i2 = 0; i2 < 8; i2++) {
                if (((1 << (7 - i2)) & iG) != 0) {
                    this.f5342b.set((i * 8) + i2);
                }
            }
        }
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5341a);
        int length = this.f5342b.length();
        for (short s = 0; s < length; s = (short) (s + 1)) {
            if (this.f5342b.get(s)) {
                stringBuffer.append(" ");
                stringBuffer.append(ct.b(s));
            }
        }
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        this.f5341a.a(vVar, (n) null, z);
        int length = this.f5342b.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i |= this.f5342b.get(i2) ? 1 << (7 - (i2 % 8)) : 0;
            if (i2 % 8 == 7 || i2 == length - 1) {
                vVar.b(i);
                i = 0;
            }
        }
    }
}
