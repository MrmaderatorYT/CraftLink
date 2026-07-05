package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes.dex */
final class bbf implements bap {
    private int[] d;
    private boolean e;
    private int[] f;
    private boolean i;
    private ByteBuffer g = f2458a;
    private ByteBuffer h = f2458a;

    /* renamed from: b, reason: collision with root package name */
    private int f2486b = -1;
    private int c = -1;

    @Override // com.google.android.gms.internal.ads.bap
    public final int c() {
        return 2;
    }

    public final void a(int[] iArr) {
        this.d = iArr;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final boolean a(int i, int i2, int i3) throws zzgj {
        boolean z = !Arrays.equals(this.d, this.f);
        this.f = this.d;
        if (this.f == null) {
            this.e = false;
            return z;
        }
        if (i3 != 2) {
            throw new zzgj(i, i2, i3);
        }
        if (!z && this.c == i && this.f2486b == i2) {
            return false;
        }
        this.c = i;
        this.f2486b = i2;
        this.e = i2 != this.f.length;
        int i4 = 0;
        while (i4 < this.f.length) {
            int i5 = this.f[i4];
            if (i5 >= i2) {
                throw new zzgj(i, i2, i3);
            }
            this.e = (i5 != i4) | this.e;
            i4++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final boolean a() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final int b() {
        return this.f == null ? this.f2486b : this.f.length;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final void a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int length = (((iLimit - iPosition) / (this.f2486b * 2)) * this.f.length) << 1;
        if (this.g.capacity() < length) {
            this.g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.g.clear();
        }
        while (iPosition < iLimit) {
            for (int i : this.f) {
                this.g.putShort(byteBuffer.getShort((i * 2) + iPosition));
            }
            iPosition += this.f2486b << 1;
        }
        byteBuffer.position(iLimit);
        this.g.flip();
        this.h = this.g;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final void d() {
        this.i = true;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final ByteBuffer e() {
        ByteBuffer byteBuffer = this.h;
        this.h = f2458a;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final boolean f() {
        return this.i && this.h == f2458a;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final void g() {
        this.h = f2458a;
        this.i = false;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final void h() {
        g();
        this.g = f2458a;
        this.f2486b = -1;
        this.c = -1;
        this.f = null;
        this.e = false;
    }
}
