package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MarkableInputStream.java */
/* loaded from: classes.dex */
final class n extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f4136a;

    /* renamed from: b, reason: collision with root package name */
    private long f4137b;
    private long c;
    private long d;
    private long e;
    private boolean f;
    private int g;

    n(InputStream inputStream) {
        this(inputStream, 4096);
    }

    n(InputStream inputStream, int i) {
        this(inputStream, i, 1024);
    }

    private n(InputStream inputStream, int i, int i2) {
        this.e = -1L;
        this.f = true;
        this.g = -1;
        this.f4136a = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, i);
        this.g = i2;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.e = a(i);
    }

    public long a(int i) throws IOException {
        long j = this.f4137b + i;
        if (this.d < j) {
            b(j);
        }
        return this.f4137b;
    }

    public void a(boolean z) {
        this.f = z;
    }

    private void b(long j) throws IOException {
        try {
            if (this.c < this.f4137b && this.f4137b <= this.d) {
                this.f4136a.reset();
                this.f4136a.mark((int) (j - this.c));
                a(this.c, this.f4137b);
            } else {
                this.c = this.f4137b;
                this.f4136a.mark((int) (j - this.f4137b));
            }
            this.d = j;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        a(this.e);
    }

    public void a(long j) throws IOException {
        if (this.f4137b > this.d || j < this.c) {
            throw new IOException("Cannot reset");
        }
        this.f4136a.reset();
        a(this.c, j);
        this.f4137b = j;
    }

    private void a(long j, long j2) throws IOException {
        while (j < j2) {
            long jSkip = this.f4136a.skip(j2 - j);
            if (jSkip == 0) {
                if (read() == -1) {
                    return;
                } else {
                    jSkip = 1;
                }
            }
            j += jSkip;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.f && this.f4137b + 1 > this.d) {
            b(this.d + this.g);
        }
        int i = this.f4136a.read();
        if (i != -1) {
            this.f4137b++;
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (!this.f && this.f4137b + bArr.length > this.d) {
            b(this.f4137b + bArr.length + this.g);
        }
        int i = this.f4136a.read(bArr);
        if (i != -1) {
            this.f4137b += i;
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f) {
            long j = i2;
            if (this.f4137b + j > this.d) {
                b(this.f4137b + j + this.g);
            }
        }
        int i3 = this.f4136a.read(bArr, i, i2);
        if (i3 != -1) {
            this.f4137b += i3;
        }
        return i3;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (!this.f && this.f4137b + j > this.d) {
            b(this.f4137b + j + this.g);
        }
        long jSkip = this.f4136a.skip(j);
        this.f4137b += jSkip;
        return jSkip;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f4136a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4136a.close();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f4136a.markSupported();
    }
}
