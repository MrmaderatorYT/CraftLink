package com.google.android.gms.internal.ads;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class bjc extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private final bja f2723a;

    /* renamed from: b, reason: collision with root package name */
    private final bjd f2724b;
    private long f;
    private boolean d = false;
    private boolean e = false;
    private final byte[] c = new byte[1];

    public bjc(bja bjaVar, bjd bjdVar) {
        this.f2723a = bjaVar;
        this.f2724b = bjdVar;
    }

    public final long a() {
        return this.f;
    }

    public final void b() {
        c();
    }

    @Override // java.io.InputStream
    public final int read() {
        if (read(this.c) == -1) {
            return -1;
        }
        return this.c[0] & Constants.DimensionIds.NETHER;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        bjq.b(!this.e);
        c();
        int iA = this.f2723a.a(bArr, i, i2);
        if (iA == -1) {
            return -1;
        }
        this.f += iA;
        return iA;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.e) {
            return;
        }
        this.f2723a.a();
        this.e = true;
    }

    private final void c() {
        if (this.d) {
            return;
        }
        this.f2723a.a(this.f2724b);
        this.d = true;
    }
}
