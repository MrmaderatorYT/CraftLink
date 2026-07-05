package io.netty.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* compiled from: UnpooledUnsafeDirectByteBuf.java */
/* loaded from: classes.dex */
public class ak extends d {
    ByteBuffer d;
    long e;
    private final j f;
    private ByteBuffer g;
    private int h;
    private boolean i;

    @Override // io.netty.b.i
    public i A_() {
        return null;
    }

    @Override // io.netty.b.i
    public boolean H() {
        return true;
    }

    @Override // io.netty.b.i
    public boolean I() {
        return false;
    }

    @Override // io.netty.b.i
    public boolean L() {
        return true;
    }

    @Override // io.netty.b.i
    public int N() {
        return 1;
    }

    protected ak(j jVar, int i, int i2) {
        super(i2);
        if (jVar == null) {
            throw new NullPointerException("alloc");
        }
        if (i < 0) {
            throw new IllegalArgumentException("initialCapacity: " + i);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("maxCapacity: " + i2);
        }
        if (i > i2) {
            throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        this.f = jVar;
        a(D(i), false);
    }

    protected ByteBuffer D(int i) {
        return ByteBuffer.allocateDirect(i);
    }

    protected void a(ByteBuffer byteBuffer) {
        io.netty.util.a.l.a(byteBuffer);
    }

    final void a(ByteBuffer byteBuffer, boolean z) {
        ByteBuffer byteBuffer2;
        if (z && (byteBuffer2 = this.d) != null) {
            if (this.i) {
                this.i = false;
            } else {
                a(byteBuffer2);
            }
        }
        this.d = byteBuffer;
        this.e = io.netty.util.a.l.b(byteBuffer);
        this.g = null;
        this.h = byteBuffer.remaining();
    }

    @Override // io.netty.b.i
    public int Q() {
        return this.h;
    }

    @Override // io.netty.b.i
    public i C(int i) {
        A();
        if (i < 0 || i > a()) {
            throw new IllegalArgumentException("newCapacity: " + i);
        }
        int iB = b();
        int iC = c();
        int i2 = this.h;
        if (i > i2) {
            ByteBuffer byteBuffer = this.d;
            ByteBuffer byteBufferD = D(i);
            byteBuffer.position(0).limit(byteBuffer.capacity());
            byteBufferD.position(0).limit(byteBuffer.capacity());
            byteBufferD.put(byteBuffer);
            byteBufferD.clear();
            a(byteBufferD, true);
        } else if (i < i2) {
            ByteBuffer byteBuffer2 = this.d;
            ByteBuffer byteBufferD2 = D(i);
            if (iB < i) {
                if (iC > i) {
                    c(i);
                } else {
                    i = iC;
                }
                byteBuffer2.position(iB).limit(i);
                byteBufferD2.position(iB).limit(i);
                byteBufferD2.put(byteBuffer2);
                byteBufferD2.clear();
            } else {
                a(i, i);
            }
            a(byteBufferD2, true);
        }
        return this;
    }

    @Override // io.netty.b.i
    public j F() {
        return this.f;
    }

    @Override // io.netty.b.i
    public ByteOrder G() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override // io.netty.b.i
    public byte[] J() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.b.i
    public int K() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.b.i
    public long M() {
        A();
        return this.e;
    }

    @Override // io.netty.b.a
    protected byte g(int i) {
        return an.a(E(i));
    }

    @Override // io.netty.b.a
    protected short j(int i) {
        return an.b(E(i));
    }

    @Override // io.netty.b.a
    protected short l(int i) {
        return an.c(E(i));
    }

    @Override // io.netty.b.a
    protected int n(int i) {
        return an.d(E(i));
    }

    @Override // io.netty.b.a
    protected int p(int i) {
        return an.e(E(i));
    }

    @Override // io.netty.b.a
    protected long t(int i) {
        return an.f(E(i));
    }

    @Override // io.netty.b.i
    public i a(int i, i iVar, int i2, int i3) {
        an.a(this, E(i), i, iVar, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, byte[] bArr, int i2, int i3) {
        an.a(this, E(i), i, bArr, i2, i3);
        return this;
    }

    @Override // io.netty.b.a
    protected void c(int i, int i2) {
        an.a(E(i), i2);
    }

    @Override // io.netty.b.a
    protected void e(int i, int i2) {
        an.b(E(i), i2);
    }

    @Override // io.netty.b.a
    protected void g(int i, int i2) {
        an.c(E(i), i2);
    }

    @Override // io.netty.b.a
    protected void b(int i, long j) {
        an.a(E(i), j);
    }

    @Override // io.netty.b.i
    public i b(int i, i iVar, int i2, int i3) {
        an.b(this, E(i), i, iVar, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public i b(int i, byte[] bArr, int i2, int i3) {
        an.b(this, E(i), i, bArr, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, OutputStream outputStream, int i2) {
        an.a(this, E(i), i, outputStream, i2);
        return this;
    }

    @Override // io.netty.b.i
    public int a(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        return a(i, gatheringByteChannel, i2, false);
    }

    private int a(int i, GatheringByteChannel gatheringByteChannel, int i2, boolean z) {
        ByteBuffer byteBufferDuplicate;
        A();
        if (i2 == 0) {
            return 0;
        }
        if (z) {
            byteBufferDuplicate = O();
        } else {
            byteBufferDuplicate = this.d.duplicate();
        }
        byteBufferDuplicate.clear().position(i).limit(i + i2);
        return gatheringByteChannel.write(byteBufferDuplicate);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public int a(GatheringByteChannel gatheringByteChannel, int i) {
        A(i);
        int iA = a(this.f4368b, gatheringByteChannel, i, true);
        this.f4368b += iA;
        return iA;
    }

    @Override // io.netty.b.i
    public int a(int i, InputStream inputStream, int i2) {
        return an.a(this, E(i), i, inputStream, i2);
    }

    @Override // io.netty.b.i
    public int a(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        A();
        ByteBuffer byteBufferO = O();
        byteBufferO.clear().position(i).limit(i + i2);
        try {
            return scatteringByteChannel.read(byteBufferO);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.b.i
    public ByteBuffer[] n(int i, int i2) {
        return new ByteBuffer[]{m(i, i2)};
    }

    @Override // io.netty.b.i
    public ByteBuffer l(int i, int i2) {
        i(i, i2);
        return (ByteBuffer) O().clear().position(i).limit(i + i2);
    }

    private ByteBuffer O() {
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer != null) {
            return byteBuffer;
        }
        ByteBuffer byteBufferDuplicate = this.d.duplicate();
        this.g = byteBufferDuplicate;
        return byteBufferDuplicate;
    }

    @Override // io.netty.b.i
    public ByteBuffer m(int i, int i2) {
        i(i, i2);
        return ((ByteBuffer) this.d.duplicate().position(i).limit(i + i2)).slice();
    }

    @Override // io.netty.b.d
    protected void E() {
        ByteBuffer byteBuffer = this.d;
        if (byteBuffer == null) {
            return;
        }
        this.d = null;
        if (this.i) {
            return;
        }
        a(byteBuffer);
    }

    long E(int i) {
        return this.e + i;
    }

    @Override // io.netty.b.a
    protected ae m() {
        if (io.netty.util.a.l.g()) {
            return new ao(this);
        }
        return super.m();
    }
}
