package io.netty.util.a;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: MacAddressUtil.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f4683a = {-1};

    /* renamed from: b, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4684b = io.netty.util.a.b.d.a((Class<?>) g.class);

    public static byte[] a() throws SocketException {
        int iA;
        byte[] bArr = f4683a;
        InetAddress inetAddress = io.netty.util.k.f4769a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                if (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress()) {
                        linkedHashMap.put(networkInterfaceNextElement, inetAddressNextElement);
                    }
                }
            }
        } catch (SocketException e) {
            f4684b.b("Failed to retrieve the list of available network interfaces", (Throwable) e);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            NetworkInterface networkInterface = (NetworkInterface) entry.getKey();
            InetAddress inetAddress2 = (InetAddress) entry.getValue();
            if (!networkInterface.isVirtual()) {
                try {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    int iA2 = a(bArr, hardwareAddress);
                    boolean z = true;
                    if (iA2 >= 0 && (iA2 != 0 || ((iA = a(inetAddress, inetAddress2)) >= 0 && (iA != 0 || bArr.length >= hardwareAddress.length)))) {
                        z = false;
                    }
                    if (z) {
                        inetAddress = inetAddress2;
                        bArr = hardwareAddress;
                    }
                } catch (SocketException e2) {
                    f4684b.b("Failed to get the hardware address of a network interface: {}", networkInterface, e2);
                }
            }
        }
        if (bArr == f4683a) {
            return null;
        }
        if (bArr.length == 6) {
            byte[] bArr2 = new byte[8];
            System.arraycopy(bArr, 0, bArr2, 0, 3);
            bArr2[3] = -1;
            bArr2[4] = -2;
            System.arraycopy(bArr, 3, bArr2, 5, 3);
            return bArr2;
        }
        return Arrays.copyOf(bArr, 8);
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(24);
        for (byte b2 : bArr) {
            sb.append(String.format("%02x:", Integer.valueOf(b2 & Constants.DimensionIds.NETHER)));
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static int a(byte[] bArr, byte[] bArr2) {
        boolean z;
        if (bArr2 == null || bArr2.length < 6) {
            return 1;
        }
        int length = bArr2.length;
        int i = 0;
        while (true) {
            if (i < length) {
                byte b2 = bArr2[i];
                if (b2 != 0 && b2 != 1) {
                    z = false;
                    break;
                }
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (!z && (bArr2[0] & 1) == 0) {
            return (bArr[0] & 2) == 0 ? (bArr2[0] & 2) == 0 ? 0 : 1 : (bArr2[0] & 2) == 0 ? -1 : 0;
        }
        return 1;
    }

    private static int a(InetAddress inetAddress, InetAddress inetAddress2) {
        return a(inetAddress) - a(inetAddress2);
    }

    private static int a(InetAddress inetAddress) {
        if (inetAddress.isAnyLocalAddress() || inetAddress.isLoopbackAddress()) {
            return 0;
        }
        if (inetAddress.isMulticastAddress()) {
            return 1;
        }
        if (inetAddress.isLinkLocalAddress()) {
            return 2;
        }
        return inetAddress.isSiteLocalAddress() ? 3 : 4;
    }

    private g() {
    }
}
