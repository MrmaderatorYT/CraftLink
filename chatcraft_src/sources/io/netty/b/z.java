package io.netty.b;

import io.netty.util.l;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* compiled from: PooledHeapByteBuf.java */
/* loaded from: classes.dex */
class z extends w<byte[]> {
    private static final io.netty.util.l<z> l = new io.netty.util.l<z>() { // from class: io.netty.b.z.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public z b(l.b<z> bVar) {
            return new z(bVar, 0);
        }
    };

    @Override // io.netty.b.i
    public final boolean H() {
        return false;
    }

    @Override // io.netty.b.i
    public final boolean I() {
        return true;
    }

    @Override // io.netty.b.i
    public final boolean L() {
        return false;
    }

    @Override // io.netty.b.i
    public final int N() {
        return 1;
    }

    static z F(int i) {
        z zVarA = l.a();
        zVarA.D(i);
        return zVarA;
    }

    z(l.b<? extends z> bVar, int i) {
        super(bVar, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected byte g(int i) {
        return p.a((byte[]) this.f, E(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected short j(int i) {
        return p.b((byte[]) this.f, E(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected short l(int i) {
        return p.c((byte[]) this.f, E(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected int n(int i) {
        return p.d((byte[]) this.f, E(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected int p(int i) {
        return p.e((byte[]) this.f, E(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected long t(int i) {
        return p.f((byte[]) this.f, E(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.i
    public final i a(int i, i iVar, int i2, int i3) {
        b(i, i3, i2, iVar.Q());
        if (iVar.L()) {
            io.netty.util.a.l.a((byte[]) this.f, E(i), i2 + iVar.M(), i3);
        } else if (iVar.I()) {
            a(i, iVar.J(), iVar.K() + i2, i3);
        } else {
            iVar.b(i2, (byte[]) this.f, E(i), i3);
        }
        return this;
    }

    @Override // io.netty.b.i
    public final i a(int i, byte[] bArr, int i2, int i3) {
        b(i, i3, i2, bArr.length);
        System.arraycopy(this.f, E(i), bArr, i2, i3);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.i
    public final i a(int i, OutputStream outputStream, int i2) throws IOException {
        i(i, i2);
        outputStream.write((byte[]) this.f, E(i), i2);
        return this;
    }

    @Override // io.netty.b.i
    public final int a(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        return a(i, gatheringByteChannel, i2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int a(int i, GatheringByteChannel gatheringByteChannel, int i2, boolean z) {
        ByteBuffer byteBufferWrap;
        i(i, i2);
        int iE = E(i);
        if (z) {
            byteBufferWrap = O();
        } else {
            byteBufferWrap = ByteBuffer.wrap((byte[]) this.f);
        }
        return gatheringByteChannel.write((ByteBuffer) byteBufferWrap.clear().position(iE).limit(iE + i2));
    }

    @Override // io.netty.b.a, io.netty.b.i
    public final int a(GatheringByteChannel gatheringByteChannel, int i) {
        A(i);
        int iA = a(this.f4368b, gatheringByteChannel, i, true);
        this.f4368b += iA;
        return iA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected void c(int i, int i2) {
        p.a((byte[]) this.f, E(i), i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected void e(int i, int i2) {
        p.b((byte[]) this.f, E(i), i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected void g(int i, int i2) {
        p.c((byte[]) this.f, E(i), i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.a
    protected void b(int i, long j) {
        p.a((byte[]) this.f, E(i), j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.i
    public final i b(int i, i iVar, int i2, int i3) {
        a(i, i3, i2, iVar.Q());
        if (iVar.L()) {
            io.netty.util.a.l.a(iVar.M() + i2, (byte[]) this.f, E(i), i3);
        } else if (iVar.I()) {
            b(i, iVar.J(), iVar.K() + i2, i3);
        } else {
            iVar.a(i2, (byte[]) this.f, E(i), i3);
        }
        return this;
    }

    @Override // io.netty.b.i
    public final i b(int i, byte[] bArr, int i2, int i3) {
        a(i, i3, i2, bArr.length);
        System.arraycopy(bArr, i2, this.f, E(i), i3);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.i
    public final int a(int i, InputStream inputStream, int i2) {
        i(i, i2);
        return inputStream.read((byte[]) this.f, E(i), i2);
    }

    @Override // io.netty.b.i
    public final int a(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        i(i, i2);
        int iE = E(i);
        try {
            return scatteringByteChannel.read((ByteBuffer) O().clear().position(iE).limit(iE + i2));
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.b.i
    public final ByteBuffer[] n(int i, int i2) {
        return new ByteBuffer[]{m(i, i2)};
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.i
    public final ByteBuffer m(int i, int i2) {
        i(i, i2);
        return ByteBuffer.wrap((byte[]) this.f, E(i), i2).slice();
    }

    @Override // io.netty.b.i
    public final ByteBuffer l(int i, int i2) {
        i(i, i2);
        int iE = E(i);
        return (ByteBuffer) O().clear().position(iE).limit(iE + i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.i
    public final byte[] J() {
        A();
        return (byte[]) this.f;
    }

    @Override // io.netty.b.i
    public final int K() {
        return this.g;
    }

    @Override // io.netty.b.i
    public final long M() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.b.w
    public final ByteBuffer c(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }
}
