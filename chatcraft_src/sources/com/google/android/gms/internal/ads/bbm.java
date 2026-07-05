package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* loaded from: classes.dex */
public final class bbm implements bap {
    private bbl d;
    private long j;
    private long k;
    private boolean l;
    private float e = 1.0f;
    private float f = 1.0f;

    /* renamed from: b, reason: collision with root package name */
    private int f2494b = -1;
    private int c = -1;
    private ByteBuffer g = f2458a;
    private ShortBuffer h = this.g.asShortBuffer();
    private ByteBuffer i = f2458a;

    @Override // com.google.android.gms.internal.ads.bap
    public final int c() {
        return 2;
    }

    public final float a(float f) {
        this.e = bkg.a(f, 0.1f, 8.0f);
        return this.e;
    }

    public final float b(float f) {
        this.f = bkg.a(f, 0.1f, 8.0f);
        return f;
    }

    public final long i() {
        return this.j;
    }

    public final long j() {
        return this.k;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final boolean a(int i, int i2, int i3) throws zzgj {
        if (i3 != 2) {
            throw new zzgj(i, i2, i3);
        }
        if (this.c == i && this.f2494b == i2) {
            return false;
        }
        this.c = i;
        this.f2494b = i2;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final boolean a() {
        return Math.abs(this.e - 1.0f) >= 0.01f || Math.abs(this.f - 1.0f) >= 0.01f;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final int b() {
        return this.f2494b;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.j += iRemaining;
            this.d.a(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
        int iB = (this.d.b() * this.f2494b) << 1;
        if (iB > 0) {
            if (this.g.capacity() < iB) {
                this.g = ByteBuffer.allocateDirect(iB).order(ByteOrder.nativeOrder());
                this.h = this.g.asShortBuffer();
            } else {
                this.g.clear();
                this.h.clear();
            }
            this.d.b(this.h);
            this.k += iB;
            this.g.limit(iB);
            this.i = this.g;
        }
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final void d() {
        this.d.a();
        this.l = true;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final ByteBuffer e() {
        ByteBuffer byteBuffer = this.i;
        this.i = f2458a;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final boolean f() {
        if (this.l) {
            return this.d == null || this.d.b() == 0;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final void g() {
        this.d = new bbl(this.c, this.f2494b);
        this.d.a(this.e);
        this.d.b(this.f);
        this.i = f2458a;
        this.j = 0L;
        this.k = 0L;
        this.l = false;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final void h() {
        this.d = null;
        this.g = f2458a;
        this.h = this.g.asShortBuffer();
        this.i = f2458a;
        this.f2494b = -1;
        this.c = -1;
        this.j = 0L;
        this.k = 0L;
        this.l = false;
    }
}
