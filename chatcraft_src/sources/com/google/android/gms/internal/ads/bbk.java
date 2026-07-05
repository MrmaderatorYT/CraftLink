package com.google.android.gms.internal.ads;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
final class bbk implements bap {

    /* renamed from: b, reason: collision with root package name */
    private int f2491b = -1;
    private int c = -1;
    private int d = 0;
    private ByteBuffer e = f2458a;
    private ByteBuffer f = f2458a;
    private boolean g;

    @Override // com.google.android.gms.internal.ads.bap
    public final int c() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final boolean a(int i, int i2, int i3) throws zzgj {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new zzgj(i, i2, i3);
        }
        if (this.f2491b == i && this.c == i2 && this.d == i3) {
            return false;
        }
        this.f2491b = i;
        this.c = i2;
        this.d = i3;
        if (i3 != 2) {
            return true;
        }
        this.e = f2458a;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final boolean a() {
        return (this.d == 0 || this.d == 2) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final int b() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final void a(ByteBuffer byteBuffer) {
        int i;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i2 = iLimit - iPosition;
        int i3 = this.d;
        if (i3 == Integer.MIN_VALUE) {
            i = (i2 / 3) << 1;
        } else if (i3 == 3) {
            i = i2 << 1;
        } else if (i3 == 1073741824) {
            i = i2 / 2;
        } else {
            throw new IllegalStateException();
        }
        if (this.e.capacity() < i) {
            this.e = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.e.clear();
        }
        int i4 = this.d;
        if (i4 == Integer.MIN_VALUE) {
            while (iPosition < iLimit) {
                this.e.put(byteBuffer.get(iPosition + 1));
                this.e.put(byteBuffer.get(iPosition + 2));
                iPosition += 3;
            }
        } else if (i4 == 3) {
            while (iPosition < iLimit) {
                this.e.put((byte) 0);
                this.e.put((byte) ((byteBuffer.get(iPosition) & Constants.DimensionIds.NETHER) - 128));
                iPosition++;
            }
        } else {
            if (i4 != 1073741824) {
                throw new IllegalStateException();
            }
            while (iPosition < iLimit) {
                this.e.put(byteBuffer.get(iPosition + 2));
                this.e.put(byteBuffer.get(iPosition + 3));
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.e.flip();
        this.f = this.e;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final void d() {
        this.g = true;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final ByteBuffer e() {
        ByteBuffer byteBuffer = this.f;
        this.f = f2458a;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final boolean f() {
        return this.g && this.f == f2458a;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final void g() {
        this.f = f2458a;
        this.g = false;
    }

    @Override // com.google.android.gms.internal.ads.bap
    public final void h() {
        g();
        this.e = f2458a;
        this.f2491b = -1;
        this.c = -1;
        this.d = 0;
    }
}
