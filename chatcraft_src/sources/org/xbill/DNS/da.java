package org.xbill.DNS;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.util.ArrayList;

/* compiled from: WKSRecord.java */
/* loaded from: classes.dex */
public class da extends bt {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5401a;

    /* renamed from: b, reason: collision with root package name */
    private int f5402b;
    private int[] c;

    da() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new da();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5401a = tVar.d(4);
        this.f5402b = tVar.g();
        byte[] bArrJ = tVar.j();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bArrJ.length; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                if ((bArrJ[i] & Constants.DimensionIds.NETHER & (1 << (7 - i2))) != 0) {
                    arrayList.add(new Integer((i * 8) + i2));
                }
            }
        }
        this.c = new int[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.c[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(g.a(this.f5401a));
        stringBuffer.append(" ");
        stringBuffer.append(this.f5402b);
        for (int i = 0; i < this.c.length; i++) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(" ");
            stringBuffer2.append(this.c[i]);
            stringBuffer.append(stringBuffer2.toString());
        }
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.a(this.f5401a);
        vVar.b(this.f5402b);
        byte[] bArr = new byte[(this.c[this.c.length - 1] / 8) + 1];
        for (int i = 0; i < this.c.length; i++) {
            int i2 = this.c[i];
            int i3 = i2 / 8;
            bArr[i3] = (byte) ((1 << (7 - (i2 % 8))) | bArr[i3]);
        }
        vVar.a(bArr);
    }
}
