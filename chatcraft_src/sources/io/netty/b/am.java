package io.netty.b;

import java.nio.ByteBuffer;

/* compiled from: UnpooledUnsafeNoCleanerDirectByteBuf.java */
/* loaded from: classes.dex */
final class am extends ak {
    am(j jVar, int i, int i2) {
        super(jVar, i, i2);
    }

    @Override // io.netty.b.ak
    protected ByteBuffer D(int i) {
        return io.netty.util.a.l.a(i);
    }

    @Override // io.netty.b.ak
    protected void a(ByteBuffer byteBuffer) {
        io.netty.util.a.l.c(byteBuffer);
    }

    @Override // io.netty.b.ak, io.netty.b.i
    public i C(int i) {
        A();
        if (i < 0 || i > a()) {
            throw new IllegalArgumentException("newCapacity: " + i);
        }
        int iB = b();
        int iC = c();
        int iQ = Q();
        if (i > iQ) {
            a(io.netty.util.a.l.a(this.d, i), false);
        } else if (i < iQ) {
            ByteBuffer byteBuffer = this.d;
            ByteBuffer byteBufferD = D(i);
            if (iB < i) {
                if (iC > i) {
                    c(i);
                } else {
                    i = iC;
                }
                byteBuffer.position(iB).limit(i);
                byteBufferD.position(iB).limit(i);
                byteBufferD.put(byteBuffer);
                byteBufferD.clear();
            } else {
                a(i, i);
            }
            a(byteBufferD, true);
        }
        return this;
    }
}
