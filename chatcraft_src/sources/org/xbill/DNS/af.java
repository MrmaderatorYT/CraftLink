package org.xbill.DNS;

import java.util.Random;

/* compiled from: Header.java */
/* loaded from: classes.dex */
public class af implements Cloneable {
    private static Random d = new Random();

    /* renamed from: a, reason: collision with root package name */
    private int f5312a;

    /* renamed from: b, reason: collision with root package name */
    private int f5313b;
    private int[] c;

    private void g() {
        this.c = new int[4];
        this.f5313b = 0;
        this.f5312a = -1;
    }

    public af(int i) {
        g();
        c(i);
    }

    public af() {
        g();
    }

    af(t tVar) {
        this(tVar.h());
        this.f5313b = tVar.h();
        for (int i = 0; i < this.c.length; i++) {
            this.c[i] = tVar.h();
        }
    }

    void a(v vVar) {
        vVar.c(b());
        vVar.c(this.f5313b);
        for (int i = 0; i < this.c.length; i++) {
            vVar.c(this.c[i]);
        }
    }

    public byte[] a() {
        v vVar = new v();
        a(vVar);
        return vVar.b();
    }

    private static boolean i(int i) {
        return i >= 0 && i <= 15 && aa.b(i);
    }

    private static void j(int i) {
        if (i(i)) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("invalid flag bit ");
        stringBuffer.append(i);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    static int a(int i, int i2, boolean z) {
        j(i2);
        return z ? i | (1 << (15 - i2)) : i & ((1 << (15 - i2)) ^ (-1));
    }

    public void a(int i) {
        j(i);
        this.f5313b = a(this.f5313b, i, true);
    }

    public boolean b(int i) {
        j(i);
        return ((1 << (15 - i)) & this.f5313b) != 0;
    }

    public int b() {
        int i;
        if (this.f5312a >= 0) {
            return this.f5312a;
        }
        synchronized (this) {
            if (this.f5312a < 0) {
                this.f5312a = d.nextInt(65535);
            }
            i = this.f5312a;
        }
        return i;
    }

    public void c(int i) {
        if (i < 0 || i > 65535) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("DNS message ID ");
            stringBuffer.append(i);
            stringBuffer.append(" is out of range");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        this.f5312a = i;
    }

    public int c() {
        return this.f5313b & 15;
    }

    public void d(int i) {
        if (i < 0 || i > 15) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("DNS Opcode ");
            stringBuffer.append(i);
            stringBuffer.append("is out of range");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        this.f5313b &= 34815;
        this.f5313b = (i << 11) | this.f5313b;
    }

    public int d() {
        return (this.f5313b >> 11) & 15;
    }

    void e(int i) {
        if (this.c[i] == 65535) {
            throw new IllegalStateException("DNS section count cannot be incremented");
        }
        int[] iArr = this.c;
        iArr[i] = iArr[i] + 1;
    }

    void f(int i) {
        if (this.c[i] == 0) {
            throw new IllegalStateException("DNS section count cannot be decremented");
        }
        this.c[i] = r0[i] - 1;
    }

    public int g(int i) {
        return this.c[i];
    }

    int e() {
        return this.f5313b;
    }

    public String f() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            if (i(i) && b(i)) {
                stringBuffer.append(aa.a(i));
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    String h(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(";; ->>HEADER<<- ");
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("opcode: ");
        stringBuffer2.append(bj.a(d()));
        stringBuffer.append(stringBuffer2.toString());
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(", status: ");
        stringBuffer3.append(bs.a(i));
        stringBuffer.append(stringBuffer3.toString());
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append(", id: ");
        stringBuffer4.append(b());
        stringBuffer.append(stringBuffer4.toString());
        stringBuffer.append("\n");
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append(";; flags: ");
        stringBuffer5.append(f());
        stringBuffer.append(stringBuffer5.toString());
        stringBuffer.append("; ");
        for (int i2 = 0; i2 < 4; i2++) {
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append(cf.a(i2));
            stringBuffer6.append(": ");
            stringBuffer6.append(g(i2));
            stringBuffer6.append(" ");
            stringBuffer.append(stringBuffer6.toString());
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return h(c());
    }

    public Object clone() {
        af afVar = new af();
        afVar.f5312a = this.f5312a;
        afVar.f5313b = this.f5313b;
        System.arraycopy(this.c, 0, afVar.c, 0, this.c.length);
        return afVar;
    }
}
