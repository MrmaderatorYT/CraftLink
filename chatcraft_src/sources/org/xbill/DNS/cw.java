package org.xbill.DNS;

import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.security.SecureRandom;

/* compiled from: UDPClient.java */
/* loaded from: classes.dex */
final class cw extends l {
    private static SecureRandom c = new SecureRandom();
    private static volatile boolean d = true;
    private boolean e;

    static boolean a(boolean z) {
        d = z;
        return z;
    }

    static SecureRandom b() {
        return c;
    }

    static {
        new Thread(new cx()).start();
    }

    public cw(long j) {
        super(DatagramChannel.open(), j);
        this.e = false;
    }

    private void a(InetSocketAddress inetSocketAddress) throws SocketException, InterruptedException {
        InetSocketAddress inetSocketAddress2;
        if (d) {
            try {
                Thread.sleep(2L);
            } catch (InterruptedException unused) {
            }
            if (d) {
                return;
            }
        }
        DatagramChannel datagramChannel = (DatagramChannel) this.f5423b.channel();
        for (int i = 0; i < 1024; i++) {
            try {
                int iNextInt = c.nextInt(64511) + 1024;
                if (inetSocketAddress != null) {
                    inetSocketAddress2 = new InetSocketAddress(inetSocketAddress.getAddress(), iNextInt);
                } else {
                    inetSocketAddress2 = new InetSocketAddress(iNextInt);
                }
                datagramChannel.socket().bind(inetSocketAddress2);
                this.e = true;
                return;
            } catch (SocketException unused2) {
            }
        }
    }

    void a(SocketAddress socketAddress) throws SocketException, InterruptedException {
        if (socketAddress == null || ((socketAddress instanceof InetSocketAddress) && ((InetSocketAddress) socketAddress).getPort() == 0)) {
            a((InetSocketAddress) socketAddress);
            if (this.e) {
                return;
            }
        }
        if (socketAddress != null) {
            ((DatagramChannel) this.f5423b.channel()).socket().bind(socketAddress);
            this.e = true;
        }
    }

    void b(SocketAddress socketAddress) throws InterruptedException, IOException {
        if (!this.e) {
            a((SocketAddress) null);
        }
        ((DatagramChannel) this.f5423b.channel()).connect(socketAddress);
    }

    void a(byte[] bArr) throws IOException {
        DatagramChannel datagramChannel = (DatagramChannel) this.f5423b.channel();
        a("UDP write", datagramChannel.socket().getLocalSocketAddress(), datagramChannel.socket().getRemoteSocketAddress(), bArr);
        datagramChannel.write(ByteBuffer.wrap(bArr));
    }

    byte[] a(int i) throws EOFException {
        DatagramChannel datagramChannel = (DatagramChannel) this.f5423b.channel();
        byte[] bArr = new byte[i];
        this.f5423b.interestOps(1);
        while (true) {
            try {
                if (this.f5423b.isReadable()) {
                    break;
                }
                a(this.f5423b, this.f5422a);
            } finally {
                if (this.f5423b.isValid()) {
                    this.f5423b.interestOps(0);
                }
            }
        }
        long j = datagramChannel.read(ByteBuffer.wrap(bArr));
        if (j <= 0) {
            throw new EOFException();
        }
        int i2 = (int) j;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        a("UDP read", datagramChannel.socket().getLocalSocketAddress(), datagramChannel.socket().getRemoteSocketAddress(), bArr2);
        return bArr2;
    }

    static byte[] a(SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr, int i, long j) {
        cw cwVar = new cw(j);
        try {
            cwVar.a(socketAddress);
            cwVar.b(socketAddress2);
            cwVar.a(bArr);
            return cwVar.a(i);
        } finally {
            cwVar.a();
        }
    }
}
