package b;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: Buffer.java */
/* loaded from: classes.dex */
public final class c implements d, e, Cloneable, ByteChannel {
    private static final byte[] c = {48, 49, 50, 51, Constants.MobIds.SPIDER, Constants.MobIds.GIANT_ZOMBIE, Constants.MobIds.ZOMBIE, Constants.MobIds.SLIME, Constants.MobIds.GHAST, Constants.MobIds.ZOMBIE_PIGMAN, Constants.MobIds.SNOWMAN, Constants.MobIds.OCELOT, Constants.MobIds.IRON_GOLEM, 100, 101, Constants.AnimationIds.UNKNOWN};

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    o f1164a;

    /* renamed from: b, reason: collision with root package name */
    long f1165b;

    @Override // b.d, b.e
    public c c() {
        return this;
    }

    @Override // b.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // b.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c v() {
        return this;
    }

    @Override // b.d, b.r, java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public long b() {
        return this.f1165b;
    }

    @Override // b.e
    public boolean e() {
        return this.f1165b == 0;
    }

    @Override // b.e
    public void a(long j) throws EOFException {
        if (this.f1165b < j) {
            throw new EOFException();
        }
    }

    @Override // b.e
    public InputStream f() {
        return new InputStream() { // from class: b.c.1
            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (c.this.f1165b > 0) {
                    return c.this.h() & Constants.DimensionIds.NETHER;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return c.this.a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(c.this.f1165b, 2147483647L);
            }

            public String toString() {
                return c.this + ".inputStream()";
            }
        };
    }

    public c a(c cVar, long j, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        u.a(this.f1165b, j, j2);
        if (j2 == 0) {
            return this;
        }
        cVar.f1165b += j2;
        o oVar = this.f1164a;
        while (j >= oVar.c - oVar.f1188b) {
            j -= oVar.c - oVar.f1188b;
            oVar = oVar.f;
        }
        while (j2 > 0) {
            o oVarA = oVar.a();
            oVarA.f1188b = (int) (oVarA.f1188b + j);
            oVarA.c = Math.min(oVarA.f1188b + ((int) j2), oVarA.c);
            if (cVar.f1164a == null) {
                oVarA.g = oVarA;
                oVarA.f = oVarA;
                cVar.f1164a = oVarA;
            } else {
                cVar.f1164a.g.a(oVarA);
            }
            j2 -= oVarA.c - oVarA.f1188b;
            oVar = oVar.f;
            j = 0;
        }
        return this;
    }

    public long g() {
        long j = this.f1165b;
        if (j == 0) {
            return 0L;
        }
        o oVar = this.f1164a.g;
        return (oVar.c >= 8192 || !oVar.e) ? j : j - (oVar.c - oVar.f1188b);
    }

    @Override // b.e
    public byte h() {
        if (this.f1165b == 0) {
            throw new IllegalStateException("size == 0");
        }
        o oVar = this.f1164a;
        int i = oVar.f1188b;
        int i2 = oVar.c;
        int i3 = i + 1;
        byte b2 = oVar.f1187a[i];
        this.f1165b--;
        if (i3 == i2) {
            this.f1164a = oVar.b();
            p.a(oVar);
        } else {
            oVar.f1188b = i3;
        }
        return b2;
    }

    public byte b(long j) {
        u.a(this.f1165b, j, 1L);
        if (this.f1165b - j > j) {
            o oVar = this.f1164a;
            while (true) {
                long j2 = oVar.c - oVar.f1188b;
                if (j >= j2) {
                    j -= j2;
                    oVar = oVar.f;
                } else {
                    return oVar.f1187a[oVar.f1188b + ((int) j)];
                }
            }
        } else {
            long j3 = j - this.f1165b;
            o oVar2 = this.f1164a;
            do {
                oVar2 = oVar2.g;
                j3 += oVar2.c - oVar2.f1188b;
            } while (j3 < 0);
            return oVar2.f1187a[oVar2.f1188b + ((int) j3)];
        }
    }

    @Override // b.e
    public short i() {
        if (this.f1165b < 2) {
            throw new IllegalStateException("size < 2: " + this.f1165b);
        }
        o oVar = this.f1164a;
        int i = oVar.f1188b;
        int i2 = oVar.c;
        if (i2 - i < 2) {
            return (short) (((h() & Constants.DimensionIds.NETHER) << 8) | (h() & Constants.DimensionIds.NETHER));
        }
        byte[] bArr = oVar.f1187a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & Constants.DimensionIds.NETHER) << 8) | (bArr[i3] & Constants.DimensionIds.NETHER);
        this.f1165b -= 2;
        if (i4 == i2) {
            this.f1164a = oVar.b();
            p.a(oVar);
        } else {
            oVar.f1188b = i4;
        }
        return (short) i5;
    }

    @Override // b.e
    public int j() {
        if (this.f1165b < 4) {
            throw new IllegalStateException("size < 4: " + this.f1165b);
        }
        o oVar = this.f1164a;
        int i = oVar.f1188b;
        int i2 = oVar.c;
        if (i2 - i < 4) {
            return ((h() & Constants.DimensionIds.NETHER) << 24) | ((h() & Constants.DimensionIds.NETHER) << 16) | ((h() & Constants.DimensionIds.NETHER) << 8) | (h() & Constants.DimensionIds.NETHER);
        }
        byte[] bArr = oVar.f1187a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & Constants.DimensionIds.NETHER) << 24) | ((bArr[i3] & Constants.DimensionIds.NETHER) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & Constants.DimensionIds.NETHER) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & Constants.DimensionIds.NETHER);
        this.f1165b -= 4;
        if (i8 == i2) {
            this.f1164a = oVar.b();
            p.a(oVar);
        } else {
            oVar.f1188b = i8;
        }
        return i9;
    }

    @Override // b.e
    public short k() {
        return u.a(i());
    }

    @Override // b.e
    public int l() {
        return u.a(j());
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ae A[EDGE_INSN: B:49:0x00ae->B:39:0x00ae BREAK  A[LOOP:0: B:5:0x0010->B:51:?], SYNTHETIC] */
    @Override // b.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long m() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.f1165b
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Lb9
            r5 = -7
            r7 = 0
            r8 = r5
            r5 = 0
            r6 = 0
        L10:
            b.o r10 = r0.f1164a
            byte[] r11 = r10.f1187a
            int r12 = r10.f1188b
            int r13 = r10.c
        L18:
            if (r12 >= r13) goto L9a
            r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L6c
            r1 = 57
            if (r15 > r1) goto L6c
            int r14 = r14 - r15
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L3f
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 != 0) goto L38
            long r1 = (long) r14
            int r16 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r16 >= 0) goto L38
            goto L3f
        L38:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L76
        L3f:
            b.c r1 = new b.c
            r1.<init>()
            b.c r1 = r1.l(r3)
            b.c r1 = r1.i(r15)
            if (r5 != 0) goto L51
            r1.h()
        L51:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.p()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L6c:
            r1 = 45
            if (r15 != r1) goto L7b
            if (r7 != 0) goto L7b
            r1 = 1
            long r8 = r8 - r1
            r5 = 1
        L76:
            int r12 = r12 + 1
            int r7 = r7 + 1
            goto L18
        L7b:
            if (r7 == 0) goto L7f
            r6 = 1
            goto L9a
        L7f:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L9a:
            if (r12 != r13) goto La6
            b.o r1 = r10.b()
            r0.f1164a = r1
            b.p.a(r10)
            goto La8
        La6:
            r10.f1188b = r12
        La8:
            if (r6 != 0) goto Lae
            b.o r1 = r0.f1164a
            if (r1 != 0) goto L10
        Lae:
            long r1 = r0.f1165b
            long r6 = (long) r7
            long r1 = r1 - r6
            r0.f1165b = r1
            if (r5 == 0) goto Lb7
            goto Lb8
        Lb7:
            long r3 = -r3
        Lb8:
            return r3
        Lb9:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.m():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a6 A[EDGE_INSN: B:43:0x00a6->B:37:0x00a6 BREAK  A[LOOP:0: B:5:0x000b->B:45:?], SYNTHETIC] */
    @Override // b.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long n() {
        /*
            r15 = this;
            long r0 = r15.f1165b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lad
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            b.o r6 = r15.f1164a
            byte[] r7 = r6.f1187a
            int r8 = r6.f1188b
            int r9 = r6.c
        L13:
            if (r8 >= r9) goto L92
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3b
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
            int r11 = r11 + 10
            goto L3b
        L2f:
            r11 = 65
            if (r10 < r11) goto L73
            r11 = 70
            if (r10 > r11) goto L73
            int r11 = r10 + (-65)
            int r11 = r11 + 10
        L3b:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4b
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L4b:
            b.c r0 = new b.c
            r0.<init>()
            b.c r0 = r0.k(r4)
            b.c r0 = r0.i(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.p()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L73:
            if (r0 == 0) goto L77
            r1 = 1
            goto L92
        L77:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L92:
            if (r8 != r9) goto L9e
            b.o r7 = r6.b()
            r15.f1164a = r7
            b.p.a(r6)
            goto La0
        L9e:
            r6.f1188b = r8
        La0:
            if (r1 != 0) goto La6
            b.o r6 = r15.f1164a
            if (r6 != 0) goto Lb
        La6:
            long r1 = r15.f1165b
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.f1165b = r1
            return r4
        Lad:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.n():long");
    }

    public f o() {
        return new f(r());
    }

    @Override // b.e
    public f c(long j) {
        return new f(g(j));
    }

    public String p() {
        try {
            return a(this.f1165b, u.f1193a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String d(long j) {
        return a(j, u.f1193a);
    }

    public String a(long j, Charset charset) {
        u.a(this.f1165b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return BuildConfig.FLAVOR;
        }
        o oVar = this.f1164a;
        if (oVar.f1188b + j > oVar.c) {
            return new String(g(j), charset);
        }
        String str = new String(oVar.f1187a, oVar.f1188b, (int) j, charset);
        oVar.f1188b = (int) (oVar.f1188b + j);
        this.f1165b -= j;
        if (oVar.f1188b == oVar.c) {
            this.f1164a = oVar.b();
            p.a(oVar);
        }
        return str;
    }

    @Override // b.e
    public String q() {
        return e(Long.MAX_VALUE);
    }

    @Override // b.e
    public String e(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jA = a((byte) 10, 0L, j2);
        if (jA != -1) {
            return f(jA);
        }
        if (j2 < b() && b(j2 - 1) == 13 && b(j2) == 10) {
            return f(j2);
        }
        c cVar = new c();
        a(cVar, 0L, Math.min(32L, b()));
        throw new EOFException("\\n not found: limit=" + Math.min(b(), j) + " content=" + cVar.o().f() + (char) 8230);
    }

    String f(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (b(j2) == 13) {
                String strD = d(j2);
                h(2L);
                return strD;
            }
        }
        String strD2 = d(j);
        h(1L);
        return strD2;
    }

    @Override // b.e
    public byte[] r() {
        try {
            return g(this.f1165b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // b.e
    public byte[] g(long j) throws EOFException {
        u.a(this.f1165b, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[(int) j];
        a(bArr);
        return bArr;
    }

    @Override // b.e
    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iA = a(bArr, i, bArr.length - i);
            if (iA == -1) {
                throw new EOFException();
            }
            i += iA;
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        u.a(bArr.length, i, i2);
        o oVar = this.f1164a;
        if (oVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, oVar.c - oVar.f1188b);
        System.arraycopy(oVar.f1187a, oVar.f1188b, bArr, i, iMin);
        oVar.f1188b += iMin;
        this.f1165b -= iMin;
        if (oVar.f1188b == oVar.c) {
            this.f1164a = oVar.b();
            p.a(oVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        o oVar = this.f1164a;
        if (oVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), oVar.c - oVar.f1188b);
        byteBuffer.put(oVar.f1187a, oVar.f1188b, iMin);
        oVar.f1188b += iMin;
        this.f1165b -= iMin;
        if (oVar.f1188b == oVar.c) {
            this.f1164a = oVar.b();
            p.a(oVar);
        }
        return iMin;
    }

    public void s() {
        try {
            h(this.f1165b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // b.e
    public void h(long j) throws EOFException {
        while (j > 0) {
            if (this.f1164a == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, this.f1164a.c - this.f1164a.f1188b);
            long j2 = iMin;
            this.f1165b -= j2;
            j -= j2;
            this.f1164a.f1188b += iMin;
            if (this.f1164a.f1188b == this.f1164a.c) {
                o oVar = this.f1164a;
                this.f1164a = oVar.b();
                p.a(oVar);
            }
        }
    }

    public c a(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        fVar.a(this);
        return this;
    }

    @Override // b.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c b(String str) {
        return a(str, 0, str.length());
    }

    public c a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                o oVarE = e(1);
                byte[] bArr = oVarE.f1187a;
                int i3 = oVarE.c - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt;
                while (i4 < iMin) {
                    char cCharAt2 = str.charAt(i4);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i4 + i3] = (byte) cCharAt2;
                    i4++;
                }
                int i5 = (i3 + i4) - oVarE.c;
                oVarE.c += i5;
                this.f1165b += i5;
                i = i4;
            } else if (cCharAt < 2048) {
                i((cCharAt >> 6) | 192);
                i((cCharAt & '?') | 128);
                i++;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                i((cCharAt >> '\f') | 224);
                i(((cCharAt >> 6) & 63) | 128);
                i((cCharAt & '?') | 128);
                i++;
            } else {
                int i6 = i + 1;
                char cCharAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                    i(63);
                    i = i6;
                } else {
                    int i7 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                    i((i7 >> 18) | 240);
                    i(((i7 >> 12) & 63) | 128);
                    i(((i7 >> 6) & 63) | 128);
                    i((i7 & 63) | 128);
                    i += 2;
                }
            }
        }
        return this;
    }

    public c a(int i) {
        if (i < 128) {
            i(i);
        } else if (i < 2048) {
            i((i >> 6) | 192);
            i((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                i(63);
            } else {
                i((i >> 12) | 224);
                i(((i >> 6) & 63) | 128);
                i((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            i((i >> 18) | 240);
            i(((i >> 12) & 63) | 128);
            i(((i >> 6) & 63) | 128);
            i((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public c a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 <= str.length()) {
            if (charset == null) {
                throw new IllegalArgumentException("charset == null");
            }
            if (charset.equals(u.f1193a)) {
                return a(str, i, i2);
            }
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return c(bytes, 0, bytes.length);
        }
        throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
    }

    @Override // b.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c c(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return c(bArr, 0, bArr.length);
    }

    @Override // b.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c c(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        u.a(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            o oVarE = e(1);
            int iMin = Math.min(i3 - i, 8192 - oVarE.c);
            System.arraycopy(bArr, i, oVarE.f1187a, oVarE.c, iMin);
            i += iMin;
            oVarE.c += iMin;
        }
        this.f1165b += j;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            o oVarE = e(1);
            int iMin = Math.min(i, 8192 - oVarE.c);
            byteBuffer.get(oVarE.f1187a, oVarE.c, iMin);
            i -= iMin;
            oVarE.c += iMin;
        }
        this.f1165b += iRemaining;
        return iRemaining;
    }

    public long a(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jA = sVar.a(this, 8192L);
            if (jA == -1) {
                return j;
            }
            j += jA;
        }
    }

    @Override // b.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c i(int i) {
        o oVarE = e(1);
        byte[] bArr = oVarE.f1187a;
        int i2 = oVarE.c;
        oVarE.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f1165b++;
        return this;
    }

    @Override // b.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c h(int i) {
        o oVarE = e(2);
        byte[] bArr = oVarE.f1187a;
        int i2 = oVarE.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        oVarE.c = i3 + 1;
        this.f1165b += 2;
        return this;
    }

    @Override // b.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c g(int i) {
        o oVarE = e(4);
        byte[] bArr = oVarE.f1187a;
        int i2 = oVarE.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        oVarE.c = i5 + 1;
        this.f1165b += 4;
        return this;
    }

    @Override // b.d
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public c l(long j) {
        if (j == 0) {
            return i(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        o oVarE = e(i);
        byte[] bArr = oVarE.f1187a;
        int i2 = oVarE.c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        oVarE.c += i;
        this.f1165b += i;
        return this;
    }

    @Override // b.d
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public c k(long j) {
        if (j == 0) {
            return i(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        o oVarE = e(iNumberOfTrailingZeros);
        byte[] bArr = oVarE.f1187a;
        int i = oVarE.c;
        for (int i2 = (oVarE.c + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        oVarE.c += iNumberOfTrailingZeros;
        this.f1165b += iNumberOfTrailingZeros;
        return this;
    }

    o e(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        if (this.f1164a == null) {
            this.f1164a = p.a();
            o oVar = this.f1164a;
            o oVar2 = this.f1164a;
            o oVar3 = this.f1164a;
            oVar2.g = oVar3;
            oVar.f = oVar3;
            return oVar3;
        }
        o oVar4 = this.f1164a.g;
        return (oVar4.c + i > 8192 || !oVar4.e) ? oVar4.a(p.a()) : oVar4;
    }

    @Override // b.r
    public void a_(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        u.a(cVar.f1165b, 0L, j);
        while (j > 0) {
            if (j < cVar.f1164a.c - cVar.f1164a.f1188b) {
                o oVar = this.f1164a != null ? this.f1164a.g : null;
                if (oVar != null && oVar.e) {
                    if ((oVar.c + j) - (oVar.d ? 0 : oVar.f1188b) <= 8192) {
                        cVar.f1164a.a(oVar, (int) j);
                        cVar.f1165b -= j;
                        this.f1165b += j;
                        return;
                    }
                }
                cVar.f1164a = cVar.f1164a.a((int) j);
            }
            o oVar2 = cVar.f1164a;
            long j2 = oVar2.c - oVar2.f1188b;
            cVar.f1164a = oVar2.b();
            if (this.f1164a == null) {
                this.f1164a = oVar2;
                o oVar3 = this.f1164a;
                o oVar4 = this.f1164a;
                o oVar5 = this.f1164a;
                oVar4.g = oVar5;
                oVar3.f = oVar5;
            } else {
                this.f1164a.g.a(oVar2).c();
            }
            cVar.f1165b -= j2;
            this.f1165b += j2;
            j -= j2;
        }
    }

    @Override // b.s
    public long a(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f1165b == 0) {
            return -1L;
        }
        if (j > this.f1165b) {
            j = this.f1165b;
        }
        cVar.a_(this, j);
        return j;
    }

    @Override // b.e
    public long a(byte b2) {
        return a(b2, 0L, Long.MAX_VALUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long a(byte r11, long r12, long r14) {
        /*
            r10 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 < 0) goto L78
            int r2 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r2 < 0) goto L78
            long r2 = r10.f1165b
            int r4 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r4 <= 0) goto L12
            long r14 = r10.f1165b
        L12:
            r2 = -1
            int r4 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r4 != 0) goto L19
            return r2
        L19:
            b.o r4 = r10.f1164a
            if (r4 != 0) goto L1e
            return r2
        L1e:
            long r5 = r10.f1165b
            long r5 = r5 - r12
            int r7 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r7 >= 0) goto L35
            long r0 = r10.f1165b
        L27:
            int r5 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r5 <= 0) goto L44
            b.o r4 = r4.g
            int r5 = r4.c
            int r6 = r4.f1188b
            int r5 = r5 - r6
            long r5 = (long) r5
            long r0 = r0 - r5
            goto L27
        L35:
            int r5 = r4.c
            int r6 = r4.f1188b
            int r5 = r5 - r6
            long r5 = (long) r5
            long r5 = r5 + r0
            int r7 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r7 >= 0) goto L44
            b.o r4 = r4.f
            r0 = r5
            goto L35
        L44:
            int r5 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r5 >= 0) goto L77
            byte[] r5 = r4.f1187a
            int r6 = r4.c
            long r6 = (long) r6
            int r8 = r4.f1188b
            long r8 = (long) r8
            long r8 = r8 + r14
            long r8 = r8 - r0
            long r6 = java.lang.Math.min(r6, r8)
            int r6 = (int) r6
            int r7 = r4.f1188b
            long r7 = (long) r7
            long r7 = r7 + r12
            long r7 = r7 - r0
            int r12 = (int) r7
        L5d:
            if (r12 >= r6) goto L6c
            r13 = r5[r12]
            if (r13 != r11) goto L69
            int r11 = r4.f1188b
            int r12 = r12 - r11
            long r11 = (long) r12
            long r11 = r11 + r0
            return r11
        L69:
            int r12 = r12 + 1
            goto L5d
        L6c:
            int r12 = r4.c
            int r13 = r4.f1188b
            int r12 = r12 - r13
            long r12 = (long) r12
            long r12 = r12 + r0
            b.o r4 = r4.f
            r0 = r12
            goto L44
        L77:
            return r2
        L78:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            long r2 = r10.f1165b
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r0[r1] = r2
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            r13 = 1
            r0[r13] = r12
            r12 = 2
            java.lang.Long r13 = java.lang.Long.valueOf(r14)
            r0[r12] = r13
            java.lang.String r12 = "size=%s fromIndex=%s toIndex=%s"
            java.lang.String r12 = java.lang.String.format(r12, r0)
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.a(byte, long, long):long");
    }

    @Override // b.e
    public boolean a(long j, f fVar) {
        return a(j, fVar, 0, fVar.h());
    }

    public boolean a(long j, f fVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f1165b - j < i2 || fVar.h() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (b(i3 + j) != fVar.a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // b.r
    public t a() {
        return t.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f1165b != cVar.f1165b) {
            return false;
        }
        long j = 0;
        if (this.f1165b == 0) {
            return true;
        }
        o oVar = this.f1164a;
        o oVar2 = cVar.f1164a;
        int i = oVar.f1188b;
        int i2 = oVar2.f1188b;
        while (j < this.f1165b) {
            long jMin = Math.min(oVar.c - i, oVar2.c - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (i5 < jMin) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (oVar.f1187a[i4] != oVar2.f1187a[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == oVar.c) {
                oVar = oVar.f;
                i = oVar.f1188b;
            } else {
                i = i4;
            }
            if (i3 == oVar2.c) {
                oVar2 = oVar2.f;
                i2 = oVar2.f1188b;
            } else {
                i2 = i3;
            }
            j += jMin;
        }
        return true;
    }

    public int hashCode() {
        o oVar = this.f1164a;
        if (oVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = oVar.c;
            for (int i3 = oVar.f1188b; i3 < i2; i3++) {
                i = (i * 31) + oVar.f1187a[i3];
            }
            oVar = oVar.f;
        } while (oVar != this.f1164a);
        return i;
    }

    public String toString() {
        return u().toString();
    }

    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public c clone() {
        c cVar = new c();
        if (this.f1165b == 0) {
            return cVar;
        }
        cVar.f1164a = this.f1164a.a();
        o oVar = cVar.f1164a;
        o oVar2 = cVar.f1164a;
        o oVar3 = cVar.f1164a;
        oVar2.g = oVar3;
        oVar.f = oVar3;
        o oVar4 = this.f1164a;
        while (true) {
            oVar4 = oVar4.f;
            if (oVar4 != this.f1164a) {
                cVar.f1164a.g.a(oVar4.a());
            } else {
                cVar.f1165b = this.f1165b;
                return cVar;
            }
        }
    }

    public f u() {
        if (this.f1165b > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f1165b);
        }
        return f((int) this.f1165b);
    }

    public f f(int i) {
        if (i == 0) {
            return f.f1168b;
        }
        return new q(this, i);
    }
}
