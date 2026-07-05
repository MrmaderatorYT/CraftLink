package org.xbill.DNS;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: Address.java */
/* loaded from: classes.dex */
public final class g {
    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bArr[0] & Constants.DimensionIds.NETHER);
        stringBuffer.append(".");
        stringBuffer.append(bArr[1] & Constants.DimensionIds.NETHER);
        stringBuffer.append(".");
        stringBuffer.append(bArr[2] & Constants.DimensionIds.NETHER);
        stringBuffer.append(".");
        stringBuffer.append(bArr[3] & Constants.DimensionIds.NETHER);
        return stringBuffer.toString();
    }

    public static int a(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return 1;
        }
        if (inetAddress instanceof Inet6Address) {
            return 2;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static int a(int i) {
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 16;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static InetAddress a(InetAddress inetAddress, int i) {
        int i2;
        int iA = a(a(inetAddress)) * 8;
        if (i < 0 || i > iA) {
            throw new IllegalArgumentException("invalid mask length");
        }
        if (i == iA) {
            return inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i3 = i / 8;
        int i4 = i3 + 1;
        while (true) {
            if (i4 >= address.length) {
                break;
            }
            address[i4] = 0;
            i4++;
        }
        int i5 = 0;
        for (i2 = 0; i2 < i % 8; i2++) {
            i5 |= 1 << (7 - i2);
        }
        address[i3] = (byte) (address[i3] & i5);
        try {
            return InetAddress.getByAddress(address);
        } catch (UnknownHostException unused) {
            throw new IllegalArgumentException("invalid address");
        }
    }
}
