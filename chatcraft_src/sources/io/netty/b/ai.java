package io.netty.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* compiled from: UnpooledHeapByteBuf.java */
/* loaded from: classes.dex */
public class ai extends d {
    byte[] d;
    private final j e;
    private ByteBuffer f;

    @Override // io.netty.b.i
    public i A_() {
        return null;
    }

    @Override // io.netty.b.i
    public boolean H() {
        return false;
    }

    @Override // io.netty.b.i
    public boolean I() {
        return true;
    }

    @Override // io.netty.b.i
    public int K() {
        return 0;
    }

    @Override // io.netty.b.i
    public boolean L() {
        return false;
    }

    @Override // io.netty.b.i
    public int N() {
        return 1;
    }

    protected ai(j jVar, int i, int i2) {
        this(jVar, new byte[i], 0, 0, i2);
    }

    protected ai(j jVar, byte[] bArr, int i) {
        this(jVar, bArr, 0, bArr.length, i);
    }

    private ai(j jVar, byte[] bArr, int i, int i2, int i3) {
        super(i3);
        if (jVar == null) {
            throw new NullPointerException("alloc");
        }
        if (bArr == null) {
            throw new NullPointerException("initialArray");
        }
        if (bArr.length > i3) {
            throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(bArr.length), Integer.valueOf(i3)));
        }
        this.e = jVar;
        c(bArr);
        a(i, i2);
    }

    private void c(byte[] bArr) {
        this.d = bArr;
        this.f = null;
    }

    @Override // io.netty.b.i
    public j F() {
        return this.e;
    }

    @Override // io.netty.b.i
    public ByteOrder G() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override // io.netty.b.i
    public int Q() {
        A();
        return this.d.length;
    }

    @Override // io.netty.b.i
    public i C(int i) {
        A();
        if (i < 0 || i > a()) {
            throw new IllegalArgumentException("newCapacity: " + i);
        }
        int length = this.d.length;
        if (i > length) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.d, 0, bArr, 0, this.d.length);
            c(bArr);
        } else if (i < length) {
            byte[] bArr2 = new byte[i];
            int iB = b();
            if (iB < i) {
                int iC = c();
                if (iC > i) {
                    c(i);
                } else {
                    i = iC;
                }
                System.arraycopy(this.d, iB, bArr2, iB, i - iB);
            } else {
                a(i, i);
            }
            c(bArr2);
        }
        return this;
    }

    @Override // io.netty.b.i
    public byte[] J() {
        A();
        return this.d;
    }

    @Override // io.netty.b.i
    public long M() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.b.i
    public i a(int i, i iVar, int i2, int i3) {
        b(i, i3, i2, iVar.Q());
        if (iVar.L()) {
            io.netty.util.a.l.a(this.d, i, i2 + iVar.M(), i3);
        } else if (iVar.I()) {
            a(i, iVar.J(), iVar.K() + i2, i3);
        } else {
            iVar.b(i2, this.d, i, i3);
        }
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, byte[] bArr, int i2, int i3) {
        b(i, i3, i2, bArr.length);
        System.arraycopy(this.d, i, bArr, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, OutputStream outputStream, int i2) throws IOException {
        A();
        outputStream.write(this.d, i, i2);
        return this;
    }

    @Override // io.netty.b.i
    public int a(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        A();
        return a(i, gatheringByteChannel, i2, false);
    }

    private int a(int i, GatheringByteChannel gatheringByteChannel, int i2, boolean z) {
        ByteBuffer byteBufferWrap;
        A();
        if (z) {
            byteBufferWrap = O();
        } else {
            byteBufferWrap = ByteBuffer.wrap(this.d);
        }
        return gatheringByteChannel.write((ByteBuffer) byteBufferWrap.clear().position(i).limit(i + i2));
    }

    @Override // io.netty.b.a, io.netty.b.i
    public int a(GatheringByteChannel gatheringByteChannel, int i) {
        A(i);
        int iA = a(this.f4368b, gatheringByteChannel, i, true);
        this.f4368b += iA;
        return iA;
    }

    @Override // io.netty.b.i
    public i b(int i, i iVar, int i2, int i3) {
        a(i, i3, i2, iVar.Q());
        if (iVar.L()) {
            io.netty.util.a.l.a(iVar.M() + i2, this.d, i, i3);
        } else if (iVar.I()) {
            b(i, iVar.J(), iVar.K() + i2, i3);
        } else {
            iVar.a(i2, this.d, i, i3);
        }
        return this;
    }

    @Override // io.netty.b.i
    public i b(int i, byte[] bArr, int i2, int i3) {
        a(i, i3, i2, bArr.length);
        System.arraycopy(bArr, i2, this.d, i, i3);
        return this;
    }

    @Override // io.netty.b.i
    public int a(int i, InputStream inputStream, int i2) {
        A();
        return inputStream.read(this.d, i, i2);
    }

    @Override // io.netty.b.i
    public int a(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        A();
        try {
            return scatteringByteChannel.read((ByteBuffer) O().clear().position(i).limit(i + i2));
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.b.i
    public ByteBuffer m(int i, int i2) {
        A();
        return ByteBuffer.wrap(this.d, i, i2).slice();
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

    @Override // io.netty.b.a, io.netty.b.i
    public byte f(int i) {
        A();
        return g(i);
    }

    @Override // io.netty.b.a
    protected byte g(int i) {
        return p.a(this.d, i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public short i(int i) {
        A();
        return j(i);
    }

    @Override // io.netty.b.a
    protected short j(int i) {
        return p.b(this.d, i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public short k(int i) {
        A();
        return l(i);
    }

    @Override // io.netty.b.a
    protected short l(int i) {
        return p.c(this.d, i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public int m(int i) {
        A();
        return n(i);
    }

    @Override // io.netty.b.a
    protected int n(int i) {
        return p.d(this.d, i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public int o(int i) {
        A();
        return p(i);
    }

    @Override // io.netty.b.a
    protected int p(int i) {
        return p.e(this.d, i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public long s(int i) {
        A();
        return t(i);
    }

    @Override // io.netty.b.a
    protected long t(int i) {
        return p.f(this.d, i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i b(int i, int i2) {
        A();
        c(i, i2);
        return this;
    }

    @Override // io.netty.b.a
    protected void c(int i, int i2) {
        p.a(this.d, i, i2);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i d(int i, int i2) {
        A();
        e(i, i2);
        return this;
    }

    @Override // io.netty.b.a
    protected void e(int i, int i2) {
        p.b(this.d, i, i2);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i f(int i, int i2) {
        A();
        g(i, i2);
        return this;
    }

    @Override // io.netty.b.a
    protected void g(int i, int i2) {
        p.c(this.d, i, i2);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i a(int i, long j) {
        A();
        b(i, j);
        return this;
    }

    @Override // io.netty.b.a
    protected void b(int i, long j) {
        p.a(this.d, i, j);
    }

    private ByteBuffer O() {
        ByteBuffer byteBuffer = this.f;
        if (byteBuffer != null) {
            return byteBuffer;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.d);
        this.f = byteBufferWrap;
        return byteBufferWrap;
    }

    @Override // io.netty.b.d
    protected void E() {
        this.d = null;
    }
}
