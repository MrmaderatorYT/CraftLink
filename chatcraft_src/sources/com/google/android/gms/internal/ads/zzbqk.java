package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class zzbqk extends apn {

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f3658b = Logger.getLogger(zzbqk.class.getName());
    private static final boolean c = atv.a();

    /* renamed from: a, reason: collision with root package name */
    aqg f3659a;

    public static zzbqk a(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int b(double d2) {
        return 8;
    }

    public static int b(float f) {
        return 4;
    }

    public static int b(boolean z) {
        return 1;
    }

    public static int e(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int g(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int g(long j) {
        return 8;
    }

    public static int h(long j) {
        return 8;
    }

    public static int i(int i) {
        return 4;
    }

    private static long i(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int j(int i) {
        return 4;
    }

    private static int m(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract void a();

    public abstract void a(byte b2);

    public abstract void a(int i);

    public abstract void a(int i, int i2);

    public abstract void a(int i, long j);

    public abstract void a(int i, apo apoVar);

    public abstract void a(int i, asf asfVar);

    abstract void a(int i, asf asfVar, asx asxVar);

    public abstract void a(int i, String str);

    public abstract void a(int i, boolean z);

    public abstract void a(long j);

    public abstract void a(apo apoVar);

    public abstract void a(asf asfVar);

    abstract void a(asf asfVar, asx asxVar);

    public abstract void a(String str);

    public abstract int b();

    public abstract void b(int i);

    public abstract void b(int i, int i2);

    public abstract void b(int i, apo apoVar);

    public abstract void b(int i, asf asfVar);

    public abstract void b(byte[] bArr, int i, int i2);

    public abstract void c(int i, int i2);

    public abstract void c(int i, long j);

    public abstract void c(long j);

    abstract void c(byte[] bArr, int i, int i2);

    public abstract void d(int i);

    public abstract void e(int i, int i2);

    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        zzc(String str) {
            String strValueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            String strValueOf2 = String.valueOf(str);
            super(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        zzc(String str, Throwable th) {
            String strValueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            String strValueOf2 = String.valueOf(str);
            super(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf), th);
        }
    }

    public static zzbqk a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            if (atv.b()) {
                return new d(byteBuffer);
            }
            return new c(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    static final class b extends a {

        /* renamed from: b, reason: collision with root package name */
        private final ByteBuffer f3661b;
        private int c;

        b(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.f3661b = byteBuffer;
            this.c = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.ads.zzbqk.a, com.google.android.gms.internal.ads.zzbqk
        public final void a() {
            this.f3661b.position(this.c + e());
        }
    }

    static final class c extends zzbqk {

        /* renamed from: b, reason: collision with root package name */
        private final ByteBuffer f3662b;
        private final ByteBuffer c;
        private final int d;

        c(ByteBuffer byteBuffer) {
            super();
            this.f3662b = byteBuffer;
            this.c = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.d = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, int i2) {
            b((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void b(int i, int i2) {
            a(i, 0);
            a(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void c(int i, int i2) {
            a(i, 0);
            b(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void e(int i, int i2) {
            a(i, 5);
            d(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, long j) {
            a(i, 0);
            a(j);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void c(int i, long j) {
            a(i, 1);
            c(j);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, boolean z) {
            a(i, 0);
            a(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, String str) {
            a(i, 2);
            a(str);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, apo apoVar) {
            a(i, 2);
            a(apoVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, asf asfVar) {
            a(i, 2);
            a(asfVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        final void a(int i, asf asfVar, asx asxVar) {
            a(i, 2);
            a(asfVar, asxVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void b(int i, asf asfVar) {
            a(1, 3);
            c(2, i);
            a(3, asfVar);
            a(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void b(int i, apo apoVar) {
            a(1, 3);
            c(2, i);
            a(3, apoVar);
            a(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(asf asfVar) {
            b(asfVar.l());
            asfVar.a(this);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        final void a(asf asfVar, asx asxVar) {
            apf apfVar = (apf) asfVar;
            int iJ = apfVar.j();
            if (iJ == -1) {
                iJ = asxVar.b(apfVar);
                apfVar.a(iJ);
            }
            b(iJ);
            asxVar.a((asx) asfVar, (auk) this.f3659a);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(byte b2) throws zzc {
            try {
                this.c.put(b2);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(apo apoVar) {
            b(apoVar.a());
            apoVar.a(this);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void c(byte[] bArr, int i, int i2) {
            b(i2);
            b(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i) {
            if (i >= 0) {
                b(i);
            } else {
                a(i);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void b(int i) throws zzc {
            while ((i & (-128)) != 0) {
                try {
                    this.c.put((byte) ((i & 127) | 128));
                    i >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new zzc(e);
                }
            }
            this.c.put((byte) i);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void d(int i) throws zzc {
            try {
                this.c.putInt(i);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(long j) throws zzc {
            while (((-128) & j) != 0) {
                try {
                    this.c.put((byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new zzc(e);
                }
            }
            this.c.put((byte) j);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void c(long j) throws zzc {
            try {
                this.c.putLong(j);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void b(byte[] bArr, int i, int i2) throws zzc {
            try {
                this.c.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(e);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.apn
        public final void a(byte[] bArr, int i, int i2) {
            b(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(String str) throws zzc {
            int iPosition = this.c.position();
            try {
                int iG = g(str.length() * 3);
                int iG2 = g(str.length());
                if (iG2 == iG) {
                    int iPosition2 = this.c.position() + iG2;
                    this.c.position(iPosition2);
                    c(str);
                    int iPosition3 = this.c.position();
                    this.c.position(iPosition);
                    b(iPosition3 - iPosition2);
                    this.c.position(iPosition3);
                    return;
                }
                b(atx.a(str));
                c(str);
            } catch (aub e) {
                this.c.position(iPosition);
                a(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a() {
            this.f3662b.position(this.c.position());
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final int b() {
            return this.c.remaining();
        }

        private final void c(String str) throws zzc {
            try {
                atx.a(str, this.c);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(e);
            }
        }
    }

    static final class d extends zzbqk {

        /* renamed from: b, reason: collision with root package name */
        private final ByteBuffer f3663b;
        private final ByteBuffer c;
        private final long d;
        private final long e;
        private final long f;
        private final long g;
        private long h;

        d(ByteBuffer byteBuffer) {
            super();
            this.f3663b = byteBuffer;
            this.c = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.d = atv.a(byteBuffer);
            this.e = this.d + byteBuffer.position();
            this.f = this.d + byteBuffer.limit();
            this.g = this.f - 10;
            this.h = this.e;
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, int i2) {
            b((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void b(int i, int i2) {
            a(i, 0);
            a(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void c(int i, int i2) {
            a(i, 0);
            b(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void e(int i, int i2) {
            a(i, 5);
            d(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, long j) {
            a(i, 0);
            a(j);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void c(int i, long j) {
            a(i, 1);
            c(j);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, boolean z) {
            a(i, 0);
            a(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, String str) {
            a(i, 2);
            a(str);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, apo apoVar) {
            a(i, 2);
            a(apoVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, asf asfVar) {
            a(i, 2);
            a(asfVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        final void a(int i, asf asfVar, asx asxVar) {
            a(i, 2);
            a(asfVar, asxVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void b(int i, asf asfVar) {
            a(1, 3);
            c(2, i);
            a(3, asfVar);
            a(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void b(int i, apo apoVar) {
            a(1, 3);
            c(2, i);
            a(3, apoVar);
            a(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(asf asfVar) {
            b(asfVar.l());
            asfVar.a(this);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        final void a(asf asfVar, asx asxVar) {
            apf apfVar = (apf) asfVar;
            int iJ = apfVar.j();
            if (iJ == -1) {
                iJ = asxVar.b(apfVar);
                apfVar.a(iJ);
            }
            b(iJ);
            asxVar.a((asx) asfVar, (auk) this.f3659a);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(byte b2) throws zzc {
            if (this.h >= this.f) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.h), Long.valueOf(this.f), 1));
            }
            long j = this.h;
            this.h = 1 + j;
            atv.a(j, b2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(apo apoVar) {
            b(apoVar.a());
            apoVar.a(this);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void c(byte[] bArr, int i, int i2) {
            b(i2);
            b(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i) {
            if (i >= 0) {
                b(i);
            } else {
                a(i);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void b(int i) throws zzc {
            if (this.h <= this.g) {
                while ((i & (-128)) != 0) {
                    long j = this.h;
                    this.h = j + 1;
                    atv.a(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                long j2 = this.h;
                this.h = 1 + j2;
                atv.a(j2, (byte) i);
                return;
            }
            while (this.h < this.f) {
                if ((i & (-128)) == 0) {
                    long j3 = this.h;
                    this.h = 1 + j3;
                    atv.a(j3, (byte) i);
                    return;
                } else {
                    long j4 = this.h;
                    this.h = j4 + 1;
                    atv.a(j4, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.h), Long.valueOf(this.f), 1));
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void d(int i) {
            this.c.putInt((int) (this.h - this.d), i);
            this.h += 4;
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(long j) throws zzc {
            if (this.h <= this.g) {
                while ((j & (-128)) != 0) {
                    long j2 = this.h;
                    this.h = j2 + 1;
                    atv.a(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                long j3 = this.h;
                this.h = 1 + j3;
                atv.a(j3, (byte) j);
                return;
            }
            while (this.h < this.f) {
                if ((j & (-128)) == 0) {
                    long j4 = this.h;
                    this.h = 1 + j4;
                    atv.a(j4, (byte) j);
                    return;
                } else {
                    long j5 = this.h;
                    this.h = j5 + 1;
                    atv.a(j5, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.h), Long.valueOf(this.f), 1));
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void c(long j) {
            this.c.putLong((int) (this.h - this.d), j);
            this.h += 8;
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void b(byte[] bArr, int i, int i2) throws zzc {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = i2;
                if (this.f - j >= this.h) {
                    atv.a(bArr, i, this.h, j);
                    this.h += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.h), Long.valueOf(this.f), Integer.valueOf(i2)));
        }

        @Override // com.google.android.gms.internal.ads.apn
        public final void a(byte[] bArr, int i, int i2) {
            b(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(String str) throws zzc {
            long j = this.h;
            try {
                int iG = g(str.length() * 3);
                int iG2 = g(str.length());
                if (iG2 == iG) {
                    int i = ((int) (this.h - this.d)) + iG2;
                    this.c.position(i);
                    atx.a(str, this.c);
                    int iPosition = this.c.position() - i;
                    b(iPosition);
                    this.h += iPosition;
                    return;
                }
                int iA = atx.a(str);
                b(iA);
                i(this.h);
                atx.a(str, this.c);
                this.h += iA;
            } catch (aub e) {
                this.h = j;
                i(this.h);
                a(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc(e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a() {
            this.f3663b.position((int) (this.h - this.d));
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final int b() {
            return (int) (this.f - this.h);
        }

        private final void i(long j) {
            this.c.position((int) (j - this.d));
        }
    }

    static class a extends zzbqk {

        /* renamed from: b, reason: collision with root package name */
        private final byte[] f3660b;
        private final int c;
        private final int d;
        private int e;

        a(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i3 = i + i2;
            if ((i | i2 | (bArr.length - i3)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            this.f3660b = bArr;
            this.c = i;
            this.e = i;
            this.d = i3;
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public void a() {
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, int i2) {
            b((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void b(int i, int i2) {
            a(i, 0);
            a(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void c(int i, int i2) {
            a(i, 0);
            b(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void e(int i, int i2) {
            a(i, 5);
            d(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, long j) {
            a(i, 0);
            a(j);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void c(int i, long j) {
            a(i, 1);
            c(j);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, boolean z) {
            a(i, 0);
            a(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, String str) {
            a(i, 2);
            a(str);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, apo apoVar) {
            a(i, 2);
            a(apoVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(apo apoVar) {
            b(apoVar.a());
            apoVar.a(this);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void c(byte[] bArr, int i, int i2) {
            b(i2);
            b(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i, asf asfVar) {
            a(i, 2);
            a(asfVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        final void a(int i, asf asfVar, asx asxVar) {
            a(i, 2);
            apf apfVar = (apf) asfVar;
            int iJ = apfVar.j();
            if (iJ == -1) {
                iJ = asxVar.b(apfVar);
                apfVar.a(iJ);
            }
            b(iJ);
            asxVar.a((asx) asfVar, (auk) this.f3659a);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void b(int i, asf asfVar) {
            a(1, 3);
            c(2, i);
            a(3, asfVar);
            a(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void b(int i, apo apoVar) {
            a(1, 3);
            c(2, i);
            a(3, apoVar);
            a(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(asf asfVar) {
            b(asfVar.l());
            asfVar.a(this);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        final void a(asf asfVar, asx asxVar) {
            apf apfVar = (apf) asfVar;
            int iJ = apfVar.j();
            if (iJ == -1) {
                iJ = asxVar.b(apfVar);
                apfVar.a(iJ);
            }
            b(iJ);
            asxVar.a((asx) asfVar, (auk) this.f3659a);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(byte b2) throws zzc {
            try {
                byte[] bArr = this.f3660b;
                int i = this.e;
                this.e = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(int i) {
            if (i >= 0) {
                b(i);
            } else {
                a(i);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void b(int i) throws zzc {
            if (zzbqk.c && b() >= 10) {
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.f3660b;
                    int i2 = this.e;
                    this.e = i2 + 1;
                    atv.a(bArr, i2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.f3660b;
                int i3 = this.e;
                this.e = i3 + 1;
                atv.a(bArr2, i3, (byte) i);
                return;
            }
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f3660b;
                    int i4 = this.e;
                    this.e = i4 + 1;
                    bArr3[i4] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
                }
            }
            byte[] bArr4 = this.f3660b;
            int i5 = this.e;
            this.e = i5 + 1;
            bArr4[i5] = (byte) i;
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void d(int i) throws zzc {
            try {
                byte[] bArr = this.f3660b;
                int i2 = this.e;
                this.e = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.f3660b;
                int i3 = this.e;
                this.e = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.f3660b;
                int i4 = this.e;
                this.e = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.f3660b;
                int i5 = this.e;
                this.e = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(long j) throws zzc {
            if (zzbqk.c && b() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.f3660b;
                    int i = this.e;
                    this.e = i + 1;
                    atv.a(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.f3660b;
                int i2 = this.e;
                this.e = i2 + 1;
                atv.a(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f3660b;
                    int i3 = this.e;
                    this.e = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
                }
            }
            byte[] bArr4 = this.f3660b;
            int i4 = this.e;
            this.e = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void c(long j) throws zzc {
            try {
                byte[] bArr = this.f3660b;
                int i = this.e;
                this.e = i + 1;
                bArr[i] = (byte) j;
                byte[] bArr2 = this.f3660b;
                int i2 = this.e;
                this.e = i2 + 1;
                bArr2[i2] = (byte) (j >> 8);
                byte[] bArr3 = this.f3660b;
                int i3 = this.e;
                this.e = i3 + 1;
                bArr3[i3] = (byte) (j >> 16);
                byte[] bArr4 = this.f3660b;
                int i4 = this.e;
                this.e = i4 + 1;
                bArr4[i4] = (byte) (j >> 24);
                byte[] bArr5 = this.f3660b;
                int i5 = this.e;
                this.e = i5 + 1;
                bArr5[i5] = (byte) (j >> 32);
                byte[] bArr6 = this.f3660b;
                int i6 = this.e;
                this.e = i6 + 1;
                bArr6[i6] = (byte) (j >> 40);
                byte[] bArr7 = this.f3660b;
                int i7 = this.e;
                this.e = i7 + 1;
                bArr7[i7] = (byte) (j >> 48);
                byte[] bArr8 = this.f3660b;
                int i8 = this.e;
                this.e = i8 + 1;
                bArr8[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void b(byte[] bArr, int i, int i2) throws zzc {
            try {
                System.arraycopy(bArr, i, this.f3660b, this.e, i2);
                this.e += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.apn
        public final void a(byte[] bArr, int i, int i2) {
            b(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void a(String str) throws zzc {
            int i = this.e;
            try {
                int iG = g(str.length() * 3);
                int iG2 = g(str.length());
                if (iG2 == iG) {
                    this.e = i + iG2;
                    int iA = atx.a(str, this.f3660b, this.e, b());
                    this.e = i;
                    b((iA - i) - iG2);
                    this.e = iA;
                    return;
                }
                b(atx.a(str));
                this.e = atx.a(str, this.f3660b, this.e, b());
            } catch (aub e) {
                this.e = i;
                a(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final int b() {
            return this.d - this.e;
        }

        public final int e() {
            return this.e - this.c;
        }
    }

    private zzbqk() {
    }

    public final void d(int i, int i2) {
        c(i, m(i2));
    }

    public final void b(int i, long j) {
        a(i, i(j));
    }

    public final void a(int i, float f) {
        e(i, Float.floatToRawIntBits(f));
    }

    public final void a(int i, double d2) {
        c(i, Double.doubleToRawLongBits(d2));
    }

    public final void c(int i) {
        b(m(i));
    }

    public final void b(long j) {
        a(i(j));
    }

    public final void a(float f) {
        d(Float.floatToRawIntBits(f));
    }

    public final void a(double d2) {
        c(Double.doubleToRawLongBits(d2));
    }

    public final void a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    public static int f(int i, int i2) {
        return e(i) + f(i2);
    }

    public static int g(int i, int i2) {
        return e(i) + g(i2);
    }

    public static int h(int i, int i2) {
        return e(i) + g(m(i2));
    }

    public static int i(int i, int i2) {
        return e(i) + 4;
    }

    public static int j(int i, int i2) {
        return e(i) + 4;
    }

    public static int d(int i, long j) {
        return e(i) + e(j);
    }

    public static int e(int i, long j) {
        return e(i) + e(j);
    }

    public static int f(int i, long j) {
        return e(i) + e(i(j));
    }

    public static int g(int i, long j) {
        return e(i) + 8;
    }

    public static int h(int i, long j) {
        return e(i) + 8;
    }

    public static int b(int i, float f) {
        return e(i) + 4;
    }

    public static int b(int i, double d2) {
        return e(i) + 8;
    }

    public static int b(int i, boolean z) {
        return e(i) + 1;
    }

    public static int k(int i, int i2) {
        return e(i) + f(i2);
    }

    public static int b(int i, String str) {
        return e(i) + b(str);
    }

    public static int c(int i, apo apoVar) {
        int iE = e(i);
        int iA = apoVar.a();
        return iE + g(iA) + iA;
    }

    public static int a(int i, arl arlVar) {
        int iE = e(i);
        int iB = arlVar.b();
        return iE + g(iB) + iB;
    }

    public static int c(int i, asf asfVar) {
        return e(i) + b(asfVar);
    }

    static int b(int i, asf asfVar, asx asxVar) {
        return e(i) + b(asfVar, asxVar);
    }

    public static int d(int i, asf asfVar) {
        return (e(1) << 1) + g(2, i) + c(3, asfVar);
    }

    public static int d(int i, apo apoVar) {
        return (e(1) << 1) + g(2, i) + c(3, apoVar);
    }

    public static int b(int i, arl arlVar) {
        return (e(1) << 1) + g(2, i) + a(3, arlVar);
    }

    public static int e(int i) {
        return g(i << 3);
    }

    public static int f(int i) {
        if (i >= 0) {
            return g(i);
        }
        return 10;
    }

    public static int h(int i) {
        return g(m(i));
    }

    public static int d(long j) {
        return e(j);
    }

    public static int f(long j) {
        return e(i(j));
    }

    public static int k(int i) {
        return f(i);
    }

    public static int b(String str) {
        int length;
        try {
            length = atx.a(str);
        } catch (aub unused) {
            length = str.getBytes(ara.f2199a).length;
        }
        return g(length) + length;
    }

    public static int a(arl arlVar) {
        int iB = arlVar.b();
        return g(iB) + iB;
    }

    public static int b(apo apoVar) {
        int iA = apoVar.a();
        return g(iA) + iA;
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        return g(length) + length;
    }

    public static int b(asf asfVar) {
        int iL = asfVar.l();
        return g(iL) + iL;
    }

    static int b(asf asfVar, asx asxVar) {
        apf apfVar = (apf) asfVar;
        int iJ = apfVar.j();
        if (iJ == -1) {
            iJ = asxVar.b(apfVar);
            apfVar.a(iJ);
        }
        return g(iJ) + iJ;
    }

    public final void c() {
        if (b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void a(String str, aub aubVar) throws zzc {
        f3658b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) aubVar);
        byte[] bytes = str.getBytes(ara.f2199a);
        try {
            b(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (zzc e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzc(e2);
        }
    }

    @Deprecated
    static int c(int i, asf asfVar, asx asxVar) {
        int iE = e(i) << 1;
        apf apfVar = (apf) asfVar;
        int iJ = apfVar.j();
        if (iJ == -1) {
            iJ = asxVar.b(apfVar);
            apfVar.a(iJ);
        }
        return iE + iJ;
    }

    @Deprecated
    public static int c(asf asfVar) {
        return asfVar.l();
    }

    @Deprecated
    public static int l(int i) {
        return g(i);
    }
}
