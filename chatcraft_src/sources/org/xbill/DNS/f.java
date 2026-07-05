package org.xbill.DNS;

import com.github.steveice10.mc.v1_5.util.Constants;

/* compiled from: ARecord.java */
/* loaded from: classes.dex */
public class f extends bt {

    /* renamed from: a, reason: collision with root package name */
    private int f5410a;

    f() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new f();
    }

    private static final int b(byte[] bArr) {
        return (bArr[3] & Constants.DimensionIds.NETHER) | ((bArr[0] & Constants.DimensionIds.NETHER) << 24) | ((bArr[1] & Constants.DimensionIds.NETHER) << 16) | ((bArr[2] & Constants.DimensionIds.NETHER) << 8);
    }

    private static final byte[] b(int i) {
        return new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)};
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5410a = b(tVar.d(4));
    }

    @Override // org.xbill.DNS.bt
    String b() {
        return g.a(b(this.f5410a));
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.a(this.f5410a & 4294967295L);
    }
}
