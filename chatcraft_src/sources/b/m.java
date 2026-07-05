package b;

import java.nio.ByteBuffer;

/* compiled from: RealBufferedSink.java */
/* loaded from: classes.dex */
final class m implements d {

    /* renamed from: a, reason: collision with root package name */
    public final c f1182a = new c();

    /* renamed from: b, reason: collision with root package name */
    public final r f1183b;
    boolean c;

    m(r rVar) {
        if (rVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.f1183b = rVar;
    }

    @Override // b.d, b.e
    public c c() {
        return this.f1182a;
    }

    @Override // b.r
    public void a_(c cVar, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f1182a.a_(cVar, j);
        v();
    }

    @Override // b.d
    public d b(String str) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f1182a.b(str);
        return v();
    }

    @Override // b.d
    public d c(byte[] bArr) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f1182a.c(bArr);
        return v();
    }

    @Override // b.d
    public d c(byte[] bArr, int i, int i2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f1182a.c(bArr, i, i2);
        return v();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f1182a.write(byteBuffer);
        v();
        return iWrite;
    }

    @Override // b.d
    public d i(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f1182a.i(i);
        return v();
    }

    @Override // b.d
    public d h(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f1182a.h(i);
        return v();
    }

    @Override // b.d
    public d g(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f1182a.g(i);
        return v();
    }

    @Override // b.d
    public d l(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f1182a.l(j);
        return v();
    }

    @Override // b.d
    public d k(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f1182a.k(j);
        return v();
    }

    @Override // b.d
    public d v() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long jG = this.f1182a.g();
        if (jG > 0) {
            this.f1183b.a_(this.f1182a, jG);
        }
        return this;
    }

    @Override // b.d, b.r, java.io.Flushable
    public void flush() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.f1182a.f1165b > 0) {
            this.f1183b.a_(this.f1182a, this.f1182a.f1165b);
        }
        this.f1183b.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // b.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.c) {
            return;
        }
        Throwable th = null;
        try {
            if (this.f1182a.f1165b > 0) {
                this.f1183b.a_(this.f1182a, this.f1182a.f1165b);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f1183b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.c = true;
        if (th != null) {
            u.a(th);
        }
    }

    @Override // b.r
    public t a() {
        return this.f1183b.a();
    }

    public String toString() {
        return "buffer(" + this.f1183b + ")";
    }
}
