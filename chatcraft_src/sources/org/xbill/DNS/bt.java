package org.xbill.DNS;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: Record.java */
/* loaded from: classes.dex */
public abstract class bt implements Serializable, Cloneable, Comparable {

    /* renamed from: a, reason: collision with root package name */
    private static final DecimalFormat f5357a = new DecimalFormat();
    protected bg g;
    protected int h;
    protected int i;
    protected long j;

    abstract bt a();

    abstract void a(t tVar);

    abstract void a(v vVar, n nVar, boolean z);

    abstract String b();

    public bg c() {
        return null;
    }

    static {
        f5357a.setMinimumIntegerDigits(3);
    }

    protected bt() {
    }

    bt(bg bgVar, int i, int i2, long j) {
        if (!bgVar.a()) {
            throw new RelativeNameException(bgVar);
        }
        ct.a(i);
        p.a(i2);
        cq.a(j);
        this.g = bgVar;
        this.h = i;
        this.i = i2;
        this.j = j;
    }

    private static final bt a(bg bgVar, int i, int i2, long j, boolean z) {
        bt yVar;
        if (z) {
            bt btVarC = ct.c(i);
            if (btVarC != null) {
                yVar = btVarC.a();
            } else {
                yVar = new cy();
            }
        } else {
            yVar = new y();
        }
        yVar.g = bgVar;
        yVar.h = i;
        yVar.i = i2;
        yVar.j = j;
        return yVar;
    }

    private static bt a(bg bgVar, int i, int i2, long j, int i3, t tVar) throws WireParseException {
        bt btVarA = a(bgVar, i, i2, j, tVar != null);
        if (tVar != null) {
            if (tVar.b() < i3) {
                throw new WireParseException("truncated record");
            }
            tVar.a(i3);
            btVarA.a(tVar);
            if (tVar.b() > 0) {
                throw new WireParseException("invalid record length");
            }
            tVar.c();
        }
        return btVarA;
    }

    public static bt a(bg bgVar, int i, int i2, long j) {
        if (!bgVar.a()) {
            throw new RelativeNameException(bgVar);
        }
        ct.a(i);
        p.a(i2);
        cq.a(j);
        return a(bgVar, i, i2, j, false);
    }

    public static bt a(bg bgVar, int i, int i2) {
        return a(bgVar, i, i2, 0L);
    }

    static bt a(t tVar, int i, boolean z) throws WireParseException {
        bg bgVar = new bg(tVar);
        int iH = tVar.h();
        int iH2 = tVar.h();
        if (i == 0) {
            return a(bgVar, iH, iH2);
        }
        long jI = tVar.i();
        int iH3 = tVar.h();
        if (iH3 == 0 && z && (i == 1 || i == 2)) {
            return a(bgVar, iH, iH2, jI);
        }
        return a(bgVar, iH, iH2, jI, iH3, tVar);
    }

    void a(v vVar, int i, n nVar) {
        this.g.a(vVar, nVar);
        vVar.c(this.h);
        vVar.c(this.i);
        if (i == 0) {
            return;
        }
        vVar.a(this.j);
        int iA = vVar.a();
        vVar.c(0);
        a(vVar, nVar, false);
        vVar.a((vVar.a() - iA) - 2, iA);
    }

    public byte[] a(int i) {
        v vVar = new v();
        a(vVar, i, (n) null);
        return vVar.b();
    }

    private void a(v vVar, boolean z) {
        this.g.a(vVar);
        vVar.c(this.h);
        vVar.c(this.i);
        if (z) {
            vVar.a(0L);
        } else {
            vVar.a(this.j);
        }
        int iA = vVar.a();
        vVar.c(0);
        a(vVar, (n) null, true);
        vVar.a((vVar.a() - iA) - 2, iA);
    }

    private byte[] a(boolean z) {
        v vVar = new v();
        a(vVar, z);
        return vVar.b();
    }

    public byte[] h() {
        v vVar = new v();
        a(vVar, (n) null, true);
        return vVar.b();
    }

