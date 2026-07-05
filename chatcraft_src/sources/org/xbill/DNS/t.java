package org.xbill.DNS;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.nio.ByteBuffer;

/* compiled from: DNSInput.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private ByteBuffer f5434a;

    /* renamed from: b, reason: collision with root package name */
    private int f5435b = -1;
    private int c = -1;

    public t(byte[] bArr) {
        this.f5434a = ByteBuffer.wrap(bArr);
    }

    public int a() {
        return this.f5434a.position();
    }

    public int b() {
        return this.f5434a.remaining();
    }

    private void e(int i) throws WireParseException {
        if (i > b()) {
            throw new WireParseException("end of input");
        }
    }

    public void a(int i) {
        if (i > this.f5434a.capacity() - this.f5434a.position()) {
            throw new IllegalArgumentException("cannot set active region past end of input");
        }
        this.f5434a.limit(this.f5434a.position() + i);
    }

    public void c() {
        this.f5434a.limit(this.f5434a.capacity());
    }

    public int d() {
        return this.f5434a.limit();
    }

    public void b(int i) {
        if (i > this.f5434a.capacity()) {
            throw new IllegalArgumentException("cannot set active region past end of input");
        }
        this.f5434a.limit(this.f5434a.position());
    }

    public void c(int i) {
        if (i >= this.f5434a.capacity()) {
            throw new IllegalArgumentException("cannot jump past end of input");
        }
        this.f5434a.position(i);
        this.f5434a.limit(this.f5434a.capacity());
    }

    public void e() {
        this.f5435b = this.f5434a.position();
        this.c = this.f5434a.limit();
    }

    public void f() {
        if (this.f5435b < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.f5434a.position(this.f5435b);
        this.f5434a.limit(this.c);
        this.f5435b = -1;
        this.c = -1;
    }

    public int g() throws WireParseException {
        e(1);
        return this.f5434a.get() & Constants.DimensionIds.NETHER;
    }

    public int h() throws WireParseException {
        e(2);
        return this.f5434a.getShort() & 65535;
    }

    public long i() throws WireParseException {
        e(4);
        return this.f5434a.getInt() & 4294967295L;
    }

    public void a(byte[] bArr, int i, int i2) throws WireParseException {
        e(i2);
        this.f5434a.get(bArr, i, i2);
    }

    public byte[] d(int i) throws WireParseException {
        e(i);
        byte[] bArr = new byte[i];
        this.f5434a.get(bArr, 0, i);
        return bArr;
    }

    public byte[] j() {
        int iB = b();
        byte[] bArr = new byte[iB];
        this.f5434a.get(bArr, 0, iB);
        return bArr;
    }

    public byte[] k() {
        return d(g());
    }
}
