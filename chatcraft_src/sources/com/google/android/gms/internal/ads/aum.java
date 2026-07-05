package com.google.android.gms.internal.ads;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* loaded from: classes.dex */
public final class aum {

    /* renamed from: a, reason: collision with root package name */
    private final ByteBuffer f2278a;

    /* renamed from: b, reason: collision with root package name */
    private zzbqk f2279b;
    private int c;

    private aum(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int a(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int d(int i) {
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

    private aum(ByteBuffer byteBuffer) {
        this.f2278a = byteBuffer;
        this.f2278a.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static aum a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static aum a(byte[] bArr, int i, int i2) {
        return new aum(bArr, 0, i2);
    }

    public final void a(int i, long j) throws zzbus {
        c(i, 0);
        b(j);
    }

    public final void b(int i, long j) throws zzbus {
        c(i, 0);
        b(j);
    }

    public final void a(int i, int i2) throws zzbus {
        c(i, 0);
        if (i2 >= 0) {
            c(i2);
        } else {
            b(i2);
        }
    }

    public final void a(int i, boolean z) throws zzbus {
        c(i, 0);
        byte b2 = z ? (byte) 1 : (byte) 0;
        if (!this.f2278a.hasRemaining()) {
            throw new zzbus(this.f2278a.position(), this.f2278a.limit());
        }
        this.f2278a.put(b2);
    }

    public final void a(int i, String str) throws zzbus {
        c(i, 2);
        try {
            int iD = d(str.length());
            if (iD == d(str.length() * 3)) {
                int iPosition = this.f2278a.position();
                if (this.f2278a.remaining() < iD) {
                    throw new zzbus(iPosition + iD, this.f2278a.limit());
                }
                this.f2278a.position(iPosition + iD);
                a(str, this.f2278a);
                int iPosition2 = this.f2278a.position();
                this.f2278a.position(iPosition);
                c((iPosition2 - iPosition) - iD);
                this.f2278a.position(iPosition2);
                return;
            }
            c(a((CharSequence) str));
            a(str, this.f2278a);
        } catch (BufferOverflowException e) {
            zzbus zzbusVar = new zzbus(this.f2278a.position(), this.f2278a.limit());
            zzbusVar.initCause(e);
            throw zzbusVar;
        }
    }

    public final void a(int i, aus ausVar) throws zzbus {
        c(i, 2);
        if (ausVar.aa < 0) {
            ausVar.d();
        }
        c(ausVar.aa);
        ausVar.a(this);
    }

    public final void a(int i, asf asfVar) {
        if (this.f2279b == null) {
            this.f2279b = zzbqk.a(this.f2278a);
            this.c = this.f2278a.position();
        } else if (this.c != this.f2278a.position()) {
            this.f2279b.b(this.f2278a.array(), this.c, this.f2278a.position() - this.c);
            this.c = this.f2278a.position();
        }
        zzbqk zzbqkVar = this.f2279b;
        zzbqkVar.a(i, asfVar);
        zzbqkVar.a();
        this.c = this.f2278a.position();
    }

    public final void a(int i, byte[] bArr) throws zzbus {
        c(i, 2);
        c(bArr.length);
        c(bArr);
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt < 2048) {
                i3 += (127 - cCharAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char cCharAt2 = charSequence.charAt(i2);
                    if (cCharAt2 < 2048) {
                        i += (127 - cCharAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i2);
                                throw new IllegalArgumentException(sb.toString());
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j = i3 + 4294967296L;
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(j);
        throw new IllegalArgumentException(sb2.toString());
    }

    private static void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        char cCharAt;
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        int i3 = 0;
        if (byteBuffer.hasArray()) {
            try {
                byte[] bArrArray = byteBuffer.array();
                int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                int iRemaining = byteBuffer.remaining();
                int length = charSequence.length();
                int i4 = iRemaining + iArrayOffset;
                while (i3 < length) {
                    int i5 = i3 + iArrayOffset;
                    if (i5 >= i4 || (cCharAt = charSequence.charAt(i3)) >= 128) {
                        break;
                    }
                    bArrArray[i5] = (byte) cCharAt;
                    i3++;
                }
                if (i3 == length) {
                    i = iArrayOffset + length;
                } else {
                    i = iArrayOffset + i3;
                    while (i3 < length) {
                        char cCharAt2 = charSequence.charAt(i3);
                        if (cCharAt2 >= 128 || i >= i4) {
                            if (cCharAt2 < 2048 && i <= i4 - 2) {
                                int i6 = i + 1;
                                bArrArray[i] = (byte) ((cCharAt2 >>> 6) | 960);
                                i = i6 + 1;
                                bArrArray[i6] = (byte) ((cCharAt2 & '?') | 128);
                            } else {
                                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i > i4 - 3) {
                                    if (i <= i4 - 4) {
                                        int i7 = i3 + 1;
                                        if (i7 != charSequence.length()) {
                                            char cCharAt3 = charSequence.charAt(i7);
                                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                                int i8 = i + 1;
                                                bArrArray[i] = (byte) ((codePoint >>> 18) | 240);
                                                int i9 = i8 + 1;
                                                bArrArray[i8] = (byte) (((codePoint >>> 12) & 63) | 128);
                                                int i10 = i9 + 1;
                                                bArrArray[i9] = (byte) (((codePoint >>> 6) & 63) | 128);
                                                i = i10 + 1;
                                                bArrArray[i10] = (byte) ((codePoint & 63) | 128);
                                                i3 = i7;
                                            } else {
                                                i3 = i7;
                                            }
                                        }
                                        StringBuilder sb = new StringBuilder(39);
                                        sb.append("Unpaired surrogate at index ");
                                        sb.append(i3 - 1);
                                        throw new IllegalArgumentException(sb.toString());
                                    }
                                    StringBuilder sb2 = new StringBuilder(37);
                                    sb2.append("Failed writing ");
                                    sb2.append(cCharAt2);
                                    sb2.append(" at index ");
                                    sb2.append(i);
                                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                                }
                                int i11 = i + 1;
                                bArrArray[i] = (byte) ((cCharAt2 >>> '\f') | 480);
                                int i12 = i11 + 1;
                                bArrArray[i11] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                                i2 = i12 + 1;
                                bArrArray[i12] = (byte) ((cCharAt2 & '?') | 128);
                            }
                            i3++;
                        } else {
                            i2 = i + 1;
                            bArrArray[i] = (byte) cCharAt2;
                        }
                        i = i2;
                        i3++;
                    }
                }
                byteBuffer.position(i - byteBuffer.arrayOffset());
                return;
            } catch (ArrayIndexOutOfBoundsException e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        }
        int length2 = charSequence.length();
        while (i3 < length2) {
            char cCharAt4 = charSequence.charAt(i3);
            if (cCharAt4 < 128) {
                byteBuffer.put((byte) cCharAt4);
            } else if (cCharAt4 < 2048) {
                byteBuffer.put((byte) ((cCharAt4 >>> 6) | 960));
                byteBuffer.put((byte) ((cCharAt4 & '?') | 128));
            } else if (cCharAt4 < 55296 || 57343 < cCharAt4) {
                byteBuffer.put((byte) ((cCharAt4 >>> '\f') | 480));
                byteBuffer.put((byte) (((cCharAt4 >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((cCharAt4 & '?') | 128));
            } else {
                int i13 = i3 + 1;
                if (i13 != charSequence.length()) {
                    char cCharAt5 = charSequence.charAt(i13);
                    if (Character.isSurrogatePair(cCharAt4, cCharAt5)) {
                        int codePoint2 = Character.toCodePoint(cCharAt4, cCharAt5);
                        byteBuffer.put((byte) ((codePoint2 >>> 18) | 240));
                        byteBuffer.put((byte) (((codePoint2 >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((codePoint2 >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((codePoint2 & 63) | 128));
                        i3 = i13;
                    } else {
                        i3 = i13;
                    }
                }
                StringBuilder sb3 = new StringBuilder(39);
                sb3.append("Unpaired surrogate at index ");
                sb3.append(i3 - 1);
                throw new IllegalArgumentException(sb3.toString());
            }
            i3++;
        }
    }

    public static int c(int i, long j) {
        return b(i) + a(j);
    }

    public static int d(int i, long j) {
        return b(i) + a(j);
    }

    public static int b(int i, int i2) {
        return b(i) + a(i2);
    }

    public static int b(int i, String str) {
        return b(i) + a(str);
    }

    public static int b(int i, aus ausVar) {
        int iB = b(i);
        int iD = ausVar.d();
        return iB + d(iD) + iD;
    }

    public static int b(int i, byte[] bArr) {
        return b(i) + b(bArr);
    }

    public static int a(int i) {
        if (i >= 0) {
            return d(i);
        }
        return 10;
    }

    public static int a(String str) {
        int iA = a((CharSequence) str);
        return d(iA) + iA;
    }

    public static int b(byte[] bArr) {
        return d(bArr.length) + bArr.length;
    }

    public final void a() {
        if (this.f2278a.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.f2278a.remaining())));
        }
    }

    private final void e(int i) throws zzbus {
        byte b2 = (byte) i;
        if (!this.f2278a.hasRemaining()) {
            throw new zzbus(this.f2278a.position(), this.f2278a.limit());
        }
        this.f2278a.put(b2);
    }

    public final void c(byte[] bArr) throws zzbus {
        int length = bArr.length;
        if (this.f2278a.remaining() >= length) {
            this.f2278a.put(bArr, 0, length);
            return;
        }
        throw new zzbus(this.f2278a.position(), this.f2278a.limit());
    }

    public final void c(int i, int i2) throws zzbus {
        c((i << 3) | i2);
    }

    public static int b(int i) {
        return d(i << 3);
    }

    public final void c(int i) throws zzbus {
        while ((i & (-128)) != 0) {
            e((i & 127) | 128);
            i >>>= 7;
        }
        e(i);
    }

    private final void b(long j) throws zzbus {
        while (((-128) & j) != 0) {
            e((((int) j) & 127) | 128);
            j >>>= 7;
        }
        e((int) j);
    }
}
