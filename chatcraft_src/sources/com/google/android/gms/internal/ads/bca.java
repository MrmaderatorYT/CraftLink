package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class bca implements bce {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f2511a = new byte[4096];

    /* renamed from: b, reason: collision with root package name */
    private final bja f2512b;
    private final long c;
    private long d;
    private byte[] e = new byte[65536];
    private int f;
    private int g;

    public bca(bja bjaVar, long j, long j2) {
        this.f2512b = bjaVar;
        this.d = j;
        this.c = j2;
    }

    @Override // com.google.android.gms.internal.ads.bce
    public final int a(byte[] bArr, int i, int i2) throws InterruptedException, EOFException {
        int iD = d(bArr, i, i2);
        if (iD == 0) {
            iD = a(bArr, i, i2, 0, true);
        }
        f(iD);
        return iD;
    }

    @Override // com.google.android.gms.internal.ads.bce
    public final boolean a(byte[] bArr, int i, int i2, boolean z) throws InterruptedException, EOFException {
        int iD = d(bArr, i, i2);
        while (iD < i2 && iD != -1) {
            iD = a(bArr, i, i2, iD, z);
        }
        f(iD);
        return iD != -1;
    }

    @Override // com.google.android.gms.internal.ads.bce
    public final void b(byte[] bArr, int i, int i2) throws InterruptedException, EOFException {
        a(bArr, i, i2, false);
    }

    @Override // com.google.android.gms.internal.ads.bce
    public final int a(int i) throws InterruptedException, EOFException {
        int iD = d(i);
        if (iD == 0) {
            iD = a(f2511a, 0, Math.min(i, f2511a.length), 0, true);
        }
        f(iD);
        return iD;
    }

    @Override // com.google.android.gms.internal.ads.bce
    public final void b(int i) throws InterruptedException, EOFException {
        int iD = d(i);
        while (iD < i && iD != -1) {
            iD = a(f2511a, -iD, Math.min(i, f2511a.length + iD), iD, false);
        }
        f(iD);
    }

    @Override // com.google.android.gms.internal.ads.bce
    public final void c(byte[] bArr, int i, int i2) {
        if (a(i2, false)) {
            System.arraycopy(this.e, this.f - i2, bArr, i, i2);
        }
    }

    private final boolean a(int i, boolean z) throws InterruptedException, EOFException {
        int i2 = this.f + i;
        if (i2 > this.e.length) {
            this.e = Arrays.copyOf(this.e, bkg.a(this.e.length << 1, 65536 + i2, i2 + 524288));
        }
        int iMin = Math.min(this.g - this.f, i);
        while (iMin < i) {
            iMin = a(this.e, this.f, i, iMin, false);
            if (iMin == -1) {
                return false;
            }
        }
        this.f += i;
        this.g = Math.max(this.g, this.f);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.bce
    public final void c(int i) throws InterruptedException, EOFException {
        a(i, false);
    }

    @Override // com.google.android.gms.internal.ads.bce
    public final void a() {
        this.f = 0;
    }

    @Override // com.google.android.gms.internal.ads.bce
    public final long b() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.bce
    public final long c() {
        return this.c;
    }

    private final int d(int i) {
        int iMin = Math.min(this.g, i);
        e(iMin);
        return iMin;
    }

    private final int d(byte[] bArr, int i, int i2) {
        if (this.g == 0) {
            return 0;
        }
        int iMin = Math.min(this.g, i2);
        System.arraycopy(this.e, 0, bArr, i, iMin);
        e(iMin);
        return iMin;
    }

    private final void e(int i) {
        this.g -= i;
        this.f = 0;
        byte[] bArr = this.e;
        if (this.g < this.e.length - 524288) {
            bArr = new byte[this.g + 65536];
        }
        System.arraycopy(this.e, i, bArr, 0, this.g);
        this.e = bArr;
    }

    private final int a(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, EOFException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int iA = this.f2512b.a(bArr, i + i3, i2 - i3);
        if (iA != -1) {
            return i3 + iA;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private final void f(int i) {
        if (i != -1) {
            this.d += i;
        }
    }
}
