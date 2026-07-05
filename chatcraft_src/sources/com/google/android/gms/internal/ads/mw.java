package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
final class mw extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private final long f3281a;

    /* renamed from: b, reason: collision with root package name */
    private long f3282b;

    mw(InputStream inputStream, long j) {
        super(inputStream);
        this.f3281a = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i = super.read();
        if (i != -1) {
            this.f3282b++;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = super.read(bArr, i, i2);
        if (i3 != -1) {
            this.f3282b += i3;
        }
        return i3;
    }

    final long a() {
        return this.f3281a - this.f3282b;
    }
}
