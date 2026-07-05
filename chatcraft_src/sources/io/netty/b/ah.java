package io.netty.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* compiled from: UnpooledDirectByteBuf.java */
/* loaded from: classes.dex */
public class ah extends d {
    private final j d;
    private ByteBuffer e;
    private ByteBuffer f;
    private int g;
    private boolean h;

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
        return false;
    }

    @Override // io.netty.b.i
    public int N() {
        return 1;
    }

    protected ah(j jVar, int i, int i2) {
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
        this.d = jVar;
        b(ByteBuffer.allocateDirect(i));
    }

    protected ByteBuffer D(int i) {
        return ByteBuffer.allocateDirect(i);
    }

    protected void a(ByteBuffer byteBuffer) {
        io.netty.util.a.l.a(byteBuffer);
    }

    private void b(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = this.e;
        if (byteBuffer2 != null) {
            if (this.h) {
                this.h = false;
            } else {
                a(byteBuffer2);
            }
        }
        this.e = byteBuffer;
        this.f = null;
        this.g = byteBuffer.remaining();
    }

    @Override // io.netty.b.i
    public int Q() {
        return this.g;
    }

    @Override // io.netty.b.i
    public i C(int i) {
        A();
        if (i < 0 || i > a()) {
            throw new IllegalArgumentException("newCapacity: " + i);
        }
        int iB = b();
        int iC = c();
        int i2 = this.g;
        if (i > i2) {
            ByteBuffer byteBuffer = this.e;
            ByteBuffer byteBufferD = D(i);
            byteBuffer.position(0).limit(byteBuffer.capacity());
            byteBufferD.position(0).limit(byteBuffer.capacity());
            byteBufferD.put(byteBuffer);
            byteBufferD.clear();
            b(byteBufferD);
        } else if (i < i2) {
            ByteBuffer byteBuffer2 = this.e;
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
            b(byteBufferD2);
        }
        return this;
    }

    @Override // io.netty.b.i
    public j F() {
        return this.d;
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
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public byte f(int i) {
        A();
        return g(i);
    }

    @Override // io.netty.b.a
    protected byte g(int i) {
        return this.e.get(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public short i(int i) {
        A();
        return j(i);
    }

    @Override // io.netty.b.a
    protected short j(int i) {
        return this.e.getShort(i);
    }

    @Override // io.netty.b.a
    protected short l(int i) {
        return l.a(this.e.getShort(i));
    }

    @Override // io.netty.b.a, io.netty.b.i
    public int m(int i) {
        A();
        return n(i);
    }

    @Override // io.netty.b.a
    protected int n(int i) {
        return this.e.getInt(i);
    }

    @Override // io.netty.b.a
    protected int p(int i) {
        return l.a(this.e.getInt(i));
    }

    @Override // io.netty.b.a, io.netty.b.i
    public long s(int i) {
        A();
        return t(i);
    }

    @Override // io.netty.b.a
    protected long t(int i) {
        return this.e.getLong(i);
    }

    @Override // io.netty.b.i
    public i a(int i, i iVar, int i2, int i3) {
        b(i, i3, i2, iVar.Q());
        if (iVar.I()) {
            a(i, iVar.J(), iVar.K() + i2, i3);
        } else if (iVar.N() > 0) {
            ByteBuffer[] byteBufferArrN = iVar.n(i2, i3);
            for (ByteBuffer byteBuffer : byteBufferArrN) {
                int iRemaining = byteBuffer.remaining();
                a(i, byteBuffer);
                i += iRemaining;
            }
        } else {
            iVar.b(i2, this, i, i3);
        }
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, byte[] bArr, int i2, int i3) {
        a(i, bArr, i2, i3, false);
        return this;
    }

    private void a(int i, byte[] bArr, int i2, int i3, boolean z) {
        ByteBuffer byteBufferDuplicate;
        b(i, i3, i2, bArr.length);
        if (z) {
            byteBufferDuplicate = O();
        } else {
            byteBufferDuplicate = this.e.duplicate();
        }
        byteBufferDuplicate.clear().position(i).limit(i + i3);
        byteBufferDuplicate.get(bArr, i2, i3);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i a(byte[] bArr, int i, int i2) {
        A(i2);
        a(this.f4368b, bArr, i, i2, true);
        this.f4368b += i2;
        return this;
    }

    public i a(int i, ByteBuffer byteBuffer) {
        a(i, byteBuffer, false);
        return this;
    }

    private void a(int i, ByteBuffer byteBuffer, boolean z) {
        ByteBuffer byteBufferDuplicate;
        i(i, byteBuffer.remaining());
        if (z) {
            byteBufferDuplicate = O();
        } else {
            byteBufferDuplicate = this.e.duplicate();
        }
        byteBufferDuplicate.clear().position(i).limit(i + byteBuffer.remaining());
        byteBuffer.put(byteBufferDuplicate);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i b(int i, int i2) {
        A();
        c(i, i2);
        return this;
    }

    @Override // io.netty.b.a
    protected void c(int i, int i2) {
        this.e.put(i, (byte) i2);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i d(int i, int i2) {
        A();
        e(i, i2);
        return this;
    }

    @Override // io.netty.b.a
    protected void e(int i, int i2) {
        this.e.putShort(i, (short) i2);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i f(int i, int i2) {
        A();
        g(i, i2);
        return this;
    }

    @Override // io.netty.b.a
    protected void g(int i, int i2) {
        this.e.putInt(i, i2);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i a(int i, long j) {
        A();
        b(i, j);
        return this;
    }

    @Override // io.netty.b.a
    protected void b(int i, long j) {
        this.e.putLong(i, j);
    }

    @Override // io.netty.b.i
    public i b(int i, i iVar, int i2, int i3) {
        a(i, i3, i2, iVar.Q());
        if (iVar.N() > 0) {
            ByteBuffer[] byteBufferArrN = iVar.n(i2, i3);
            for (ByteBuffer byteBuffer : byteBufferArrN) {
                int iRemaining = byteBuffer.remaining();
                b(i, byteBuffer);
                i += iRemaining;
            }
        } else {
            iVar.a(i2, this, i, i3);
        }
        return this;
    }

    @Override // io.netty.b.i
    public i b(int i, byte[] bArr, int i2, int i3) {
        a(i, i3, i2, bArr.length);
        ByteBuffer byteBufferO = O();
        byteBufferO.clear().position(i).limit(i + i3);
        byteBufferO.put(bArr, i2, i3);
        return this;
    }

    public i b(int i, ByteBuffer byteBuffer) {
        A();
        ByteBuffer byteBufferO = O();
        if (byteBuffer == byteBufferO) {
            byteBuffer = byteBuffer.duplicate();
        }
        byteBufferO.clear().position(i).limit(i + byteBuffer.remaining());
        byteBufferO.put(byteBuffer);
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, OutputStream outputStream, int i2) throws IOException {
        a(i, outputStream, i2, false);
        return this;
    }

    private void a(int i, OutputStream outputStream, int i2, boolean z) throws IOException {
        ByteBuffer byteBufferDuplicate;
        A();
        if (i2 == 0) {
            return;
        }
        if (this.e.hasArray()) {
            outputStream.write(this.e.array(), i + this.e.arrayOffset(), i2);
            return;
        }
        byte[] bArr = new byte[i2];
        if (z) {
            byteBufferDuplicate = O();
        } else {
            byteBufferDuplicate = this.e.duplicate();
        }
        byteBufferDuplicate.clear().position(i);
        byteBufferDuplicate.get(bArr);
        outputStream.write(bArr);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i a(OutputStream outputStream, int i) throws IOException {
        A(i);
        a(this.f4368b, outputStream, i, true);
        this.f4368b += i;
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
            byteBufferDuplicate = this.e.duplicate();
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
    public int a(int i, InputStream inputStream, int i2) throws IOException {
        A();
        if (this.e.hasArray()) {
            return inputStream.read(this.e.array(), this.e.arrayOffset() + i, i2);
        }
        byte[] bArr = new byte[i2];
        int i3 = inputStream.read(bArr);
        if (i3 <= 0) {
            return i3;
        }
        ByteBuffer byteBufferO = O();
        byteBufferO.clear().position(i);
        byteBufferO.put(bArr, 0, i3);
        return i3;
    }

    @Override // io.netty.b.i
    public int a(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        A();
        O().clear().position(i).limit(i + i2);
        try {
            return scatteringByteChannel.read(this.f);
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
        ByteBuffer byteBuffer = this.f;
        if (byteBuffer != null) {
            return byteBuffer;
        }
        ByteBuffer byteBufferDuplicate = this.e.duplicate();
        this.f = byteBufferDuplicate;
        return byteBufferDuplicate;
    }

    @Override // io.netty.b.i
    public ByteBuffer m(int i, int i2) {
        i(i, i2);
        return ((ByteBuffer) this.e.duplicate().position(i).limit(i + i2)).slice();
    }

    @Override // io.netty.b.d
    protected void E() {
        ByteBuffer byteBuffer = this.e;
        if (byteBuffer == null) {
            return;
        }
        this.e = null;
        if (this.h) {
            return;
        }
        a(byteBuffer);
    }
}
