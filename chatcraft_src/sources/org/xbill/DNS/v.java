package org.xbill.DNS;

/* compiled from: DNSOutput.java */
/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5436a;

    /* renamed from: b, reason: collision with root package name */
    private int f5437b;
    private int c;

    public v(int i) {
        this.f5436a = new byte[i];
        this.f5437b = 0;
        this.c = -1;
    }

    public v() {
        this(32);
    }

    public int a() {
        return this.f5437b;
    }

    private void a(long j, int i) {
        long j2 = 1 << i;
        if (j < 0 || j > j2) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(j);
            stringBuffer.append(" out of range for ");
            stringBuffer.append(i);
            stringBuffer.append(" bit value");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    private void d(int i) {
        if (this.f5436a.length - this.f5437b >= i) {
            return;
        }
        int length = this.f5436a.length * 2;
        if (length < this.f5437b + i) {
            length = this.f5437b + i;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(this.f5436a, 0, bArr, 0, this.f5437b);
        this.f5436a = bArr;
    }

    public void a(int i) {
        if (i > this.f5437b) {
            throw new IllegalArgumentException("cannot jump past end of data");
        }
        this.f5437b = i;
    }

    public void b(int i) {
        a(i, 8);
        d(1);
        byte[] bArr = this.f5436a;
        int i2 = this.f5437b;
        this.f5437b = i2 + 1;
        bArr[i2] = (byte) (i & 255);
    }

    public void c(int i) {
        a(i, 16);
        d(2);
        byte[] bArr = this.f5436a;
        int i2 = this.f5437b;
        this.f5437b = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        byte[] bArr2 = this.f5436a;
        int i3 = this.f5437b;
        this.f5437b = i3 + 1;
        bArr2[i3] = (byte) (i & 255);
    }

    public void a(int i, int i2) {
        a(i, 16);
        if (i2 > this.f5437b - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        this.f5436a[i2] = (byte) ((i >>> 8) & 255);
        this.f5436a[i2 + 1] = (byte) (i & 255);
    }

    public void a(long j) {
        a(j, 32);
        d(4);
        byte[] bArr = this.f5436a;
        int i = this.f5437b;
        this.f5437b = i + 1;
        bArr[i] = (byte) ((j >>> 24) & 255);
        byte[] bArr2 = this.f5436a;
        int i2 = this.f5437b;
        this.f5437b = i2 + 1;
        bArr2[i2] = (byte) ((j >>> 16) & 255);
        byte[] bArr3 = this.f5436a;
        int i3 = this.f5437b;
        this.f5437b = i3 + 1;
        bArr3[i3] = (byte) ((j >>> 8) & 255);
        byte[] bArr4 = this.f5436a;
        int i4 = this.f5437b;
        this.f5437b = i4 + 1;
        bArr4[i4] = (byte) (j & 255);
    }

    public void a(byte[] bArr, int i, int i2) {
        d(i2);
        System.arraycopy(bArr, i, this.f5436a, this.f5437b, i2);
        this.f5437b += i2;
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public void b(byte[] bArr) {
        if (bArr.length > 255) {
            throw new IllegalArgumentException("Invalid counted string");
        }
        d(bArr.length + 1);
        byte[] bArr2 = this.f5436a;
        int i = this.f5437b;
        this.f5437b = i + 1;
        bArr2[i] = (byte) (255 & bArr.length);
        a(bArr, 0, bArr.length);
    }

    public byte[] b() {
        byte[] bArr = new byte[this.f5437b];
        System.arraycopy(this.f5436a, 0, bArr, 0, this.f5437b);
        return bArr;
    }
}
