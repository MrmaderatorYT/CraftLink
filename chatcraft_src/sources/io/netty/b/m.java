package io.netty.b;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: CompositeByteBuf.java */
/* loaded from: classes.dex */
public class m extends d implements Iterable<i> {
    static final /* synthetic */ boolean d = !m.class.desiredAssertionStatus();
    private static final ByteBuffer e = af.c.y();
    private static final Iterator<i> f = Collections.emptyList().iterator();
    private final j g;
    private final boolean h;
    private final List<a> i;
    private final int j;
    private boolean k;

    @Override // io.netty.b.i
    public i A_() {
        return null;
    }

    @Override // io.netty.b.d, io.netty.b.i, io.netty.util.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m b(Object obj) {
        return this;
    }

    public m(j jVar, boolean z, int i) {
        super(Integer.MAX_VALUE);
        if (jVar == null) {
            throw new NullPointerException("alloc");
        }
        this.g = jVar;
        this.h = z;
        this.j = i;
        this.i = M(i);
    }

    private static List<a> M(int i) {
        return new ArrayList(Math.min(16, i));
    }

    m(j jVar) {
        super(Integer.MAX_VALUE);
        this.g = jVar;
        this.h = false;
        this.j = 0;
        this.i = Collections.emptyList();
    }

    public m a(boolean z, i iVar) throws Throwable {
        io.netty.util.a.j.a(iVar, "buffer");
        a(z, this.i.size(), iVar);
        U();
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0061 A[Catch: all -> 0x0073, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:9:0x000f, B:11:0x002d, B:26:0x0061, B:18:0x0050), top: B:34:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int a(boolean r6, int r7, io.netty.b.i r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = io.netty.b.m.d
            if (r0 != 0) goto Ld
            if (r8 == 0) goto L7
            goto Ld
        L7:
            java.lang.AssertionError r6 = new java.lang.AssertionError
            r6.<init>()
            throw r6
        Ld:
            r0 = 0
            r1 = 1
            r5.N(r7)     // Catch: java.lang.Throwable -> L73
            int r2 = r8.g()     // Catch: java.lang.Throwable -> L73
            io.netty.b.m$a r3 = new io.netty.b.m$a     // Catch: java.lang.Throwable -> L73
            java.nio.ByteOrder r4 = java.nio.ByteOrder.BIG_ENDIAN     // Catch: java.lang.Throwable -> L73
            io.netty.b.i r4 = r8.a(r4)     // Catch: java.lang.Throwable -> L73
            io.netty.b.i r4 = r4.x()     // Catch: java.lang.Throwable -> L73
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L73
            java.util.List<io.netty.b.m$a> r4 = r5.i     // Catch: java.lang.Throwable -> L73
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L73
            if (r7 != r4) goto L50
            java.util.List<io.netty.b.m$a> r1 = r5.i     // Catch: java.lang.Throwable -> L73
            boolean r1 = r1.add(r3)     // Catch: java.lang.Throwable -> L73
            if (r7 != 0) goto L3b
            r3.d = r2     // Catch: java.lang.Throwable -> L38
            goto L4e
        L38:
            r6 = move-exception
            r0 = r1
            goto L74
        L3b:
            java.util.List<io.netty.b.m$a> r0 = r5.i     // Catch: java.lang.Throwable -> L38
            int r4 = r7 + (-1)
            java.lang.Object r0 = r0.get(r4)     // Catch: java.lang.Throwable -> L38
            io.netty.b.m$a r0 = (io.netty.b.m.a) r0     // Catch: java.lang.Throwable -> L38
            int r0 = r0.d     // Catch: java.lang.Throwable -> L38
            r3.c = r0     // Catch: java.lang.Throwable -> L38
            int r0 = r3.c     // Catch: java.lang.Throwable -> L38
            int r0 = r0 + r2
            r3.d = r0     // Catch: java.lang.Throwable -> L38
        L4e:
            r0 = r1
            goto L5f
        L50:
            java.util.List<io.netty.b.m$a> r4 = r5.i     // Catch: java.lang.Throwable -> L73
            r4.add(r7, r3)     // Catch: java.lang.Throwable -> L73
            if (r2 == 0) goto L5e
            r5.O(r7)     // Catch: java.lang.Throwable -> L5b
            goto L5e
        L5b:
            r6 = move-exception
            r0 = 1
            goto L74
        L5e:
            r0 = 1
        L5f:
            if (r6 == 0) goto L6d
            int r6 = r5.c()     // Catch: java.lang.Throwable -> L73
            int r1 = r8.g()     // Catch: java.lang.Throwable -> L73
            int r6 = r6 + r1
            r5.c(r6)     // Catch: java.lang.Throwable -> L73
        L6d:
            if (r0 != 0) goto L72
            r8.D()
        L72:
            return r7
        L73:
            r6 = move-exception
        L74:
            if (r0 != 0) goto L79
            r8.D()
        L79:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.b.m.a(boolean, int, io.netty.b.i):int");
    }

    private void U() {
        int size = this.i.size();
        if (size > this.j) {
            i iVarQ = Q(this.i.get(size - 1).d);
            for (int i = 0; i < size; i++) {
                a aVar = this.i.get(i);
                iVarQ.a(aVar.f4387a);
                aVar.a();
            }
            a aVar2 = new a(iVarQ);
            aVar2.d = aVar2.f4388b;
            this.i.clear();
            this.i.add(aVar2);
        }
    }

    private void N(int i) {
        A();
        if (i < 0 || i > this.i.size()) {
            throw new IndexOutOfBoundsException(String.format("cIndex: %d (expected: >= 0 && <= numComponents(%d))", Integer.valueOf(i), Integer.valueOf(this.i.size())));
        }
    }

    private void O(int i) {
        int size = this.i.size();
        if (size <= i) {
            return;
        }
        a aVar = this.i.get(i);
        if (i == 0) {
            aVar.c = 0;
            aVar.d = aVar.f4388b;
            i++;
        }
        while (i < size) {
            a aVar2 = this.i.get(i - 1);
            a aVar3 = this.i.get(i);
            aVar3.c = aVar2.d;
            aVar3.d = aVar3.c + aVar3.f4388b;
            i++;
        }
    }

    public Iterator<i> iterator() {
        A();
        if (this.i.isEmpty()) {
            return f;
        }
        return new b();
    }

    @Override // io.netty.b.i
    public boolean H() {
        int size = this.i.size();
        if (size == 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this.i.get(i).f4387a.H()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.netty.b.i
    public boolean I() {
        switch (this.i.size()) {
            case 0:
                return true;
            case 1:
                return this.i.get(0).f4387a.I();
            default:
                return false;
        }
    }

    @Override // io.netty.b.i
    public byte[] J() {
        switch (this.i.size()) {
            case 0:
                return io.netty.util.a.b.f4643a;
            case 1:
                return this.i.get(0).f4387a.J();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // io.netty.b.i
    public int K() {
        switch (this.i.size()) {
            case 0:
                return 0;
            case 1:
                return this.i.get(0).f4387a.K();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // io.netty.b.i
    public boolean L() {
        switch (this.i.size()) {
            case 0:
                return af.c.L();
            case 1:
                return this.i.get(0).f4387a.L();
            default:
                return false;
        }
    }

    @Override // io.netty.b.i
    public long M() {
        switch (this.i.size()) {
            case 0:
                return af.c.M();
            case 1:
                return this.i.get(0).f4387a.M();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // io.netty.b.i
    public int Q() {
        int size = this.i.size();
        if (size == 0) {
            return 0;
        }
        return this.i.get(size - 1).d;
    }

    @Override // io.netty.b.i
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public m C(int i) throws Throwable {
        A();
        if (i < 0 || i > a()) {
            throw new IllegalArgumentException("newCapacity: " + i);
        }
        int iQ = Q();
        if (i > iQ) {
            int i2 = i - iQ;
            if (this.i.size() < this.j) {
                i iVarQ = Q(i2);
                iVarQ.a(0, i2);
                a(false, this.i.size(), iVarQ);
            } else {
                i iVarQ2 = Q(i2);
                iVarQ2.a(0, i2);
                a(false, this.i.size(), iVarQ2);
                U();
            }
        } else if (i < iQ) {
            int i3 = iQ - i;
            ListIterator<a> listIterator = this.i.listIterator(this.i.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                a aVarPrevious = listIterator.previous();
                if (i3 >= aVarPrevious.f4388b) {
                    i3 -= aVarPrevious.f4388b;
                    listIterator.remove();
                } else {
                    a aVar = new a(aVarPrevious.f4387a.h(0, aVarPrevious.f4388b - i3));
                    aVar.c = aVarPrevious.c;
                    aVar.d = aVar.c + aVar.f4388b;
                    listIterator.set(aVar);
                    break;
                }
            }
            if (b() > i) {
                a(i, i);
            } else if (c() > i) {
                c(i);
            }
        }
        return this;
    }

    @Override // io.netty.b.i
    public j F() {
        return this.g;
    }

    @Override // io.netty.b.i
    public ByteOrder G() {
        return ByteOrder.BIG_ENDIAN;
    }

    public int J(int i) {
        z(i);
        int size = this.i.size();
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            a aVar = this.i.get(i3);
            if (i >= aVar.d) {
                i2 = i3 + 1;
            } else {
                if (i >= aVar.c) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        throw new Error("should not reach here");
    }

    @Override // io.netty.b.a, io.netty.b.i
    public byte f(int i) {
        return g(i);
    }

    @Override // io.netty.b.a
    protected byte g(int i) {
        a aVarP = P(i);
        return aVarP.f4387a.f(i - aVarP.c);
    }

    @Override // io.netty.b.a
    protected short j(int i) {
        a aVarP = P(i);
        if (i + 2 <= aVarP.d) {
            return aVarP.f4387a.i(i - aVarP.c);
        }
        if (G() == ByteOrder.BIG_ENDIAN) {
            return (short) ((g(i + 1) & Constants.DimensionIds.NETHER) | ((g(i) & Constants.DimensionIds.NETHER) << 8));
        }
        return (short) (((g(i + 1) & Constants.DimensionIds.NETHER) << 8) | (g(i) & Constants.DimensionIds.NETHER));
    }

    @Override // io.netty.b.a
    protected short l(int i) {
        a aVarP = P(i);
        if (i + 2 <= aVarP.d) {
            return aVarP.f4387a.k(i - aVarP.c);
        }
        if (G() == ByteOrder.BIG_ENDIAN) {
            return (short) (((g(i + 1) & Constants.DimensionIds.NETHER) << 8) | (g(i) & Constants.DimensionIds.NETHER));
        }
        return (short) ((g(i + 1) & Constants.DimensionIds.NETHER) | ((g(i) & Constants.DimensionIds.NETHER) << 8));
    }

    @Override // io.netty.b.a
    protected int n(int i) {
        a aVarP = P(i);
        if (i + 4 <= aVarP.d) {
            return aVarP.f4387a.m(i - aVarP.c);
        }
        if (G() == ByteOrder.BIG_ENDIAN) {
            return (j(i + 2) & 65535) | ((j(i) & 65535) << 16);
        }
        return ((j(i + 2) & 65535) << 16) | (j(i) & 65535);
    }

    @Override // io.netty.b.a
    protected int p(int i) {
        a aVarP = P(i);
        if (i + 4 <= aVarP.d) {
            return aVarP.f4387a.o(i - aVarP.c);
        }
        if (G() == ByteOrder.BIG_ENDIAN) {
            return ((l(i + 2) & 65535) << 16) | (l(i) & 65535);
        }
        return (l(i + 2) & 65535) | ((l(i) & 65535) << 16);
    }

    @Override // io.netty.b.a
    protected long t(int i) {
        a aVarP = P(i);
        if (i + 8 <= aVarP.d) {
            return aVarP.f4387a.s(i - aVarP.c);
        }
        if (G() == ByteOrder.BIG_ENDIAN) {
            return ((n(i) & 4294967295L) << 32) | (4294967295L & n(i + 4));
        }
        return (n(i) & 4294967295L) | ((4294967295L & n(i + 4)) << 32);
    }

    @Override // io.netty.b.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m a(int i, byte[] bArr, int i2, int i3) {
        b(i, i3, i2, bArr.length);
        if (i3 == 0) {
            return this;
        }
        int iJ = J(i);
        while (i3 > 0) {
            a aVar = this.i.get(iJ);
            i iVar = aVar.f4387a;
            int i4 = i - aVar.c;
            int iMin = Math.min(i3, iVar.Q() - i4);
            iVar.a(i4, bArr, i2, iMin);
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iJ++;
        }
        return this;
    }

    @Override // io.netty.b.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m a(int i, i iVar, int i2, int i3) {
        b(i, i3, i2, iVar.Q());
        if (i3 == 0) {
            return this;
        }
        int iJ = J(i);
        while (i3 > 0) {
            a aVar = this.i.get(iJ);
            i iVar2 = aVar.f4387a;
            int i4 = i - aVar.c;
            int iMin = Math.min(i3, iVar2.Q() - i4);
            iVar2.a(i4, iVar, i2, iMin);
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iJ++;
        }
        return this;
    }

    @Override // io.netty.b.i
    public int a(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        if (N() == 1) {
            return gatheringByteChannel.write(l(i, i2));
        }
        long jWrite = gatheringByteChannel.write(n(i, i2));
        if (jWrite > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jWrite;
    }

    @Override // io.netty.b.i
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m a(int i, OutputStream outputStream, int i2) {
        i(i, i2);
        if (i2 == 0) {
            return this;
        }
        int iJ = J(i);
        while (i2 > 0) {
            a aVar = this.i.get(iJ);
            i iVar = aVar.f4387a;
            int i3 = i - aVar.c;
            int iMin = Math.min(i2, iVar.Q() - i3);
            iVar.a(i3, outputStream, iMin);
            i += iMin;
            i2 -= iMin;
            iJ++;
        }
        return this;
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public m b(int i, int i2) {
        a aVarP = P(i);
        aVarP.f4387a.b(i - aVarP.c, i2);
        return this;
    }

    @Override // io.netty.b.a
    protected void c(int i, int i2) {
        b(i, i2);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public m d(int i, int i2) {
        return (m) super.d(i, i2);
    }

    @Override // io.netty.b.a
    protected void e(int i, int i2) {
        a aVarP = P(i);
        if (i + 2 <= aVarP.d) {
            aVarP.f4387a.d(i - aVarP.c, i2);
        } else if (G() == ByteOrder.BIG_ENDIAN) {
            c(i, (int) ((byte) (i2 >>> 8)));
            c(i + 1, (int) ((byte) i2));
        } else {
            c(i, (int) ((byte) i2));
            c(i + 1, (int) ((byte) (i2 >>> 8)));
        }
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public m f(int i, int i2) {
        return (m) super.f(i, i2);
    }

    @Override // io.netty.b.a
    protected void g(int i, int i2) {
        a aVarP = P(i);
        if (i + 4 <= aVarP.d) {
            aVarP.f4387a.f(i - aVarP.c, i2);
        } else if (G() == ByteOrder.BIG_ENDIAN) {
            e(i, (short) (i2 >>> 16));
            e(i + 2, (short) i2);
        } else {
            e(i, (short) i2);
            e(i + 2, (short) (i2 >>> 16));
        }
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m a(int i, long j) {
        return (m) super.a(i, j);
    }

    @Override // io.netty.b.a
    protected void b(int i, long j) {
        a aVarP = P(i);
        if (i + 8 <= aVarP.d) {
            aVarP.f4387a.a(i - aVarP.c, j);
        } else if (G() == ByteOrder.BIG_ENDIAN) {
            g(i, (int) (j >>> 32));
            g(i + 4, (int) j);
        } else {
            g(i, (int) j);
            g(i + 4, (int) (j >>> 32));
        }
    }

    @Override // io.netty.b.i
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public m b(int i, byte[] bArr, int i2, int i3) {
        a(i, i3, i2, bArr.length);
        if (i3 == 0) {
            return this;
        }
        int iJ = J(i);
        while (i3 > 0) {
            a aVar = this.i.get(iJ);
            i iVar = aVar.f4387a;
            int i4 = i - aVar.c;
            int iMin = Math.min(i3, iVar.Q() - i4);
            iVar.b(i4, bArr, i2, iMin);
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iJ++;
        }
        return this;
    }

    @Override // io.netty.b.i
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public m b(int i, i iVar, int i2, int i3) {
        a(i, i3, i2, iVar.Q());
        if (i3 == 0) {
            return this;
        }
        int iJ = J(i);
        while (i3 > 0) {
            a aVar = this.i.get(iJ);
            i iVar2 = aVar.f4387a;
            int i4 = i - aVar.c;
            int iMin = Math.min(i3, iVar2.Q() - i4);
            iVar2.b(i4, iVar, i2, iMin);
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iJ++;
        }
        return this;
    }

    @Override // io.netty.b.i
    public int a(int i, InputStream inputStream, int i2) {
        i(i, i2);
        if (i2 == 0) {
            return inputStream.read(io.netty.util.a.b.f4643a);
        }
        int iJ = J(i);
        int i3 = 0;
        while (true) {
            a aVar = this.i.get(iJ);
            i iVar = aVar.f4387a;
            int i4 = i - aVar.c;
            int iMin = Math.min(i2, iVar.Q() - i4);
            if (iMin == 0) {
                iJ++;
            } else {
                int iA = iVar.a(i4, inputStream, iMin);
                if (iA < 0) {
                    if (i3 == 0) {
                        return -1;
                    }
                } else if (iA == iMin) {
                    i += iMin;
                    i2 -= iMin;
                    i3 += iMin;
                    iJ++;
                } else {
                    i += iA;
                    i2 -= iA;
                    i3 += iA;
                }
            }
            if (i2 <= 0) {
                break;
            }
        }
        return i3;
    }

    @Override // io.netty.b.i
    public int a(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        i(i, i2);
        if (i2 == 0) {
            return scatteringByteChannel.read(e);
        }
        int iJ = J(i);
        int i3 = 0;
        while (true) {
            a aVar = this.i.get(iJ);
            i iVar = aVar.f4387a;
            int i4 = i - aVar.c;
            int iMin = Math.min(i2, iVar.Q() - i4);
            if (iMin != 0) {
                int iA = iVar.a(i4, scatteringByteChannel, iMin);
                if (iA == 0) {
                    break;
                }
                if (iA < 0) {
                    if (i3 == 0) {
                        return -1;
                    }
                } else if (iA == iMin) {
                    i += iMin;
                    i2 -= iMin;
                    i3 += iMin;
                    iJ++;
                } else {
                    i += iA;
                    i2 -= iA;
                    i3 += iA;
                }
            } else {
                iJ++;
            }
            if (i2 <= 0) {
                break;
            }
        }
        return i3;
    }

    private a P(int i) {
        z(i);
        int size = this.i.size();
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            a aVar = this.i.get(i3);
            if (i >= aVar.d) {
                i2 = i3 + 1;
            } else {
                if (i >= aVar.c) {
                    if (d || aVar.f4388b != 0) {
                        return aVar;
                    }
                    throw new AssertionError();
                }
                size = i3 - 1;
            }
        }
        throw new Error("should not reach here");
    }

    @Override // io.netty.b.i
    public int N() {
        switch (this.i.size()) {
            case 0:
                return 1;
            case 1:
                return this.i.get(0).f4387a.N();
            default:
                int size = this.i.size();
                int iN = 0;
                for (int i = 0; i < size; i++) {
                    iN += this.i.get(i).f4387a.N();
                }
                return iN;
        }
    }

    @Override // io.netty.b.i
    public ByteBuffer l(int i, int i2) {
        switch (this.i.size()) {
            case 0:
                return e;
            case 1:
                return this.i.get(0).f4387a.l(i, i2);
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // io.netty.b.i
    public ByteBuffer m(int i, int i2) {
        i(i, i2);
        switch (this.i.size()) {
            case 0:
                return e;
            case 1:
                if (this.i.get(0).f4387a.N() == 1) {
                    return this.i.get(0).f4387a.m(i, i2);
                }
                break;
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i2).order(G());
        for (ByteBuffer byteBuffer : n(i, i2)) {
            byteBufferOrder.put(byteBuffer);
        }
        byteBufferOrder.flip();
        return byteBufferOrder;
    }

    @Override // io.netty.b.i
    public ByteBuffer[] n(int i, int i2) {
        i(i, i2);
        if (i2 == 0) {
            return new ByteBuffer[]{e};
        }
        ArrayList arrayList = new ArrayList(this.i.size());
        int iJ = J(i);
        while (i2 > 0) {
            a aVar = this.i.get(iJ);
            i iVar = aVar.f4387a;
            int i3 = i - aVar.c;
            int iMin = Math.min(i2, iVar.Q() - i3);
            switch (iVar.N()) {
                case 0:
                    throw new UnsupportedOperationException();
                case 1:
                    arrayList.add(iVar.m(i3, iMin));
                    break;
                default:
                    Collections.addAll(arrayList, iVar.n(i3, iMin));
                    break;
            }
            i += iMin;
            i2 -= iMin;
            iJ++;
        }
        return (ByteBuffer[]) arrayList.toArray(new ByteBuffer[arrayList.size()]);
    }

    public m P() {
        A();
        int iB = b();
        if (iB == 0) {
            return this;
        }
        int iC = c();
        if (iB == iC && iC == Q()) {
            Iterator<a> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.i.clear();
            a(0, 0);
            d(iB);
            return this;
        }
        int iJ = J(iB);
        for (int i = 0; i < iJ; i++) {
            this.i.get(i).a();
        }
        this.i.subList(0, iJ).clear();
        int i2 = this.i.get(0).c;
        O(0);
        a(iB - i2, iC - i2);
        d(i2);
        return this;
    }

    private i Q(int i) {
        return this.h ? F().d(i) : F().c(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public String toString() {
        return super.toString().substring(0, r0.length() - 1) + ", components=" + this.i.size() + ')';
    }

    /* compiled from: CompositeByteBuf.java */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        final i f4387a;

        /* renamed from: b, reason: collision with root package name */
        final int f4388b;
        int c;
        int d;

        a(i iVar) {
            this.f4387a = iVar;
            this.f4388b = iVar.g();
        }

        void a() {
            this.f4387a.D();
        }
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public m b(int i) {
        return (m) super.b(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public m c(int i) {
        return (m) super.c(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public m a(int i, int i2) {
        return (m) super.a(i, i2);
    }

    @Override // io.netty.b.a
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public m d() {
        return (m) super.d();
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public m j() {
        return (m) super.j();
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public m k() {
        return (m) super.k();
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public m e(int i) {
        return (m) super.e(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m a(byte[] bArr) {
        return (m) super.a(bArr);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m a(byte[] bArr, int i, int i2) {
        return (m) super.a(bArr, i, i2);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m a(OutputStream outputStream, int i) {
        return (m) super.a(outputStream, i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m a(boolean z) {
        return (m) super.a(z);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public m v(int i) {
        return (m) super.v(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public m w(int i) {
        return (m) super.w(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public m x(int i) {
        return (m) super.x(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m a(long j) {
        return (m) super.a(j);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public m y(int i) {
        return (m) super.y(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m a(float f2) {
        return (m) super.a(f2);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m a(double d2) {
        return (m) super.a(d2);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m a(i iVar) {
        return (m) super.a(iVar);
    }

    @Override // io.netty.b.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m a(i iVar, int i) {
        return (m) super.a(iVar, i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m a(i iVar, int i, int i2) {
        return (m) super.a(iVar, i, i2);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public m b(byte[] bArr) {
        return (m) super.b(bArr);
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public m b(byte[] bArr, int i, int i2) {
        return (m) super.b(bArr, i, i2);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public ByteBuffer[] z() {
        return n(b(), g());
    }

    @Override // io.netty.b.a, io.netty.b.i
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public m l() {
        return P();
    }

    @Override // io.netty.b.d
    protected void E() {
        if (this.k) {
            return;
        }
        this.k = true;
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            this.i.get(i).a();
        }
    }

    /* compiled from: CompositeByteBuf.java */
    private final class b implements Iterator<i> {

        /* renamed from: b, reason: collision with root package name */
        private final int f4390b;
        private int c;

        private b() {
            this.f4390b = m.this.i.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4390b > this.c;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i next() {
            if (this.f4390b != m.this.i.size()) {
                throw new ConcurrentModificationException();
            }
            if (hasNext()) {
                try {
                    List list = m.this.i;
                    int i = this.c;
                    this.c = i + 1;
                    return ((a) list.get(i)).f4387a;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ConcurrentModificationException();
                }
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-Only");
        }
    }
}
