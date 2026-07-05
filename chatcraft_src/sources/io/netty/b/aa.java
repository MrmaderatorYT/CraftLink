package io.netty.b;

import io.netty.util.l;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* compiled from: PooledUnsafeDirectByteBuf.java */
/* loaded from: classes.dex */
final class aa extends w<ByteBuffer> {
    private static final io.netty.util.l<aa> l = new io.netty.util.l<aa>() { // from class: io.netty.b.aa.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public aa b(l.b<aa> bVar) {
            return new aa(bVar, 0);
        }
    };
    private long m;

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

    static aa F(int i) {
        aa aaVarA = l.a();
        aaVarA.D(i);
        return aaVarA;
    }

    private aa(l.b<aa> bVar, int i) {
        super(bVar, i);
    }

    @Override // io.netty.b.w
    void a(r<ByteBuffer> rVar, long j, int i, int i2, int i3, v vVar) {
        super.a(rVar, j, i, i2, i3, vVar);
        P();
    }

    @Override // io.netty.b.w
    void a(r<ByteBuffer> rVar, int i) {
        super.a(rVar, i);
        P();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void P() {
        this.m = io.netty.util.a.l.b((ByteBuffer) this.f) + this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.b.w
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ByteBuffer c(ByteBuffer byteBuffer) {
        return byteBuffer.duplicate();
    }

    @Override // io.netty.b.a
    protected byte g(int i) {
        return an.a(G(i));
    }

    @Override // io.netty.b.a
    protected short j(int i) {
        return an.b(G(i));
    }

    @Override // io.netty.b.a
    protected short l(int i) {
        return an.c(G(i));
    }

    @Override // io.netty.b.a
    protected int n(int i) {
        return an.d(G(i));
    }

    @Override // io.netty.b.a
    protected int p(int i) {
        return an.e(G(i));
    }

    @Override // io.netty.b.a
    protected long t(int i) {
        return an.f(G(i));
    }

    @Override // io.netty.b.i
    public i a(int i, i iVar, int i2, int i3) {
        an.a(this, G(i), i, iVar, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, byte[] bArr, int i2, int i3) {
        an.a(this, G(i), i, bArr, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, OutputStream outputStream, int i2) {
        an.a(this, G(i), i, outputStream, i2);
        return this;
    }

    @Override // io.netty.b.i
    public int a(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        return a(i, gatheringByteChannel, i2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int a(int i, GatheringByteChannel gatheringByteChannel, int i2, boolean z) {
        ByteBuffer byteBufferDuplicate;
        i(i, i2);
        if (i2 == 0) {
            return 0;
        }
        if (z) {
            byteBufferDuplicate = O();
        } else {
            byteBufferDuplicate = ((ByteBuffer) this.f).duplicate();
        }
        int iE = E(i);
        byteBufferDuplicate.clear().position(iE).limit(iE + i2);
        return gatheringByteChannel.write(byteBufferDuplicate);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public int a(GatheringByteChannel gatheringByteChannel, int i) {
        A(i);
        int iA = a(this.f4368b, gatheringByteChannel, i, true);
        this.f4368b += iA;
        return iA;
    }

    @Override // io.netty.b.a
    protected void c(int i, int i2) {
        an.a(G(i), (int) ((byte) i2));
    }

    @Override // io.netty.b.a
    protected void e(int i, int i2) {
        an.b(G(i), i2);
    }

    @Override // io.netty.b.a
    protected void g(int i, int i2) {
        an.c(G(i), i2);
    }

    @Override // io.netty.b.a
    protected void b(int i, long j) {
        an.a(G(i), j);
    }

    @Override // io.netty.b.i
    public i b(int i, i iVar, int i2, int i3) {
        an.b(this, G(i), i, iVar, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public i b(int i, byte[] bArr, int i2, int i3) {
        an.b(this, G(i), i, bArr, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public int a(int i, InputStream inputStream, int i2) {
        return an.a(this, G(i), i, inputStream, i2);
    }

    @Override // io.netty.b.i
    public int a(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        i(i, i2);
        ByteBuffer byteBufferO = O();
        int iE = E(i);
        byteBufferO.clear().position(iE).limit(iE + i2);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.i
    public ByteBuffer m(int i, int i2) {
        i(i, i2);
        int iE = E(i);
        return ((ByteBuffer) ((ByteBuffer) this.f).duplicate().position(iE).limit(iE + i2)).slice();
    }

    @Override // io.netty.b.i
    public ByteBuffer l(int i, int i2) {
        i(i, i2);
        int iE = E(i);
        return (ByteBuffer) O().clear().position(iE).limit(iE + i2);
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
        return this.m;
    }

    private long G(int i) {
        return this.m + i;
    }

    @Override // io.netty.b.a
    protected ae m() {
        if (io.netty.util.a.l.g()) {
            return new ao(this);
        }
        return super.m();
    }
}