    public String i() {
        return b();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.g);
        if (stringBuffer.length() < 8) {
            stringBuffer.append("\t");
        }
        if (stringBuffer.length() < 16) {
            stringBuffer.append("\t");
        }
        stringBuffer.append("\t");
        if (bk.b("BINDTTL")) {
            stringBuffer.append(cq.b(this.j));
        } else {
            stringBuffer.append(this.j);
        }
        stringBuffer.append("\t");
        if (this.i != 1 || !bk.b("noPrintIN")) {
            stringBuffer.append(p.b(this.i));
            stringBuffer.append("\t");
        }
        stringBuffer.append(ct.b(this.h));
        String strB = b();
        if (!strB.equals(BuildConfig.FLAVOR)) {
            stringBuffer.append("\t");
            stringBuffer.append(strB);
        }
        return stringBuffer.toString();
    }

    protected static String a(byte[] bArr, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        if (z) {
            stringBuffer.append('\"');
        }
        for (byte b2 : bArr) {
            int i = b2 & Constants.DimensionIds.NETHER;
            if (i < 32 || i >= 127) {
                stringBuffer.append('\\');
                stringBuffer.append(f5357a.format(i));
            } else if (i == 34 || i == 92) {
                stringBuffer.append('\\');
                stringBuffer.append((char) i);
            } else {
                stringBuffer.append((char) i);
            }
        }
        if (z) {
            stringBuffer.append('\"');
        }
        return stringBuffer.toString();
    }

    protected static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\\# ");
        stringBuffer.append(bArr.length);
        stringBuffer.append(" ");
        stringBuffer.append(org.xbill.DNS.a.a.a(bArr));
        return stringBuffer.toString();
    }

    public bg j() {
        return this.g;
    }

    public int k() {
        return this.h;
    }

    public int l() {
        if (this.h == 46) {
            return ((bp) this).d();
        }
        return this.h;
    }

    public int m() {
        return this.i;
    }

    public long n() {
        return this.j;
    }

    public boolean a(bt btVar) {
        return l() == btVar.l() && this.i == btVar.i && this.g.equals(btVar.g);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof bt)) {
            return false;
        }
        bt btVar = (bt) obj;
        if (this.h == btVar.h && this.i == btVar.i && this.g.equals(btVar.g)) {
            return Arrays.equals(h(), btVar.h());
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        for (byte b2 : a(true)) {
            i += (i << 3) + (b2 & Constants.DimensionIds.NETHER);
        }
        return i;
    }

    bt o() {
        try {
            return (bt) clone();
        } catch (CloneNotSupportedException unused) {
            throw new IllegalStateException();
        }
    }

    void a(long j) {
        this.j = j;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        bt btVar = (bt) obj;
        if (this == btVar) {
            return 0;
        }
        int iCompareTo = this.g.compareTo(btVar.g);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int i = this.i - btVar.i;
        if (i != 0) {
            return i;
        }
        int i2 = this.h - btVar.h;
        if (i2 != 0) {
            return i2;
        }
        byte[] bArrH = h();
        byte[] bArrH2 = btVar.h();
        for (int i3 = 0; i3 < bArrH.length && i3 < bArrH2.length; i3++) {
            int i4 = (bArrH[i3] & Constants.DimensionIds.NETHER) - (bArrH2[i3] & Constants.DimensionIds.NETHER);
            if (i4 != 0) {
                return i4;
            }
        }
        return bArrH.length - bArrH2.length;
    }

    static int a(String str, int i) {
        if (i >= 0 && i <= 65535) {
            return i;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\"");
        stringBuffer.append(str);
        stringBuffer.append("\" ");
        stringBuffer.append(i);
        stringBuffer.append(" must be an unsigned 16 bit value");
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    static long a(String str, long j) {
        if (j >= 0 && j <= 4294967295L) {
            return j;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\"");
        stringBuffer.append(str);
        stringBuffer.append("\" ");
        stringBuffer.append(j);
        stringBuffer.append(" must be an unsigned 32 bit value");
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    static bg a(String str, bg bgVar) {
        if (bgVar.a()) {
            return bgVar;
        }
        throw new RelativeNameException(bgVar);
    }
}
