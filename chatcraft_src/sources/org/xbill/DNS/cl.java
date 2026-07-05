package org.xbill.DNS;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/* compiled from: TCPClient.java */
/* loaded from: classes.dex */
final class cl extends l {
    public cl(long j) {
        super(SocketChannel.open(), j);
    }

    void a(SocketAddress socketAddress) throws IOException {
        ((SocketChannel) this.f5423b.channel()).socket().bind(socketAddress);
    }

    void b(SocketAddress socketAddress) {
        SocketChannel socketChannel = (SocketChannel) this.f5423b.channel();
        if (socketChannel.connect(socketAddress)) {
            return;
        }
        this.f5423b.interestOps(8);
        while (true) {
            try {
                if (socketChannel.finishConnect()) {
                    break;
                } else if (!this.f5423b.isConnectable()) {
                    a(this.f5423b, this.f5422a);
                }
            } finally {
                if (this.f5423b.isValid()) {
                    this.f5423b.interestOps(0);
                }
            }
        }
    }

    void a(byte[] bArr) {
        SocketChannel socketChannel = (SocketChannel) this.f5423b.channel();
        a("TCP write", socketChannel.socket().getLocalSocketAddress(), socketChannel.socket().getRemoteSocketAddress(), bArr);
        ByteBuffer[] byteBufferArr = {ByteBuffer.wrap(new byte[]{(byte) (bArr.length >>> 8), (byte) (bArr.length & 255)}), ByteBuffer.wrap(bArr)};
        this.f5423b.interestOps(4);
        int i = 0;
        while (i < bArr.length + 2) {
            try {
                if (this.f5423b.isWritable()) {
                    long jWrite = socketChannel.write(byteBufferArr);
                    if (jWrite < 0) {
                        throw new EOFException();
                    }
                    i += (int) jWrite;
                    if (i < bArr.length + 2 && System.currentTimeMillis() > this.f5422a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(this.f5423b, this.f5422a);
                }
            } finally {
                if (this.f5423b.isValid()) {
                    this.f5423b.interestOps(0);
                }
            }
        }
    }

    private byte[] a(int i) {
        SocketChannel socketChannel = (SocketChannel) this.f5423b.channel();
        byte[] bArr = new byte[i];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.f5423b.interestOps(1);
        int i2 = 0;
        while (i2 < i) {
            try {
                if (this.f5423b.isReadable()) {
                    long j = socketChannel.read(byteBufferWrap);
                    if (j < 0) {
                        throw new EOFException();
                    }
                    i2 += (int) j;
                    if (i2 < i && System.currentTimeMillis() > this.f5422a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(this.f5423b, this.f5422a);
                }
            } finally {
                if (this.f5423b.isValid()) {
                    this.f5423b.interestOps(0);
                }
            }
        }
        return bArr;
    }

    byte[] b() {
        byte[] bArrA = a(2);
        byte[] bArrA2 = a(((bArrA[0] & Constants.DimensionIds.NETHER) << 8) + (bArrA[1] & Constants.DimensionIds.NETHER));
        SocketChannel socketChannel = (SocketChannel) this.f5423b.channel();
        a("TCP read", socketChannel.socket().getLocalSocketAddress(), socketChannel.socket().getRemoteSocketAddress(), bArrA2);
        return bArrA2;
    }

    static byte[] a(SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr, long j) {
        cl clVar = new cl(j);
        if (socketAddress != null) {
            try {
                clVar.a(socketAddress);
            } catch (Throwable th) {
                clVar.a();
                throw th;
            }
        }
        clVar.b(socketAddress2);
        clVar.a(bArr);
        byte[] bArrB = clVar.b();
        clVar.a();
        return bArrB;
    }
}
