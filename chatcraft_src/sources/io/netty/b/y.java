package io.netty.b;

import io.netty.util.l;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* compiled from: PooledDirectByteBuf.java */
/* loaded from: classes.dex */
final class y extends w<ByteBuffer> {
    private static final io.netty.util.l<y> l = new io.netty.util.l<y>() { // from class: io.netty.b.y.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public y b(l.b<y> bVar) {
            return new y(bVar, 0);
        }
    };

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

    static y F(int i) {
        y yVarA = l.a();
        yVarA.D(i);
        return yVarA;
    }

    private y(l.b<y> bVar, int i) {
        super(bVar, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.b.w
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ByteBuffer c(ByteBuffer byteBuffer) {
        return byteBuffer.duplicate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected byte g(int i) {
        return ((ByteBuffer) this.f).get(E(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected short j(int i) {
        return ((ByteBuffer) this.f).getShort(E(i));
    }

    @Override // io.netty.b.a
    protected short l(int i) {
        return l.a(j(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected int n(int i) {
        return ((ByteBuffer) this.f).getInt(E(i));
    }

    @Override // io.netty.b.a
    protected int p(int i) {
        return l.a(n(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected long t(int i) {
        return ((ByteBuffer) this.f).getLong(E(i));
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

    /* JADX WARN: Multi-variable type inference failed */
    private void a(int i, byte[] bArr, int i2, int i3, boolean z) {
        ByteBuffer byteBufferDuplicate;
        b(i, i3, i2, bArr.length);
        if (z) {
            byteBufferDuplicate = O();
        } else {
            byteBufferDuplicate = ((ByteBuffer) this.f).duplicate();
        }
        int iE = E(i);
        byteBufferDuplicate.clear().position(iE).limit(iE + i3);
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

    /* JADX WARN: Multi-variable type inference failed */
    private void a(int i, ByteBuffer byteBuffer, boolean z) {
        ByteBuffer byteBufferDuplicate;
        i(i, byteBuffer.remaining());
        if (z) {
            byteBufferDuplicate = O();
        } else {
            byteBufferDuplicate = ((ByteBuffer) this.f).duplicate();
        }
        int iE = E(i);
        byteBufferDuplicate.clear().position(iE).limit(iE + byteBuffer.remaining());
        byteBuffer.put(byteBufferDuplicate);
    }

    @Override // io.netty.b.i
    public i a(int i, OutputStream outputStream, int i2) throws IOException {
        a(i, outputStream, i2, false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(int i, OutputStream outputStream, int i2, boolean z) throws IOException {
        ByteBuffer byteBufferDuplicate;
        i(i, i2);
        if (i2 == 0) {
            return;
        }
        byte[] bArr = new byte[i2];
        if (z) {
            byteBufferDuplicate = O();
        } else {
            byteBufferDuplicate = ((ByteBuffer) this.f).duplicate();
        }
        byteBufferDuplicate.clear().position(E(i));
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected void c(int i, int i2) {
        ((ByteBuffer) this.f).put(E(i), (byte) i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected void e(int i, int i2) {
        ((ByteBuffer) this.f).putShort(E(i), (short) i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected void g(int i, int i2) {
        ((ByteBuffer) this.f).putInt(E(i), i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected void b(int i, long j) {
        ((ByteBuffer) this.f).putLong(E(i), j);
    }

    @Override // io.netty.b.i
    public i b(int i, i iVar, int i2, int i3) {
        a(i, i3, i2, iVar.Q());
        if (iVar.I()) {
            b(i, iVar.J(), iVar.K() + i2, i3);
        } else if (iVar.N() > 0) {
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
        int iE = E(i);
        byteBufferO.clear().position(iE).limit(iE + i3);
        byteBufferO.put(bArr, i2, i3);
        return this;
    }

    public i b(int i, ByteBuffer byteBuffer) {
        i(i, byteBuffer.remaining());
        ByteBuffer byteBufferO = O();
        if (byteBuffer == byteBufferO) {
            byteBuffer = byteBuffer.duplicate();
        }
        int iE = E(i);
        byteBufferO.clear().position(iE).limit(iE + byteBuffer.remaining());
        byteBufferO.put(byteBuffer);
        return this;
    }

    @Override // io.netty.b.i
    public int a(int i, InputStream inputStream, int i2) throws IOException {
        i(i, i2);
        byte[] bArr = new byte[i2];
        int i3 = inputStream.read(bArr);
        if (i3 <= 0) {
            return i3;
        }
        ByteBuffer byteBufferO = O();
        byteBufferO.clear().position(E(i));
        byteBufferO.put(bArr, 0, i3);
        return i3;
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.i
    public ByteBuffer m(int i, int i2) {
        i(i, i2);
        int iE = E(i);
        return ((ByteBuffer) ((ByteBuffer) this.f).duplicate().position(iE).limit(iE + i2)).slice();
    }

    @Override // io.netty.b.i
    public ByteBuffer[] n(int i, int i2) {
        return new ByteBuffer[]{m(i, i2)};
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
        throw new UnsupportedOperationException();
    }
}
