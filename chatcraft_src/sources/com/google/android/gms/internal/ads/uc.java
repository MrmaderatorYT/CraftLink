package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public final class uc extends ByteArrayOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final jc f3486a;

    public uc(jc jcVar, int i) {
        this.f3486a = jcVar;
        this.buf = this.f3486a.a(Math.max(i, 256));
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f3486a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.f3486a.a(this.buf);
    }

    private final void a(int i) {
        if (this.count + i <= this.buf.length) {
            return;
        }
        byte[] bArrA = this.f3486a.a((this.count + i) << 1);
        System.arraycopy(this.buf, 0, bArrA, 0, this.count);
        this.f3486a.a(this.buf);
        this.buf = bArrA;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i) {
        a(1);
        super.write(i);
    }
}
