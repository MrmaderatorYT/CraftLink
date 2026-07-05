package org.xbill.DNS;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: AAAARecord.java */
/* loaded from: classes.dex */
public class b extends bt {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5335a;

    b() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new b();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5335a = tVar.d(16);
    }

    @Override // org.xbill.DNS.bt
    String b() throws UnknownHostException {
        try {
            InetAddress byAddress = InetAddress.getByAddress(null, this.f5335a);
            if (byAddress.getAddress().length == 4) {
                StringBuffer stringBuffer = new StringBuffer("0:0:0:0:0:ffff:");
                int i = ((this.f5335a[12] & Constants.DimensionIds.NETHER) << 8) + (this.f5335a[13] & Constants.DimensionIds.NETHER);
                int i2 = ((this.f5335a[14] & Constants.DimensionIds.NETHER) << 8) + (this.f5335a[15] & Constants.DimensionIds.NETHER);
                stringBuffer.append(Integer.toHexString(i));
                stringBuffer.append(':');
                stringBuffer.append(Integer.toHexString(i2));
                return stringBuffer.toString();
            }
            return byAddress.getHostAddress();
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.a(this.f5335a);
    }
}
