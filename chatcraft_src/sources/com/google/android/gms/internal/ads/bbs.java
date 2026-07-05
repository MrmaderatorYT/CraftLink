package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class bbs extends bbn {

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f2503b;
    public long c;

    /* renamed from: a, reason: collision with root package name */
    public final bbo f2502a = new bbo();
    private final int d = 0;

    public bbs(int i) {
    }

    public final void d(int i) {
        if (this.f2503b == null) {
            this.f2503b = e(i);
            return;
        }
        int iCapacity = this.f2503b.capacity();
        int iPosition = this.f2503b.position();
        int i2 = i + iPosition;
        if (iCapacity >= i2) {
            return;
        }
        ByteBuffer byteBufferE = e(i2);
        if (iPosition > 0) {
            this.f2503b.position(0);
            this.f2503b.limit(iPosition);
            byteBufferE.put(this.f2503b);
        }
        this.f2503b = byteBufferE;
    }

    public final boolean e() {
        return c(1073741824);
    }

    @Override // com.google.android.gms.internal.ads.bbn
    public final void a() {
        super.a();
        if (this.f2503b != null) {
            this.f2503b.clear();
        }
    }

    private final ByteBuffer e(int i) {
        int iCapacity = this.f2503b == null ? 0 : this.f2503b.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(iCapacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }
}
