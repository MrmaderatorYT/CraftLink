package org.xbill.DNS;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.PrintStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: Name.java */
/* loaded from: classes.dex */
public class bg implements Serializable, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public static final bg f5343a;

    /* renamed from: b, reason: collision with root package name */
    public static final bg f5344b;
    private static final byte[] f = {0};
    private static final byte[] g = {1, 42};
    private static final DecimalFormat h = new DecimalFormat();
    private static final byte[] i = new byte[256];
    private static final bg j;
    private byte[] c;
    private long d;
    private int e;

    static {
        h.setMinimumIntegerDigits(3);
        for (int i2 = 0; i2 < i.length; i2++) {
            if (i2 < 65 || i2 > 90) {
                i[i2] = (byte) i2;
            } else {
                i[i2] = (byte) ((i2 - 65) + 97);
            }
        }
        f5343a = new bg();
        f5343a.b(f, 0, 1);
        f5344b = new bg();
        f5344b.c = new byte[0];
        j = new bg();
        j.b(g, 0, 1);
    }

    private bg() {
    }

    private final void a(int i2, int i3) {
        if (i2 >= 7) {
            return;
        }
        int i4 = (7 - i2) * 8;
        this.d &= (255 << i4) ^ (-1);
        this.d = (i3 << i4) | this.d;
    }

    private final int a(int i2) {
        if (i2 == 0 && e() == 0) {
            return 0;
        }
        if (i2 < 0 || i2 >= e()) {
            throw new IllegalArgumentException("label out of range");
        }
        if (i2 < 7) {
            return ((int) (this.d >>> ((7 - i2) * 8))) & 255;
        }
        int iA = a(6);
        for (int i3 = 6; i3 < i2; i3++) {
            iA += this.c[iA] + 1;
        }
        return iA;
    }

    private final void b(int i2) {
        this.d &= -256;
        this.d |= i2;
    }

    private final int e() {
        return (int) (this.d & 255);
    }

    private static final void b(bg bgVar, bg bgVar2) {
        if (bgVar.a(0) == 0) {
            bgVar2.c = bgVar.c;
            bgVar2.d = bgVar.d;
            return;
        }
        int iA = bgVar.a(0);
        int length = bgVar.c.length - iA;
        int iC = bgVar.c();
        bgVar2.c = new byte[length];
        System.arraycopy(bgVar.c, iA, bgVar2.c, 0, length);
        for (int i2 = 0; i2 < iC && i2 < 7; i2++) {
            bgVar2.a(i2, bgVar.a(i2) - iA);
        }
        bgVar2.b(iC);
    }

    private final void a(byte[] bArr, int i2, int i3) throws NameTooLongException {
        int length = this.c == null ? 0 : this.c.length - a(0);
        int i4 = i2;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = bArr[i4];
            if (i7 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i8 = i7 + 1;
            i4 += i8;
            i5 += i8;
        }
        int i9 = length + i5;
        if (i9 > 255) {
            throw new NameTooLongException();
        }
        int iE = e();
        int i10 = iE + i3;
        if (i10 > 128) {
            throw new IllegalStateException("too many labels");
        }
        byte[] bArr2 = new byte[i9];
        if (length != 0) {
            System.arraycopy(this.c, a(0), bArr2, 0, length);
        }
        System.arraycopy(bArr, i2, bArr2, length, i5);
        this.c = bArr2;
        for (int i11 = 0; i11 < i3; i11++) {
            a(iE + i11, length);
            length += bArr2[length] + 1;
        }
        b(i10);
    }

    private static TextParseException a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("'");
        stringBuffer.append(str);
        stringBuffer.append("': ");
        stringBuffer.append(str2);
        return new TextParseException(stringBuffer.toString());
    }

    private final void a(String str, byte[] bArr, int i2, int i3) throws TextParseException {
        try {
            a(bArr, i2, i3);
        } catch (NameTooLongException unused) {
            throw a(str, "Name too long");
        }
    }

    private final void b(byte[] bArr, int i2, int i3) {
        try {
            a(bArr, i2, i3);
        } catch (NameTooLongException unused) {
        }
    }

    public bg(String str, bg bgVar) throws TextParseException {
        boolean z;
        int i2;
        if (str.equals(BuildConfig.FLAVOR)) {
            throw a(str, "empty name");
        }
        if (str.equals("@")) {
            if (bgVar == null) {
                b(f5344b, this);
                return;
            } else {
                b(bgVar, this);
                return;
            }
        }
        if (str.equals(".")) {
            b(f5343a, this);
            return;
        }
        byte[] bArr = new byte[64];
        boolean z2 = false;
        int i3 = 0;
        int i4 = -1;
        int i5 = 1;
        int i6 = 0;
        for (int i7 = 0; i7 < str.length(); i7++) {
            byte bCharAt = (byte) str.charAt(i7);
            if (z2) {
                if (bCharAt >= 48 && bCharAt <= 57 && i3 < 3) {
                    i3++;
                    i6 = (i6 * 10) + (bCharAt - 48);
                    if (i6 > 255) {
                        throw a(str, "bad escape");
                    }
                    if (i3 < 3) {
                        continue;
                    } else {
                        bCharAt = (byte) i6;
                    }
                } else if (i3 > 0 && i3 < 3) {
                    throw a(str, "bad escape");
                }
                if (i5 > 63) {
                    throw a(str, "label too long");
                }
                i2 = i5 + 1;
                bArr[i5] = bCharAt;
                i4 = i5;
                z2 = false;
                i5 = i2;
            } else if (bCharAt == 92) {
                z2 = true;
                i3 = 0;
                i6 = 0;
            } else if (bCharAt == 46) {
                if (i4 == -1) {
                    throw a(str, "invalid empty label");
                }
                bArr[0] = (byte) (i5 - 1);
                a(str, bArr, 0, 1);
                i4 = -1;
                i5 = 1;
            } else {
                i4 = i4 == -1 ? i7 : i4;
                if (i5 > 63) {
                    throw a(str, "label too long");
                }
                i2 = i5 + 1;
                bArr[i5] = bCharAt;
                i5 = i2;
            }
        }
        if (i3 > 0 && i3 < 3) {
            throw a(str, "bad escape");
        }
        if (z2) {
            throw a(str, "bad escape");
        }
        if (i4 == -1) {
            z = true;
            a(str, f, 0, 1);
        } else {
            bArr[0] = (byte) (i5 - 1);
            a(str, bArr, 0, 1);
            z = false;
        }
        if (bgVar == null || z) {
            return;
        }
        a(str, bgVar.c, bgVar.a(0), bgVar.e());
    }

    public static bg a(String str, bg bgVar) {
        if (str.equals("@") && bgVar != null) {
            return bgVar;
        }
        if (str.equals(".")) {
            return f5343a;
        }
        return new bg(str, bgVar);
    }

    public static bg a(String str) {
        return a(str, (bg) null);
    }

    public static bg b(String str) {
        try {
            return a(str, (bg) null);
        } catch (TextParseException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid name '");
            stringBuffer.append(str);
            stringBuffer.append("'");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    public bg(t tVar) throws WireParseException {
        byte[] bArr = new byte[64];
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            int iG = tVar.g();
            int i2 = iG & 192;
            if (i2 != 0) {
                if (i2 == 192) {
                    int iG2 = tVar.g() + ((iG & (-193)) << 8);
                    if (bk.b("verbosecompression")) {
                        PrintStream printStream = System.err;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("currently ");
                        stringBuffer.append(tVar.a());
                        stringBuffer.append(", pointer to ");
                        stringBuffer.append(iG2);
                        printStream.println(stringBuffer.toString());
                    }
                    if (iG2 >= tVar.a() - 2) {
                        throw new WireParseException("bad compression");
                    }
                    if (!z2) {
                        tVar.e();
                        z2 = true;
                    }
                    tVar.c(iG2);
                    if (bk.b("verbosecompression")) {
                        PrintStream printStream2 = System.err;
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("current name '");
                        stringBuffer2.append(this);
                        stringBuffer2.append("', seeking to ");
                        stringBuffer2.append(iG2);
                        printStream2.println(stringBuffer2.toString());
                    }
                } else {
                    throw new WireParseException("bad label type");
                }
            } else {
                if (e() >= 128) {
                    throw new WireParseException("too many labels");
                }
                if (iG == 0) {
                    a(f, 0, 1);
                    z = true;
                } else {
                    bArr[0] = (byte) iG;
                    tVar.a(bArr, 1, iG);
                    a(bArr, 0, 1);
                }
            }
        }
        if (z2) {
            tVar.f();
        }
    }

    public bg(bg bgVar, int i2) {
        int iC = bgVar.c();
        if (i2 > iC) {
            throw new IllegalArgumentException("attempted to remove too many labels");
        }
        this.c = bgVar.c;
        int i3 = iC - i2;
        b(i3);
        for (int i4 = 0; i4 < 7 && i4 < i3; i4++) {
            a(i4, bgVar.a(i4 + i2));
        }
    }

    public static bg a(bg bgVar, bg bgVar2) throws NameTooLongException {
        if (bgVar.a()) {
            return bgVar;
        }
        bg bgVar3 = new bg();
        b(bgVar, bgVar3);
        bgVar3.a(bgVar2.c, bgVar2.a(0), bgVar2.e());
        return bgVar3;
    }

    public bg a(s sVar) throws NameTooLongException {
        bg bgVarJ = sVar.j();
        bg bgVarM_ = sVar.M_();
        if (!a(bgVarJ)) {
            return null;
        }
        int iC = c() - bgVarJ.c();
        int iB = b() - bgVarJ.b();
        int iA = a(0);
        int iC2 = bgVarM_.c();
        short sB = bgVarM_.b();
        int i2 = iB + sB;
        if (i2 > 255) {
            throw new NameTooLongException();
        }
        bg bgVar = new bg();
        int i3 = iC + iC2;
        bgVar.b(i3);
        bgVar.c = new byte[i2];
        System.arraycopy(this.c, iA, bgVar.c, 0, iB);
        System.arraycopy(bgVarM_.c, 0, bgVar.c, iB, sB);
        int i4 = 0;
        for (int i5 = 0; i5 < 7 && i5 < i3; i5++) {
            bgVar.a(i5, i4);
            i4 += bgVar.c[i4] + 1;
        }
        return bgVar;
    }

    public boolean a() {
        int iC = c();
        return iC != 0 && this.c[a(iC - 1)] == 0;
    }

    public short b() {
        if (e() == 0) {
            return (short) 0;
        }
        return (short) (this.c.length - a(0));
    }

    public int c() {
        return e();
    }

    public boolean a(bg bgVar) {
        int iC = c();
        int iC2 = bgVar.c();
        if (iC2 > iC) {
            return false;
        }
        if (iC2 == iC) {
            return equals(bgVar);
        }
        return bgVar.b(this.c, a(iC - iC2));
    }

    private String a(byte[] bArr, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + 1;
        int i4 = bArr[i2];
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            int i6 = bArr[i5] & Constants.DimensionIds.NETHER;
            if (i6 <= 32 || i6 >= 127) {
                stringBuffer.append('\\');
                stringBuffer.append(h.format(i6));
            } else if (i6 == 34 || i6 == 40 || i6 == 41 || i6 == 46 || i6 == 59 || i6 == 92 || i6 == 64 || i6 == 36) {
                stringBuffer.append('\\');
                stringBuffer.append((char) i6);
            } else {
                stringBuffer.append((char) i6);
            }
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0057, code lost:
    
        return r2.toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(boolean r7) {
        /*
            r6 = this;
            int r0 = r6.c()
            if (r0 != 0) goto L9
            java.lang.String r7 = "@"
            return r7
        L9:
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L1a
            byte[] r2 = r6.c
            int r3 = r6.a(r1)
            r2 = r2[r3]
            if (r2 != 0) goto L1a
            java.lang.String r7 = "."
            return r7
        L1a:
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            int r3 = r6.a(r1)
        L23:
            if (r1 >= r0) goto L53
            byte[] r4 = r6.c
            r4 = r4[r3]
            r5 = 63
            if (r4 > r5) goto L4b
            r5 = 46
            if (r4 != 0) goto L37
            if (r7 != 0) goto L53
            r2.append(r5)
            goto L53
        L37:
            if (r1 <= 0) goto L3c
            r2.append(r5)
        L3c:
            byte[] r5 = r6.c
            java.lang.String r5 = r6.a(r5, r3)
            r2.append(r5)
            int r4 = r4 + 1
            int r3 = r3 + r4
            int r1 = r1 + 1
            goto L23
        L4b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "invalid label"
            r7.<init>(r0)
            throw r7
        L53:
            java.lang.String r7 = r2.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.bg.a(boolean):java.lang.String");
    }

    public String toString() {
        return a(false);
    }

    public void a(v vVar, n nVar) {
        if (!a()) {
            throw new IllegalArgumentException("toWire() called on non-absolute name");
        }
        int iC = c();
        int i2 = 0;
        while (i2 < iC - 1) {
            bg bgVar = i2 == 0 ? this : new bg(this, i2);
            int iA = nVar != null ? nVar.a(bgVar) : -1;
            if (iA >= 0) {
                vVar.c(49152 | iA);
                return;
            }
            if (nVar != null) {
                nVar.a(vVar.a(), bgVar);
            }
            int iA2 = a(i2);
            vVar.a(this.c, iA2, this.c[iA2] + 1);
            i2++;
        }
        vVar.b(0);
    }

    public void a(v vVar) {
        vVar.a(d());
    }

    public byte[] d() {
        int iC = c();
        if (iC == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[this.c.length - a(0)];
        int iA = a(0);
        int i2 = 0;
        int i3 = 0;
        while (i2 < iC) {
            byte b2 = this.c[iA];
            if (b2 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i4 = iA + 1;
            bArr[i3] = this.c[iA];
            i3++;
            int i5 = 0;
            while (i5 < b2) {
                bArr[i3] = i[this.c[i4] & Constants.DimensionIds.NETHER];
                i5++;
                i3++;
                i4++;
            }
            i2++;
            iA = i4;
        }
        return bArr;
    }

    public void a(v vVar, n nVar, boolean z) {
        if (z) {
            a(vVar);
        } else {
            a(vVar, nVar);
        }
    }

    private final boolean b(byte[] bArr, int i2) {
        int iC = c();
        int iA = a(0);
        int i3 = i2;
        int i4 = 0;
        while (i4 < iC) {
            if (this.c[iA] != bArr[i3]) {
                return false;
            }
            int i5 = iA + 1;
            byte b2 = this.c[iA];
            int i6 = i3 + 1;
            if (b2 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i7 = i6;
            int i8 = 0;
            while (i8 < b2) {
                int i9 = i5 + 1;
                int i10 = i7 + 1;
                if (i[this.c[i5] & Constants.DimensionIds.NETHER] != i[bArr[i7] & Constants.DimensionIds.NETHER]) {
                    return false;
                }
                i8++;
                i7 = i10;
                i5 = i9;
            }
            i4++;
            i3 = i7;
            iA = i5;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof bg)) {
            return false;
        }
        bg bgVar = (bg) obj;
        if (bgVar.e == 0) {
            bgVar.hashCode();
        }
        if (this.e == 0) {
            hashCode();
        }
        if (bgVar.e == this.e && bgVar.c() == c()) {
            return b(bgVar.c, bgVar.a(0));
        }
        return false;
    }

    public int hashCode() {
        if (this.e != 0) {
            return this.e;
        }
        int i2 = 0;
        for (int iA = a(0); iA < this.c.length; iA++) {
            i2 += (i2 << 3) + i[this.c[iA] & Constants.DimensionIds.NETHER];
        }
        this.e = i2;
        return this.e;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        bg bgVar = (bg) obj;
        if (this == bgVar) {
            return 0;
        }
        int iC = c();
        int iC2 = bgVar.c();
        int i2 = iC > iC2 ? iC2 : iC;
        for (int i3 = 1; i3 <= i2; i3++) {
            int iA = a(iC - i3);
            int iA2 = bgVar.a(iC2 - i3);
            byte b2 = this.c[iA];
            byte b3 = bgVar.c[iA2];
            for (int i4 = 0; i4 < b2 && i4 < b3; i4++) {
                int i5 = i[this.c[(i4 + iA) + 1] & Constants.DimensionIds.NETHER] - i[bgVar.c[(i4 + iA2) + 1] & Constants.DimensionIds.NETHER];
                if (i5 != 0) {
                    return i5;
                }
            }
            if (b2 != b3) {
                return b2 - b3;
            }
        }
        return iC - iC2;
    }
}
