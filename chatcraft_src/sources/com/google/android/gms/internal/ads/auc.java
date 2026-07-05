package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class auc extends atz {
    auc() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0090, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.ads.atz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int a(int r18, byte[] r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auc.a(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.ads.atz
    final String b(byte[] bArr, int i, int i2) throws zzbrl {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte bA = atv.a(bArr, i);
            if (!aty.d(bA)) {
                break;
            }
            i++;
            aty.b(bA, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte bA2 = atv.a(bArr, i);
            if (aty.d(bA2)) {
                int i7 = i5 + 1;
                aty.b(bA2, cArr, i5);
                while (i6 < i3) {
                    byte bA3 = atv.a(bArr, i6);
                    if (!aty.d(bA3)) {
                        break;
                    }
                    i6++;
                    aty.b(bA3, cArr, i7);
                    i7++;
                }
                i = i6;
                i5 = i7;
            } else if (aty.e(bA2)) {
                if (i6 < i3) {
                    aty.b(bA2, atv.a(bArr, i6), cArr, i5);
                    i = i6 + 1;
                    i5++;
                } else {
                    throw zzbrl.i();
                }
            } else if (aty.f(bA2)) {
                if (i6 < i3 - 1) {
                    int i8 = i6 + 1;
                    aty.b(bA2, atv.a(bArr, i6), atv.a(bArr, i8), cArr, i5);
                    i = i8 + 1;
                    i5++;
                } else {
                    throw zzbrl.i();
                }
            } else {
                if (i6 >= i3 - 2) {
                    throw zzbrl.i();
                }
                int i9 = i6 + 1;
                byte bA4 = atv.a(bArr, i6);
                int i10 = i9 + 1;
                aty.b(bA2, bA4, atv.a(bArr, i9), atv.a(bArr, i10), cArr, i5);
                i = i10 + 1;
                i5 = i5 + 1 + 1;
            }
        }
        return new String(cArr, 0, i5);
    }

    @Override // com.google.android.gms.internal.ads.atz
    final int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        int i3;
        char cCharAt;
        long j2 = i;
        long j3 = i2 + j2;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char cCharAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(cCharAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (i4 < length && (cCharAt = charSequence.charAt(i4)) < 128) {
            atv.a(bArr, j2, (byte) cCharAt);
            i4++;
            j2 = 1 + j2;
        }
        if (i4 == length) {
            return (int) j2;
        }
        while (i4 < length) {
            char cCharAt3 = charSequence.charAt(i4);
            if (cCharAt3 >= 128 || j2 >= j3) {
                if (cCharAt3 < 2048 && j2 <= j3 - 2) {
                    long j4 = j2 + 1;
                    atv.a(bArr, j2, (byte) ((cCharAt3 >>> 6) | 960));
                    j2 = j4 + 1;
                    atv.a(bArr, j4, (byte) ((cCharAt3 & '?') | 128));
                } else {
                    if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || j2 > j3 - 3) {
                        if (j2 <= j3 - 4) {
                            int i5 = i4 + 1;
                            if (i5 != length) {
                                char cCharAt4 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                    int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                    long j5 = j2 + 1;
                                    atv.a(bArr, j2, (byte) ((codePoint >>> 18) | 240));
                                    long j6 = j5 + 1;
                                    atv.a(bArr, j5, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j7 = j6 + 1;
                                    atv.a(bArr, j6, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j2 = j7 + 1;
                                    atv.a(bArr, j7, (byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                }
                            } else {
                                i5 = i4;
                            }
                            throw new aub(i5 - 1, length);
                        }
                        if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt3, charSequence.charAt(i3)))) {
                            throw new aub(i4, length);
                        }
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(cCharAt3);
                        sb2.append(" at index ");
                        sb2.append(j2);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    long j8 = j2 + 1;
                    atv.a(bArr, j2, (byte) ((cCharAt3 >>> '\f') | 480));
                    long j9 = j8 + 1;
                    atv.a(bArr, j8, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                    j = j9 + 1;
                    atv.a(bArr, j9, (byte) ((cCharAt3 & '?') | 128));
                }
                i4++;
            } else {
                j = j2 + 1;
                atv.a(bArr, j2, (byte) cCharAt3);
            }
            j2 = j;
            i4++;
        }
        return (int) j2;
    }

    @Override // com.google.android.gms.internal.ads.atz
    final void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        char c;
        long j;
        long j2;
        long j3;
        int i;
        char cCharAt;
        long jA = atv.a(byteBuffer);
        long jPosition = byteBuffer.position() + jA;
        long jLimit = byteBuffer.limit() + jA;
        int length = charSequence.length();
        if (length > jLimit - jPosition) {
            char cCharAt2 = charSequence.charAt(length - 1);
            int iLimit = byteBuffer.limit();
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(cCharAt2);
            sb.append(" at index ");
            sb.append(iLimit);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i2 = 0;
        while (true) {
            c = 128;
            j = 1;
            if (i2 >= length || (cCharAt = charSequence.charAt(i2)) >= 128) {
                break;
            }
            atv.a(jPosition, (byte) cCharAt);
            i2++;
            jPosition = 1 + jPosition;
        }
        if (i2 == length) {
            byteBuffer.position((int) (jPosition - jA));
            return;
        }
        while (i2 < length) {
            char cCharAt3 = charSequence.charAt(i2);
            if (cCharAt3 < c && jPosition < jLimit) {
                j2 = jPosition + j;
                atv.a(jPosition, (byte) cCharAt3);
            } else if (cCharAt3 < 2048 && jPosition <= jLimit - 2) {
                long j4 = jPosition + j;
                atv.a(jPosition, (byte) ((cCharAt3 >>> 6) | 960));
                atv.a(j4, (byte) ((cCharAt3 & '?') | 128));
                j2 = j4 + j;
            } else {
                if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || jPosition > jLimit - 3) {
                    if (jPosition <= jLimit - 4) {
                        int i3 = i2 + 1;
                        if (i3 != length) {
                            char cCharAt4 = charSequence.charAt(i3);
                            if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                long j5 = jPosition + 1;
                                atv.a(jPosition, (byte) ((codePoint >>> 18) | 240));
                                long j6 = j5 + 1;
                                atv.a(j5, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j7 = j6 + 1;
                                atv.a(j6, (byte) (((codePoint >>> 6) & 63) | 128));
                                j3 = 1;
                                atv.a(j7, (byte) ((codePoint & 63) | 128));
                                i2 = i3;
                                j2 = j7 + 1;
                                i2++;
                                j = j3;
                                jPosition = j2;
                                c = 128;
                            } else {
                                i2 = i3;
                            }
                        }
                        throw new aub(i2 - 1, length);
                    }
                    if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i = i2 + 1) == length || !Character.isSurrogatePair(cCharAt3, charSequence.charAt(i)))) {
                        throw new aub(i2, length);
                    }
                    StringBuilder sb2 = new StringBuilder(46);
                    sb2.append("Failed writing ");
                    sb2.append(cCharAt3);
                    sb2.append(" at index ");
                    sb2.append(jPosition);
                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                }
                long j8 = jPosition + j;
                atv.a(jPosition, (byte) ((cCharAt3 >>> '\f') | 480));
                long j9 = j8 + j;
                atv.a(j8, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                atv.a(j9, (byte) ((cCharAt3 & '?') | 128));
                j2 = j9 + 1;
                j3 = 1;
                i2++;
                j = j3;
                jPosition = j2;
                c = 128;
            }
            j3 = j;
            i2++;
            j = j3;
            jPosition = j2;
            c = 128;
        }
        byteBuffer.position((int) (jPosition - jA));
    }

    private static int a(byte[] bArr, int i, long j, int i2) {
        switch (i2) {
            case 0:
                return atx.b(i);
            case 1:
                return atx.b(i, atv.a(bArr, j));
            case 2:
                return atx.b(i, atv.a(bArr, j), atv.a(bArr, j + 1));
            default:
                throw new AssertionError();
        }
    }
}
